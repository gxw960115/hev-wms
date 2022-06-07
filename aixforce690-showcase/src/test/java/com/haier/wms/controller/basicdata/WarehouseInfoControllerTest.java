package com.haier.wms.controller.basicdata;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: WarehouseInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月5日 下午6:36:37
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value={PageUtil.class,UserUtil.class}) 
public class WarehouseInfoControllerTest {

	private CdWhInfoServiceClient cdWhInfoServiceClient;
	private HttpServletRequest request;
//	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext servletContext;
	
	private WarehouseInfoController target = new WarehouseInfoController();
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午6:41:43  void
	 */
	@Before
	public void init() {
		cdWhInfoServiceClient = createMock(CdWhInfoServiceClient.class);
		request = createMock(HttpServletRequest.class);
		session = createMock(HttpSession.class);
		servletContext = createMock(ServletContext.class);
		target.setCdWhInfoServiceClient(cdWhInfoServiceClient);
		PowerMockito.mockStatic(PageUtil.class,UserUtil.class);
		BaseUser baseUser = new BaseUser();
		baseUser.setId(11L);
		PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
		Pager<Object> pager = new Pager<Object>();
		PowerMockito.when(PageUtil.setPager(pager)).thenReturn(new PageBean());
	}
	
	/**
	 * @title: testSelectWarehouseCboxList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午6:41:37  void
	 */
	@Test
	public void testSelectWarehouseCboxList() {
		expect(cdWhInfoServiceClient.searchWhInfo()).andReturn(new ArrayList<CdWhInfoDTO>());
		replay(cdWhInfoServiceClient);
		target.selectWarehouseCboxList();
		assertTrue(true);
	}

	/**
	 * @title: testSearchAvailableWh
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月5日 下午6:47:46  void
	 */
	@Test
	public void testSearchAvailableWh() {
		List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
		expect(cdWhInfoServiceClient.searchAvailableWh((Long) anyObject())).andReturn(list);
		replay(cdWhInfoServiceClient);
		String result = target.searchAvailableWh();
		assertNotNull(result);
	}

	/**
	 * @title: testSelectPhysicalWhList
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:24:05 
	 * @return: void
	 */
	@Test
	public void testSelectPhysicalWhList() {
		expect(cdWhInfoServiceClient.searchPhysicalWhInfo()).andReturn(new ArrayList<CdWhInfoDTO>());
		replay(cdWhInfoServiceClient);
		target.selectPhysicalWhList();
		assertTrue(true);
	}

	/**
	 * @title: testSearchAvailablePhyWh
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:24:01 
	 * @return: void
	 */
	@Test
	public void testSearchAvailablePhyWh() {
		List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
		expect(cdWhInfoServiceClient.searchAvailablePhyWh((Long) anyObject())).andReturn(list);
		replay(cdWhInfoServiceClient);
		String result = target.searchAvailablePhyWh();
		assertNotNull(result);
	}

	/**
	 * @title: testSearchAvailablePhyWhGap
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:24:47 
	 * @return: void
	 */
	@Test
	public void testSearchAvailablePhyWhGap() {
		List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
		expect(cdWhInfoServiceClient.searchAvailablePhyWhGap((Long) anyObject())).andReturn(list);
		replay(cdWhInfoServiceClient);
		String result = target.searchAvailablePhyWhGap();
		assertNotNull(result);
	}

	/**
	 * @title: testGetAllwhInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:29:50 
	 * @return: void
	 */
	@Test
	public void testGetAllwhInfo() {
		Pager<CdWhInfoDTO> pager = new Pager<CdWhInfoDTO>();
		expect(cdWhInfoServiceClient.searchCdWhInfos((Long) anyObject(), (Long) anyObject(), 
				(CdWhInfoDTO) anyObject())).andReturn(pager);
		replay(cdWhInfoServiceClient);
		String result = target.getAllwhInfo(11L, 11L, new CdWhInfoDTO());
		assertNotNull(result);
	}

//	@Test
//	public void testImportMdMatInfo() {
//		fail("Not yet implemented");
//	}

	/**
	 * @title: testDownload
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午9:43:13 
	 * @return: void
	 */
	@Test
	public void testDownload() {
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		
		replay(request);
		replay(session);
		replay(servletContext);
		try {
			target.download(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
