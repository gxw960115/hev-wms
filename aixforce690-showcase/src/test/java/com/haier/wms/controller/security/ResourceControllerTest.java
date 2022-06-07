package com.haier.wms.controller.security;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.service.ResourceServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: ResourceControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 下午4:47:06
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class ResourceControllerTest {

	private ResourceServiceClient resourceServiceClient;
	private HttpServletRequest request;
//	private HttpServletResponse response;
	private ResourceController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午4:47:54  void
	 */
	@Before
	public void init() {
		resourceServiceClient = EasyMock.createMock(ResourceServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
//		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new ResourceController();
		target.setResourceServiceClient(resourceServiceClient);
		target.getResourceServiceClient();
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<ResourceDTO> pager = new Pager<ResourceDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	/**
	 * @title: testSearchResource
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午4:56:41  void
	 */
	@Test
	public void testSearchResource() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		Pager<ResourceDTO> outpager = new Pager<ResourceDTO>();
		ResourceDTO temp = new ResourceDTO();
		expect(resourceServiceClient.searchResource(11L, 11L, temp)).andReturn(outpager);
		
		String result = target.searchResource(request, temp);
		assertNotNull(result);
	}

	/**
	 * @title: testSelectResourceTree
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午4:57:16  void
	 */
	@Test
	public void testSelectResourceTree() {
		expect(request.getParameter((String) anyObject())).andReturn("22");
		replay(request);
		
		String resultString = target.selectResourceTree(request);
		assertNotNull(resultString);
	}

	/**
	 * @title: testGetParentResource
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午4:58:36  void
	 */
	@Test
	public void testGetParentResource() {
		expect(request.getParameter((String) anyObject())).andReturn("22");
		replay(request);
		
		String result = target.getParentResource(request);
		assertNotNull(result);
	}

}
