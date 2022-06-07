package com.haier.openplatform.wms.scrap.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.haier.hevwms.scrap.service.OdsScrapOrderService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapOrderServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsScrapOrderServiceClientImpl.java
 * @description: 报废单功能
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月23日 下午2:42:34
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月23日		LJZ			v1.0.0			create
 */

public class OdsScrapOrderServiceClientImpl implements
		OdsScrapOrderServiceClient {
	Logger logger = Logger.getLogger(OdsScrapOrderServiceClientImpl.class);
	
	private OdsScrapOrderService odsScrapOrderService;

	public OdsScrapOrderService getOdsScrapOrderService() {
		return odsScrapOrderService;
	}

	public void setOdsScrapOrderService(OdsScrapOrderService odsScrapOrderService) {
		this.odsScrapOrderService = odsScrapOrderService;
	}

	/**
	 * 分页条件查询
	 */
	@Override
	public Pager<OdsScrapOrderDTO> searchOdsScrapOrderByPage(Long page, Long rows, OdsScrapOrderDTO dto) {
		Pager<OdsScrapOrderDTO> pager = new Pager<OdsScrapOrderDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsScrapOrderService.searchOdsScrapOrderByPage(pager, dto);
		return pager;
	}

	/**
	 * 删除 Scrap Order
	 */
	@Override
	public int deleteScrapOrder(List<Long> idList) {
		return odsScrapOrderService.deleteScrapOrder(idList);
	}

	/**
	 * 确认 报废单
	 */
	@Override
	public int approveScrapOrder(List<Long> idList, String userName) {
		return odsScrapOrderService.confirmScrapOrder(idList, userName);
	}

	/**
	 * 查询导出Excel条数
	 */
	@Override
	public Long getExportAmount(OdsScrapOrderDTO dto) {
		return odsScrapOrderService.getExportAmount(dto);
	}

	/**
	 * 条件查询
	 */
	@Override
	public List<OdsScrapOrderDTO> getOdsScrapOrderByList(OdsScrapOrderDTO dto) {
		return odsScrapOrderService.getOdsScrapOrderListByParm(dto);
	}

	/* (non-Javadoc)  
	 * <p>Title: getScrapSequence</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.haier.openplatform.wms.scrap.service.OdsScrapOrderServiceClient#getScrapSequence()  
	 */
	@Override
	public String getScrapSequence() {
		return odsScrapOrderService.getScrapSequence();
	}

	/* (non-Javadoc)  
	 * <p>Title: saveScrapOrder</p>  
	 * <p>Description: </p>  
	 * @param list
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.scrap.service.OdsScrapOrderServiceClient#saveScrapOrder(java.util.List, com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO)  
	 */
	@Override
	public String saveScrapOrder(List<OdsScrapOrderDTO> list, OdsScrapOrderDTO dto) {
		
		return odsScrapOrderService.saveScrapOrder(list, dto);
	}

	@Override
	public int updateCostCenter(OdsScrapOrderDTO dto) {
		// TODO Auto-generated method stub
		return odsScrapOrderService.updateCostCenter(dto);
	}

}
