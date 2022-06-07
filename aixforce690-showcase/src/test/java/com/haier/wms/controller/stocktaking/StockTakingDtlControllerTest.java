package com.haier.wms.controller.stocktaking;

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
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDtlServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: StockTakingDtlControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午11:54:00
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StockTakingDtlControllerTest {

	private StocktakingDtlServiceClient stocktakingDtlServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private StockTakingDtlController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:55:40  void
	 */
	@Before
	public void init() {
		stocktakingDtlServiceClient = EasyMock.createMock(StocktakingDtlServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		target = new StockTakingDtlController();
		target.setStocktakingDtlServiceClient(stocktakingDtlServiceClient);
		
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
	 * @title: testSelectStocktakingDtlInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午12:00:04  void
	 */
	@Test
	public void testSelectStocktakingDtlInfo() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		String result = target.selectStocktakingDtlInfo(request, new OdsPdInfoDtlDTO());
		Assert.assertNotNull(result);
		verify(request);
	}

	/**
	 * @title: testSelectStocktakingDtlSum
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:47:36  void
	 */
	@Test
	public void testSelectStocktakingDtlSum() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		
		String result = target.selectStocktakingDtlSum(request, new OdsPdInfoDtlDTO());
		assertNotNull(result);
		verify(request);
	}

	/**
	 * @title: testPdQtyDetail
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:47:33  void
	 */
	@Test
	public void testPdQtyDetail() {
		target.pdQtyDetail(11L, 11L, new OdsPdInfoDtlDTO());
		assertTrue(true);
	}

	/**
	 * @title: testSearchPdExportAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:47:30  void
	 */
	@Test
	public void testSearchPdExportAmount() {
		expect(stocktakingDtlServiceClient.getPdExportAmount((OdsPdInfoDtlDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(stocktakingDtlServiceClient);
		
		String result = target.searchPdExportAmount(request, response, new OdsPdInfoDtlDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportExcel
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:48:59  void
	 */
	@Test
	public void testExportExcel() {
		String resu = target.exportExcel(new OdsPdInfoDtlDTO(), request, response);
		assertNull(resu);
	}

	/**
	 * @title: testSearchPdDetailSumAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:49:15  void
	 */
	@Test
	public void testSearchPdDetailSumAmount() {
		expect(stocktakingDtlServiceClient.searchOdsPdInfoDtlsCountBySum((OdsPdInfoDtlDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(stocktakingDtlServiceClient);
		String result = target.searchPdDetailSumAmount(request, response,  new OdsPdInfoDtlDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testExportDetailsSum
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 下午1:52:46  void
	 */
	@Test
	public void testExportDetailsSum() {
		String result = target.exportDetailsSum(new OdsPdInfoDtlDTO(), request, response);
		assertNull(result);
	}

}
