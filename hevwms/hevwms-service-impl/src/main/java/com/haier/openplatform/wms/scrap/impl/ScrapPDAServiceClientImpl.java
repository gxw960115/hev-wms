package com.haier.openplatform.wms.scrap.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sapinterface.ScrapToSap;
import com.haier.hevwms.scrap.service.OdsScrapOrderService;
import com.haier.hevwms.scrap.service.OdsScrapScanInfoService;
import com.haier.hevwms.scrap.service.ScrapPDAService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import com.haier.openplatform.wms.scrap.service.ScrapPDAServiceClient;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ScrapPDAServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月13日 上午10:21:59
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月13日		LJZ			v1.0.0			create
 */

public class ScrapPDAServiceClientImpl implements ScrapPDAServiceClient {
	
	private Logger logger = Logger.getLogger(ScrapPDAServiceClientImpl.class);
	@Resource
	private WebServiceContext context;
	private RfWsService rfWsService;
	private ScrapPDAService scrapPDAService;
	private OdsScrapOrderService odsScrapOrderService;
	private OdsScrapScanInfoService odsScrapScanInfoService;
	
	public ScrapPDAService getScrapPDAService() {
		return scrapPDAService;
	}
	public void setScrapPDAService(ScrapPDAService scrapPDAService) {
		this.scrapPDAService = scrapPDAService;
	}
	public OdsScrapOrderService getOdsScrapOrderService() {
		return odsScrapOrderService;
	}
	public void setOdsScrapOrderService(OdsScrapOrderService odsScrapOrderService) {
		this.odsScrapOrderService = odsScrapOrderService;
	}
	
	public OdsScrapScanInfoService getOdsScrapScanInfoService() {
		return odsScrapScanInfoService;
	}
	public void setOdsScrapScanInfoService(OdsScrapScanInfoService odsScrapScanInfoService) {
		this.odsScrapScanInfoService = odsScrapScanInfoService;
	}
	
	public WebServiceContext getContext() {
		return context;
	}
	public void setContext(WebServiceContext context) {
		this.context = context;
	}
	public RfWsService getRfWsService() {
		return rfWsService;
	}
	public void setRfWsService(RfWsService rfWsService) {
		this.rfWsService = rfWsService;
	}
	/**
	 * 手持Scrap_按照输入的单号，验证单号是否存在可扫，如果单号不存在则提示需要下载输入的单号
	 */
	@Override
	public OrderCheckOutDTO scrapOrderCheck(OrderCheckInDTO dto, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		// 检查版本号 与 用户信息
		RfLogResult rfLogResult = scrapPDAService.checkSign(dto.getUser(),dto.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			result = odsScrapOrderService.checkScrapOrderByPDA(dto);
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		scrapPDAService.writeLog(dto.getUser(), "Scrap_PDA_Check", dto.getSign(),
			context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), dto, result);
	
		return result;
	}

