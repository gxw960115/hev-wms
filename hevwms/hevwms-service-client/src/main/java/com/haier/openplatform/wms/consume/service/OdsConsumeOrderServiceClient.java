package com.haier.openplatform.wms.consume.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeOrderServiceClient.java
 * @description: 领用单ServiceClient
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:42:11
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

public interface OdsConsumeOrderServiceClient {

	/**
	 * @title: searchOdsConsumeOrderByPage
	 * @description: 条件分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午2:50:33 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: Pager<OdsConsumeOrderDTO>
	 */
	Pager<OdsConsumeOrderDTO> searchOdsConsumeOrderByPage(Long page, Long rows, OdsConsumeOrderDTO dto);

	/**
	 * @title: deleteConsumeOrder
	 * @description: 删除consumeOrder
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午6:37:26 
	 * @param idList
	 * @return: int
	 */
	int deleteConsumeOrder(List<Long> idList);

	/**
	 * @title: approveConsumeOrder
	 * @description: 领用单确认
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:18:56 
	 * @param idList
	 * @return: int
	 */
	int approveConsumeOrder(List<Long> idList, String userName);

	/**
	 * @title: getExportAmount
	 * @description: 查询导出条数
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午5:02:26 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsConsumeOrderDTO dto);

	/**
	 * @title: getOdsConsumeOrderByList
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午6:09:36 
	 * @param dto
	 * @return: List<OdsConsumeOrderDTO>
	 */
	List<OdsConsumeOrderDTO> getOdsConsumeOrderByList(OdsConsumeOrderDTO dto);
	
	/** 
	* @Title: getConsumeSequence 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String getConsumeSequence();
    
    /** 
    * @Title: saveConsumeOrder 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param list
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String saveConsumeOrder(List<OdsConsumeOrderDTO> list, OdsConsumeOrderDTO dto);
    
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
