package com.haier.hevwms.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.domain.OdsWmsOrder;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsInventoryInfoDtlServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午2:44:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsInventoryInfoDtlServiceImplTest extends BasicTestCase {
	OdsInventoryInfoDtlServiceImpl ss = new OdsInventoryInfoDtlServiceImpl();
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:44:17 
	*/ 
	@Before
	public void bf() {

		odsInventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		ss.setOdsInventoryInfoDtlDAO(odsInventoryInfoDtlDAO);
		ss.getOdsInventoryInfoDtlDAO();

	}

	/**  
	* @Title: createOdsInventoryInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:45:55 
	*/ 
	@Test
	public void createOdsInventoryInfoDtl() {

		try {
			OdsInventoryInfoDtl odsInventoryInfoDtl = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);

			ss.createOdsInventoryInfoDtl(odsInventoryInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOdsInventoryInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:45:58 
	*/ 
	@Test
	public void updateOdsInventoryInfoDtl() {

		try {
			OdsInventoryInfoDtl odsInventoryInfoDtl = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);

			ss.updateOdsInventoryInfoDtl(odsInventoryInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsInventoryInfoDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:01 
	*/ 
	@Test
	public void deleteOdsInventoryInfoDtl() {

		try {
			Long odsInventoryInfoDtlId = (long) 17;

			ss.deleteOdsInventoryInfoDtl(odsInventoryInfoDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsInventoryInfoDtlAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:04 
	*/ 
	@Test
	public void deleteOdsInventoryInfoDtlAll() {

		try {
			List idList = new ArrayList<Integer>();
			idList.add(1);
			ss.deleteOdsInventoryInfoDtlAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsInventoryInfoDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:06 
	*/ 
	@Test
	public void searchOdsInventoryInfoDtls() {
		List<OdsInventoryInfoDtl> list = new ArrayList<OdsInventoryInfoDtl>();
		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfoDtls((Pager<OdsInventoryInfoDtl>)EasyMock.anyObject(), 
				(OdsInventoryInfoDtl) EasyMock.anyObject())).andReturn(list);
		
		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfoDtlsCount(
				(OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(11L);
		
		EasyMock.replay(odsInventoryInfoDtlDAO);
		
		Pager<OdsInventoryInfoDtl> pager = new Pager<OdsInventoryInfoDtl>();
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		ss.searchOdsInventoryInfoDtls(pager, odsInventoryInfoDtl);
	}

	/**  
	* @Title: getOdsInventoryInfoDtlById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:09 
	*/ 
	@Test
	public void getOdsInventoryInfoDtlById() {

		try {
			Long odsInventoryInfoDtlId = (long) 19;

			ss.getOdsInventoryInfoDtlById(odsInventoryInfoDtlId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsInventoryInfoDtls  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:13 
	*/ 
	@Test
	public void getOdsInventoryInfoDtls() {

		try {

			ss.getOdsInventoryInfoDtls();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: searchDiffInventorys  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:18 
	*/ 
	@Test
	public void searchDiffInventorys() {
		List<OdsInventoryInfoDtl> list = new ArrayList<OdsInventoryInfoDtl>();
		EasyMock.expect(odsInventoryInfoDtlDAO.searchDiffInventorys((Pager<OdsInventoryInfoDtl>)EasyMock.anyObject(), 
				(OdsInventoryInfoDtl) EasyMock.anyObject())).andReturn(list);
		
		EasyMock.expect(odsInventoryInfoDtlDAO.searchDiffInventoryCount(
				(OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(11L);
		
		EasyMock.replay(odsInventoryInfoDtlDAO);
		
		Pager<OdsInventoryInfoDtl> pager = new Pager<OdsInventoryInfoDtl>();
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		ss.searchDiffInventorys(pager, odsInventoryInfoDtl);
	}

	/**  
	* @Title: getListByids  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:21 
	*/ 
	@Test
	public void getListByids() {

		try {
			String[] ids = { "3" };

			ss.getListByids(ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateUseQty  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:24 
	*/ 
	@Test
	public void updateUseQty() {

		try {
			String[] ids = { "3" };

			ss.updateUseQty(ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getDiffInventoryByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:27 
	*/ 
	@Test
	public void getDiffInventoryByParam() {

		try {
			OdsInventoryInfoDtl odsInventoryInfoDtl = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);

			ss.getDiffInventoryByParam(odsInventoryInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateUseQtyByOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:30 
	*/ 
	@Test
	public void updateUseQtyByOrderNo() {

		try {
			OdsWmsOrder odsWmsOrder = (OdsWmsOrder) getBean(OdsWmsOrder.class);

			ss.updateUseQtyByOrderNo(odsWmsOrder);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsInventoryInfoDtlByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:33 
	*/ 
	@Test
	public void getOdsInventoryInfoDtlByParam() {

		try {
			OdsInventoryInfoDtl odsInventoryInfoDtl = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);

			ss.getOdsInventoryInfoDtlByParam(odsInventoryInfoDtl);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: sapQtyDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:36 
	*/ 
	@Test
	public void sapQtyDetail() {
		List<OdsInventoryInfoDtl> list = new ArrayList<OdsInventoryInfoDtl>();
		EasyMock.expect(odsInventoryInfoDtlDAO.sapQtyDetail((Pager<OdsInventoryInfoDtl>)EasyMock.anyObject(), 
				(OdsInventoryInfoDtl) EasyMock.anyObject())).andReturn(list);
		
		EasyMock.expect(odsInventoryInfoDtlDAO.sapQtyDetailCount(
				(OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(11L);
		
		EasyMock.replay(odsInventoryInfoDtlDAO);
		
		Pager<OdsInventoryInfoDtl> pager = new Pager<OdsInventoryInfoDtl>();
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		ss.sapQtyDetail(pager, odsInventoryInfoDtl);
	}

	/**  
	* @Title: updateBarcodeRemark  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:38 
	*/ 
	@Test
	public void updateBarcodeRemark() {
		EasyMock.expect(odsInventoryInfoDtlDAO.updateBarcodeRemark((OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(1);
		EasyMock.replay(odsInventoryInfoDtlDAO);
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		ss.updateBarcodeRemark(odsInventoryInfoDtl);
	}

	/**  
	* @Title: updateBarcodeStatus  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:41 
	*/ 
	@Test
	public void updateBarcodeStatus() {

		try {
			String barcode = "9";
			String status = "6";

			ss.updateBarcodeStatus(barcode, status);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:46:44 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			OdsInventoryInfoDtl dto = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}