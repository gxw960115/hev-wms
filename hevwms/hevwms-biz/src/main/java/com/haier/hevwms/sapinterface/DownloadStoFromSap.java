package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.sap.conn.jco.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.Map.Entry;


/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: DownloadStoFromSap.java
 * @description: 调拨单下载，WMS主动从SAP获取调拨单（STO），接口定时和实时间调用，
 *  	获取到的sto订单在wms存入到的STG_STO_DOWN中
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月9日 下午2:02:39
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月9日		LJZ			v1.0.0			create
 */

public class DownloadStoFromSap {
	private String rfc_id = "ZMM_HEV_INT_SAP_TO_WMS_STOINFO"; // RFC函数名
//	private String system_id = "HEVWMS";
	private String beginTime;
	private String endTime;
	private String grPlant; // 收货工厂
	private String stoNo; // 调拨单号
	private String purOrg; // 采购组织
	private String userName;
	private String message;
	private StgStoDownDAO stgStoDownDAO;
	private OperationLogDAO operationLogDAO;

	Logger logger = Logger.getLogger(DownloadStoFromSap.class);

	public DownloadStoFromSap(String beginTime,
							  String endTime,
							  String grPlant,
							  String stoNo,
							  String purOrg,
							  StgStoDownDAO stgStoDownDAO,
							  OperationLogDAO operationLogDAO) {
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.grPlant = grPlant;
		this.stoNo = stoNo;
		this.purOrg = purOrg;
		this.stgStoDownDAO = stgStoDownDAO;
		this.operationLogDAO = operationLogDAO;
	}

	public DownloadStoFromSap(String beginTime, String endTime, String grPlant, String stoNo, String purOrg, String userName) {
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.stoNo = stoNo;
		this.grPlant = grPlant;
		this.purOrg = purOrg;
		this.userName = userName;
		stgStoDownDAO = SpringApplicationContextHolder.getBean("stgStoDownDAO");
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
	}

