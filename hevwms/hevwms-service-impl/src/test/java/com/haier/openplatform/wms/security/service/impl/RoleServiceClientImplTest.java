package com.haier.openplatform.wms.security.service.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.haier.openplatform.util.Pager;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.security.service.RoleService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: RoleServiceClientImplTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月5日 下午1:36:11
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class RoleServiceClientImplTest {

	private RoleService roleServiceMock;
	private RoleServiceClientImpl clientImplMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		roleServiceMock = EasyMock.createMock(RoleService.class);
		clientImplMock = new RoleServiceClientImpl();
		clientImplMock.setRoleService(roleServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchRole(){
		EasyMock.expect(roleServiceMock.searchRoles(
				(Pager<RoleDTO>)EasyMock.anyObject(),
				(RoleDTO)EasyMock.anyObject())
		).andReturn(new Pager<RoleDTO>()).times(1);
		EasyMock.replay(roleServiceMock);
		clientImplMock.searchRole(1L,10L,new RoleDTO());
	}

	/**
	 * @Title: testDeleteRoleMessage
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午1:43:31
	 */
	@Test
	public void testDeleteRoleMessage() {
		ExecuteResult<RoleDTO> resultTestCaseExecuteResult = new ExecuteResult<RoleDTO>();
		expect(roleServiceMock.deleteRole(11L)).andReturn(resultTestCaseExecuteResult);
		
		replay(roleServiceMock);
		String result = clientImplMock.deleteRoleMessage("11");
		assertNotNull(result);
		verify(roleServiceMock);
	}

	/**
	 * @Title: testCreateRole
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月5日 下午1:47:40
	 */
	@Test
	public void testCreateRole() {
		RoleDTO temp = new RoleDTO();
		temp.setResourceIds("1");
		expect(roleServiceMock.createRole(temp)).andReturn(new ExecuteResult<RoleDTO>());
		
		replay(roleServiceMock);
		String result = clientImplMock.createRole(temp);
		assertNotNull(result);
		verify(roleServiceMock);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.RoleServiceClientImpl#updateRole(com.haier.openplatform.wms.security.dto.RoleDTO)}.
	 */
	@Test
	public void testUpdateRole() {
		ExecuteResult<RoleDTO> resultTestCase = new ExecuteResult<RoleDTO>();
		RoleDTO temp = new RoleDTO();
		temp.setResourceIds("1");
		expect(roleServiceMock.updateRole(temp)).andReturn(resultTestCase);
		
		replay(roleServiceMock);
		clientImplMock.updateRole(temp);
		assertNotNull(true);
		verify(roleServiceMock);
	}

	/**
	 * Test method for {@link com.haier.openplatform.wms.security.service.impl.RoleServiceClientImpl#getRoleResources(long)}.
	 */
	@Test
	public void testGetRoleResources() {
		List<RoleDTO> temp = new ArrayList<RoleDTO>();
		expect(roleServiceMock.getRoleResources(11L)).andReturn(temp);
		
		replay(roleServiceMock);
		List<RoleDTO> result = clientImplMock.getRoleResources(11L);
		assertNotNull(result);
		verify(roleServiceMock);
	}

	@Test
	public void searchRolesByGroupId(){
		EasyMock.expect(roleServiceMock.getRolesByGroupId(
				(Pager<RoleDTO>)EasyMock.anyObject(),
				(RoleDTO)EasyMock.anyObject())
		).andReturn(new Pager<RoleDTO>()).times(1);
		EasyMock.replay(roleServiceMock);
		clientImplMock.searchRolesByGroupId(1L,10L,new RoleDTO());
	}

}
