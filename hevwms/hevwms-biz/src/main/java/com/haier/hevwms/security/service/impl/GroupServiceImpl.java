package com.haier.hevwms.security.service.impl;

import java.util.List;

import com.haier.hevwms.security.dao.GroupDAO;
import com.haier.hevwms.security.dao.RoleDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.security.service.GroupService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.RoleGroup;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * @author WangJian
 * 
 */
public class GroupServiceImpl implements GroupService {
	private GroupDAO groupDAO;
	private UserDAO userDAO;
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	} 
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	} 
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	} 
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}  
	
	@Override
	public Pager<GroupDTO> getAllGroupsByPager(Pager<GroupDTO> pager,GroupDTO group) {
		List<GroupDTO> groups = groupDAO.getAllGroupsByPager(pager, group);
		long size = groupDAO.getAllGroupsByPagerCount(group);
		return Pager.cloneFromPager(pager, size, groups);
	}

	@Override
	public ExecuteResult<GroupDTO> createGroup(GroupDTO group,long currentUserId) {
		ExecuteResult<GroupDTO> executeResult = new ExecuteResult<GroupDTO>();
		GroupDTO dbGrop = groupDAO.getGroupByName(group.getName());
		if (dbGrop == null) {
			groupDAO.save(group);
			//saveGroupLang(group);
			UserGroup userGroup = new UserGroup();
			userGroup.getUser().setId(currentUserId);
//			userGroup.getGroup().setId(group.getId());
			userGroup.getGroup().setId(groupDAO.getGroupByName(group.getName()).getId());
			userGroup.setAdmin(1);
			groupDAO.addUserGroup(userGroup); //人员和组对应
		} else {
			executeResult.addErrorMessage("security.group.creategroup.name.exist");
		}
		return executeResult;
	}
	
	/*private void saveGroupLang(Group group){
		if(group == null){
			return ;
		}
		List<GroupLang> list = new ArrayList<GroupLang>();
		GroupLang groupLang = new GroupLang();
		groupLang.setGroupId(group.getId());
		groupLang.setName(group.getName());
		groupLang.setDescription(group.getDescription());
		
		groupLang.setLanguageCode("zh_CN"LoginContextHolder.get().getLanguage());  //正式环境要放开
		list.add(groupLang);
		groupLangService.createLangs(list);
	}*/

	@Override
	public ExecuteResult<GroupDTO> deleteGroup(String groupIds,Long currentUserId) {
		ExecuteResult<GroupDTO> executeResult = new ExecuteResult<GroupDTO>();
		String[] groupId = groupIds.split(",");
		String faildDeleteGroup = "";
		for (int i = 0; i < groupId.length; i++) {
			Long groupid = Long.parseLong(groupId[i]);
			boolean isExistUserOrRole = false;
			GroupDTO group = groupDAO.get(groupid);
			UserGroup userGroup = new UserGroup();
			userGroup.getGroup().setId(groupid);
			userGroup.setAdmin(-1);
			
			RoleGroup roleGroup = new RoleGroup();
			roleGroup.getGroup().setId(groupid);
			
			//判断组中是否有人
			List<UserGroup> userGroups = groupDAO.searchUserGroup(userGroup);
			if(userGroups.size() ==1){//当前用户时该组的管理员，并且该组中只有这一个人时，可以删除
				if(!userGroups.get(0).getUser().getId().equals(currentUserId)){
					faildDeleteGroup = "[" + group.getName()
							+ "]"+"security.group.deletegroup.exist.user"+"<br/><br/>"
							+ faildDeleteGroup;
					executeResult.addErrorMessage(faildDeleteGroup);
					isExistUserOrRole = true;
				}
			}else if(userGroups.size() > 1){//当前组中有多余一个人时禁止删除
				faildDeleteGroup = "[" + group.getName()
						+ "]"+"security.group.deletegroup.exist.user"+"<br/><br/>"
						+ faildDeleteGroup;
				executeResult.addErrorMessage(faildDeleteGroup);
				isExistUserOrRole = true;
			}
			
			//判断组中是否有角色
			if (groupDAO.searchRoleGroup(roleGroup).size()>0) {
				faildDeleteGroup = "[" + group.getName()
						+ "]"+"security.group.deletegroup.exist.role"+"<br/><br/>"
						+ faildDeleteGroup;
				executeResult.addErrorMessage(faildDeleteGroup);
				isExistUserOrRole = true;
			}
			if(!isGroupAdmin(currentUserId, groupid)){
				faildDeleteGroup = "[" + group.getName()
						+ "]"+"security.group.deletegroup.not.admin"+"<br/><br/>"
						+ faildDeleteGroup;
				executeResult.addErrorMessage(faildDeleteGroup);
			}
			if (!isExistUserOrRole) {
				groupDAO.delete(groupid);
			}
		}
		return executeResult;
	}

	
	@Override
	public ExecuteResult<GroupDTO> updateGroup(GroupDTO group, String groupName,Long currentUserId) {
		ExecuteResult<GroupDTO> executeResult = new ExecuteResult<GroupDTO>();
		if(this.isGroupAdmin(currentUserId, group.getId())){
			if (groupDAO.getGroupByName(group.getName()) != null&& !group.getName().equals(groupName)) { 
				executeResult.addErrorMessage("security.group.creategroup.name.exist");
			} else {
				GroupDTO dbGroup = groupDAO.get(group.getId());
				dbGroup.setName(group.getName());
				dbGroup.setDescription(group.getDescription());
				groupDAO.update(dbGroup); 
			}
		}else{
			executeResult.addErrorMessage("security.group.update.not.admin");
		}
		return executeResult;
	}

	@Override
	public ExecuteResult<GroupDTO> addUserToGroup(Long groupId, String userId,long currentUserId) {
		ExecuteResult<GroupDTO> result = new ExecuteResult<GroupDTO>();
		String faildAddUser = "";
		if(this.isGroupAdmin(currentUserId, groupId)){
			String[] userid = userId.split(",");
			for (int i = 0; i < userid.length; i++) {
				UserGroup userGroup = new UserGroup();
				userGroup.getUser().setId(Long.valueOf(userid[i]));
				userGroup.getGroup().setId(groupId);
				if (!groupDAO.searchUserGroup(userGroup).isEmpty()) {
					UserDTO user = userDAO.get(Long.parseLong(userid[i]));
					faildAddUser = user.getName()+"already exist!";
				} else {
					userGroup.setAdmin(0);
					groupDAO.addUserGroup(userGroup);
				}
			}
		}else{
			GroupDTO group = groupDAO.get(groupId);
			faildAddUser = group.getName()+"security.group.update.not.admin";
		}
		
		if (faildAddUser != null && !("").equals(faildAddUser)) {
			result.addErrorMessage(faildAddUser);
		}
		return result;
	}

	@Override
	public ExecuteResult<GroupDTO> addRoleToGroup(Long groupId, String roleId,long currentUserId) {
		ExecuteResult<GroupDTO> result = new ExecuteResult<GroupDTO>();
		String faildAddRole = "";
		if(this.isGroupAdmin(currentUserId, groupId)){
			String[] roleid = roleId.split(",");
			for (int i = 0; i < roleid.length; i++) {
				RoleGroup roleGroup = new RoleGroup();
				roleGroup.getGroup().setId(groupId);
				roleGroup.getRole().setId(Long.valueOf(roleid[i]));
				if (groupDAO.searchRoleGroup(roleGroup).size()>0) {
					RoleDTO role = roleDAO.getRoleById(Long.parseLong(roleid[i]));
					faildAddRole = role.getName()+"already exist!";

				} else {
					groupDAO.addRoleGroup(roleGroup);
				}
			}
		}else{
			GroupDTO group = groupDAO.get(groupId);
			faildAddRole = group.getName()+"security.group.update.not.admin";
		}
		if (faildAddRole != null && !"".equals(faildAddRole)) {
			result.addErrorMessage(faildAddRole);
		}
		return result;

	}

	@Override
	public ExecuteResult<GroupDTO> deleteUserFromGroup(Long groupId, String userId,long currentUserId) {
		ExecuteResult<GroupDTO> result = new ExecuteResult<GroupDTO>();
		if(this.isGroupAdmin(currentUserId, groupId)){
			String[] userid = userId.split(",");
			//List<Long> userIds = new ArrayList<Long>();
			//String userIds = "";
			for (int i = 0; i < userid.length; i++) {
				//userIds.add(Long.valueOf(userid[i]));
				//userIds+="'"+userid[i]+"',";
				groupDAO.deleteUserFromGroup(groupId, Long.valueOf(userid[i]));
			}
			//userIds+="''";
			
		}else{
			result.addErrorMessage("security.group.update.not.admin");
		}
		return result;
	}
	
	@Override
	public ExecuteResult<RoleDTO> deleteRoleFromGroup(Long groupId, String roleId,long currentUserId) {
		ExecuteResult<RoleDTO> result = new ExecuteResult<RoleDTO>();
		if(this.isGroupAdmin(currentUserId, groupId)){
			String[] roleid = roleId.split(",");
			//List<Long> roleIds = new ArrayList<Long>();
			for (int i = 0; i < roleid.length; i++) {
				//roleIds.add(Long.valueOf(roleid[i]));
				groupDAO.deleteRoleFromGroup(groupId, Long.valueOf(roleid[i]));
			}
			
		}else{
			result.addErrorMessage("security.group.update.not.admin");
		}
		return result;
	}
	
	@Override
	public Pager<UserGroup> getAdminByGroupId(Pager<UserGroup> pager,UserDTO user) {
		List<UserGroup> groupUsers = groupDAO.getAdminByGroupId(pager, user);
		long size = groupDAO.getAdminByGroupIdCount(user);
		return Pager.cloneFromPager(pager, size, groupUsers);
	}

	@Override
	public ExecuteResult<GroupDTO> addAdminToGroup(Long groupId, String userId,long currentUserId) {
		ExecuteResult<GroupDTO> result = new ExecuteResult<GroupDTO>();
		if(this.isGroupAdmin(currentUserId, groupId)){
			if (!userId.isEmpty()) {
				String[] userid = userId.split(",");
				for (int i = 0; i < userid.length; i++) {
					createOrUpdateGroupAdmin(groupId, Long.valueOf(userid[i]));
				}
			}
		}else{
			result.addErrorMessage("security.group.update.not.admin");
		}
		return result;
	}
	
	private void createOrUpdateGroupAdmin(Long groupId,Long userId){
		UserGroup userGroup = new UserGroup();
		userGroup.getUser().setId(userId);
		userGroup.getGroup().setId(groupId);
		userGroup.setAdmin(-1);//设置一个不存在的标志，查找状态为0,1的数据
		List<UserGroup> userGroups = groupDAO.searchUserGroup(userGroup);
		userGroup.setAdmin(1);//设置为admin
		if(!userGroups.isEmpty()){
			groupDAO.updateUserGroup(userGroup);
		}else{
			groupDAO.addUserGroup(userGroup);
		}
	}
	
	
	@Override
	public ExecuteResult<GroupDTO> deleteAdminFromGroup(Long groupId, String userId,long currentUserId) {
		ExecuteResult<GroupDTO> result = new ExecuteResult<GroupDTO>();
		if(this.isGroupAdmin(currentUserId, groupId)){
			if (!userId.isEmpty()) {
				String[] userid = userId.split(",");
				for (int i = 0; i < userid.length; i++) {
					UserGroup userGroup = new UserGroup();
					userGroup.getUser().setId(Long.valueOf(userid[i]));
					userGroup.getGroup().setId(groupId);
					userGroup.setAdmin(0);
					groupDAO.updateUserGroup(userGroup);
				}
			}
		}else{
			result.addErrorMessage("security.group.update.not.admin");
		}
		return result;
	} 
	
	@Override
	public boolean isGroupAdmin(Long userId,Long groupId){
		UserGroup userGroup = new UserGroup();
		userGroup.getGroup().setId(groupId);
		userGroup.getUser().setId(userId);
		userGroup.setAdmin(1);
		return groupDAO.searchUserGroup(userGroup).size()>0;
	}
}
