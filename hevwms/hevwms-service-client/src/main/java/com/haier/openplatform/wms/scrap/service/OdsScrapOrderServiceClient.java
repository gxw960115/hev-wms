package com.haier.openplatform.wms.scrap.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapOrderServiceClient.java
 * @description: Scrap Order Client
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:42:11
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

public interface OdsScrapOrderServiceClient {

	/**
	 * @title: searchOdsScrapOrderByPage
	 * @description: 条件分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午2:50:33 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: Pager<OdsScrapOrderDTO>
	 */
	Pager<OdsScrapOrderDTO> searchOdsScrapOrderByPage(Long page, Long rows, OdsScrapOrderDTO dto);

	/**
	 * @title: deleteScrapOrder
	 * @description: 删除scrapOrder
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月23日 下午6:37:26 
	 * @param idList
	 * @return: int
	 */
	int deleteScrapOrder(List<Long> idList);

	/**
	 * @title: approveScrapOrder
	 * @description: 报废单确认
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 上午11:18:56 
	 * @param idList
	 * @return: int
	 */
	int approveScrapOrder(List<Long> idList, String userName);

	/**
	 * @title: getExportAmount
	 * @description: 查询导出条数
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午5:02:26 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsScrapOrderDTO dto);

	/**
	 * @title: getOdsScrapOrderByList
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月24日 下午6:09:36 
	 * @param dto
	 * @return: List<OdsScrapOrderDTO>
	 */
	List<OdsScrapOrderDTO> getOdsScrapOrderByList(OdsScrapOrderDTO dto);
	
    /** 
    * @Title: getScrapSequence 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String getScrapSequence();
    
    /** 
    * @Title: saveScrapOrder 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param list
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String saveScrapOrder(List<OdsScrapOrderDTO> list, OdsScrapOrderDTO dto);
    
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
