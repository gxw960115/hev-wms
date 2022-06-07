package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.sap.conn.jco.*;
import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018
 * @className: RePostSoToSap.java
 * @description:
 *
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月13日 上午10:29:35
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月12日		SJK			v1.0.0			create
 */
public class RePostSoToSap {
	Logger logger = Logger.getLogger(PostPoToSap.class);

	String rfc_id = "ZSD_AEV_INT_02_2";
	String[] orderNos;
	String sapFlag;
	String message;
	String shippingPoint;
	private String userName;
	private OperationLogDAO operationLogDAO;
	private OdsSoGrInfoDAO odsSoGrInfoDAO;

	public RePostSoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsSoGrInfoDAO odsSoGrInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsSoGrInfoDAO = odsSoGrInfoDAO;
	}

	public RePostSoToSap(String orderNo, String sapFlag, String shippingPoint, String userName){
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
		log.setAppName("RePostSoToSap");
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
				OdsSoGrInfoDTO odsSoGrInfo = new OdsSoGrInfoDTO	();
				odsSoGrInfo.setOrderNo(orderNos[i]);
				odsSoGrInfo.setSapFlag(sapFlag);
				List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getOdsSoGrInfoListByParm(odsSoGrInfo);
				if (list != null && list.size() > 0){
					for (OdsSoGrInfoDTO dto: list ){
						tableIn.appendRow();
						// 销售订单号
						tableIn.setValue("VBELN",dto.getDnNo());
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
