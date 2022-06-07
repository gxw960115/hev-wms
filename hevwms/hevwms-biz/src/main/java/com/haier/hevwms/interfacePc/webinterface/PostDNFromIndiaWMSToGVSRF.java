package com.haier.hevwms.interfacePc.webinterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.openplatform.showcase.security.dao.OperationLogDAO;
import com.haier.openplatform.showcase.security.domain.OperationLogSaveModel;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.showcase.util.Env;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.order.dto.StgDnDownDTO;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.dao.StgDnDownDAO;
import com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS.TransGoodsIssueFromINDWMSToGVS;
import com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS.ZSDWMSTOPGIITEM;
import com.haier.hevwms.webinterface.PostDNFromYueNanWmsToGVS.ZSDWMSTOPGIOUT;

public class PostDNFromIndiaWMSToGVSRF {
    private static final Logger logger = Logger.getLogger(PostDNFromIndiaWMSToGVSRF.class);
    private static final String SAP_ON = "ON";
    private static final String SAP_FLAG = Env.getProperty(Env.SAP_FLAG);
    private StgDnDownDAO stgDnDownDAO;
    private OdsOrderInfoDAO odsOrderInfoDAO;
    private OperationLogDAO operationLogDAO;//记录SAP返回的数据
    private TransGoodsIssueFromINDWMSToGVS transGoodsIssueFromINDWMSToGVS;
    private String[] ids;
    private String userName;
    private long a ;
    private long b;
    private long c;
    private long d;
    
    public PostDNFromIndiaWMSToGVSRF(StgDnDownDAO stgDnDownDAO,
			OdsOrderInfoDAO odsOrderInfoDAO, OperationLogDAO operationLogDAO,
			TransGoodsIssueFromINDWMSToGVS transGoodsIssueFromINDWMSToGVS,
			String[] ids, String userName) {
		super();
		this.stgDnDownDAO = stgDnDownDAO;
		this.odsOrderInfoDAO = odsOrderInfoDAO;
		this.operationLogDAO = operationLogDAO;
		this.transGoodsIssueFromINDWMSToGVS = transGoodsIssueFromINDWMSToGVS;
		this.ids = ids.clone();
		this.userName = userName;
	}

	public PostDNFromIndiaWMSToGVSRF(String dnNos,String userName) {
        //传的是ods_order_info中的order_no
        logger.info("Entering PostDNFromIndiaWMSToGVSRF, DN_NO = " + dnNos + ", User_Name: " + userName);
        this.ids = dnNos.split(",");
        this.userName=userName;
        
        stgDnDownDAO = SpringApplicationContextHolder.getBean("stgDnDownDAO");
        operationLogDAO=SpringApplicationContextHolder.getBean("operationLogDAO");
        odsOrderInfoDAO = SpringApplicationContextHolder.getBean("odsOrderInfoDAO");
        transGoodsIssueFromINDWMSToGVS = SpringApplicationContextHolder.getBean("transGoodsIssueFromINDWMSToGVS");
        
        logger.info("Exiting PostDNFromIndiaWMSToGVSRF...");
    }
    
