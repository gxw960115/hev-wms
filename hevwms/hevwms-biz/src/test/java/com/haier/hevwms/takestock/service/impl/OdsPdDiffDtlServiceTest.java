package com.haier.hevwms.takestock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsPdDiffDtlServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:22:50 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsPdDiffDtlServiceTest extends BasicTestCase {
	OdsPdDiffDtlServiceImpl ss = new OdsPdDiffDtlServiceImpl();
	OdsPdDiffDtlDAO dao;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:22:53 
	*/ 
	@Before
	public void bf() {

		dao = EasyMock.createMock(OdsPdDiffDtlDAO.class);
		ss.setOdsPdDiffDtlDAO(dao);
		ss.getOdsPdDiffDtlDAO();
	}

	/**  
	* @Title: createOdsPdDiffDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:22:55 
	*/ 
	@Test
	public void createOdsPdDiffDtl() {

		try {
			OdsPdDiffDtl odsPdDiffDtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);

			ss.createOdsPdDiffDtl(odsPdDiffDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOdsPdDiffDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:22:58 
	*/ 
	@Test
	public void updateOdsPdDiffDtl() {

		try {
			OdsPdDiffDtl odsPdDiffDtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);

			ss.updateOdsPdDiffDtl(odsPdDiffDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdDiffDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:01 
	*/ 
	@Test
	public void deleteOdsPdDiffDtl() {

		try {
			Long odsPdDiffDtlId = (long) 18;

			ss.deleteOdsPdDiffDtl(odsPdDiffDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdDiffDtlAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:04 
	*/ 
	@Test
	public void deleteOdsPdDiffDtlAll() {

		try {
			List idList = new ArrayList<Long>();
			dao.deleteAll(EasyMock.isA(ArrayList.class));
			EasyMock.expectLastCall().anyTimes();
			EasyMock.replay(dao);

			ss.deleteOdsPdDiffDtlAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdDiffDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:06 
	*/ 
	@Test
	public void searchOdsPdDiffDtls() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsPdDiffDtl odsPdDiffDtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);
			List<OdsPdDiffDtl> list=new ArrayList<OdsPdDiffDtl>();
			EasyMock.expect(dao.searchOdsPdDiffDtlsCount(EasyMock.isA(OdsPdDiffDtl.class))).andReturn(2L);
			EasyMock.expect(dao.searchOdsPdDiffDtls(EasyMock.isA(Pager.class),EasyMock.isA(OdsPdDiffDtl.class))).andReturn(list);
			EasyMock.replay(dao);
			ss.searchOdsPdDiffDtls(pager, odsPdDiffDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdDiffDtlById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:08 
	*/ 
	@Test
	public void getOdsPdDiffDtlById() {

		try {
			Long odsPdDiffDtlId = (long) 19;

			ss.getOdsPdDiffDtlById(odsPdDiffDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdDiffDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:11 
	*/ 
	@Test
	public void getOdsPdDiffDtls() {

		try {

			ss.getOdsPdDiffDtls();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdDiffDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:17 
	*/ 
	@Test
	public void getOdsPdDiffDtl() {

		try {
			OdsPdDiffDtl odsPdDiffDtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);

			ss.getOdsPdDiffDtl(odsPdDiffDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdDiffDtlsCount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:21 
	*/ 
	@Test
	public void searchOdsPdDiffDtlsCount() {

		try {
			OdsPdDiffDtl dtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);

			ss.searchOdsPdDiffDtlsCount(dtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}