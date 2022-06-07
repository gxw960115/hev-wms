package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoGigrInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:05:26
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public interface OdsStoGigrInfoServiceClient {

	/**
	 * @title: searchOdsStoGigrInfoByPage
	 * @description: 分页条件查询
	 * @author: LJZ
	 * @date: 2018年11月15日 下午4:29:39 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: Pager<OdsStoGigrInfoDTO>
	 */
	Pager<OdsStoGigrInfoDTO> searchOdsStoGigrInfoByPage(Long page, Long rows,
			OdsStoGigrInfoDTO dto);

	/**
	 * @title: getExportOdsStoGigrInfoAmount
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午5:33:30 
	 * @param dto
	 * @return: Long
	 */
	Long getExportOdsStoGigrInfoAmount(OdsStoGigrInfoDTO dto);

	/**
	 * @title: getExportOdsStoDnGigrInfoAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: Long
	 */
	Long getExportOdsStoDnGigrInfoAmount(OdsStodnGigrInfoDTO dto);

	/**
	 * @title: getStoGigrInfoListByParm
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午6:03:01 
	 * @param dto
	 * @return: List<OdsStoGigrInfoDTO>
	 */
	List<OdsStoGigrInfoDTO> getStoGigrInfoListByParm(OdsStoGigrInfoDTO dto);

	/**
	 * @title: getStoDnGigrInfoListByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: List<OdsStodnGigrInfoDTO>
	 */
	List<OdsStodnGigrInfoDTO> getStoDnGigrInfoListByParm(OdsStodnGigrInfoDTO dto);

//	OrderIgpOutDTO (String makexml, String stodnNo, String materialDesp);

	public OrderIgpOutDTO printVNPT(String makexml, String stodnNo, String materialDesp);

}
