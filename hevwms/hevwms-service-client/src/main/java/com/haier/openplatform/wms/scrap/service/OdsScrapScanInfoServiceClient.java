package com.haier.openplatform.wms.scrap.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapScanInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月22日 下午8:13:23
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月22日		LJZ			v1.0.0			create
 */

public interface OdsScrapScanInfoServiceClient {

	/**
	 * @title: searchOdsScrapScanInfoByPage
	 * @description: 根据条件分页查询Scrap Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:15:17 
	 * @param page
	 * @param rows
	 * @param OdsScrapScanInfoDTO
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	Pager<OdsScrapScanInfoDTO> searchOdsScrapScanInfoByPage(Long page, Long rows, OdsScrapScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 查询Scrap导出数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午3:49:28 
	 * @param OdsOrderInfoDtlDTO
	 * @return: Long
	 */
	Long getExportAmount(OdsScrapScanInfoDTO dto);

	/**
	 * @title: getOdsScrapScanInfos
	 * @description: 根据条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:03:26 
	 * @param dto
	 * @return
	 * @return: List<OdsScrapScanInfoDTO>
	 */
	List<OdsScrapScanInfoDTO> getOdsScrapScanInfos(OdsScrapScanInfoDTO dto);

}
