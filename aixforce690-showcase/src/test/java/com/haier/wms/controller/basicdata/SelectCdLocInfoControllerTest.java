package com.haier.wms.controller.basicdata;

import static org.junit.Assert.*;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * @Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SelectCdLocInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月5日 下午5:16:38
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class})
public class SelectCdLocInfoControllerTest {

	private SelectCdLocInfoController target;
	private CdLocInfoServiceClient cdLocInfoServiceClient;
	private HttpServletRequest request;
//	private HttpSession session;
//	private ServletContext servletContext;
	/**
	 * @Title: init
	 * @Description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午5:19:19  void
	 */
	@Before
	public void init() {
		request = EasyMock.createMock(HttpServletRequest.class);
		cdLocInfoServiceClient = EasyMock.createMock(CdLocInfoServiceClient.class);
//		session = createMock(HttpSession.class);
//		servletContext = createMock(ServletContext.class);
		
		target = new SelectCdLocInfoController();
		target.setCdLocInfoServiceClient(cdLocInfoServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class,UserUtil.class);
		PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
	}
	/**
	 * Test method for {@link com.haier.wms.controller.basicdata.SelectCdLocInfoController#getAllLocInfo(javax.servlet.http.HttpServletRequest, java.lang.Long, java.lang.Long, com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO)}.
	 */
	@Test
	public void testGetAllLocInfo() {
		CdLocInfoDTO temp = new CdLocInfoDTO();
		Pager<CdLocInfoDTO> pagerTestCase = new Pager<CdLocInfoDTO>();
		expect(cdLocInfoServiceClient.searchCdLocInfoByCondition(11L, 11L, temp)).andReturn(pagerTestCase);
		
		replay(cdLocInfoServiceClient);
		String result = target.getAllLocInfo(request, 11L, 11L, temp);
		assertNotNull(result);
	}

	/**
	 * @title: testImportMdMatInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午5:36:42  void
	 */
//	@Test
//	public void testImportMdMatInfo() {
//		fail("Not yet implemented");
//	}

	/**
	 * @title: testDownload
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午5:37:17 
	 * @throws IOException void
	 */
//	@Test
//	public void testDownload() throws IOException {
//		expect(request.getSession()).andReturn(session);
//		expect(session.getServletContext()).andReturn(servletContext);
//		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
//		
//		replay(request);
//		replay(session);
//		replay(servletContext);
//		target.download(request);
//	}

	/**
	 * @title: testCreateLocInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:56:55 
	 * @return: void
	 */
	@Test
	public void testCreateLocInfo() {
		expect(cdLocInfoServiceClient.createLocInfos((CdLocInfoDTO)anyObject())).andReturn("111");
		replay(cdLocInfoServiceClient);
		target.createLocInfo(new CdLocInfoDTO());
		assertNotNull(true);
	}

