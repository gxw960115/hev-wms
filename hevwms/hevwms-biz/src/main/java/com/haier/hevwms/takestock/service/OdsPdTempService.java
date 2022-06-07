package com.haier.hevwms.takestock.service;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;

import net.sf.json.JSONObject;

public interface OdsPdTempService {
	
	/**
	 * 
	* <p>Title: addPdTempOrder</p>
	* <p>Description: </p>  增加临时盘点单
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#addPdTempOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	public String addPdTempOrder(OdsPdTempDTO pdTempDTO);
	
	/**
	 * 
	* <p>Title: updateOrderStatus</p>
	* <p>Description: </p> 更新状态
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#updateOrderStatus(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	public String updateOrderStatus(OdsPdTempDTO pdTempDTO);
	
	/**
	 * 
	* <p>Title: searchOdsPdTemps</p>
	* <p>Description: </p> 分页查询
	* @param pdTempDTO
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdTempService#searchOdsPdTemps(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */
	public JSONObject searchOdsPdTemps(OdsPdTempDTO pdTempDTO , Long pageSize, Long currentPage);
	
	/**
	 * 
	* @Title: orderCheck
	* @Description: 检查订单是否存在
	* @param @param orderNo
	* @param @return
	* @return String
	* @throws
	 */
	public String orderCheck(String orderNo);
}
