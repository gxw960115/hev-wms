package com.haier.hevwms.so.service.impl;

import java.util.List;

import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.hevwms.so.service.OdsSoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoGrInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月18日 下午7:08:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月18日		LJZ			v1.0.0			create
 */

public class OdsSoGrInfoServiceImpl implements OdsSoGrInfoService {

	private OdsSoGrInfoDAO odsSoGrInfoDAO;
	
	public OdsSoGrInfoDAO getOdsSoGrInfoDAO() {
		return odsSoGrInfoDAO;
	}
	public void setOdsSoGrInfoDAO(OdsSoGrInfoDAO odsSoGrInfoDAO) {
		this.odsSoGrInfoDAO = odsSoGrInfoDAO;
	}

	/*
	 * 分页
	 */
	@Override
	public Pager<OdsSoGrInfoDTO> searchOdsSoGrInfoListByPage(
			Pager<OdsSoGrInfoDTO> pager, OdsSoGrInfoDTO dto) {
		Long size = odsSoGrInfoDAO.searchOdsSoGrInfoCount(dto);
		List<OdsSoGrInfoDTO> list = odsSoGrInfoDAO.searchOdsSoGrInfoListByPage(pager, dto);
		return Pager.cloneFromPager(pager, size, list);
	}

	/*
	 * 统计
	 */
	@Override
	public Long getExportAmout(OdsSoGrInfoDTO dto) {
		return odsSoGrInfoDAO.searchOdsSoGrInfoCount(dto);
	}

	/*
	 * 条件查询
	 */
	@Override
	public List<OdsSoGrInfoDTO> getListByParm(OdsSoGrInfoDTO dto) {
		return odsSoGrInfoDAO.getOdsSoGrInfoListByParm(dto);
	}

}
