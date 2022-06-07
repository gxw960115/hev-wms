package com.haier.wms.controller.report;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.report.service.StoIntransitReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StoIntransitReportControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018-9-7 AM11:19:37
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018-9-7		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class StoIntransitReportControllerTest {

	private StoIntransitReportServiceClient stoIntransitReportServiceClient;
	private PsiReportServiceClient psiReportServiceClient;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private StoIntransitReportController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018-9-7 AM11:22:57
	 */
	@Before
	public void init() {
		stoIntransitReportServiceClient = EasyMock.createMock(StoIntransitReportServiceClient.class);
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new StoIntransitReportController();
		target.setPsiReportServiceClient(psiReportServiceClient);
		target.setStoIntransitReportServiceClient(stoIntransitReportServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<Object> pager = new Pager<Object>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchStoIntransitReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018-9-7 AM11:24:34  void
	 */
	@Test
	public void testSearchStoIntransitReport() {
		try {
			String result = target.searchStoIntransitReport(request, 11L, 11L, new StoIntransitReportDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchStoIntransitAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 下午1:25:50 
	 * @return: void
	 */
	@Test
	public void testSearchStoIntransitAmount() {
		expect(stoIntransitReportServiceClient.getExportAmount((StoIntransitReportDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(stoIntransitReportServiceClient);
		
		String result = target.searchStoIntransitAmount(request, response, new StoIntransitReportDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportStoIntransitReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018-9-7 AM11:26:54  void
	 */
	@Test
	public void testExportStoIntransitReport() {
		String result = target.exportStoIntransitReport(request, response, new StoIntransitReportDTO());
		assertNull(result);
	}

	/**
	 * @title: testPrintOfp
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018-9-7 AM11:27:00  void
	 */
	@Test
	public void testPrintOfp() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		StoIntransitReportDTO testCase = new StoIntransitReportDTO();
		testCase.setStoNo("test");
		testCase.setMaterialNo("test");
		testCase.setDivision("test");
		String result = target.printOfp(request, response, new StoIntransitReportDTO());
		assertNull(result);
	}

}