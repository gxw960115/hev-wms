package com.haier.hevwms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoScanInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月17日 下午8:27:19
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月17日		LJZ			v1.0.0			create
 */

public interface OdsPoScanInfoService {

	/**
	 * @title: searchOdsPoScanInfoByPage
	 * @description: 分页查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:29:12 
	 * @param pager
	 * @param dto
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	Pager<OdsPoScanInfoDTO> searchOdsPoScanInfoByPage(Pager<OdsPoScanInfoDTO> pager, OdsPoScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 获取导出数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:44:49 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsPoScanInfoDTO dto);

	/**
	 * @title: getOdsPoScanInfos
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:46:23 
	 * @param dto
	 * @return: List<OdsPoScanInfoDTO>
	 */
	List<OdsPoScanInfoDTO> getOdsPoScanInfos(OdsPoScanInfoDTO dto);
	
}
