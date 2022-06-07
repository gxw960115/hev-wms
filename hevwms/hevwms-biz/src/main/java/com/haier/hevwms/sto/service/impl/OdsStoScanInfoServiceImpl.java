package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.sto.dao.OdsStoScanInfoDAO;
import com.haier.hevwms.sto.service.OdsStoScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnScanInfoDTO;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoScanInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午1:46:15
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public class OdsStoScanInfoServiceImpl implements OdsStoScanInfoService {

	private OdsStoScanInfoDAO odsStoScanInfoDAO;

	public OdsStoScanInfoDAO getOdsStoScanInfoDAO() {
		return odsStoScanInfoDAO;
	}

	public void setOdsStoScanInfoDAO(OdsStoScanInfoDAO odsStoScanInfoDAO) {
		this.odsStoScanInfoDAO = odsStoScanInfoDAO;
	}

	@Override
	public Pager<OdsStoScanInfoDTO> searchOdsStoScanInfoByPage(Pager<OdsStoScanInfoDTO> pager, OdsStoScanInfoDTO dto) {
		List<OdsStoScanInfoDTO> result = odsStoScanInfoDAO.searchOdsStoScanInfoByPage(pager, dto);
		Long size = odsStoScanInfoDAO.searchOdsStoScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}

	@Override
	public Long getExportAmount(OdsStoScanInfoDTO dto) {
		return odsStoScanInfoDAO.searchOdsStoScanInfoCount(dto);
	}

	@Override
	public List<OdsStoScanInfoDTO> getOdsStoScanInfos(OdsStoScanInfoDTO dto) {
		return odsStoScanInfoDAO.getListByParam(dto);
	}

	@Override
	public List<OdsStoScanInfoDTO> getOdsStodnScanInfo(OdsStoScanInfoDTO dto) {
		return odsStoScanInfoDAO.getOdsStodnScanInfo(dto);
	}

	@Override
	public List<OdsStoScanInfoDTO> getListByBarcodes(String orderNo, String barcodes) {
		return odsStoScanInfoDAO.getListByBarcodes(orderNo, barcodes);
	}

	@Override
	public Long getOdsStoDnScanInfoCountByParm(OdsStodnScanInfoDTO dto) {
		return odsStoScanInfoDAO.searchOdsStoDnScanInfosCount(dto);
	}

	@Override
	public List<OdsStodnScanInfoDTO> getStoDnListByParm(OdsStodnScanInfoDTO dto) {
		return odsStoScanInfoDAO.searchStoDnList(dto);
	}

}
