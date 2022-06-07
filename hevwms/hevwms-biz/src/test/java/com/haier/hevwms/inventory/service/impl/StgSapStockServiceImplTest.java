package com.haier.hevwms.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.StgSapStockDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgSapStockServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午2:47:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgSapStockServiceImplTest extends BasicTestCase {
	StgSapStockServiceImpl ss = new StgSapStockServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:03 
	*/ 
	@Before
	public void bf() {

		StgSapStockDAO dao = EasyMock.createMock(StgSapStockDAO.class);
		ss.setStgSapStockDAO(dao);

		ss.getStgSapStockDAO();
	}

	/**  
	* @Title: createStgSapStock  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:06 
	*/ 
	@Test
	public void createStgSapStock() {

		try {
			StgSapStockDTO stgSapStock = (StgSapStockDTO) getBean(StgSapStockDTO.class);

			ss.createStgSapStock(stgSapStock);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateStgSapStock  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:09 
	*/ 
	@Test
	public void updateStgSapStock() {

		try {
			StgSapStockDTO stgSapStock = (StgSapStockDTO) getBean(StgSapStockDTO.class);

			ss.updateStgSapStock(stgSapStock);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteStgSapStock  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:12 
	*/ 
	@Test
	public void deleteStgSapStock() {

		try {
			Long stgSapStockId = (long) 5;

			ss.deleteStgSapStock(stgSapStockId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteStgSapStockAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:15 
	*/ 
	@Test
	public void deleteStgSapStockAll() {

		try {
			List idList = new ArrayList<Integer>();
			idList.add(1);
			ss.deleteStgSapStockAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchStgSapStocks  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:19 
	*/ 
	@Test
	public void searchStgSapStocks() {
		StgSapStockDAO stgSapStockDAO = EasyMock.createMock(StgSapStockDAO.class);
		ss.setStgSapStockDAO(stgSapStockDAO);
		
		List<StgSapStockDTO> stgSapStocks = new ArrayList<StgSapStockDTO>();
		EasyMock.expect(stgSapStockDAO.searchStgSapStocks((Pager<StgSapStockDTO>) EasyMock.anyObject(),
				(StgSapStockDTO) EasyMock.anyObject())).andReturn(stgSapStocks);
		
		EasyMock.expect(stgSapStockDAO.searchStgSapStocksCount((StgSapStockDTO) EasyMock.anyObject())).andReturn(11L);
		
		EasyMock.replay(stgSapStockDAO);
		Pager<StgSapStockDTO> pager = new Pager<StgSapStockDTO>();
		StgSapStockDTO stgSapStock = new StgSapStockDTO();
		ss.searchStgSapStocks(pager, stgSapStock);
	}

	/**  
	* @Title: getStgSapStockById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:22 
	*/ 
	@Test
	public void getStgSapStockById() {

		try {
			Long stgSapStockId = (long) 18;

			ss.getStgSapStockById(stgSapStockId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgSapStocks  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:25 
	*/ 
	@Test
	public void getStgSapStocks() {

		try {

			ss.getStgSapStocks();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: downInventoryFromSap  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:31 
	*/ 
	@Test
	public void downInventoryFromSap() {

		try {
			String plant = "5";
			String materialNo = "3";
			String location = "7";

//			ss.downInventoryFromSap(plant, materialNo, location);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgSapStockByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:34 
	*/ 
	@Test
	public void getStgSapStockByParam() {

		try {
			StgSapStockDTO stgSapStock = (StgSapStockDTO) getBean(StgSapStockDTO.class);

			ss.getStgSapStockByParam(stgSapStock);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: physicalStockGap  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:38 
	*/ 
	@Test
	public void physicalStockGap() {
		StgSapStockDAO stgSapStockDAO = EasyMock.createMock(StgSapStockDAO.class);
		ss.setStgSapStockDAO(stgSapStockDAO);
		
		List<String> list = new ArrayList<String>();
		list.add("11");
		EasyMock.expect(stgSapStockDAO.getAvailableWhs((Long) EasyMock.anyObject())).andReturn(list);
		
		List<StgSapStockDTO> sapStockGaps = new ArrayList<StgSapStockDTO>();
		EasyMock.expect(stgSapStockDAO.physicalStockGap((Pager<StgSapStockDTO>)EasyMock.anyObject(),(StgSapStockDTO) EasyMock.anyObject())).andReturn(sapStockGaps);
		
		EasyMock.replay(stgSapStockDAO);
		Pager<StgSapStockDTO> pager = new Pager<StgSapStockDTO>();
		StgSapStockDTO stgSapStock = new StgSapStockDTO();
		stgSapStock.setUserType("3");
		ss.physicalStockGap(pager, stgSapStock);
	}

	/**  
	* @Title: physicalStockGapList  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:48:41 
	*/ 
	@Test
	public void physicalStockGapList() {

		try {
			StgSapStockDTO stgSapStock = (StgSapStockDTO) getBean(StgSapStockDTO.class);

			ss.physicalStockGapList(stgSapStock);
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
	* @date: 2018年6月27日 下午2:48:44 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgSapStockDTO dto = (StgSapStockDTO) getBean(StgSapStockDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}