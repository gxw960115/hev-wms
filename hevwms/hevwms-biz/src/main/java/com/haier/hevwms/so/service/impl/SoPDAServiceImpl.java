package com.haier.hevwms.so.service.impl;

import javax.xml.ws.WebServiceContext;

import com.alibaba.fastjson.JSON;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.so.dao.SoPDADAO;
import com.haier.hevwms.so.service.SoPDAService;
import com.haier.hevwms.util.CommonTool;
import com.haier.hevwms.util.WsIpUtil;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.apache.log4j.Logger;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: SoPDAServiceImpl.java
 * @description: SO 的 PDA 相关功能
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午5:50:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public class SoPDAServiceImpl implements SoPDAService {
	private Logger logger = Logger.getLogger(SoPDAServiceImpl.class);

	private WmsLoginDAO wmsLoginDAO;
	private FileUploadDAO fileUploadDAO;
	private RfLogDAO rfLogDAO;
	
	private SoPDADAO soPDADAO;

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

	public WmsLoginDAO getWmsLoginDAO() {
		return wmsLoginDAO;
	}

	public void setWmsLoginDAO(WmsLoginDAO wmsLoginDAO) {
		this.wmsLoginDAO = wmsLoginDAO;
	}
	
	public SoPDADAO getSoPDADAO() {
		return soPDADAO;
	}

	public void setSoPDADAO(SoPDADAO soPDADAO) {
		this.soPDADAO = soPDADAO;
	}

	/**
	 * 手持SO_权限检查
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
//			if(pdaFile.getVersions().equals(version)) {
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
	 * 手持SO_日志记录
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
	 * 手持SO_订单删除
	 */
	@Override
	public OrderDeleteOutDTO soOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		soPDADAO.orderDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}
	
	/**
	 * 手持SO_订单删除
	 */
	@Override
	public OrderDeleteOutDTO giftSoOrderDelete(OrderDeleteInDTO in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		soPDADAO.giftSoOrderDelete(in, out);
		if ("0".equals(out.getStatus())) {
			out.setStatus("S");
		} else {
			out.setStatus("F");
		}
		return out;
	}

	/**
	 * 手持SO_扫描
	 */
	@Override
	public OrderUploadOutDTO scanSoCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		if(CommonTool.isNull(inpara.getQty())||"0".equals(inpara.getQty()))
		{
			inpara.setQty("1");
		}
		soPDADAO.scanSoCheck(inpara, result);
		return result;
	}

	@Override
	public OrderUploadOutDTO scanSoOldBarcodeCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		if(CommonTool.isNull(inpara.getQty())||"0".equals(inpara.getQty()))
		{
			inpara.setQty("1");
		}
		soPDADAO.scanSoOldBarcodeCheck(inpara, result);
		return result;
	}
	
	/**
	 * 手持SO_扫描
	 */
	@Override
	public OrderUploadOutDTO scanGiftSoCheck(OrderUploadInDTO inpara) {
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		if(CommonTool.isNull(inpara.getQty())||"0".equals(inpara.getQty()))
		{
			inpara.setQty("1");
		}
		soPDADAO.scanGiftSoCheck(inpara, result);
		return result;
	}
	
	/**
	 * 手持SO_过账
	 */
	@Override
	public OrderIgpOutDTO soOrderIgp(OrderIgpInDTO inpara) {
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if (inpara.getPostingdate() != null && !inpara.getPostingdate().trim().equals("")) {
            logger.debug("Posting SO_PDA date is: " + inpara.getPostingdate());
            try {
                String currMonth = CommonTool.getCurrentDate("yyyy-MM");
                String postMonth = inpara.getPostingdate().substring(0, 7);
                logger.debug("current month is " + currMonth + ", post month is " + postMonth);
                if (!currMonth.equals(postMonth)) {
                    logger.error("Post SO_PDA Date is not in current month, return!");
                    outResult.setStatus("F");
                    outResult.setMsg("The Posting SO_PDA Date should be in current month, Please correct and submit again. ");
                    return outResult;
                }
            } catch (Exception e) {
                e.printStackTrace();
                outResult.setStatus("F");
                outResult.setMsg("Posting SO_PDA Date error, please contact with administrator.");
                return outResult;
            }
        }

		soPDADAO.soOrderIgp(inpara, outResult);

		return outResult;
	}
	
	/**
	 * 手持SO_过账
	 */
	@Override
	public OrderIgpOutDTO giftSoOrderIgp(OrderIgpInDTO inpara) {
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        if (inpara.getPostingdate() != null && !inpara.getPostingdate().trim().equals("")) {
            logger.debug("Posting SO_PDA date is: " + inpara.getPostingdate());
            try {
                String currMonth = CommonTool.getCurrentDate("yyyy-MM");
                String postMonth = inpara.getPostingdate().substring(0, 7);
                logger.debug("current month is " + currMonth + ", post month is " + postMonth);
                if (!currMonth.equals(postMonth)) {
                    logger.error("Post SO_PDA Date is not in current month, return!");
                    outResult.setStatus("F");
                    outResult.setMsg("The Posting SO_PDA Date should be in current month, Please correct and submit again. ");
                    return outResult;
                }
            } catch (Exception e) {
                e.printStackTrace();
                outResult.setStatus("F");
                outResult.setMsg("Posting SO_PDA Date error, please contact with administrator.");
                return outResult;
            }
        }

		soPDADAO.giftSoOrderIgp(inpara, outResult);

		return outResult;
	}
}
