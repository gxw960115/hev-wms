package com.haier.openplatform.wms.customer.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.hevwms.customer.service.OdsCustomerScanInfoService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;

import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**  
 * @Title:  OdsCustomerScanInfoServiceClientImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:42:21   
 * @version V1.0 
 */  
public class OdsCustomerScanInfoServiceClientImpl implements OdsCustomerScanInfoServiceClient {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerScanInfoServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private RfWsService rfWsService;
	private OdsCustomerScanInfoService odsCustomerScanInfoService;

	public OdsCustomerScanInfoService getOdsCustomerScanInfoService() {
		return odsCustomerScanInfoService;
	}

	public void setOdsCustomerScanInfoService(OdsCustomerScanInfoService odsCustomerScanInfoService) {
		this.odsCustomerScanInfoService = odsCustomerScanInfoService;
	}

	public RfWsService getRfWsService() {
		return rfWsService;
	}

	public void setRfWsService(RfWsService rfWsService) {
		this.rfWsService = rfWsService;
	}

	public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#searchOdsCustomerScanInfos(long, long, com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public Pager<OdsCustomerScanInfoDTO> searchOdsCustomerScanInfos(long page, long rows,
			OdsCustomerScanInfoDTO odsCustomerScanInfoDTO) {
		Pager<OdsCustomerScanInfoDTO> pager = new Pager<OdsCustomerScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);

		Pager<OdsCustomerScanInfoDTO> temp = odsCustomerScanInfoService.searchOdsCustomerScanInfos(pager, odsCustomerScanInfoDTO);
		long totalSize = temp.getTotalRecords();
		List<OdsCustomerScanInfoDTO> listInfo = temp.getRecords();
		pager.setRecords(listInfo);
		pager.setTotalRecords(totalSize);
		return pager;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#searchOdsCustomerScanInfosCount(com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public Long searchOdsCustomerScanInfosCount(OdsCustomerScanInfoDTO odsCustomerScanInfoDTO) {
		return odsCustomerScanInfoService.searchOdsCustomerScanInfosCount(odsCustomerScanInfoDTO);
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
			outResult = odsCustomerScanInfoService.orderDelete(in);
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
                outResult = odsCustomerScanInfoService.orderDelete(in);
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
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#orderScan(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO, java.lang.String)
	 */
	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		log.debug("Entering Customer Order Scan......");
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
	
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if ("CUSTOMER".equals(inpara.getDoctype())) {
				outResult = odsCustomerScanInfoService.scanCustomer(inpara);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, outResult);
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "Customer_Order_Upload", inpara.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
	
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#orderIgp(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO, java.lang.String)
	 */
	@Override
	public OrderIgpOutDTO orderDelivery(OrderIgpInDTO inpara) throws IllegalAccessException, InvocationTargetException {
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		WmsOrderIgpOut result;
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
	
		result = odsCustomerScanInfoService.orderOgp(in);
		BeanUtils.copyProperties(outResult, result);
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#orderDelivery(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO, java.lang.String)
	 */
	@Override
	public OrderIgpOutDTO orderOgp(OrderIgpInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		log.debug("Entering CustomerOrderIgp...");
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		WmsOrderIgpOut result = new WmsOrderIgpOut();
		WmsOrderIgpIn in = new WmsOrderIgpIn();
		BeanUtils.copyProperties(in, inpara);
		// 调用时间
		Date startDate = new Date();
	
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(), in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    log.debug("Sign check successful...");
		    // 调用service
		    if ("CUSTOMER".equals(in.getDocType())) {
		    	result = odsCustomerScanInfoService.orderOgp(in);
			}
		} else {
			log.error("sign check failed, user must re-login...");
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, result);
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(in.getUser(), "Otcwms_Order_Igp", in.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), in, result);
	
		log.debug("Exiting Customer Order Igp...");
		return outResult;
	}
	
	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#barcodeList(com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO)
	 */
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
	    if ("CUSTOMER".equals(inpara.getDocType())) {
	    	OdsCustomerScanInfoDTO info = new OdsCustomerScanInfoDTO();
	    	info.setCtrOrderNo(inpara.getOrderNo());
	    	info.setInOutFlag("0");
			List<OdsCustomerScanInfoDTO> list = odsCustomerScanInfoService.getListByParams(info);
			if (list == null) {
			    return outResult;
			}
			for (OdsCustomerScanInfoDTO scanDTO : list) {
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
		rfWsService.writeLog(inpara.getUser(), "Customer_Order_GetCarlist",
			inpara.getSign(), context, "",
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}
	
}
