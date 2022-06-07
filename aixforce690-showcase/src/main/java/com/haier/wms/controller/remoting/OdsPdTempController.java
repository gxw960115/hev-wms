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

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.OdsPdTempDtlServiceClient;

/**  
 * @ClassName: OdsPdTempController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2015-4-20  
 */ 
@Controller
public class OdsPdTempController {
	/**  
	 * @Fields field:field:{}(dubbo接口)  
	 */  
	@Resource
	private OdsPdTempDtlServiceClient odsPdTempDtlServiceClient;

	public void setOdsPdTempDtlServiceClient(OdsPdTempDtlServiceClient odsPdTempDtlServiceClient) {
		this.odsPdTempDtlServiceClient = odsPdTempDtlServiceClient;
	}

	/**
	 * @Title: setServiceClient  
	 * @Description: (set)  
	 * @param odsPdTempDtlServiceClient
	 * @return void 
	 * @throws  
	 */  
	public void setServiceClient(OdsPdTempDtlServiceClient odsPdTempDtlServiceClient) {
		this.odsPdTempDtlServiceClient = odsPdTempDtlServiceClient;
	}
	
	/**  
	 * @Title: orderCheck  
	 * @Description: (order check)  
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/rf/pdTemp/orderCheck", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderCheck(OdsPdTempDtlDTO dto){
		return odsPdTempDtlServiceClient.orderCheck(dto);
	}
	
	/**  
	 * @Title: orderScan  
	 * @Description: (order scan)  
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/rf/pdTemp/orderScan", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderScan(OdsPdTempDtlDTO dto){
		return odsPdTempDtlServiceClient.orderScan(dto);
	}
	
	/**  
	 * @Title: offlineScan  
	 * @Description: (离线扫描)  
	 * @param orderNo
	 * @param jsonArray
	 * @param doctype
	 * @param createBy
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/rf/pdTemp/offlineScan", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String offlineScan(String orderNo,String jsonArray,String doctype,String createBy){
		List<OdsPdTempDtlDTO> list = com.alibaba.fastjson.JSONArray.parseArray(jsonArray, OdsPdTempDtlDTO.class);
		for (OdsPdTempDtlDTO odsPdTempDtlDTO : list) {
			odsPdTempDtlDTO.setOrderNo(orderNo);
			odsPdTempDtlDTO.setSapDocNo(odsPdTempDtlDTO.getLocation());//此处从离线数据库表location存的为sapDocNo
			odsPdTempDtlDTO.setLocation("");
			odsPdTempDtlDTO.setCreateBy(createBy);
		}
		Map<String, String> result = new HashMap<String, String>();
		try {
			result = odsPdTempDtlServiceClient.offlineScan(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
		
	}
	
	/**  
	 * @Title: orderDelete  
	 * @Description: (删除)  
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/rf/pdTemp/orderDelete", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDelete(OdsPdTempDtlDTO dto){
		return odsPdTempDtlServiceClient.orderDelete(dto);
	}
	
	/**  
	 * @Title: orderDetail  
	 * @Description: (扫描详情)  
	 * @param dto
	 * @return
	 * @return String 
	 * @throws  
	 */  
	@RequestMapping(value="/rf/pdTemp/orderDetail", method = RequestMethod.POST,
		    produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String orderDetail(OdsPdTempDtlDTO dto){
		return odsPdTempDtlServiceClient.orderDetail(dto);
	}
}
