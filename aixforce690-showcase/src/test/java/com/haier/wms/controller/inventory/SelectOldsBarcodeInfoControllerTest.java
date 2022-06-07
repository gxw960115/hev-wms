package com.haier.wms.controller.inventory;

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
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;
import com.haier.openplatform.wms.inventory.service.SearchOldsBarcodeInfoClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SelectOldsBarcodeInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:20:57
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class SelectOldsBarcodeInfoControllerTest {

	private SearchOldsBarcodeInfoClient searchOldsBarcodeInfoClient;
	
	private SelectOldsBarcodeInfoController target;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		searchOldsBarcodeInfoClient = EasyMock.createMock(SearchOldsBarcodeInfoClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new SelectOldsBarcodeInfoController();
		target.setSearchOldsBarcodeInfoClient(searchOldsBarcodeInfoClient);
		
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
	 * @date: 2018年9月11日 上午10:19:04 
	 * @return: void
	 */
	@Test
	public void testSelectStockAgeReport() {
		target.selectStockAgeReport(request, 11L, 11L, new OdsBarcodeHistoryDTO());
		Assert.assertTrue(true);
	}

	/**
	 * @title: testSearchInventoryAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:17:33 
	 * @return: void
	 */
	@Test
	public void testSearchInventoryAmount() {
		EasyMock.expect(searchOldsBarcodeInfoClient.getExportAmount((OdsBarcodeHistoryDTO) EasyMock.anyObject())).andReturn(25001L);
		EasyMock.replay(searchOldsBarcodeInfoClient);
		target.searchInventoryAmount(request, response, new OdsBarcodeHistoryDTO());
		Assert.assertTrue(true);
	}

	/**
	 * @title: testExportOdsBarcodeInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:17:26 
	 * @return: void
	 */
	@Test
	public void testExportOdsBarcodeInfo() {
		target.exportOdsBarcodeInfo(request, response, new OdsBarcodeHistoryDTO());
		Assert.assertTrue(true);
	}

}
