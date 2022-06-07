package com.haier.hevwms.consume.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeScanInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月22日 下午1:32:09
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月22日		LJZ			v1.0.0			create
 */

public interface OdsConsumeScanInfoService {
	/**
	 * @title: searchOdsConsumeScanInfoByPage
	 * @description: 分页条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 下午3:37:18 
	 * @param pager
	 * @param dto
	 * @return: Pager<OdsConsumeScanInfoDTO>
	 */
	Pager<OdsConsumeScanInfoDTO> searchOdsConsumeScanInfoByPage(Pager<OdsConsumeScanInfoDTO> pager, OdsConsumeScanInfoDTO dto);
	
	/**
	 * @title: getExportAmount
	 * @description: 获取导出Excel数量
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 下午3:37:34 
	 * @param dto
	 * @return: Long
	 */
	Long getExportAmount(OdsConsumeScanInfoDTO dto);
	
	/**
	 * @title: getOdsConsumeScanInfos
	 * @description: 条件查询
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月25日 下午3:38:00 
	 * @param dto
	 * @return: List<OdsConsumeScanInfoDTO>
	 */
	List<OdsConsumeScanInfoDTO> getOdsConsumeScanInfos(OdsConsumeScanInfoDTO dto);
}