	/**
	 * 手持Scrap_调用SAP接口，下载Scrap
	 */
	@Override
	public OrderLoadOutDTO scrapOrderDownload(OrderLoadInDTO inpara, String version) {
		String result = "";
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		// 接口调用开始时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = scrapPDAService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			// FIXME @LJZ 未编写手持Scrap订单下载
//			result = odsScrapOrderService.downloadScrap(inpara.getOrno(), "2018-11-11", null, inpara.getUser());
			if ("S".equals(result)){
				outResult.setStatus("S");
				outResult.setMsg("SUCCESS");
//				outResult.setWlList(odsScrapOrderService.getScrapMaterialList(inpara.getOrno()));
			} else {
				outResult.setStatus("F");
				outResult.setMsg("Sap download nothing!");
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_Downoad", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持Scrap_删除
	 */
	@Override
	public OrderDeleteOutDTO scrapOrderDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = scrapPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    // 调用service
			outResult = scrapPDAService.scrapOrderDelete(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_Delete", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持Scrap_删除
	 */
	@Override
	public OrderDeleteOutDTO scrapOrdersDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = scrapPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);

		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
			String[] barcodes = inpara.getBarcode().split(",");
			for (int i = 0; i <barcodes.length; i++) {
				inpara.setBarcode(barcodes[i]);
				// 调用service
				outResult = scrapPDAService.scrapOrderDelete(inpara);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}

		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_Delete", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持Scrap_过账
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public OrderIgpOutDTO scrapOrderIgp(OrderIgpInDTO inpara, String version,String sapFlag) throws IllegalAccessException, InvocationTargetException {
		logger.debug("Entering ScrapOrderIgp...");
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		Date startDate = new Date();
		RfLogResult rfLogResult = scrapPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    logger.debug("Sign check successful...");
		    //调用SAP接口过账
//		    long scanFlag =  scrapPDAService.scanStatus(inpara.getOrno());
		    List<OdsScrapOrderDTO> list = odsScrapOrderService.scanStatus(inpara.getOrno());
		    String finishFlag = "1", dbSapFlag = "0";
		    for (OdsScrapOrderDTO dto : list) {
				if ("0".equals(dto.getFinishFlag())) {
					finishFlag = "0";
					break;
				}
				if (!"0".equals(dto.getSapFlag())) {
					dbSapFlag = dto.getSapFlag();
					break;
				}
			}
	    	if ("1".equals(finishFlag)) {
	    		//扫描完毕,更改信息
	    		if ("0".equals(dbSapFlag)) {
	    			scrapPDAService.updateSapInfo(inpara);
	    			ScrapToSap sap = new ScrapToSap(inpara.getOrno(), sapFlag);
	    			String sapResult = sap.exchangeWithSap();
	    			if ("S".equals(sapResult)) {
	    				result = scrapPDAService.scrapOrderIgp(in);
	    			} else {
	    				result.setMsg("Exchange with sap failure");
	    			}
				} else {
					if ("1".equals(dbSapFlag)) {
						result.setMsg("This Order has already Posting Success!");
					} else {
						result.setMsg("Please post this order on portal!");
					}
				}
	    	} else {
	    		result.setMsg("Order Is Not Finished");
	    	}
		} else {
		    outResult.setStatus(rfLogResult.getStatus());
		    outResult.setMsg(rfLogResult.getMsg());
		}
		BeanUtils.copyProperties(outResult, result);
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_Igp", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		logger.debug("Exiting otcwmsOrderIgp...");
		return outResult;
	}
	
	@Override
	public OrderIgpOutDTO orderPosting(OrderIgpInDTO inpara, String sapFlag) throws IllegalAccessException, InvocationTargetException {
		logger.debug("Entering Scrap Posting...");
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		
		//调用SAP接口过账
		ScrapToSap sap = new ScrapToSap(inpara.getOrno(), sapFlag);
		String sapResult = sap.exchangeWithSap();
		if ("S".equals(sapResult)) {
			result = scrapPDAService.scrapOrderIgp(in);
		} else {
			result.setMsg("Exchange with sap failure");
		}
		BeanUtils.copyProperties(outResult, result);
		return outResult;
	}

	/**
	 * 手持Scrap_查询条码明细
	 */
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		OdsScrapScanInfoDTO dto = new OdsScrapScanInfoDTO();
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
		// 拼装查询条件
		dto.setScrapNo(inpara.getOrderNo());
		dto.setScannedBy(inpara.getUser());
		dto.setOrderType(inpara.getOrderType());
		dto.setInOutFlag("0");
		// 按照条件查询到想要的结果
		List<OdsScrapScanInfoDTO> list = odsScrapScanInfoService.getOdsScrapScanInfos(dto);
		if (list == null) {
			return outResult;
		}
		// 把查询结果拼装成想要的列表返回
		for (OdsScrapScanInfoDTO info : list) {
			OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
			tempDTO.setBarcode(info.getBarcode());
			tempDTO.setQty(info.getQty().toString());
			tempDTO.setSapOrderNo(info.getScrapNo());
			tempDTO.setRowId(info.getRowId().toString());
			detial.add(tempDTO);
		}
		outResult.setTotal(list.size() + "");
		outResult.setDetial(detial);

		Date endDate = new Date();
		// PDA 日志记录
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_GetDetailList",
				inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持Scrap_扫描订单
	 */
	@Override
	public OrderUploadOutDTO scrapOrderScan(OrderUploadInDTO inpara, String version) {
		logger.debug("Entering ScrapPDA_OrderScan......");
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
		RfLogResult rfLogResult = scrapPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
		if ("S".equals(rfLogResult.getStatus())) {
			outResult = scrapPDAService.scanScrapCheck(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		scrapPDAService.writeLog(inpara.getUser(), "Scrap_PDA_Upload", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}
}
