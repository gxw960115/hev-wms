package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.hevwms.sto.service.OdsStoGigrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsStoGigrInfoServiceImpl.java
 * @description:
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午4:10:29
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public class OdsStoGigrInfoServiceImpl implements OdsStoGigrInfoService {
	private OdsStoGigrInfoDAO odsStoGigrInfoDAO;

	public OdsStoGigrInfoDAO getOdsStoGigrInfoDAO() {
		return odsStoGigrInfoDAO;
	}

	public void setOdsStoGigrInfoDAO(OdsStoGigrInfoDAO odsStoGigrInfoDAO) {
		this.odsStoGigrInfoDAO = odsStoGigrInfoDAO;
	}

	/**
	 * 分页
	 */
	@Override
	public Pager<OdsStoGigrInfoDTO> getListByPage(
			Pager<OdsStoGigrInfoDTO> pager, OdsStoGigrInfoDTO dto) {
		List<OdsStoGigrInfoDTO> list = odsStoGigrInfoDAO.searchOdsStoGiGrInfos(pager, dto);
		Long size = odsStoGigrInfoDAO.searchOdsStoGiGrInfosCount(dto);
		return Pager.cloneFromPager(pager, size, list);
	}

	/**
	 * 统计
	 */
	@Override
	public Long getOdsStoGigrInfoCountByParm(OdsStoGigrInfoDTO dto) {
		return odsStoGigrInfoDAO.searchOdsStoGiGrInfosCount(dto);
	}

	/**
	 * 统计
	 */
	@Override
	public Long getOdsStoDnGigrInfoCountByParm(OdsStodnGigrInfoDTO dto) {
		return odsStoGigrInfoDAO.searchOdsStoDnGiGrInfosCount(dto);
	}

	/**
	 * 条件
	 */
	@Override
	public List<OdsStoGigrInfoDTO> getListByParm(OdsStoGigrInfoDTO dto) {
		return odsStoGigrInfoDAO.searchList(dto);
	}

	/**
	 * 条件
	 */
	@Override
	public List<OdsStodnGigrInfoDTO> getStoDnListByParm(OdsStodnGigrInfoDTO dto) {
		return odsStoGigrInfoDAO.searchStoDnList(dto);
	}

	/**
	 * 根据orderNo修改
	 * @param vnptNo
	 * @param orderNo
	 */
	@Override
	public void updateByOrderNo(String stodnNo, String materialDesp, String vnptNo) {
		odsStoGigrInfoDAO.updateByOrderNo(stodnNo, materialDesp, vnptNo);
	}

}
