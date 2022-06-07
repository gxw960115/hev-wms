package com.haier.hevwms.po.service.impl;

import javax.xml.ws.WebServiceContext;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.haier.hevwms.po.dao.PoPDADAO;
import com.haier.hevwms.po.service.PoPDAService;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.util.CommonTool;
import com.haier.hevwms.util.WsIpUtil;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: PoPDAServiceImpl.java
 * @description: Po PDA Service
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午3:18:43
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public class PoPDAServiceImpl implements PoPDAService {

	Logger logger = Logger.getLogger(PoPDAServiceImpl.class);
	private WmsLoginDAO wmsLoginDAO;
	private FileUploadDAO fileUploadDAO;
	private RfLogDAO rfLogDAO;
	
	private PoPDADAO poPDADAO;
	
	public RfLogDAO getRfLogDAO() {
		return rfLogDAO;
	}

	public void setRfLogDAO(RfLogDAO rfLogDAO) {
		this.rfLogDAO = rfLogDAO;
	}

	public FileUploadDAO getFileUploadDAO() {
		return fileUploadDAO;
	}

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
		this.fileUploadDAO = fileUploadDAO;
	}

	public PoPDADAO getPoPDADAO() {
		return poPDADAO;
	}

	public void setPoPDADAO(PoPDADAO poPDADAO) {
		this.poPDADAO = poPDADAO;
	}

	public WmsLoginDAO getWmsLoginDAO() {
		return wmsLoginDAO;
	}

	public void setWmsLoginDAO(WmsLoginDAO wmsLoginDAO) {
		this.wmsLoginDAO = wmsLoginDAO;
	}

	/**
	 * 手持签名校验
	 */
	@Override
	public RfLogResult checkSign(String userName, String sign, String version) {
		RfLogResult rfLogResult = new RfLogResult();
		
		// 判断当前登陆的用户是否存在
		UserDTO user = wmsLoginDAO.getRfUserByName(userName);
		if (null != user) {
//			 首先检查版本号 where t.status=1 and t.file_name like '%HEVWMS_Android%'
//			UploadFile pdaFile= fileUploadDAO.getPdaFileInfo();
//			 检查版本号是否相同
//			if(pdaFile.getVersions().equals(version)){
				rfLogResult.setStatus("S");
				rfLogResult.setMsg("SUCCESS");
//				return rfLogResult;
//			}
//			rfLogResult.setStatus("FF");
//			rfLogResult.setMsg(pdaFile.getVersions());
		}else{
			rfLogResult.setStatus("F");
			rfLogResult.setMsg("The user does not exist");
		}
		
		return rfLogResult;
	}

	@Override
	public void writeLog(String user, String type, String sign, WebServiceContext context, String status,
			String dydate, String fhdate, Object rcnr, Object ccnr) {
		
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
	 * PO扫描单  删除
	 */
	@Override
	public OrderDeleteOutDTO poOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		poPDADAO.orderDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}
	
	/**
	 * PO扫描单  删除
	 */
	@Override
	public OrderDeleteOutDTO giftPoOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		poPDADAO.giftPoOrderDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}

	/**
	 * 手持_扫描
	 */
	@Override
	public OrderUploadOutDTO scanPoCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		if(CommonTool.isNull(inpara.getQty())||"0".equals(inpara.getQty()))
		{
			inpara.setQty("1");
		}
		poPDADAO.scanPoCheck(inpara, result);
		return result;
	}
	
	/**
	 * 手持_扫描
	 */
	@Override
	public OrderUploadOutDTO scanGiftPoCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		poPDADAO.scanGiftPoCheck(inpara, result);
		return result;
	}
	
	/* (non-Javadoc)  
	 * <p>Title: poOrderIgp</p>  
	 * <p>Description:汇总 </p>  
	 * @param inpara
	 * @return  
	 * @see com.haier.hevwms.po.service.PoPDAService#poOrderIgp(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO)  
	 */
	@Override
	public OrderIgpOutDTO poOrderIgp(OrderIgpInDTO inpara) {
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
		
		poPDADAO.poOrderIgp(inpara, outResult);
		return outResult;
		
	}
	
	/* (非 Javadoc) 
	* <p>Title: giftPoOrderIgp</p> 
	* <p>Description: </p> 
	* @param inpara
	* @return 
	* @see com.haier.hevwms.po.service.PoPDAService#giftPoOrderIgp(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
	*/
	@Override
	public OrderIgpOutDTO giftPoOrderIgp(OrderIgpInDTO inpara) {
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
		
		poPDADAO.giftPoOrderIgp(inpara, outResult);
		return outResult;
		
	}


}
