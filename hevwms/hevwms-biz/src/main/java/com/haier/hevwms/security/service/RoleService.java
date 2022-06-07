package com.haier.hevwms.security.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.RoleDTO;

/**
 * @author WangXuzheng
 *
 */
public interface RoleService {
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	public ExecuteResult<RoleDTO> createRole(RoleDTO role);
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public ExecuteResult<RoleDTO> updateRole(RoleDTO role);
	
	/**
	 * 删除角色信息
	 * @param roleId
	 * @return
	 */
	public ExecuteResult<RoleDTO> deleteRole(Long roleId);
	
	/**
	 * 查询角色信息
	 * @param searchModel
	 * @return
	 */
	public Pager<RoleDTO> searchRoles(Pager<RoleDTO> pager, RoleDTO role);
	
	/**
	 * 通过角色id获取角色信息
	 * @param roleId
	 * @return
	 */
	public RoleDTO getRoleById(Long roleId);
	
	/**
	 * 获取系统所有角色列表
	 * @return
	 */
	public List<RoleDTO> getRoles();
	
	public Pager<RoleDTO> getRolesByGroupId(Pager<RoleDTO> pager, RoleDTO role);
	
	/**
	 * 
	* @Title: getRoleResources by liyun
	* @Description: role query edit，show the relationship of role and resources
	* @param @param roleId
	* @param @return
	* @return List<RoleDTO>
	* @throws
	 */
	public List<RoleDTO> getRoleResources(long roleId);
}
