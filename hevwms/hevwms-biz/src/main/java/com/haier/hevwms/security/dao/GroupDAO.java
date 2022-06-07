package com.haier.hevwms.security.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.RoleGroup;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author WangJian
 *
 */
public interface GroupDAO extends CommonDAO<GroupDTO, Long>{

	/**
	 * 根据id和当前语言查询组
	 * @param id
	 * @param language
	 * @return
	 */
	@Override
	public GroupDTO get(@Param("id")Long id);
	/**
	 * 分页查找所有组
	 * @param
	 * @retuen
	 */
	public List<GroupDTO> getAllGroupsByPager(@Param("pager") Pager<GroupDTO> pager, @Param("group")GroupDTO group);
	public Long getAllGroupsByPagerCount(@Param("group")GroupDTO group);

	/**
	 * 查询组内管理员
	 * @param userid
	 * @return
	 */
	public List<UserGroup> getAdminByGroupId(@Param("pager") Pager<UserGroup> pager, @Param("user")UserDTO user) ;
	public Long getAdminByGroupIdCount(@Param("user")UserDTO user) ;
	/**
	 * 根据组合用户ID 删除组中的用户
	 * @param groupId
	 * @param userId
	 */
	//public void deleteUserFromGroup(@Param("groupId")Long groupId,@Param("userIds") List<Long> userIds);
	public void deleteUserFromGroup(@Param("groupId")Long groupId,@Param("userIds") Long userIds);
	/**
	 * 根据组合用户ID 删除组中的角色
	 * @param groupId
	 * @param userId
	 */
	//public void deleteRoleFromGroup(@Param("groupId")Long groupId, @Param("roleIds")List<Long> roleIds);
	public void deleteRoleFromGroup(@Param("groupId")Long groupId, @Param("roleIds")Long roleIds);

	/**
	 * 将人员添加到组
	 * @param groupId
	 * @param userId
	 */
	public void addUserGroup(UserGroup userGroup);
	/**
	 * 将角色添加到组
	 * @param groupId
	 * @param userId
	 */
	public void addRoleGroup(RoleGroup roleGroup);
	/**
	 * 查找组内是否存在角色
	 * @param userid
	 * @return
	 */
	public long getRoleCountInGroup(Long id);

	/**
	 * 根据用户ID查找用户对应组中的角色
	 * @param userid
	 * @return
	 */
	public List<RoleDTO> getRolesByUserId(Long userId);

	/**
	 * 获取当前用户是否为
	 * @param
	 * @return
	 */
	public boolean isGroupAdmin(Long userId,Long groupId);

	public GroupDTO getGroupByName(@Param("name")String groupName);

	public List<UserGroup> searchUserGroup(UserGroup userGroup);
	public void updateUserGroup(UserGroup userGroup);

	public List<RoleGroup> searchRoleGroup(RoleGroup roleGroup);
}
