package com.haier.openplatform.wms.so.impl;

import java.util.List;

import com.haier.hevwms.so.service.OdsSoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.haier.openplatform.wms.so.service.OdsSoGrInfoServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoGrInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午7:14:51
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

public class OdsSoGrInfoServiceClientImpl implements OdsSoGrInfoServiceClient {

	private OdsSoGrInfoService odsSoGrInfoService;
	
	public OdsSoGrInfoService getOdsSoGrInfoService() {
		return odsSoGrInfoService;
	}
	public void setOdsSoGrInfoService(OdsSoGrInfoService odsSoGrInfoService) {
		this.odsSoGrInfoService = odsSoGrInfoService;
	}

	/**
	 * 分页
	 */
	@Override
	public Pager<OdsSoGrInfoDTO> searchOdsSoGrInfoListByPage(Long page,
			Long rows, OdsSoGrInfoDTO dto) {
		Pager<OdsSoGrInfoDTO> pager = new Pager<OdsSoGrInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		return odsSoGrInfoService.searchOdsSoGrInfoListByPage(pager, dto);
	}

	/**
	 * 统计
	 */
	@Override
	public Long getExportAmount(OdsSoGrInfoDTO dto) {
		return odsSoGrInfoService.getExportAmout(dto);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<OdsSoGrInfoDTO> getOdsSoGrInfoListByParm(OdsSoGrInfoDTO dto) {
		return odsSoGrInfoService.getListByParm(dto);
	}

}
