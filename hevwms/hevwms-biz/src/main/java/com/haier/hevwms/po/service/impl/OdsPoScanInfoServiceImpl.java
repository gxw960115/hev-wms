package com.haier.hevwms.po.service.impl;

import java.util.List;

import com.haier.hevwms.po.dao.OdsPoScanInfoDAO;
import com.haier.hevwms.po.service.OdsPoScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsPoScanInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月17日 下午8:30:33
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月17日		LJZ			v1.0.0			create
 */
public class OdsPoScanInfoServiceImpl implements OdsPoScanInfoService {

	private OdsPoScanInfoDAO odsPoScanInfoDAO;
	
	public OdsPoScanInfoDAO getOdsPoScanInfoDAO() {
		return odsPoScanInfoDAO;
	}

	public void setOdsPoScanInfoDAO(OdsPoScanInfoDAO odsPoScanInfoDAO) {
		this.odsPoScanInfoDAO = odsPoScanInfoDAO;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public Pager<OdsPoScanInfoDTO> searchOdsPoScanInfoByPage(Pager<OdsPoScanInfoDTO> pager, OdsPoScanInfoDTO dto) {
		List<OdsPoScanInfoDTO> result = odsPoScanInfoDAO.searchOdsPoScanInfoByPage(pager, dto);
		long size = odsPoScanInfoDAO.searchOdsPoScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}
	
	/**
	 * 统计
	 */
	@Override
	public Long getExportAmount(OdsPoScanInfoDTO dto) {
		return odsPoScanInfoDAO.searchOdsPoScanInfoCount(dto);
	}
	
	/**
	 * 条件查询
	 */
	@Override
	public List<OdsPoScanInfoDTO> getOdsPoScanInfos(OdsPoScanInfoDTO dto) {
		return odsPoScanInfoDAO.getListByParam(dto);
	}
}
