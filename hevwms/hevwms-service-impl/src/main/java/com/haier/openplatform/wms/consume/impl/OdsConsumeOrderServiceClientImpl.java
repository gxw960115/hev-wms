package com.haier.openplatform.wms.consume.impl;

import java.util.List;

import com.haier.hevwms.consume.service.OdsConsumeOrderService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OdsConsumeOrderServiceClientImpl.java
 * @description: 领用单功能
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

public class OdsConsumeOrderServiceClientImpl implements
		OdsConsumeOrderServiceClient {
	private OdsConsumeOrderService odsConsumeOrderService;

	public OdsConsumeOrderService getOdsConsumeOrderService() {
		return odsConsumeOrderService;
	}

	public void setOdsConsumeOrderService(OdsConsumeOrderService odsConsumeOrderService) {
		this.odsConsumeOrderService = odsConsumeOrderService;
	}

	/* (非 Javadoc) 
	* <p>Title: searchOdsConsumeOrderByPage</p> 
	* <p>Description: </p> 
	* @param page
	* @param rows
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#searchOdsConsumeOrderByPage(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO) 
	*/
	@Override
	public Pager<OdsConsumeOrderDTO> searchOdsConsumeOrderByPage(Long page, Long rows, OdsConsumeOrderDTO dto) {
		Pager<OdsConsumeOrderDTO> pager = new Pager<OdsConsumeOrderDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsConsumeOrderService.searchOdsConsumeOrderByPage(pager, dto);
		return pager;
	}

	/* (非 Javadoc) 
	* <p>Title: deleteConsumeOrder</p> 
	* <p>Description: </p> 
	* @param idList
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#deleteConsumeOrder(java.util.List) 
	*/
	@Override
	public int deleteConsumeOrder(List<Long> idList) {
		
		return odsConsumeOrderService.deleteConsumeOrder(idList);
	}

	/* (非 Javadoc) 
	* <p>Title: approveConsumeOrder</p> 
	* <p>Description: </p> 
	* @param idList
	* @param userName
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#approveConsumeOrder(java.util.List, java.lang.String) 
	*/
	@Override
	public int approveConsumeOrder(List<Long> idList, String userName) {
		return odsConsumeOrderService.confirmConsumeOrder(idList, userName);
	}

	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#getExportAmount(com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO) 
	*/
	@Override
	public Long getExportAmount(OdsConsumeOrderDTO dto) {
		return odsConsumeOrderService.getExportAmount(dto);
	}

	/* (非 Javadoc) 
	* <p>Title: getOdsConsumeOrderByList</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#getOdsConsumeOrderByList(com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO) 
	*/
	@Override
	public List<OdsConsumeOrderDTO> getOdsConsumeOrderByList(OdsConsumeOrderDTO dto) {
		return odsConsumeOrderService.getOdsConsumeOrderListByParm(dto);
	}

	/* (non-Javadoc)  
	 * <p>Title: getConsumeSequence</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#getConsumeSequence()  
	 */
	@Override
	public String getConsumeSequence() {
		return odsConsumeOrderService.getConsumeSequence();
	}

	/* (non-Javadoc)  
	 * <p>Title: saveConsumeOrder</p>  
	 * <p>Description: </p>  
	 * @param list
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient#saveConsumeOrder(java.util.List, com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO)  
	 */
	@Override
	public String saveConsumeOrder(List<OdsConsumeOrderDTO> list,
			OdsConsumeOrderDTO dto) {
		return odsConsumeOrderService.saveConsumeOrder(list, dto);
	}

	@Override
	public int updateCostCenter(OdsConsumeOrderDTO dto) {
		return odsConsumeOrderService.updateCostCenter(dto);
	}

}
