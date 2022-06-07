package com.haier.openplatform.wms.consume.impl;

import com.haier.hevwms.consume.service.ConsumePDAService;
import com.haier.hevwms.consume.service.OdsConsumeOrderService;
import com.haier.hevwms.consume.service.OdsConsumeScanInfoService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.sapinterface.ConsumingToSap;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
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
 * @className: ConsumePDAServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月12日 下午3:02:55
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月12日		LJZ			v1.0.0			create
 */

public class ConsumePDAServiceClientImpl implements ConsumePDAServiceClient {

	private Logger logger = Logger.getLogger(ConsumePDAServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private ConsumePDAService consumePDAService;
	private OdsConsumeOrderService odsConsumeOrderService;
	private OdsConsumeScanInfoService odsConsumeScanInfoService;
	
	public ConsumePDAService getConsumePDAService() {
		return consumePDAService;
	}
	public void setConsumePDAService(ConsumePDAService consumePDAService) {
		this.consumePDAService = consumePDAService;
	}
	public OdsConsumeOrderService getOdsConsumeOrderService() {
		return odsConsumeOrderService;
	}
	public void setOdsConsumeOrderService(OdsConsumeOrderService odsConsumeOrderService) {
		this.odsConsumeOrderService = odsConsumeOrderService;
	}

	public OdsConsumeScanInfoService getOdsConsumeScanInfoService() {
		return odsConsumeScanInfoService;
	}
	public void setOdsConsumeScanInfoService(OdsConsumeScanInfoService odsConsumeScanInfoService) {
		this.odsConsumeScanInfoService = odsConsumeScanInfoService;
	}
	
	public WebServiceContext getContext() {
		return context;
	}
	public void setContext(WebServiceContext context) {
		this.context = context;
	}
	
	/* (非 Javadoc) 
	* <p>Title: consumeOrderCheck</p> 
	* <p>Description: </p> 
	* @param dto
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String) 
	*/
	@Override
	public OrderCheckOutDTO consumeOrderCheck(OrderCheckInDTO dto, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		// 检查版本号 与 用户信息
		RfLogResult rfLogResult = consumePDAService.checkSign(dto.getUser(),dto.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			result = odsConsumeOrderService.checkConsumeOrderByPDA(dto);
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		consumePDAService.writeLog(dto.getUser(), "Consume_PDA_Check", dto.getSign(),
			context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), dto, result);
	
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: consumeOrderDownload</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrderDownload(com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO, java.lang.String) 
	*/
	@Override
	public OrderLoadOutDTO consumeOrderDownload(OrderLoadInDTO inpara, String version) {
		String result = "";
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		// 接口调用开始时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = consumePDAService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if ("S".equals(result)){
				outResult.setStatus("S");
				outResult.setMsg("SUCCESS");
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
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_Downoad", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/* (非 Javadoc) 
	* <p>Title: consumeOrderDelete</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrderDelete(com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO, java.lang.String) 
	*/
	@Override
	public OrderDeleteOutDTO consumeOrderDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = consumePDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    // 调用service
			outResult = consumePDAService.consumeOrderDelete(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_Delete", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/* (非 Javadoc) 
	* <p>Title: consumeOrdersDelete</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrdersDelete(com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO, java.lang.String) 
	*/
	@Override
	public OrderDeleteOutDTO consumeOrdersDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = consumePDAService.checkSign(inpara.getUser(), inpara.getSign(),version);

		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
			// 调用service
			String[] barcodes = inpara.getBarcode().split(",");
			for (int i = 0; i <barcodes.length; i++) {
				inpara.setBarcode(barcodes[i]);
				outResult = consumePDAService.consumeOrderDelete(inpara);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}

		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_Delete", inpara.getSign(),
				context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/* (非 Javadoc) 
	* <p>Title: consumeOrderIgp</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param version
	* @param sapFlag
	* @return
	* @throws IllegalAccessException
	* @throws InvocationTargetException 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrderIgp(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO, java.lang.String, java.lang.String) 
	*/
	@Override
	public OrderIgpOutDTO consumeOrderIgp(OrderIgpInDTO inpara, String version, String sapFlag) throws IllegalAccessException, InvocationTargetException {
		logger.debug("Entering ConsumeOrderIgp...");
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		
		Date startDate = new Date();
		RfLogResult rfLogResult = consumePDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
		// 调用Service
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    logger.debug("Sign check successful...");
		    //调用SAP接口过账
//		    long scanFlag =  consumePDAService.scanStatus(inpara.getOrno());
		    List<OdsConsumeOrderDTO> list = odsConsumeOrderService.scanStatus(inpara.getOrno());
		    String finishFlag = "1", dbSapFlag = "0";
		    for (OdsConsumeOrderDTO dto : list) {
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
	    		if ("0".equals(dbSapFlag)) {
	    			//扫描完毕,更改信息
	    			consumePDAService.updateSapInfo(inpara);
	    			ConsumingToSap sap = new ConsumingToSap(inpara.getOrno(), sapFlag);
	    			String sapResult = sap.exchangeWithSap();
	    			if ("S".equals(sapResult)) {
	    				result = consumePDAService.consumeOrderIgp(in);
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
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_Igp", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		logger.debug("Exiting consumeOrderIgp");
		return outResult;
	}

	/* (非 Javadoc) 
	* <p>Title: orderPosting</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param sapFlag
	* @return
	* @throws IllegalAccessException
	* @throws InvocationTargetException 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#orderPosting(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO, java.lang.String) 
	*/
	@Override
	public OrderIgpOutDTO orderPosting(OrderIgpInDTO inpara, String sapFlag) throws IllegalAccessException, InvocationTargetException {
		logger.debug("Entering Consume Posting...");
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		
	    //调用SAP接口过账
	    ConsumingToSap sap = new ConsumingToSap(inpara.getOrno(), sapFlag);
	    String sapResult = sap.exchangeWithSap();
	    if ("S".equals(sapResult)) {
	    	result = consumePDAService.consumeOrderIgp(in);
		} else {
			result.setMsg("Exchange with sap failure");
		}
		BeanUtils.copyProperties(outResult, result);
		
		return outResult;
	}
	
	/* (非 Javadoc) 
	* <p>Title: barcodeList</p> 
	* <p>Description: </p> 
	* @param inpara
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#barcodeList(com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO) 
	*/
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		OdsConsumeScanInfoDTO dto = new OdsConsumeScanInfoDTO();
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
		// 拼装查询条件
		dto.setConsumeNo(inpara.getOrderNo());
		dto.setScannedBy(inpara.getUser());
		dto.setOrderType(inpara.getOrderType());
		dto.setInOutFlag("0");
		// 按照条件查询到想要的结果
		List<OdsConsumeScanInfoDTO> list = odsConsumeScanInfoService.getOdsConsumeScanInfos(dto);
		if (list == null) {
			return outResult;
		}
		// 把查询结果拼装成想要的列表返回
		for (OdsConsumeScanInfoDTO info : list) {
			OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
			tempDTO.setBarcode(info.getBarcode());
			tempDTO.setQty(info.getQty().toString());
			tempDTO.setSapOrderNo(info.getConsumeNo());
			tempDTO.setRowId(info.getRowId().toString());
			detial.add(tempDTO);
		}
		outResult.setTotal(list.size() + "");
		outResult.setDetial(detial);

		Date endDate = new Date();
		// PDA 日志记录
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_GetDetailList",
				inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/* (非 Javadoc) 
	* <p>Title: consumeOrderScan</p> 
	* <p>Description: </p> 
	* @param inpara
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient#consumeOrderScan(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO, java.lang.String) 
	*/
	@Override
	public OrderUploadOutDTO consumeOrderScan(OrderUploadInDTO inpara, String version) {
		logger.debug("Entering ConsumePDA_OrderScan......");
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
		RfLogResult rfLogResult = consumePDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
		if ("S".equals(rfLogResult.getStatus())) {
			outResult = consumePDAService.scanConsumeCheck(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		consumePDAService.writeLog(inpara.getUser(), "Consume_PDA_Upload", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

}
