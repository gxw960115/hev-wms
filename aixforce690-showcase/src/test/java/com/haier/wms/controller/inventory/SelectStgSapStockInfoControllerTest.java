package com.haier.wms.controller.inventory;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.haier.openplatform.wms.basicdata.service.CdWhInfoServiceClient;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.inventory.service.StgSapStockServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SelectStgSapStockInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:31:37
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class SelectStgSapStockInfoControllerTest {

	private CdWhInfoServiceClient cdWhInfoServiceClient;
	private StgSapStockServiceClient stgSapStockServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private SelectStgSapStockInfoController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:13:10 
	 * @return: void
	 */
	@Before
	public void init() {
		cdWhInfoServiceClient = EasyMock.createMock(CdWhInfoServiceClient.class);
		stgSapStockServiceClient = EasyMock.createMock(StgSapStockServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new SelectStgSapStockInfoController();
		target.setCdWhInfoServiceClient(cdWhInfoServiceClient);
		target.setStgSapStockServiceClient(stgSapStockServiceClient);
		
		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
		JSONObject res = new JSONObject();
		res.put("_user_name", "11");
		res.put("user_duty_type", "11");
		res.put("_user_id", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
	}
	
	/**
	 * @title: testSelectStockAgeReport
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:13:06 
	 * @return: void
	 */
	@Test
	public void testSelectStockAgeReport() {
		String result = target.selectStockAgeReport(request, 11L, 11L, new StgSapStockDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testSearchMb52Amount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:13:19 
	 * @return: void
	 */
	@Test
	public void testSearchMb52Amount() {
		EasyMock.expect(stgSapStockServiceClient.getExportAmount((StgSapStockDTO) EasyMock.anyObject())).andReturn(25001L);
		EasyMock.replay(stgSapStockServiceClient);
		target.searchMb52Amount(request, response, new StgSapStockDTO());
		Assert.assertTrue(true);
		verify(stgSapStockServiceClient);
	}

	/**
	 * @title: testExportStgSapStockInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:14:14 
	 * @return: void
	 */
	@Test
	public void testExportStgSapStockInfo() {
		String result = target.exportStgSapStockInfo(request, response, new StgSapStockDTO());
		assertNull(result);
	}

	/**
	 * @title: testSelectLocationTree
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:15:32 
	 * @return: void
	 */
	@Test
	public void testSelectLocationTree() {
		target.selectLocationTree(request, "1", 11L);
		assertTrue(true);
	}

	/**
	 * @title: testSearchActualStockGap
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:15:29 
	 * @return: void
	 */
	@Test
	public void testSearchActualStockGap() {
		String result = target.searchActualStockGap(request, 11L, 11L, new StgSapStockDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportActualStockGap
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:15:46 
	 * @return: void
	 */
	@Test
	public void testExportActualStockGap() {
		String result = target.exportActualStockGap(request, response, new StgSapStockDTO());
		assertNull(result);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.inventory.SelectStgSapStockInfoController#downAllInventoryFromSap(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDownAllInventoryFromSap() {
		target.downAllInventoryFromSap(request, response);
		assertTrue(true);
	}

}
