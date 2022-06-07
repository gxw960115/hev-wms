package com.haier.wms.controller.order;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.easymock.EasyMock.*;
import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.po.service.OdsOrderInfoDtlServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: OdsOrderInfoDtlControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午11:24:21
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsOrderInfoDtlControllerTest {

	private PsiReportServiceClient psiReportServiceClient;
	private OdsOrderInfoDtlServiceClient odsOrderInfoDtlServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private OdsOrderInfoDtlController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:26:06  void
	 */
	@Before
	public void init() {
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		odsOrderInfoDtlServiceClient = EasyMock.createMock(OdsOrderInfoDtlServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new OdsOrderInfoDtlController();
		target.setOdsOrderInfoDtlServiceClient(odsOrderInfoDtlServiceClient);
		target.setPsiReportServiceClient(psiReportServiceClient);
		
		PowerMockito.mockStatic(SessionConstants.class,PageUtil.class);
		Pager<OdsOrderInfoDtlDTO> pager = new Pager<OdsOrderInfoDtlDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
		
		JSONObject res = new JSONObject();
		res.put("user_duty_type", "11");
		res.put("_user_id", "11");
		res.put("_user_name", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
	}
	
	/**
	 * @title: testSearchOdsOrderInfoDtl
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:53:59 
	 * @return: void
	 */
	@Test
	public void testSearchOdsOrderInfoDtl() {
		String result = target.searchOdsOrderInfoDtl(request, 11L, 11L, new OdsOrderInfoDtlDTO());
		Assert.assertNotNull(result);
	}

	/**
	 * @title: testSearchOrderInfoDtlAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:29:24  void
	 */
	@Test
	public void testSearchOrderInfoDtlAmount() {
		expect(odsOrderInfoDtlServiceClient.getExportAmount((OdsOrderInfoDtlDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(odsOrderInfoDtlServiceClient);
		
		target.searchOrderInfoDtlAmount(request, response, new OdsOrderInfoDtlDTO());
	}

	/**
	 * @title: testPrint
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:52:08 
	 * @return: void
	 */
	@Test
	public void testPrint() {
		ServletOutputStream stream = createMock(ServletOutputStream.class);
		try {
			expect(response.getOutputStream()).andReturn(stream);
			response.setContentType((String) anyObject());
			EasyMock.expectLastCall();
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
		
		String result = target.print(request, response, "1", "1");
		Assert.assertNull(result);
	}

}
