package com.haier.openplatform.wms.scrap.impl;

import java.util.List;

import com.haier.hevwms.scrap.service.OdsScrapScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapScanInfoServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapScanInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月22日 上午10:20:16
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月22日		LJZ			v1.0.0			create
 */

public class OdsScrapScanInfoServiceClientImpl implements OdsScrapScanInfoServiceClient {
	
	private OdsScrapScanInfoService odsScrapScanInfoService;
	
	/**
	 * 分页查询
	 */
	@Override
	public Pager<OdsScrapScanInfoDTO> searchOdsScrapScanInfoByPage(Long page,Long rows, OdsScrapScanInfoDTO dto) {
		Pager<OdsScrapScanInfoDTO> pager = new Pager<OdsScrapScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsScrapScanInfoService.searchOdsScrapScanInfoByPage(pager, dto);
		return pager;
	}

	/**
	 * 获取导出Excel数量
	 */
	@Override
	public Long getExportAmount(OdsScrapScanInfoDTO dto) {
		return odsScrapScanInfoService.getExportAmount(dto);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<OdsScrapScanInfoDTO> getOdsScrapScanInfos(OdsScrapScanInfoDTO dto) {
		return odsScrapScanInfoService.getOdsScrapScanInfos(dto);
	}

	
	/** get and set */
	public OdsScrapScanInfoService getOdsScrapScanInfoService() {
		return odsScrapScanInfoService;
	}

	public void setOdsScrapScanInfoService(OdsScrapScanInfoService odsScrapScanInfoService) {
		this.odsScrapScanInfoService = odsScrapScanInfoService;
	}

}