    public String exchangeWithSap(){
        logger.info("=====Enter exchangeWithSap. The size of parameter order_no: " + ids.length+"=====");
        a = System.currentTimeMillis();
        logger.info("SAP_ON:"+SAP_ON+";  SAP_FLAG:"+SAP_FLAG);
        if (!SAP_ON.equalsIgnoreCase(SAP_FLAG)) {
            for (int i = 0; i < ids.length; i++) {
                List<OdsOrderInfoDTO> odsOrderInfoList = odsOrderInfoDAO.searchByDnNo(ids[i]);
                if (odsOrderInfoList != null && odsOrderInfoList.size() > 0) {
                    OdsOrderInfoDTO odsInfoWms = new OdsOrderInfoDTO();
                    odsInfoWms.setSapOrderNo(odsOrderInfoList.get(0).getSapOrderNo());
                    odsInfoWms.setSapFlag("1");
                    odsInfoWms.setModifyBy(userName);
                    odsInfoWms.setModifyDate(new Date());
                    odsOrderInfoDAO.updateSapBackMsgOfDn(odsInfoWms);
                }
            }
            logger.info("SAP Flag is OFF, return!");
            return "S";
        }
        String str="S";
        
        List<ZSDWMSTOPGIOUT> result = null;
        List<ZSDWMSTOPGIITEM> item = new ArrayList<ZSDWMSTOPGIITEM>();
        
        for (int i = 0; i < ids.length; i++) {
            String dnNo = odsOrderInfoDAO.getDnByOrderNo(ids[i]);
            List<StgDnDownDTO> list = stgDnDownDAO.getListByDn(dnNo);
            logger.info("i=" + i + ", order_no = " + ids[i] + ", dn_no = " + dnNo);
            
            if (list != null && list.size() != 0) {
                String flag = list.get(0).getSapFlag();
                logger.info("The size of records in stg_dn_down: " + list.size() + ", SAP_FLAG = " + flag);
                
                if ("0".equals(flag)) {
                    // RF端扫描，汇总，过账
                    OdsOrderInfoDTO odsInfoWms = new OdsOrderInfoDTO();
                    odsInfoWms.setOrderNo(ids[i]);
                    List<OdsOrderInfoDTO> orders = odsOrderInfoDAO.getListByParam(odsInfoWms);
                    if (orders == null || orders.size() == 0) {
                        logger.error("No record found from ods_order_info by order_no " + ids[i]);
                        str = "E,Please Complete Igp/Ogp First!";
                        continue;
                    } else {
                        logger.info("The size of records in ods_order_info by order_no " + ids[i] + " is " + orders.size());
                    }
//                    OdsOrderInfoDTO p = orders.get(0);
                    for (int k = 0; k < orders.size(); k++) {
                        OdsOrderInfoDTO odsOrderInfo = orders.get(k);
                        ZSDWMSTOPGIITEM zSDWMSTOPGIITEM = new ZSDWMSTOPGIITEM();
                        zSDWMSTOPGIITEM.setVBELN(odsOrderInfo.getSapOrderNo());
                        try {
                            String sdate = odsOrderInfo.getPostingDate();
                            if (sdate != null && sdate.length() == 19) {
                                sdate = DataFormat.formatDate(DataFormat.parseDate(sdate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd");
                            }
                            zSDWMSTOPGIITEM.setWADATIST(sdate);
                            logger.info("k = " + k + "***** POSTING_DT(WADATIST) " + sdate);
                        } catch (Exception e) {
                            zSDWMSTOPGIITEM.setWADATIST(odsOrderInfo.getPostingDate());
                            logger.info("k = " + k + "***** POSTING_DT(WADATIST) " + odsOrderInfo.getPostingDate());
                            e.printStackTrace();
                        }
                        zSDWMSTOPGIITEM.setPOSNR(odsOrderInfo.getSapOrderItem());
                        zSDWMSTOPGIITEM.setWERKS(odsOrderInfo.getPlant());
                        zSDWMSTOPGIITEM.setMATNR(odsOrderInfo.getMaterialNo());
                        zSDWMSTOPGIITEM.setLGORT(odsOrderInfo.getLocation());
                        BigDecimal qty = new BigDecimal(odsOrderInfo.getScannedQty());
                        zSDWMSTOPGIITEM.setLFIMG(qty);
                        
                        logger.info("k = " + k + "***** SAP_ORDER_NO(VBELN) " + odsOrderInfo.getSapOrderNo());
                        logger.info("k = " + k + "***** SAP_ORDER_ITEM(POSNR) " + odsOrderInfo.getSapOrderItem());
                        logger.info("k = " + k + "***** PLANT(WERKS) " + odsOrderInfo.getPlant());
                        logger.info("k = " + k + "***** MATERIAL_NO(MATNR) " + odsOrderInfo.getMaterialNo());
                        logger.info("k = " + k + "***** LOCATION(LGORT) " + odsOrderInfo.getLocation());
                        logger.info("k = " + k + "***** SCAN_QTY(LFIMG) " + qty);
                        item.add(zSDWMSTOPGIITEM);
                    }
                    
                    // 插入数据到日志表
                    OperationLogSaveModel log = new OperationLogSaveModel();// 记录SAP返回的数据实体
                    log.setAppName("PostDNFromIndiaWMSToGVSRF");
//                  log.setUserId(System.currentTimeMillis());// 本次任务的唯一标记
                    log.setActualData(ids[i]);
                    String content = "";
                    
                    try {
                        logger.info("======Start to trans data with SAP...");
                        b = System.currentTimeMillis();
                        result = transGoodsIssueFromINDWMSToGVS.transGoodsIssueFromINDWMSToGVS(item);
                        c = System.currentTimeMillis();
                        
                    } catch (Exception e) {
                    	c = System.currentTimeMillis();
                        logger.error("SAP interface error: " + e.toString());
                        OdsOrderInfoDTO odsInfoERR = new OdsOrderInfoDTO();
                        odsInfoERR.setSapFlag("2");
                        String mess = "";
                        if (e.toString().length() > 1900) {
                            mess = e.toString().substring(0, 1900);
                        } else {
                            mess = e.toString();
                        }
                        odsInfoERR.setSapMsg("SAP interface error: " + mess);
                        // odsInfoERR.setRowId(p.getRowId());
                        odsInfoERR.setSapOrderNo(ids[i]);
                        odsOrderInfoDAO.updateSapBackMsgOfDn(odsInfoERR);
                        
                        log.setDescription("SAP interface error: " + mess);
                        operationLogDAO.save(log);
                        
                        logger.error("SAP post error, Exiting exchangeWithSap...");
                        e.printStackTrace();
                        return "E, SAP post error, please contact with system administrator.";
                        
                    }
                    
                    if (result == null || result.size() == 0) {
                        logger.error("Post To SAP but No Return Msg, Exiting exchangeWithSap...");
                        log.setDescription("ERROR: No result return from SAP...");
                        operationLogDAO.save(log);
                        return "E, Post To SAP but No Return Msg";
                    }
                    
                    logger.info("The size of return from SAP = " + result.size());
                    for (int m = 0; m < result.size(); m++) {
                        ZSDWMSTOPGIOUT zSDWMSTOPGIOUT = result.get(m);
                        
                        logger.info("m = " + m + "********** SAP Return(VBELN): " + zSDWMSTOPGIOUT.getVBELN());
                        logger.info("m = " + m + "********** SAP Return(FLAG): " + zSDWMSTOPGIOUT.getFLAG());
                        logger.info("m = " + m + "********** SAP Return(MSG): " + zSDWMSTOPGIOUT.getMSG());
                        logger.info("m = " + m + "********** SAP Return(MBLNR): " + zSDWMSTOPGIOUT.getMBLNR());
                        
                        OdsOrderInfoDTO dto = new OdsOrderInfoDTO();
                        dto.setModifyBy(userName);// temporary
                        dto.setModifyDate(new Date());
                        if ("S".equals(zSDWMSTOPGIOUT.getFLAG()) || (zSDWMSTOPGIOUT.getMBLNR() != null && !"".equals(zSDWMSTOPGIOUT.getMBLNR()))) {
                            logger.info("SAP return SUCCESS...");
                            str = "S";
                            dto.setSapOrderNo(zSDWMSTOPGIOUT.getVBELN());
                            dto.setSapFlag("1");
                            dto.setSapDocNo(zSDWMSTOPGIOUT.getMBLNR());
                            if(zSDWMSTOPGIOUT.getMSG()!=null){
                        	dto.setSapMsg(zSDWMSTOPGIOUT.getMSG().replaceAll("/", " ").trim());
                            }
                            try {
                                odsOrderInfoDAO.updateSapBackMsgOfDn(dto);
                                
                                content = zSDWMSTOPGIOUT.toString();
                                log.setDescription(content);// 记录SAP返回的所有字段的内容
                                log.setUserNickName(zSDWMSTOPGIOUT.getVBELN());// 记录DN单号
                                log.setUserName(userName);
                                operationLogDAO.save(log);
                                
                            } catch (Exception es) {
                                logger.error("Catch Unknown Exception when update ORS_ORDER_INFO or OPERATION_LOG...");
                                es.printStackTrace();
                            }
                            
                        } else {
                            logger.error("SAP PGI Failed...");
                            try {
                                dto.setSapOrderNo(zSDWMSTOPGIOUT.getVBELN());
                                dto.setSapFlag("2");
                                dto.setSapDocNo(zSDWMSTOPGIOUT.getMBLNR());
                                if (zSDWMSTOPGIOUT.getMSG()!=null) {
                                    dto.setSapMsg(zSDWMSTOPGIOUT.getMSG().replaceAll("/", " ").trim());
                                }
                                odsOrderInfoDAO.updateSapBackMsgOfDn(dto);
                                
                                content = zSDWMSTOPGIOUT.toString();
                                log.setDescription(content);// 记录SAP返回的所有字段的内容
                                log.setUserNickName(zSDWMSTOPGIOUT.getVBELN());// 记录DN单号
                                log.setUserName(userName);
                                operationLogDAO.save(log);
                            } catch (Exception es) {
                                logger.error("Catch Unknown Exception when update ORS_ORDER_INFO or OPERATION_LOG...");
                                es.printStackTrace();
                            }
                            
                            logger.error("Post To SAP but fail,Dn_No:"+dto.getSapOrderNo()+",sap_msg:"+zSDWMSTOPGIOUT.getMSG()
                            						+", Exiting exchangeWithSap...");
                            return "E," + zSDWMSTOPGIOUT.getMSG();
                        }
                        
                    }
                } else if ("1".equals(flag)) {// 先通过PC端过账了；不调用过账接口，直接更新ods_order_info中的状态
                    odsOrderInfoDAO.updateSAPFlagByOrderNo(ids[i]);
                    String docNoOfSAP=list.get(0).getSapDocNo();//把dn的docno也更过去，sunyanfei
                    odsOrderInfoDAO.updateDocNoOfDN(ids[i], docNoOfSAP);
                } else {// 如果过账失败不允许通过手持进行过账
                    str = "E,Please Post At PC when Post Failed";
                }
            } else {
                // 说明这个订单号有问题，理论上stg_dn_down中肯定会存在这个DN的
                logger.error("No record found in stg_dn_down by DN_NO: " + dnNo + ", please check!");
                str = "E, Order errors, please contact with system administrator.";
            }
        }
        d = System.currentTimeMillis();
        logger.info("Interface takes time: " +(c-b)+"ms");
        logger.info("WMS takes time: " +(d-a)+"ms");
        logger.info("======Exiting exchangeWithSap with message : " + str+"=======");
        return str;
    }
}
