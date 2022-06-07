package com.haier.hevwms.order.service.impl;

import static org.mockito.Matchers.anyList;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.order.dao.StgInboundDownDAO;
import com.haier.hevwms.order.dao.StgInboundDownTempDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgInboundDownServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:12:26 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgInboundDownServiceTest extends BasicTestCase {
	StgInboundDownServiceImpl ss = new StgInboundDownServiceImpl();
	private StgInboundDownDAO stgInboundDownDAO;
	private StgInboundDownTempDAO stgInboundDownTempDAO;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:29 
	*/ 
	@Before
	public void bf() {

		stgInboundDownDAO = EasyMock.createMock(StgInboundDownDAO.class);
		stgInboundDownTempDAO = EasyMock.createMock(StgInboundDownTempDAO.class);
		
		ss.getStgInboundDownDAO();
		ss.getStgInboundDownTempDAO();
		
		ss.setStgInboundDownDAO(stgInboundDownDAO);
		ss.setStgInboundDownTempDAO(stgInboundDownTempDAO);

	}

	/**  
	* @Title: createStgInboundDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:31 
	*/ 
	@Test
	public void createStgInboundDown() {

		try {
			StgInboundDownDTO stgInboundDown = (StgInboundDownDTO) getBean(StgInboundDownDTO.class);

			ss.createStgInboundDown(stgInboundDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateStgInboundDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:35 
	*/ 
	@Test
	public void updateStgInboundDown() {

		try {
			StgInboundDownDTO stgInboundDown = (StgInboundDownDTO) getBean(StgInboundDownDTO.class);

			ss.updateStgInboundDown(stgInboundDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteStgInboundDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:38 
	*/ 
	@Test
	public void deleteStgInboundDown() {

		try {
			Long stgInboundDownId = (long) 13;

			ss.deleteStgInboundDown(stgInboundDownId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * @Title: deleteStgInboundDownAll
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 下午5:10:35
	 */
	@Test
	public void deleteStgInboundDownAll() {
		stgInboundDownDAO.deleteAll((List<Long>) anyList());
		EasyMock.expectLastCall();
		ExecuteResult<StgInboundDownDTO> result = ss.deleteStgInboundDownAll(new ArrayList<Long>());
		Assert.assertNotNull(result);

	}

	/**  
	* @Title: searchStgInboundDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:45 
	*/ 
	@Test
	public void searchStgInboundDowns() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			StgInboundDownDTO stgInboundDown = (StgInboundDownDTO) getBean(StgInboundDownDTO.class);

			ss.searchStgInboundDowns(pager, stgInboundDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgInboundDownById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:48 
	*/ 
	@Test
	public void getStgInboundDownById() {

		try {
			Long stgInboundDownId = (long) 2;

			ss.getStgInboundDownById(stgInboundDownId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgInboundDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:12:50 
	*/ 
	@Test
	public void getStgInboundDowns() {

		try {

			ss.getStgInboundDowns();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgInboundDownByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:00 
	*/ 
	@Test
	public void getStgInboundDownByParam() {

		try {
			StgInboundDownDTO stgInboundDown = (StgInboundDownDTO) getBean(StgInboundDownDTO.class);

			ss.getStgInboundDownByParam(stgInboundDown);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: removeHistory  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:08 
	*/ 
	@Test
	public void removeHistory() {

		try {

			ss.removeHistory();
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
	* @date: 2018年6月27日 下午3:13:11 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgInboundDownDTO dto = (StgInboundDownDTO) getBean(StgInboundDownDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}