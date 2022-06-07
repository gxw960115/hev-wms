/**
* @Company 青鸟软通
* @Title: ResourceService.java
* @Package com.haier.openplatform.showcase.security.service
* @author Lynn
* @date 2015-10-30 下午2:02:22
* @version V1.0
*/
package com.haier.hevwms.security.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;

/**
 * @author WangXuzheng
 * @author lupeng
 */
public interface ResourceService {
	/**
	 * 创建资源
	 * @param resource
	 */
	public ExecuteResult<ResourceDTO> createResource(ResourceDTO resource);
	
	/**
	 * 更新资源信息
	 * @param resource
	 */
	public ExecuteResult<ResourceDTO> updateResource(ResourceDTO resource);
	
	/**
	 * 删除资源
	 * @param resourceId
	 * @return
	 */
	public ExecuteResult<ResourceDTO> deleteResource(Long resourceId);
	
	/**
	 * 通过id获取资源信息
	 * @param resourceId
	 * @return
	 */
	public ResourceDTO getResourceById(Long resourceId);
	
	/**
	 * 获取资源的子资源
	 * @param resourceId
	 * @return
	 */
	public List<ResourceDTO> getChilden(Long resourceId);
	
	/**
	 * 获取某个节点的所有直接父节点列表
	 * @param resourceId
	 * @return
	 */
	public LinkedList<ResourceDTO> getParentsChain(Long resourceId);
	
	/**
	 * 获取系统根资源
	 * @return
	 */
	public List<ResourceDTO> getRoot();
	
	/**
	 * 查询指定角色下的资源列表
	 * @param roleIds
	 * @return
	 */
	public List<ResourceDTO> getResourceByRole(Long[] roleIds);
	
	/**
	 * 获取系统中所有的资源列表
	 * @return
	 */
	public List<ResourceDTO> getAll();
	
	/**
	 * 获取指定模块下用户可见的所有资源列表
	 * @param userId 用户ID信息
	 * @param moduleName
	 * @return
	 */
	public List<ResourceDTO> getUserDisplayedURLResources(Long userId,String moduleName);
	
	/**
	 * 查询资源
	 */
	public Pager<ResourceDTO> searchResources(Pager<ResourceDTO> pager,ResourceDTO resource);
	
	/**
	 * 查询某个用户所用于的资源所有子节点(包含间接子节点和自身)
	 * @param userId
	 * @param code
	 * @return
	 */
	public Map<ResourceDTO,List<ResourceDTO>> getUserResourceDescendants(Long userId,List<String> codeList);
	  
	/**
	 * 查询摸个用户对应的资源列表
	 * @param userId
	 * @return
	 */
	public List<ResourceDTO> getGroupResourceByUserId(Long userId);

	/**
	 * 查询资源信息
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	public List<ResourceDTO> selectResourceTree(ResourceDTO resource); 
	
	//public List<Resource> getGroupResourceByUserId(Long userId,String languageCode); 
	/**
	 * 
	* @Title: getParentResource by liyun
	* @Description: combobox 得到父级module
	* @param @return
	* @return List<ResourceDTO>
	* @throws
	 */
	public List<ResourceDTO> getParentResource(ResourceDTO resource);
}
