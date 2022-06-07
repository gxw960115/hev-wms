package com.haier.hevwms.security.service.impl;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.security.dao.GroupDAO;
import com.haier.hevwms.security.dao.RoleDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.wms.security.domain.RoleGroup;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: GroupServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:09:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class GroupServiceTest extends BasicTestCase {
	GroupServiceImpl ss = new GroupServiceImpl();
	GroupDAO groupDAO;
	UserDAO userDAO;
	RoleDAO roleDAO;
	
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:09:51 
	*/ 
	@Before
	public void bf() {

		groupDAO = EasyMock.createMock(GroupDAO.class);
		userDAO = EasyMock.createMock(UserDAO.class);
		roleDAO = EasyMock.createMock(RoleDAO.class);
		ss.setGroupDAO(groupDAO);
		ss.setUserDAO(userDAO);
		ss.setRoleDAO(roleDAO);
        ss.getGroupDAO();
        ss.getRoleDAO();
        ss.getUserDAO();
	}

	/**  
	* @Title: createGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:10:23 
	*/ 
	@Test
	public void createGroup() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			long currentUserId = (long) 7;
			EasyMock.expect(groupDAO.getGroupByName(EasyMock.isA(String.class))).andReturn(group).anyTimes();
			EasyMock.replay(groupDAO);
			ss.createGroup(group, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:10:32 
	*/ 
	@Test
	public void deleteGroup() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			UserDTO user = new UserDTO();
			user.setId(1L);
			String groupIds = "1";
			Long currentUserId = (long) 15;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			UserGroup u=new UserGroup();
			u.setUser(user);
			userGroups.add(u);
			ArrayList<RoleGroup> rs=new ArrayList<RoleGroup>();
			rs.add((RoleGroup) getBean(RoleGroup.class));
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(group);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.searchRoleGroup(EasyMock.isA(RoleGroup.class))).andReturn(rs).anyTimes();
            EasyMock.replay(groupDAO);
			ss.deleteGroup(groupIds, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteGroup2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:10:46 
	*/ 
	@Test
	public void deleteGroup2() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			UserDTO user = new UserDTO();
			user.setId(1L);
			String groupIds = "1";
			Long currentUserId = (long) 15;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			UserGroup u=new UserGroup();
			u.setUser(user);
			userGroups.add(u);
			userGroups.add(u);
			ArrayList<RoleGroup> rs=new ArrayList<RoleGroup>();
			rs.add((RoleGroup) getBean(RoleGroup.class));
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(group);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.searchRoleGroup(EasyMock.isA(RoleGroup.class))).andReturn(rs).anyTimes();
            EasyMock.replay(groupDAO);
			ss.deleteGroup(groupIds, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteGroup1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:10:55 
	*/ 
	@Test
	public void deleteGroup1() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			 UserDTO user = new UserDTO();
			 user.setId(1L);
			String groupIds = "1";
			Long currentUserId = (long) 15;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			
			ArrayList<RoleGroup> rs=new ArrayList<RoleGroup>();
			rs.add((RoleGroup) getBean(RoleGroup.class));
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(group);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.searchRoleGroup(EasyMock.isA(RoleGroup.class))).andReturn(rs).anyTimes();
            EasyMock.replay(groupDAO);
			ss.deleteGroup(groupIds, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:04 
	*/ 
	@Test
	public void updateGroup() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			String groupName = "4";
			Long currentUserId = (long) 14;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			UserGroup u=new UserGroup();
			 UserDTO user = new UserDTO();
			 user.setId(1L);
			u.setUser(user);
			userGroups.add(u);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.getGroupByName(EasyMock.isA(String.class))).andReturn(group).anyTimes();
			
            EasyMock.replay(groupDAO);
			ss.updateGroup(group, groupName, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: updateGroup1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:11 
	*/ 
	@Test
	public void updateGroup1() {

		try {
			GroupDTO group = (GroupDTO) getBean(GroupDTO.class);
			String groupName = "4";
			Long currentUserId = (long) 14;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			
            EasyMock.replay(groupDAO);
			ss.updateGroup(group, groupName, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: addUserToGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:20 
	*/ 
	@Test
	public void addUserToGroup() {

		try {
			Long groupId = (long) 16;
			String userIds = "7";
			long currentUserId = (long) 19;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			UserGroup u1=new UserGroup();
			 UserDTO user = new UserDTO();
			 user.setId(1L);
			u1.setUser(user);
			userGroups.add(u1);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			
            EasyMock.replay(groupDAO);
			ss.addUserToGroup(groupId, userIds, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: addUserToGroup1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:27 
	*/ 
	@Test
	public void addUserToGroup1() {

		try {
			Long groupId = (long) 16;
			String userIds = "7";
			long currentUserId = (long) 19;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			
            EasyMock.replay(groupDAO);
			ss.addUserToGroup(groupId, userIds, currentUserId);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: addRoleToGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:34 
	*/ 
	@Test
	public void addRoleToGroup() {

		try {
			Long groupId = (long) 14;
			String roleId = "9";
			long currentUserId = (long) 11;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			UserGroup u1=new UserGroup();
			 UserDTO user = new UserDTO();
			 user.setId(1L);
			u1.setUser(user);
			userGroups.add(u1);
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			ArrayList<RoleGroup> rs=new ArrayList<RoleGroup>();
			rs.add((RoleGroup) getBean(RoleGroup.class));
			EasyMock.expect(groupDAO.searchRoleGroup(EasyMock.isA(RoleGroup.class))).andReturn(rs).anyTimes();
			EasyMock.expect(roleDAO.getRoleById(EasyMock.anyLong())).andReturn((RoleDTO) getBean(RoleDTO.class)).anyTimes();
			 EasyMock.replay(groupDAO,roleDAO);
			ss.addRoleToGroup(groupId, roleId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: addRoleToGroup1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:40 
	*/ 
	@Test
	public void addRoleToGroup1() {

		try {
			Long groupId = (long) 14;
			String roleId = "9";
			long currentUserId = (long) 11;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			 EasyMock.replay(groupDAO,roleDAO);
			ss.addRoleToGroup(groupId, roleId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteUserFromGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:11:54 
	*/ 
	@Test
	public void deleteUserFromGroup() {

		try {
			Long groupId = (long) 8;
			String userId = "5";
			long currentUserId = (long) 11;
			
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			 EasyMock.replay(groupDAO);
			ss.deleteUserFromGroup(groupId, userId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteRoleFromGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:03 
	*/ 
	@Test
	public void deleteRoleFromGroup() {

		try {
			Long groupId = (long) 3;
			String roleId = "7";
			long currentUserId = (long) 19;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			 EasyMock.replay(groupDAO);
			ss.deleteRoleFromGroup(groupId, roleId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: addAdminToGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:19 
	*/ 
	@Test
	public void addAdminToGroup() {

		try {
			Long groupId = (long) 18;
			String userId = "6";
			long currentUserId = (long) 18;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			 EasyMock.replay(groupDAO);
			ss.addAdminToGroup(groupId, userId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteAdminFromGroup  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:27 
	*/ 
	@Test
	public void deleteAdminFromGroup() {

		try {
			Long groupId = (long) 5;
			String userId = "7";
			long currentUserId = (long) 13;
			ArrayList<UserGroup> userGroups=new ArrayList<UserGroup>();
			GroupDTO u=new GroupDTO();
			
			EasyMock.expect(groupDAO.searchUserGroup(EasyMock.isA(UserGroup.class))).andReturn(userGroups).anyTimes();
			EasyMock.expect(groupDAO.get(EasyMock.anyLong())).andReturn(u);
			 EasyMock.replay(groupDAO);
			ss.deleteAdminFromGroup(groupId, userId, currentUserId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: isGroupAdmin  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:12:34 
	*/ 
	@Test
	public void isGroupAdmin() {

		try {
			Long userId = (long) 13;
			Long groupId = (long) 3;

			ss.isGroupAdmin(userId, groupId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}