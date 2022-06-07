package com.haier.hevwms.po.service.impl;

import java.util.List;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.hevwms.po.service.OdsPoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoGrInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:23:11
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public class OdsPoGrInfoServiceImpl implements OdsPoGrInfoService {
	private OdsPoGrInfoDAO odsPoGrInfoDAO;

	public OdsPoGrInfoDAO getOdsPoGrInfoDAO() {
		return odsPoGrInfoDAO;
	}
	public void setOdsPoGrInfoDAO(OdsPoGrInfoDAO odsPoGrInfoDAO) {
		this.odsPoGrInfoDAO = odsPoGrInfoDAO;
	}
	
	/**
	 * 分页
	 */
	@Override
	public Pager<OdsPoGrInfoDTO> searchOdsPoGrInfoListByPage(Pager<OdsPoGrInfoDTO> pager,OdsPoGrInfoDTO dto) {
		List<OdsPoGrInfoDTO> result = odsPoGrInfoDAO.searchOdsPoGrInfoListByPage(pager, dto);
		Long sizeLong = odsPoGrInfoDAO.searchOdsPoGrInfoCount(dto);
		return Pager.cloneFromPager(pager, sizeLong, result);
	}
	
	/**
	 * 统计
	 */
	@Override
	public Long getExportAmout(OdsPoGrInfoDTO dto) {
		return odsPoGrInfoDAO.searchOdsPoGrInfoCount(dto);
	}
	
	/**
	 * 条件
	 */
	@Override
	public List<OdsPoGrInfoDTO> getListByParm(OdsPoGrInfoDTO dto) {
		return odsPoGrInfoDAO.searchList(dto);
	}
}
