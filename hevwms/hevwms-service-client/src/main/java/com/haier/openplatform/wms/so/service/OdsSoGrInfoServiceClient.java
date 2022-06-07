package com.haier.openplatform.wms.so.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoGrInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午7:14:10
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

public interface OdsSoGrInfoServiceClient {
	/**
	 * @title: searchOdsSoGrInfoListByPage
	 * @description: 分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月18日 下午7:16:33 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: Pager<OdsSoGrInfoDTO>
	 */
	Pager<OdsSoGrInfoDTO> searchOdsSoGrInfoListByPage(Long page, Long rows,
			OdsSoGrInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 条件统计
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月18日 下午7:16:44 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsSoGrInfoDTO dto);

	/**
	 * @title: getOdsSoGrInfoListByParm
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月18日 下午7:16:53 
	 * @param dto
	 * @return: List<OdsSoGrInfoDTO>
	 */
	List<OdsSoGrInfoDTO> getOdsSoGrInfoListByParm(OdsSoGrInfoDTO dto);
}
