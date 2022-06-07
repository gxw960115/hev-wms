package com.haier.hevwms.consume.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeOrderService.java
 * @description: 领用单Service
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:38:43
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

/**  
 * @Title: OdsConsumeOrderService.java   
 * @Description: 用一句话描述该文件做什么
 * @author: ZhangLL
 * @date: 2018年12月3日 下午4:31:53   
 * @version: V1.0 
 */  
public interface OdsConsumeOrderService {

	/**
	 * @title: searchOdsConsumeOrderByPage
	 * @description: 分页条件查询
	 * @author: LJZ
	 * @date: 2018年10月23日 下午2:58:08 
	 * @param pager
	 * @param dto
	 * @return: Pager<OdsConsumeOrderDTO>
	 */
	Pager<OdsConsumeOrderDTO> searchOdsConsumeOrderByPage(
			Pager<OdsConsumeOrderDTO> pager, OdsConsumeOrderDTO dto);

	/**
	 * @title: deleteConsumeOrder
	 * @description: 删除 ConsumeOrder
	 * @author: LJZ
	 * @date: 2018年10月23日 下午6:55:07 
	 * @param idList
	 * @return: int
	 */
	public int deleteConsumeOrder(List<Long> idList);

	/**
	 * @title: confirmConsumeOrder
	 * @description: 领用单确认
	 * @author: LJZ
	 * @date: 2018年10月24日 上午11:29:25 
	 * @param idList
	 * @return: int
	 */
	public int confirmConsumeOrder(List<Long> idList, String userName);

	/**
	 * @title: getExportAmount
	 * @description: 查询导出Excel条数
	 * @author: LJZ
	 * @date: 2018年10月24日 下午5:06:13 
	 * @param dto
	 * @return: Long
	 */
	public Long getExportAmount(OdsConsumeOrderDTO dto);

	/**
	 * @title: getOdsConsumeOrderListByParm
	 * @description: 条件查询
	 * @author: LJZ
	 * @date: 2018年10月25日 上午10:27:22 
	 * @param dto
	 * @return: List<OdsConsumeOrderDTO>
	 */
	List<OdsConsumeOrderDTO> getOdsConsumeOrderListByParm(OdsConsumeOrderDTO dto);
	
	public String getConsumeSequence();
	
	public String saveConsumeOrder(List<OdsConsumeOrderDTO> list, OdsConsumeOrderDTO dto);

	/**
	 * @title: checkConsumeOrderByPDA
	 * @description: 手持Consume_ 订单扫描检查 
	 * @author: LJZ
	 * @date: 2018年11月12日 下午3:38:06 
	 * @param dto
	 * @return: OrderCheckOutDTO
	 */
	public OrderCheckOutDTO checkConsumeOrderByPDA(OrderCheckInDTO dto);

	/**  
	* @Title: scanStatus  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param orderNo
	* @return List<OdsConsumeOrderDTO>
	* @throws  
	*/
	public List<OdsConsumeOrderDTO> scanStatus(String orderNo);
	
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
	public int updateCostCenter(OdsConsumeOrderDTO dto);
	
}