	/**
	 * @title: testSelectLocInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:56:50 
	 * @return: void
	 */
	@Test
	public void testSelectLocInfo() {
		Pager<CdLocInfoDTO> pager = new Pager<CdLocInfoDTO>();
		pager.setPageSize(10L);
		pager.setCurrentPage(1L);
		expect(cdLocInfoServiceClient.searchCdLocInfo((Pager<CdLocInfoDTO>)anyObject(),(CdLocInfoDTO)anyObject())).andReturn(pager);
		replay(cdLocInfoServiceClient);
		String result = target.selectLocInfo(request, 11L, 11L, new CdLocInfoDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testDeleteLocInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午6:18:54  void
	 */
	@Test
	public void testDeleteLocInfo() {
		expect(cdLocInfoServiceClient.deleteLocInfo((List<Long>)anyObject())).andReturn("111");
		replay(cdLocInfoServiceClient);
		target.deleteLocInfo("1");
	}

	/**
	 * @title: testUpdateLocInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午6:19:05  void
	 */
	@Test
	public void testUpdateLocInfo() {
		expect(cdLocInfoServiceClient.updateLocInfo((CdLocInfoDTO)anyObject())).andReturn("111");
		replay(cdLocInfoServiceClient);
		target.updateLocInfo(new CdLocInfoDTO());
		assertTrue(true);
	}

	@Test
	public void testSelectPhysicalLoc(){
		CdWhInfoDTO cdWhInfoDTO = new CdWhInfoDTO();
		cdWhInfoDTO.setRowId(10000000000L);
		List<CdLocInfoDTO> list = new ArrayList<CdLocInfoDTO>();
		CdLocInfoDTO cdLocInfoDTO = new CdLocInfoDTO();
		cdLocInfoDTO.setAddress("11111111111");
		cdLocInfoDTO.setCode("11");
		cdLocInfoDTO.setName("111");
		list.add(cdLocInfoDTO);
		expect(cdLocInfoServiceClient.selectPhysicalLoc(cdWhInfoDTO.getRowId())).andReturn(list);
		replay(cdLocInfoServiceClient);
		target.selectPhysicalLoc(request,cdWhInfoDTO);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.basicdata.SelectCdLocInfoController(javax.servlet.http.HttpServletRequest, com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)}.
	 */
	@Test
	public void testSelectLocTree() {
		List<CdLocInfoDTO> temp = new ArrayList<CdLocInfoDTO>();
		temp.add(new CdLocInfoDTO());
		expect(cdLocInfoServiceClient.selectLocTree(11L, "0")).andReturn(temp);
		
		replay(cdLocInfoServiceClient);
		CdWhInfoDTO temp2 = new CdWhInfoDTO();
		temp2.setRowId(11L);
		target.selectLocTree(request, temp2, "0");
	}

	@Test
	public void testSelectLocTreeWithType(){
		expect(cdLocInfoServiceClient.selectLocTreeWithType(
				(CdLocInfoDTO)anyObject())
		).andReturn(new ArrayList<CdLocInfoDTO>());
		replay(cdLocInfoServiceClient);
		target.selectLocTreeWithType(request,new CdLocInfoDTO());
	}

	@Test
	public void testSelectLocTreeWithLocation(){
		expect(cdLocInfoServiceClient.selectLocTreeWithLocation(
				(CdLocInfoDTO)anyObject())
		).andReturn(new ArrayList<CdLocInfoDTO>());
		replay(cdLocInfoServiceClient);
		target.selectLocTreeWithLocation(request,new CdLocInfoDTO());
	}

	/**
	 * Test method for {@link com.haier.wms.controller.basicdata.SelectCdLocInfoController#cdLocTree(javax.servlet.http.HttpServletRequest, com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)}.
	 */
	@Test
	public void testCdLocTree() {
		List<CdLocInfoDTO> temp = new ArrayList<CdLocInfoDTO>();
		CdLocInfoDTO dteTestCase = new CdLocInfoDTO();
		dteTestCase.setRowId(11L);
		temp.add(dteTestCase);
		expect(cdLocInfoServiceClient.getCdLocInfosByParentId(11L)).andReturn(temp);
		
		replay(cdLocInfoServiceClient);
		CdWhInfoDTO dto = new CdWhInfoDTO();
		dto.setRowId(11L);
		String result = target.cdLocTree(request, dto);
		assertNotNull(result);
	}

	/**
	 * @title: testCdLocTreeByParentId
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:53:52 
	 * @return: void
	 */
	@Test
	public void testCdLocTreeByParentId() {
		expect(request.getParameter((String) anyObject())).andReturn("11");
		replay(request);
		CdLocInfoDTO temp = new CdLocInfoDTO();
		temp.setLocationType("11");
		String result = target.cdLocTreeByParentId(request, temp);
		assertNotNull(result);
	}

	@Test
	public void testGetLocationList(){
		expect(cdLocInfoServiceClient.getCdLocInfoManyColumn(
				(CdLocInfoDTO)anyObject())
		).andReturn(new ArrayList<CdLocInfoDTO>());
		replay(cdLocInfoServiceClient);
		target.getLocationList(new CdLocInfoDTO());
	}

}
