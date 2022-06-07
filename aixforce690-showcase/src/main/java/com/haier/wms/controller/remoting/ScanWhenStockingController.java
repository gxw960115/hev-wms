package com.haier.wms.controller.remoting;

import io.terminus.common.utils.JsonMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.service.RfScanWhenPDClient;

/**
 * @author 作者 :sunyanfei
 * @date 创建时间：2016-3-25 上午10:57:26
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Controller("ScanWhenStockingController")
public class ScanWhenStockingController {
    
    @Resource
    private RfScanWhenPDClient rfScanWhenPDClient;

    /**  
     * @Title: orderCkeck  
     * @Description: (订单确认)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/orderCheck", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String orderCkeck(OrderCheckInDTO in) {
		in.setOrno(orderNoFormat(in.getOrno()));
		OrderIgpOutDTO result=rfScanWhenPDClient.orderCheck(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
   
    /**  
     * @Title: orderDownLoad  
     * @Description: (订单下载)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/orderDownload", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String orderDownLoad(OrderCheckInDTO in){
		in.setOrno(orderNoFormat(in.getOrno()));
		OrderIgpOutDTO result=rfScanWhenPDClient.orderDownLoad(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: orderScan  
     * @Description: (订单扫描)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/orderScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String orderScan(OrderUploadInDTO in){
		in.setOrno(orderNoFormat(in.getOrno()));
		OrderUploadOutDTO result=rfScanWhenPDClient.orderScan(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: offlineScan  
     * @Description: (离线扫描)  
     * @param orno
     * @param jsonArray
     * @param doctype
     * @param ordertype
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/offlineScan", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String offlineScan(String orno,String jsonArray,String doctype,String ordertype) {
		List<OrderUploadInDTO> list = com.alibaba.fastjson.JSONArray.parseArray(jsonArray, OrderUploadInDTO.class);
		for (OrderUploadInDTO otcwmsOrderUploadInDTO : list) {
			otcwmsOrderUploadInDTO.setOrno(orderNoFormat(orno));
			otcwmsOrderUploadInDTO.setDoctype(doctype);
			otcwmsOrderUploadInDTO.setOrdertype(ordertype);
		}
		Map<String, String> result = new HashMap<String, String>();
		try {
			result = rfScanWhenPDClient.offlineScan(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: barcodeDetail  
     * @Description: (条码明细)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/barcodeDetail", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String barcodeDetail(OrderUploadInDTO in){
		in.setOrno(orderNoFormat(in.getOrno()));
		WmsOrderDelListOutDTO result=rfScanWhenPDClient.barcodeDetail(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: orderIogp  
     * @Description: (订单汇总)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/orderIogp", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String orderIogp(OrderUploadInDTO in){
		in.setOrno(orderNoFormat(in.getOrno()));
		OrderUploadOutDTO result=rfScanWhenPDClient.orderIogp(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: orderDelete  
     * @Description: (订单删除)  
     * @param in
     * @return String 
     */  
    @RequestMapping(value = "/scanWhenPD/orderDelete", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String orderDelete(OrderUploadInDTO in){
		in.setOrno(orderNoFormat(in.getOrno()));
		OrderUploadOutDTO result=rfScanWhenPDClient.orderDelete(in);
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
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
     * @Title: setRfScanWhenPDClient  
     * @Description: (set)  
     * @param rfScanWhenPDClient
     * @return void 
     */  
    public void setRfScanWhenPDClient(RfScanWhenPDClient rfScanWhenPDClient) {
    	this.rfScanWhenPDClient = rfScanWhenPDClient;
    }
}
