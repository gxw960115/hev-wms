package com.haier.openplatform.wms.consume.impl;

import java.util.List;

import com.haier.hevwms.consume.service.OdsConsumeScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeScanInfoServiceClientImpl.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月22日 上午10:20:16
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月22日		LJZ			v1.0.0			create
 */

public class OdsConsumeScanInfoServiceClientImpl implements
		OdsConsumeScanInfoServiceClient {
	
	private OdsConsumeScanInfoService odsConsumeScanInfoService;
	
	/* (非 Javadoc) 
	* <p>Title: searchOdsConsumeScanInfoByPage</p> 
	* <p>Description: </p> 
	* @param page
	* @param rows
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient#searchOdsConsumeScanInfoByPage(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO) 
	*/
	@Override
	public Pager<OdsConsumeScanInfoDTO> searchOdsConsumeScanInfoByPage(Long page,
			Long rows, OdsConsumeScanInfoDTO dto) {
		Pager<OdsConsumeScanInfoDTO> pager = new Pager<OdsConsumeScanInfoDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsConsumeScanInfoService.searchOdsConsumeScanInfoByPage(pager, dto);
		return pager;
	}

	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient#getExportAmount(com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO) 
	*/
	@Override
	public Long getExportAmount(OdsConsumeScanInfoDTO dto) {
		return odsConsumeScanInfoService.getExportAmount(dto);
	}

	/* (非 Javadoc) 
	* <p>Title: getOdsConsumeScanInfos</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient#getOdsConsumeScanInfos(com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO) 
	*/
	@Override
	public List<OdsConsumeScanInfoDTO> getOdsConsumeScanInfos(
			OdsConsumeScanInfoDTO dto) {
		return odsConsumeScanInfoService.getOdsConsumeScanInfos(dto);
	}

	public OdsConsumeScanInfoService getOdsConsumeScanInfoService() {
		return odsConsumeScanInfoService;
	}

	public void setOdsConsumeScanInfoService(OdsConsumeScanInfoService odsConsumeScanInfoService) {
		this.odsConsumeScanInfoService = odsConsumeScanInfoService;
	}

}
