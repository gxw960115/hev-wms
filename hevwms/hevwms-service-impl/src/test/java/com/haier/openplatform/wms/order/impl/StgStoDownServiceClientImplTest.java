package com.haier.openplatform.wms.order.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.impl.StgStoDownServiceClientImpl;

/**
 * @项目名称otcwms-service-impl
 * @类名称StgStoDownServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class StgStoDownServiceClientImplTest {
	private StgStoDownServiceClientImpl clientImplMock = new StgStoDownServiceClientImpl();
	private StgStoDownService stgStoDownServiceMock;
	
	/**
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:50
	 */
	@Before
	public void init() {
		stgStoDownServiceMock = EasyMock.createMock(StgStoDownService.class);
		clientImplMock.setStgStoDownService(stgStoDownServiceMock);
	}

	/**
	* @Title: testSearchStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:53
	 */
	@Test
	public void testSearchStgStoDown() {
		Pager<StgStoDownDTO> pager = new Pager<StgStoDownDTO>();
		StgStoDownDTO dto = new StgStoDownDTO();
		clientImplMock.searchStgStoDown(pager, dto);
	}

	/**
	* @Title: testCreateStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:58
	 */
	@Test
	public void testCreateStgStoDown() {
		StgStoDownDTO dto = new StgStoDownDTO();
		clientImplMock.createStgStoDown(dto);
	}

	/**
	* @Title: testGetStgStoDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:01
	 */
	@Test
	public void testGetStgStoDowns() {
		StgStoDownDTO stgStoDown = new StgStoDownDTO();
		clientImplMock.getStgStoDowns(stgStoDown);
	}

	/**
	* @Title: testCloseStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:04
	 */
	@Test
	public void testCloseStgStoDown() {
		clientImplMock.closeStgStoDown("", "");
	}

	/**
	* @Title: testOpenStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:11
	 */
	@Test
	public void testOpenStgStoDown() {
		clientImplMock.openStgStoDown("", "");
	}

	/**
	* @Title: testConfirmSto  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:16
	 */
	@Test
	public void testConfirmSto() {
		String stoNos = "we";
		EasyMock.expect(stgStoDownServiceMock.updateStoConfirm((String)EasyMock.anyObject())).andReturn(1).times(1);
		EasyMock.replay(stgStoDownServiceMock);
		
		clientImplMock.confirmSto(stoNos);
	}

	/**
	* @Title: testGetExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:20
	 */
	@Test
	public void testGetExportAmount() {
		StgStoDownDTO dto = new StgStoDownDTO();
		clientImplMock.getExportAmount(dto);
	}
	
	/**
	* @Title: testGetStgStoDownService  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:52:24
	 */
	@Test
	public void testGetStgStoDownService() {
		clientImplMock.getStgStoDownService();
	}

}
