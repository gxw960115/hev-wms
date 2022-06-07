package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.scrap.dao.OdsScrapOrderDAO;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.sap.conn.jco.*;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author mahuansen
 * @date: 2018/11/6 14:35
 * @description: 报废单过账接口
 */
public class ScrapToSap {
    Logger logger = Logger.getLogger(ScrapToSap.class);
    String rfc_id = "ZMM_AEV_INT_GOODSSCRAP";
    String system_id = "HEVWMS";
    String orderNo;
    String sapFlag; 
    String message;
    private OperationLogDAO operationLogDAO;
    private OdsScrapOrderDAO odsScrapOrderDAO;

    public ScrapToSap(OperationLogDAO operationLogDAO, OdsScrapOrderDAO odsScrapOrderDAO) {
        this.operationLogDAO = operationLogDAO;
        this.odsScrapOrderDAO = odsScrapOrderDAO;
    }

    public ScrapToSap(String orderNo, String sapFlag, OperationLogDAO operationLogDAO, OdsScrapOrderDAO odsScrapOrderDAO) {
        this.orderNo = orderNo;
        this.sapFlag = sapFlag;
        this.operationLogDAO = operationLogDAO;
        this.odsScrapOrderDAO = odsScrapOrderDAO;
    }

    public ScrapToSap(String orderNo, String sapFlag){
        this.orderNo = orderNo;
        this.sapFlag = sapFlag;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsScrapOrderDAO = SpringApplicationContextHolder.getBean("odsScrapOrderDAO");
    }

    public String exchangeWithSap() {
        logger.info("<<<ScrapToSap>>> Exchange with sap start----------------<<<ScrapToSap>>>\n");
        logger.info("<<<ScrapToSap>>> SAP Interface Input Param: OrderNo=" + orderNo + "sapFlag=" + sapFlag);
        String result = "E";
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setAppName("ScrapToSap");
        String mv_type = "551";			//移动类型
        String issue_plant = "";		//发货工厂
        String issue_loc = "";			//发货库位
        String doc_dt = "";				//凭证日期  默认当前
        String post_dt = "";			//过账日期 默认当前  可手工调整与SAP账期有关
        String mat_code = "";			//物料
        String qty = "";				//数量
        String unit = "";				//单位
        String cost_center = "";        //成本中心
        String wms_id = "";

        String plant = "";				//工厂
        String doc_no = "";				//物料凭证
        String doc_year = "";			//凭证年
        String sap_flag = "";			//过账结果标识，S成功，E失败
        String sap_msg = "";			//sap 消息

        try {
            SapConnection.initSapConn();
            logger.info("<<<ScrapToSap>>> SAP connection successfully");
        } catch (Exception ex) {
            result = "E";
            logger.info(ex);
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:"+(message.length()<=1000?message:message.substring(0, 1000)));
            operationLogDAO.save(log);
        }

        try {
            JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            JCoFunction function = destination.getRepository().getFunction(rfc_id);
            OdsScrapOrderDTO odsScrapOrderDTO = new OdsScrapOrderDTO();
            odsScrapOrderDTO.setScrapNo(orderNo);
            odsScrapOrderDTO.setSapFlag(sapFlag);
            List<OdsScrapOrderDTO> list = odsScrapOrderDAO.getOdsScrapOrderListByParm(odsScrapOrderDTO);
            if (list != null && list.size() > 0) {
                for (OdsScrapOrderDTO header: list ) {
                    issue_plant = header.getPlant();
                    issue_loc = header.getLocation();
                    doc_dt = header.getPostingDate();
                    post_dt = header.getPostingDate();
                    cost_center = header.getCostCenter();
                    wms_id = header.getRowId().toString();    //sap最长20位
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
                        paramIn.setValue("COSTCTR",cost_center);
                        paramIn.setValue("WMS_ID",wms_id);

                        JCoTable tableIn = function.getTableParameterList().getTable("INPUT_ITEM");
                        tableIn.clear();
                        tableIn.appendRow();
                        tableIn.setValue("MATNR",mat_code);
                        tableIn.setValue("QTY",qty);
                        tableIn.setValue("UOM",unit);
                        tableIn.setValue("LGORT",issue_loc);

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
                    logger.info("<<<ScrapToSap>>> Sap Return Param: \n" + sapReturnParam);
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
                        logger.info("<<<ScrapToSap>>>Scrap to SAP Success!");
                    }
                    header.setSapMsg(sap_flag+":"+sap_msg);
                    odsScrapOrderDAO.updateSapReMsg(header);
                }
            } else {
                logger.info("Order:"+orderNo+",  no data to post!");
                log.setDescription("Order:"+orderNo+",  no data to post!");
                operationLogDAO.save(log);
            }
        }catch(Exception e){
            result = "E";
            message = e.getMessage();
            logger.error("<<<ScrapToSap>>>Catch Exception when post PO: " + e.getMessage());
            log.setDescription("Execute Sap Function failed!"+(message.length()<=1000?message:message.substring(0, 1000)));
            operationLogDAO.save(log);
        }
        logger.info("<<<ScrapToSap>>> Exit ScrapToSap!");
        return result;
    }
}
