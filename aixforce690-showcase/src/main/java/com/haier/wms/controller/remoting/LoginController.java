package com.haier.wms.controller.remoting;

import io.terminus.common.utils.JsonMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.wms.remoting.dto.LoginParaDTO;
import com.haier.openplatform.wms.remoting.dto.LoginResultDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutParaDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutResultDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.service.RfWsClient;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.service.FileUploadServiceClient;

/**
* @ClassName: LoginController
* @Description: (手持登录页面)
* @author Song Yinglong /Nicholas
* @date 2015-11-11 上午10:28:38
*/ 

@Controller("LoginController")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private RfWsClient rfWsClient;
	
	@Resource
	private FileUploadServiceClient fileUploadServiceClient;


	
	/**
	* @Title: test
	* @Description: (手持测试方法)
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/rf/test", method = RequestMethod.POST,produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String test(){
		Date date = new Date();
		return date.toString();
	}
	
	/**
	* @Title: userLogin
	* @Description: (手持用户登录)
	* @param @param username
	* @param @param password
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/rf/login", method = RequestMethod.POST,
    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String userLogin( String username, String password,String version, HttpServletRequest request){
	    logger.debug("Client:" + "RF" + "User name:" + username + "Password:" + password);
		LoginParaDTO loginParaDTO = new LoginParaDTO();
		loginParaDTO.setIp("");
		loginParaDTO.setUser(username);
		loginParaDTO.setPass(password);
		LoginResultDTO loginResultDTO = new LoginResultDTO();
		try {
			loginResultDTO = rfWsClient.otcwmsLogin(loginParaDTO,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(loginResultDTO);
	}
	
	/**
	* @Title: userLogout
	* @Description: (手持用户登出)
	* @param @param username 用户登录名
	* @param @param sign 手持签名
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/rf/logout", method = RequestMethod.POST,
    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String userLogout(String username,String sign){
		LogoutResultDTO result = new LogoutResultDTO();
		LogoutParaDTO logoutParaDTO = new LogoutParaDTO();
		logoutParaDTO.setUser(username);
		logoutParaDTO.setSign(sign);
		try {
			//调用dubbo方法中的登录出功能
			result = rfWsClient.otcwmsLogout(logoutParaDTO);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**
	* @Title: orderCheck
	* @Description: (输入订单号检查一下订单是否存在是否需要下载)
	* @param @param username 登录用户名
	* @param @param sign 手持签名
	* @param @param orderNo 订单号
	* @param @param doctype 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/rf/orderCheck", method = RequestMethod.POST,
    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(String username,String sign,String orderNo,String doctype
		,String orderType,String version,String dnType){
		
	    orderNo=orderNoFormat(orderNo);
	    
	    logger.debug("Entering orderCheck with user: " + username + ", sign: " + sign + ", orderNo: " + orderNo + ", doctype: " + doctype 
	            + ", orderType: " + orderType);
		OrderCheckOutDTO orderResult = new OrderCheckOutDTO();
		OrderCheckInDTO inpara = new OrderCheckInDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setDnType(dnType);
		try {
			orderResult = rfWsClient.otcwmsOrderCheck(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(orderResult);
		
		logger.debug("Exit orderCheck with result: " + result);
		return result;
	}
	
	/**
	* @Title: orderDelete
	* @Description: (删除扫描的条码)
	* @param @param username 用户名
	* @param @param sign 手持签名
	* @param @param orderNo 订单号
	* @param @param barcode 条码
	* @param @param doctype 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping(value = "/rf/orderDelelte", method = RequestMethod.POST,
    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(String username,String sign,String orderNo,String barcode,String doctype,String orderType,String version){

    	//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo=orderNoFormat(orderNo);

	    OrderDeleteInDTO inpara = new OrderDeleteInDTO();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		inpara.setBarcode(barcode);
		inpara.setDoctype(doctype);
		inpara.setOrdertype(orderType);
		inpara.setOrno(orderNo);
		inpara.setSign(sign);
		inpara.setUser(username);
		try {
			//调用dubbo方法执行删除操作
			outResult = rfWsClient.otcwmsOrderDelete(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	* @Title: orderScan
	* @Description: (手持扫描条码)
	* @param @param username 用户登录名
	* @param @param sign 手持签名
	* @param @param orderNo 订单号
	* @param @param barcode 条码
	* @param @param doctype 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @param location 库存地点
	* @param @param qty 条码数量 默认为1
	* @param @return    设定文件
	* @return String    返回类型
	*/ 
	@RequestMapping(value = "/rf/orderScan", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(String username,String sign,String orderNo,String barcode,String doctype,String orderType,
			String bin, String qty,String version, String remark){

		orderNo=orderNoFormat(orderNo);

	    logger.debug("Entering orderScan with user: " + username + ", sign: " + sign + ", orderNo: " + orderNo + ", doctype: " + doctype 
                + ", orderType: " + orderType + ", bin: " + bin + ", barcode: " + barcode + ", qty: " + qty + ", version: IND," + ",remark:" + remark);
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
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
		try {
			//调用后台dubbo方法执行扫描操作
			outResult = rfWsClient.otcwmsOrderUpload(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**
	* @Title: orderIgp
	* @Description: (这里用一句话描述这个方法的作用)
	* @param @param username 登录用户
	* @param @param sign 手持签名
	* @param @param postDate 过账日期
	* @param @param carNo 车号
	* @param @param docType 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @param orderNo 单号
	* @param @return    设定文件
	* @return String    返回类型
	*/ 
	@RequestMapping(value = "/rf/orderIOgp", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderIOgp(String username,String postDate,String orderNo,String version,OrderIgpInDTO inpara){
	    
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo=orderNoFormat(orderNo);
	    
	    logger.debug("Entering orderIOgp with userName = " + username + ", carNo = " + inpara.getCarNo()
	    					+ ", docType = " + inpara.getDocType() + ", orderType = " + inpara.getOrderType() 
	    					+ ", orderNo = " + orderNo + ", postDt = " + postDate + ", resDt = " + inpara.getResDt()
	    					+ ", goodDt = " + inpara.getGooddt() + ", crmdt = " + inpara.getCrmdt() 
	    					+ ", reasonDt = " + inpara.getReasondt()+ ", vehicleType = " + inpara.getVehicleType());
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		inpara.setOrno(orderNo);
		inpara.setPostingdate(postDate);
		inpara.setUser(username);
		inpara.setVersion("IND");
		try {
			outResult = rfWsClient.otcwmsOrderIgp(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		String result = JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
		logger.debug("Exiting orderIOgp with result: " + result);
		return result;
	}
	
	/**
	* @Title: orderDownload
	* @Description: (下载单据)
	* @param @param username 登录用户名
	* @param @param sign 手持签名
	* @param @param orderNo 订单号
	* @param @param docType 订单类型（PO,Inbound,DN,STO-DN,Scrap,GIFT,stocktaking)
	* @param @param orderType 出入库类型 1-入库 2-出库
	* @param @return    设定文件
	* @return String    返回类型
	*/ 
	@RequestMapping(value = "/rf/orderDownload", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDownload(String username,String sign,String orderNo,String docType,String orderType,String version){
		
		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo=orderNoFormat(orderNo);
	    
	    OrderLoadInDTO inpara = new OrderLoadInDTO();
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrno(orderNo);
		inpara.setDoctype(docType);
		inpara.setOrdertype(orderType);
		try {
			outResult = rfWsClient.otcwmsOrderLoad(inpara,version);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
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
	@RequestMapping(value = "/rf/barcodeList", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String barcodeList(String username,String sign,String orderNo,String docType,String orderType){

		//订单拼成10位   2016-4-8  不足10位 左边加0 add by sunyanfei	
	    orderNo=orderNoFormat(orderNo);
	    	
	    WmsOrderDelListInDTO inpara = new WmsOrderDelListInDTO();
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		inpara.setUser(username);
		inpara.setSign(sign);
		inpara.setOrderNo(orderNo);
		inpara.setDocType(docType);
		inpara.setOrderType(orderType);
		try{
			//调用dubbo方法获取barcode列表
			outResult = rfWsClient.otcwmsBarcodeList(inpara);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(outResult);
	}
	
	/**  
	 * @Title: offlineScan  
	 * @Description: TODO(离线扫描)  
	 * @param orderNo
	 * @param jsonArray
	 * @param docType
	 * @param orderType
	 * @param userName
	 * @return String 
	 */  
	@RequestMapping(value = "/rf/offlineScan", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String offlineScan(String orderNo,String jsonArray,String docType,String orderType,String userName){
		List<OrderUploadInDTO> list = com.alibaba.fastjson.JSONArray.parseArray(jsonArray, OrderUploadInDTO.class);
		for (OrderUploadInDTO otcwmsOrderUploadInDTO : list) {
			otcwmsOrderUploadInDTO.setOrno(orderNoFormat(orderNo));
			otcwmsOrderUploadInDTO.setDoctype(docType);
			otcwmsOrderUploadInDTO.setOrdertype(orderType);
			otcwmsOrderUploadInDTO.setUser(userName);
		}
		Map<String, String> result = new HashMap<String, String>();
		try {
			result = rfWsClient.offlineScan(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
	}
	
	/**  
	 * @Title: downloadApp  
	 * @Description: TODO(下载app)
	 * @return String 
	 * @throws IOException 
	 */  
	@RequestMapping(value = "/rf/downloadApp", method = RequestMethod.GET,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String downloadApp(String name,String version, HttpServletRequest request, HttpServletResponse response) throws IOException{

        UploadFile path = fileUploadServiceClient.getLatestApp(name, version);
        if(path!=null){
            String fileName=path.getFileName();
            String mimetype = "application/vnd.android.package-archive";
            response.setContentType(mimetype);
            String inlineType = "attachment"; 
            response.setHeader("Content-Disposition", inlineType + ";fileName=\""
                    + fileName + "\"");
            InputStream is = new FileInputStream(new File(path.getFilePath1()+ File.separator + fileName));
            ServletOutputStream os = response.getOutputStream();
            try {
                IOUtils.copy(is, os);
            } catch (Exception e) {
               
            } finally {
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);
            }
        }else{
            response.getWriter().write("The File is Not Found!");
        }
       
        return null;
	}
	
	/**
	* @Title: orderNoFormat
	* @Description: 前台传来的order no 拼成10位
	* @param @param orderNo
	* @param @return
	* @return String
	*/
	private String orderNoFormat(String orderNo){
	    String orno="0000000000"+orderNo;
	    return orno.substring(orno.length()-10, orno.length());
	}

	/**
	* @Title: setRfWsClient
	* @Description: (RfWsClient的set方法)
	* @param @param rfWsClient    设定文件
	* @return void    返回类型
	*/ 
	public void setRfWsClient(RfWsClient rfWsClient) {
		this.rfWsClient = rfWsClient;
	}

	public void setFileUploadServiceClient(
			FileUploadServiceClient fileUploadServiceClient) {
		this.fileUploadServiceClient = fileUploadServiceClient;
	}

}
