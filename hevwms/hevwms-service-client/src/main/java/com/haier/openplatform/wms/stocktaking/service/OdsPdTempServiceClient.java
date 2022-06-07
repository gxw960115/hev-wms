package com.haier.openplatform.wms.stocktaking.service;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;

import io.terminus.pampas.client.Export;
import net.sf.json.JSONObject;

public interface OdsPdTempServiceClient {

	/** 
	* @Title: addPdTempOrder 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames={"pdTempDTO"})
	public String addPdTempOrder(OdsPdTempDTO pdTempDTO);
	
	/** 
	* @Title: updateStatus 
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
	public String updateStatus(String ids,String status);
	
	/** 
	* @Title: searchOdsPdTemps 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pdTempDTO
	* @param @param rows
	* @param @param page
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return JSONObject    返回类型 
	* @throws 
	*/
	@Export(paramNames={"pdTempDTO","rows","page"})
	public JSONObject searchOdsPdTemps(OdsPdTempDTO pdTempDTO , Long rows, Long page);
	
	/** 
	* @Title: getTempPdOrderNo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export
	public String getTempPdOrderNo();
	
	
}
