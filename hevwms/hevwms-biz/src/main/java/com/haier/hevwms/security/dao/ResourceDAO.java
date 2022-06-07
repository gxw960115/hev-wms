/**
* @Company 青鸟软通
* @Title: ResourceDAO.java
* @Package com.haier.hevwms.security.dao
* @author Liyun
* @date 2015-10-30 下午2:02:22
* @version V1.0
*/
package com.haier.hevwms.security.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;

/**
 * 资源资源
 */
public interface ResourceDAO extends CommonDAO<ResourceDTO,Long>{
	/**
	 * 根据id查询资源
	 * @param id
	 * @param languageCode
	 * @return
	 */
	public ResourceDTO getResourceById(@Param("id")Long id);
	/**
	 * 通过资源名称获取资源信息
	 * @param name
	 * @return
	 */
	public ResourceDTO getResourceByName(@Param("name") String name,@Param("parentId") Long parentId);
	
	/**
	 * 通过资源code获取资源信息
	 * @param code
	 * @param languageCode
	 * @return
	 */
	public ResourceDTO getResourceByCode(@Param("code")String code);
	
	/**
	 * 查询子资源
	 * @param resourceId
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getChildren(@Param("resourceId")Long resourceId);
	
	/**
	 * 获取某个节点的所有直接父节点列表
	 * @param resourceId
	 * @return
	 */
	public LinkedList<ResourceDTO> getParentsChain(Long resourceId);
	
	/**
	 * 获取根节点资源信息列表
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getRoots();
	
	/**
	 * 获取指定id下的所有资源列表
	 * @param roleIds
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getResourceByRoleIds(@Param("roleIds")Long[] roleIds); 
	 
	/**
	 * 获取指定用户id下的所有资源列表
	 * @param userId
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getGroupResourceByUserId(@Param("userId")Long userId);
	
	/**
	 * 获取指定模块下的所有资源列表
	 * @param roles
	 * @param moduleName
	 * @return
	 */
	public List<ResourceDTO> getUserDisplayedURLResourcesByModuleAndRoles(@Param("userId")Long userId,@Param("moduleName")String moduleName);
	/**
	 * 查询资源
	 * @param pager
	 * @param resource
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> searchResources(@Param("pager")Pager<ResourceDTO> pager,@Param("resource")ResourceDTO resource);
	public Long searchResourcesCount(@Param("pager")Pager<ResourceDTO> pager,@Param("resource")ResourceDTO resource);
	
	/**
	 * 获取某个资源下的所有子节点(包含间接子节点和自身)
	 * @param userId
	 * @param code
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getDescendants(@Param("userId")Long userId,@Param("code")String code);
	/**
	 * 获取所有moduleName的列表
	 * @return
	 */
	public List<String> getmoduleNames();
	/**
	 * 获取所有资源
	 * @param languageCode
	 * @return
	 */
	public List<ResourceDTO> getAll(ResourceDTO resource);
	public List<ResourceDTO> getParentResource(ResourceDTO resource);
}
