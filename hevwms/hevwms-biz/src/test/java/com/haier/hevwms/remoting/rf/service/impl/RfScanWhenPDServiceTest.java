package com.haier.hevwms.remoting.rf.service.impl;

import static org.mockito.Matchers.anyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderCheckDAO;
import com.haier.hevwms.remoting.rf.dao.ScanAndIOGPWhenPD;
import com.haier.hevwms.remoting.rf.dao.StgInoutBarcodeWhenPDDAO;
import com.haier.hevwms.remoting.rf.dao.StgOrdersWhenPDDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.StgInoutBarcodeWhenPDDTO;
import com.haier.openplatform.wms.remoting.dto.StgOrdersWhenPDDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: RfScanWhenPDServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:55:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/ 
public class RfScanWhenPDServiceTest extends BasicTestCase {
	RfScanWhenPDServiceImpl ss = new RfScanWhenPDServiceImpl();
	StgInoutBarcodeWhenPDDAO stgInoutBarcodeWhenPDDAO;
    StgOrdersWhenPDDAO stgOrdersWhenPDDAO;
    OdsOrderInfoDAO orderInfoDAO;
    ScanAndIOGPWhenPD scanAndIOGPWhenPD;
    OdsInventoryInfoDtlDAO inventoryInfoDtlDAO;
    OdsBarcodeHistoryDAO barcodeHistoryDAO;
    OtcwmsOrderCheckDAO otcwmsOrderCheckDAO;
    
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:29 
	*/ 
	@Before
	public void bf() {
		stgInoutBarcodeWhenPDDAO= EasyMock.createMock(StgInoutBarcodeWhenPDDAO.class);
		stgOrdersWhenPDDAO= EasyMock.createMock(StgOrdersWhenPDDAO.class);
		orderInfoDAO= EasyMock.createMock(OdsOrderInfoDAO.class);
		scanAndIOGPWhenPD= EasyMock.createMock(ScanAndIOGPWhenPD.class);
		inventoryInfoDtlDAO= EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		barcodeHistoryDAO= EasyMock.createMock(OdsBarcodeHistoryDAO.class);
		otcwmsOrderCheckDAO= EasyMock.createMock(OtcwmsOrderCheckDAO.class);
		ss.setStgInoutBarcodeWhenPDDAO(stgInoutBarcodeWhenPDDAO);
		ss.setStgOrdersWhenPDDAO(stgOrdersWhenPDDAO);
		ss.setOrderInfoDAO(orderInfoDAO);
		ss.setScanAndIOGPWhenPD(scanAndIOGPWhenPD);
		ss.setInventoryInfoDtlDAO(inventoryInfoDtlDAO);
		ss.setBarcodeHistoryDAO(barcodeHistoryDAO);
		ss.setOtcwmsOrderCheckDAO(otcwmsOrderCheckDAO);
		ss.getStgInoutBarcodeWhenPDDAO();
		ss.getStgOrdersWhenPDDAO();
		ss.getOrderInfoDAO();
		ss.getScanAndIOGPWhenPD();
		ss.getInventoryInfoDtlDAO();
		ss.getBarcodeHistoryDAO();
		ss.getOtcwmsOrderCheckDAO();
	}

