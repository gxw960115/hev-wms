package com.haier.hevwms.remoting.rf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderCheckDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderLoadDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderLoadIn;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderCheckService;

public class OtcwmsOrderCheckServiceImpl implements OtcwmsOrderCheckService {
    Logger logger = Logger.getLogger(OtcwmsOrderCheckServiceImpl.class);
	private OtcwmsOrderCheckDAO otcwmsOrderCheckDAO;
	private OtcwmsOrderLoadDAO otcwmsOrderLoadDAO;
	private WmsLoginDAO loginDAO;
	
	public void setOtcwmsOrderCheckDAO(OtcwmsOrderCheckDAO otcwmsOrderCheckDAO) {
		this.otcwmsOrderCheckDAO = otcwmsOrderCheckDAO;
	}
	
	public void setOtcwmsOrderLoadDAO(OtcwmsOrderLoadDAO otcwmsOrderLoadDAO) {
		this.otcwmsOrderLoadDAO = otcwmsOrderLoadDAO;
	}

	public void setLoginDAO(WmsLoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	/* (非 Javadoc) 
	* <p>Title: otcwmsOrderCheck</p> 
	* <p>Description: </p> 
	* @param otcwmsOrderCheckIn
	* @return 
	* @see com.haier.hevwms.remoting.rf.service.OtcwmsOrderCheckService#otcwmsOrderCheck(com.haier.hevwms.remoting.rf.domain.order.OtcwmsOrderCheckIn) 
	*/ 
	@Override
    public WmsOrderCheckOut otcwmsOrderCheck(WmsOrderCheckIn otcwmsOrderCheckIn) {
	    logger.debug("Entering otcwmsOrderCheck...");
        WmsOrderCheckOut out = new WmsOrderCheckOut();
        Map<String, String> wlMap = new HashMap<String, String>();
        String ret = "";
        String errorMsg = "";
        UserDTO user = loginDAO.getRfUserByName(otcwmsOrderCheckIn.getUser());  
        
        //added by guolulu 20160513. check the existing of PO for inbound order.
        if ("INBOUND".equalsIgnoreCase(otcwmsOrderCheckIn.getDoctype())) {
            List<StgInboundDownDTO> inboundList = otcwmsOrderCheckDAO.getInbdByOrderNo(otcwmsOrderCheckIn);
            if (inboundList != null && inboundList.size() > 0) {
                logger.debug("The size of inbound is: " + inboundList.size() + ", orderNo: " + otcwmsOrderCheckIn.getOrno());
                
                for (int i = 0; i < inboundList.size(); i++) {
                    StgInboundDownDTO inbound = inboundList.get(i);
                    String poNo = inbound.getPoNo();
                    String poItemNo = inbound.getPoItemNo();
                    StgInboundDownDTO poCheck = new StgInboundDownDTO();
                    poCheck.setPoNo(poNo);
                    poCheck.setInboundItemNo(poItemNo);
                    ret = otcwmsOrderCheckDAO.getPoByOrderNoItem(poCheck);
                    logger.debug("The result is: " + ret + ",  for poNo: " + poNo + " & itemNo: " + poItemNo);
                    if (!"Y".equalsIgnoreCase(ret)) {
                        logger.debug("po check failed, break...");
                        errorMsg = "PO " + poNo + " not exist. Please download it from SAP.";
                        break;
                    }
                    if ("3".equals(user.getDutyType())){
                    	ret = otcwmsOrderCheckDAO.getPoByAvailableWh(poCheck, user.getId());
                        if (!"Y".equalsIgnoreCase(ret)) {
                            logger.debug("po check failed, break...");
                            errorMsg = "This account has no authority to operate PO " + poNo + ". ";
                            break;
                        }
                    }
                }
                if ("Y".equals(ret)){
                	ret = otcwmsOrderCheckDAO.orderCheckScannerInbound(otcwmsOrderCheckIn.getOrno(), user.getId());
                	if (!"Y".equalsIgnoreCase(ret)) {
                        logger.debug("inbound check failed, break...");
                        errorMsg = "This order has been scanned by another user . ";
                    }
                }
            } else {
                errorMsg = "Inbound order " + otcwmsOrderCheckIn.getOrno() + " not exist. Please download it from SAP.";
            }
        } else {
        	if (!"3".equals(user.getDutyType())){
        		ret = otcwmsOrderCheckDAO.orderCheck(otcwmsOrderCheckIn);
        	} else {
        		ret = otcwmsOrderCheckDAO.orderCheckByAvailableWh(otcwmsOrderCheckIn, user.getId());
        	}
            logger.debug("the return value is: " + ret);
        }
        
        WmsOrderLoadIn in = new WmsOrderLoadIn();
        in.setDoctype(otcwmsOrderCheckIn.getDoctype());
        in.setOrdertype(otcwmsOrderCheckIn.getOrdertype());
        in.setOrno(otcwmsOrderCheckIn.getOrno());
        in.setUser(otcwmsOrderCheckIn.getUser());
        
        // sto:Y/N   po:C/R   dn:order type  transfor:Y/N
        if (!"".equals(ret) && null != ret && !"0".equals(ret) && !"N".equals(ret)) {
            // 只判断数量的
            if ("Y".equals(ret)) {
              //  out.setStatus("F");
                out.setStatus("S");
                if ("GIFT".equals(otcwmsOrderCheckIn.getDoctype()) || "SCRAP".equals(otcwmsOrderCheckIn.getDoctype())) {
                    out.setMsg("SUCCESS!");
                } else if ("TRANSFER".equals(otcwmsOrderCheckIn.getDoctype())) {
                	out.setMsg("Submit success!");
	            } else {
	                out.setMsg("Order has been download, please scan!");
                }
                if(!"PD".equals(otcwmsOrderCheckIn.getDoctype())){
                	out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
                    out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
                    if ("3".equals(user.getDutyType())&& ("INBOUND".equals(otcwmsOrderCheckIn.getDoctype())
                    		||"STO".equals(otcwmsOrderCheckIn.getDoctype()))){
                    	otcwmsOrderCheckDAO.updateCurrentScanner(otcwmsOrderCheckIn.getOrno(),otcwmsOrderCheckIn.getDoctype(), user.getId());
                    }
                }else{
                    List<String> locations=otcwmsOrderCheckDAO.getPdLocation(otcwmsOrderCheckIn.getOrno());
                    StringBuffer location = new StringBuffer();
                    for (int i=0;i<locations.size();i++) {
                        location.append(locations.get(i));
                        if(i!=(locations.size()-1)){
                            location.append(",");
                        }
                    }
                    out.setMsg(location.toString());
                    
                    //查询库位对应的物料,库位和物料对应关系返回到前台进行验收条码的前9位是不是物料号  2018/1/19 by yanfd
                    List<String> listWl = new ArrayList<String>();
                    for (int i=0;i<locations.size();i++) {
                    	listWl = otcwmsOrderCheckDAO.getPdMat(otcwmsOrderCheckIn.getOrno(), locations.get(i));
                    	StringBuffer mats = new StringBuffer();
                    	for (int j=0; j<listWl.size(); j++) {
                    		mats.append(listWl.get(j)).append(",");
                    	}
                    	wlMap.put(locations.get(i), mats.toString());
                    }
                    
                    out.setWlMap(wlMap);
                }
            } else {
                // 如果是入库 判断与数据库中状态一直
                if ("1".equals(otcwmsOrderCheckIn.getOrdertype())) {
                    // 与入库相同
                    if ("R".equals(ret)) {
                       // out.setStatus("F");
                        out.setStatus("S");
                        out.setMsg("Submit success, please scan.");
                        out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
                        out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
                        //DN验证要先在pc端完成过账才能扫描
                        /* for DN receipt, no need check SAP flag. 20160518
                        if("DN".equals(otcwmsOrderCheckIn.getDoctype())){
                        	ret=otcwmsOrderCheckDAO.checkDnSapFlag(otcwmsOrderCheckIn);
                        	if("S".equals(ret)){
                        		out.setMsg("Submit success, please scan.");
                        	}else{
                        		out.setStatus("F");
                        		out.setMsg("Please post this order at PC first!");
                        	}
                        }
                        */
                    }else if("SRN".equals(otcwmsOrderCheckIn.getDnType())){//dn 退货给供应商ZRE，换货类型ZRP，退货给工厂ZRSB
	                	if("SRN".equals(ret)){//与手持传来的类型一致才行
	                	    out.setStatus("S");
	                	    out.setMsg("Submit success, please scan.");
	                	    out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
	                        out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
	                	}else if("ConPickUp".equals(ret)){
	                	    out.setStatus("F");
	                	    out.setMsg("This Order is Con.Pick-up");
	                	}else{
	                	    out.setStatus("F");
	                	    out.setMsg("This is order for goods delivery, plase operate " +
	                        		"with [Billing] or [Con. Issue].");
	                	}
                    }else if("ConPickUp".equals(otcwmsOrderCheckIn.getDnType())){//寄售到非限制 ZKA
	                	if("ConPickUp".equals(ret)){
	                	    out.setStatus("S");
	                	    out.setMsg("Submit success, please scan.");
	                	    out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
	                        out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
	                	}else if("SRN".equals(ret)){
	                	    out.setStatus("F");
	                	    out.setMsg("This Order is SRN");
	                	}else{
	                	    out.setStatus("F");
	                	    out.setMsg("This is order for goods delivery, plase operate " +
	                        		"with [Billing] or [Con. Issue].");
	                	}
                    }
                    else {
                        out.setStatus("F");
                        out.setMsg("This order is GI,Plase [" + otcwmsOrderCheckIn.getDoctype() + " GI]");
                    }
                } else if ("2".equals(otcwmsOrderCheckIn.getOrdertype())) {
                    // 如果是出库
                    if ("C".equals(ret)) {
                        //out.setStatus("F");
                        out.setStatus("S");
                        out.setMsg("Submit success, please scan.");
                        out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
                        out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
//                        //DN验证要先在pc端完成过账才能扫描
//                        if("DN".equals(otcwmsOrderCheckIn.getDoctype())){
//                        	ret=otcwmsOrderCheckDAO.checkDnSapFlag(otcwmsOrderCheckIn);
//                        	if("S".equals(ret)){
//                        		out.setMsg("Submit success, please scan.");
//                        	}else{
//                        		out.setStatus("F");
//                        		out.setMsg("Order not submit. Please go to portal side [DN Detail] tab to post this order before submit.");
//                        	}
//                        }
                    } else if("Billing".equals(otcwmsOrderCheckIn.getDnType())){//billing类型，ZSO，ZFO，ZFD, ZIDS(不良品)
	                	if("Billing".equals(ret)){
	                		//DN验证完成过账才能扫描
	                	    ret=otcwmsOrderCheckDAO.checkDnSapFlag(otcwmsOrderCheckIn);
	                	    if("S".equals(ret)){
		                		out.setStatus("S");
		                		out.setMsg("Submit success, please scan.");
		                		out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
		                		out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
	                	    }else{
		                		out.setStatus("F");
		                		out.setMsg("This order has posted at SAP first.");
	                	    }
	                	}else if("ConIssue".equals(ret)){
	                	    out.setStatus("F");
	                	    out.setMsg("This Order is Con.Issue");
	                	}else{
	                	    out.setStatus("F");
	                            out.setMsg("This is order for goods receive, plase operate " +
	                            		"with [SRN] or [Con. Pick-up].");
	                	}
                    } else if("ConIssue".equals(otcwmsOrderCheckIn.getDnType())){//非限制到寄售 ZKB
	                	if("ConIssue".equals(ret)){
	                	    out.setStatus("S");
	                	    out.setMsg("Submit success, please scan.");
	                	    out.setRequiredQty(otcwmsOrderCheckDAO.getRequiredTotalQty(otcwmsOrderCheckIn));
	                            out.setWlList(otcwmsOrderLoadDAO.otcwmsGetWlList(in));
	                	}else if("Billing".equals(ret)){
	                	    out.setStatus("F");
	                	    out.setMsg("This Order is Billing");
	                	}else {
	                            out.setStatus("F");
	                            out.setMsg("This is order for goods receive, plase operate with [SRN] or [Con. Pick-up].");
                        }
                	} else {
                        out.setStatus("F");
                        out.setMsg("This is order for goods receive, plase operate with [SRN] or [Con. Pick-up].");
                    }
                }
                if ("3".equals(user.getDutyType())&& ("DN".equals(otcwmsOrderCheckIn.getDoctype())
                		||"PO".equals(otcwmsOrderCheckIn.getDoctype()))){
                	otcwmsOrderCheckDAO.updateCurrentScanner(otcwmsOrderCheckIn.getOrno(),otcwmsOrderCheckIn.getDoctype(), user.getId());
                }
                
            }
        } else {
            //out.setStatus("S");
            out.setStatus("F");
            if ("GIFT".equals(otcwmsOrderCheckIn.getDoctype())
                    || "SCRAP".equals(otcwmsOrderCheckIn.getDoctype())
                    || "PD".equalsIgnoreCase(otcwmsOrderCheckIn.getDoctype())
                    || "TRANSFER".equalsIgnoreCase(otcwmsOrderCheckIn.getDoctype())) {
                out.setMsg("Order doesn't exsit or insufficient privilege. Please check.");
            } else if (StringUtils.isNotEmpty(errorMsg)) {
                out.setMsg(errorMsg);
            } else {
                out.setMsg("Order isn't downloaded or insufficient privilege. Please check.");
            }
        }
        /*
         * OdsIndoorInfo oi = new OdsIndoorInfo(); oi.setCreateDate(new Date());
         * out.setCarlist(odsIndoorInfoDAO.getCarList(oi));
         */
        return out;
    }
}
