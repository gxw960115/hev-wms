package com.haier.hevwms.sapinterface;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.transfer.dao.OdsTransferInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * @author: mahuansen
 * @date: 2018/11/6 14:35
 * @description:
 */
public class GoodsMovementToSap {
    Logger logger = Logger.getLogger(GoodsMovementToSap.class);
    String rfc_id = "ZMM_AEV_INT_SLOCTRANSFER";
    String system_id = "HEVWMS";
    String orderNo;
    String sapFlag;
    String message ;
    private OperationLogDAO operationLogDAO;
    private OdsTransferInfoDAO odsTransferInfoDAO;

    public GoodsMovementToSap(String orderNo, OperationLogDAO operationLogDAO, OdsTransferInfoDAO odsTransferInfoDAO) {
        this.orderNo = orderNo;
        this.operationLogDAO = operationLogDAO;
        this.odsTransferInfoDAO = odsTransferInfoDAO;
    }

    public GoodsMovementToSap(String orderNo, String sapFlag) {
        this.orderNo = orderNo;
        this.sapFlag = sapFlag;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsTransferInfoDAO = SpringApplicationContextHolder.getBean("odsTransferInfoDAO");
    }

    public String exchangeWithSap() {
        logger.info("<<<GoodsMovementToSAP>>> Exchange with sap start-------------<<<GoodsMovementToSAP>>>");
        logger.info("<<<GoodsMovementToSAP>>> SAP Interface Input Param: OrderNo=" + orderNo + "sapFlag=" + sapFlag);
        String result = "E";
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setAppName("GoodsMovementToSap");
        String mv_type = "311";			//移动类型
        String issue_plant = "";		//发货工厂
        String issue_loc = "";			//发货库位
        String doc_dt = "";				//凭证日期  默认当前
        String post_dt = "";			//过账日期 默认当前  可手工调整与SAP账期有关
        String rec_loc = "";			//接受库位
        String mat_code = "";			//物料
        String qty = "";				//数量
        String unit = "";				//单位
        String wms_id = "";

        String plant = "";				//工厂
        String doc_no = "";				//物料凭证
        String doc_year = "";			//凭证年
        String sap_flag = "";			//过账结果标识，S成功，E失败
        String sap_msg = "";			//sap 消息

        try {
            SapConnection.initSapConn();
            logger.info("<<<GoodsMovementToSAP>>> SAP connection successfully");
        } catch (Exception ex) {
            result = "E";
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
            operationLogDAO.save(log);
            logger.info(ex);
        }
        try {

            JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            JCoFunction function = destination.getRepository().getFunction(rfc_id);
            
            OdsTransferInfoDTO dto = new OdsTransferInfoDTO();
            dto.setTransNo(orderNo);
            dto.setSapFlag(sapFlag);
            List<OdsTransferInfoDTO> list = odsTransferInfoDAO.searchOdsTransferInfoList(dto);
            if (list != null && list.size() > 0) {
                for (OdsTransferInfoDTO header: list ) {
                    logger.info("Transfer begin>>>>order:" + orderNo + ", material:" + header.getMaterialNo());
                    issue_plant = header.getPlant();
                    issue_loc = header.getGiLocation();
                    doc_dt = header.getPostingDate();
                    post_dt = header.getPostingDate();
                    rec_loc = header.getGrLocation();
                    wms_id = header.getRowId().toString();
                    
                    mat_code = header.getMaterialNo();
                    qty = String.valueOf(header.getQty());
                    unit = header.getUnit();

                    try {
                        JCoParameterList paramIn = function.getImportParameterList();
                        paramIn.clear();
                        paramIn.setValue("MOVE_TYPE",mv_type);
                        paramIn.setValue("PLANT",issue_plant);
                        paramIn.setValue("DOC_DATE",doc_dt);
                        paramIn.setValue("PSTNG_DATE",post_dt);
                        paramIn.setValue("RLGORT",rec_loc);
                        paramIn.setValue("WMS_ID", wms_id);
                        logger.info("<<<GoodsMovementToSAP>>> SAP paramIn: \n" + paramIn);

                        JCoTable tableIn = function.getTableParameterList().getTable("IT_ITEM");
                        tableIn.clear();
                        tableIn.appendRow();
                        tableIn.setValue("MATNR",mat_code);
                        tableIn.setValue("QTY",qty);
                        tableIn.setValue("UOM",unit);
                        tableIn.setValue("LGORT",issue_loc);
                        logger.info("<<<GoodsMovementToSAP>>> SAP tableIn: \n" + tableIn);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new Exception(e.getMessage());
                    }
                    try {
                        function.execute(destination);
                    } catch(Exception e) {
                    	logger.info("Order:"+orderNo+", function execute fail!");
						log.setDescription("Order:"+orderNo+", function execute fail!");
						operationLogDAO.save(log);
                    }

                    JCoStructure sapReturnParam = function.getExportParameterList().getStructure("EX_RETURN");
                    logger.info("<<<GoodsMovementToSAP>>> >>>>>>>>>>>>>>>>>>>>>>>SAP Return Param:\n"+sapReturnParam);
                    logger.info(sapReturnParam);
                    plant = sapReturnParam.getString("PLANT");
                    doc_no = sapReturnParam.getString("MBLNR");
                    doc_year = sapReturnParam.getString("MJAHR");
                    sap_flag = sapReturnParam.getString("MSG_TYPE");
                    sap_msg = sapReturnParam.getString("MESSAGE");
                    header.setPlant(plant);
                    header.setDocNo(doc_no);
                    header.setDocYear(doc_year);
                    if (StringUtils.isEmpty(doc_no)) {
                    	header.setSapFlag("2");
                    } else {
                    	header.setSapFlag("1");
                    	result = "S";
                    	logger.info("<<<GoodsMovementToSAP>>> SAP Interface Success!");
                    }
                    header.setSapMsg(sap_flag + ":" + sap_msg);
                    odsTransferInfoDAO.updatePostResult(header);
                }
            } else {
                logger.info("Order:"+orderNo+",  no data to post!");
                log.setDescription("Order:"+orderNo+",  no data to post!");
                operationLogDAO.save(log);
            }
        } catch(Exception e) {
            result = "E";
            message = e.getMessage();
            logger.error("Catch Exception when post PO: " + e.getMessage());
            log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
            operationLogDAO.save(log);
        }
        logger.info("<<<GoodsMovementToSAP>>> Exchange with sap exit-------------<<<GoodsMovementToSAP>>>");
        return result;
    }
}
