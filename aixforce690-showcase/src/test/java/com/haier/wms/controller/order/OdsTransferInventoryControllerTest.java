package com.haier.wms.controller.order;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.order.service.TransferInventoryServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: OdsTransferInventoryControllerTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月10日 上午10:52:06
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月10日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsTransferInventoryControllerTest {

	private HttpServletRequest request;
	private HttpServletResponse response;
	public TransferInventoryServiceClient transferInventoryServiceClient;
	private OdsTransferInventoryController target;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void initialization() {
		transferInventoryServiceClient = createMock(TransferInventoryServiceClient.class);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		target = new OdsTransferInventoryController();
		target.setTransferInventoryServiceClient(transferInventoryServiceClient);
		
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
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchTransInventoryOrder() {
		expect(request.getParameter((String) anyObject())).andReturn("11").times(2);
		replay(request);
		String resultString = target.searchTransInventoryOrder(request, new OdsTransferInventoryDTO());
		assertNotNull(resultString);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchTransInventoryOrderAmount() {
		expect(transferInventoryServiceClient.getExportAmount((OdsTransferInventoryDTO) anyObject())).andReturn(25001L);
		replay(transferInventoryServiceClient);
		String result = target.searchTransInventoryOrderAmount(request, response, new OdsTransferInventoryDTO());
		assertNotNull(result);
	}

}
