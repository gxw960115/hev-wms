package com.haier.wms.controller.order;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import com.haier.wms.controller.sto.StgStoDownController;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StgStoDownControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 下午4:32:04
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StgStoDownControllerTest {

	private StgStoDownServiceClient stgStoDownService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StgStoDownController target;
	
	/**
	 * @title: initialization
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:34:39 
	 * @return: void
	 */
	@Before
	public void initialization() {
		stgStoDownService = createMock(StgStoDownServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		
		target = new StgStoDownController();
		target.setStgStoDownServiceClient(stgStoDownService);
		
		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
		Pager<Object> pager = new Pager<Object>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
		JSONObject res = new JSONObject();
		res.put("_user_name", "11");
		res.put("user_duty_type", "11");
		res.put("_user_id", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
	}
	
	/**
	 * @title: testSelectStgStoDowns
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:35:43 
	 * @return: void
	 */
	@Test
	public void testSelectStgStoDowns() {
		String result = target.selectStgStoDowns(request, 11L, 11L, new StgStoDownDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSearchList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:39:43 
	 * @return: void
	 */
	@Test
	public void testSearchList() {
		try {
			String result = target.searchList(new StgStoDownDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchStgStoDownAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:39:41 
	 * @return: void
	 */
	@Test
	public void testSearchStgStoDownAmount() {
		expect(stgStoDownService.getExportAmount((StgStoDownDTO) anyObject())).andReturn(25001L);
		replay(stgStoDownService);
		String result = target.searchStgStoDownAmount(request, response, new StgStoDownDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportStgStoDown
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:39:39 
	 * @return: void
	 */
	@Test
	public void testExportStgStoDown() {
		try {
			String result = target.exportStgStoDown(request, response, new StgStoDownDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
