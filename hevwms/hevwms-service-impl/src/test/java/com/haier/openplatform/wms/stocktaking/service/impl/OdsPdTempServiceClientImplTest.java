package com.haier.openplatform.wms.stocktaking.service.impl;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.hevwms.takestock.service.OdsPdTempService;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称OdsPdTempServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsPdTempServiceClientImplTest {
	private OdsPdTempServiceClientImpl clientImplMock = new OdsPdTempServiceClientImpl();
	private OdsPdTempService odsPdTempServiceMock;
	private OdsPdInfoService odsPdInfoServiceMock;
	
	@Before
	public void init() {
		odsPdTempServiceMock = EasyMock.createMock(OdsPdTempService.class);
		odsPdInfoServiceMock = EasyMock.createMock(OdsPdInfoService.class);
		clientImplMock.setPdTempService(odsPdTempServiceMock);
		clientImplMock.setOdsPdInfoService(odsPdInfoServiceMock);
	}
	
	/**
	* @Title: testAddPdTempOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:19
	 */
	@Test
	public void testAddPdTempOrder() {
		OdsPdTempDTO pdTempDTO = new OdsPdTempDTO();
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		EasyMock.expect(odsPdTempServiceMock.addPdTempOrder((OdsPdTempDTO)EasyMock.anyObject())).andReturn("we").times(1);
		EasyMock.replay(odsPdTempServiceMock);
		
		clientImplMock.addPdTempOrder(pdTempDTO);
		EasyMock.verify(odsPdTempServiceMock);
	}

	/**
	* @Title: testUpdateOrderStatus  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:27
	 */
	@Test
	public void testUpdateOrderStatus() {
		OdsPdTempDTO pdTempDTO = new OdsPdTempDTO();
		clientImplMock.updateOrderStatus(pdTempDTO);
	}

	/**
	* @Title: testUpdateStatus  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:31
	 */
	@Test
	public void testUpdateStatus() {
		clientImplMock.updateStatus("12","12");
	}

	/**
	* @Title: testSearchOdsPdTemps  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:35
	 */
	@Test
	public void testSearchOdsPdTemps() {
		OdsPdTempDTO pdTempDTO=new OdsPdTempDTO();
		clientImplMock.searchOdsPdTemps(pdTempDTO, 1L, 10L);
	}

	/**
	* @Title: testGetTempPdOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:39
	 */
	@Test
	public void testGetTempPdOrderNo() {
		EasyMock.expect(odsPdInfoServiceMock.selectStocktakingOrderNo()).andReturn("we").times(1);
		EasyMock.replay(odsPdInfoServiceMock);
		
		clientImplMock.getTempPdOrderNo();
	}
}
