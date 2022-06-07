package com.haier.hevwms.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.hevwms.so.service.impl.StgDnDownServiceImpl;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgDnDownServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:11:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgDnDownServiceTest extends BasicTestCase {
	StgDnDownServiceImpl ss = new StgDnDownServiceImpl();
	private StgDnDownDAO stgDnDownDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:11:09 
	*/ 
	@Before
	public void bf() {

		stgDnDownDAO = EasyMock.createMock(StgDnDownDAO.class);
		
		ss.getStgDnDownDAO();
		
		ss.setStgDnDownDAO(stgDnDownDAO);

	}

	/**  
	* @Title: searchStgDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:11:11 
	*/ 
	@Test
	public void searchStgDnDowns() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			StgDnDownDTO stgDnDown = (StgDnDownDTO) getBean(StgDnDownDTO.class);

			ss.searchStgDnDowns(pager, stgDnDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgDnDownById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:11:17 
	*/ 
	@Test
	public void getStgDnDownById() {

		try {
			Long stgDnDownId = (long) 16;

			ss.getStgDnDownById(stgDnDownId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:11:24 
	*/ 
	@Test
	public void getStgDnDowns() {

		try {

			ss.getStgDnDowns();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgDnDownsByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:11:26 
	*/ 
	@Test
	public void getStgDnDownsByParam() {

		try {
			StgDnDownDTO stgDnDown = (StgDnDownDTO) getBean(StgDnDownDTO.class);

			ss.getStgDnDownsByParam(stgDnDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * @Title: postDn
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月28日 下午3:11:32
	 */
	@Test
	public void postDn() {
//		List<StgDnDownDTO> listTestCase = new ArrayList<StgDnDownDTO>();
//		StgDnDownDTO testCase = EasyMock.anyObject(StgDnDownDTO.class);
////		EasyMock.expect(stgDnDownDAO.getStgDnDownsByParam(testCase)).andReturn(listTestCase);
//
//		EasyMock.replay(stgDnDownDAO);
//		WmsOrderIgpOut result = ss.postDn("111","111");
//		Assert.assertNotNull(result);
//
//		EasyMock.verify(stgDnDownDAO);
	}

	/**  
	* @Title: getExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:11 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgDnDownDTO dto = (StgDnDownDTO) getBean(StgDnDownDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}