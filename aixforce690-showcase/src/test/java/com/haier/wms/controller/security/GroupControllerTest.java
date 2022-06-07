package com.haier.wms.controller.security;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.hac.security.model.UserInGroupSearchModel;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.domain.UserGroup;
import com.haier.openplatform.wms.security.dto.GroupDTO;
import com.haier.openplatform.wms.security.service.GroupServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: GroupControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 下午2:15:42
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class GroupControllerTest {

	private GroupServiceClient groupServiceClient;
	private HttpServletRequest request;
	private GroupController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午2:16:38  void
	 */
	@Before
	public void init() {
		groupServiceClient = EasyMock.createMock(GroupServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		target = new GroupController();
		target.setGroupServiceClient(groupServiceClient);
		target.getGroupServiceClient();
		PowerMockito.mockStatic(PageUtil.class);
		Pager<GroupDTO> pager = new Pager<GroupDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchGroup
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午2:16:13  void
	 */
	@Test
	public void testSearchGroup() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		String result = target.searchGroup(request, new GroupDTO());
		Assert.assertNotNull(result);
	}

}
