package com.haier.wms.controller.security;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.hac.security.model.UserSearchModel;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.security.service.SecurityUserServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: UserControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月6日 下午5:21:26
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class UserControllerTest {

	private MdDictionaryServiceClient mdDictionaryServiceClient;
	private CdWhInfoServiceClient cdWhInfoServiceClient;
	private SecurityUserServiceClient securityUserServiceClient;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private UserController target;
	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		mdDictionaryServiceClient = EasyMock.createMock(MdDictionaryServiceClient.class);
		cdWhInfoServiceClient = EasyMock.createMock(CdWhInfoServiceClient.class);
		securityUserServiceClient = EasyMock.createMock(SecurityUserServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new UserController();
		target.setCdWhInfoServiceClient(cdWhInfoServiceClient);
		target.setMdDictionaryServiceClient(mdDictionaryServiceClient);
		target.setSecurityUserServiceClient(securityUserServiceClient);
		target.getSecurityUserServiceClient();
		target.getMdDictionaryServiceClient();
		target.getCdWhInfoServiceClient();
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<RoleDTO> pager = new Pager<RoleDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchDivisions
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午5:24:20  void
	 */
	@Test
	public void testSearchDivisions() {
		String result = target.searchDivisions();
		assertNotNull(result);
	}

	/**
	 * @title: testSelectLocationTree
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午5:25:31  void
	 */
	@Test
	public void testSelectLocationTree() {
		String result = target.selectLocationTree(request, "11");
		assertNotNull(result);
	}

	/**
	 * @title: testSearchUser
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午5:28:03  void
	 */
	@Test
	public void testSearchUser() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		Pager<UserDTO> outpager = new Pager<UserDTO>();
		UserDTO temp = new UserDTO();
		expect(securityUserServiceClient.searchUser(11L, 11L, temp)).andReturn(outpager);
		replay(securityUserServiceClient);
		
		String result = target.searchUser(request, temp);
		assertNotNull(result);
	}

	/**
	 * @title: testLogin
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:06:28  void
	 */
	@Test
	public void testLogin() {
		expect(request.getHeader((String) anyObject())).andReturn("11");
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		ExecuteResult<UserDTO> returnTestCase = new ExecuteResult<UserDTO>();
		List<String> temp = new ArrayList<String>();
		temp.add("11");
		returnTestCase.setErrorMessages(temp);
		expect(securityUserServiceClient.userLogin("11", "11", "11")).andReturn(returnTestCase);
		
		replay(securityUserServiceClient);
		
		String result = target.login(request, response);
		assertNotNull(result);
		EasyMock.verify(request);
		EasyMock.verify(securityUserServiceClient);
		
	}

}
