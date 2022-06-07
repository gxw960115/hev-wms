package com.haier.openplatform.wms.security.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.RoleDTO;


/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
public interface RoleServiceClient {

	/** 
	* @Title: searchRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param role
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<RoleDTO>    返回类型 
	* @throws 
	*/
	public Pager<RoleDTO> searchRole(long page, long rows, RoleDTO role);
	
	/** 
	* @Title: deleteRoleMessage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param id
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"id"})
	public String deleteRoleMessage(String id);
	
	/** 
	* @Title: createRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param role
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"role"})
	public String createRole(RoleDTO role);

	/** 
	* @Title: updateRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param role
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"role"})
	public String updateRole(RoleDTO role);
	
	/** 
	* @Title: getRoleResources 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param roleId
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<RoleDTO>    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"roleId"})
	public List<RoleDTO> getRoleResources(long roleId);
	
	/** 
	* @Title: searchRolesByGroupId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param role
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<RoleDTO>    返回类型 
	* @throws 
	*/
	public Pager<RoleDTO> searchRolesByGroupId(long page, long rows,
			RoleDTO role);
	
}