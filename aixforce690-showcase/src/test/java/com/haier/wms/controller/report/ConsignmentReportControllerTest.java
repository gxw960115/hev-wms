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
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.openplatform.wms.report.service.ConsignmentReportServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.security.dto.RoleDTO;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: ConsignmentReportControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午9:16:08
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(PageUtil.class)
public class ConsignmentReportControllerTest {

	private PsiReportServiceClient psiReportServiceClient;
	private ConsignmentReportServiceClient consignmentReportServiceClient;
	// JSP对象
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	// 目标对象
	private ConsignmentReportController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:17:43  void
	 */
	@Before
	public void init() {
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		consignmentReportServiceClient = EasyMock.createMock(ConsignmentReportServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new ConsignmentReportController();
		target.setConsignmentReportServiceClient(consignmentReportServiceClient);
		target.setPsiReportServiceClient(psiReportServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class);
		Pager<RoleDTO> pager = new Pager<RoleDTO>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSearchConsignmentReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:26:07  void
	 */
	@Test
	public void testSearchConsignmentReport() {
		try {
			String result = target.searchConsignmentReport(request, 11L, 11L, new ConsignmentReportDTO());
			assertNotNull(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchInventoryAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:47:10  void
	 */
	@Test
	public void testSearchInventoryAmount() {
		expect(consignmentReportServiceClient.getExportAmount((ConsignmentReportDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(consignmentReportServiceClient);
		
		String result = target.searchInventoryAmount(request, response, new ConsignmentReportDTO());
		assertNotNull(result);
		verify(consignmentReportServiceClient);
	}

	/**
	 * @title: testExportConsignmentReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:48:52  void
	 */
	@Test
	public void testExportConsignmentReport() {
		String result = target.exportConsignmentReport(request, response, new ConsignmentReportDTO());
		assertNull(result);
	}

	/**
	 * @title: testPrintConsigment
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午9:56:38  void
	 */
	@Test
	public void testPrintConsigment() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		ConsignmentReportDTO testCase = new ConsignmentReportDTO();
		testCase.setMaterialNo("11");
		testCase.setCustomerNo("11");
		testCase.setDivision("11");
		String result = target.printConsigment(request, response, testCase);
		assertNull(result);
	}

}
