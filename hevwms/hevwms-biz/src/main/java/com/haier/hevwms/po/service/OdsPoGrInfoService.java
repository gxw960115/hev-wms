package com.haier.hevwms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoGrInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:22:40
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public interface OdsPoGrInfoService {

	/**
	 * @title: searchOdsPoGrInfoListByPage
	 * @description: searchOdsPoGrInfoListByPage
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:13:23 
	 * @param pager
	 * @return: Long
	 */
	Pager<OdsPoGrInfoDTO> searchOdsPoGrInfoListByPage(Pager<OdsPoGrInfoDTO> pager,OdsPoGrInfoDTO dto);

	/**
	 * @title: getExportAmout
	 * @description: getExportAmout
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:14:28 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmout(OdsPoGrInfoDTO dto);

	/**
	 * @title: getListByParm
	 * @description: getListByParm
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:15:08 
	 * @param dto
	 * @return: List<OdsPoGrInfoDTO>
	 */
	List<OdsPoGrInfoDTO> getListByParm(OdsPoGrInfoDTO dto);

}
