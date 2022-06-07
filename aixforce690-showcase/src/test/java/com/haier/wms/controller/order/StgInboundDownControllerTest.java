package com.haier.wms.controller.order;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
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
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.order.service.StgInboundDownServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StgInboundDownControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 下午3:57:34
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StgInboundDownControllerTest {

	private StgInboundDownServiceClient stgInboundDownService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StgInboundDownController target;
	
	/**
	 * @title: initialization
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午3:58:59 
	 * @return: void
	 */
	@Before
	public void initialization() {
		stgInboundDownService = createMock(StgInboundDownServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		
		target = new StgInboundDownController();
		target.setStgInboundDownService(stgInboundDownService);
		
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
	 * @title: testSearchStgInboundDowns
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:01:45 
	 * @return: void
	 */
	@Test
	public void testSearchStgInboundDowns() {
		try {
			String result = target.searchStgInboundDowns(request, response, new StgInboundDownDTO(), 11L, 11L);
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchStgInboundDownAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午4:03:21 
	 * @return: void
	 */
	@Test
	public void testSearchStgInboundDownAmount() {
		expect(stgInboundDownService.getExportAmount((StgInboundDownDTO) anyObject())).andReturn(250001L);
		replay(stgInboundDownService);
		String result = target.searchStgInboundDownAmount(request, response, new StgInboundDownDTO());
		assertNotNull(result);
	}

}
