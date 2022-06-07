package com.haier.hevwms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoScanInfoService.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午1:44:51
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public interface OdsStoScanInfoService {
	Pager<OdsStoScanInfoDTO> searchOdsStoScanInfoByPage(Pager<OdsStoScanInfoDTO> pager, OdsStoScanInfoDTO dto);
	Long getExportAmount(OdsStoScanInfoDTO dto);
	List<OdsStoScanInfoDTO> getOdsStoScanInfos(OdsStoScanInfoDTO dto);
	List<OdsStoScanInfoDTO> getOdsStodnScanInfo(OdsStoScanInfoDTO dto);
	List<OdsStoScanInfoDTO> getListByBarcodes(String orderNo, String barcodes);

	/**
	 * @title: getOdsStoDnScanInfoCountByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @param dto
	 * @return: Long
	 */
	Long getOdsStoDnScanInfoCountByParm(OdsStodnScanInfoDTO dto);

	/**
	 * @title: getListByParm
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月15日 下午6:10:15
	 * @param dto
	 * @return: List<OdsStoGigrInfoDTO>
	 */
	List<OdsStodnScanInfoDTO> getStoDnListByParm(OdsStodnScanInfoDTO dto);
}
