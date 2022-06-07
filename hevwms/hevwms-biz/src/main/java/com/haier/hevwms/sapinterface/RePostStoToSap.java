package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.sap.conn.jco.*;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018
 * @className: PostStoToSap.java
 * @description: STO出库过账重新触发
 *
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月12日 下午01:13:39
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月16日		SJK			v1.0.0			create
 */

public class RePostStoToSap {
	
	Logger logger = Logger.getLogger(RePostStoToSap.class);
	
	String rfc_id = "ZMM_HEV_TO_WMS_STOTODN2"; // RFC函数名
	String system_id = "HEVWMS"; 
	String[] orderNos;   //ogp号
	String sapFlag;  //只传2
	String message;
	String orderType;
	private String userName;
	private OperationLogDAO operationLogDAO;
	private OdsStoGigrInfoDAO odsStoGigrInfoDAO;

	public RePostStoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsStoGigrInfoDAO odsStoGigrInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsStoGigrInfoDAO = odsStoGigrInfoDAO;
	}

	public RePostStoToSap(String orderNo, String sapFlag, String userName, String orderType){
		this.orderNos = orderNo.split(",");
		this.sapFlag = sapFlag;
		this.userName = userName;
		this.orderType = orderType;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		odsStoGigrInfoDAO = SpringApplicationContextHolder.getBean("odsStoGigrInfoDAO");
	}
	
	public InterfaceOutDTO exchangeWithSap(){
		logger.info("Exchange with sap start------------------------");
		InterfaceOutDTO result = new InterfaceOutDTO();
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("RePostStoToSap");

		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			logger.info(ex);
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			result.setStatus("E");
			result.setMsg("SAP connection failed!");
			return result;
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
				List<OdsStoGigrInfoDTO> list = odsStoGigrInfoDAO.searchList(odsStoGiGrInfo);
				if (list != null && list.size() > 0){
					for (OdsStoGigrInfoDTO dto: list ){
						tableIn.appendRow();
						// 销售订单号
						tableIn.setValue("VBELN",dto.getStodnNo());
					}

					logger.info("INPUT Table=========>" + tableIn);
					function.execute(destination);

					JCoTable tableOut = function.getTableParameterList().getTable("IT_PO_OUTPUT1");
					logger.info("OUTPUT Table=========>" + tableOut);
					
					for (int j = 0; j < tableOut.getNumRows(); j++) {
						tableOut.setRow(j);
						if ("S".equalsIgnoreCase(tableOut.getString("MSG_TYPE"))){
							odsStoGiGrInfo.setSapFlag("1");
							result.setStatus("S");
						} else {
							odsStoGiGrInfo.setSapFlag("2");
							result.setStatus("E");
							result.setMsg(tableOut.getString("MSG_TEXT"));
						}
						odsStoGiGrInfo.setStodnNo(tableOut.getString("VBELN"));
						odsStoGiGrInfo.setStodnItemNo(tableOut.getString("POSNR"));
						odsStoGiGrInfo.setMaterialNo(tableOut.getString("MATNR"));
						odsStoGiGrInfo.setPlant(tableOut.getString("WERKS"));
						odsStoGiGrInfo.setLocation(tableOut.getString("LGORT"));
						odsStoGiGrInfo.setScannedQty(Double.valueOf(tableOut.getString("LFIMG")).longValue());
						odsStoGiGrInfo.setUnit(tableOut.getString("MEINS"));
						odsStoGiGrInfo.setSapDocNo(tableOut.getString("VGBEL"));
//						odsStoGiGrInfo.setXXXX(tableOut.getString("VGPOS"));
//						odsStoGiGrInfo.setSapFlag(tableOut.getString("BAPI_MTYPE"));  //Message type: S Success, E Error, W Warning, I Info, A Abort
						odsStoGiGrInfo.setSapMsg(tableOut.getString("MSG_TYPE")+":"+tableOut.getString("MSG_TEXT"));
						odsStoGiGrInfo.setModifyBy(userName);
						odsStoGiGrInfo.setModifyDate(new Date());
						odsStoGiGrInfo.setOrderType(orderType);
						odsStoGigrInfoDAO.updatePostResult(odsStoGiGrInfo);
					}				
				} else {
					logger.info("Order:"+orderNos[i]+",  no data to post!");
					log.setDescription("Order:"+orderNos[i]+",  no data to post!");
					operationLogDAO.save(log);
					result.setStatus("E");
					result.setMsg("No data to post!");
				}
			}
		}catch(Exception e){
			message = e.getMessage();
			logger.error("Catch Exception when post STO: " + e.getMessage());
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
			result.setStatus("E");
			result.setMsg("Execute SAP function failed!");
			return result;
		}
		logger.info("Post Sto to SAP Success!");
		return result;
	}
	
}
