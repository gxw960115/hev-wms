package com.haier.openplatform.wms.inventory.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient;

public class OdsInventoryInfoDtlServiceClientImpl implements OdsInventoryInfoDtlServiceClient {
	private OdsInventoryInfoDtlService odsInventoryInfoDtlService;

	/* (非 Javadoc) 
	* <p>Title: addInventory</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#addInventory(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public String addInventory(OdsInventoryInfoDtlDTO dto) {
		return odsInventoryInfoDtlService.addInventory(dto);
	}
	
	/* (非 Javadoc) 
	* <p>Title: deleteInventory</p> 
	* <p>Description: </p> 
	* @param barcode
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#deleteInventory(java.lang.String) 
	*/
	@Override
	public String deleteInventory(String barcode) {
		return odsInventoryInfoDtlService.deleteInventory(barcode);
	}

	/* (非 Javadoc) 
	* <p>Title: createOdsInventoryInfoDtlDTO</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#createOdsInventoryInfoDtlDTO(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public ExecuteResult<OdsInventoryInfoDtlDTO> createOdsInventoryInfoDtlDTO(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: updateOdsInventoryInfoDtlDTO</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#updateOdsInventoryInfoDtlDTO(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public ExecuteResult<OdsInventoryInfoDtlDTO> updateOdsInventoryInfoDtlDTO(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: deleteOdsInventoryInfoDtlDTO</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTOId
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#deleteOdsInventoryInfoDtlDTO(java.lang.Long) 
	*/
	@Override
	public ExecuteResult<OdsInventoryInfoDtlDTO> deleteOdsInventoryInfoDtlDTO(
			Long odsInventoryInfoDtlDTOId) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: deleteOdsInventoryInfoDtlDTOAll</p> 
	* <p>Description: </p> 
	* @param idList
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#deleteOdsInventoryInfoDtlDTOAll(java.util.List) 
	*/
	@Override
	public ExecuteResult<OdsInventoryInfoDtlDTO> deleteOdsInventoryInfoDtlDTOAll(
			List<Long> idList) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: searchOdsInventoryInfoDtlDTOs</p> 
	* <p>Description: </p> 
	* @param page
	* @param rows
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#searchOdsInventoryInfoDtlDTOs(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryInfoDtlDTOs(
			Long page, Long rows, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		OdsInventoryInfoDtl dtl = new OdsInventoryInfoDtl();
		try {
			BeanUtils.copyProperties(dtl, odsInventoryInfoDtlDTO);// 把dto
																	// 照order复制一下？
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		Pager<OdsInventoryInfoDtl> pager = new Pager<OdsInventoryInfoDtl>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		pager = odsInventoryInfoDtlService.searchOdsInventoryInfoDtls(pager,
				dtl);
		Pager<OdsInventoryInfoDtlDTO> pager2 = new Pager<OdsInventoryInfoDtlDTO>();
		try {
			BeanUtils.copyProperties(pager2, pager);// 把dto 照order复制一下？
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return pager2;
	}

	/* (非 Javadoc) 
	* <p>Title: getOdsInventoryInfoDtlDTOById</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTOId
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#getOdsInventoryInfoDtlDTOById(java.lang.Long) 
	*/
	@Override
	public OdsInventoryInfoDtlDTO getOdsInventoryInfoDtlDTOById(
			Long odsInventoryInfoDtlDTOId) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: getOdsInventoryInfoDtlDTOs</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#getOdsInventoryInfoDtlDTOs() 
	*/
	@Override
	public List<OdsInventoryInfoDtlDTO> getOdsInventoryInfoDtlDTOs() {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: searchDiffInventorys</p> 
	* <p>Description: </p> 
	* @param pager
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#searchDiffInventorys(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public Pager<OdsInventoryInfoDtlDTO> searchDiffInventorys(
			Pager<OdsInventoryInfoDtlDTO> pager,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: getDiffInventoryByParam</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#getDiffInventoryByParam(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public List<OdsInventoryInfoDtlDTO> getDiffInventoryByParam(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		
		return null;
	}

	/* (非 Javadoc) 
	* <p>Title: getOdsInventoryInfoDtlDTOByParam</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient#getOdsInventoryInfoDtlDTOByParam(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public List<OdsInventoryInfoDtlDTO> getOdsInventoryInfoDtlDTOByParam(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		
		return null;
	}

	public OdsInventoryInfoDtlService getOdsInventoryInfoDtlService() {
		return odsInventoryInfoDtlService;
	}

	public void setOdsInventoryInfoDtlService(
			OdsInventoryInfoDtlService odsInventoryInfoDtlService) {
		this.odsInventoryInfoDtlService = odsInventoryInfoDtlService;
	}

}
