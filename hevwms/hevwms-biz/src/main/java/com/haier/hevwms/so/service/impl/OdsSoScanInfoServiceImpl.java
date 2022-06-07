package com.haier.hevwms.so.service.impl;

import java.util.List;

import com.haier.hevwms.so.dao.OdsSoScanInfoDAO;
import com.haier.hevwms.so.service.OdsSoScanInfoService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsSoScanInfoServiceImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月19日 下午1:15:57
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月19日		LJZ			v1.0.0			create
 */

public class OdsSoScanInfoServiceImpl implements OdsSoScanInfoService {
	
	private OdsSoScanInfoDAO odsSoScanInfoDAO;

	public OdsSoScanInfoDAO getOdsSoScanInfoDAO() {
		return odsSoScanInfoDAO;
	}

	public void setOdsSoScanInfoDAO(OdsSoScanInfoDAO odsSoScanInfoDAO) {
		this.odsSoScanInfoDAO = odsSoScanInfoDAO;
	}
	
	@Override
	public Pager<OdsSoScanInfoDTO> searchOdsSoScanInfoByPage(Pager<OdsSoScanInfoDTO> pager, OdsSoScanInfoDTO dto) {
		List<OdsSoScanInfoDTO> result = odsSoScanInfoDAO.searchOdsSoScanInfoByPage(pager, dto);
		long size = odsSoScanInfoDAO.searchOdsSoScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}
	
	/**
	 * 统计导出的数据
	 */
	@Override
	public Long getExportAmount(OdsSoScanInfoDTO dto) {
		return odsSoScanInfoDAO.searchOdsSoScanInfoCount(dto);
	}
	
	/**
	 * 获取导出excel的数据
	 */
	@Override
	public List<OdsSoScanInfoDTO> getOdsSoScanInfos(OdsSoScanInfoDTO dto) {
		return odsSoScanInfoDAO.getListByParam(dto);
	}

	/**
	 * 条码获取信息
	 * @param barcodes
	 * @return
	 */
	@Override
	public List<OdsSoScanInfoDTO> getListByBarcodes(String barcodes) {
		return odsSoScanInfoDAO.getListByBarcodes(barcodes);
	}

	@Override
	public ExecuteResult<OdsSoScanInfoDTO> updateOldBarcode(
			OdsSoScanInfoDTO odsSoScanInfoDTO) {
		ExecuteResult<OdsSoScanInfoDTO> executeResult = new ExecuteResult<OdsSoScanInfoDTO>();
		
		int count = odsSoScanInfoDAO.updateOldBarcode(odsSoScanInfoDTO);
		if (count != 0){
			executeResult.setResult(odsSoScanInfoDTO);
		} 
		return executeResult;
	}
}
