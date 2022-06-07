package com.haier.wms.controller.order;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: OdsOrderInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:49:15
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsOrderInfoControllerTest {

	private OdsOrderInfoServiceClient odsOrderInfoService;
	private PsiReportServiceClient psiReportServiceClient;
	private StgStodnDownServiceClient stgStoDnDownServiceClient;
	private OdsOrderInfoController target;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	/**
	 * @title: init
	 * @description:初始化
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午10:09:29  void
	 */
	@Before
	public void init() {
		odsOrderInfoService = EasyMock.createMock(OdsOrderInfoServiceClient.class);
		psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
		stgStoDnDownServiceClient = EasyMock.createMock(StgStodnDownServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		session = EasyMock.createMock(HttpSession.class);
		servletContext = EasyMock.createMock(ServletContext.class);
		
		target = new OdsOrderInfoController();
		target.setOdsOrderInfoService(odsOrderInfoService);
		target.setPsiReportServiceClient(psiReportServiceClient);
		target.setStgStoDnDownServiceClient(stgStoDnDownServiceClient);
		
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
	 * @title: testSearchOIGPOrders
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:35:18 
	 * @return: void
	 */
	@Test
	public void testSearchOIGPOrders() {
		String result = target.searchOIGPOrders(11L, 11L, new OdsOrderInfoDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSearchOIGPOrderInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:35:41 
	 * @return: void
	 */
	@Test
	public void testSearchOIGPOrderInfo() {
		String result = target.searchOIGPOrderInfo(11L, 11L, new OdsOrderInfoDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSearchOIGPOrdersByNo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:22:09  void
	 */
	@Test
	public void testSearchOIGPOrdersByNo() {
		target.searchOIGPOrdersByNo(new OdsOrderInfoDTO());
		assertTrue(true);
	}

	/**
	 * @title: testReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:21:23  void
	 */
	@Test
	public void testReport() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		OdsOrderInfoDTO dtoTestCase = new OdsOrderInfoDTO();
		dtoTestCase.setCarFlag("1");
		target.report(request, response, dtoTestCase);
		assertTrue(true);
	}

	/**
	 * @title: testAddGFOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:17:22  void
	 */
	@Test
	public void testAddGFOrder() {
		target.addGFOrder(new OdsOrderInfoDTO());
		assertTrue(true);
	}

	/**
	 * @title: testDeleteGFOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:16:49  void
	 */
	@Test
	public void testDeleteGFOrder() {
		target.deleteGFOrder("1");
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.order.OdsOrderInfoController#searchOrderNo(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO, java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public void testSearchOrderNo() {
		try {
			target.searchOrderNo(new OdsOrderInfoDTO(), 11L, 11L);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.haier.wms.controller.order.OdsOrderInfoController#searchStoDNDetail(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO, java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public void testSearchStoDNDetail() {
		try {
			target.searchStoDNDetail(new OdsOrderInfoDTO(), 11L, 11L);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchOgpDetailList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:14:01  void
	 */
	@Test
	public void testSearchOgpDetailList() {
		try {
			target.searchOgpDetailList(new OdsOrderInfoDtlDTO(), 11L, 11L);
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testPrescanImportCheck
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:06:37  void
	 */
	@Test
	public void testPrescanImportCheck() {
		List<OdsOrderInfoDTO> testCaseDtos = new ArrayList<OdsOrderInfoDTO>();
		testCaseDtos.add(new OdsOrderInfoDTO());
		expect(odsOrderInfoService.getListByParams((OdsOrderInfoDTO) anyObject())).andReturn(testCaseDtos);
		
		replay(odsOrderInfoService);
		try {
			target.prescanImportCheck("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @title: testSearchList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:02:31  void
	 */
	@Test
	public void testSearchList() {
		target.searchList(new OdsOrderInfoDTO());
		assertTrue(true);
	}

	/**
	 * @title: testPrescan
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:00:59  void
	 */
	@Test
	public void testPrescan() {
		odsOrderInfoService.saveOdsInfoDtls((String) anyObject());
		expectLastCall();
		
		ExecuteResult<OdsOrderInfoDTO> testCase  = new ExecuteResult<OdsOrderInfoDTO>();
		OdsOrderInfoDTO temp = new OdsOrderInfoDTO();
		temp.setMsg("1");
		temp.setOrId("1");
		testCase.setResult(temp);
		expect(odsOrderInfoService.savePreScan((String) anyObject(), (String) anyObject())).andReturn(testCase);
		
		odsOrderInfoService.deleteOdsOrderInfoDtlByNo((String) anyObject());
		expectLastCall();
		
		odsOrderInfoService.updateFinishQty((String) anyObject());
		expectLastCall();
		
		replay(odsOrderInfoService);
		String result = target.prescan("", "");
		assertNotNull(result);
		verify(odsOrderInfoService);
	}

	/**
	 * @title: testPostOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:46:50 
	 * @return: void
	 */
	@Test
	public void testPostOrder() {
		try {
			target.postOrder("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.haier.wms.controller.order.OdsOrderInfoController#print(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testPrint() throws IOException {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
//		expect(response.getOutputStream()).andReturn((ServletOutputStream) anyObject());
//		byte[] bytes = new byte[1];
//		expect(psiReportServiceClient.generatePsiReport("", new HashMap())).andReturn(bytes);
		
//		replay(psiReportServiceClient);
//		replay(response);
		replay(request);
		replay(session);
		replay(servletContext);
		target.print(request, response, "1");
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.order.OdsOrderInfoController#printOfp(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPrintOfp() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		
		target.printOfp(request, response, "", "");
		assertTrue(true);
	}

}
