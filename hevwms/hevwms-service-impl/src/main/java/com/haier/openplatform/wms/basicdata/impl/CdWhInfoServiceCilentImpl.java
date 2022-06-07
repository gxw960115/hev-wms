package com.haier.openplatform.wms.basicdata.impl;

import io.terminus.pampas.common.BaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;

/**  
 * @ClassName: CdWhInfoServiceCilentImpl  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2016-4-20  
 */ 
public class CdWhInfoServiceCilentImpl implements CdWhInfoServiceClient {
    /**  
     * @Fields field:field:{}(cdWhInfoService)  
     */  
    private CdWhInfoService cdWhInfoService;

    /**  
     * @Title: getCdWhInfoService  
     * @Description: (get)  
     * @return
     * @return CdWhInfoService 
     * @throws  
     */  
    public CdWhInfoService getCdWhInfoService() {
        return cdWhInfoService;
    }

    /**  
     * @Title: setCdWhInfoService  
     * @Description: (set)  
     * @param cdWhInfoService
     * @return void 
     * @throws  
     */  
    public void setCdWhInfoService(CdWhInfoService cdWhInfoService) {
        this.cdWhInfoService = cdWhInfoService;
    }

    /**
     * Title: findWhlocalInfos
     * Description:查寻树形资源
     * @param userType
     * @param userId
     * @return
     * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#findWhlocalInfos(java.lang.String,
     *      java.lang.Long)
     */
    @Override
    public List<HashMap<String, Object>> findWhlocalInfos(String userType,
            Long userId) {
        //  Auto-generated method stub
        return cdWhInfoService.findWhLocTree(userType, userId);
    }

    /**
    * <p>Title: searchWhInfo</p>
    * <p>Description:add by Linzx@20151112 
    * 1.DispatchPlanInput,DiliveryCity下拉框获取值 
    * 2.StocktakingOrder,Add功能获取所有的warehouse的下拉框的值</p>
    * 3.gift order add 获取所有的warehouse   sunyanfei
    * @return
    * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchWhInfo()
    */
    @Override
    public List<CdWhInfoDTO> searchWhInfo() {
        List<CdWhInfoDTO> list = cdWhInfoService.getCdWhInfos();
        /*List<CdWhInfoDTO> row = new ArrayList<CdWhInfoDTO>();
        if (list.size() > 0) {
            for (CdWhInfoDTO ww : list) {
                CdWhInfoDTO cdi = new CdWhInfoDTO();
                try {
                    BeanUtilEx.copyProperties(cdi, ww);
                    row.add(cdi);
                } catch (InvocationTargetException e) {
                    //  Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    //  Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }*/
        if (list.size() > 0) {
            for (CdWhInfoDTO ww : list) {
            	ww.setName(ww.getName()+" ("+ww.getCode()+")");
            }
        }
        return list;
    }
    
     /** (non-Javadoc)  
     * <p>Title: searchPhysicalWhInfo</p>  
     * <p>Description:盘点单和gap，只能选择实体库位SJK</p>  
     * @return  
     * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchPhysicalWhInfo()  
     */
    @Override
     public List<CdWhInfoDTO> searchPhysicalWhInfo() {
         List<CdWhInfoDTO> list = cdWhInfoService.getPhysicalWhInfos();
         if (list.size() > 0) {
             for (CdWhInfoDTO ww : list) {
             	ww.setName(ww.getName()+" ("+ww.getCode()+")");
             }
         }
         return list;
     }
     
	/** (non-Javadoc)  
	 * <p>Title: searchCdWhInfos</p>  
	 * <p>Description:查询 </p>  
	 * @param page
	 * @param rows
	 * @param whinfo
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchCdWhInfos(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)  
	 */
	@Override
	public Pager<CdWhInfoDTO> searchCdWhInfos(Long page, Long rows,
			CdWhInfoDTO whinfo) {
		return cdWhInfoService.searchCdWhInfosByConditions(page, rows, whinfo);
	}

