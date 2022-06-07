package com.haier.wms.controller.order;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.openplatform.wms.order.service.OdsWmsOrderServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: OdsWmsOrderControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 下午3:15:07
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsWmsOrderControllerTest {

	private OdsWmsOrderServiceClient odsWmsOrderServiceClient;
	private PsiReportServiceClient psiReportServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private OdsWmsOrderController target;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void initialization() {
		psiReportServiceClient = createMock(PsiReportServiceClient.class);
		odsWmsOrderServiceClient = createMock(OdsWmsOrderServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		session = createMock(HttpSession.class);
		servletContext = createMock(ServletContext.class);
		
		target = new OdsWmsOrderController();
		target.setOdsWmsOrderClient(odsWmsOrderServiceClient);
		target.setPsiReportServiceClient(psiReportServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
		Pager<OdsOrderInfoDtlDTO> pager = new Pager<OdsOrderInfoDtlDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
		
		JSONObject res = new JSONObject();
		res.put("_user_name", "11");
		res.put("_user_id", "11");
		res.put("user_duty_type", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
	}
	
	/**
	 * @title: testSearchGfOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:00:12 
	 * @return: void
	 */
	@Test
	public void testSearchGfOrder() {
		String result = target.searchGfOrder(request, 11L, 11L, new OdsWmsOrderDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSaveScrapOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:02:11 
	 * @return: void
	 */
	@Test
	public void testSaveScrapOrder() {
		ExecuteResult<OdsWmsOrderDTO> executeResult = new ExecuteResult<OdsWmsOrderDTO>();
		expect(odsWmsOrderServiceClient.saveScrapOrder((OdsWmsOrderDTO) anyObject(), 
				(String) anyObject())).andReturn(executeResult);
		replay(odsWmsOrderServiceClient);
		String result = target.saveScrapOrder(request, "11", new OdsWmsOrderDTO());
		assertNotNull(result);
		verify(odsWmsOrderServiceClient);
	}

	/**
	 * @title: testDeltScrapOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:07:15 
	 * @return: void
	 */
	@Test
	public void testDeltScrapOrder() {
		OdsWmsOrderDTO temp = new OdsWmsOrderDTO();
		expect(odsWmsOrderServiceClient.getOdsWmsOrderById((Long) anyObject())).andReturn(temp);
		
		ExecuteResult<OdsWmsOrderDTO> execute = new ExecuteResult<OdsWmsOrderDTO>();
		expect(odsWmsOrderServiceClient.deleteScrapOrder((OdsWmsOrderDTO) anyObject())).andReturn(execute);
		
		replay(odsWmsOrderServiceClient);
		
		String result = target.deltScrapOrder("11");
		assertNotNull(result);
		verify(odsWmsOrderServiceClient);
	}

	/**
	 * @title: testCheckScrapOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:09:20 
	 * @return: void
	 */
	@Test
	public void testCheckScrapOrder() {
		ExecuteResult<OdsWmsOrderDTO> execute = new ExecuteResult<OdsWmsOrderDTO>();
		expect(odsWmsOrderServiceClient.updateScrapOrder((OdsWmsOrderDTO) anyObject())).andReturn(execute);
		replay(odsWmsOrderServiceClient);
		String result = target.checkScrapOrder(new OdsWmsOrderDTO());
		assertNotNull(result);
		verify(odsWmsOrderServiceClient);
	}

	/**
	 * @title: testDeltGfOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:11:58 
	 * @return: void
	 */
	@Test
	public void testDeltGfOrder() {
		ExecuteResult<OdsWmsOrderDTO> execute = new ExecuteResult<OdsWmsOrderDTO>();
		expect(odsWmsOrderServiceClient.deltGfOrder((OdsWmsOrderDTO) anyObject())).andReturn(execute);
		replay(odsWmsOrderServiceClient);
		
		try {
			String result = target.deltGfOrder(new OdsWmsOrderDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchScrapBarcodeDtl
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:13:15 
	 * @return: void
	 */
	@Test
	public void testSearchScrapBarcodeDtl() {
		String result = target.searchScrapBarcodeDtl(request, 11L, 11L, new OdsInventoryInfoDtlDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSaveGfOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:14:54 
	 * @return: void
	 */
	@Test
	public void testSaveGfOrder() {
		ExecuteResult<OdsWmsOrderDTO> execute = new ExecuteResult<OdsWmsOrderDTO>();
		expect(odsWmsOrderServiceClient.createOdsWmsOrder((OdsWmsOrderDTO) anyObject())).andReturn(execute);
		replay(odsWmsOrderServiceClient);
		try {
			String result = target.saveGfOrder(new OdsWmsOrderDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testPrint
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午11:17:54 
	 * @return: void
	 */
	@Test
	public void testPrint() {
		ServletOutputStream outputStream = createMock(ServletOutputStream.class);
		try {
			expect(response.getOutputStream()).andReturn(outputStream);
			response.setContentType((String) anyObject());
			expectLastCall();
		} catch (IOException e) {
			e.printStackTrace();
		}
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(response);
		replay(session);
		replay(servletContext);
		String result = target.print(request, response, "11");
		assertNull(result);
	}

}
