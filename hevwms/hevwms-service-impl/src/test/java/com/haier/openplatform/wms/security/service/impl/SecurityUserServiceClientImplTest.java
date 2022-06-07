package com.haier.openplatform.wms.security.service.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.security.service.ResourceService;
import com.haier.hevwms.security.service.UserService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SecurityUserServiceClientImplTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月5日 下午1:56:40
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class SecurityUserServiceClientImplTest {

	private UserService userService;
	private ResourceService resourceService;
	private SecurityUserServiceClientImpl target;
	
	/**
	 * @Title: init
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午1:59:26
	 */
	@Before
	public void init(){
		userService = EasyMock.createMock(UserService.class);
		resourceService = EasyMock.createMock(ResourceService.class);
		target = new SecurityUserServiceClientImpl();
		target.setResourceService(resourceService);
		target.setUserService(userService);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchUser(){
		EasyMock.expect(userService.searchUser(
				(Pager<UserDTO>)EasyMock.anyObject(),
				(UserDTO)EasyMock.anyObject())
		).andReturn(new Pager<UserDTO>()).times(1);
		EasyMock.replay(userService);
		target.searchUser(1L,10L,new UserDTO());
	}

	/**
	 * @Title: testCreateUser
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午1:57:19
	 */
	@Test
	public void testCreateUser() {
		UserDTO userTestCaseDto = new UserDTO();
		
		ExecuteResult<UserDTO> tempExecuteResult = new ExecuteResult<UserDTO>();
		expect(userService.createUser(userTestCaseDto)).andReturn(tempExecuteResult);
		
		replay(userService);
		target.createUser(userTestCaseDto);
		verify(userService);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.SecurityUserServiceClientImpl#deleteUserInfo(java.lang.String)}.
	 */
	@SuppressWarnings("all")
	@Test
	public void testDeleteUserInfo() {
		ExecuteResult resultTestCase = new ExecuteResult();
		expect(userService.deleteUser(11L)).andReturn(resultTestCase);
		
		replay(userService);
		String result = target.deleteUserInfo("11");
		assertNotNull(result);
		verify(userService);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.SecurityUserServiceClientImpl#updatePassword(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdatePassword() {
		PowerMockito.mockStatic(UserUtil.class);
		PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
//		UserDTO returnCase = new UserDTO();
		expect(userService.getUserById((Long) anyObject())).andReturn(null);
		
		replay(userService);
		String result = target.updatePassword("11", "11", "11");
		assertNotNull(result);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.SecurityUserServiceClientImpl#updateUser(com.haier.openplatform.wms.security.dto.UserDTO)}.
	 */
	@Test
	public void testUpdateUser() {
		UserDTO temp = new UserDTO();
		ExecuteResult<UserDTO> rExecuteResult = new ExecuteResult<UserDTO>();
		expect(userService.updateUser((UserDTO) anyObject())).andReturn(rExecuteResult);
		
		replay(userService);
		String result = target.updateUser(temp);
		assertNotNull(result);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.SecurityUserServiceClientImpl#getAllMenus(java.lang.Long)}.
	 */
	@Test
	public void testGetAllMenus() {
		List<ResourceDTO> result = new ArrayList<ResourceDTO>();
		expect(resourceService.getGroupResourceByUserId(11L)).andReturn(result);
		
		replay(resourceService);
		result = target.getAllMenus(11L);
		assertNotNull(result);
	}

	@Test
	public void userLogin(){
		EasyMock.expect(userService.mergeUserLogin(
				(UserDTO)EasyMock.anyObject())
		).andReturn(new ExecuteResult<UserDTO>()).times(1);
		EasyMock.replay(userService);
		target.userLogin("","","'");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchUsersByGroupId(){
		EasyMock.expect(userService.getUsersByGroupId(
				(Pager<UserDTO>)EasyMock.anyObject(),
				(UserDTO)EasyMock.anyObject())
		).andReturn(new Pager<UserDTO>()).times(1);
		EasyMock.replay(userService);
		target.searchUsersByGroupId(1L,10L,new UserDTO());
	}
}
