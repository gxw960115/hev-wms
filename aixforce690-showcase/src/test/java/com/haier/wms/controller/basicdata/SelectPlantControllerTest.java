package com.haier.wms.controller.basicdata;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;

import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.PlantDTO;
import com.haier.openplatform.wms.security.service.PlantServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

import java.util.ArrayList;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: SelectPlantControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月11日 上午9:44:39
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月11日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class SelectPlantControllerTest {

	private PlantServiceClient plantServiceClient;
	private HttpServletRequest request;
//	private HttpServletResponse response;
	
	private SelectPlantController target;
	
	/**
	 * @title: initialization
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:47:45 
	 * @return: void
	 */
	@Before
	public void initialization() {
		plantServiceClient = createMock(PlantServiceClient.class);
		request = createMock(HttpServletRequest.class);
//		response = createMock(HttpServletResponse.class);
		
		target = new SelectPlantController();
		target.setPlantServiceClient(plantServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class);
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSelectPlant
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:47:52 
	 * @return: void
	 */
	@Test
	public void testSelectPlant() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		String result = target.selectPlant(request, 11L, 11L, new PlantDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSelectPlantList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:49:48 
	 * @return: void
	 */
	@Test
	public void testSelectPlantList() {
		expect(plantServiceClient.searchAll()).andReturn(new ArrayList<CdFactoryDTO>());
		replay(plantServiceClient);
		String result = target.selectPlantList();
		assertNotNull(result);
	}

}
