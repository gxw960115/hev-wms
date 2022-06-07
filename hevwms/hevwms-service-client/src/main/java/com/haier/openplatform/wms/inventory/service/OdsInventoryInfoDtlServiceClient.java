package com.haier.openplatform.wms.inventory.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

public interface OdsInventoryInfoDtlServiceClient {

	/** 
	* @Title: addInventory 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	String addInventory(OdsInventoryInfoDtlDTO dto);

	/** 
	* @Title: deleteInventory 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param barcode
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	String deleteInventory(String barcode);

	/** 
	* @Title: createOdsInventoryInfoDtlDTO 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return ExecuteResult<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public ExecuteResult<OdsInventoryInfoDtlDTO> createOdsInventoryInfoDtlDTO(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/** 
	* @Title: updateOdsInventoryInfoDtlDTO 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return ExecuteResult<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public ExecuteResult<OdsInventoryInfoDtlDTO> updateOdsInventoryInfoDtlDTO(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/** 
	* @Title: deleteOdsInventoryInfoDtlDTO 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTOId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return ExecuteResult<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public ExecuteResult<OdsInventoryInfoDtlDTO> deleteOdsInventoryInfoDtlDTO(
			Long odsInventoryInfoDtlDTOId);

	/** 
	* @Title: deleteOdsInventoryInfoDtlDTOAll 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return ExecuteResult<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public ExecuteResult<OdsInventoryInfoDtlDTO> deleteOdsInventoryInfoDtlDTOAll(
			List<Long> idList);

	/** 
	* @Title: searchOdsInventoryInfoDtlDTOs 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryInfoDtlDTOs(
			Long page,Long rows,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/** 
	* @Title: getOdsInventoryInfoDtlDTOById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTOId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return OdsInventoryInfoDtlDTO    返回类型 
	* @throws 
	*/
	public OdsInventoryInfoDtlDTO getOdsInventoryInfoDtlDTOById(
			Long odsInventoryInfoDtlDTOId);

	/** 
	* @Title: getOdsInventoryInfoDtlDTOs 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public List<OdsInventoryInfoDtlDTO> getOdsInventoryInfoDtlDTOs();

	/** 
	* @Title: searchDiffInventorys 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pager
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public Pager<OdsInventoryInfoDtlDTO> searchDiffInventorys(
			Pager<OdsInventoryInfoDtlDTO> pager,
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/** 
	* @Title: getDiffInventoryByParam 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public List<OdsInventoryInfoDtlDTO> getDiffInventoryByParam(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

	/** 
	* @Title: getOdsInventoryInfoDtlDTOByParam 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param odsInventoryInfoDtlDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<OdsInventoryInfoDtlDTO>    返回类型 
	* @throws 
	*/
	public List<OdsInventoryInfoDtlDTO> getOdsInventoryInfoDtlDTOByParam(
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
}
