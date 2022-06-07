package com.haier.openplatform.wms.po.impl;

import java.util.List;

import com.haier.hevwms.po.service.OdsPoScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoScanInfoServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoScanInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月17日 下午8:21:37
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月17日		LJZ			v1.0.0			create
 */

public class OdsPoScanInfoServiceClientImpl implements OdsPoScanInfoServiceClient {

	private OdsPoScanInfoService odsPoScanInfoService;
	
	public OdsPoScanInfoService getOdsPoScanInfoService() {
		return odsPoScanInfoService;
	}

	public void setOdsPoScanInfoService(OdsPoScanInfoService odsPoScanInfoService) {
		this.odsPoScanInfoService = odsPoScanInfoService;
	}
	
	/**
	 * @title: searchOdsPoScanInfoByPage
	 * @description: 根据条件分页查询PO Scan Info
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年10月17日 下午8:15:17 
	 * @param page
	 * @param rows
	 * @param dto
	 * @return
	 * @return: Pager<OdsOrderInfoDtlDTO>
	 */
	@Override
	public Pager<OdsPoScanInfoDTO> searchOdsPoScanInfoByPage(Long page, Long rows, OdsPoScanInfoDTO dto) {
		Pager<OdsPoScanInfoDTO> pager = new Pager<OdsPoScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsPoScanInfoService.searchOdsPoScanInfoByPage(pager, dto);
		return pager;
	}
	
	/**
	 * 
	 */
	@Override
	public Long getExportAmount(OdsPoScanInfoDTO dto) {
		return odsPoScanInfoService.getExportAmount(dto);
	}
	
	/**
	 * 
	 */
	@Override
	public List<OdsPoScanInfoDTO> getOdsPoScanInfos(OdsPoScanInfoDTO dto) {
		return odsPoScanInfoService.getOdsPoScanInfos(dto);
	}
	
}
