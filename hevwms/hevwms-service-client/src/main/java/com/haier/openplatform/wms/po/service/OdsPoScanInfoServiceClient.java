package com.haier.openplatform.wms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoScanInfoServiceClient.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月17日 下午8:13:23
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月17日		LJZ			v1.0.0			create
 */

public interface OdsPoScanInfoServiceClient {

	/**
	 * @title: searchOdsPoScanInfoByPage
	 * @description: 根据条件分页查询PO Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:15:17 
	 * @param page
	 * @param rows
	 * @param OdsPoScanInfoDTO
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	Pager<OdsPoScanInfoDTO> searchOdsPoScanInfoByPage(Long page, Long rows, OdsPoScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 查询Po导出数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午3:49:28 
	 * @param OdsOrderInfoDtlDTO
	 * @return: Long
	 */
	Long getExportAmount(OdsPoScanInfoDTO dto);

	/**
	 * @title: getOdsPoScanInfos
	 * @description: 
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:03:26 
	 * @param dto
	 * @return
	 * @return: List<OdsPoScanInfoDTO>
	 */
	List<OdsPoScanInfoDTO> getOdsPoScanInfos(OdsPoScanInfoDTO dto);

}