	/** (non-Javadoc)  
	 * <p>Title: createCdWhInfo</p>  
	 * <p>Description:创建 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#createCdWhInfo(com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)  
	 */
	@Override
	public String createCdWhInfo(CdWhInfoDTO dto) {
		return cdWhInfoService.createCdWhInfo(dto);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteCdWhInfo</p>  
	 * <p>Description:删除 </p>  
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#deleteCdWhInfo(java.util.List)  
	 */
	@Override
	public String deleteCdWhInfo(List<Long> ids) {
		return cdWhInfoService.deleteCdWhInfoAll(ids);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateCdWhInfo</p>  
	 * <p>Description:更新 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#updateCdWhInfo(com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)  
	 */
	@Override
	public String updateCdWhInfo(CdWhInfoDTO dto) {
		return cdWhInfoService.updateCdWhInfo(dto);
	}

	/** (non-Javadoc)  
	 * <p>Title: saveOrUpdate</p>  
	 * <p>Description:保存或更新 </p>  
	 * @param list
	 * @param user
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#saveOrUpdate(java.util.List, io.terminus.pampas.common.BaseUser)  
	 */
	@Override
	public String saveOrUpdate(List<CdWhInfoDTO> list, BaseUser user) {
		return 	cdWhInfoService.saveOrUpdate2(list, user);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateWhFlag</p>  
	 * <p>Description:更新flag </p>  
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#updateWhFlag(java.util.List)  
	 */
	@Override
	public String updateWhFlag(List<Long> ids) {
		return cdWhInfoService.updateWhFlag(ids);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteCdWhInfoByRowids</p>  
	 * <p>Description:删除 </p>  
	 * @param ids
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#deleteCdWhInfoByRowids(java.lang.String)  
	 */
	@Override
	public String deleteCdWhInfoByRowids(String ids) {
		List<Long> idList = new ArrayList<Long>();
        for (String id : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(id)) {
                continue;
            }
            idList.add(Long.valueOf(id));
        }
        return cdWhInfoService.deleteCdWhInfoAll(idList);
	}

    /** (non-Javadoc)  
     * <p>Title: findCdUserLoc</p>  
     * <p>Description:查询user对应的loc </p>  
     * @param userType
     * @param userId
     * @return  
     * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#findCdUserLoc(java.lang.String, long)  
     */
    @Override
    public List<Long> findCdUserLoc(String userType, long userId) {
//        List<Long> list=cdWhInfoService.findCdUserLoc(userType, userId);
        return cdWhInfoService.findCdUserLoc(userType, userId);
    }
    
	/** (non-Javadoc)
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchAvailableWh()
	 * 根据用户查询可用的仓库。用户权限控制 SJK
	 */
	@Override
	public List<CdWhInfoDTO> searchAvailableWh(Long userId) {
		
		List<CdWhInfoDTO> list = cdWhInfoService.findAvailableWhInfos(userId);
        if (list.size() > 0) {
            for (CdWhInfoDTO ww : list) {
            	ww.setName(ww.getName()+" ("+ww.getCode()+")");
            }
        }
        return list;
	}
	
	/* (非 Javadoc) 
	* <p>Title: searchAvailablePhyWh</p> 
	* <p>Description: </p> 
	* @param userId
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchAvailablePhyWh(java.lang.Long) 
	*/
	@Override
	public List<CdWhInfoDTO> searchAvailablePhyWh(Long userId) {
		List<CdWhInfoDTO> list = cdWhInfoService.findAvailablePhyWhInfos(userId);
        if (list.size() > 0) {
            for (CdWhInfoDTO ww : list) {
            	ww.setName(ww.getName()+" ("+ww.getCode()+")");
            }
        }
        return list;
	}
	
	/** (non-Javadoc)
	 * @see com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient#searchAvailableWh()
	 * 根据用户查询可用的物理仓库。用户权限控制 SJK
	 * 移除6603，6612，6600，6613，6602，661P，6618，6616，6610，6611，6640
	 */
	@Override
	public List<CdWhInfoDTO> searchAvailablePhyWhGap(Long userId) {
		String[] removed = {"6603","6612","6600","6613","6602","661P","6618","6616","6610","6611","6640"};
		List<CdWhInfoDTO> list = cdWhInfoService.findAvailablePhyWhInfos(userId);
		List<CdWhInfoDTO> result = new ArrayList<CdWhInfoDTO>();
        if (list.size() > 0) {
            for (CdWhInfoDTO ww : list) {
            	if (!ArrayUtils.contains(removed, ww.getCode())){
            		ww.setName(ww.getName()+" ("+ww.getCode()+")");
            		result.add(ww);
            	}
            }
        }
        return result;
	}
	
}
