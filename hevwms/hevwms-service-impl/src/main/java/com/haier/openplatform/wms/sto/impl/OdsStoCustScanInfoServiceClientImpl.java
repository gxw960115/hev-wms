package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sto.service.OdsStoCustScanInfoService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoCustScanInfoServiceClient;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title:  OdsStoCustScanInfoServiceClientImpl.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0
 */
public class OdsStoCustScanInfoServiceClientImpl implements OdsStoCustScanInfoServiceClient {

	/**
	 * @Fields log: 日志处理
	 */
	private static final Logger log = LoggerFactory.getLogger(OdsStoCustScanInfoServiceClientImpl.class); 
	
	private WebServiceContext context;
	private RfWsService rfWsService;

	private OdsStoCustScanInfoService odsStoCustScanInfoService;
	
	public OdsStoCustScanInfoService getOdsStoCustScanInfoService() {
		return odsStoCustScanInfoService;
	}
	
	public void setOdsStoCustScanInfoService(OdsStoCustScanInfoService odsStoCustScanInfoService) {
		this.odsStoCustScanInfoService = odsStoCustScanInfoService;
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

	@Override
	public Pager<OdsStoCustScanInfoDTO> searchOdsStoCustScanInfoByPage(Long page, Long rows, OdsStoCustScanInfoDTO dto) {
		Pager<OdsStoCustScanInfoDTO> pager = new Pager<OdsStoCustScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsStoCustScanInfoService.searchOdsStoCustScanInfoByPage(pager, dto);
		return pager;
	}

	@Override
	public Long getExportAmount(OdsStoCustScanInfoDTO dto) {
		return odsStoCustScanInfoService.getExportAmount(dto);
	}

	@Override
	public List<OdsStoCustScanInfoDTO> getOdsStoCustScanInfos(OdsStoCustScanInfoDTO dto) {
		return odsStoCustScanInfoService.getOdsStoCustScanInfos(dto);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient#orderDelete(com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO, java.lang.String)
	 */
	@Override
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		WmsOrderDeleteIn in = new WmsOrderDeleteIn();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		BeanUtils.copyProperties(in, inpara);
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(),in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			// 调用service
			outResult = odsStoCustScanInfoService.orderDelete(in);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(in.getUser(), "Customer_Order_Delete", in.getSign(),
				context, outResult.getStatus(),
				CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), in, outResult);
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient#orderDelete(com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO, java.lang.String)
	 */
	@Override
	public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		WmsOrderDeleteIn in = new WmsOrderDeleteIn();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		BeanUtils.copyProperties(in, inpara);
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(),in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			String[] barcodes = in.getBarcode().split(",");
			for (int i = 0; i <barcodes.length; i++) {
				in.setBarcode(barcodes[i]);
				outResult = odsStoCustScanInfoService.orderDelete(in);
			}
			// 调用service
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(in.getUser(), "Customer_Order_Delete", in.getSign(),
				context, outResult.getStatus(),
				CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), in, outResult);
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.odsStoCustScanInfoServiceClient#orderScan(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO, java.lang.String)
	 */
	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		log.debug("Entering sto cust Order Scan......");
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();

		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    outResult = odsStoCustScanInfoService.orderScan(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, outResult);
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "sto_cust_Order_Upload", inpara.getSign(),
				context, outResult.getStatus(),
				CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);

		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.odsStoCustScanInfoServiceClient#barcodeList(com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO)
	 */
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
		if ("STOCUSTIN".equals(inpara.getDocType())||"STOCUSTOUT".equals(inpara.getDocType())) {
			OdsStoCustScanInfoDTO info = new OdsStoCustScanInfoDTO();
			info.setStoNo(inpara.getOrderNo());
	    	info.setOrderType(inpara.getOrderType());
	    	info.setInOutFlag("0");
			List<OdsStoCustScanInfoDTO> list = odsStoCustScanInfoService.getListByParams(info);
			if (list == null) {
				return outResult;
			}
			for (OdsStoCustScanInfoDTO scanDTO : list) {
				OrderDelDetialDTO dto = new OrderDelDetialDTO();
				dto.setBarcode(scanDTO.getBarcode());
				dto.setQty(scanDTO.getQty().toString());
				dto.setSapOrderNo(scanDTO.getOrderNo());
				dto.setRowId(scanDTO.getRowId().toString());
				dto.setLocation(scanDTO.getLocation());
				detial.add(dto);
			}
			outResult.setTotal(list.size() + "");
		}
		outResult.setDetial(detial);
		// 调用时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "STO_CUST_Order_GetCarlist",
				inpara.getSign(), context, "",
				CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}


}
