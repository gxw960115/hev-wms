package com.haier.hevwms.scrap.service.impl;

import javax.xml.ws.WebServiceContext;

import com.alibaba.fastjson.JSON;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.scrap.dao.ScrapPDADAO;
import com.haier.hevwms.scrap.service.ScrapPDAService;
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
 * @className: ScrapPDAServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月13日 上午10:14:32
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月13日		LJZ			v1.0.0			create
 */

public class ScrapPDAServiceImpl implements ScrapPDAService {
	private WmsLoginDAO wmsLoginDAO;
	private FileUploadDAO fileUploadDAO;
	private RfLogDAO rfLogDAO;
	
	private ScrapPDADAO scrapPDADAO;

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

	public ScrapPDADAO getScrapPDADAO() {
		return scrapPDADAO;
	}
	public void setScrapPDADAO(ScrapPDADAO scrapPDADAO) {
		this.scrapPDADAO = scrapPDADAO;
	}
	
	/**
	 * 手持Scrap_权限检查
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
	 * 手持Scrap_日志记录
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
	 * 手持Scrap_订单删除
	 */
	@Override
	public OrderDeleteOutDTO scrapOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		scrapPDADAO.orderDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}

	/**
	 * 手持Scrap_扫描
	 */
	@Override
	public OrderUploadOutDTO scanScrapCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		scrapPDADAO.scanScrapCheck(inpara, result);
		return result;
	}

	/**
	 * 手持Scrap_过账
	 */
	/* (non-Javadoc)
	 * @see com.haier.hevwms.scrap.service.ScrapPDAService#scrapOrderIgp(com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn)
	 */
	@Override
	public WmsOrderIgpOut scrapOrderIgp(WmsOrderIgpIn in) {
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		scrapPDADAO.scrapOrderIgp(in, out);
		return out;
	}
	/* (non-Javadoc)
	 * @see com.haier.hevwms.scrap.service.ScrapPDAService#scanStatus(java.lang.String)
	 */
	@Override
	public long scanStatus(String orno) {
		return scrapPDADAO.scanStatus(orno);
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.scrap.service.ScrapPDAService#updateSapInfo(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO)
	 */
	@Override
	public void updateSapInfo(OrderIgpInDTO inpara) {
		scrapPDADAO.updateSapInfo(inpara);
	}
}
