package com.haier.openplatform.wms.order.impl;

import static org.easymock.EasyMock.expectLastCall;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.hevwms.order.domain.OdsWmsOrder;
import com.haier.hevwms.order.service.OdsWmsOrderService;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称OdsWmsOrderServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class OdsWmsOrderServiceClientImplTest {
	private OdsWmsOrderServiceClientImpl clientImplMock = new OdsWmsOrderServiceClientImpl();
	private OdsWmsOrderService odsWmsOrderServiceMock;
	private OdsOrderInfoDtlService odsOrderInfoDtlServiceMock;
	private OdsInventoryInfoDtlService odsInventoryInfoDtlServiceMock;
	
	/**
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:05
	 */
	@Before
	public void init() {
		odsWmsOrderServiceMock = EasyMock.createMock(OdsWmsOrderService.class);
		odsOrderInfoDtlServiceMock = EasyMock.createMock(OdsOrderInfoDtlService.class);
		odsInventoryInfoDtlServiceMock = EasyMock.createMock(OdsInventoryInfoDtlService.class);
		clientImplMock.setOdsInventoryInfoDtlService(odsInventoryInfoDtlServiceMock);
		clientImplMock.setOdsWmsOrderService(odsWmsOrderServiceMock);
		clientImplMock.setOrderInfoDtlService(odsOrderInfoDtlServiceMock);
	}

	/**
	* @Title: testSearchOdsWmsOrders  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:08
	 */
	@Test
	public void testSearchOdsWmsOrders() {
		clientImplMock.searchOdsWmsOrders(new Pager<OdsWmsOrderDTO>(), new OdsWmsOrderDTO());
	}

	/**
	* @Title: testCreateOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:13
	 */
	@Test
	public void testCreateOdsWmsOrder() {
		clientImplMock.createOdsWmsOrder(new OdsWmsOrderDTO());
	}

	/**
	* @Title: testUpdateOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:17
	 */
	@Test
	public void testUpdateOdsWmsOrder() {
		clientImplMock.updateOdsWmsOrder(new OdsWmsOrderDTO());
	}

	/**
	* @Title: testDeleteOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:20
	 */
	@Test
	public void testDeleteOdsWmsOrder() {
		clientImplMock.deleteOdsWmsOrder(1L);
	}

	/**
	* @Title: testDeleteOdsWmsOrderAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:23
	 */
	@Test
	public void testDeleteOdsWmsOrderAll() {
		clientImplMock.deleteOdsWmsOrderAll(new ArrayList<Long>());
	}

	/**
	* @Title: testGetOdsWmsOrderById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:27
	 */
	@Test
	public void testGetOdsWmsOrderById() {
		EasyMock.expect(odsWmsOrderServiceMock.getOdsWmsOrderById((Long)EasyMock.anyObject()))
			.andReturn(new OdsWmsOrderDTO()).times(1);
		EasyMock.replay(odsWmsOrderServiceMock);

		clientImplMock.getOdsWmsOrderById(1L);
		EasyMock.verify(odsWmsOrderServiceMock);

	}

	/**
	* @Title: testGetOdsWmsOrders  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:31
	 */
	@Test
	public void testGetOdsWmsOrders() {
		clientImplMock.getOdsWmsOrders();
	}

	/**
	* @Title: testDeltGfOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:34
	 */
	@Test
	public void testDeltGfOrder() {
		List<OdsOrderInfoDtlDTO> list= new ArrayList<OdsOrderInfoDtlDTO>();
		list.add(new OdsOrderInfoDtlDTO());
		EasyMock.expect(odsOrderInfoDtlServiceMock.getOdsOrderInfoDtls((OdsOrderInfoDtlDTO)EasyMock.anyObject()))
			.andReturn(list).times(1);
		EasyMock.replay(odsOrderInfoDtlServiceMock);
		
		clientImplMock.deltGfOrder(new OdsWmsOrderDTO());
		EasyMock.verify(odsOrderInfoDtlServiceMock);
	}

	/**
	* @Title: testSaveScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:39
	 */
	@Test
	public void testSaveScrapOrder() {
		String ids = "we,are";
		OdsWmsOrderDTO odsWmsOrderDTO = new OdsWmsOrderDTO();
		List<OdsInventoryInfoDtl> list = new ArrayList<OdsInventoryInfoDtl>();
		list.add(new OdsInventoryInfoDtl());
		
		odsInventoryInfoDtlServiceMock.updateUseQty((String[])EasyMock.anyObject());
		expectLastCall().times(1);
		EasyMock.expect(odsInventoryInfoDtlServiceMock.getListByids((String[])EasyMock.anyObject()))
			.andReturn(list).times(1);
		odsOrderInfoDtlServiceMock.save((OdsOrderInfoDtlDTO)EasyMock.anyObject());
		expectLastCall().times(1);
//		odsWmsOrderServiceMock.save((OdsOrderInfoDtlDTO)EasyMock.anyObject());
//		expectLastCall().times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		EasyMock.replay(odsOrderInfoDtlServiceMock);
		
		clientImplMock.saveScrapOrder(odsWmsOrderDTO, ids);
		EasyMock.verify(odsInventoryInfoDtlServiceMock);
		EasyMock.verify(odsOrderInfoDtlServiceMock);
	}

	/**
	* @Title: testUpdateScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:43
	 */
	@Test
	public void testUpdateScrapOrder() {
		clientImplMock.updateScrapOrder(new OdsWmsOrderDTO());
	}

	/**
	* @Title: testDeleteScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:47
	 */
	@Test
	public void testDeleteScrapOrder() {
		odsInventoryInfoDtlServiceMock.updateUseQtyByOrderNo((OdsWmsOrder)EasyMock.anyObject());
		expectLastCall().times(1);
		EasyMock.expect(odsWmsOrderServiceMock.updateOdsWmsOrder((OdsWmsOrderDTO)EasyMock.anyObject()))
			.andReturn(new ExecuteResult<OdsWmsOrderDTO>()).times(1);
		odsWmsOrderServiceMock.updateScrapDtl((OdsWmsOrderDTO)EasyMock.anyObject());
		expectLastCall().times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		EasyMock.replay(odsWmsOrderServiceMock);
		
		clientImplMock.deleteScrapOrder(new OdsWmsOrderDTO());
		EasyMock.verify(odsInventoryInfoDtlServiceMock);
		EasyMock.verify(odsWmsOrderServiceMock);
	}

	/**
	* @Title: testGetOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:51
	 */
	@Test
	public void testGetOdsWmsOrder() {
		clientImplMock.getOdsWmsOrder(new OdsWmsOrderDTO());
	}

	/**
	* @Title: testSearchScrapBarcodeDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:54
	 */
	@Test
	public void testSearchScrapBarcodeDtl() {
		clientImplMock.searchScrapBarcodeDtl(new Pager<OdsInventoryInfoDtlDTO>(), new OdsInventoryInfoDtlDTO());
	}

	/**
	* @Title: testGetOrderInfoDtlService  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:50:58
	 */
	@Test
	public void testGetOrderInfoDtlService() {
		clientImplMock.getOrderInfoDtlService();
	}

	/**
	* @Title: testGetOdsInventoryInfoDtlService  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:01
	 */
	@Test
	public void testGetOdsInventoryInfoDtlService() {
		clientImplMock.getOdsInventoryInfoDtlService();
	}
	
	/**
	* @Title: testGetOdsWmsOrderService  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:05
	 */
	@Test
	public void testGetOdsWmsOrderService() {
		clientImplMock.getOdsWmsOrderService();
	}
}
