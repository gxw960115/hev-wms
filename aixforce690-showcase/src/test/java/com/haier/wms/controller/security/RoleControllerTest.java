package com.haier.wms.controller.security;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.hac.security.model.RoleSearchModel;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.service.RoleServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: RoleControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 下午4:59:48
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class RoleControllerTest {

	private RoleServiceClient roleServiceClient;
	private RoleController target;
	private HttpServletRequest request;
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午5:00:29  void
	 */
	@Before
	public void init() {
		roleServiceClient = EasyMock.createMock(RoleServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		
		target = new RoleController();
		target.setRoleServiceClient(roleServiceClient);
		target.getRoleServiceClient();
		target.getRoleServiceClient();
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<RoleDTO> pager = new Pager<RoleDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchRole
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午5:01:29  void
	 */
	@Test
	public void testSearchRole() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		Pager<RoleDTO> outpager = new Pager<RoleDTO>();
		RoleDTO temp = new RoleDTO();
		expect(roleServiceClient.searchRole(11L, 11L, temp)).andReturn(outpager);
		replay(roleServiceClient);
		
		String result = target.searchRole(request, temp);
		assertNotNull(result);
	}

}
