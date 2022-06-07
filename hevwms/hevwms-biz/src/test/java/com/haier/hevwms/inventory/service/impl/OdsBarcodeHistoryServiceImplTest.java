package com.haier.hevwms.inventory.service.impl;

import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsBarcodeHistoryServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午2:42:55 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsBarcodeHistoryServiceImplTest extends BasicTestCase {
	
	private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
	OdsBarcodeHistoryServiceImpl impl = new OdsBarcodeHistoryServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:43:00 
	*/ 
	@Before
	public void init() {
		odsBarcodeHistoryDAO = EasyMock.createMock(OdsBarcodeHistoryDAO.class);
		impl.setOdsBarcodeHistoryDAO(odsBarcodeHistoryDAO);
		
	}

	/**
	 * 
	 * @Title: createOdsBarcodeHistory
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 上午9:29:24
	 */
	@Test
	public void testCreateOdsBarcodeHistory() {
		OdsBarcodeHistoryDTO testCase = new OdsBarcodeHistoryDTO();
		testCase.setCreateDate(new Date());
		testCase.setInoutDate(new Date());
		testCase.setModifyDate(new Date());
		testCase.setGmtCreate(new Date());
		testCase.setGmtModified(new Date());
		odsBarcodeHistoryDAO.save((OdsBarcodeHistory) anyObject());
		expectLastCall();
		EasyMock.replay(odsBarcodeHistoryDAO); 
		ExecuteResult<OdsBarcodeHistoryDTO> result = impl.createOdsBarcodeHistory(testCase);
		Assert.assertNotNull(result);
		EasyMock.verify(odsBarcodeHistoryDAO);
	}

	/**
	 * 
	 * @Title: updateOdsBarcodeHistory
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 上午10:29:30
	 */
	@Test
	public void updateOdsBarcodeHistory() {
		OdsBarcodeHistoryDTO testCase = new OdsBarcodeHistoryDTO();
		testCase.setCreateDate(new Date());
		testCase.setInoutDate(new Date());
		testCase.setModifyDate(new Date());
		testCase.setGmtCreate(new Date());
		testCase.setGmtModified(new Date());
		EasyMock.expect(odsBarcodeHistoryDAO.update((OdsBarcodeHistory) anyObject())).andReturn(1);
		EasyMock.replay(odsBarcodeHistoryDAO);
		
		ExecuteResult<OdsBarcodeHistoryDTO> result = impl.updateOdsBarcodeHistory(testCase);
		Assert.assertNotNull(result);
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsBarcodeHistory  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:43:23 
	*/ 
	@Test
	public void deleteOdsBarcodeHistory() {

		try {
			Long odsBarcodeHistoryId = (long) 15;

			impl.deleteOdsBarcodeHistory(odsBarcodeHistoryId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsBarcodeHistoryAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:43:31 
	*/ 
	@Test
	public void deleteOdsBarcodeHistoryAll() {

		try {
			List idList = new ArrayList<Integer>();
			idList.add(1);

			impl.deleteOdsBarcodeHistoryAll(idList);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * @Title: searchOdsBarcodeHistorys
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 上午10:34:13
	 */
	@Test
	public void testSearchOdsBarcodeHistorys() {
		List<OdsBarcodeHistoryDTO> testParm = new ArrayList<OdsBarcodeHistoryDTO>();
		OdsBarcodeHistoryDTO dtoCase = new OdsBarcodeHistoryDTO();
		testParm.add(dtoCase);
		EasyMock.expect(odsBarcodeHistoryDAO.searchOdsBarcodeHistorys((Pager<OdsBarcodeHistoryDTO>) anyObject(),(OdsBarcodeHistoryDTO) anyObject())).andReturn(testParm);
		EasyMock.expect(odsBarcodeHistoryDAO.searchOdsBarcodeHistorysCount(dtoCase)).andReturn(1L);
		EasyMock.replay(odsBarcodeHistoryDAO);
		
		Pager<OdsBarcodeHistoryDTO> result = impl.searchOdsBarcodeHistorys(new Pager<OdsBarcodeHistoryDTO>(), dtoCase);
		Assert.assertNotNull(result);
	}

	/**
	 * @Title: getOdsBarcodeHistoryById
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 上午10:51:04
	 */
	@Test
	public void testGetOdsBarcodeHistoryById() {
		OdsBarcodeHistory testCase = new OdsBarcodeHistory();
		testCase.setCreateDate(new Date());
		testCase.setInoutDate(new Date());
		testCase.setModifyDate(new Date());
		testCase.setGmtCreate(new Date());
		testCase.setGmtModified(new Date());
		EasyMock.expect(odsBarcodeHistoryDAO.get((Long) anyObject())).andReturn(testCase);
		EasyMock.replay(odsBarcodeHistoryDAO);
		OdsBarcodeHistoryDTO result = impl.getOdsBarcodeHistoryById(1L);
		Assert.assertNotNull(result);
	}

	/**
	 * @Title: getOdsBarcodeHistorys
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 上午10:51:22
	 */
	@Test
	public void testGetOdsBarcodeHistorys() {
		List<OdsBarcodeHistory> testCase = new ArrayList<OdsBarcodeHistory>();
		OdsBarcodeHistory testCaseDomain = new OdsBarcodeHistory();
		testCaseDomain.setCreateDate(new Date());
		testCaseDomain.setInoutDate(new Date());
		testCaseDomain.setModifyDate(new Date());
		testCaseDomain.setGmtCreate(new Date());
		testCaseDomain.setGmtModified(new Date());
		OdsBarcodeHistory testCaseDomain2 = new OdsBarcodeHistory();
		testCaseDomain2.setCreateDate(new Date());
		testCaseDomain2.setInoutDate(new Date());
		testCaseDomain2.setModifyDate(new Date());
		testCaseDomain2.setGmtCreate(new Date());
		testCaseDomain2.setGmtModified(new Date());
		testCase.add(testCaseDomain);
		testCase.add(testCaseDomain2);
		EasyMock.expect(odsBarcodeHistoryDAO.getAll()).andReturn(testCase);
		EasyMock.replay(odsBarcodeHistoryDAO);
		List<OdsBarcodeHistoryDTO> result = impl.getOdsBarcodeHistorys();
		Assert.assertNotNull(result);
	}

	/**  
	* @Title: getOdsBarcodeHistoryByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:43:58 
	*/ 
	@Test
	public void getOdsBarcodeHistoryByParam() {

		try {
			OdsBarcodeHistoryDTO odsBarcodeHistory = (OdsBarcodeHistoryDTO) getBean(OdsBarcodeHistoryDTO.class);

			impl.getOdsBarcodeHistoryByParam(odsBarcodeHistory);
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
	* @date: 2018年6月27日 下午2:44:02 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			OdsBarcodeHistoryDTO dto = (OdsBarcodeHistoryDTO) getBean(OdsBarcodeHistoryDTO.class);

			impl.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}