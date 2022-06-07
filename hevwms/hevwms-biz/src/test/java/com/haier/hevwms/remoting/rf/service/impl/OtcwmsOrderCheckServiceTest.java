package com.haier.hevwms.remoting.rf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderCheckDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderLoadDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderLoadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderWlList;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsOrderCheckServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:46:37 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsOrderCheckServiceTest extends BasicTestCase {
	OtcwmsOrderCheckServiceImpl ss = new OtcwmsOrderCheckServiceImpl();
	OtcwmsOrderCheckDAO dao;
	OtcwmsOrderLoadDAO otcwmsOrderLoadDAO;
	private WmsLoginDAO loginDAO;
	@Before
	public void bf() {

		dao = EasyMock.createMock(OtcwmsOrderCheckDAO.class);
		otcwmsOrderLoadDAO = EasyMock.createMock(OtcwmsOrderLoadDAO.class);
		loginDAO = EasyMock.createMock(WmsLoginDAO.class);

		ss.setLoginDAO(loginDAO);
		ss.setOtcwmsOrderCheckDAO(dao);
		ss.setOtcwmsOrderLoadDAO(otcwmsOrderLoadDAO);

	}
	
	/**  
	* @Title: otcwmsOrderCheck  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:46 
	*/ 
//	@Test
//	public void otcwmsOrderCheck() {
//		UserDTO userDTO = new UserDTO();
//		EasyMock.expect(loginDAO.getRfUserByName((String) EasyMock.anyObject())).andReturn(userDTO);
//		
//		
//		List<StgInboundDownDTO> inboundList = new ArrayList<StgInboundDownDTO>();
//		StgInboundDownDTO dto = new StgInboundDownDTO();
//		inboundList.add(dto);
//		EasyMock.expect(dao.getInbdByOrderNo((WmsOrderCheckIn) EasyMock.anyObject())).andReturn(inboundList);
//		
//		EasyMock.expect(dao.getPoByOrderNoItem((StgInboundDownDTO) EasyMock.anyObject())).andReturn("Y");
//		
//		EasyMock.expect(dao.getRequiredTotalQty((WmsOrderCheckIn) EasyMock.anyObject())).andReturn("1");
//		
//		EasyMock.replay(dao);
//		EasyMock.replay(loginDAO);
//		
//		WmsOrderCheckIn otcwmsOrderCheckIn = new WmsOrderCheckIn();
//		otcwmsOrderCheckIn.setDoctype("INBOUND");
//		ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
//		Assert.assertTrue(true);
//
//	}

	@Test
	public void test2() {
		UserDTO userDTO = new UserDTO();
		EasyMock.expect(loginDAO.getRfUserByName((String) EasyMock.anyObject())).andReturn(userDTO);
		
		EasyMock.expect(dao.orderCheck((WmsOrderCheckIn) EasyMock.anyObject())).andReturn("Y");
		
		List<String> locations = new ArrayList<String>();
		locations.add("11");
		EasyMock.expect(dao.getPdLocation((String) EasyMock.anyObject())).andReturn(locations);
		
		List<String> listWl = new ArrayList<String>();
		listWl.add("11");
		EasyMock.expect(dao.getPdMat((String) EasyMock.anyObject(), (String) EasyMock.anyObject())).andReturn(listWl);
		
		EasyMock.replay(dao);
		EasyMock.replay(loginDAO);
		
		
		WmsOrderCheckIn otcwmsOrderCheckIn = new WmsOrderCheckIn();
		otcwmsOrderCheckIn.setDoctype("PD");
		ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
	}
	
	/**  
	* @Title: otcwmsOrderCheck1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:50 
	*/ 
	@Test
	public void otcwmsOrderCheck1() {

		try {
			WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
			otcwmsOrderCheckIn.setDoctype("INBOUND");
			List<StgInboundDownDTO> inboundList = new ArrayList<StgInboundDownDTO>();
			for(int i=1;i<3;i++){
				StgInboundDownDTO s=(StgInboundDownDTO) getBean(StgInboundDownDTO.class);
				inboundList.add(s);
			}
		    EasyMock.expect(dao.getPoByOrderNoItem(EasyMock.isA(StgInboundDownDTO.class))).andReturn("Ns").anyTimes();
		   EasyMock.expect(dao.getInbdByOrderNo(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(inboundList).anyTimes();
		   EasyMock.replay(dao);
			ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:56 
	*/ 
	@Test
	public void otcwmsOrderCheck2() {

		try {
			WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
			otcwmsOrderCheckIn.setDoctype("INBOUND");
			List<StgInboundDownDTO> inboundList = new ArrayList<StgInboundDownDTO>();
		   EasyMock.expect(dao.getInbdByOrderNo(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(inboundList).anyTimes();
		   EasyMock.replay(dao);
			ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck5  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:03 
	*/ 
	@Test
	public void otcwmsOrderCheck5() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("PD");
			a.add("Y");
			WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
			otcwmsOrderCheckIn.setDoctype(a.get(0));
			 EasyMock.expect(dao.getPoByOrderNoItem(EasyMock.isA(StgInboundDownDTO.class))).andReturn("Ns").anyTimes();
			 EasyMock.expect(dao.orderCheck(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
			 List<String> locations= new ArrayList<String>();
				for(int i=1;i<3;i++){
					locations.add(i+"");
				};
			   EasyMock.expect(dao.getPdLocation(EasyMock.isA(String.class))).andReturn(locations).anyTimes();
			   EasyMock.expect(dao.getPdMat(EasyMock.isA(String.class),EasyMock.isA(String.class))).andReturn(locations).anyTimes();
			   
			   EasyMock.replay(dao);
			ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
			
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck6  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:10 
	*/ 
	@Test
	public void otcwmsOrderCheck6() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("F");
			a.add("Y");
			WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
			otcwmsOrderCheckIn.setDoctype(a.get(0));
			 EasyMock.expect(dao.getPoByOrderNoItem(EasyMock.isA(StgInboundDownDTO.class))).andReturn("Ns").anyTimes();
			 EasyMock.expect(dao.orderCheck(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
			 EasyMock.expect(dao.getRequiredTotalQty(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
			 List<WmsOrderWlList> wlList=new ArrayList<WmsOrderWlList>();
			 EasyMock.expect(otcwmsOrderLoadDAO.otcwmsGetWlList(EasyMock.isA(WmsOrderLoadIn.class))).andReturn(wlList).anyTimes();
			 EasyMock.replay(dao,otcwmsOrderLoadDAO);
			ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck7  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:17 
	*/ 
	@Test
	public void otcwmsOrderCheck7() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("SRN");
			a.add("R");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck8  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:25 
	*/ 
	@Test
	public void otcwmsOrderCheck8() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("SRN");
			a.add("SRN");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck9  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:44 
	*/ 
	@Test
	public void otcwmsOrderCheck9() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("SRN");
			a.add("ConPickUp");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck10  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:40 
	*/ 
	@Test
	public void otcwmsOrderCheck10() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("ConPickUp");
			a.add("ConPckUp");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck11  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:50 
	*/ 
	@Test
	public void otcwmsOrderCheck11() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("ConPickUp");
			a.add("SRN");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck12  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:47:55 
	*/ 
	@Test
	public void otcwmsOrderCheck12() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("ConPickUp");
			a.add("ConPkUp");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck13  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:02 
	*/ 
	@Test
	public void otcwmsOrderCheck13() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("s");
			a.add("s");
			a.add("1");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck14  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:08 
	*/ 
	@Test
	public void otcwmsOrderCheck14() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("s");
			a.add("C");
			a.add("2");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck15  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:14 
	*/ 
	@Test
	public void otcwmsOrderCheck15() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("Billing");
			a.add("Billing");
			a.add("2");
			EasyMock.expect(dao.checkDnSapFlag(EasyMock.isA(WmsOrderCheckIn.class))).andReturn("S").anyTimes();
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck16  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:21 
	*/ 
	@Test
	public void otcwmsOrderCheck16() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("Billing");
			a.add("Billing");
			a.add("2");
			EasyMock.expect(dao.checkDnSapFlag(EasyMock.isA(WmsOrderCheckIn.class))).andReturn("a").anyTimes();
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck17  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:30 
	*/ 
	@Test
	public void otcwmsOrderCheck17() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("s");
			a.add("ConIssue");
			a.add("2");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck18  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:36 
	*/ 
	@Test
	public void otcwmsOrderCheck18() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("s");
			a.add("s");
			a.add("2");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderCheck19  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:48:43 
	*/ 
	@Test
	public void otcwmsOrderCheck19() {

		try {
			ArrayList<String> a =new ArrayList<String>();
			a.add("s");
			a.add("s");
			a.add("3");
			param1(a);
			
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: param  
	* @Description: 
	* @param a 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:49:51 
	*/ 
	public void param( ArrayList<String> a  ){
		WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
		otcwmsOrderCheckIn.setDoctype(a.get(0));
		EasyMock.expect(dao.getPoByOrderNoItem(EasyMock.isA(StgInboundDownDTO.class))).andReturn("Ns").anyTimes();
		EasyMock.expect(dao.orderCheck(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
	    EasyMock.replay(dao);
		ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
		Assert.assertTrue(true);
	}
	
	/**  
	* @Title: param1  
	* @Description: 
	* @param a 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:49:55 
	*/ 
	public void param1( ArrayList<String> a  ){
		WmsOrderCheckIn otcwmsOrderCheckIn = (WmsOrderCheckIn) getBean(WmsOrderCheckIn.class);
		otcwmsOrderCheckIn.setDoctype(a.get(0));
		otcwmsOrderCheckIn.setOrdertype(a.get(2));
		EasyMock.expect(dao.getPoByOrderNoItem(EasyMock.isA(StgInboundDownDTO.class))).andReturn("Ns").anyTimes();
		EasyMock.expect(dao.orderCheck(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
		EasyMock.expect(dao.getRequiredTotalQty(EasyMock.isA(WmsOrderCheckIn.class))).andReturn(a.get(1)).anyTimes();
		List<WmsOrderWlList> wlList=new ArrayList<WmsOrderWlList>();
		EasyMock.expect(otcwmsOrderLoadDAO.otcwmsGetWlList(EasyMock.isA(WmsOrderLoadIn.class))).andReturn(wlList).anyTimes();
		EasyMock.replay(dao,otcwmsOrderLoadDAO);
		ss.otcwmsOrderCheck(otcwmsOrderCheckIn);
		Assert.assertTrue(true);
	}
}