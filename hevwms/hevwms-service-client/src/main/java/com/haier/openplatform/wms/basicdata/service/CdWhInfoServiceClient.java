package com.haier.openplatform.wms.basicdata.service;

import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;

import java.util.HashMap;
import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;

/**
 * @ClassName: CdWhInfoServiceClient
 * @author Liujian
 *
 */
public interface CdWhInfoServiceClient {

	/** 
	* @Title: searchCdWhInfos 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param whinfo
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<CdWhInfoDTO>    返回类型 
	* @throws 
	*/
	public Pager<CdWhInfoDTO> searchCdWhInfos(Long page,Long rows, CdWhInfoDTO whinfo);
	
	/** 
	* @Title: createCdWhInfo 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"cdWhInfo"})
	public String createCdWhInfo(CdWhInfoDTO dto);
	
    /** 
    * @Title: deleteCdWhInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
	public String deleteCdWhInfo(List<Long> ids);

    /** 
    * @Title: deleteCdWhInfoByRowids 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
   	public String deleteCdWhInfoByRowids(String ids);

    /** 
    * @Title: updateWhFlag 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
	public String updateWhFlag(List<Long> ids);
    
    /** 
    * @Title: updateCdWhInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"cdWhInfo"})
	public String updateCdWhInfo(CdWhInfoDTO dto);
	    
    /**
    * @Title: findWhlocalInfos
    * @Description:查询locationTree
    * @param @param userType
    * @param @param userId
    * @param @return
    * @return List<HashMap<String,Object>>
    * @throws
    */
    public List<HashMap<String, Object>> findWhlocalInfos(String userType,
            Long userId);
    
    
    /**
    * @Title: searchWhInfo
    * @Description: add by Linzx@20151112 
    * 1.DispatchPlanInput,DiliveryCity下拉框获取值 
    * 2.StocktakingOrder,Add功能获取所有的warehouse的下拉框的值
    * @param @return
    * @return List<CdWhInfoDTO>
    * @throws
    */
    public List<CdWhInfoDTO> searchWhInfo();
    
     /** 
    * @Title: searchPhysicalWhInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<CdWhInfoDTO>    返回类型 
    * @throws 
    */
    public List<CdWhInfoDTO> searchPhysicalWhInfo();
    
	/** 
	* @Title: saveOrUpdate 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param list
	* @param @param user
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String saveOrUpdate(List<CdWhInfoDTO> list, BaseUser user);
	
	/**
	 * 
	* @Title: findCdUserLoc by liyun
	* @Description: the relationship of user and location
	* @param @param userType
	* @param @param userId
	* @param @return
	* @return List<Long>
	* @throws
	 */
	@Export(paramNames = {"userType","userId"})
	public List<Long> findCdUserLoc(String userType,long userId);
	
    /**
     * @Title: searchWhInfo
     * @Description: SJK
     * 根据用户查询可用的仓库。用户权限控制
     * @param @return
     * @return List<CdWhInfoDTO>
     * @throws
     */
    public List<CdWhInfoDTO> searchAvailableWh(Long userId);
    
    /**
     * @Title: searchWhInfo
     * @Description: SJK
     * 根据用户查询可用的物理仓库。用户权限控制
     * @param @return
     * @return List<CdWhInfoDTO>
     * @throws
     */
    public List<CdWhInfoDTO> searchAvailablePhyWh(Long userId);
    
    /**
     * @Title: searchWhInfo
     * @Description: SJK
     * 根据用户查询可用的物理仓库。用户权限控制
     * @param @return
     * @return List<CdWhInfoDTO>
     * @throws
     */
    public List<CdWhInfoDTO> searchAvailablePhyWhGap(Long userId);
    
}
