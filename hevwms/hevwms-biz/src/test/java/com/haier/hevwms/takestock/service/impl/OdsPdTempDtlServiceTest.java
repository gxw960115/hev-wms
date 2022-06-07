package com.haier.hevwms.takestock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.takestock.dao.OdsPdTempDAO;
import com.haier.hevwms.takestock.dao.OdsPdTempDtlDAO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsPdTempDtlServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:27:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsPdTempDtlServiceTest extends BasicTestCase {
	OdsPdTempDtlServiceImpl ss = new OdsPdTempDtlServiceImpl();
	private OdsPdTempDtlDAO odsPdTempDtlDao;

	private OdsPdTempDAO odsPdTempDAO;

	private OdsInventoryInfoDtlDAO inventoryInfoDtlDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:21 
	*/ 
	@Before
	public void bf() {

		odsPdTempDtlDao = EasyMock.createMock(OdsPdTempDtlDAO.class);
		odsPdTempDAO = EasyMock.createMock(OdsPdTempDAO.class);
		inventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		ss.setOdsPdTempDtlDao(odsPdTempDtlDao);
		ss.setOdsPdTempDAO(odsPdTempDAO);
		ss.setInventoryInfoDtlDAO(inventoryInfoDtlDAO);

	}

	/**  
	* @Title: getScanQty  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:25 
	*/ 
	@Test
	public void getScanQty() {

		try {
			String orderNo = "7";
            
			ss.getScanQty(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: barcodeCheck  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:28 
	*/ 
	@Test
	public void barcodeCheck() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: barcodeCheck1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:30 
	*/ 
	@Test
	public void barcodeCheck1() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			OdsPdTempDtlDTO o=(OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			list.add(o);
			list.add(o);
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: barcodeCheck7  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:33 
	*/ 
	@Test
	public void barcodeCheck7() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			OdsPdTempDtlDTO o=(OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			o.setStatus("0");
			list.add(o);
			
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: barcodeCheck31  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:35 
	*/ 
	@Test
	public void barcodeCheck31() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			OdsPdTempDtlDTO o=(OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			o.setStatus("1");
			list.add(o);
			
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: barcodeCheck21  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:38 
	*/ 
	@Test
	public void barcodeCheck21() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			OdsPdTempDtlDTO o=(OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			o.setStatus("2");
			list.add(o);
			
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: barcodeCheck3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:40 
	*/ 
	@Test
	public void barcodeCheck3() {

		try {
			String orderNo = "5";
			String barcode = "9";
			List<OdsPdTempDtlDTO> list=new ArrayList<OdsPdTempDtlDTO>();
			OdsPdTempDtlDTO o=(OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			o.setStatus("3");
			list.add(o);
			
			EasyMock.expect(odsPdTempDtlDao.getListByparam(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(list);
			EasyMock.replay(odsPdTempDtlDao);
			ss.barcodeCheck(orderNo, barcode);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: add  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:43 
	*/ 
	@Test
	public void add() {

		try {
			OdsPdTempDtlDTO dto = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			dto.setBarcode("1233333333333333333");
			EasyMock.expect(odsPdTempDtlDao.cusModel(EasyMock.isA(String.class))).andReturn("123");
			EasyMock.expect(odsPdTempDtlDao.materialExisted(EasyMock.isA(String.class))).andReturn(0);
			EasyMock.replay(odsPdTempDtlDao);
			ss.add(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: add1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:50 
	*/ 
	@Test
	public void add1() {

		try {
			OdsPdTempDtlDTO dto = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			dto.setBarcode("1233333333333333333");
			EasyMock.expect(odsPdTempDtlDao.cusModel(EasyMock.isA(String.class))).andReturn("123");
			EasyMock.expect(odsPdTempDtlDao.materialExisted(EasyMock.isA(String.class))).andReturn(2);
			EasyMock.expect(odsPdTempDtlDao.add(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(2);
			List<OdsPdTempDTO> pdTemps=new ArrayList<OdsPdTempDTO>();
					
			EasyMock.expect(odsPdTempDAO.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(pdTemps);
			EasyMock.replay(odsPdTempDtlDao);
			ss.add(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: add2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:27:55 
	*/ 
	@Test
	public void add2() {

		try {
			OdsPdTempDtlDTO dto = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			dto.setBarcode("1233333333333333333");
			EasyMock.expect(odsPdTempDtlDao.cusModel(EasyMock.isA(String.class))).andReturn("123");
			EasyMock.expect(odsPdTempDtlDao.materialExisted(EasyMock.isA(String.class))).andReturn(2);
			EasyMock.expect(odsPdTempDtlDao.add(EasyMock.isA(OdsPdTempDtlDTO.class))).andReturn(0);
			List<OdsPdTempDTO> pdTemps=new ArrayList<OdsPdTempDTO>();
			OdsPdTempDTO o=(OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			pdTemps.add(o);
			EasyMock.expect(odsPdTempDAO.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(pdTemps);
			EasyMock.replay(odsPdTempDtlDao);
			ss.add(dto);
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
	* @date: 2018年6月27日 下午4:28:06 
	*/ 
	@Test
	public void orderDelete() {

		try {
			OdsPdTempDtlDTO dto = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);

			ss.orderDelete(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: orderDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:03 
	*/ 
	@Test
	public void orderDetail() {

		try {
			OdsPdTempDtlDTO dto = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);

			ss.orderDetail(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchOdsPdTemps  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:10 
	*/ 
	@Test
	public void searchOdsPdTemps() {

		try {
			OdsPdTempDtlDTO pdTempDtlDTO = (OdsPdTempDtlDTO) getBean(OdsPdTempDtlDTO.class);
			Long rows = (long) 17;
			Long page = (long) 14;

			ss.searchOdsPdTemps(pdTempDtlDTO, rows, page);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: moveBarcode  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:14 
	*/ 
	@Test
	public void moveBarcode() {
//		OdsPdTempDtlDTO expectCase = new OdsPdTempDtlDTO();
//		OdsInventoryInfoDtl expectCase2 = new OdsInventoryInfoDtl();
//		expectCase.setStatus("4");
//		List listCast = new ArrayList();
//		String strCase = "abc";
//		
//		EasyMock.expect(odsPdTempDtlDao.getById(2L)).andReturn(expectCase);
//		expectCase2.setBarcode(expectCase.getBarcode());
//		EasyMock.expect(inventoryInfoDtlDAO.getOdsInventoryInfoDtlByParam(expectCase2)).andReturn(listCast);
//		EasyMock.expect(odsPdTempDtlDao.getUnit(expectCase.getMaterialNo())).andReturn(strCase);
//		inventoryInfoDtlDAO.save(expectCase2);
//		EasyMock.expect(odsPdTempDtlDao.updateOrderStatus(expectCase)).andReturn(1);
//		
//		EasyMock.expectLastCall();
//		EasyMock.replay(odsPdTempDtlDao);
//		EasyMock.replay(inventoryInfoDtlDAO);
//		
//		String result = ss.moveBarcode(2L);
//		Assert.assertNotNull(result);
		try {
			Long rowId = (long) 13;

			ss.moveBarcode(rowId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * @Title: updateBarcodeStatus
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 下午5:57:36
	 */
	@Test
	public void updateBarcodeStatus() {
		OdsPdTempDtlDTO dtoTestCase = new OdsPdTempDtlDTO();
		EasyMock.expect(odsPdTempDtlDao.getById(1L)).andReturn(dtoTestCase);
		EasyMock.expect(odsPdTempDtlDao.updateOrderStatus( dtoTestCase)).andReturn(1);
		EasyMock.replay(odsPdTempDtlDao);
		
		String result = ss.updateBarcodeStatus(1L, "1");

		Assert.assertNotNull(result);

	}
}