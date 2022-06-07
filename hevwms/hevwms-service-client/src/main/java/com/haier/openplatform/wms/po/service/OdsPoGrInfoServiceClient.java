package com.haier.openplatform.wms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoGrInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午2:52:40
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public interface OdsPoGrInfoServiceClient {

	/**
	 * @title: searchOdsPoGrInfo
	 * @description: "见名知意"、"常用取简"、"专用取繁"
	 * @author: LJZ
	 * @date: 2018年11月14日 下午5:50:20 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return: Pager<OdsPoScanInfoDTO>
	 */
	Pager<OdsPoGrInfoDTO> searchOdsPoGrInfoListByPage(Long page, Long rows,
			OdsPoGrInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: "见名知意"、"常用取简"、"专用取繁"
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:01:40 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsPoGrInfoDTO dto);

	/**
	 * @title: getOdsPoGrInfoListByParm
	 * @description: "见名知意"、"常用取简"、"专用取繁"
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:01:51 
	 * @param dto
	 * @return: List<OdsPoGrInfoDTO>
	 */
	List<OdsPoGrInfoDTO> getOdsPoGrInfoListByParm(OdsPoGrInfoDTO dto);

}
