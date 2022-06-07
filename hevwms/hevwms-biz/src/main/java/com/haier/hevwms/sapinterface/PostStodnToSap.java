package com.haier.hevwms.sapinterface;

import java.util.Date;
import java.util.List;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * Copyright: Copyright © 2013-2018
 *
 * @className: PostStodnToSap.java
 * @description: stodn入库过账, 过账结果按订单更新
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月14日 下午12:13:39
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年11月12日		SJK			v1.0.0			create
 */

public class PostStodnToSap {
    Logger logger = Logger.getLogger(PostStodnToSap.class);

    String rfc_id = "ZMM_HEV_WMS_POST_GR";
    String system_id = "HEVWMS";
    String[] orderNos;
    String sapFlag;
    String message;
    private String userName;
    private OperationLogDAO operationLogDAO;
    private OdsStoGigrInfoDAO odsStoGigrInfoDAO;

    public PostStodnToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsStoGigrInfoDAO odsStoGigrInfoDAO) {
        this.orderNos = orderNos;
        this.operationLogDAO = operationLogDAO;
        this.odsStoGigrInfoDAO = odsStoGigrInfoDAO;
    }

    public PostStodnToSap(String orderNo, String sapFlag, String userName) {
        this.orderNos = orderNo.split(",");
        this.sapFlag = sapFlag;
        this.userName = userName;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsStoGigrInfoDAO = SpringApplicationContextHolder.getBean("odsStoGigrInfoDAO");
    }

    public InterfaceOutDTO exchangeWithSap() {
        logger.info("Exchange with sap start------------------------");
        InterfaceOutDTO result = new InterfaceOutDTO();
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("PostStodnToSap");

        try {
            SapConnection.initSapConn();
            logger.info("SAP connection successfully");
        } catch (Exception ex) {
            logger.info(ex);
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
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
            JCoTable tableIn = parameterList.getTable("IT_GR_INPUT");
            tableIn.clear();

            for (int i = 0; i < orderNos.length; i++) {
                OdsStoGigrInfoDTO odsStoGiGrInfo = new OdsStoGigrInfoDTO();
                odsStoGiGrInfo.setOrderNo(orderNos[i]);
                odsStoGiGrInfo.setSapFlag(sapFlag);
                odsStoGiGrInfo.setOrderType("1");
                List<OdsStoGigrInfoDTO> list = odsStoGigrInfoDAO.searchList(odsStoGiGrInfo);
                if (list != null && list.size() > 0) {
                    for (OdsStoGigrInfoDTO dto : list) {
                        tableIn.appendRow();
                        tableIn.setValue("EBELN", dto.getStoNo());
                        tableIn.setValue("EBELP", dto.getStoItemNo());
                        tableIn.setValue("VBELN", dto.getStodnNo());
                        tableIn.setValue("POSNR", dto.getStodnItemNo());
                        tableIn.setValue("MATNR", dto.getMaterialNo());
                        tableIn.setValue("LFIMG", dto.getScannedQty());
                        tableIn.setValue("LGORT", dto.getLocation());
                        tableIn.setValue("MEINS", dto.getUnit());
                        tableIn.setValue("WERKS", dto.getPlant());
                    }
                    logger.info("INPUT Table=========> \n" + tableIn);
                    function.execute(destination);
//					JCoStructure outputStruct = function.getExportParameterList().getStructure("RETURN");
                    JCoTable tableOut = function.getTableParameterList().getTable("IT_GR_OUTPUT");

                    logger.info("OUTPUT Structure=========>" + tableOut);
                    for (int j = 0; j < tableOut.getNumRows(); j++) {
                        tableOut.setRow(j);

                        if (StringUtils.isEmpty(tableOut.getString("MBLNR"))) {
                            odsStoGiGrInfo.setSapFlag("2");
                            result.setStatus("E");
                            result.setMsg(tableOut.getString("MSG"));
                        } else {
                            result.setStatus("S");
                            result.setMsg(tableOut.getString("MSG"));
                            odsStoGiGrInfo.setSapFlag("1");
                        }
                        //返回F，stodn没有。只有sto, EBELN
//						odsStoGiGrInfo.setStodnNo(tableOut.getString("VBELN"));
                        odsStoGiGrInfo.setStoNo(tableOut.getString("EBELN"));
                        odsStoGiGrInfo.setSapDocNo(tableOut.getString("MBLNR"));
                        odsStoGiGrInfo.setSapMsg(tableOut.getString("FLAG") + ":" + tableOut.getString("MSG"));

                        odsStoGiGrInfo.setModifyBy(userName);
                        odsStoGiGrInfo.setModifyDate(new Date());
                        odsStoGigrInfoDAO.updateDnPostResult(odsStoGiGrInfo);
                    }

                } else {
                    logger.info("Order:" + orderNos[i] + ",  no data to post!");
                    log.setDescription("Order:" + orderNos[i] + ",  no data to post!");
                    operationLogDAO.save(log);
                    result.setStatus("E");
                    result.setMsg("No data to post!");
                }
            }
        } catch (Exception e) {
            message = e.getMessage();
            logger.error("Catch Exception when post STO DN: " + e.getMessage());
            log.setDescription("Execute Sap Function failed!" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("Execute SAP function failed!");
            return result;
        }
        logger.info("Post Stodn to SAP Success!");
        return result;
    }

}
