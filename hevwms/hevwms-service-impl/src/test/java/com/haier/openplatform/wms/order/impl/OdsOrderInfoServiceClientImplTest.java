package com.haier.openplatform.wms.order.impl;

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

import com.haier.hevwms.order.service.OdsOrderInfoService;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称OdsOrderInfoServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsOrderInfoServiceClientImplTest {
	private OdsOrderInfoServiceClientImpl clientImplMock = new OdsOrderInfoServiceClientImpl();
	private OdsOrderInfoService odsOrderInfoServiceMock;
	
	/**
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:55
	 */
	@Before
	public void init() {
		odsOrderInfoServiceMock = EasyMock.createMock(OdsOrderInfoService.class);
		clientImplMock.setOdsOrderInfoService(odsOrderInfoServiceMock);
	}

	/**
	* @Title: testSearchOdsOrderInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:59
	 */
	@Test
	public void testSearchOdsOrderInfo() {
		clientImplMock.searchOdsOrderInfo(new Pager<OdsOrderInfoDTO>(), new OdsOrderInfoDTO());
	}

	/**
	* @Title: testCreateOdsOrderInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:02
	 */
	@Test
	public void testCreateOdsOrderInfo() {
		clientImplMock.createOdsOrderInfo(new OdsOrderInfoDTO());
	}

	/**
	* @Title: testDeleteOdsOrderInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:05
	 */
	@Test
	public void testDeleteOdsOrderInfo() {
		clientImplMock.deleteOdsOrderInfo("");
	}

	/**
	* @Title: testSearchOdsOrderInfoDTOs  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:14
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchOdsOrderInfoDTOs() {
		EasyMock.expect(odsOrderInfoServiceMock.searchOdsOrderInfos((Pager<OdsOrderInfoDTO>)EasyMock.anyObject()
				,(OdsOrderInfoDTO)EasyMock.anyObject())).andReturn(new Pager<OdsOrderInfoDTO>()).times(1);
		EasyMock.replay(odsOrderInfoServiceMock);
		clientImplMock.searchOdsOrderInfoDTOs(1L, 10L, new OdsOrderInfoDTO());
		EasyMock.verify(odsOrderInfoServiceMock);
	}

	/**
	* @Title: testSearchOrderNos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:18
	 */
	@Test
	public void testSearchOrderNos() {
		clientImplMock.searchOrderNos(new Pager<OdsOrderInfoDTO>() , new OdsOrderInfoDTO());
	}

	/**
	* @Title: testGetOdsOrderInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:22
	 */
	@Test
	public void testGetOdsOrderInfos() {
		clientImplMock.getOdsOrderInfos(new OdsOrderInfoDTO());
	}

	/**
	* @Title: testSearchStoDNDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:25
	 */
	@Test
	public void testSearchStoDNDetail() {
		clientImplMock.searchStoDNDetail(new Pager<OdsOrderInfoDTO>() , new OdsOrderInfoDTO());
	}

	/**
	* @Title: testSearchOgpDetailsByStodnNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:29
	 */
	@Test
	public void testSearchOgpDetailsByStodnNo() {
		clientImplMock.searchOgpDetailsByStodnNo(new Pager<OdsOrderInfoDtlDTO>(), new OdsOrderInfoDtlDTO());
	}

	/**
	* @Title: testSearchOgpDetailsByStodnNoList  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:33
	 */
	@Test
	public void testSearchOgpDetailsByStodnNoList() {
		clientImplMock.searchOgpDetailsByStodnNoList(new OdsOrderInfoDtlDTO());
	}

	/**
	* @Title: testSaveOdsInfoDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:36
	 */
	@Test
	public void testSaveOdsInfoDtls() {
		clientImplMock.saveOdsInfoDtls("");
	}

	/**
	* @Title: testSavePreScan  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:40
	 */
	@Test
	public void testSavePreScan() {
		clientImplMock.savePreScan("", "");
	}

	/**
	* @Title: testDeleteOdsOrderInfoDtlByNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:43
	 */
	@Test
	public void testDeleteOdsOrderInfoDtlByNo() {
		clientImplMock.deleteOdsOrderInfoDtlByNo("");
	}

	/**
	* @Title: testUpdateFinishQty  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:47
	 */
	@Test
	public void testUpdateFinishQty() {
		clientImplMock.updateFinishQty("");
	}

	/**
	* @Title: testGetListByParams  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:51
	 */
	@Test
	public void testGetListByParams() {
		clientImplMock.getListByParams(new OdsOrderInfoDTO());
	}

	/**
	* @Title: testPostOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:54
	 */
	@Test
	public void testPostOrder() {
		try {
			clientImplMock.postOrder("", "");
		}catch(Exception e) {
			
		}
		

	}

	/**
	* @Title: testGetOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:48:59
	 */
	@Test
	public void testGetOrderNo() {
		clientImplMock.getOrderNo("");
	}

	/**
	* @Title: testInOutWarehouse  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:49:02
	 */
	@Test
	public void testInOutWarehouse() {
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		clientImplMock.inOutWarehouse("", "");
	}

	/**
	* @Title: testIogpCancel  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:49:32
	 */
	@Test
	public void testIogpCancel() {
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		EasyMock.expect(odsOrderInfoServiceMock.iogpCancel((OdsOrderInfoDTO)EasyMock.anyObject())).andReturn(out).times(1);
		EasyMock.replay(odsOrderInfoServiceMock);
		
		clientImplMock.iogpCancel(new OdsOrderInfoDTO());
	}

	/**
	* @Title: testSearchOIGPOrderInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:49:48
	 */
	@Test
	public void testSearchOIGPOrderInfo() {
		clientImplMock.searchOIGPOrderInfo(new Pager<OdsOrderInfoDTO>(), new OdsOrderInfoDTO());
	}

	/**
	* @Title: testGetExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:49:52
	 */
	@Test
	public void testGetExportAmount() {
		clientImplMock.getExportAmount(new OdsOrderInfoDTO());
	}

}
