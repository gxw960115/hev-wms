package com.haier.hevwms.takestock.service.impl;

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
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.dao.OdsPdInfoDAO;
import com.haier.hevwms.takestock.dao.OdsPdInfoDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsPdInfoServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:25:06 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsPdInfoServiceTest extends BasicTestCase {
	OdsPdInfoServiceImpl ss = new OdsPdInfoServiceImpl();
	private OdsPdInfoDAO odsPdInfoDAO;// 库存盘点单
	private OdsPdInfoDtlDAO odsPdInfoDtlDAO;// 库存盘点单明细
	private OdsPdDiffDtlDAO odsPdDiffDtlDAO;// 库存盘点单差异明细
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:09 
	*/ 
	@Before
	public void bf() {

		odsPdInfoDAO = EasyMock.createMock(OdsPdInfoDAO.class);
		odsPdInfoDtlDAO = EasyMock.createMock(OdsPdInfoDtlDAO.class);
		odsPdDiffDtlDAO = EasyMock.createMock(OdsPdDiffDtlDAO.class);
		odsInventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		ss.setOdsPdInfoDAO(odsPdInfoDAO);
		ss.setOdsPdInfoDtlDAO(odsPdInfoDtlDAO);
		ss.setOdsPdDiffDtlDAO(odsPdDiffDtlDAO);
		ss.setOdsInventoryInfoDtlDAO(odsInventoryInfoDtlDAO);
		ss.getOdsPdInfoDAO();
		ss.getOdsPdInfoDtlDAO();
		ss.getOdsPdDiffDtlDAO();
		ss.getOdsInventoryInfoDtlDAO();

	}

	/**  
	* @Title: createOdsPdInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:16 
	*/ 
	@Test
	public void createOdsPdInfo() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			EasyMock.expect(odsPdInfoDAO.quertPdCountByParam(EasyMock.isA(OdsPdInfo.class))).andReturn(1);
			EasyMock.replay(odsPdInfoDAO);
			ss.createOdsPdInfo(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createOdsPdInfo1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:20 
	*/ 
	@Test
	public void createOdsPdInfo1() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			EasyMock.expect(odsPdInfoDAO.quertPdCountByParam(EasyMock.isA(OdsPdInfo.class))).andReturn(0);
			odsPdInfoDAO.save(EasyMock.isA(OdsPdInfo.class));
			EasyMock.expectLastCall().anyTimes();
			EasyMock.replay(odsPdInfoDAO);
			ss.createOdsPdInfo(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOdsPdInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:28 
	*/ 
	@Test
	public void updateOdsPdInfo() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			EasyMock.expect(odsPdInfoDAO.update(EasyMock.isA(OdsPdInfo.class))).andReturn(0);

			EasyMock.replay(odsPdInfoDAO);
			ss.updateOdsPdInfo(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:35 
	*/ 
	@Test
	public void deleteOdsPdInfo() {

		try {
			Long odsPdInfoId = (long) 9;
			EasyMock.expect(odsPdInfoDAO.delete(EasyMock.anyLong())).andReturn(0);

			EasyMock.replay(odsPdInfoDAO);
			ss.deleteOdsPdInfo(odsPdInfoId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsPdInfoAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:42 
	*/ 
	@Test
	public void deleteOdsPdInfoAll() {

		try {
			List idList = new ArrayList<Long>();
			idList.add(2L);
			odsPdInfoDAO.deleteAll(EasyMock.isA(ArrayList.class));
			EasyMock.expectLastCall().anyTimes();
			ss.deleteOdsPdInfoAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:25:48 
	*/ 
	@Test
	public void searchOdsPdInfos() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			List<OdsPdInfo> odsPdInfos = new ArrayList<OdsPdInfo>();
			EasyMock.expect(odsPdInfoDAO.searchOdsPdInfosCount(EasyMock.isA(OdsPdInfo.class))).andReturn(0L);
			EasyMock.expect(odsPdInfoDAO.searchOdsPdInfos(EasyMock.isA(Pager.class), EasyMock.isA(OdsPdInfo.class)))
					.andReturn(odsPdInfos);

			EasyMock.replay(odsPdInfoDAO);
			ss.searchOdsPdInfos(pager, odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);
	}

	/**  
	* @Title: getOdsPdInfoById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:04 
	*/ 
	@Test
	public void getOdsPdInfoById() {

		try {
			Long odsPdInfoId = (long) 14;

			ss.getOdsPdInfoById(odsPdInfoId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:13 
	*/ 
	@Test
	public void getOdsPdInfos() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);

			ss.getOdsPdInfos(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: findPdNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:21 
	*/ 
	@Test
	public void findPdNo() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			List<OdsPdInfo> odsPdInfos = new ArrayList<OdsPdInfo>();

			EasyMock.expect(odsPdInfoDAO.getListByParams(EasyMock.isA(OdsPdInfo.class))).andReturn(odsPdInfos);

			EasyMock.replay(odsPdInfoDAO);
			ss.findPdNo();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: findPdNo1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:25 
	*/ 
	@Test
	public void findPdNo1() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			List<OdsPdInfo> odsPdInfos = new ArrayList<OdsPdInfo>();
			odsPdInfos.add(odsPdInfo);
			EasyMock.expect(odsPdInfoDAO.getListByParams(EasyMock.isA(OdsPdInfo.class))).andReturn(odsPdInfos);

			EasyMock.replay(odsPdInfoDAO);
			ss.findPdNo();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: saveOdsPds  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:34 
	*/ 
	@Test
	public void saveOdsPds() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);

			List<OdsPdInfo> odsPdInfos = new ArrayList<OdsPdInfo>();
			odsPdInfos.add(odsPdInfo);
			odsPdInfoDAO.save(EasyMock.isA(OdsPdInfo.class));
			EasyMock.expectLastCall().anyTimes();
			ss.saveOdsPds(odsPdInfo, odsPdInfos);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOrderStatus  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:42 
	*/ 
	@Test
	public void updateOrderStatus() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			EasyMock.expect(odsPdInfoDAO.updateOrderStatus(EasyMock.isA(OdsPdInfo.class))).andReturn(2);

			odsPdDiffDtlDAO.deleteByPdNo(EasyMock.isA(String.class));
			EasyMock.expectLastCall().anyTimes();
			odsPdInfo.setOrderStatus("2");
			OdsPdInfo odsPdInfo1 = (OdsPdInfo) getBean(OdsPdInfo.class);
			List<OdsPdInfo> odsPdInfos1 = new ArrayList<OdsPdInfo>();
			odsPdInfos1.add(odsPdInfo1);
			EasyMock.expect(odsPdInfoDAO.getListByParams(EasyMock.isA(OdsPdInfo.class))).andReturn(odsPdInfos1);
			List<OdsPdInfoDtl> pdDtls = new ArrayList<OdsPdInfoDtl>();
			OdsPdInfoDtl o = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);
			o.setInveBarcode(null);
			pdDtls.add(o);
			EasyMock.expect(odsPdInfoDtlDAO.getDiff(EasyMock.isA(OdsPdInfo.class))).andReturn(pdDtls);
			EasyMock.expect(odsPdInfoDtlDAO.get(EasyMock.anyLong())).andReturn(o);
			odsPdDiffDtlDAO.save(EasyMock.isA(OdsPdDiffDtl.class));
			EasyMock.expectLastCall().anyTimes();
			EasyMock.replay(odsPdInfoDAO, odsPdDiffDtlDAO, odsPdInfoDtlDAO);
			ss.updateOrderStatus(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOrderStatus1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:48 
	*/ 
	@Test
	public void updateOrderStatus1() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);
			EasyMock.expect(odsPdInfoDAO.updateOrderStatus(EasyMock.isA(OdsPdInfo.class))).andReturn(2);

			odsPdDiffDtlDAO.deleteByPdNo(EasyMock.isA(String.class));
			EasyMock.expectLastCall().anyTimes();
			odsPdInfo.setOrderStatus("2");
			OdsPdInfo odsPdInfo1 = (OdsPdInfo) getBean(OdsPdInfo.class);
			List<OdsPdInfo> odsPdInfos1 = new ArrayList<OdsPdInfo>();
			odsPdInfos1.add(odsPdInfo1);
			EasyMock.expect(odsPdInfoDAO.getListByParams(EasyMock.isA(OdsPdInfo.class))).andReturn(odsPdInfos1);
			List<OdsPdInfoDtl> pdDtls = new ArrayList<OdsPdInfoDtl>();
			OdsPdInfoDtl o = (OdsPdInfoDtl) getBean(OdsPdInfoDtl.class);
			o.setInveBarcode("1");
			o.setBarcode(null);
			pdDtls.add(o);
			EasyMock.expect(odsPdInfoDtlDAO.getDiff(EasyMock.isA(OdsPdInfo.class))).andReturn(pdDtls);
			EasyMock.expect(odsPdInfoDtlDAO.get(EasyMock.anyLong())).andReturn(o);
			odsPdDiffDtlDAO.save(EasyMock.isA(OdsPdDiffDtl.class));
			EasyMock.expectLastCall().anyTimes();
			OdsInventoryInfoDtl inve = (OdsInventoryInfoDtl) getBean(OdsInventoryInfoDtl.class);
			EasyMock.expect(odsInventoryInfoDtlDAO.get(EasyMock.anyLong())).andReturn(inve);

			EasyMock.replay(odsPdInfoDAO, odsPdDiffDtlDAO, odsPdInfoDtlDAO, odsInventoryInfoDtlDAO);
			ss.updateOrderStatus(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsPdInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:26:55 
	*/ 
	@Test
	public void getOdsPdInfo() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);

			ss.getOdsPdInfo(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: selectStocktakingOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:01 
	*/ 
	@Test
	public void selectStocktakingOrderNo() {

		try {
			EasyMock.expect(odsPdInfoDAO.selectStocktakingOrderNo(EasyMock.isA(String.class))).andReturn("1234");

			EasyMock.replay(odsPdInfoDAO);
			ss.selectStocktakingOrderNo();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:08 
	*/ 
	@Test
	public void deleteOrder() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);

			EasyMock.expect(odsPdInfoDAO.updateOrderStatus(EasyMock.isA(OdsPdInfo.class))).andReturn(2);
			EasyMock.replay(odsPdInfoDAO);
			ss.deleteOrder(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdInfosCount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:11 
	*/ 
	@Test
	public void searchOdsPdInfosCount() {

		try {
			OdsPdInfo odsPdInfo = (OdsPdInfo) getBean(OdsPdInfo.class);

			ss.searchOdsPdInfosCount(odsPdInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}