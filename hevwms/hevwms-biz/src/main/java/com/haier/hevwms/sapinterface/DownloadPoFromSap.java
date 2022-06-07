package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.security.dto.OperationLogDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

public class DownloadPoFromSap {
	 
	String rfc_id = "ZMM_AEV_INT_PURCHASEOD"; // RFC函数名
	String system_id = "HEVWMS"; 
	String beginTime;
	String endTime; 
	String poNo; 
	String userName;
	private StgPoDownDAO stgPoDownDAO;
	private OperationLogDAO operationLogDAO;
//	private UserDAO userDAO;;
	
	Logger logger = Logger.getLogger(DownloadPoFromSap.class);
	
	public DownloadPoFromSap(String poNo, String beginTime, String endTime, String userName){
		this.poNo = poNo;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.userName = userName;
		stgPoDownDAO = SpringApplicationContextHolder.getBean("stgPoDownDAO");
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
//		userDAO = SpringApplicationContextHolder.getBean("userDAO");
	}
	
	public String exchangeWithSap() {
		logger.info("Exchange with sap start------------------------");
		String result = "S";
		String message ;
		OperationLogDTO log = new OperationLogDTO();
//		UserDTO user = userDAO.getUserByName(userName);
//		log.setUserId(user.getId());
		log.setUserName(userName);
		log.setAppName("DownloadPoFromSap");

		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			result = "E";
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			logger.info(ex);
		}
		
		try{
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);

			// 输入日期参数
			if (beginTime != null && !"".equals(beginTime)) {
				if (endTime != null && !"".equals(endTime)) {
					if (beginTime.equals(endTime)) {
						function.getImportParameterList().setValue("AEDAT_B", beginTime);
					} else {
						function.getImportParameterList().setValue("AEDAT_B", beginTime);
						function.getImportParameterList().setValue("AEDAT_E", endTime);
					}
				} else {
					function.getImportParameterList().setValue("AEDAT_B", beginTime);
				}
			}  
			
			// 输入采购组织
			function.getImportParameterList().setValue("BUKRS_B", "65C0");
			
			// 输入凭证参数
			if (poNo != null && !"".equals(poNo)) {
				function.getImportParameterList().setValue("EBELN_B", poNo);
			}
			logger.info("INPUT Parameters=========>" + function.getImportParameterList());	
			function.execute(destination);
			