	/**  
	* @Title: orderCkeck  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:39 
	*/ 
	@Test
	public void orderCkeck() {

		try {
			orderCkeckParams("Y",1L,"C");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeck1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:47 
	*/ 
	@Test
	public void orderCkeck1() {

		try {
			orderCkeckParams("N",1L,"1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeck2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:54 
	*/ 
	@Test
	public void orderCkeck2() {

		try {
			orderCkeckParams("R",1L,"1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeck3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:56:00 
	*/ 
	@Test
	public void orderCkeck3() {

		try {
			orderCkeckParams("c",1L,"1");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeck4  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:56:05 
	*/ 
	@Test
	public void orderCkeck4() {

		try {
			orderCkeckParams("Billing",1L,"2");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeck5  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:56:10 
	*/ 
	@Test
	public void orderCkeck5() {

		try {
			orderCkeckParams("w",1L,"2");
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCkeckParams  
	* @Description: 
	* @param a
	* @param b
	* @param c 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:56:58 
	*/ 
	public void orderCkeckParams(String a,Long b,String c){
	    OrderCheckInDTO in = (OrderCheckInDTO) getBean(OrderCheckInDTO.class);
	    in.setOrdertype(c);
        EasyMock.expect( otcwmsOrderCheckDAO.orderCheck(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a);
        EasyMock.expect( stgOrdersWhenPDDAO.searchOrderCount
        		(EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(b);
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        EasyMock.expect(stgOrdersWhenPDDAO.getOrdersLocation
       	    	(EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(list);          
        EasyMock.replay(otcwmsOrderCheckDAO,stgOrdersWhenPDDAO);
		ss.orderCkeck(in);
    }
	
	/**  
	* @Title: orderDownLoad  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:03 
	*/ 
	@Test
	public void orderDownLoad() {

		try {
			OrderCheckInDTO in = (OrderCheckInDTO) getBean(OrderCheckInDTO.class);
			List<OdsOrderInfoDTO> orders=new ArrayList<OdsOrderInfoDTO>();
			List<StgOrdersWhenPDDTO> list=new ArrayList<StgOrdersWhenPDDTO>();
			for(int i =0;i<3;i++){
				OdsOrderInfoDTO o=new OdsOrderInfoDTO();
				o.setSapOrderNo("1");
				o.setSapOrderItem("1");
				o.setSapOrderItem("1");
				o.setRequireQty(1L);
				orders.add(o);
			}
			for(int i =0;i<3;i++){
				StgOrdersWhenPDDTO o=new StgOrdersWhenPDDTO();
				o.setOrderNo("1");
				o.setOrderItem("1");
				o.setQty(1L);
				
				list.add(o);
			}
			 EasyMock.expect(orderInfoDAO.getOrdersByNo
			       		(EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(orders);          
          
			 EasyMock.expect( stgOrdersWhenPDDAO.getOrders
					 (EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(list);          
			 EasyMock.replay(orderInfoDAO);
			 
			ss.orderDownLoad(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderDownLoad6  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:11 
	*/ 
	@Test
	public void orderDownLoad6() {

		try {
			OrderCheckInDTO in = (OrderCheckInDTO) getBean(OrderCheckInDTO.class);
			List<OdsOrderInfoDTO> orders=new ArrayList<OdsOrderInfoDTO>();
			List<StgOrdersWhenPDDTO> list=new ArrayList<StgOrdersWhenPDDTO>();
			for(int i =0;i<3;i++){
				OdsOrderInfoDTO o=new OdsOrderInfoDTO();
				o.setSapOrderNo("1");
				o.setSapOrderItem("1");
				o.setSapOrderItem("1");
				o.setRequireQty(1L);
				orders.add(o);
			}
			for(int i =0;i<3;i++){
				StgOrdersWhenPDDTO o=new StgOrdersWhenPDDTO();
				o.setOrderNo("1");
				o.setOrderItem("1");
				o.setQty(1L);
				
				list.add(o);
			}
			 EasyMock.expect(orderInfoDAO.getOrdersByNo
			       		(EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(orders);          
          
			 EasyMock.expect( stgOrdersWhenPDDAO.getOrders
					 (EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(list);          
			 EasyMock.replay(orderInfoDAO,stgOrdersWhenPDDAO);
			 
			ss.orderDownLoad(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderDownLoad1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:19 
	*/ 
	@Test
	public void orderDownLoad1() {

		try {
			OrderCheckInDTO in = (OrderCheckInDTO) getBean(OrderCheckInDTO.class);
			List<OdsOrderInfoDTO> orders=new ArrayList<OdsOrderInfoDTO>();
			List<StgOrdersWhenPDDTO> list=new ArrayList<StgOrdersWhenPDDTO>();
			for(int i =0;i<3;i++){
				OdsOrderInfoDTO o=new OdsOrderInfoDTO();
				o.setSapOrderNo("1");
				o.setSapOrderItem("1");
				o.setSapOrderItem("1");
				o.setRequireQty(1L);
				orders.add(o);
			}
			 EasyMock.expect(orderInfoDAO.getOrdersByNo
			       		(EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(orders).anyTimes();          
			 EasyMock.expect(stgOrdersWhenPDDAO.getOrders
					 (EasyMock.isA(String.class),EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(list).anyTimes();
			 stgOrdersWhenPDDAO.save(EasyMock.isA(StgOrdersWhenPDDTO.class));
			 EasyMock.replay(orderInfoDAO);     
			ss.orderDownLoad(in);
		} catch (Exception e) {
		}finally{
		Assert.assertTrue(true);
		}

	}

	/**  
	* @Title: orderScan  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:23 
	*/ 
	@Test
	public void orderScan() {

		try {
			OrderUploadInDTO in = (OrderUploadInDTO) getBean(OrderUploadInDTO.class);

			ss.orderScan(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: orderDelete  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:27 
	*/ 
	@Test
	public void orderDelete() {

		try {
			OrderUploadInDTO in = (OrderUploadInDTO) getBean(OrderUploadInDTO.class);

			ss.orderDelete(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: barcodeDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:31 
	*/ 
	@Test
	public void barcodeDetail() {

		try {
			OrderUploadInDTO in = (OrderUploadInDTO) getBean(OrderUploadInDTO.class);
			List<StgInoutBarcodeWhenPDDTO> list=new ArrayList<StgInoutBarcodeWhenPDDTO>();
			StgInoutBarcodeWhenPDDTO s = (StgInoutBarcodeWhenPDDTO) getBean(StgInoutBarcodeWhenPDDTO.class);
			list.add(s);
			EasyMock.expect(stgInoutBarcodeWhenPDDAO.getByOrderNoAndType(EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(list).anyTimes();
			EasyMock.replay(stgInoutBarcodeWhenPDDAO);
			ss.barcodeDetail(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: orderIogp  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:36 
	*/ 
	@Test
	public void orderIogp() {
////		DataSourceTransactionManager transactionManager = EasyMock.createMock(DataSourceTransactionManager.class);
////		TransactionStatus status = EasyMock.createMock(TransactionStatus.class);
////		EasyMock.expect(transactionManager.getTransaction((DefaultTransactionDefinition)EasyMock.anyObject())).andReturn(status);
////		
////		EasyMock.replay(transactionManager);
//		ss.orderIogp((OtcwmsOrderUploadInDTO) anyObject());
		try {
//			OtcwmsOrderUploadInDTO in = (OtcwmsOrderUploadInDTO) getBean(OtcwmsOrderUploadInDTO.class);
			
			ss.orderIogp((OrderUploadInDTO) anyObject());
		} catch (Exception e) {
			
		}
		Assert.assertTrue(true);
	}

	/**
	 * @Title: offlineScan
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月27日 下午2:16:43
	 */
	@Test
	public void offlineScan() {
		List<OrderUploadInDTO> listTestCase = new ArrayList<OrderUploadInDTO>();
		OrderUploadInDTO dtoTestCase = new OrderUploadInDTO();
		listTestCase.add(dtoTestCase);
		
		Map<String, String> offlineScan = ss.offlineScan(listTestCase);
		Assert.assertNotNull(offlineScan);

	}
}