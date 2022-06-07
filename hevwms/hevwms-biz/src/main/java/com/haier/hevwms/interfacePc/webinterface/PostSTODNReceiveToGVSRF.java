package com.haier.hevwms.interfacePc.webinterface;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.haier.openplatform.showcase.security.dao.OperationLogDAO;
import com.haier.openplatform.showcase.security.domain.OperationLogSaveModel;
import com.haier.openplatform.showcase.util.Env;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.order.dto.StgStoDnDownDTO;
import com.haier.openplatform.wms.order.dto.StgStoDownDTO;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.dao.StgStoDnDownDAO;
import com.haier.hevwms.order.dao.StgStoDownDAO;
import com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS.TransGoodsReceiveFromINDWMSToGVS;
import com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS.ZMMSTRUGRIN;
import com.haier.hevwms.webinterface.PostSTODNReceiveFromYueNanWMSToGVS.ZMMSTRUGROUT;

public class PostSTODNReceiveToGVSRF {

    private static final Logger logger = Logger.getLogger(PostSTODNReceiveToGVSRF.class);
    private static final String SAP_ON = "ON";
    private static final String SAP_FLAG = Env.getProperty(Env.SAP_FLAG);
    private OdsOrderInfoDAO odsOrderInfoDAO;
    private StgStoDnDownDAO stgStoDnDownDAO;
    private StgStoDownDAO stgStoDownDAO;
    private TransGoodsReceiveFromINDWMSToGVS transGoodsReceiveFromINDWMSToGVS;
    private String[] ids;
    private String userNameGet;

    private OperationLogDAO operationLogDAO;//记录SAP返回的数据

    public PostSTODNReceiveToGVSRF(OdsOrderInfoDAO odsOrderInfoDAO,
			StgStoDnDownDAO stgStoDnDownDAO, StgStoDownDAO stgStoDownDAO,
			TransGoodsReceiveFromINDWMSToGVS transGoodsReceiveFromINDWMSToGVS,
			String[] ids, String userNameGet, OperationLogDAO operationLogDAO) {
		super();
		this.odsOrderInfoDAO = odsOrderInfoDAO;
		this.stgStoDnDownDAO = stgStoDnDownDAO;
		this.stgStoDownDAO = stgStoDownDAO;
		this.transGoodsReceiveFromINDWMSToGVS = transGoodsReceiveFromINDWMSToGVS;
		this.ids = ids.clone();
		this.userNameGet = userNameGet;
		this.operationLogDAO = operationLogDAO;
	}

	public PostSTODNReceiveToGVSRF(String poNos, String userName) {
        logger.debug("Entering PostSTODNReceiveToGVSRF, STO_DN_NO: " + poNos + ", USER_NAME: " + userName);
        this.ids = poNos.split(",");
        this.userNameGet = userName;
        odsOrderInfoDAO = SpringApplicationContextHolder.getBean("odsOrderInfoDAO");
        stgStoDnDownDAO = SpringApplicationContextHolder.getBean("stgStoDnDownDAO");
        stgStoDownDAO=SpringApplicationContextHolder.getBean("stgStoDownDAO");
        operationLogDAO=SpringApplicationContextHolder.getBean("operationLogDAO");
        transGoodsReceiveFromINDWMSToGVS = SpringApplicationContextHolder.getBean("transGoodsReceiveFromINDWMSToGVS");
        logger.debug("Exiting PostSTODNReceiveToGVSRF...");
    }

    public PostSTODNReceiveToGVSRF(String[] ids, String userName) {
        logger.debug("Entering PostSTODNReceiveToGVSRF, USER_NAME: " + userName);
        this.ids = ids.clone();
        this.userNameGet = userName;
        odsOrderInfoDAO = SpringApplicationContextHolder
                .getBean("odsOrderInfoDAO");
        stgStoDnDownDAO = SpringApplicationContextHolder
                .getBean("stgStoDnDownDAO");
        stgStoDownDAO=SpringApplicationContextHolder.getBean("stgStoDownDAO");
        operationLogDAO=SpringApplicationContextHolder.getBean("operationLogDAO");
        transGoodsReceiveFromINDWMSToGVS = SpringApplicationContextHolder
                .getBean("transGoodsReceiveFromINDWMSToGVS");
        logger.debug("Exiting PostSTODNReceiveToGVSRF...");
    }

