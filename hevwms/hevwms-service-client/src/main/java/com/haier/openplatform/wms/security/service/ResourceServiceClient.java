package com.haier.openplatform.wms.security.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;


/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
public interface ResourceServiceClient {

	/** 
	* @Title: searchResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param resource
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<ResourceDTO>    返回类型 
	* @throws 
	*/
	Pager<ResourceDTO> searchResource(long page, long rows, ResourceDTO resource);
	
	/** 
	* @Title: deleteResourceMessage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"id"})
	public String deleteResourceMessage(String id);
	
	/** 
	* @Title: createResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param resource
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"resource"})
	public String createResource(ResourceDTO resource);
	
	/** 
	* @Title: updateResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param resource
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"resource"})
	public String updateResource(ResourceDTO resource);
	
	/** 
	* @Title: selectResourceTree 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param status
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<ResourceDTO>    返回类型 
	* @throws 
	*/
	List<ResourceDTO> selectResourceTree(Integer status);
	
	/** 
	* @Title: getParentResource 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param status
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<ResourceDTO>    返回类型 
	* @throws 
	*/
	public List<ResourceDTO> getParentResource(Integer status);
}