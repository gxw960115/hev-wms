//package com.haier.wms.controller.order;
//
//import static org.easymock.EasyMock.anyObject;
//import static org.easymock.EasyMock.createMock;
//import static org.easymock.EasyMock.expect;
//import static org.easymock.EasyMock.replay;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import net.sf.json.JSONObject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.haier.openplatform.util.Pager;
//import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
//import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
//import com.haier.wms.util.PageBean;
//import com.haier.wms.util.PageUtil;
//import com.haier.wms.util.SessionConstants;
//
///**
// * Copyright: Copyright © 2018 LiuJiazhen
// * @className: StgStoDnDownControllerTest.java
// * @description: 
// *
// * @version: v1.0.0
// * @author: LiuJiazhen
// * @date 2018年9月10日 下午4:14:13
// *
// * Modification History:
// * Date			Author			Version			Description
// *---------------------------------------------------------*
// * 2018年9月10日		LJZ			v1.0.0			create
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
//public class StgStoDnDownControllerTest {
//
//	private StgStodnDownServiceClient stgStoDnDownService;
//	private HttpServletRequest request;
//	private HttpServletResponse response;
//	private HttpSession session;
//	private ServletContext servletContext;
//	
//	private StgStodnDownController target;
//	
//	/**
//	 * @title: initialization
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:15:38 
//	 * @return: void
//	 */
//	@Before
//	public void initialization() {
//		stgStoDnDownService = createMock(StgStodnDownServiceClient.class);
//		request = createMock(HttpServletRequest.class);
//		response = createMock(HttpServletResponse.class);
//		session = createMock(HttpSession.class);
//		servletContext = createMock(ServletContext.class);
//		
//		target = new StgStodnDownController();
//		target.setStgStoDnDownService(stgStoDnDownService);
//		
//		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
//		Pager<Object> pager = new Pager<Object>();
//		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
//		JSONObject res = new JSONObject();
//		res.put("_user_name", "11");
//		res.put("user_duty_type", "11");
//		res.put("_user_id", "11");
//		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
//	}
//	
//	/**
//	 * @title: testGetlist
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:18:31 
//	 * @return: void
//	 */
//	@Test
//	public void testGetlist() {
//		String result = target.getlist(new StgStodnDownDTO(), 11L, 11L);
//		assertNotNull(result);
//	}
//
//	/**
//	 * @title: testSearchStgStoDnDownAmount
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:19:42 
//	 * @return: void
//	 */
//	@Test
//	public void testSearchStgStoDnDownAmount() {
//		expect(stgStoDnDownService.getExportAmount((StgStodnDownDTO) anyObject())).andReturn(24500L);
//		replay(stgStoDnDownService);
//		String result = target.searchStgStoDnDownAmount(request, response, new StgStodnDownDTO());
//		assertNotNull(result);
//	}
//
//	/**
//	 * @title: testExportStgStoDown
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:20:40 
//	 * @return: void
//	 */
//	@Test
//	public void testExportStgStoDown() {
//		try {
//			String result = target.exportStgStoDown(request, response, new StgStodnDownDTO());
//			assertNotNull(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testImportStoReceipt() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		try {
//			expect(file.getBytes()).andReturn("11".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		replay(file);
//		replay(request2);
//		
//		target.importStoReceipt(request2, "");
//	}
//
//	/**
//	 * Test method for {@link com.haier.wms.controller.order.StgStodnDownController#importStoReceiptPlus(org.springframework.web.multipart.MultipartHttpServletRequest, java.lang.String)}.
//	 */
//	@Test
//	public void testImportStoReceiptPlus() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		replay(request2);
//		
//		target.importStoReceiptPlus(request2, "11");
//	}
//
//	/**
//	 * Test method for {@link com.haier.wms.controller.order.StgStodnDownController#importDnDelivery(org.springframework.web.multipart.MultipartHttpServletRequest)}.
//	 */
//	@Test
//	public void testImportDnDelivery() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		try {
//			expect(file.getBytes()).andReturn("11".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		replay(file);
//		replay(request2);
//		
//		target.importDnDelivery(request2);
//	}
//
//	/**
//	 * Test method for {@link com.haier.wms.controller.order.StgStodnDownController#importInboundDelivery(org.springframework.web.multipart.MultipartHttpServletRequest)}.
//	 */
//	@Test
//	public void testImportInboundDelivery() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		try {
//			expect(file.getBytes()).andReturn("11".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		replay(file);
//		replay(request2);
//		
//		target.importInboundDelivery(request2);
//	}
//
//	/**
//	 * Test method for {@link com.haier.wms.controller.order.StgStoDnDownController#template(javax.servlet.http.HttpServletRequest, java.lang.String)}.
//	 */
//	/**
//	 * @title: testTemplate
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:28:14 
//	 * @return: void
//	 */
//	@Test
//	public void testTemplate() {
//		expect(request.getSession()).andReturn(session);
//		expect(session.getServletContext()).andReturn(servletContext);
//		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
//		
//		replay(request);
//		replay(session);
//		replay(servletContext);
//		ResponseEntity<byte[]> result = target.template(request, "11");
//		assertNull(result);
//	}
//
//	/**
//	 * @title: testImportStoExcel
//	 * @description:方法太复杂
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月10日 下午4:30:50 
//	 * @return: void
//	 */
//	@Test
//	public void testImportStoExcel() {
//		Map<String, Object> result = target.importStoExcel("doc", "11", "11", "11".getBytes());
//		assertNotNull(result);
//	}
//
////	@Test
////	public void testImportStoExcelPlus() {
////		target.importStoExcelPlus("11", "11", new File("Test1.java"));
////	}
//
//	@Test
//	public void testImportStoRecPlus() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		replay(request2);
//		
//		target.importStoRecPlus(request2);
//	}
//
//	/**
//	 * @title: testImportInboundDeliveryPlus
//	 * @description:
//	 * @author: LJZ
//	 * @version: v1.0.0
//	 * @date: 2018年9月11日 下午5:24:34 
//	 * @return: void
//	 */
//	@Test
//	public void testImportInboundDeliveryPlus() {
//		MultipartHttpServletRequest request2 = createMock(MultipartHttpServletRequest.class);
//		Set<String> set = new HashSet<String>();
//		set.add("11");
//		Iterator<String> iterator = set.iterator();
//		expect(request2.getFileNames()).andReturn(iterator);
//		
//		MultipartFile file = createMock(MultipartFile.class);
//		expect(request2.getFile((String) anyObject())).andReturn(file);
//		
//		replay(request2);
//		
//		String result = target.importInboundDeliveryPlus(request2);
//		assertNotNull(result);
//	}
//
//}
