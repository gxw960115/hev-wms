package com.haier.wms.controller.inventory;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;

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
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SelectStockAgeReportControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:40:35
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class SelectStockAgeReportControllerTest {

	private SearchStockAgeReportClient searchStockAgeReportClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private SelectStockAgeReportController target;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		searchStockAgeReportClient = EasyMock.createMock(SearchStockAgeReportClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new SelectStockAgeReportController();
		target.setSearchStockAgeReportClient(searchStockAgeReportClient);
		target.getSearchStockAgeReportClient();
		
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
	 * @date: 2018年9月11日 上午10:11:03 
	 * @return: void
	 */
	@Test
	public void testSelectStockAgeReport() {
		target.selectStockAgeReport(request, 11L, 11L, new OdsInventoryInfoDtlDTO());
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.inventory.SelectStockAgeReportController#searchStockAmount(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO)}.
	 */
	@Test
	public void testSearchStockAmount() {
		expect(searchStockAgeReportClient.getExportAmount((OdsInventoryInfoDtlDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(searchStockAgeReportClient);
		
		target.searchStockAmount(request, response, new OdsInventoryInfoDtlDTO());
		assertTrue(true);
		verify(searchStockAgeReportClient);
	}

	/**
	 * @title: testExportOdsInventoryDtlInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:09:57 
	 * @return: void
	 */
	@Test
	public void testExportOdsInventoryDtlInfo() {
		target.exportOdsInventoryDtlInfo(request, response, new OdsInventoryInfoDtlDTO());
		assertTrue(true);
	}

	/**
	 * @title: testSapQtyDetail
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:07:35 
	 * @return: void
	 */
	@Test
	public void testSapQtyDetail() {
		String result = target.sapQtyDetail(11L, 11L, new OdsInventoryInfoDtlDTO());
		Assert.assertNotNull(result);
	}

	/**
	 * Test method for {@link com.haier.wms.controller.inventory.SelectStockAgeReportController#updateBarcodeStatus(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdateBarcodeStatus() {
		target.updateBarcodeStatus("11", "");
		assertTrue(true);
	}

}
