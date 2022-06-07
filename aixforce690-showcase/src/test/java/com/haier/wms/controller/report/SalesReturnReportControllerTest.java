package com.haier.wms.controller.report;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.report.service.SalesReturnReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: SalesReturnReportControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午10:34:24
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class SalesReturnReportControllerTest {

	private SalesReturnReportServiceClient salesReturnReportServiceClient;
	private PsiReportServiceClient psiReportServiceClient;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private SalesReturnReportController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:08:06  void
	 */
	@Before
	public void init() {
		salesReturnReportServiceClient = EasyMock.createMock(SalesReturnReportServiceClient.class);
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new SalesReturnReportController();
		target.setPsiReportServiceClient(psiReportServiceClient);
		target.setSalesReturnReportServiceClient(salesReturnReportServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<Object> pager = new Pager<Object>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchSalesReturnReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:09:59  void
	 */
	@Test
	public void testSearchSalesReturnReport() {
		try {
			String result = target.searchSalesReturnReport(request, 11L, 11L, new SalesReturnReportDTO());
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchSalesReturnAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:12:28  void
	 */
	@Test
	public void testSearchSalesReturnAmount() {
		expect(salesReturnReportServiceClient.getExportAmount((SalesReturnReportDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(salesReturnReportServiceClient);
		
		String result = target.searchSalesReturnAmount(request, response, new SalesReturnReportDTO());
		Assert.assertNotNull(result);
		verify(salesReturnReportServiceClient);
	}

	/**
	 * @title: testExportSalesReturnReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:14:06  void
	 */
	@Test
	public void testExportSalesReturnReport() {
		String result = target.exportSalesReturnReport(request, response, new SalesReturnReportDTO());
		assertNull(result);
	}

	/**
	 * @title: testPrintOfp
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:14:44  void
	 */
	@Test
	public void testPrintOfp() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		SalesReturnReportDTO testCase = new SalesReturnReportDTO();
		testCase.setBegin("test");
		testCase.setEnd("test");
		testCase.setLocation("test");
		testCase.setMaterialNo("test");
		String resu = target.printOfp(request, response, testCase);
		assertNull(resu);
	}

}
