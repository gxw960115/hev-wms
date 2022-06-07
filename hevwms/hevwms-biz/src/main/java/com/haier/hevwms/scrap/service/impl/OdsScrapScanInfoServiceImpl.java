package com.haier.hevwms.scrap.service.impl;

import java.util.List;

import com.haier.hevwms.scrap.dao.OdsScrapScanInfoDAO;
import com.haier.hevwms.scrap.service.OdsScrapScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapScanInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月22日 下午1:37:01
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月22日		LJZ			v1.0.0			create
 */

public class OdsScrapScanInfoServiceImpl implements OdsScrapScanInfoService {

	private OdsScrapScanInfoDAO odsScrapScanInfoDAO;
	
	/**
	 * 分页条件查询
	 */
	@Override
	public Pager<OdsScrapScanInfoDTO> searchOdsScrapScanInfoByPage(
			Pager<OdsScrapScanInfoDTO> pager, OdsScrapScanInfoDTO dto) {
		List<OdsScrapScanInfoDTO> result = odsScrapScanInfoDAO.searchOdsScrapScanInfoByPage(pager, dto);
		Long size = odsScrapScanInfoDAO.searchOdsScrapScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}

	/**
	 * 根据条件，获取数量
	 */
	@Override
	public Long getExportAmount(OdsScrapScanInfoDTO dto) {
		return odsScrapScanInfoDAO.searchOdsScrapScanInfoCount(dto);
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<OdsScrapScanInfoDTO> getOdsScrapScanInfos(OdsScrapScanInfoDTO dto) {
		return odsScrapScanInfoDAO.getListByParam(dto);
	}

	/** get and set */
	public OdsScrapScanInfoDAO getOdsScrapScanInfoDAO() {
		return odsScrapScanInfoDAO;
	}

	public void setOdsScrapScanInfoDAO(OdsScrapScanInfoDAO odsScrapScanInfoDAO) {
		this.odsScrapScanInfoDAO = odsScrapScanInfoDAO;
	}

}
