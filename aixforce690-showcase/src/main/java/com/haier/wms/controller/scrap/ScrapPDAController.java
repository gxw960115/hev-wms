package com.haier.wms.controller.scrap;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.scrap.service.ScrapPDAServiceClient;
import com.haier.wms.util.HevUtil;
import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ScrapPDAController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月13日 上午10:27:25
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月13日		LJZ			v1.0.0			create
 */

@Controller
public class ScrapPDAController {

	private static final Logger logger = Logger.getLogger(ScrapPDAController.class);
	
	@Resource
	private ScrapPDAServiceClient scrapPDAServiceClient;

	public void setScrapPDAServiceClient(ScrapPDAServiceClient scrapPDAServiceClient) {
		this.scrapPDAServiceClient = scrapPDAServiceClient;
	}

	/**
	 * @title: orderCheck
	 * @description: 输入订单号检查一下订单是否存在是否需要下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月30日 下午5:28:28 
	 * @param username
	 * @param sign 手持签名
	 * @param orderNo 订单号
	 * @param orderType 订单类型
	 * @param version 版本
	 * @param dnType 
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/orderCheck", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username, String sign, String orderNo,
			String orderType, String dnType, String docType, String version) {
		
	    logger.debug("Entering ScrapPDA_OrderCheck with user: " + username + ", sign: " + sign 
	    		+ ", orderNo: " + orderNo + ", orderType: " + orderType);
	    
	    // 将编号改为十位
	    orderNo = this.orderNoFormat(orderNo);
		OrderCheckInDTO inpara = new OrderCheckInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setOrdertype(orderType);
		inpara.setDnType(dnType);
		inpara.setDoctype(docType);
		
		OrderCheckOutDTO orderResult = scrapPDAServiceClient.scrapOrderCheck(inpara,version);
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		logger.debug("Exit ScrapOrderCheck with result: " + result);
		return result;
	}

	/**
	 * @title: orderDownload
	 * @description: Scrap订单，调用SAP进行下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午11:32:33 
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param orderType
	 * @param version
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/orderDownload", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDownload(String username,String sign,String orderNo,
			String orderType,String version, String docType){
		// 订单改为10位
	    orderNo = this.orderNoFormat(orderNo);
		
	    OrderLoadInDTO inpara = new OrderLoadInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setOrdertype(orderType);
		inpara.setDoctype(docType);
		
		OrderLoadOutDTO outResult = scrapPDAServiceClient.scrapOrderDownload(inpara, version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: orderDelete
	 * @description: 删除扫描的条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午4:54:26 
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param orderType
	 * @param version
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String orderType,String version,String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setDoctype(doctype);
		inpara.setUser(username);
		
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		try {
			outResult = scrapPDAServiceClient.scrapOrderDelete(inpara,version);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @title: orderDelete
	 * @description: 删除扫描的条码
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 下午4:54:26
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param orderType
	 * @param version
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/ordersDelete", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String orderType,String version,String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setDoctype(doctype);
		inpara.setUser(username);

		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		try {
			outResult = scrapPDAServiceClient.scrapOrdersDelete(inpara,version);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @title: ScrapOrderIOgp
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:09:17 
	 * @param username
	 * @param postDate
	 * @param orderNo
	 * @param version
	 * @param inpara
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/orderIOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderIOgp(String username,String postDate,String orderNo,String version,String sapFlag,OrderIgpInDTO inpara) {
		orderNo = this.orderNoFormat(orderNo);
		
		logger.debug("Entering ScrapPDAorderIOgp with userName = " + username + ", carNo = " + inpara.getCarNo()
					+ ", docType = " + inpara.getDocType() + ", orderType = " + inpara.getOrderType() 
					+ ", orderNo = " + orderNo + ", postDt = " + postDate + ", resDt = " + inpara.getResDt()
					+ ", goodDt = " + inpara.getGooddt() + ", crmdt = " + inpara.getCrmdt() 
					+ ", reasonDt = " + inpara.getReasondt()+ ", vehicleType = " + inpara.getVehicleType());
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		
		try {
			outResult = scrapPDAServiceClient.scrapOrderIgp(inpara, version,sapFlag);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting ScrapPDAorderIOgp with result: " + result);
		return result;
	}
	
	/**  
	 * @Title: orderPosting
	 * @Description: 出库(后台)
	 * @author: ZhangLL
	 * @param username
	 * @param postDate
	 * @param orderNo
	 * @param version
	 * @param inpara
	 * @return String
	 * @throws  
	 */
	@RequestMapping(value = "/pdaScrap/orderPosting", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderPosting(String orderNo,OrderIgpInDTO inpara,String sapFlag){
		
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
		orderNo = HevUtil.orderNoFormat(orderNo);
		
		BaseUser user = UserUtil.getCurrentUser();
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(user.getName());
		inpara.setVersion("HEV");
		try {
			outResult = scrapPDAServiceClient.orderPosting(inpara, sapFlag);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//成功返回success,失败返回失败信息
		if ("0".equals(outResult.getStatus())) {
			return "success";
		} else {
			return outResult.getMsg();
		}
	}
	
	/**
	 * @title: barcodeList
	 * @description: 获取条码列表
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:48:35 
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param docType
	 * @param orderType
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/barcodeList", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType) {
	    orderNo = orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		
		WmsOrderDelListOutDTO outResult = scrapPDAServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: orderScan
	 * @description: 手持扫描条码
	 * @author: LJZ
	 * @version: v1.0.3
	 * @date: 2018年11月1日 下午1:45:34 
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param doctype
	 * @param orderType
	 * @param bin
	 * @param qty
	 * @param version
	 * @param remark
	 * @return: String
	 */
	@RequestMapping(value = "/pdaScrap/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering ScrapOrderScan with user: " + username + ", sign: "
				+ sign + ", orderNo: " + orderNo + ", doctype: " + doctype
				+ ", orderType: " + orderType + ", bin: " + bin + ", barcode: "
				+ barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);
		
		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setUser(username);
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setBin(bin);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		
		OrderUploadOutDTO outResult = scrapPDAServiceClient.scrapOrderScan(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: orderNoFormat
	 * @description: 编号凑足十位 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午9:28:37 
	 * @param orderNo
	 * @return: String
	 */
	private String orderNoFormat(String orderNo) {
		String orno = "0000000000" + orderNo;
		return orno.substring(orno.length() - 10, orno.length());
	}
}