			JCoTable codes = function.getTableParameterList().getTable("OUTPUT");
			logger.info("OUTPUT Table=========>" + codes);
			
			
			if (codes != null && codes.getNumRows() > 0) {
				//PO No: EBELN    PO item No: EBELP
				Map<String, Set<String>> newOrder = new HashMap<String, Set<String>>();
				Map<String, Set<String>> oldOrder = new HashMap<String, Set<String>>();
				for (int i = 0; i < codes.getNumRows(); i++){
					codes.setRow(i);
					Set<String> newItem = new HashSet<String>();
					if(newOrder.get(codes.getString("EBELN".toUpperCase()))==null){
						newItem.add(codes.getString("EBELP".toUpperCase()));
						newOrder.put(codes.getString("EBELN".toUpperCase()), newItem);
					} else {
						newItem = newOrder.get(codes.getString("EBELN".toUpperCase()));
						newItem.add(codes.getString("EBELP".toUpperCase()));
					}
					
					if (oldOrder.get(codes.getString("EBELN".toUpperCase()))==null){
						StgPoDownDTO oldTemp = new StgPoDownDTO();
						oldTemp.setPoNo(codes.getString("EBELN".toUpperCase()));
						List<String> oldPoItems = stgPoDownDAO.getPoItemsByPoNo(oldTemp);
						Set<String> oldItem = new HashSet<String>(oldPoItems);
						oldOrder.put(codes.getString("EBELN".toUpperCase()), oldItem);
					}
				}
				
				Set<Entry<String, Set<String>>> entrySet = oldOrder.entrySet();
				for (Entry<String, Set<String>> oldPo:entrySet){
					Set<String> oldItems = oldPo.getValue();
					Set<String> newItems = newOrder.get(oldPo.getKey());
					for (String exsitedItem:oldItems){
						boolean deleteFlag = false;
						for (String checkItem:newItems){
							if(checkItem.equals(exsitedItem)){
								deleteFlag = true;
								break;
							}
						}
						if (!deleteFlag){
							StgPoDownDTO checkTemp = new StgPoDownDTO();
							checkTemp.setPoNo(oldPo.getKey());
							checkTemp.setPoItemNo(exsitedItem);
							Long ifStart = stgPoDownDAO.ifScanningStart(checkTemp);
							if (ifStart == 0){
								stgPoDownDAO.bankupDeletedItems(checkTemp);
								stgPoDownDAO.deleteByPoItems(checkTemp);
							}
						}
						
					}
				}
				for (int j = 0; j < codes.getNumRows(); j++) {
					codes.setRow(j);
					// 对下载的数据进行过滤，如果工厂不是65C1，则不下载
					String plant = codes.getString("WERKS".toUpperCase());
					if("65C1".equalsIgnoreCase(plant)) {
						StgPoDownDTO po = new StgPoDownDTO();
						po.setPoNo(codes.getString("EBELN".toUpperCase()));
						po.setPoItemNo(codes.getString("EBELP".toUpperCase()));
						po.setPoType(codes.getString("BSART".toUpperCase()));
						po.setPlant(codes.getString("WERKS".toUpperCase()));
						po.setPoLocation(codes.getString("LGORT".toUpperCase()));
						po.setMaterialNo(codes.getString("MATNR".toUpperCase()));

						String qty = codes.getString("MENGE1".toUpperCase());
						if ("".equals(qty) || qty == null) {
							qty = "0";
						}
						po.setQty(Double.valueOf(qty).longValue());
						po.setUnit(codes.getString("MEINS1".toUpperCase()));  //基本单位
						po.setFinishQty(0L);
						po.setFinishFlag("0");
						String materialDesp = codes.getString("TXZ01".toUpperCase());
						if (!"".equals(materialDesp) && materialDesp != null) {
							materialDesp = CommonTool.replace(materialDesp, "'", " ");
							materialDesp = CommonTool.replace(materialDesp, "\"", "");
						}
						po.setMaterialDesp(materialDesp);
//					po.setPoClose(codes.getString("ELIKZ".toUpperCase()));  //X-不能继续收货. 空-可以继续收货
						String poClose = codes.getString("ELIKZ".toUpperCase()); // 订单状态
						if("".equals(poClose) ||poClose == null){
							poClose = "0";
						}
						po.setPoClose(poClose);
//					po.setItemDeltet(codes.getString("LOEKZ".toUpperCase()));
						String itemDelete = codes.getString("LOEKZ".toUpperCase()); //空,未删除 L,删除
						if("".equals(itemDelete) ||itemDelete == null){
							itemDelete = "0";
						}
						po.setItemDeltet(itemDelete);
						po.setOrderUnit(codes.getString("MEINS".toUpperCase()));
						po.setPoCreateBy(codes.getString("ERNAM".toUpperCase()));
						po.setPoLastModifyDate(codes.getString("AEDAT".toUpperCase()));
						po.setVendorCode(codes.getString("LIFNR".toUpperCase()));
						po.setVendorName(codes.getString("NAME1".toUpperCase()));
						po.setDeliverDate(codes.getString("EINDT".toUpperCase()));

						List<StgPoDownDTO> poList = stgPoDownDAO.getExistingPoItem(po);
						if (poList == null || poList.size() == 0){
							po.setCreateBy(userName);
							po.setCreateDate(new Date());
							stgPoDownDAO.save(po);
						} else {

							Long ifStart = stgPoDownDAO.ifScanningStart(po);
							if (ifStart == 0){
								//根据po_no和po_item_no,修改所有字段
								po.setModifyBy(userName);
								po.setModifyDate(new Date());
								stgPoDownDAO.updateByPoItem(po);
							}
						}
					}
				}
			} else {
				if (poNo != null && !"".equals(poNo) && poNo.length() > 0) {
					StgPoDownDTO dto = new StgPoDownDTO();
					dto.setPoNo(poNo);
					List<StgPoDownDTO> stgPoDownList = stgPoDownDAO.getStgPoDownsByParam(dto);
					if (stgPoDownList != null && stgPoDownList.size() > 0) {
						for (int i = 0; i < stgPoDownList.size(); i++) {
							StgPoDownDTO checkDTO = stgPoDownList.get(i);
							Long ifStart = stgPoDownDAO.ifScanningStart(checkDTO);
							if (ifStart == 0) {
								stgPoDownDAO.bankupDeletedItems(checkDTO);
								stgPoDownDAO.deleteByPoItems(checkDTO);
							}
						}
					}
				}
				result = "E";
				log.setDescription("No data is downloaded!");
				operationLogDAO.save(log);
			}	
		} catch (Exception e) {
			result = "E";
			message = e.getMessage();
			logger.error("Catch Exception when download PO: " + message);
			log.setDescription("Execute Sap Function failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		return result;
	}
	
}
