package com.haier.openplatform.wms.stocktaking.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;

import io.terminus.pampas.client.Export;
import net.sf.json.JSONObject;

public interface OdsPdTempDtlServiceClient {
	/** 
	* @Title: orderCheck 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String orderCheck(OdsPdTempDtlDTO pdTempDtlDTO);

	/** 
	* @Title: orderScan 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String orderScan(OdsPdTempDtlDTO pdTempDtlDTO);

	/** 
	* @Title: offlineScan 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param list
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Map<String,String>    返回类型 
	* @throws 
	*/
	public Map<String, String> offlineScan(List<OdsPdTempDtlDTO> list);
	
	/** 
	* @Title: orderDelete 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String orderDelete(OdsPdTempDtlDTO pdTempDtlDTO);
	
	/** 
	* @Title: orderDetail 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String orderDetail(OdsPdTempDtlDTO pdTempDtlDTO);
	
	/** 
	* @Title: searchOdsPdTempdtls 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDtlDTO
	* @param @param rows
	* @param @param page
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return JSONObject    返回类型 
	* @throws 
	*/
	@Export(paramNames={"pdTempDtlDTO","rows","page"})
	public JSONObject searchOdsPdTempdtls(OdsPdTempDtlDTO pdTempDtlDTO , Long rows, Long page);
	
	/** 
	* @Title: moveBarcodes 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"ids"})
	public String moveBarcodes(String ids);
	
	/** 
	* @Title: updateBarcodesStatus 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param status
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"ids","status"})
	public String updateBarcodesStatus(String ids,String status);
}
