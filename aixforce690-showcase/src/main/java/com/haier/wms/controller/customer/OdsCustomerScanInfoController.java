package com.haier.wms.controller.customer;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.Servlets;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.wms.exceltemplate.customer.ExportCustomerScanInfoTemplate;
import com.haier.wms.util.HevUtil;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**  
 * @Title:  OdsCustomerScanInfoController.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:43:43   
 * @version V1.0 
 */  
@Controller
public class OdsCustomerScanInfoController {

	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/
	private static Logger log = LoggerFactory.getLogger(OdsCustomerScanInfoController.class);
	
	/**  
	* @Fields field:field:{todo}(dubbo接口)  
	*/
	@Resource
	private OdsCustomerScanInfoServiceClient odsCustomerScanInfoServiceClient;

	public void setOdsCustomerScanInfoServiceClient(OdsCustomerScanInfoServiceClient odsCustomerScanInfoServiceClient) {
		this.odsCustomerScanInfoServiceClient = odsCustomerScanInfoServiceClient;
	}

	/**
	* @Title: searchCustomerScanInfo  
	* @Description: TODO(查询列表)  
	* @author zhangll
	* @param request
	* @param odsCustomerScanInfoDTO
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerScanInfo/list", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerScanInfo(HttpServletRequest request, OdsCustomerScanInfoDTO odsCustomerScanInfoDTO) {

		long page = Long.parseLong(request.getParameter("page"));
		long rows = Long.parseLong(request.getParameter("rows"));

		PageBean bean = null;
		Pager<OdsCustomerScanInfoDTO> outpager = odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfos(page, rows,
				odsCustomerScanInfoDTO);
		bean = PageUtil.setPager(outpager);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(bean);
	}
	
	/**
	 * @Title: searchCustomerScanInfosAmount @Description:
	 * TODO(统计导出数量是否超出25000) @author zhangll @param request @param response @param
	 * dto @return String @throws
	 */
	@RequestMapping(value = "/odsCustomerScanInfo/searchAmount", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String searchCustomerScanInfosAmount(HttpServletRequest request, HttpServletResponse response,
			OdsCustomerScanInfoDTO dto) {
		String result = "success";

		// 查询导出的数据总量是多少
		Long exportAmount = odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfosCount(dto);
		if (exportAmount > 25000) {
			result = "The amount of data you exported is too large, please narrowing the query range!";
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}

	/**  
	* @Title: exportExcel  
	* @Description: TODO(导出)  
	* @author zhangll
	* @param odsCustomerScanInfoDTO
	* @param request
	* @param response
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerScanInfo/export", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String exportExcel(OdsCustomerScanInfoDTO odsCustomerScanInfoDTO, HttpServletRequest request,
			HttpServletResponse response) {
		String result = "success";
		response.setContentType(Servlets.EXCEL_TYPE);
		StringBuffer fileNameBuffer = new StringBuffer();
		fileNameBuffer.append("CustomerScanInfo");
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameBuffer.append(fmtDate.format(new Date()));
		fileNameBuffer.append(".xlsx");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileNameBuffer.toString());

		try {
			Pager<OdsCustomerScanInfoDTO> temp = odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfos(1, 25000,
					odsCustomerScanInfoDTO);
			ExportCustomerScanInfoTemplate template = new ExportCustomerScanInfoTemplate(temp.getRecords());
			template.doExport(response.getOutputStream(), odsCustomerScanInfoDTO);
		} catch (Exception e) {
			result = "false";
		}
		return null;
	}
	
	/**  
	* @Title: orderDelete  
	* @Description: 订单删除(手持)
	* @author: ZhangLL
	* @param username
	* @param sign
	* @param orderNo
	* @param barcode
	* @param doctype 订单类型CUSTOMER
	* @param orderType 出入库类型 1-入库 2-出库
	* @param version
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerScanInfo/orderDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
		orderNo = HevUtil.orderNoFormat(orderNo);

	    OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsCustomerScanInfoServiceClient.orderDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @Title: ordersDelete
	 * @Description: 多选barcode删除(手持)
	 * @author: ZhangLL
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param doctype 订单类型CUSTOMER
	 * @param orderType 出入库类型 1-入库 2-出库
	 * @param version
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/odsCustomerScanInfo/ordersDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei
		orderNo = HevUtil.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		//调用dubbo方法执行删除操作
		try {
			outResult = odsCustomerScanInfoServiceClient.ordersDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**  
	* @Title: orderScan  
	* @Description: 扫码
	* @author: ZhangLL
	* @param username
	* @param sign
	* @param orderNo
	* @param barcode
	* @param doctype 订单类型CUSTOMER
	* @param orderType 出入库类型 1-入库 2-出库
	* @param bin
	* @param qty
	* @param version
	* @param remark
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerScanInfo/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark){
		
		orderNo = HevUtil.orderNoFormat(orderNo);

	    log.debug("Entering orderScan with user: " + username + ", sign: " + sign + ", orderNo: " + orderNo + ", doctype: " + doctype+ ", orderType: " + orderType + ", bin: " + bin + ", barcode: " + barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setUser(username);
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype("2");
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setBin(bin);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		//调用后台dubbo方法执行扫描操作
		try {
			outResult = odsCustomerScanInfoServiceClient.orderScan(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**  
	* @Title: orderOgp  
	* @Description: 出库(手持)
	* @author: ZhangLL
	* @param username
	* @param postDate
	* @param orderNo
	* @param version
	* @param inpara
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "/odsCustomerScanInfo/orderOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo = HevUtil.orderNoFormat(orderNo);
	    
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		try {
			outResult = odsCustomerScanInfoServiceClient.orderOgp(inpara, version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		log.debug("Exiting orderIOgp with result: " + result);
		return result;
	}
	
	/**  
	 * @Title: orderDelivery
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
	@RequestMapping(value = "/odsCustomerScanInfo/orderDelivery", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelivery(String orderNo,OrderIgpInDTO inpara){
		
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
		orderNo = HevUtil.orderNoFormat(orderNo);
		
		BaseUser user = UserUtil.getCurrentUser();
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setUser(user.getName());
		inpara.setVersion("HEV");
		try {
			outResult = odsCustomerScanInfoServiceClient.orderDelivery(inpara);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		log.debug("Exiting orderIOgp with result: " + outResult);
		//成功返回success,失败返回失败信息
		if ("0".equals(outResult.getStatus())) {
			return "success";
		} else {
			return outResult.getMsg();
		}
	}
	
	/**
	* @Title: barcodeList
	* @Description: (获取条码列表)
	* @param @param username 登录用户
	* @param @param sign 手持签名 
	* @param @param orderNo 订单号的
	* @param @param docType 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @return    设定文件
	* @return String    返回类型
	*/ 
	@RequestMapping(value = "/odsCustomerScanInfo/barcodeList", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo = HevUtil.orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		//调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = odsCustomerScanInfoServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
}