	public InterfaceOutDTO exchangeWithSap() {
		logger.info("Exchange with SAP start------------------------");
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("DownloadStoFromSap");
		// 返回结果对象
		InterfaceOutDTO result = new InterfaceOutDTO();
		result.setStatus("S");
		result.setMsg("Download success!");
		try {
			SapConnection.initSapConn();
		} catch (Exception ex) {
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			logger.info(ex);
			result.setStatus("E");
			result.setMsg("SAP connection failed!");
			return result;
		}
		logger.info("SAP connection successfully");
		JCoFunction function;
		JCoDestination destination;
		try {
			destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			function = destination.getRepository().getFunction(rfc_id);
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Catch Exception when download STO: " + e.getMessage());
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			result.setStatus("E");
			result.setMsg("SAP Function does not exist!");
			return result;
		}
		// 输入日期参数
		if (beginTime != null) {
			if (endTime != null) {
				if (beginTime.equals(endTime)) {
					function.getImportParameterList().setValue("DATE_BEGIN", beginTime);
				} else {
					function.getImportParameterList().setValue("DATE_BEGIN", beginTime);
					function.getImportParameterList().setValue("DATE_END", endTime);
				}
			} else {
				function.getImportParameterList().setValue("DATE_BEGIN", beginTime);
			}
		}
		// 收货工厂
		function.getImportParameterList().setValue("GR_PLANT", "65C1");
		// 采购组织
		function.getImportParameterList().setValue("PUR_ORG", "65C0");
		if (stoNo != null && !"".equals(stoNo)) {
			function.getImportParameterList().setValue("STO_NO", stoNo);
		}

		logger.info(function.getImportParameterList());
		try {
			function.execute(destination);
		} catch (JCoException e) {
			e.printStackTrace();
			result.setStatus("E");
			result.setMsg("SAP Function execute failed!");
			return result;
		}
		JCoTable table = function.getTableParameterList().getTable("OUTITAB");

		if (table == null || table.getNumRows() == 0) {
			if (stoNo != null && !"".equals(stoNo) && stoNo.length() > 0) {
				StgStoDownDTO stoDTO = new StgStoDownDTO();
				stoDTO.setStoNo(stoNo);
				List<StgStoDownDTO> stoDownList = stgStoDownDAO.getListByParam(stoDTO);
				if (stoDownList != null && stoDownList.size() > 0) {
					for (int i = 0; i < stoDownList.size(); i++) {
						StgStoDownDTO checkDTO = stoDownList.get(i);
						Long ifStart = stgStoDownDAO.ifScanningStart(checkDTO);
						if (ifStart == 0) {
							stgStoDownDAO.bankupDeletedItems(checkDTO);
							stgStoDownDAO.deleteByStoItems(checkDTO);
						}
					}
				}
			}
			log.setDescription("No data is downloaded!");
			operationLogDAO.save(log);
			result.setStatus("E");
			result.setMsg("No data is downloaded!");
		}else {
			Map<String, Set<String>> newOrder = new HashMap<String, Set<String>>();
			Map<String, Set<String>> oldOrder = new HashMap<String, Set<String>>();
			for (int i = 0; i < table.getNumRows(); i++) {
				table.setRow(i);
				Set<String> newItem = new HashSet<String>();
				if(newOrder.get(table.getString("STO_NO".toUpperCase()))==null) {
					newItem.add(table.getString("STO_ITEM".toUpperCase()));
					newOrder.put(table.getString("STO_NO".toUpperCase()), newItem);
				} else {
					newItem = newOrder.get(table.getString("STO_NO".toUpperCase()));
					newItem.add(table.getString("STO_ITEM".toUpperCase()));
				}

				if (oldOrder.get(table.getString("STO_NO".toUpperCase()))==null) {
					StgStoDownDTO oldTemp = new StgStoDownDTO();
					oldTemp.setStoNo(table.getString("STO_NO".toUpperCase()));
					List<String> oldPoItems = stgStoDownDAO.getStoItemsByStoNo(oldTemp);
					Set<String> oldItem = new HashSet<String>(oldPoItems);
					oldOrder.put(table.getString("STO_NO".toUpperCase()), oldItem);
				}
			}

			Set<Entry<String, Set<String>>> entrySet = oldOrder.entrySet();
			for (Entry<String, Set<String>> oldPo:entrySet) {
				Set<String> oldItems = oldPo.getValue();
				Set<String> newItems = newOrder.get(oldPo.getKey());
				for (String exsitedItem:oldItems) {
					boolean deleteFlag = false;
					for (String checkItem:newItems) {
						if(checkItem.equals(exsitedItem)) {
							deleteFlag = true;
							break;
						}
					}
					if (!deleteFlag) {
						StgStoDownDTO checkTemp = new StgStoDownDTO();
						checkTemp.setStoNo(oldPo.getKey());
						checkTemp.setStoItemNo(exsitedItem);
						Long ifStart = stgStoDownDAO.ifScanningStart(checkTemp);
						if (ifStart == 0) {
							stgStoDownDAO.bankupDeletedItems(checkTemp);
							stgStoDownDAO.deleteByStoItems(checkTemp);
						}
					}

				}
			}
			for (int j = 0; j < table.getNumRows(); j++) {
				table.setRow(j);
				String grPlant = table.getString("GR_PLANT");
				String giPlant = table.getString("GI_PLANT");
				// 对下载的订单进行过滤，如果工厂不是65C1则不下载
				if ("65C1".equalsIgnoreCase(grPlant) || "65C1".equalsIgnoreCase(giPlant)) {
					StgStoDownDTO sto = new StgStoDownDTO();
					sto.setStoNo(table.getString("STO_NO"));
					sto.setGrPlant(table.getString("GR_PLANT"));
					sto.setGiPlant(table.getString("GI_PLANT"));
					sto.setStoDocDate(table.getString("STO_CDATE"));
					sto.setStoLastModifyDate(table.getString("STO_EDATE"));
					sto.setStoCreateBy(table.getString("STO_CREATER"));
					sto.setStoItemNo(table.getString("STO_ITEM"));
					sto.setMaterialNo(table.getString("MATERIAL_NO"));
					sto.setStoType(table.getString("BSART"));

					String materialDesp = table.getString("MATERIAL_DESP".toUpperCase());
					if (!"".equals(materialDesp) && materialDesp != null) {
						materialDesp = CommonTool.replace(materialDesp, "'", " ");
						materialDesp = CommonTool.replace(materialDesp, "\"", "");
					}
					sto.setMaterialDesp(materialDesp);
					String qty = table.getString("QTY");
					if(qty == null || qty.equals("")){
						qty = "0";
					}
					sto.setQty(Double.valueOf(qty).longValue());
					sto.setGiFinishQty(0L);
					sto.setGiFinishFlag("0");
					sto.setGrFinishQty(0L);
					sto.setGrFinishFlag("0");
					sto.setUnit(table.getString("UNIT"));
					sto.setGrLocation(table.getString("GR_LGORT"));
					sto.setGrDate(table.getString("GR_DATE"));
					sto.setGiLocation(table.getString("GI_LGORT"));
					sto.setGiDate(table.getString("GI_DATE"));
					String itemDeltet = table.getString("ITEM_DELTET");
					if (itemDeltet == null || "".equals(itemDeltet)) {
						itemDeltet = "0";
					}
					sto.setItemDeltet(itemDeltet);
					// STO_CLOSE 空对应0 其余对应1
					String stoClose = table.getString("STO_CLOSE");
					if (stoClose == null || "".equals(stoClose)) {
						stoClose = "0";
					}
					sto.setStoClose(stoClose);
					sto.setComeFromTms("SAP");

					List<StgStoDownDTO> stoList = stgStoDownDAO.getExistingStoItem(sto);
					if (stoList == null || stoList.size() == 0) {
						sto.setCreateBy(userName);
						sto.setCreateDate(new Date());
						stgStoDownDAO.save(sto);
					} else {
						Long ifStart = stgStoDownDAO.ifScanningStart(sto);
						if (ifStart == 0) {
							sto.setModifyBy(userName);
							sto.setModifyDate(new Date());
							stgStoDownDAO.updateByStoItem(sto);
						}
					}
				}
			}

		}

		logger.info("Download Sto Finish!");
		return result;
	}
}
