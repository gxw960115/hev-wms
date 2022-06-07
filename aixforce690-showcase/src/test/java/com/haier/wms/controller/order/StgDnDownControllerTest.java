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
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
import com.haier.wms.controller.so.StgSoDownController;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StgDnDownControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 下午3:33:04
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StgDnDownControllerTest {

	private StgDnDownServiceClient stgDnDownService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StgSoDownController target;
	
	/**
	 * @title: initialization
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月10日 下午3:57:09 
	 * @return: void
	 */
	@Before
	public void initialization() {
		stgDnDownService = createMock(StgDnDownServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		
		target = new StgSoDownController();
		
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
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSelectDnDowns() {
		String result = target.selectDnDowns(request, 11L, 11L, new StgDnDownDTO());
		assertNotNull(result);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchStgDnDownAmount() {
		expect(stgDnDownService.getExportAmount((StgDnDownDTO) anyObject())).andReturn(25001L);
		replay(stgDnDownService);
		String result = target.searchStgDnDownAmount(request, response, new StgDnDownDTO());
		assertNotNull(result);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testExportStgDnDown() {
		try {
			String result = target.exportStgDnDown(request, response, new StgDnDownDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
