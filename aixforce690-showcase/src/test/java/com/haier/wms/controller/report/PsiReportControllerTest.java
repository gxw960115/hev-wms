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
import com.haier.openplatform.wms.report.dto.PsiReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: PsiReportControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午9:57:49
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class PsiReportControllerTest {

	private PsiReportServiceClient psiReportServiceClient;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private PsiReportController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:58:32  void
	 */
	@Before
	public void init() {
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new PsiReportController();
		target.setPsiReportServiceClient(psiReportServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<Object> pager = new Pager<Object>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchPsiReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:04:13  void
	 */
	@Test
	public void testSearchPsiReport() {
		try {
			String result = target.searchPsiReport(request, 11L, 11L, new PsiReportDTO());
			Assert.assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchPsiReportAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:04:39  void
	 */
	@Test
	public void testSearchPsiReportAmount() {
		expect(psiReportServiceClient.getExportAmount((PsiReportDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(psiReportServiceClient);
		
		String result = target.searchPsiReportAmount(request, response, new PsiReportDTO());
		assertNotNull(result);
		verify(psiReportServiceClient);
	}

	/**
	 * @title: testExportPsiReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:11:42  void
	 */
	@Test
	public void testExportPsiReport() {
		String result = target.exportPsiReport(request, response, new PsiReportDTO());
		assertNull(result);
	}

	/**
	 * @title: testPrint
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:26:28  void
	 */
	@Test
	public void testPrint() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		PsiReportDTO testCase = new PsiReportDTO();
		testCase.setBegin("11");
		testCase.setEnd("11");
		testCase.setWarehouseCode("11");
		testCase.setLocation("11");
		testCase.setMaterialNo("11");
		testCase.setDivision("11");
		String result = target.print(request, response, testCase);
		assertNull(result);
	}

	/**
	 * @title: testPrintInQty
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:28:27  void
	 */
	@Test
	public void testPrintInQty() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		String result = target.printInQty(request, response, "11", "11", "11", "11", "11");
		assertNull(result);
	}

	/**
	 * @title: testPrintOutQty
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:29:51  void
	 */
	@Test
	public void testPrintOutQty() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		String result = target.printOutQty(request, response, "test", "test", "test", "test");
		assertNull(result);
	}

	/**
	 * @title: testPrintWmsQty
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:30:05  void
	 */
	@Test
	public void testPrintWmsQty() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		String result = target.printWmsQty(request, response, "test", "test");
		assertNull(result);
	}

	/**
	 * @title: testPrintOpenQty
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午10:32:13  void
	 */
	@Test
	public void testPrintOpenQty() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		String result = target.printOpenQty(request, response, "test", "test", "test", "test");
		assertNull(result);
	}

}
