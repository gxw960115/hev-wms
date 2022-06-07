package com.haier.openplatform.wms.basicdata.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;

import io.terminus.pampas.common.BaseUser;


/**  
 * @ClassName: CdLocInfoServiceClientImpl  
 * @Description:
 * @author SJK  
 * @date 2016-4-20  
 */ 
public class CdLocInfoServiceClientImpl implements CdLocInfoServiceClient{

	private CdLocInfoService cdLocInfoService;	

	public CdLocInfoService getCdLocInfoService() {
		return cdLocInfoService;
	}

	public void setCdLocInfoService(CdLocInfoService cdLocInfoService) {
		this.cdLocInfoService = cdLocInfoService;
	}

	/**
	 * <p>Title: SearchCdLocInfo</p>
	 * <p>Description:查询库位 </p>  
	 * @param pager
	 * @param cdLocInfo
	 */
	@Override
	public Pager<CdLocInfoDTO> searchCdLocInfo(Pager<CdLocInfoDTO> pager,CdLocInfoDTO cdLocInfo) {
		return cdLocInfoService.searchCdLocInfos(pager, cdLocInfo);
	}

	@Override
	public List<CdLocInfoDTO> searchCdLocInfoByConditionBc() {
		return cdLocInfoService.searchCdLocInfoByConditionBc();
	}
	
	/**
	 * <p>Title: searchCdLocInfoByCondition</p>  
	 * <p>Description:查询库存地点 </p>  
	 * @param rows
	 * @param page
	 * @param cdLocInfo
	 */
	@Override
	public Pager<CdLocInfoDTO> searchCdLocInfoByCondition(Long rows, Long page,	CdLocInfoDTO cdLocInfo) {
		return cdLocInfoService.searchCdLocInfoByCondition(rows, page, cdLocInfo);
	}
	
	
	/**
	 * <p>Title: createLocInfos</p>  
	 * <p>Description:创建 </p>  
	 * @param dto
	 */
	@Override
	public String createLocInfos(CdLocInfoDTO dto) {
		return cdLocInfoService.createCdLocInfo(dto);
	}

	/**
	 * <p>Title: deleteLocInfo</p>  
	 * <p>Description:删除 </p>  
	 * @param idList
	 */
	@Override
	public String deleteLocInfo(List<Long> idList) {
		return cdLocInfoService.deleteCdLocInfoAll(idList);
	}
	
	/**
	 * <p>Title: deleteLocInfoByIds</p>  
	 * <p>Description:根据id删除 </p>  
	 * @param ids
	 */
	@Override
	public String deleteLocInfoByIds(String ids) {
		List<Long> idList = new ArrayList<Long>();
        for (String id : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(id)) {
                continue;
            }
            idList.add(Long.valueOf(id));
        }
		return cdLocInfoService.updateFlag(idList);
	}

	/**
	 * <p>Title: updateLocInfo</p>  
	 * <p>Description:更新 </p>  
	 * @param dto
	 */
	@Override
	public String updateLocInfo(CdLocInfoDTO dto) {
		return cdLocInfoService.updateCdLocInfo(dto);
	}
	
    /**
     * <p>Title: selectLocTree</p>  
     * <p>Description:根据warehouse级联出location需要的数据 </p>  
     * @param parentId
     */
    @Override
    public List<CdLocInfoDTO> selectLocTree(long parentId, String locType) {
        return  cdLocInfoService.selectCdLocTree(parentId, locType);
    }
    
    /* (非 Javadoc) 
    * <p>Title: selectLocTreeWithType</p> 
    * <p>Description: </p> 
    * @param cdLocInfoDTO
    * @return 
    * @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#selectLocTreeWithType(com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO) 
    */
    @Override
    public List<CdLocInfoDTO> selectLocTreeWithType(CdLocInfoDTO cdLocInfoDTO) {
    	return cdLocInfoService.selectCdLocTreeWithType(cdLocInfoDTO);
    }

    /* (非 Javadoc) 
    * <p>Title: selectLocTreeWithLocation</p> 
    * <p>Description: </p> 
    * @param cdLocInfoDTO
    * @return 
    * @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#selectLocTreeWithLocation(com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO) 
    */
    @Override
    public List<CdLocInfoDTO> selectLocTreeWithLocation(CdLocInfoDTO cdLocInfoDTO) {
    	return cdLocInfoService.selectCdLocTreeWithLocation(cdLocInfoDTO);
    }
    
	/* (非 Javadoc) 
	* <p>Title: getCdLocInfos</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#getCdLocInfos() 
	*/
	@Override
	public List<CdLocInfoDTO> getCdLocInfos() {
		return cdLocInfoService.getCdLocInfos();
	}

    /* (非 Javadoc) 
    * <p>Title: getCdLocInfoManyColumn</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#getCdLocInfoManyColumn(com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO) 
    */
    @Override
    public List<CdLocInfoDTO> getCdLocInfoManyColumn(CdLocInfoDTO dto) {
        return cdLocInfoService.getCdLocInfoManyColumn(dto);
    }

    /**
	 * <p>Title: saveOrUpdate</p>  
	 * <p>Description:增加或更新 </p>  
	 * @param list
	 * @param user
	 */
	@Override
	public String saveOrUpdate(List<CdLocInfoDTO> list, BaseUser user) {
			
		return cdLocInfoService.saveOrUpdate2(list, user);
	}

	/* (非 Javadoc) 
	* <p>Title: getCdLocInfosByParentId</p> 
	* <p>Description: </p> 
	* @param parentId
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#getCdLocInfosByParentId(java.lang.Long) 
	*/
	@Override
	public List<CdLocInfoDTO> getCdLocInfosByParentId(Long parentId) {
		return cdLocInfoService.getCdLocInfosByParentId(parentId);
	}

	/* (非 Javadoc) 
	* <p>Title: deleteLocInfoByRowids</p> 
	* <p>Description: </p> 
	* @param ids
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#deleteLocInfoByRowids(java.lang.String) 
	*/
	@Override
	public String deleteLocInfoByRowids(String ids) {
		List<Long> idList = new ArrayList<Long>();
        for (String id : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(id)) {
                continue;
            }
            idList.add(Long.valueOf(id));
        }
		return cdLocInfoService.deleteCdLocInfoAll(idList);
	}

    /* (非 Javadoc) 
    * <p>Title: getCdTreeByParentId</p> 
    * <p>Description: </p> 
    * @param parentId
    * @param locType
    * @return 
    * @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#getCdTreeByParentId(java.lang.Long, java.lang.String) 
    */
    @Override
    public List<CdLocInfoDTO> getCdTreeByParentId(Long parentId, String locType) {
        return cdLocInfoService.getCdTreeByParentId(parentId,locType);
    }

    /* (非 Javadoc) 
    * <p>Title: selectPhysicalLoc</p> 
    * <p>Description: </p> 
    * @param parentId
    * @return 
    * @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#selectPhysicalLoc(long) 
    */
    @Override
    public List<CdLocInfoDTO> selectPhysicalLoc(long parentId) {
        return cdLocInfoService.selectPhysicalLocTree(parentId);
    }

	/* (非 Javadoc) 
	* <p>Title: getCdLocInfoListByCode</p> 
	* <p>Description: </p> 
	* @param codes
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient#getCdLocInfoListByCode(java.lang.String) 
	*/
	@Override
	public List<CdLocInfoDTO> getCdLocInfoListByCode(String codes) {
		return cdLocInfoService.getCdLocInfoListByCode(codes);
	}

}
