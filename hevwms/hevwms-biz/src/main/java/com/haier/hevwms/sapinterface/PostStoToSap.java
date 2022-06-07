package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.hevwms.sto.dao.OdsStoScanInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.sap.conn.jco.*;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright: Copyright © 2013-2018 
 * @className: PostStoToSap.java
 * @description: STO出库过账,参数表名需要改
 *
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年10月16日 上午10:13:39
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月12日		SJK			v1.0.0			create
 */

public class PostStoToSap {
	
	Logger logger = Logger.getLogger(PostStoToSap.class);
	
	String rfc_id = "ZMM_HEV_TO_WMS_STOTODN"; // RFC函数名
	String system_id = "HEVWMS"; 
	String[] orderNos;   //igp号，目前只传一个
	String sapFlag;
	String message ;
	private String userName;
	private OperationLogDAO operationLogDAO;
	private OdsStoGigrInfoDAO odsStoGigrInfoDAO;
	private OdsStoScanInfoDAO odsStoScanInfoDAO;

	public PostStoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsStoGigrInfoDAO odsStoGigrInfoDAO, OdsStoScanInfoDAO odsStoScanInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsStoGigrInfoDAO = odsStoGigrInfoDAO;
		this.odsStoScanInfoDAO = odsStoScanInfoDAO;
	}

	public PostStoToSap(String orderNo, String sapFlag, String userName){
		this.orderNos = orderNo.split(",");
		this.sapFlag = sapFlag;
		this.userName = userName;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		odsStoGigrInfoDAO = SpringApplicationContextHolder.getBean("odsStoGigrInfoDAO");
		odsStoScanInfoDAO = SpringApplicationContextHolder.getBean("odsStoScanInfoDAO");
	}
	
	public InterfaceOutDTO exchangeWithSap(){
		
		logger.info("Exchange with sap start------------------------");
		
		InterfaceOutDTO result = new InterfaceOutDTO();
		Set<String> dnNos = new HashSet<String>();
		result.setStatus("E");
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("PostStoToSap");

		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			logger.info(ex);
			message = ex.getMessage();
			result.setMsg(message);
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		try {
			
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);

			// 定义输入参数
			JCoParameterList parameterList = function.getTableParameterList();
			JCoTable tableIn = parameterList.getTable("IT_PO_INPUT1");
			tableIn.clear();
			
			for (int i = 0;i < orderNos.length; i++){
				OdsStoGigrInfoDTO odsStoGiGrInfo = new OdsStoGigrInfoDTO();
				odsStoGiGrInfo.setOrderNo(orderNos[i]);
				odsStoGiGrInfo.setSapFlag(sapFlag);
				odsStoGiGrInfo.setOrderType("2");
				List<OdsStoGigrInfoDTO> list = odsStoGigrInfoDAO.searchList(odsStoGiGrInfo);
				if (list != null && list.size() > 0){
					for (OdsStoGigrInfoDTO dto: list ){
						tableIn.appendRow();
						if (result.getStoNo() == null || "".equals(result.getStoNo())){
							result.setStoNo(dto.getStoNo());
						}
						tableIn.setValue("EBELN", dto.getStoNo());
						tableIn.setValue("EBELP", dto.getStoItemNo());
						tableIn.setValue("MATNR", dto.getMaterialNo());
						tableIn.setValue("BEROT", dto.getOrderNo());
						tableIn.setValue("MENGE", dto.getScannedQty());
						tableIn.setValue("VSTEL", dto.getPlant());
					}
					logger.info("INPUT Table=========>" + tableIn);
					function.execute(destination);
//					JCoStructure outputStruct = function.getExportParameterList().getStructure("RETURN");
					JCoTable tableOut = function.getTableParameterList().getTable("IT_PO_OUTPUT1");
					logger.info("OUTPUT Structure=========>" + tableOut);
					for (int j = 0; j < tableOut.getNumRows(); j++) {
						tableOut.setRow(j);
						dnNos.add(tableOut.getString("VBELN"));
//						if (StringUtils.isEmpty(tableOut.getString("VBELN"))){
						if (!"S".equalsIgnoreCase(tableOut.getString("MSG_TYPE"))){
							odsStoGiGrInfo.setSapFlag("2");
						} else {
							odsStoGiGrInfo.setSapFlag("1");
							result.setStatus("S");
							result.setMsg("Success!");
						}
						odsStoGiGrInfo.setStodnNo(tableOut.getString("VBELN"));
						odsStoGiGrInfo.setStodnItemNo(tableOut.getString("POSNR"));
						odsStoGiGrInfo.setMaterialNo(tableOut.getString("MATNR"));
						odsStoGiGrInfo.setPlant(tableOut.getString("WERKS"));
						odsStoGiGrInfo.setLocation(tableOut.getString("LGORT"));
						odsStoGiGrInfo.setScannedQty(Double.valueOf(tableOut.getString("LFIMG")).longValue());
						odsStoGiGrInfo.setUnit(tableOut.getString("MEINS"));
//						odsStoGiGrInfo.setStoNo(tableOut.getString("VGBEL"));
//						odsStoGiGrInfo.setStoItemNo(tableOut.getString("VGPOS"));
//						odsStoGiGrInfo.setSapFlag(tableOut.getString("BAPI_MTYPE"));  //Message type: S Success, E Error, W Warning, I Info, A Abort
						odsStoGiGrInfo.setSapMsg(tableOut.getString("MSG_TYPE")+":"+tableOut.getString("MSG_TEXT"));
						odsStoGiGrInfo.setModifyBy(userName);
						odsStoGiGrInfo.setModifyDate(new Date());  //0080000584
						odsStoGigrInfoDAO.updatePostResult(odsStoGiGrInfo);
						//更新扫描信息的sto dn 和stodn no
						OdsStoScanInfoDTO scanDto = new OdsStoScanInfoDTO();
						scanDto.setOrderNo(orderNos[i]);
						scanDto.setMaterialNo(tableOut.getString("MATNR"));
						scanDto.setStodnNo(tableOut.getString("VBELN"));
						scanDto.setStodnItemNo(tableOut.getString("POSNR"));
						odsStoScanInfoDAO.updateStodnInfo(scanDto);
					}	
					result.setDnNos(dnNos);
				} else {
					logger.info("Order:"+orderNos[i]+",  no data to post!");
					log.setDescription("Order:"+orderNos[i]+",  no data to post!");
					operationLogDAO.save(log);
				}
			}
		}catch(Exception e){
			message = e.getMessage();
			result.setMsg(message);
			logger.error("Catch Exception when post STO: " + e.getMessage());
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		log.setDescription("Post sto success, stodn no:"+result.getDnNos());
		logger.info("Post Sto to SAP Success!");
		return result;
	}
	
}
