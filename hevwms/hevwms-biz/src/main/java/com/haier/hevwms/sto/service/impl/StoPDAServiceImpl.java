package com.haier.hevwms.sto.service.impl;


import com.alibaba.fastjson.JSON;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.sapinterface.PostStoToSap;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.sto.dao.StoPDADAO;
import com.haier.hevwms.sto.service.StoPDAService;
import com.haier.hevwms.util.CommonTool;
import com.haier.hevwms.util.WsIpUtil;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.apache.log4j.Logger;

import javax.xml.ws.WebServiceContext;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StoPDAServiceImpl.java
 * @description: STO 的 PDA 相关功能
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午5:51:20
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public class StoPDAServiceImpl implements StoPDAService {
	
	Logger logger = Logger.getLogger(StoPDAServiceImpl.class);
	private WmsLoginDAO wmsLoginDAO;
	private FileUploadDAO fileUploadDAO;
	private RfLogDAO rfLogDAO;
	
	private StoPDADAO stoPDADAO;
	
	// Get And Set
	public StoPDADAO getStoPDADAO() {
		return stoPDADAO;
	}
	public void setStoPDADAO(StoPDADAO stoPDADAO) {
		this.stoPDADAO = stoPDADAO;
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
	 * 手持STO_权限检查
	 */
	@Override
	public RfLogResult checkSign(String userName, String sign, String version) {
		RfLogResult rfLogResult = new RfLogResult();
		// 判断当前登陆的用户是否存在
		UserDTO user = wmsLoginDAO.getRfUserByName(userName);
		if (null != user) {
//			 首先检查版本号 where t.status=1 and t.file_name like '%HEVWMS_Android%'
//			UploadFile pdaFile = fileUploadDAO.getPdaFileInfo();
//			 检查版本号是否相同
//			if (pdaFile.getVersions().equals(version)) {
				rfLogResult.setStatus("S");
				rfLogResult.setMsg("SUCCESS");
//				return rfLogResult;
//			}
//			rfLogResult.setStatus("FF");
//			rfLogResult.setMsg(pdaFile.getVersions());
		} else {
			rfLogResult.setStatus("F");
			rfLogResult.setMsg("The user does not exist");
		}

		return rfLogResult;
	}

	/**
	 * 手持STO_日志记录
	 */
	@Override
	public void writeLog(String user, String type, String sign,
			WebServiceContext context, String status, String dydate,
			String fhdate, Object rcnr, Object ccnr) {
		RfLog rfLog = new RfLog();
		rfLog.setUserId(user);
		rfLog.setType(type);
		rfLog.setSign(sign);
		if(context != null) {
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
	 * 手持STO_订单删除
	 */
	@Override
	public OrderDeleteOutDTO stoOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		if ("1".equals(in.getOrdertype())){
			stoPDADAO.orderdnDelete(in, out);
		} else {
			stoPDADAO.orderDelete(in, out);
		}
		
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}

	/**
	 * 手持STODN_订单删除
	 */
	@Override
	public OrderDeleteOutDTO stodnOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		stoPDADAO.orderStodnDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}

	/**
	 * 手持STO_扫描
	 */
	@Override
	public OrderUploadOutDTO scanStoCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		stoPDADAO.scanStoCheck(inpara, result);
		return result;
	}

	/**
	 * 手持STODN_条码扫描
	 * stodn 出库
	 * @param inpara
	 * @return
	 */
	@Override
	public OrderUploadOutDTO scanStoDnOutCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		stoPDADAO.scanStoDnOutCheck(inpara, result);
		return result;
	}

	/**
	 * 手持STODN_条码扫描
	 * stodn 入库
	 * @param inpara
	 * @return
	 */
	@Override
	public OrderUploadOutDTO scanStoDnInCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		stoPDADAO.scanStoDnInCheck(inpara, result);
		return result;
	}

	/**
	 * 手持STODN_扫描
	 */
	@Override
	public OrderUploadOutDTO scanStodnCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		stoPDADAO.scanStodnCheck(inpara, result);
		return result;
	}
	
	@Override
	public OrderIgpOutDTO stoOrderOgp(OrderIgpInDTO inpara) {
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if (!CommonTool.isNull(inpara.getPostingdate())) {
			logger.debug("Posting date is: " + inpara.getPostingdate());
			try {
				String currMonth = CommonTool.getCurrentDate("yyyy-MM");
				String postMonth = inpara.getPostingdate().substring(0, 7);
				logger.debug("current month is " + currMonth + ", post month is " + postMonth);
				if (!currMonth.equals(postMonth)) {
					logger.error("Post Date is not in current month, return!");
					outResult.setStatus("F");
					outResult.setMsg("The Posting Date should be in current month, Please correct and submit again. ");
					return outResult;
				}
			} catch (Exception e) {
				e.printStackTrace();
				outResult.setStatus("F");
				outResult.setMsg("Posting Date error, please contact with administrator.");
				return outResult;
			}
		}
		
		stoPDADAO.stoOrderOgp(inpara, outResult);
		return outResult;
	}
	
	@Override
	public OrderIgpOutDTO stodnOrderIgp(OrderIgpInDTO inpara) {
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if (!CommonTool.isNull(inpara.getPostingdate())) {
			logger.debug("Posting date is: " + inpara.getPostingdate());
			try {
				String currMonth = CommonTool.getCurrentDate("yyyy-MM");
				String postMonth = inpara.getPostingdate().substring(0, 7);
				logger.debug("current month is " + currMonth + ", post month is " + postMonth);
				if (!currMonth.equals(postMonth)) {
					logger.error("Post Date is not in current month, return!");
					outResult.setStatus("F");
					outResult.setMsg("The Posting Date should be in current month, Please correct and submit again. ");
					return outResult;
				}
			} catch (Exception e) {
				e.printStackTrace();
				outResult.setStatus("F");
				outResult.setMsg("Posting Date error, please contact with administrator.");
				return outResult;
			}
		}
		
		stoPDADAO.stodnOrderIgp(inpara, outResult);
		return outResult;
	}
	/**
	 * 手持STO_过账
	 */
