package com.haier.hevwms.consume.service.impl;

import javax.xml.ws.WebServiceContext;

import com.alibaba.fastjson.JSON;
import com.haier.hevwms.consume.dao.ConsumePDADAO;
import com.haier.hevwms.consume.service.ConsumePDAService;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.util.WsIpUtil;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: ConsumePDAServiceImpl.java
 * @description: Consume 的 PDA 相关功能
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午5:51:20
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public class ConsumePDAServiceImpl implements ConsumePDAService {
    private WmsLoginDAO wmsLoginDAO;
    private FileUploadDAO fileUploadDAO;
    private RfLogDAO rfLogDAO;

    private ConsumePDADAO consumePDADAO;

    public ConsumePDADAO getConsumePDADAO() {
        return consumePDADAO;
    }

    public void setConsumePDADAO(ConsumePDADAO consumePDADAO) {
        this.consumePDADAO = consumePDADAO;
    }

    public WmsLoginDAO getWmsLoginDAO() {
        return wmsLoginDAO;
    }

    public void setWmsLoginDAO(WmsLoginDAO wmsLoginDAO) {
        this.wmsLoginDAO = wmsLoginDAO;
    }

    public FileUploadDAO getFileUploadDAO() {
        return fileUploadDAO;
    }

    public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
        this.fileUploadDAO = fileUploadDAO;
    }

    public RfLogDAO getRfLogDAO() {
        return rfLogDAO;
    }

    public void setRfLogDAO(RfLogDAO rfLogDAO) {
        this.rfLogDAO = rfLogDAO;
    }

    /**
     * 手持Consume_权限检查
     */
    @Override
    public RfLogResult checkSign(String userName, String sign, String version) {
        RfLogResult rfLogResult = new RfLogResult();
        // 判断当前登陆的用户是否存在
        UserDTO user = wmsLoginDAO.getRfUserByName(userName);
        if (null != user) {
//             首先检查版本号 where t.status=1 and t.file_name like '%HEVWMS_Android%'
//            UploadFile pdaFile = fileUploadDAO.getPdaFileInfo();
//             检查版本号是否相同
//            if (pdaFile.getVersions().equals(version)) {
                rfLogResult.setStatus("S");
                rfLogResult.setMsg("SUCCESS");
//                return rfLogResult;
//            }
//            rfLogResult.setStatus("FF");
//            rfLogResult.setMsg(pdaFile.getVersions());
        } else {
            rfLogResult.setStatus("F");
            rfLogResult.setMsg("The user does not exist");
        }

        return rfLogResult;
    }

    /**
     * 手持Consume_日志记录
     */
    @Override
    public void writeLog(String user, String type, String sign,
                         WebServiceContext context, String status, String dydate,
                         String fhdate, Object rcnr, Object ccnr) {
        RfLog rfLog = new RfLog();
        rfLog.setUserId(user);
        rfLog.setType(type);
        rfLog.setSign(sign);
        if (context != null) {
            rfLog.setIp(WsIpUtil.getRemoteIp(context));
        }
        rfLog.setStatus(status);
        rfLog.setDydate(dydate);
        rfLog.setFhdate(fhdate);
        rfLog.setRcnr(JSON.toJSONString(rcnr));
        rfLog.setCcnr(JSON.toJSONString(ccnr));
        rfLogDAO.writeLog(rfLog);
    }

    /**
     * 手持Consume_订单删除
     */
    @Override
    public OrderDeleteOutDTO consumeOrderDelete(OrderDeleteInDTO in) {
        OrderDeleteOutDTO out = new OrderDeleteOutDTO();
        consumePDADAO.orderDelete(in, out);
        if ("0".equals(out.getStatus())) {
            out.setStatus("S");
        } else {
            out.setStatus("F");
        }
        return out;
    }

    /**
     * 手持Consume_扫描
     */
    @Override
    public OrderUploadOutDTO scanConsumeCheck(OrderUploadInDTO inParam) {
        OrderUploadOutDTO result = new OrderUploadOutDTO();
        consumePDADAO.scanConsumeCheck(inParam, result);
        return result;
    }

    /**
     * 手持Consume_过账
     */
    @Override
    public WmsOrderIgpOut consumeOrderIgp(WmsOrderIgpIn in) {
        WmsOrderIgpOut out = new WmsOrderIgpOut();
        consumePDADAO.consumeOrderIgp(in, out);
        return out;
    }

    @Override
    public long scanStatus(String orno) {
        return consumePDADAO.scanStatus(orno);
    }

    @Override
    public void updateSapInfo(OrderIgpInDTO inpara) {
        consumePDADAO.updateSapInfo(inpara);
    }
}
