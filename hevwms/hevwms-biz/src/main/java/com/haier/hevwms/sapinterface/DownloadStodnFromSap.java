package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.List;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.log4j.Logger;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.StgStodnDownDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: DownloadStoDnFromSap.java
 * @description: STO-DN依赖于STO，当STO订单产生之后，SAP会产生STO-DN订单，
 * 		wms主动定时或者实时获取，获取之后存入STG_STODN_DOWN					
 *  	Transfer the DN information to WMS system  Interface. 
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月9日 下午2:03:21
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月9日		LJZ			v1.0.0			create
 */

public class DownloadStodnFromSap {
	private String rfc_id = "ZMM_HEV_INT_DN_TO_WMS";
	private String system_id = "HEVWMS";
	private String stoNo;
	private String stoDnNo;
	private String message ;
	private String userName;
	Logger logger = Logger.getLogger(DownloadStodnFromSap.class);
	private StgStodnDownDAO stgStodnDownDAO;
	private OperationLogDAO operationLogDAO;
	
	public DownloadStodnFromSap(String stoNo, String stoDnNo, String userName) {
		this.stoNo = stoNo;
		this.stoDnNo = stoDnNo;
		this.userName = userName;
		stgStodnDownDAO = SpringApplicationContextHolder.getBean("stgStodnDownDAO");
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
	}
	
	public InterfaceOutDTO exchangeWithSap() {
		logger.info("Exchange with SAP start------------------------");
		// 构建返回值对象
		InterfaceOutDTO result = new InterfaceOutDTO();
		result.setStatus("S");
		result.setMsg("Download success!");

		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("DownloadStoDnFromSap");

		StgStodnDownDTO stgStoDnDownDTO = new StgStodnDownDTO();
		stgStoDnDownDTO.setStodnNo(stoDnNo);
		Long count = stgStodnDownDAO.searchStgStodnDownsCount(stgStoDnDownDTO);
		if (count > 0) {
			log.setDescription("Order already exists! Order no:"+stoDnNo);
			operationLogDAO.save(log);
		}
		try {
			SapConnection.initSapConn();
		} catch (Exception ex) {
			result.setStatus("E");
			result.setMsg("SAP connection failed!");
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			logger.info(ex);
			return result;
		}
		logger.info("SAP connection successfully");

		JCoTable table;
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);
			
			JCoTable inTable = function.getTableParameterList().getTable("IT_PO_INPUT");
			inTable.clear();
			inTable.appendRow();
			
			inTable.setValue("VGBEL", stoNo);
			inTable.setValue("VBELN", stoDnNo);
			
			logger.info("\n"+function.getTableParameterList());

			function.execute(destination);
			table = function.getTableParameterList().getTable("IT_PO_OUTPUT");
		} catch (JCoException e) {
			message = e.getMessage();
			logger.error("Catch Exception when download STODN: " + e.getMessage());
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);

			result.setStatus("E");
			result.setMsg("SAP function execute failed!");
			return result;
		}

		if (table == null || table.getNumRows() == 0) {
			log.setDescription("No data is downloaded!");

			result.setStatus("E");
			result.setMsg("No data is downloaded!");
			operationLogDAO.save(log);
		} else {
			for (int i = 0; i < table.getNumRows(); i++) {
				table.setRow(i);
				String grPlant = table.getString("WERKS_R");
				// 对订单进行过滤，只下载65C1工厂的订单
				if ("65C1".equalsIgnoreCase(grPlant)) {
					String stodnNo = table.getString("VBELN");
					String stodnItemNo = table.getString("POSNR");
					StgStodnDownDTO dto = new StgStodnDownDTO();
					dto.setStoNo(table.getString("VGBEL"));
					dto.setStoItemNo(table.getString("VGPOS"));
					dto.setMaterialNo(table.getString("MATNR"));
					dto.setStodnNo(stodnNo);
					dto.setStodnItemNo(stodnItemNo);
					String qty = table.getString("LFIMG");
					if("".equals(qty) || null == qty){
						qty = "0";
					}
					dto.setQty(Double.valueOf(qty).longValue());
					dto.setUnit(table.getString("MEINS"));
					// dto.setGrPlant(table.getString("WERKS"));
					dto.setGrPlant(table.getString("WERKS_R"));
					dto.setGrLocation(table.getString("LGORT"));
					dto.setGrFinishFlag("0");
					dto.setGrFinishQty(0L);
					dto.setGrSapFlag("0");
					dto.setStoType(table.getString("BSART"));

					StgStodnDownDTO temp = new StgStodnDownDTO();
					temp.setStodnNo(stodnNo);
					temp.setStodnItemNo(stodnItemNo);
					List<StgStodnDownDTO> dnList = stgStodnDownDAO.getStgStodnDownListByParm(temp);
					if (dnList == null || dnList.size() == 0){
						dto.setCreateBy(userName);
						dto.setCreateDate(new Date());
						stgStodnDownDAO.save(dto);
					} else {
						Integer ifStart = stgStodnDownDAO.ifStartScan(stodnNo, stodnItemNo);
						if (ifStart == 0){
							dto.setModifyBy(userName);
							dto.setModifyDate(new Date());
							stgStodnDownDAO.updateStodnDown(dto);
						}
					}
				}
			}
		}

		return result;
	}
	
}