    public String exchangeWithSap() throws Exception {
        logger.debug("Entering exchangeWithSap...");
        if (!SAP_ON.equalsIgnoreCase(SAP_FLAG)) {
            for (int i = 0; i < ids.length; i++) {
                List<OdsOrderInfoDTO> odsOrderInfoList = odsOrderInfoDAO.searchByDnNo(ids[i]);
                if (odsOrderInfoList != null && odsOrderInfoList.size() > 0) {
                    OdsOrderInfoDTO odsInfoWms = new OdsOrderInfoDTO();
                    odsInfoWms.setOrderNo(odsOrderInfoList.get(0).getOrderNo());
                    odsInfoWms.setSapFlag("1");
                    odsInfoWms.setModifyBy(userNameGet);
                    odsInfoWms.setModifyDate(new Date());
                    odsOrderInfoDAO.updateSapByOrderNo(odsInfoWms);
                }

            }
            logger.debug("SAP Flag is OFF, return!");
            return "S";
        }
        logger.debug("The length of IDs = " + ids.length);
        String str = "E";
        List<ZMMSTRUGROUT> orders = null;
        for (int i = 0; i < ids.length; i++) {
            List<OdsOrderInfoDTO> odsOrderInfoList = odsOrderInfoDAO
                    .searchByDnNo(ids[i]);
            if (odsOrderInfoList.size() == 0) {
                logger.debug("No ods_order_info with ORDER_NO: " + ids[i] + ", Continue...");
                continue;
            }
            OdsOrderInfoDTO odsOrderInfoP = odsOrderInfoList.get(0);
            List<ZMMSTRUGRIN> zSTWMSGROTCList = new ArrayList<ZMMSTRUGRIN>();
            for (int n = 0; n < odsOrderInfoList.size(); n++) {
                OdsOrderInfoDTO odsOrderInfo = odsOrderInfoList.get(n);
                ZMMSTRUGRIN zSTWMSGROTC = new ZMMSTRUGRIN();
                //关联出stg_stodn_down表中的俩字段：sto_no 和 sto_item_no,GI_plant,GR_plant,Gi_location,gr_location
                StgStoDnDownDTO stoDn=new StgStoDnDownDTO();
                stoDn.setStoDnNo(odsOrderInfo.getSapOrderNo());
                stoDn.setStoDnItemNo(odsOrderInfo.getSapOrderItem());
                List<StgStoDnDownDTO> stoDnList=stgStoDnDownDAO.getListByParam(stoDn);
                StgStoDnDownDTO des=null;
                if(stoDnList==null || stoDnList.size()==0){
                    logger.error("No stg_stodn_down with STO_DN_NO: " + odsOrderInfo.getSapOrderNo() + " and STO_DN_ITEM_NO: " + odsOrderInfo.getSapOrderItem());
                    return "E,There is no data in table stg_stodn_down!";
                } else{
                    des=stoDnList.get(0);
                    logger.debug("Find record from stg_stodn_down with STO_DN_NO: " + odsOrderInfo.getSapOrderNo() + " and STO_DN_ITEM_NO: " + odsOrderInfo.getSapOrderItem());
                }
                //要从stg_sto_down中关联出来的gr_plant,gr_location
                StgStoDownDTO stgStoDown=new StgStoDownDTO();
                stgStoDown.setStoNo(des.getStoNo());
                stgStoDown.setStoItemNo((des.getStoItemNo()).substring(1));
                List<StgStoDownDTO> list=stgStoDownDAO.getListByParam(stgStoDown);
                StgStoDownDTO dest=null;
                if(list==null || list.size()==0){
                    logger.error("No stg_sto_down with STO_NO: " + des.getStoNo() + " and STO_ITEM_NO: " + (des.getStoItemNo()).substring(1));
                    return "E,There is no data in table stg_sto_down!";
                } else{
                    dest=list.get(0);
                    logger.debug("Find record from stg_sto_down with STO_NO: " + des.getStoNo() + " and STO_ITEM_NO: " + (des.getStoItemNo()).substring(1));
                }

                //开始组织入参
                zSTWMSGROTC.setEBELN(des.getStoNo());
                zSTWMSGROTC.setEBELP((des.getStoItemNo()).substring(1));
                zSTWMSGROTC.setMATNR(odsOrderInfo.getMaterialNo());
                zSTWMSGROTC.setVBELN(odsOrderInfo.getSapOrderNo());
                zSTWMSGROTC.setPOSNR(odsOrderInfo.getSapOrderItem());
                zSTWMSGROTC.setLFIMG(new BigDecimal(odsOrderInfo.getScannedQty()));
                zSTWMSGROTC.setMEINS(odsOrderInfo.getUnit());
                zSTWMSGROTC.setWERKS(dest.getGrPlant());
                zSTWMSGROTC.setLGORT(dest.getGrLocation());

                logger.debug("************* EBELN = " + des.getStoNo());
                logger.debug("************* EBELP = " + (des.getStoItemNo()).substring(1));
                logger.debug("************* MATNR = " + odsOrderInfo.getMaterialNo());
                logger.debug("************* VBELN = " + odsOrderInfo.getSapOrderNo());
                logger.debug("************* POSNR = " + odsOrderInfo.getSapOrderItem());
                logger.debug("************* LFIMG = " + odsOrderInfo.getScannedQty());
                logger.debug("************* MEINS = " + odsOrderInfo.getUnit());
                logger.debug("************* WERKS = " + dest.getGrPlant());
                logger.debug("************* LGORT = " + dest.getGrLocation());

                zSTWMSGROTCList.add(zSTWMSGROTC);
            }
            try {
                orders = transGoodsReceiveFromINDWMSToGVS.transGoodsReceiveFromINDWMSToGVS(zSTWMSGROTCList);

                //插入数据到日志表
                OperationLogSaveModel log=new OperationLogSaveModel();//记录SAP返回的数据实体
                log.setAppName("PostSTODNReceiveToGVSRF");
                log.setUserId(System.currentTimeMillis());//本次任务的唯一标记
                String content="";
                if(orders==null || orders.size()==0){
                    logger.error("ERROR: No result return from SAP...");
                    log.setDescription("ERROR: No result return from SAP...");
                    operationLogDAO.save(log);
                }else{
                    logger.debug("The size of SAP return is: " + orders.size());
                    for(int s=0;s<orders.size();s++){
                        ZMMSTRUGROUT one=orders.get(s);
                        content=one.toString();
                        logger.debug("i = " + s + ", the content of SAP return: " + content);
                        log.setDescription(content);
                        log.setUserName(userNameGet);
                        log.setUserNickName(one.getEBELN());//stodn单号
                        operationLogDAO.save(log);
                    }
                }
            } catch (Exception ex) {
                logger.error("EAI interface error ： " + ex.toString());
                OdsOrderInfoDTO odsInfoERR = new OdsOrderInfoDTO();
                odsInfoERR.setSapFlag("2");
                String mess = "";
                if (ex.toString().length() > 1900) {
                    mess = ex.toString().substring(0, 1900);
                } else {
                    mess = ex.toString();
                }
                odsInfoERR.setSapMsg("EAI interface error" + mess);
                odsInfoERR.setOrderNo(odsOrderInfoP.getOrderNo());
                odsOrderInfoDAO.updateSapToWms(odsInfoERR);
                ex.printStackTrace();
                continue;
            }
            if (orders == null) {
                continue;
            }
            boolean flag=false;
            for (int m = 0; m < orders.size(); m++) {
                ZMMSTRUGROUT outPuts = orders.get(m);
                if (outPuts != null) {
                    logger.debug("********** SAP Return(EBELN): " + outPuts.getEBELN());
                    logger.debug("********** SAP Return(FLAG): " + outPuts.getFLAG());
                    logger.debug("********** SAP Return(MSG): " + outPuts.getMSG());
                    logger.debug("********** SAP Return(MBLNR): " + outPuts.getMBLNR());

                    OdsOrderInfoDTO odsInfoWms = new OdsOrderInfoDTO();
//                    outPuts.getEBELN();
//                    odsInfoWms.setSapOrderNo(outPuts.getVBELN());
                    if ("S".equals(outPuts.getFLAG())||(outPuts.getMBLNR()!=null
                	    &&!"".equals(outPuts.getMBLNR()))) {
                        logger.debug("SAP return SUCCESS...");
                        odsInfoWms.setSapFlag("1");
                        str = "S";
                    } else {
                        logger.debug("SAP return ERROR...");
                        odsInfoWms.setSapFlag("2");
                        flag=true;
                        str="E,"+outPuts.getMSG();
                    }
                    if(outPuts.getMSG()!=null){
                	odsInfoWms.setSapMsg(outPuts.getMSG().replaceAll("/", " ").trim());
                    }
                    odsInfoWms.setSapDocNo(outPuts.getMBLNR());
                    odsInfoWms.setModifyBy(userNameGet);
                    odsInfoWms.setModifyDate(new Date());
                    odsInfoWms.setOrderNo(odsOrderInfoP.getOrderNo());//根据传入的order_no进行SAP过账信息更新
                    try {
                        odsOrderInfoDAO.updateSapByOrderNo(odsInfoWms);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e.toString());
                    }
                }
                if(flag){
                    break;
                }
            }
        }
        logger.debug("Exit exchangeWithSap with result: " + str);
        return str;
    }
}
