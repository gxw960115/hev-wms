package com.haier.openplatform.wms.po.impl;

import java.util.List;

import com.haier.hevwms.po.service.OdsPoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoGrInfoServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoGrInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:07:24
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public class OdsPoGrInfoServiceClientImpl implements OdsPoGrInfoServiceClient {
	private OdsPoGrInfoService odsPoGrInfoService;

	public OdsPoGrInfoService getOdsPoGrInfoService() {
		return odsPoGrInfoService;
	}
	public void setOdsPoGrInfoService(OdsPoGrInfoService odsPoGrInfoService) {
		this.odsPoGrInfoService = odsPoGrInfoService;
	}
	
	/**
	 * "见名知意"、"常用取简"、"专用取繁"
	 */
	@Override
	public Pager<OdsPoGrInfoDTO> searchOdsPoGrInfoListByPage(Long page, Long rows, OdsPoGrInfoDTO dto) {
		Pager<OdsPoGrInfoDTO> pager = new Pager<OdsPoGrInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsPoGrInfoService.searchOdsPoGrInfoListByPage(pager,dto);
		return pager;
	}
	
	/**
	 * "见名知意"、"常用取简"、"专用取繁"
	 */
	@Override
	public Long getExportAmount(OdsPoGrInfoDTO dto) {
		return odsPoGrInfoService.getExportAmout(dto);
	}
	
	/**
	 * "见名知意"、"常用取简"、"专用取繁"
	 */
	@Override
	public List<OdsPoGrInfoDTO> getOdsPoGrInfoListByParm(OdsPoGrInfoDTO dto) {
		return odsPoGrInfoService.getListByParm(dto);
	}
}
