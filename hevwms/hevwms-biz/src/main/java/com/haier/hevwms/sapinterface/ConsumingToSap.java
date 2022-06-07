package com.haier.hevwms.sapinterface;

import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.consume.dao.OdsConsumeOrderDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * @author liujiazhen
 * @date: 2018/11/6 14:35
 * @description:
 */
public class ConsumingToSap {

    Logger logger = Logger.getLogger(ConsumingToSap.class);
    String rfc_id = "ZMM_AEV_INT_GGOODSISSUE";
    String system_id = "HEVWMS";
    String orderNo;
    String sapFlag;
    String message;
    private OperationLogDAO operationLogDAO;
    private OdsConsumeOrderDAO odsConsumeOrderDAO;

    public ConsumingToSap(OperationLogDAO operationLogDAO, OdsConsumeOrderDAO odsConsumeOrderDAO) {
        this.operationLogDAO = operationLogDAO;
        this.odsConsumeOrderDAO = odsConsumeOrderDAO;
    }

    public ConsumingToSap(String orderNo, String sapFlag){
        this.orderNo = orderNo;
        this.sapFlag = sapFlag;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsConsumeOrderDAO = SpringApplicationContextHolder.getBean("odsConsumeOrderDAO");
    }

    public String exchangeWithSap(){
        logger.info("<<<ConsumingToSap>>> Exchange with sap start------------------------");
        logger.info("<<<ConsumingToSap>>> Input param: OrderNo=" + orderNo + "sapFlag=" + sapFlag);
        String result = "E";
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setAppName("ConsumingToSap");
        String mv_type = "201";			//移动类型
        String issue_plant = "";		//发货工厂
        String issue_loc = "";			//发货库位
        String doc_dt = "";				//凭证日期  默认当前
        String post_dt = "";			//过账日期 默认当前  可手工调整与SAP账期有关
        String mat_code = "";			//物料
        String qty = "";				//数量
        String unit = "";				//单位
        String gl_account = "";         //会计科目
        String cost_center = "";        //成本中心
        String wms_id = "";

        String plant = "";				//工厂
        String doc_no = "";				//物料凭证
        String doc_year = "";			//凭证年
        String sap_flag = "";			//过账结果标识，S成功，E失败
        String sap_msg = "";			//sap 消息

        try {
            SapConnection.initSapConn();
            logger.info("<<<ConsumingToSap>>> SAP connection successfully");
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
            OdsConsumeOrderDTO odsConsumeOrderDTO = new OdsConsumeOrderDTO();
            odsConsumeOrderDTO.setConsumeNo(orderNo);
            odsConsumeOrderDTO.setSapFlag(sapFlag);
            List<OdsConsumeOrderDTO> list = odsConsumeOrderDAO.getOdsConsumeOrderListByParm(odsConsumeOrderDTO);
            if (list != null && list.size() > 0){
                for (OdsConsumeOrderDTO header: list ) {
                    issue_plant = header.getPlant();
                    issue_loc = header.getLocation();
                    doc_dt = header.getPostingDate();
                    post_dt = header.getPostingDate();
                    cost_center = header.getCostCenter();
                    wms_id = header.getRowId().toString();  //sap最长20位
                    gl_account = header.getGlAccount();
                    mat_code = header.getMaterialNo();
                    qty = String.valueOf(header.getRequireQty());
                    unit = header.getUnit();

                    try {
                        JCoStructure paramIn = function.getImportParameterList().getStructure("INPUT_HEAD");
                        paramIn.clear();
                        paramIn.setValue("MOVE_TYPE",mv_type);
                        paramIn.setValue("PLANT",issue_plant);
                        paramIn.setValue("DOC_DATE",doc_dt);
                        paramIn.setValue("PSTNG_DATE",post_dt);
                        paramIn.setValue("GLACCOUNT",gl_account);
                        paramIn.setValue("COSTCTR",cost_center);
                        paramIn.setValue("WMS_ID", wms_id);
                        logger.info("<<<ConsumingToSap>>> SAP paramIn: \n" + paramIn);

                        JCoTable tableIn = function.getTableParameterList().getTable("INPUT_ITEM");
                        tableIn.clear();
                        tableIn.appendRow();
                        tableIn.setValue("MATNR",mat_code);
                        tableIn.setValue("QTY",qty);
                        tableIn.setValue("UOM",unit);
                        tableIn.setValue("LGORT",issue_loc);
                        logger.info("<<<ConsumingToSap>>> SAP tableIn: \n" + tableIn);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new Exception(e.getMessage());
                    }
                    try {
                        function.execute(destination);
                    } catch(Exception e) {
                        e.printStackTrace();
                        throw new Exception(e.getMessage());
                    }

                    JCoStructure sapReturnParam = function.getExportParameterList().getStructure("OUTPUT");
                    logger.info("<<<ConsumingToSap>>> SAP Return Param: \n" + sapReturnParam);

                    plant = sapReturnParam.getString("EX_PLANT");
                    doc_no = sapReturnParam.getString("MBLNR");
                    doc_year = sapReturnParam.getString("MJAHR");
                    sap_flag = sapReturnParam.getString("MSG_TYPE");
                    sap_msg = sapReturnParam.getString("MSG_TEXT");
                    header.setPlant(plant);
                    header.setMatDoc(doc_no);
                    header.setDocYear(doc_year);
                    if (StringUtils.isEmpty(doc_no)){
                    	header.setSapFlag("2");
                    } else {
                    	header.setSapFlag("1");
                    	result = "S";
                        logger.info("<<<ConsumingToSap>>> Consume to SAP Success!");
                    }
                    header.setSapMsg(sap_flag+":"+sap_msg);
                    odsConsumeOrderDAO.updateSapReMsg(header);
                }
            } else {
                logger.info("Order:"+orderNo+",  no data to post!");
                log.setDescription("Order:"+orderNo+",  no data to post!");
                operationLogDAO.save(log);
            }
        }catch(Exception e){
            result = "E";
            message = e.getMessage();
            logger.error("<<<ConsumingToSap>>> Catch Exception when post PO: " + e.getMessage());
            log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
            operationLogDAO.save(log);
        }
        logger.info("<<<ConsumingToSap>>> exit consuming to sap!");
        return result;
    }
}