//	@Override
	public OrderIgpOutDTO stoOrderOgp111(OrderIgpInDTO inpara) {
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if (!CommonTool.isNull(inpara.getPostingdate())) {
			logger.debug("Posting date is: " + inpara.getPostingdate());
			try {
				String currMonth = CommonTool.getCurrentDate("yyyy-MM");
				String postMonth = inpara.getPostingdate().substring(0, 7);
				logger.debug("current month is " + currMonth + ", post month is " + postMonth);
				if (!currMonth.equals(postMonth)) {
					logger.error("Post Date is not in current month, return!");
					outResult.setStatus("F");
					outResult.setMsg("The Posting Date should be in current month, Please correct and submit again. ");
					return outResult;
				}
			} catch (Exception e) {
				e.printStackTrace();
				outResult.setStatus("F");
				outResult.setMsg("Posting Date error, please contact with administrator.");
				return outResult;
			}
		}
		stoPDADAO.stoOrderOgp(inpara, outResult);
		if ("0".equals(outResult.getStatus())) {		
			try {
				InterfaceOutDTO result = new PostStoToSap(outResult.getOrId(), "0", inpara.getUser()).exchangeWithSap();

				if("S".equals(result.getStatus())){
					OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
					stoPDADAO.stoGoodsDelivery(inpara, ret);
					if ("0".equals(ret.getStatus())){
						outResult.setStatus("S");
						outResult.setMsg(ret.getMsg());
					} else {
						outResult.setStatus("F");
						outResult.setMsg(ret.getMsg());
					}
					//TODO 下载dn----------------
				} else {
					outResult.setStatus("F");
					outResult.setMsg("Sto Posting failed!");
				}
			} catch (Exception e) {
				outResult.setStatus("F");
				outResult.setMsg("Sto Posting exception!");
			}
		} else {
			outResult.setStatus("F");
		}
		return outResult;
	}
}
