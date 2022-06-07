package com.haier.hevwms.so.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoScanInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午1:14:47
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public interface OdsSoScanInfoService {
	Pager<OdsSoScanInfoDTO> searchOdsSoScanInfoByPage(Pager<OdsSoScanInfoDTO> pager, OdsSoScanInfoDTO dto);
	Long getExportAmount(OdsSoScanInfoDTO dto);
	List<OdsSoScanInfoDTO> getOdsSoScanInfos(OdsSoScanInfoDTO dto);
	List<OdsSoScanInfoDTO> getListByBarcodes(String barcodes);
	
	public ExecuteResult<OdsSoScanInfoDTO> updateOldBarcode(OdsSoScanInfoDTO odsSoScanInfoDTO) ;
}
