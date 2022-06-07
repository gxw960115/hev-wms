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
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDiffServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: StockTakingDiffControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午11:48:33
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StockTakingDiffControllerTest {

	private StocktakingDiffServiceClient stocktakingDiffServiceClient;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private StockTakingDiffController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:51:10  void
	 */
	@Before
	public void init() {
		stocktakingDiffServiceClient = EasyMock.createMock(StocktakingDiffServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		target = new StockTakingDiffController();
		target.setStocktakingDiffServiceClient(stocktakingDiffServiceClient);
		
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
	 * @title: testSelectStocktakingDiffInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 下午12:11:25 
	 * @return: void
	 */
	@Test
	public void testSelectStocktakingDiffInfo() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		String result = target.selectStocktakingDiffInfo(request, new OdsPdDiffDtlDTO());
		Assert.assertNotNull(result);
		verify(request);
	}

	/**
	 * @title: testSearchStockTakingDiffAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:53:14  void
	 */
	@Test
	public void testSearchStockTakingDiffAmount() {
		expect(stocktakingDiffServiceClient.searchOdsPdDiffDtlsCount((OdsPdDiffDtlDTO) EasyMock.anyObject())).andReturn(25001L);
		replay(stocktakingDiffServiceClient);
		target.searchStockTakingDiffAmount(request, response, new OdsPdDiffDtlDTO());
	}

	/**
	 * @title: testExportExcel
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午11:53:16  void
	 */
	@Test
	public void testExportExcel() {
		target.exportExcel(new OdsPdDiffDtlDTO(), response);
	}

}
