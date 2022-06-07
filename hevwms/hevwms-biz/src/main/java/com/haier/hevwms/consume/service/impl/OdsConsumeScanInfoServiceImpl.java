package com.haier.hevwms.consume.service.impl;

import java.util.List;

import com.haier.hevwms.consume.dao.OdsConsumeScanInfoDAO;
import com.haier.hevwms.consume.service.OdsConsumeScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeScanInfoServiceImpl.java
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

public class OdsConsumeScanInfoServiceImpl implements OdsConsumeScanInfoService {

	private OdsConsumeScanInfoDAO odsConsumeScanInfoDAO;
	
	/**
	 * 分页条件查询
	 */
	@Override
	public Pager<OdsConsumeScanInfoDTO> searchOdsConsumeScanInfoByPage(
			Pager<OdsConsumeScanInfoDTO> pager, OdsConsumeScanInfoDTO dto) {
		List<OdsConsumeScanInfoDTO> result = odsConsumeScanInfoDAO.searchOdsConsumeScanInfoByPage(pager, dto);
		Long size = odsConsumeScanInfoDAO.searchOdsConsumeScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}

	/**
	 * 根据条件，获取数量
	 */
	@Override
	public Long getExportAmount(OdsConsumeScanInfoDTO dto) {
		return odsConsumeScanInfoDAO.searchOdsConsumeScanInfoCount(dto);
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<OdsConsumeScanInfoDTO> getOdsConsumeScanInfos(OdsConsumeScanInfoDTO dto) {
		return odsConsumeScanInfoDAO.getListByParam(dto);
	}

	/** get and set */
	public OdsConsumeScanInfoDAO getOdsConsumeScanInfoDAO() {
		return odsConsumeScanInfoDAO;
	}

	public void setOdsConsumeScanInfoDAO(OdsConsumeScanInfoDAO odsConsumeScanInfoDAO) {
		this.odsConsumeScanInfoDAO = odsConsumeScanInfoDAO;
	}

}
