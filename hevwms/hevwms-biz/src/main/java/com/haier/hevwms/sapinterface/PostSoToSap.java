package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * Copyright: Copyright © 2013-2018
 * @className: PostSoToSap.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月13日 上午9:19:35
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月12日		SJK			v1.0.0			create
 */

public class PostSoToSap {
	Logger logger = Logger.getLogger(PostPoToSap.class);
	
	String rfc_id = "ZSD_AEV_INT_02";
	String[] orderNos;
	String sapFlag;
	String message;
	String shippingPoint;
	private String userName;
	private OperationLogDAO operationLogDAO;
	private OdsSoGrInfoDAO odsSoGrInfoDAO;

	public PostSoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsSoGrInfoDAO odsSoGrInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsSoGrInfoDAO = odsSoGrInfoDAO;
	}

	public PostSoToSap(String orderNo, String sapFlag, String shippingPoint, String userName){
		this.shippingPoint = shippingPoint;
		this.orderNos = orderNo.split(",");
		this.sapFlag = sapFlag;
		this.userName = userName;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		odsSoGrInfoDAO = SpringApplicationContextHolder.getBean("odsSoGrInfoDAO");
	}
	
	public String exchangeWithSap(){
		logger.info("Exchange with sap start------------------------");
		logger.info(shippingPoint);
		String result = "S";
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("PostSoToSap");
		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			logger.info(ex);
			result = "E";
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);

			// 定义输入参数
			JCoParameterList parameterList = function.getTableParameterList();
			JCoTable tableIn = parameterList.getTable("INPUT");
			tableIn.clear();
			
			for (int i = 0;i < orderNos.length; i++){
				OdsSoGrInfoDTO odsSoGrInfo = new OdsSoGrInfoDTO();
				odsSoGrInfo.setOrderNo(orderNos[i]);
				odsSoGrInfo.setSapFlag(sapFlag);
				List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getOdsSoGrInfoListByParm(odsSoGrInfo);
				if (list != null && list.size() > 0){
					for (OdsSoGrInfoDTO dto: list ){
						tableIn.appendRow();
						// 销售订单号
						tableIn.setValue("VBELN",dto.getSapOrderNo());
						// 行项目
						tableIn.setValue("POSNR", dto.getSapOrderItem());
						// WMS的编号ID
						tableIn.setValue("ID",dto.getRowId());
						// CNTC 此字段打印在DN上
						tableIn.setValue("CNTC",dto.getOrderNo());
						// VSTEL 装船点，WMS手工录入
						tableIn.setValue("VSTEL","65C1");
						// 物料号
						tableIn.setValue("MATNR",dto.getMaterialNo());
						// 数量
						tableIn.setValue("MENGE",dto.getScannedQty());
						// 单位
						tableIn.setValue("MEINS",dto.getUnit());
						// 工厂
						tableIn.setValue("WERKS",dto.getPlant());
						// 库位
						tableIn.setValue("LGORT",dto.getLocation());
						// 备注
						tableIn.setValue("REMARK","");
					}
					logger.info("INPUT Table=========>" + tableIn);
					function.execute(destination);

					JCoTable tableOut = function.getTableParameterList().getTable("OUTPUT");
					
					logger.info("OUTPUT Table=========>" + tableOut);
					if (tableOut.getNumRows() > 0) {
						for (int j = 0; i < tableOut.getNumRows(); j++) {
							tableOut.setRow(j);
							OdsSoGrInfoDTO temp = new OdsSoGrInfoDTO();
							temp.setRowId(Long.valueOf(tableOut.getString("ID")));
							temp.setOrderNo(tableOut.getString("CNTC"));
							temp.setDnNo(tableOut.getString("VBELN_DN"));
							if (StringUtils.isEmpty(tableOut.getString("MBLNR"))){
								temp.setSapFlag("2");
							} else {
								temp.setSapFlag("1");
							}
							temp.setSapMsg(tableOut.getString("FLAG")+":"+tableOut.getString("MESSAGE"));
							temp.setSapDocNo(tableOut.getString("MBLNR"));
							temp.setModifyBy(userName);
							temp.setModifyDate(new Date());
							odsSoGrInfoDAO.updatePostResult(odsSoGrInfo);
						}
					} else {
						logger.info("Order:"+orderNos[i]+",  no data return!");
						log.setDescription("Order:"+orderNos[i]+",  no data to return!");
						operationLogDAO.save(log);
					}
				} else {
					logger.info("Order:"+orderNos[i]+",  no data to post!");
					log.setDescription("Order:"+orderNos[i]+",  no data to post!");
					operationLogDAO.save(log);
				}
			}
		}catch(Exception e){
			result = "E";
			message = e.getMessage();
			logger.error("Catch Exception when post PO: " + e.getMessage());
			log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		logger.info("Post So to SAP Success!");
		
		return result;
	}
}
