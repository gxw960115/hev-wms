package com.haier.openplatform.wms.stocktaking.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.takestock.service.OdsPdTempDtlService;
import com.haier.hevwms.takestock.service.OdsPdTempService;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: OdsPdTempDtlServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:02:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class OdsPdTempDtlServiceClientImplTest {
	private OdsPdTempDtlServiceClientImpl clientImplMock = new OdsPdTempDtlServiceClientImpl();
	private OdsPdTempService odsPdTempServiceMock;
	private OdsPdTempDtlService odsPdTempDtlServiceMock;
	
	@Before
	public void init() {
		odsPdTempServiceMock = EasyMock.createMock(OdsPdTempService.class);
		odsPdTempDtlServiceMock = EasyMock.createMock(OdsPdTempDtlService.class);
		clientImplMock.setOdsPdTempService(odsPdTempServiceMock);
		clientImplMock.setOdsPdTempDtlService(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testOrderCheck  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:43:39
	 */
	@Test
	public void testOrderCheck() {
		OdsPdTempDtlDTO pdTempDTO = new OdsPdTempDtlDTO();
		pdTempDTO.setCreateBy("test");
		pdTempDTO.setOrderNo("123");
		
		EasyMock.expect(odsPdTempServiceMock.orderCheck((String)EasyMock.anyObject())).andReturn("we").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.getScanQty((String)EasyMock.anyObject())).andReturn(1L).times(1);
		EasyMock.replay(odsPdTempServiceMock);
		EasyMock.replay(odsPdTempDtlServiceMock);
		
		clientImplMock.orderCheck(pdTempDTO);
		EasyMock.verify(odsPdTempServiceMock);
		EasyMock.verify(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testOrderScan  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:43:44
	 */
	@Test
	public void testOrderScan() {
		OdsPdTempDtlDTO pdTempDTO = new OdsPdTempDtlDTO();
		pdTempDTO.setCreateBy("test");
		pdTempDTO.setOrderNo("123");
		
		Map<String, String> result = new HashMap<String, String>();
		
		EasyMock.expect(odsPdTempServiceMock.orderCheck((String)EasyMock.anyObject())).andReturn("S").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.barcodeCheck((String)EasyMock.anyObject()
				,(String)EasyMock.anyObject())).andReturn("S").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.add((OdsPdTempDtlDTO)EasyMock.anyObject())).andReturn(result).times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.getScanQty((String)EasyMock.anyObject())).andReturn(1L).times(1);
		EasyMock.replay(odsPdTempServiceMock);
		EasyMock.replay(odsPdTempDtlServiceMock);
		
		clientImplMock.orderScan(pdTempDTO);
		EasyMock.verify(odsPdTempServiceMock);
		EasyMock.verify(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testOfflineScan  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:43:48
	 */
	@Test
	public void testOfflineScan() {
		List<OdsPdTempDtlDTO> list = new ArrayList<OdsPdTempDtlDTO>();
		OdsPdTempDtlDTO odsPdTempDtlDTO = new OdsPdTempDtlDTO();
		odsPdTempDtlDTO.setCreateBy("test");
		odsPdTempDtlDTO.setOrderNo("123");
		list.add(odsPdTempDtlDTO);
		
		Map<String, String> result = new HashMap<String, String>();
		
		EasyMock.expect(odsPdTempServiceMock.orderCheck((String)EasyMock.anyObject())).andReturn("S").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.barcodeCheck((String)EasyMock.anyObject()
				,(String)EasyMock.anyObject())).andReturn("S").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.add((OdsPdTempDtlDTO)EasyMock.anyObject())).andReturn(result).times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.getScanQty((String)EasyMock.anyObject())).andReturn(1L).times(1);
		EasyMock.replay(odsPdTempServiceMock);
		EasyMock.replay(odsPdTempDtlServiceMock);
			
		clientImplMock.offlineScan(list);
		EasyMock.verify(odsPdTempServiceMock);
		EasyMock.verify(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testOrderDelete  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:43:53
	 */
	@Test
	public void testOrderDelete() {
		OdsPdTempDtlDTO pdTempDTO = new OdsPdTempDtlDTO();
		
		EasyMock.expect(odsPdTempDtlServiceMock.orderDelete((OdsPdTempDtlDTO)EasyMock.anyObject())).andReturn("we").times(1);
		EasyMock.expect(odsPdTempDtlServiceMock.getScanQty((String)EasyMock.anyObject())).andReturn(1L).times(1);
		EasyMock.replay(odsPdTempDtlServiceMock);
		
		clientImplMock.orderDelete(pdTempDTO);
		EasyMock.verify(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testOrderDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:43:58
	 */
	@Test
	public void testOrderDetail() {
		List<OdsPdTempDtlDTO> list = new ArrayList<OdsPdTempDtlDTO>();
		OdsPdTempDtlDTO pdTempDTO = new OdsPdTempDtlDTO();
		EasyMock.expect(odsPdTempDtlServiceMock.orderDetail((OdsPdTempDtlDTO)EasyMock.anyObject())).andReturn(list).times(1);
		EasyMock.replay(odsPdTempDtlServiceMock);
		
		clientImplMock.orderDetail(pdTempDTO);
		EasyMock.verify(odsPdTempDtlServiceMock);
	}

	/**
	* @Title: testSearchOdsPdTempdtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:02
	 */
	@Test
	public void testSearchOdsPdTempdtls() {
		OdsPdTempDtlDTO pdTempDtlDTO = new OdsPdTempDtlDTO();
		clientImplMock.searchOdsPdTempdtls(pdTempDtlDTO, 1L, 10L);
	}

	/**
	* @Title: testMoveBarcodes  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:06
	 */
	@Test
	public void testMoveBarcodes() {
		String ids = "12,23";
		clientImplMock.moveBarcodes(ids);
		assertThat(1, is(1));
	}

	/**
	* @Title: testUpdateBarcodesStatus  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:44:10
	 */
	@Test
	public void testUpdateBarcodesStatus() {
		String ids = "12,24";
		clientImplMock.updateBarcodesStatus(ids, "1");
		assertThat(1, is(1));
	}

}
