package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;

public class PostPoToSap {
	
	Logger logger = Logger.getLogger(PostPoToSap.class);
	
	String rfc_id = "ZMM_AEV_INT_GOODSRECEIPT"; // RFC函数名
	String system_id = "HEVWMS"; 
	String[] orderNos;   //igp号，目前只传一个
	String sapFlag;
	String message ;
	private String userName;
	private OperationLogDAO operationLogDAO;
	private OdsPoGrInfoDAO odsPoGrInfoDAO;

	public PostPoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsPoGrInfoDAO odsPoGrInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsPoGrInfoDAO = odsPoGrInfoDAO;
	}

	public PostPoToSap(String orderNo, String sapFlag, String userName){
		this.orderNos = orderNo.split(",");
		this.sapFlag = sapFlag;
		this.userName = userName;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		odsPoGrInfoDAO = SpringApplicationContextHolder.getBean("odsPoGrInfoDAO");
	}
	
	public String exchangeWithSap(){
		
		logger.info("Exchange with sap start------------------------");
		String result = "E";
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("PostPoToSap");

		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			logger.info(ex);
			message=ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		try {
			
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);

			// 定义输入参数
			JCoParameterList parameterList = function.getImportParameterList();
			JCoStructure inputStruct = parameterList.getStructure("INPUT");
			
			for (int i = 0;i < orderNos.length; i++){
				OdsPoGrInfoDTO odsPoGrInfo = new OdsPoGrInfoDTO();
				odsPoGrInfo.setOrderNo(orderNos[i]);
				odsPoGrInfo.setSapFlag(sapFlag);
				List<OdsPoGrInfoDTO> list = odsPoGrInfoDAO.searchList(odsPoGrInfo);
				if (list != null && list.size() > 0){
					for (OdsPoGrInfoDTO dto: list ){
						inputStruct.setValue("WMS_ID", dto.getRowId());
						inputStruct.setValue("DELIVERY", dto.getOrderNo());
						inputStruct.setValue("EBELN", dto.getPoNo());
						inputStruct.setValue("EBELP", dto.getPoItemNo());
						inputStruct.setValue("MATNR", dto.getMaterialNo());
						inputStruct.setValue("LGORT", dto.getLocation());
						inputStruct.setValue("MENGE", dto.getScannedQty());
						inputStruct.setValue("MEINS", dto.getUnit());
						inputStruct.setValue("FRBNR", dto.getCarNo());
						inputStruct.setValue("SHIP_DATE", dto.getDeliveryDate());
						
						logger.info("INPUT Table=========>\n" + inputStruct);
						function.execute(destination);

						JCoStructure outputStruct = function.getExportParameterList().getStructure("RETURN");
						logger.info("OUTPUT Structure=========>\n" + outputStruct);
						
						if (StringUtils.isEmpty(outputStruct.getString("MBLNR"))){
							dto.setSapFlag("2");
						} else {
							dto.setSapFlag("1");
							result="S";
						}
						
						dto.setSapMsg(outputStruct.getString("FLAG")+":"+outputStruct.getString("MESSAGE"));
						dto.setSapDocNo(outputStruct.getString("MBLNR"));
						dto.setSapDocYear(outputStruct.getString("MJAHR"));
						dto.setModifyBy(userName);
						dto.setModifyDate(new Date());
					    odsPoGrInfoDAO.updatePostResult(dto);

					}
				} else {
					logger.info("Order:"+orderNos[i]+",  no data to post!");
					log.setDescription("Order:"+orderNos[i]+",  no data to post!");
					operationLogDAO.save(log);
				}
				
			}
		}catch(Exception e){
			logger.error("Catch Exception when post PO: " + e.getMessage());
			message = e.getMessage();
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		logger.info("Post Po to SAP Success!");
		return result;
	}
}
