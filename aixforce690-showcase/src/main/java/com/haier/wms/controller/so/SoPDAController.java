package com.haier.wms.controller.so;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.service.SoPDAServiceClient;
import com.haier.wms.controller.po.exceltemplate.ImportPoReceiptExcelTemplate;
import com.haier.wms.util.ExcelUtil;
import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: SoPDAController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午6:34:23
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

@Controller
public class SoPDAController {
	@Resource
	private SoPDAServiceClient soPDAServiceClient;

	public void setSoPDAServiceClient(SoPDAServiceClient soPDAServiceClient) {
		this.soPDAServiceClient = soPDAServiceClient;
	}

	private static final Logger logger = Logger.getLogger(SoPDAController.class);
	
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
	@RequestMapping(value = "/pdaSo/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username, String sign, String orderNo,
			String orderType, String dnType, String docType, String version, String returnType) {
		// logger记录
	    logger.debug("Entering SoOrderCheck with user: " + username + ", sign: " + sign 
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
		
		OrderCheckOutDTO orderResult = soPDAServiceClient.soOrderCheck(inpara,version);
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		logger.debug("Exit SoOrderCheck with result: " + result);
		return result;
	}

	/**
	 * @title: orderDownload   20210425修改为调用TSM下载
	 * @description: So订单，调用SAP进行下载
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
	@RequestMapping(value = "/pdaSo/orderDownload", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDownload(String username,String sign,String orderNo,
			String orderType,String version, String docType){
		//订单拼成10位   2016-4-8  不足10位 左边加0
	    orderNo = this.orderNoFormat(orderNo);
		
	    OrderLoadInDTO inpara = new OrderLoadInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setOrdertype(orderType);
		inpara.setDoctype(docType);
		
		OrderLoadOutDTO outResult = soPDAServiceClient.soOrderDownload(inpara, version);
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
	@RequestMapping(value = "/pdaSo/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String orderType,String version,
			String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setDoctype(doctype);
		
		OrderDeleteOutDTO outResult = soPDAServiceClient.soOrderDelete(inpara,version);
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
	@RequestMapping(value = "/pdaGiftSo/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftSoDelete(String username,String sign,String orderNo,String barcode,
			String qty,String orderType,String version, String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setDoctype(doctype);
		
		OrderDeleteOutDTO outResult = soPDAServiceClient.giftSoOrderDelete(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * 手持SO_ 循环删除
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param orderType
	 * @param version
	 * @param doctype
	 * @return
	 */
	@RequestMapping(value = "/pdaSo/ordersDelete", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username, String sign, String orderNo, String barcode, String orderType,
							   String version, String doctype){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inParam = new OrderDeleteInDTO();
		inParam.setBarcode(barcode);
		inParam.setOrdertype(orderType);
		inParam.setOrno(orderNo);
		inParam.setSign(sign);
		inParam.setUser(username);
		inParam.setDoctype(doctype);

		OrderDeleteOutDTO outResult = soPDAServiceClient.soOrdersDelete(inParam,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: SoOrderIOgp
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:09:17 
	 * @param username
	 * @param postDate
	 * @param orderNo
	 * @param version
	 * @param inpara
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSo/orderIOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String soOrderIOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara) {
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
		OrderIgpOutDTO outResult = soPDAServiceClient.soOrderIgp(inpara, version);

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting orderIOgp with result: " + result);
		return result;
	}
	
	
	/**
	 * @title: SoOrderIOgp
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月1日 下午1:09:17 
	 * @param username
	 * @param postDate
	 * @param orderNo
	 * @param version
	 * @param inpara
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/pdaGiftSo/orderIOgp", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftSoOrderIOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara) {
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
		OrderIgpOutDTO outResult = soPDAServiceClient.giftSoOrderIgp(inpara, version);

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
	@RequestMapping(value = "/pdaSo/barcodeList", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType) {
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo=orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
			//调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = soPDAServiceClient.barcodeList(inpara);
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
	@RequestMapping(value = "/pdaSo/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark, String returnType) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering SoOrderScan with user: " + username + ", sign: "
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
		OrderUploadOutDTO outResult = soPDAServiceClient.soOrderScan(inpara,version);
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
	@RequestMapping(value = "/pdaGiftSo/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String giftSoScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String qty,String version, String remark, String returnType) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering SoOrderScan with user: " + username + ", sign: "
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
		inpara.setReturnType(returnType);
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = soPDAServiceClient.giftSoOrderScan(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	@RequestMapping(value = "/pdaSo/fifoGet", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String fifoGet(String orderNo, String matNo, String location, WmsOrderDelListInDTO inpara){
		orderNo = this.orderNoFormat(orderNo);
		inpara.setOrderNo(orderNo);
		WmsOrderDelListOutDTO fifoList = soPDAServiceClient.getFifo(inpara,location, matNo);

		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(fifoList);
	}

	@RequestMapping(value = "/pdaSo/orderScanOldBarcode", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScanOldBarcode(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark, String oldBarcode) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering SoOrderScan with user: " + username + ", sign: "
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
		inpara.setOldBarcode(oldBarcode);
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = soPDAServiceClient.soOrderScanOldBarcode(inpara,version);
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



	/**
	 * @title:
	 * @description: 直发派遣SO单出库  导入Excel
	 * @author: skq
	 * @version: v1.0.3
	 * @date: 2020-11-04
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSo/importSODeliveryExcel",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String importSODeliveryExcel(MultipartHttpServletRequest request) throws Exception {
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
					OrderUploadOutDTO outResult = soPDAServiceClient.soOrderScanBarcodeExcel(inpara);
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
	 * 导出so出库单Excel模板
	 */
	/**
	 * 导出Excel模板
	 */
	@RequestMapping(value = "/export/sODelivery")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//excel标题
		String[] title = {"orderNo","barcode","doctype(fixed value)","orderType(fixed value)","bin","qty","remark"};
		//excel文件名
		String fileName = "SO Delivery Template.xls";
		//sheet名
		String sheetName = "SO Delivery";
		String [][] content = new String[1][];

		content[0] = new String[title.length];
		content[0][0] = "orderNo";
		content[0][1] = "barcode";
		content[0][2] = "SO";
		content[0][3] = "2";
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
