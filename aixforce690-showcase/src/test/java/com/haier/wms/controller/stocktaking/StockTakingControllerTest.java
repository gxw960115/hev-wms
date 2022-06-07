package com.haier.wms.controller.stocktaking;

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
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: StockTakingControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午11:42:16
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StockTakingControllerTest {

	private StocktakingServiceClient stocktakingServiceClient;
	private StockTakingController target;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:43:12  void
	 */
	@Before
	public void init() {
		stocktakingServiceClient = EasyMock.createMock(StocktakingServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		target = new StockTakingController();
		target.setStocktakingServiceClient(stocktakingServiceClient);
		
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
	 * @title: testSelectStocktakingOrder
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 下午12:09:48 
	 * @return: void
	 */
	@Test
	public void testSelectStocktakingOrder() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		String result = target.selectStocktakingOrder(request, new OdsPdInfoDTO());
		Assert.assertNotNull(result);
		verify(request);
	}

	/**
	 * @title: testSearchStockAuditAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:46:35  void
	 */
	@Test
	public void testSearchStockAuditAmount() {
		expect(stocktakingServiceClient.searchOdsPdInfosCount((OdsPdInfoDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(stocktakingServiceClient);
		
		target.searchStockAuditAmount(request, response, new OdsPdInfoDTO());
		Assert.assertTrue(true);
	}

	/**
	 * @title: testExportExcel
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:47:49  void
	 */
	@Test
	public void testExportExcel() {
		String result = target.exportExcel(new OdsPdInfoDTO(), request, response);
		Assert.assertNull(result);
	}

}
