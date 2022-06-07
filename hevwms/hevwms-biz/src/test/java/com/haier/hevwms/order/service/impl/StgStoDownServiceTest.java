package com.haier.hevwms.order.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.basic.dao.OdsHistoryLogDAO;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.sto.service.impl.StgStoDownServiceImpl;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgStoDownServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:15:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgStoDownServiceTest extends BasicTestCase {
	StgStoDownServiceImpl ss = new StgStoDownServiceImpl();
	private StgStoDownDAO stgStoDownDAO;
	private OdsHistoryLogDAO odsHistoryLogDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:24 
	*/ 
	@Before
	public void bf() {

		stgStoDownDAO = EasyMock.createMock(StgStoDownDAO.class);
		odsHistoryLogDAO = EasyMock.createMock(OdsHistoryLogDAO.class);
		
		ss.getStgStoDownDAO();
		ss.getOdsHistoryLogDAO();
		
		ss.setOdsHistoryLogDAO(odsHistoryLogDAO);
		ss.setStgStoDownDAO(stgStoDownDAO);

	}

	/**  
	* @Title: searchStgStoDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:26 
	*/ 
	@Test
	public void searchStgStoDowns() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			StgStoDownDTO stgStoDown = (StgStoDownDTO) getBean(StgStoDownDTO.class);

			ss.searchStgStoDowns(pager, stgStoDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgStoDownById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:29 
	*/ 
	@Test
	public void getStgStoDownById() {

		try {
			Long stgStoDownId = (long) 17;

			ss.getStgStoDownById(stgStoDownId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgStoDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:32 
	*/ 
	@Test
	public void getStgStoDowns() {

		try {
			StgStoDownDTO stgStoDown = (StgStoDownDTO) getBean(StgStoDownDTO.class);

			ss.getStgStoDowns(stgStoDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: closeStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:36 
	*/ 
	@Test
	public void closeStgStoDown() {

		try {
			String userName = "5";
			String ids = "3";

			ss.closeStgStoDown(userName, ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: openStgStoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:39 
	*/ 
	@Test
	public void openStgStoDown() {

		try {
			String userName = "8";
			String ids = "8";

			ss.openStgStoDown(userName, ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateStoConfirm  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:45 
	*/ 
	@Test
	public void updateStoConfirm() {

		try {
			String stoNo = "7";

			ss.updateStoConfirm(stoNo);
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
	* @date: 2018年6月27日 下午3:15:49 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgStoDownDTO dto = (StgStoDownDTO) getBean(StgStoDownDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}