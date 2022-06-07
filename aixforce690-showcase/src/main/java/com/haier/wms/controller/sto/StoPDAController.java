package com.haier.wms.controller.sto;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.service.StoPDAServiceClient;
import com.haier.wms.controller.po.exceltemplate.ImportPoReceiptExcelTemplate;
import com.haier.wms.util.ExcelUtil;
import com.haier.wms.util.SessionConstants;
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
 * @className: StoPDAController.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午6:34:55
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

@Controller
public class StoPDAController {

	@Resource
	private StoPDAServiceClient stoPDAServiceClient;

	public void setStoPDAServiceClient(StoPDAServiceClient stoPDAServiceClient) {
		this.stoPDAServiceClient = stoPDAServiceClient;
	}

	private static final Logger logger = Logger.getLogger(StoPDAController.class);

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
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSto/orderCheck", method = RequestMethod.POST, 
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username, String sign, String orderNo,
			String orderType, String docType, String version) {
		
	    logger.debug("Entering StoPDA_OrderCheck with user: " + username + ", sign: " + sign 
	    		+ ", orderNo: " + orderNo + ", orderType: " + orderType);
	    
	    // 将编号改为十位
	    orderNo = this.orderNoFormat(orderNo);
		OrderCheckInDTO inpara = new OrderCheckInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setOrdertype(orderType);
//		inpara.setDnType(dnType);
		inpara.setDoctype(docType);
		
		OrderCheckOutDTO orderResult = stoPDAServiceClient.stoOrderCheck(inpara,version);
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		logger.debug("Exit StoOrderCheck with result: " + result);
		return result;
	}

	/**
	 * @title: orderDownload   20210425修改为调用TSM下载
	 * @description: Sto和stodn订单，调用SAP进行下载
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月31日 上午11:32:33 
	 * @param username
	 * @param sign
	 * @param orderType
	 * @param version
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSto/orderDownload", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDownload(String username,String sign,String stoNo, String stodnNo, 
			String orderType,String version, String docType){
		// 订单改为10位
	    stodnNo = this.orderNoFormat(stodnNo);
		stoNo = this.orderNoFormat(stoNo);
	    OrderLoadInDTO inpara = new OrderLoadInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(stodnNo);
		inpara.setOrdertype(orderType);
		inpara.setDoctype(docType);
		
		OrderLoadOutDTO outResult = stoPDAServiceClient.stoOrderDownload(inpara, version, stoNo);
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
	@RequestMapping(value = "/pdaSto/orderDelelte", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String docType,String orderType,String version){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		inpara.setBarcode(barcode);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		inpara.setDoctype(docType);
		
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		try {
			outResult = stoPDAServiceClient.stoOrderDelete(inpara,version);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * @title: orderDelete
	 * @description: 循环删除扫描的条码
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
	@RequestMapping(value = "/pdaSto/ordersDelete", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String ordersDelete(String username,String sign,String orderNo,String barcode,String docType,String orderType,String version){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inParam = new OrderDeleteInDTO();
		inParam.setBarcode(barcode);
		inParam.setOrdertype(orderType);
		inParam.setOrno(orderNo);
		inParam.setSign(sign);
		inParam.setUser(username);
		inParam.setDoctype(docType);

		OrderDeleteOutDTO outResult = stoPDAServiceClient.stoOrdersDelete(inParam,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * 循环删除扫描的条码
	 * STODN
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param barcode
	 * @param docType
	 * @param orderType
	 * @param version
	 * @return
	 */
	@RequestMapping(value = "/pdaStodn/ordersDelete", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String stodnScanDelete(String username,String sign,String orderNo,String barcode,String docType,String orderType,String version){
		orderNo = this.orderNoFormat(orderNo);

		OrderDeleteInDTO inParam = new OrderDeleteInDTO();
		inParam.setBarcode(barcode);
		inParam.setOrdertype(orderType);
		inParam.setOrno(orderNo);
		inParam.setSign(sign);
		inParam.setUser(username);
		inParam.setDoctype(docType);

		OrderDeleteOutDTO outResult = stoPDAServiceClient.stodnScanDelete(inParam,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	 * @title: StoOrderIOgp
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
	@RequestMapping(value = "/pdaSto/orderIOgp", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String poOrderIOgp(String username,String postDate,String orderNo,String docType, String version,OrderIgpInDTO inpara) {
		orderNo = this.orderNoFormat(orderNo);
		
		logger.debug("Entering StoPDAorderIOgp with userName = " + username + ", carNo = " + inpara.getCarNo()
					+ ", docType = " + inpara.getDocType() + ", orderType = " + inpara.getOrderType() 
					+ ", orderNo = " + orderNo + ", postDt = " + postDate + ", resDt = " + inpara.getResDt()
					+ ", goodDt = " + inpara.getGooddt() + ", crmdt = " + inpara.getCrmdt() 
					+ ", reasonDt = " + inpara.getReasondt()+ ", vehicleType = " + inpara.getVehicleType());
		inpara.setOrno(orderNo);
		inpara.setDocType(docType);
		inpara.setPostingdate(postDate);
		inpara.setUser(username);
		inpara.setVersion("HEV");
		
		OrderIgpOutDTO outResult = stoPDAServiceClient.stoOrderOgp(inpara, version);

		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting StoPDAorderIOgp with result: " + result);
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
	@RequestMapping(value = "/pdaSto/barcodeList", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType) {
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo = orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		
		// 调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = stoPDAServiceClient.barcodeList(inpara);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	@RequestMapping(value = "/pdaStodn/barcodeList", method = RequestMethod.POST,
			produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String stodnBarcodeList(String username,String sign,String orderNo,String docType,String orderType) {
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei
	    orderNo = orderNoFormat(orderNo);

	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);

		// 调用dubbo方法获取barcode列表
		WmsOrderDelListOutDTO outResult = stoPDAServiceClient.getBarcodeList(inpara);
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
	@RequestMapping(value = "/pdaSto/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering StoOrderScan with user: " + username + ", sign: "
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
		
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = stoPDAServiceClient.stoOrderUpload(inpara,version);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}

	/**
	 * 手持条码扫描
	 * stodn 出库入库扫描
	 * @param username
	 * @param sign
	 * @param orderNo
	 * @param stodn
	 * @param barcode
	 * @param doctype
	 * @param orderType
	 * @param bin
	 * @param qty
	 * @param remark
	 * @return
	 */
	@RequestMapping(value = "/pdaStodn/stodnScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String stodnOutScan(String username,String sign,String orderNo,String stodn,String barcode,String doctype,String orderType,
							String bin, String qty, String remark) {
		logger.debug("Entering StoOrderScan with user: " + username + ", sign: "
				+ sign + ", orderNo: " + orderNo + ", stodn: " + stodn + ", doctype: " + doctype
				+ ", orderType: " + orderType + ", bin: " + bin + ", barcode: "
				+ barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);

		OrderUploadInDTO inpara = new OrderUploadInDTO();
		inpara.setUser(username);
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setStodn(stodn);
		inpara.setQty(qty);
		inpara.setSign(sign);
		inpara.setBin(bin);
		inpara.setRemark(remark);
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = stoPDAServiceClient.stodnInfoUpload(inpara);
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
	@RequestMapping(value = "/pdaSto/stodnScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String stodnScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark) {
		
		orderNo = this.orderNoFormat(orderNo);
		logger.debug("Entering StoOrderScan with user: " + username + ", sign: "
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
		
		// 调用后台dubbo方法执行扫描操作
		OrderUploadOutDTO outResult = stoPDAServiceClient.stodnOrderUpload(inpara,version);
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

	@RequestMapping(value = "/sto/inoutWarehouse",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String inoutWarehouse(HttpServletRequest request, HttpServletResponse response, String orderNo, String orderType, String docType){
		String userName = SessionConstants.getSession().getString(SessionSecurityConstants.KEY_USER_NAME);

		return stoPDAServiceClient.inoutWarehouseSto(orderNo, orderType, userName);
	}



	/**
	 * @title:
	 * @description: 直发派遣STO单入库  导入Excel
	 * @author: skq
	 * @version: v1.0.3
	 * @date: 2020-11-04
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSto/importSTOReceiptExcel",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String importSTOReceiptExcel(MultipartHttpServletRequest request) throws Exception {
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
					OrderUploadOutDTO outResult = stoPDAServiceClient.stodnOrderUploadExcel(inpara);
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
	 * @title:
	 * @description: 直发派遣STO单出库  导入Excel
	 * @author: skq
	 * @version: v1.0.3
	 * @date: 2020-11-04
	 * @return: String
	 */
	@RequestMapping(value = "/pdaSto/importSTODeliveryExcel",
			method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String importSTODeliveryExcel(MultipartHttpServletRequest request) throws Exception {

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
					OrderUploadOutDTO outResult = stoPDAServiceClient.stoOrderUploadExcel(inpara);
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
	 * STO 入库导出Excel模板
	 */
	@RequestMapping(value = "/export/stoReceipt")
	@ResponseBody
	public void stoReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//excel标题
		String[] title = {"orderNo","barcode","doctype(fixed value)","orderType(fixed value)","bin","qty","remark"};
		//excel文件名
		String fileName = "STO Receipt Template.xls";
		//sheet名
		String sheetName = "STO Receipt";
		String [][] content = new String[1][];

		content[0] = new String[title.length];
		content[0][0] = "orderNo";
		content[0][1] = "barcode";
		content[0][2] = "STODN";
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



	/**
	 * STO 入库导出Excel模板
	 */
	@RequestMapping(value = "/export/stoDelivery")
	@ResponseBody
	public void stoDelivery(HttpServletRequest request, HttpServletResponse response) throws Exception {


		//excel标题
		String[] title = {"orderNo","barcode","doctype(fixed value)","orderType(fixed value)","bin","qty","remark"};
		//excel文件名
		String fileName = "STO Delivery Template.xls";
		//sheet名
		String sheetName = "STO Delivery";
		String [][] content = new String[1][];

		content[0] = new String[title.length];
		content[0][0] = "orderNo";
		content[0][1] = "barcode";
		content[0][2] = "STO";
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
