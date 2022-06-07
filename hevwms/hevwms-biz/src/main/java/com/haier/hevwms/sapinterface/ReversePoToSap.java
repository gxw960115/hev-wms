package com.haier.hevwms.sapinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.common.utils.StringUtils;
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
import com.sap.conn.jco.JCoTable;

public class ReversePoToSap {
	
	Logger logger = Logger.getLogger(ReversePoToSap.class);
	
	String rfc_id = "ZMM_AEV_INT_POREVERSAL"; // RFC函数名
	String system_id = "HEVWMS"; 
	String[] orderNos;   //igp号，目前只传一个
	String sapFlag;
	String message;
	private String userName;
	private String moveType;  //移动类型 按照退货PO退货，类型为161 按照DN退货，类型为102  按照原PO退货 类型为122
	private OperationLogDAO operationLogDAO;
	private OdsPoGrInfoDAO odsPoGrInfoDAO;

	public ReversePoToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsPoGrInfoDAO odsPoGrInfoDAO) {
		this.orderNos = orderNos;
		this.operationLogDAO = operationLogDAO;
		this.odsPoGrInfoDAO = odsPoGrInfoDAO;
	}

	public ReversePoToSap(String orderNo, String sapFlag, String userName, String moveType){
		this.orderNos = orderNo.split(",");
		this.sapFlag = sapFlag;
		this.userName = userName;
		this.moveType = moveType;
		operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
		odsPoGrInfoDAO = SpringApplicationContextHolder.getBean("odsPoGrInfoDAO");
	}
	
	public String exchangeWithSap(){
		
		logger.info("Exchange with sap start------------------------");
		String result = "E";
		OperationLogSaveModel log = new OperationLogSaveModel();
		log.setUserName(userName);
		log.setAppName("ReversePoToSap");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			SapConnection.initSapConn();
			logger.info("SAP connection successfully");
		} catch (Exception ex) {
			logger.info(ex);
			message = ex.getMessage();
			log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
			operationLogDAO.save(log);
		}
		try {
			
			JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
			JCoFunction function = destination.getRepository().getFunction(rfc_id);

			// 定义输入参数
			JCoParameterList parameterList = function.getTableParameterList();
			JCoTable tableIn = parameterList.getTable("IT_ITEM");
			JCoParameterList paramIn = function.getImportParameterList();
			boolean headIn = false;
			tableIn.clear();
			
			for (int i = 0;i < orderNos.length; i++){
				OdsPoGrInfoDTO odsPoGrInfo = new OdsPoGrInfoDTO();
				odsPoGrInfo.setOrderNo(orderNos[i]);
				odsPoGrInfo.setSapFlag(sapFlag);
				List<OdsPoGrInfoDTO> list = odsPoGrInfoDAO.searchList(odsPoGrInfo);
				if (list != null && list.size() > 0){
					for (OdsPoGrInfoDTO dto: list ){
						if(!headIn) {
							try {
								paramIn.setValue("MOVE_TYPE", moveType);
								paramIn.setValue("PLANT", dto.getPlant());
								paramIn.setValue("DOC_DATE", sdf.format(new Date()));  //当前时间
								paramIn.setValue("PSTNG_DATE", dto.getPostingDate());
								paramIn.setValue("PO_NUMBER", dto.getPoNo());
								headIn = true;
								logger.info(paramIn);
							} catch (Exception e) {
								logger.error("Set paramIn failed:" + e.getMessage());
								throw new Exception("Set inParam failed:" + e.getMessage());
							}
						}
						
						try {
							tableIn.appendRow();
							tableIn.setValue("PO_ITEM", dto.getPoItemNo());
							tableIn.setValue("ENTRY_QNT", String.valueOf(dto.getScannedQty()));
							tableIn.setValue("ENTRY_UOM", dto.getUnit());
							tableIn.setValue("STGE_LOC", dto.getLocation());
						} catch (Exception e) {
							logger.error("Set tableIn failed:" + e.getMessage());
							throw new Exception("Set tableIn failed:" + e.getMessage());
						}
					}
					logger.info("INPUT Table=========>" + tableIn);
					function.execute(destination);

					JCoStructure outputStruct = function.getExportParameterList().getStructure("EX_RETURN");
					logger.info("OUTPUT Structure=========>" + outputStruct);
					
					if (StringUtils.isEmpty(outputStruct.getString("MBLNR"))){
						odsPoGrInfo.setSapFlag("2");
					} else {
						odsPoGrInfo.setSapFlag("1");
						result="S";
					}
					
					odsPoGrInfo.setPoNo(outputStruct.getString("PURCHASE_ORDER"));
					odsPoGrInfo.setSapMsg(outputStruct.getString("MBLNR")+":"+outputStruct.getString("MESSAGE"));
					odsPoGrInfo.setSapDocNo(outputStruct.getString("MBLNR"));
					odsPoGrInfo.setSapDocYear(outputStruct.getString("MJAHR"));
					odsPoGrInfo.setModifyBy(userName);
					odsPoGrInfo.setModifyDate(new Date());
					odsPoGrInfoDAO.updateReverseResult(odsPoGrInfo);
					
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
		return result;
	}
}
