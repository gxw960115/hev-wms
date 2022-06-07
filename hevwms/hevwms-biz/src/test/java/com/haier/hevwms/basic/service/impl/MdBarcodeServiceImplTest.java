package com.haier.hevwms.basic.service.impl;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.basic.dao.MdBarcodeDAO;
import com.haier.hevwms.basic.domain.MdBarcode;

/**   
* Copyright: Copyright (c) 2018 SJK
* 
* @ClassName: MdBarcodeServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: SJK
* @date: 2018年5月3日 上午9:17:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月3日     SJK           v1.0.0               修改原因
*/
public class MdBarcodeServiceImplTest {
	
	private MdBarcodeDAO mdBarcodeDAO;
	private MdBarcodeServiceImpl mdBarcodeServiceImpl = new MdBarcodeServiceImpl();
	
	/**  
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:44:47 
	*/ 
	@Before
	public void init(){
		mdBarcodeDAO = createMock(MdBarcodeDAO.class);
		mdBarcodeServiceImpl.setMdBarcodeDAO(mdBarcodeDAO);
	}
	
	/**  
	* @Title: testCreateMdBarcode  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:44:51 
	*/ 
	@Test
	public void testCreateMdBarcode() {
		List<MdBarcode> paramList = new ArrayList<MdBarcode>();
		paramList.add(new MdBarcode());
		mdBarcodeDAO.save((MdBarcode) anyObject());
		expectLastCall();
		replay(mdBarcodeDAO);
		ExecuteResult<MdBarcode> result = mdBarcodeServiceImpl.createMdBarcode(paramList);
		assertTrue(result.isSuccess());
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testSearchMdBarcodesHisNum  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:44:54 
	*/ 
	@Test
	public void testSearchMdBarcodesHisNum() {
		expect(mdBarcodeDAO.searchMdBarcodesHisNum()).andReturn(5);
		replay(mdBarcodeDAO);
		Integer result = mdBarcodeServiceImpl.searchMdBarcodesHisNum();
		assertSame(result, 5);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testUpdateBarcodesHisNum  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:44:58 
	*/ 
	@Test
	public void testUpdateBarcodesHisNum() {
		expect(mdBarcodeDAO.updateBarcodesHisNum((String)anyObject(), anyInt())).andReturn(5);
		replay(mdBarcodeDAO);
		Integer result = mdBarcodeServiceImpl.updateBarcodesHisNum(5, 10);
		assertSame(result, 5);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testUpdateMdBarcode  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:02 
	*/ 
	@Test
	public void testUpdateMdBarcode() {
		mdBarcodeDAO.update((List<Long>)anyObject(), (String)anyObject());
		replay(mdBarcodeDAO);
		ExecuteResult<MdBarcode> result = mdBarcodeServiceImpl.updateMdBarcode(new ArrayList<Long>(), "9999");
		assertTrue(result.isSuccess());
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testSearchMdBarcodes  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:04 
	*/ 
	@Test
	public void testSearchMdBarcodes() {
		List<MdBarcode> expectList = new ArrayList<MdBarcode>();
		expectList.add(new MdBarcode());
		expectList.add(new MdBarcode());
		expectList.add(new MdBarcode());
		expect(mdBarcodeDAO.searchMdBarcodes((Pager<MdBarcode>)anyObject(), (MdBarcode)anyObject())).andReturn(expectList);
		expect(mdBarcodeDAO.searchMdBarcodesCount((MdBarcode) anyObject())).andReturn(5L);
		replay(mdBarcodeDAO);
		Pager<MdBarcode> result = mdBarcodeServiceImpl.searchMdBarcodes(new Pager<MdBarcode>(), new MdBarcode());
		assertSame(result.getTotalRecords(), 5L);
		assertSame(result.getRecords().size(), 3);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testSearchById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:09 
	*/ 
	@Test
	public void testSearchById() {
		List<MdBarcode> expectList = new ArrayList<MdBarcode>();
		expectList.add(new MdBarcode());
		expectList.add(new MdBarcode());
		expectList.add(new MdBarcode());
		expect(mdBarcodeDAO.selectByOrderId((String) anyObject())).andReturn(expectList);
		replay(mdBarcodeDAO);
		List<MdBarcode> result = mdBarcodeServiceImpl.searchById("9999");
		assertSame(result.size(), 3);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testSearchMdBarcodesStNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:13 
	*/ 
	@Test
	public void testSearchMdBarcodesStNo() {
		expect(mdBarcodeDAO.searchMdBarcodesStNo()).andReturn(5L);
		replay(mdBarcodeDAO);
		Long result = mdBarcodeServiceImpl.searchMdBarcodesStNo();
		assertSame(result, 5L);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testAddNewBarcodes  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:16 
	*/ 
	@Test
	public void testAddNewBarcodes() {
		MdBarcode paramBarcode = new MdBarcode();
		paramBarcode.setBarcodeNum(1L);
		paramBarcode.setMaterialNo("TEST");
		expect(mdBarcodeDAO.selectSeq()).andReturn("9999").andReturn("6666");
		mdBarcodeDAO.save((MdBarcode) anyObject());
		expectLastCall();
		replay(mdBarcodeDAO);
		String result = mdBarcodeServiceImpl.addNewBarcodes(paramBarcode);
		assertEquals(result, "S");
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testCreateMdBarcode1D  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:21 
	*/ 
	@Test
	public void testCreateMdBarcode1D() {
		String result = mdBarcodeServiceImpl.createMdBarcode1D("AAAA", "BBBB");
		assertSame(result.length(), 4);
	}

	/**  
	* @Title: testCreateTempDir  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:24 
	*/ 
	@Test
	public void testCreateTempDir() {
		String result = mdBarcodeServiceImpl.createTempDir("AAAA");
		assertNotNull(result);
	}

	/**  
	* @Title: testExistBarcode  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:27 
	*/ 
	@Test
	public void testExistBarcode() {
		expect(mdBarcodeDAO.existBarcode((String) anyObject())).andReturn(1);
		replay(mdBarcodeDAO);
		boolean result = mdBarcodeServiceImpl.existBarcode("9999");
		assertTrue(result);
		verify(mdBarcodeDAO);
	}

	/**  
	* @Title: testInsert  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:30 
	*/ 
//	@Test
//	public void testInsert() {
//		boolean flag = true;
//		mdBarcodeDAO.insertBarcode((String) anyObject());
//		expectLastCall();
//		replay(mdBarcodeDAO);
//		try {
//			mdBarcodeServiceImpl.insert("9999","1111");
//		} catch(Exception e){
//			flag = false;
//		}
//		assertTrue(flag);
//		verify(mdBarcodeDAO);
//	}
}
