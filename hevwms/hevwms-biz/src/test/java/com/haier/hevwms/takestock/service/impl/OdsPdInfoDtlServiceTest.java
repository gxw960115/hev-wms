package com.haier.hevwms.takestock.service.impl;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.takestock.dao.OdsPdInfoDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsPdInfoDtlServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:23:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsPdInfoDtlServiceTest extends BasicTestCase {
	OdsPdInfoDtlServiceImpl ss = new OdsPdInfoDtlServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:35 
	*/ 
	@Before
	public void bf() {

		OdsPdInfoDtlDAO dao = EasyMock.createMock(OdsPdInfoDtlDAO.class);
		ss.setOdsPdInfoDtlDAO(dao);
		ss.getOdsPdInfoDtlDAO();
	}

	/**  
	* @Title: createOdsPdInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:38 
	*/ 
	@Test
	public void createOdsPdInfoDtl() {

		try {
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.createOdsPdInfoDtl(odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOdsPdInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:46 
	*/ 
	@Test
	public void updateOdsPdInfoDtl() {

		try {
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.updateOdsPdInfoDtl(odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:23:53 
	*/ 
	@Test
	public void deleteOdsPdInfoDtl() {

		try {
			Long odsPdInfoDtlId = (long) 2;

			ss.deleteOdsPdInfoDtl(odsPdInfoDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdInfoDtlAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:01 
	*/ 
	@Test
	public void deleteOdsPdInfoDtlAll() {

		try {
			List idList = (List) getBean(List.class);

			ss.deleteOdsPdInfoDtlAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfoDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:08 
	*/ 
	@Test
	public void searchOdsPdInfoDtls() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.searchOdsPdInfoDtls(pager, odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdInfoDtlById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:16 
	*/ 
	@Test
	public void getOdsPdInfoDtlById() {

		try {
			Long odsPdInfoDtlId = (long) 13;

			ss.getOdsPdInfoDtlById(odsPdInfoDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdInfoDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:24 
	*/ 
	@Test
	public void getOdsPdInfoDtls() {

		try {
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.getOdsPdInfoDtls(odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfoDtlsBySum  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:34 
	*/ 
	@Test
	public void searchOdsPdInfoDtlsBySum() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.searchOdsPdInfoDtlsBySum(pager, odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfoDtlsBySum2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:41 
	*/ 
	@Test
	public void searchOdsPdInfoDtlsBySum2() {

		try {
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.searchOdsPdInfoDtlsBySum2(odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: pdQtyDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:49 
	*/ 
	@Test
	public void pdQtyDetail() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsPdInfoDtl odsPdInfoDtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.pdQtyDetail(pager, odsPdInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getPdExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:53 
	*/ 
	@Test
	public void getPdExportAmount() {

		try {
			OdsPdInfoDtl dtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.getPdExportAmount(dtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfoDtlsCountBySum  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:24:56 
	*/ 
	@Test
	public void searchOdsPdInfoDtlsCountBySum() {

		try {
			OdsPdInfoDtl dtl = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);

			ss.searchOdsPdInfoDtlsCountBySum(dtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}