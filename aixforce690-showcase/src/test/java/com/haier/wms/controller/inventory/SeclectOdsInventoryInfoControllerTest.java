package com.haier.wms.controller.inventory;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.service.InventoryInfoServiceClient;
import com.haier.openplatform.wms.security.service.PlantServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

import java.util.ArrayList;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SeclectOdsInventoryInfoControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:00:54
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class SeclectOdsInventoryInfoControllerTest {

	private PlantServiceClient plantServiceClient;
	private InventoryInfoServiceClient seleceInventoryInfoService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private SeclectOdsInventoryInfoController target;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午9:03:16  void
	 */
	@Before
	public void init(){
		plantServiceClient = EasyMock.createMock(PlantServiceClient.class);
		seleceInventoryInfoService = EasyMock.createMock(InventoryInfoServiceClient.class);
		request = EasyMock.createMock(HttpServletRequest.class);
		response = EasyMock.createMock(HttpServletResponse.class);
		
		
		target = new SeclectOdsInventoryInfoController();
		target.setPlantServiceClient(plantServiceClient);
		target.setSeleceInventoryInfoService(seleceInventoryInfoService);
		target.getPlantServiceClient();
		target.getSeleceInventoryInfoService();
		
		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
		JSONObject res = new JSONObject();
		res.put("_user_name", "11");
		res.put("user_duty_type", "11");
		res.put("_user_id", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
	}

	/**
	 * @title: testSelectOdsInventory
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:28:11 
	 * @return: void
	 */
	@Test
	public void testSelectOdsInventory() {
		EasyMock.expect(seleceInventoryInfoService.searchOdsInventoryInfo(
				(Pager<OdsInventoryInfoDTO>)EasyMock.anyObject(),
				(OdsInventoryInfoDTO)EasyMock.anyObject())
		).andReturn(new Pager<OdsInventoryInfoDTO>());
		EasyMock.replay(seleceInventoryInfoService);
		String result = target.selectOdsInventory(request, 11L, 11L, new OdsInventoryInfoDTO());
		assertNotNull(result);
	}

	/**
	 * @title: testWmsQtyDetail
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午9:11:03  void
	 */
	@Test
	public void testWmsQtyDetail() {
		Pager<OdsInventoryInfoDTO> testCase = new Pager<OdsInventoryInfoDTO>();
		expect(seleceInventoryInfoService.wmsQtyDetail((Pager<OdsInventoryInfoDTO>) anyObject(), (OdsInventoryInfoDTO) anyObject()))
			.andReturn(testCase);
		
		replay(seleceInventoryInfoService);
		target.wmsQtyDetail(request, 11L, 11L, new OdsInventoryInfoDTO());
		assertTrue(true);
	}

	/**
	 * @title: testSearchInventoryAmount
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午9:14:23  void
	 */
	@Test
	public void testSearchInventoryAmount() {
		expect(seleceInventoryInfoService.getExportAmount((OdsInventoryInfoDTO) anyObject())).andReturn(25001L);
		replay(seleceInventoryInfoService);
		String result = target.searchInventoryAmount(request, response, new OdsInventoryInfoDTO());
		assertNotNull(result);
		verify(seleceInventoryInfoService);
	}

	/**
	 * @title: testExportOdsInventoryInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:28:52 
	 * @return: void
	 */
	@Test
	public void testExportOdsInventoryInfo() {
		OdsInventoryInfoDtlDTO odsInventoryInfoDTO = new OdsInventoryInfoDtlDTO();
		EasyMock.expect(seleceInventoryInfoService.searchOdsInventoryBinList(
				1L,25000L,odsInventoryInfoDTO)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>());
		EasyMock.replay(seleceInventoryInfoService);
		String result = target.exportOdsInventoryInfo(request, response, odsInventoryInfoDTO);
		assertNull(result);
	}

	/**
	 * @title: testSearchFactory
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月6日 上午9:15:52  void
	 */
	@Test
	public void testSearchFactory() {
		EasyMock.expect(plantServiceClient.searchAll()).andReturn(new ArrayList<CdFactoryDTO>());
		EasyMock.replay(plantServiceClient);
		target.searchFactory(request);
		assertTrue(true);
	}

}
