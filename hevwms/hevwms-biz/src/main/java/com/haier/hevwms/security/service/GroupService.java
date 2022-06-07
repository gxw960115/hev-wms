package com.haier.hevwms.security.service;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/** 
 * @author WangJian
 *
 */
public interface GroupService { 
	/**
	 * 根据组的ID查找组信息
	 * @param
	 * @return
	 */
	//public Group getGroupById(Long id);  
	/**
	 * 分页查找组信息
	 * @param
	 * @return
	 */
	public Pager<GroupDTO> getAllGroupsByPager(Pager<GroupDTO> pager,GroupDTO group);
	/**
	 * 新建组
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> createGroup(GroupDTO group,long currentUserId);
	/**
	 * 删除组
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> deleteGroup(String groupIds,Long currentUserId);
	/**
	 * 更新组信息
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> updateGroup(GroupDTO group,String groupName,Long currentUserId);  
	/**
	 * 向组中添加用户
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> addUserToGroup(Long groupId,String userIds,long currentUserId);
	/**
	 * 向组中添加角色
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> addRoleToGroup(Long groupId, String roleId,long currentUserId);
	/**
	 * 删除组中的用户
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> deleteUserFromGroup(Long groupId, String userId,long currentUserId);
	/**
	 * 删除组中的角色
	 * @param
	 * @return
	 */
	public ExecuteResult<RoleDTO> deleteRoleFromGroup(Long groupId, String roleId,long currentUserId); 
	/**
	 * 获取组内管理员
	 * @param
	 * @return
	 */
	public Pager<UserGroup> getAdminByGroupId(Pager<UserGroup> pager, UserDTO user);
	/**
	 * 添加组管理员
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> addAdminToGroup(Long groupId, String userId,long currentUserId);
	/**
	 * 删除组管理员
	 * @param
	 * @return
	 */
	public ExecuteResult<GroupDTO> deleteAdminFromGroup(Long groupId, String userId,long currentUserId);   
	/**
	 * 获取当前用户是否为
	 * @param
	 * @return
	 */
	public boolean isGroupAdmin(Long userId,Long groupId);
	
}
