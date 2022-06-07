package com.haier.hevwms.scrap.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapOrderService.java
 * @description: 报废订单Service
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:38:43
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

public interface OdsScrapOrderService {

	/**
	 * @title: searchOdsScrapOrderByPage
	 * @description: 分页条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午2:58:08 
	 * @param pager
	 * @param dto
	 * @return: Pager<OdsScrapOrderDTO>
	 */
	Pager<OdsScrapOrderDTO> searchOdsScrapOrderByPage(
			Pager<OdsScrapOrderDTO> pager, OdsScrapOrderDTO dto);

	/**
	 * @title: deleteScrapOrder
	 * @description: 删除 ScrapOrder
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午6:55:07 
	 * @param idList
	 * @return: int
	 */
	int deleteScrapOrder(List<Long> idList);

	/**
	 * @title: confirmScrapOrder
	 * @description: 报销单确认
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:29:25 
	 * @param idList
	 * @return: int
	 */
	int confirmScrapOrder(List<Long> idList, String userName);

	/**
	 * @title: getExportAmount
	 * @description: 查询导出Excel条数
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午5:06:13 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsScrapOrderDTO dto);

	/**
	 * @title: getOdsScrapOrderListByParm
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 上午10:27:22 
	 * @param dto
	 * @return: List<OdsScrapOrderDTO>
	 */
	List<OdsScrapOrderDTO> getOdsScrapOrderListByParm(OdsScrapOrderDTO dto);
	
	public String getScrapSequence();
	
	public String saveScrapOrder(List<OdsScrapOrderDTO> list, OdsScrapOrderDTO dto);

	/**
	 * @title: checkScrapOrderByPDA
	 * @description: 手持Scrap_ 订单扫描检查 
	 * @author: LJZ
	 * @date: 2018年11月13日 上午10:24:38 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkScrapOrderByPDA(OrderCheckInDTO dto);

	/**  
	* @Title: scanStatus  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param orderNo
	* @return List<OdsScrapOrderDTO>
	* @throws  
	*/
	public List<OdsScrapOrderDTO> scanStatus(String orderNo);
	
	/** 
	* @Title: updateCostCenter 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年7月9日
	* @return int    返回类型 
	* @throws 
	*/
	public int updateCostCenter(OdsScrapOrderDTO dto);
}
