package com.haier.openplatform.wms.consume.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeScanInfoServiceClient.java
 * @description: 领用单ServiceClient
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

public interface OdsConsumeScanInfoServiceClient {

	/**
	 * @title: searchOdsConsumeScanInfoByPage
	 * @description: 根据条件分页查询Consume Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:15:17 
	 * @param page
	 * @param rows
	 * @param OdsConsumeScanInfoDTO
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	Pager<OdsConsumeScanInfoDTO> searchOdsConsumeScanInfoByPage(Long page, Long rows, OdsConsumeScanInfoDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 条件统计Consume数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午3:49:28 
	 * @param OdsOrderInfoDtlDTO
	 * @return: Long
	 */
	Long getExportAmount(OdsConsumeScanInfoDTO dto);

	/**
	 * @title: getOdsConsumeScanInfos
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月18日 下午4:03:26 
	 * @param dto
	 * @return: List<OdsConsumeScanInfoDTO>
	 */
	List<OdsConsumeScanInfoDTO> getOdsConsumeScanInfos(OdsConsumeScanInfoDTO dto);

}
