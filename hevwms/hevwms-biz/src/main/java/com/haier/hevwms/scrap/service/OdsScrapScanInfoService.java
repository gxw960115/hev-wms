package com.haier.hevwms.scrap.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapScanInfoService.java
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

public interface OdsScrapScanInfoService {
	Pager<OdsScrapScanInfoDTO> searchOdsScrapScanInfoByPage(Pager<OdsScrapScanInfoDTO> pager, OdsScrapScanInfoDTO dto);
	Long getExportAmount(OdsScrapScanInfoDTO dto);
	List<OdsScrapScanInfoDTO> getOdsScrapScanInfos(OdsScrapScanInfoDTO dto);
}
