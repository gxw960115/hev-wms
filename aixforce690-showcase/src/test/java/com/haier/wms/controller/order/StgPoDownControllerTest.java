package com.haier.wms.controller.order;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.po.service.StgPoDownServiceClient;
import com.haier.wms.controller.po.StgPoDownController;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StgPoDownControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 下午4:05:23
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StgPoDownControllerTest {

	private StgPoDownServiceClient stgPoDownService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StgPoDownController target;
	
	/**
	 * @title: initialization
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:06:40 
	 * @return: void
	 */
	@Before
	public void initialization() {
		stgPoDownService = createMock(StgPoDownServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		
		target = new StgPoDownController();
		target.setStgPoDownService(stgPoDownService);
		
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
	 * @title: testCreateMaterialInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:09:05 
	 * @return: void
	 */
	@Test
	public void testCreateMaterialInfo() {
		String result = target.createMaterialInfo(new StgPoDownDTO());
		assertNull(result);
	}

	/**
	 * @title: testSelectStgPoDowns
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:10:36 
	 * @return: void
	 */
	@Test
	public void testSelectStgPoDowns() {
		String result = target.selectStgPoDowns(request, 11L, 11L, new StgPoDownDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSearchStgPoDownAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:11:00 
	 * @return: void
	 */
	@Test
	public void testSearchStgPoDownAmount() {
		expect(stgPoDownService.getExportAmount((StgPoDownDTO) anyObject())).andReturn(25001L);
		replay(stgPoDownService);
		String result = target.searchStgPoDownAmount(request, response, new StgPoDownDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportStgPoDown
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:12:39 
	 * @return: void
	 */
	@Test
	public void testExportStgPoDown() {
		try {
			String result = target.exportStgPoDown(request, response, new StgPoDownDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
