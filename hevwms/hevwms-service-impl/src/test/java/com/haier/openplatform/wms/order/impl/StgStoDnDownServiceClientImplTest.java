package com.haier.openplatform.wms.order.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.haier.openplatform.wms.sto.impl.StgStodnDownServiceClientImpl;

/**
 * @项目名称otcwms-service-impl
 * @类名称StgStoDnDownServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class StgStoDnDownServiceClientImplTest {
	private StgStodnDownServiceClientImpl clientImplMock = new StgStodnDownServiceClientImpl();
	private StgStodnDownService stgStodnDownServiceMock;

	@Before
	public void init() {
		stgStodnDownServiceMock = EasyMock.createMock(StgStodnDownService.class);
		clientImplMock.setStgStodnDownService(stgStodnDownServiceMock);
	}
	
	/**
	* @Title: testSearchStgStoDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午1:50:35
	 */
	@Test
	public void testSearchStgStoDnDowns() {
		StgStodnDownDTO dto = new StgStodnDownDTO();
		clientImplMock.searchStgStodnDowns(1L,1L, dto);
	}

	/**
	* @Title: testGetStgStoDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午1:50:48
	 */
	@Test
	public void testGetStgStoDnDowns() {
		StgStodnDownDTO dto = new StgStodnDownDTO();
		clientImplMock.getStgStodnDownListByParm(dto);
	}

	/**
	* @Title: testPostStnDn  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午1:50:51
	 */
	@Test
	public void testPostStnDn() {
		clientImplMock.postStnDn("","");
	}


	/**
	* @Title: testGetExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午1:51:22
	 */
	@Test
	public void testGetExportAmount() {
		clientImplMock.getExportAmount(new StgStodnDownDTO());
	}
}
