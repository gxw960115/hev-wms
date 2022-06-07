package com.haier.wms.controller.po;

import com.haier.wms.controller.po.exceltemplate.ImportPoReceiptExcelTemplate;
import com.haier.wms.util.ExcelUtil;
import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.wms.po.service.PoPDAServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: PoPDAController.java
 * @description: 关于PDA 的PO 操作
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月31日 下午5:00:44
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月31日		LJZ			v1.0.0			create
 */

@Controller
public class PoPDAController {
	
	private static final Logger logger = Logger.getLogger(PoPDAController.class);

	@Resource
	private PoPDAServiceClient poPDAServiceClient;

	public void setPoPDAServiceClient(PoPDAServiceClient poPDAServiceClient) {
		this.poPDAServiceClient = poPDAServiceClient;
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
	@RequestMapping(value = "/pdaPo/orderCheck", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username, String sign, String orderNo,
			String orderType, String dnType, String docType, String version, String returnType) {
		// logger记录
	    logger.debug("Entering PoOrderCheck with user: " + username + ", sign: " + sign 
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
		inpara.setReturnType(returnType);
		
		OrderCheckOutDTO orderResult = new OrderCheckOutDTO();
		orderResult = poPDAServiceClient.poOrderCheck(inpara,version);
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		logger.debug("Exit PoOrderCheck with result: " + result);
		return result;
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
	@RequestMapping(value = "/pdaGiftPo/orderCheck", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftPoCheck(String username, String sign, String orderNo,
			String orderType, String dnType, String docType, String version, String returnType) {
		// logger记录
	    logger.debug("Entering PoOrderCheck with user: " + username + ", sign: " + sign 
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
		inpara.setReturnType(returnType);
		
		OrderCheckOutDTO orderResult = new OrderCheckOutDTO();
		orderResult = poPDAServiceClient.giftPoOrderCheck(inpara,version);
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		logger.debug("Exit PoOrderCheck with result: " + result);
		return result;
	}
	
	/**
	 * @title: orderDownload
	 * @description: PO订单，调用SAP进行下载
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
	@RequestMapping(value = "/pdaPo/orderDownload", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDownload(String username,String sign,String orderNo,
			String orderType,String version, String docType){
		logger.debug("Entering PoOrderDownload with user: " + username + ", sign: " + sign 
	    		+ ", orderNo: " + orderNo + ", orderType: " + orderType);
		// 编号改为十位
	    orderNo = this.orderNoFormat(orderNo);
		
	    OrderLoadInDTO inpara = new OrderLoadInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setOrdertype(orderType);
		inpara.setDoctype(docType);
		
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		outResult = poPDAServiceClient.poOrderDownload(inpara, version);
		logger.debug("Exit PoOrderDownload with result: " + outResult);
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
	@RequestMapping(value = "/pdaPo/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,
			String orderType,String version, String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setDoctype(doctype);
		
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		outResult = poPDAServiceClient.poOrderDelete(inpara,version);
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
	@RequestMapping(value = "/pdaGiftPo/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftPoDelete(String username,String sign,String orderNo,String barcode,
			String qty, String orderType,String version, String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setDoctype(doctype);
		
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		outResult = poPDAServiceClient.giftPoOrderDelete(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @title: orderDelete
	 * @description: 循环删除条码
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
	@RequestMapping(value = "/pdaPo/ordersDelete", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String orderType,String version){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);

		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		outResult = poPDAServiceClient.poOrdersDelete(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: poOrderIOgp
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
	@RequestMapping(value = "/pdaPo/orderIOgp", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String poOrderIOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara) {
		orderNo = this.orderNoFormat(orderNo);
		
		logger.debug("Entering orderIOgp with userName = " + username + ", carNo = " + inpara.getCarNo()
					+ ", docType = " + inpara.getDocType() + ", orderType = " + inpara.getOrderType() 
					+ ", orderNo = " + orderNo + ", postDt = " + postDate + ", resDt = " + inpara.getResDt()
					+ ", goodDt = " + inpara.getGooddt() + ", crmdt = " + inpara.getCrmdt() 
					+ ", reasonDt = " + inpara.getReasondt()+ ", vehicleType = " + inpara.getVehicleType());
		
		inpara.setOrno(orderNo);
		inpara.setPostingdate(postDate);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		outResult = poPDAServiceClient.poOrderIgp(inpara, version);

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting orderIOgp with result: " + result);
		return result;
	}
	
	/**
	 * @title: poOrderIOgp
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
	@RequestMapping(value = "/pdaGiftPo/orderIOgp", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftPoOrderIOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara) {
		orderNo = this.orderNoFormat(orderNo);
		
		logger.debug("Entering orderIOgp with userName = " + username + ", carNo = " + inpara.getCarNo()
					+ ", docType = " + inpara.getDocType() + ", orderType = " + inpara.getOrderType() 
					+ ", orderNo = " + orderNo + ", postDt = " + postDate + ", resDt = " + inpara.getResDt()
					+ ", goodDt = " + inpara.getGooddt() + ", crmdt = " + inpara.getCrmdt() 
					+ ", reasonDt = " + inpara.getReasondt()+ ", vehicleType = " + inpara.getVehicleType());
		
		inpara.setOrno(orderNo);
		inpara.setPostingdate(postDate);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		outResult = poPDAServiceClient.giftPoOrderIgp(inpara, version);

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting orderIOgp with result: " + result);
		return result;
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
	@RequestMapping(value = "/pdaPo/barcodeList", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType) {
		// 编号改为十位
	    orderNo=orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		
		// 调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		outResult = poPDAServiceClient.barcodeList(inpara);
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
	@RequestMapping(value = "/pdaPo/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark, String returnType) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering PoOrderScan with user: " + username + ", sign: "
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
		inpara.setReturnType(returnType);
		
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		outResult = poPDAServiceClient.poOrderScan(inpara,version);
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
	@RequestMapping(value = "/pdaGiftPo/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftOrderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String qty,String version, String remark, String returnType) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering PoOrderScan with user: " + username + ", sign: "
				+ sign + ", orderNo: " + orderNo + ", doctype: " + doctype
				+ ", orderType: " + orderType + ", barcode: "
				+ barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);
		
		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setUser(username);
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setVersion("HEV");
		inpara.setRemark(remark);
		
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		outResult = poPDAServiceClient.giftPoOrderScan(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	/**
	 * @title: orderNoFormat
	 * @description: 编号改为十位 
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


	/**
	 * @title:
	 * @description: 直发派遣po单入库  导入Excel
	 * @author: skq
	 * @version: v1.0.3
	 * @date: 2020-11-04
	 * @return: String
	 */
	@RequestMapping(value = "/pdaPo/importPoReceiptExcel",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String importPoReceiptExcel(MultipartHttpServletRequest request) throws Exception {
		BaseUser user = UserUtil.getCurrentUser();
		// 获得文件
		Iterator<String> fileNames = request.getFileNames();
		StringBuffer str = new StringBuffer();
		while (fileNames.hasNext()) {
			String name = fileNames.next();
			MultipartFile file = request.getFile(name);
			ImportPoReceiptExcelTemplate importPoReceiptExcelTemplate = new ImportPoReceiptExcelTemplate();
			try {
				byte[] imageData = file.getBytes();
				List<OrderUploadInDTO> list = importPoReceiptExcelTemplate.importInfo(imageData, user.getName());
				for(OrderUploadInDTO inpara : list){
					//这里不能直接调用手持的po入库接口 需要新写一个，去掉权限校验，其他不变
					inpara.setSign("importexcel");
					OrderUploadOutDTO outResult = poPDAServiceClient.poOrderScanExcel(inpara);
					if(!"0".equals(outResult.getStatus())){
						str.append("barCode:").append(inpara.getBarcode()).append(outResult.getStatus()).append(outResult.getMsg());
					}
				}
			} catch (Exception e) {
				str.append("import fail");
			}
		}
		return str.toString();
	}


	/**
	 * 导出Excel模板
	 */
	@RequestMapping(value = "/export/poReceipt")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//excel标题
		String[] title = {"orderNo","barcode","doctype(fixed value)","orderType(fixed value)","bin","qty","remark"};
		//excel文件名
		String fileName = "Po Receipt Template.xls";
		//sheet名
		String sheetName = "Po Receipt";
		String [][] content = new String[1][];

		content[0] = new String[title.length];
		content[0][0] = "orderNo";
		content[0][1] = "barcode";
		content[0][2] = "PO";
		content[0][3] = "1";
		content[0][4] = "bin";
		content[0][5] = "qty";
		content[0][6] = "remark";

		//创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		//响应到客户端
		try {
			ExcelUtil.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
