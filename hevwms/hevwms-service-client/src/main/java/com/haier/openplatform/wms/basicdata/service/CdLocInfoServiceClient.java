package com.haier.openplatform.wms.basicdata.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;

import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;

/**
 * 
* @ClassName: LocationServiceClient
* @author Liujian
*
 */
public interface CdLocInfoServiceClient {
    
    public Pager<CdLocInfoDTO> searchCdLocInfo(Pager<CdLocInfoDTO> pager,CdLocInfoDTO cdLocInfo);
    
    /** 
    * @Title: searchCdLocInfoByCondition 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param rows
    * @param @param page
    * @param @param cdLocInfo
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<CdLocInfoDTO>    返回类型 
    * @throws 
    */
    public Pager<CdLocInfoDTO> searchCdLocInfoByCondition(Long rows,Long page,CdLocInfoDTO cdLocInfo);
    
    /** 
    * @Title: createLocInfos 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"cdLocInfo"})
    public String createLocInfos(CdLocInfoDTO dto);

    /** 
    * @Title: deleteLocInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
	public String deleteLocInfo(List<Long> ids);
    
    /** 
    * @Title: deleteLocInfoByRowids 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
	public String deleteLocInfoByRowids(String ids);

    /** 
    * @Title: deleteLocInfoByIds 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
	public String deleteLocInfoByIds(String ids);

    /** 
    * @Title: updateLocInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"cdLocInfo"})
	public String updateLocInfo(CdLocInfoDTO dto);
	
	/** 
	* @Title: selectLocTree 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param parentId
	* @param @param locType
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> selectLocTree(long parentId, String locType);


	public List<CdLocInfoDTO> searchCdLocInfoByConditionBc();
	/** 
	* @Title: selectLocTreeWithType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cdLocInfoDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> selectLocTreeWithType(CdLocInfoDTO cdLocInfoDTO);
	
	/** 
	* @Title: selectLocTreeWithLocation 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param cdLocInfoDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> selectLocTreeWithLocation(CdLocInfoDTO cdLocInfoDTO);
	
	/** 
	* @Title: getCdLocInfos 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> getCdLocInfos();
	
    /** 
    * @Title: saveOrUpdate 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param mdMatInfos
    * @param @param user
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    public String saveOrUpdate(List<CdLocInfoDTO> mdMatInfos, BaseUser user);
    
	/** 
	* @Title: getCdLocInfosByParentId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param parentId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> getCdLocInfosByParentId(Long parentId);
	
	/** 
	* @Title: getCdTreeByParentId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param parentId
	* @param @param locType
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> getCdTreeByParentId(Long parentId,String locType);

	/** 
	* @Title: selectPhysicalLoc 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param parentId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"parentId"})
	public List<CdLocInfoDTO> selectPhysicalLoc(long parentId);

	/** 
	* @Title: getCdLocInfoListByCode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param codes
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> getCdLocInfoListByCode(String codes);

	/** 
	* @Title: getCdLocInfoManyColumn 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<CdLocInfoDTO>    返回类型 
	* @throws 
	*/
	public List<CdLocInfoDTO> getCdLocInfoManyColumn(CdLocInfoDTO dto);
}
