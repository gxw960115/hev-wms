package com.haier.openplatform.wms.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.order.service.OdsTransferInventoryService;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称TransferInventoryServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class TransferInventoryServiceClientImplTest {
	private TransferInventoryServiceClientImpl clientImplMock = new TransferInventoryServiceClientImpl();
	private OdsTransferInventoryService OdsTransferInventoryServiceMock;
	
	/**
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:15
	 */
	@Before
	public void init() {
		OdsTransferInventoryServiceMock = EasyMock.createMock(OdsTransferInventoryService.class);
		clientImplMock.setOdsTransferInventoryService(OdsTransferInventoryServiceMock);
	}

	/**
	* @Title: testGetTransferInventoryOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:19
	 */
	@Test
	public void testGetTransferInventoryOrderNo() {
		EasyMock.expect(OdsTransferInventoryServiceMock.selectTransferInventoryOrderNo()).andReturn("").times(1);
		EasyMock.replay(OdsTransferInventoryServiceMock);
		
		clientImplMock.getTransferInventoryOrderNo();
	}

	/**
	* @Title: testSearchTransInventoryOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:23
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchTransInventoryOrder() {
		Pager<OdsTransferInventoryDTO> temp = new Pager<OdsTransferInventoryDTO>();
		temp.setTotalRecords(10L);
		OdsTransferInventoryDTO odsTransferInventoryDTO = new OdsTransferInventoryDTO();
		
		EasyMock.expect(OdsTransferInventoryServiceMock.searchTransInventoryInfos((Pager<OdsTransferInventoryDTO>)EasyMock.anyObject()
				,(OdsTransferInventoryDTO)EasyMock.anyObject())).andReturn(temp).times(1);
		EasyMock.replay(OdsTransferInventoryServiceMock);
		
		clientImplMock.searchTransInventoryOrder(1L, 10L, odsTransferInventoryDTO);
	}

	/**
	* @Title: testGetOdsTransInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:27
	 */
	@Test
	public void testGetOdsTransInfo() {
		List<OdsTransferInventoryDTO> list = new ArrayList<OdsTransferInventoryDTO>();
		OdsTransferInventoryDTO odsTransferInventoryDTO = new OdsTransferInventoryDTO();
		
		EasyMock.expect(OdsTransferInventoryServiceMock.getList((OdsTransferInventoryDTO)EasyMock.anyObject())).andReturn(list).times(1);
		EasyMock.replay(OdsTransferInventoryServiceMock);
		
		clientImplMock.getOdsTransInfo(odsTransferInventoryDTO);
	}


	/**
	* @Title: testGetExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:51:35
	 */
	@Test
	public void testGetExportAmount() {
		OdsTransferInventoryDTO dto = new OdsTransferInventoryDTO();
		
		clientImplMock.getExportAmount(dto);
	}
}
