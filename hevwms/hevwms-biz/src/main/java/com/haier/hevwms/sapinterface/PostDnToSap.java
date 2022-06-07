package com.haier.hevwms.sapinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
import org.apache.cxf.common.util.StringUtils;

/**
 * Copyright: Copyright © 2013-2018
 *
 * @className: PostSoToSap.java
 * @description:
 * @version: v1.0.0
 * @author: SJK
 * @date 2018年11月13日 上午9:19:35
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月12日		SJK			v1.0.0			create
 */

public class PostDnToSap {
    Logger logger = Logger.getLogger(PostDnToSap.class);

    String rfc_id = "ZSD_HEV_WMS_TO_PGI";
    String system_id = "HEVWMS";
    String[] orderNos;
    String sapFlag;
    String message;
    private String userName;
    private OperationLogDAO operationLogDAO;
    private OdsSoGrInfoDAO odsSoGrInfoDAO;

    public PostDnToSap(String[] orderNos, OperationLogDAO operationLogDAO, OdsSoGrInfoDAO odsSoGrInfoDAO) {
        this.orderNos = orderNos;
        this.operationLogDAO = operationLogDAO;
        this.odsSoGrInfoDAO = odsSoGrInfoDAO;
    }

    public PostDnToSap(String orderNo, String sapFlag, String userName) {
        this.orderNos = orderNo.split(",");
        this.sapFlag = sapFlag;
        this.userName = userName;
        operationLogDAO = SpringApplicationContextHolder.getBean("operationLogDAO");
        odsSoGrInfoDAO = SpringApplicationContextHolder.getBean("odsSoGrInfoDAO");
    }

    public InterfaceOutDTO exchangeWithSap() {
        logger.info("Post DN Start========>" + orderNos[0]);
        OperationLogSaveModel log = new OperationLogSaveModel();
        log.setUserName(userName);
        log.setAppName("PostDnToSap");
        InterfaceOutDTO result = new InterfaceOutDTO();
        try {
            SapConnection.initSapConn();
            logger.debug("SAP connection successfully");
        } catch (Exception ex) {
            message = ex.getMessage();
            log.setDescription("Sap Connection Failed:" + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            logger.info(ex);
            result.setStatus("E");
            result.setMsg("SAP Connection failed! Please contact the administrator.");
            return result;
        }
        try {
            JCoDestination destination = JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            JCoFunction function = destination.getRepository().getFunction(rfc_id);

            // 定义输入参数
            JCoParameterList parameterList = function.getTableParameterList();
            JCoTable table = parameterList.getTable("ITEM");
            table.clear();
            for (int i = 0; i < orderNos.length; i++) {
                OdsSoGrInfoDTO odsSoGrInfo = new OdsSoGrInfoDTO();
                odsSoGrInfo.setOrderNo(orderNos[i]);
                odsSoGrInfo.setSapFlag(sapFlag);
                List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.getOdsSoGrInfoListByOGP(odsSoGrInfo);
                if (list != null && list.size() > 0) {
                    for (OdsSoGrInfoDTO dto : list) {
                        table.appendRow();
                        // 销售订单号
                        table.setValue("VBELN", dto.getDnNo());
                        // 行项目
                        table.setValue("POSNR", dto.getDnItemNo());
                        // 时间，参数
                        table.setValue("WADAT_IST", new SimpleDateFormat("yyyyMMdd").format(new Date()));
                        // WMS的编号ID
                        table.setValue("BOLNR", dto.getOrderNo());
                        // 物料号
                        table.setValue("MATNR", dto.getMaterialNo());
                        // 数量
                        table.setValue("LFIMG", dto.getScannedQty());
                        // 工厂
                        table.setValue("WERKS", dto.getPlant());
                        // 库位
                        table.setValue("LGORT", dto.getLocation());
                    }
                    logger.info("Post DN Input========>" + table);

                    // 执行接口，获取输出结果
                    function.execute(destination);
                    JCoTable tableOut = function.getTableParameterList().getTable("OUT");

                    logger.info("Post DN Output========>" + tableOut);
                    OdsSoGrInfoDTO resultDto = new OdsSoGrInfoDTO();
                    resultDto.setDnNo(tableOut.getString("VBELN"));

                    String sapDoc = tableOut.getString("MBLNR");
                    if (StringUtils.isEmpty(sapDoc)) {
                        resultDto.setSapFlag("2");
                        result.setStatus("E");
                        result.setMsg(tableOut.getString("MSG"));
                    } else {
                        resultDto.setSapFlag("1");
                        result.setStatus("S");
                        result.setMsg(tableOut.getString("MSG"));
                    }

                    resultDto.setSapDocNo(tableOut.getString("MBLNR"));
                    resultDto.setSapMsg(tableOut.getString("MSG"));

                    resultDto.setModifyBy(userName);
                    resultDto.setModifyDate(new Date());
                    odsSoGrInfoDAO.updatePostResult(resultDto);

                } else {
                    logger.info("Order:" + orderNos[i] + ", no data to post!");
                    log.setDescription("Order:" + orderNos[i] + ", no data to post!");
                    operationLogDAO.save(log);
                    result.setStatus("E");
                    result.setMsg("No data to post!");
                }
            }
            logger.info("Post DN End========>" + orderNos[0]);
        } catch (Exception e) {
            message = e.getMessage();
            logger.error("Post DN failed: " + e.getMessage());
            log.setDescription("Post DN failed: " + (message.length() <= 1000 ? message : message.substring(0, 1000)));
            operationLogDAO.save(log);
            result.setStatus("E");
            result.setMsg("SAP function execute failed! Please contact the administrator.");
            return result;
        }

        return result;
    }

}
