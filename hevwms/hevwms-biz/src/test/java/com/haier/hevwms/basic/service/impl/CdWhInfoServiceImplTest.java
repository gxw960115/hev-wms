package com.haier.hevwms.basic.service.impl;

import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.basic.dao.CdWhInfoDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;


/**   
* Copyright: Copyright (c) 2018 SJK
* 
* @ClassName: CdWhInfoServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: SJK
* @date: 2018年4月28日 上午9:45:32 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年4月28日     SJK           v1.0.0               修改原因
*/
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class) 
public class CdWhInfoServiceImplTest {
	private CdWhInfoDAO cdWhInfoDAO;
	private CdLocInfoDAO cdLocInfoDAO;
	private CdWhInfoServiceImpl cdWhInfoServiceImpl = new CdWhInfoServiceImpl();
	private UserDAO userDAO;
	/**  
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:47:17 
	*/ 
	@Before
	public void init(){
		userDAO = createMock(UserDAO.class);
		cdWhInfoDAO = createMock(CdWhInfoDAO.class);
		cdLocInfoDAO = createMock(CdLocInfoDAO.class);
		cdWhInfoServiceImpl.setCdWhInfoDAO(cdWhInfoDAO);
		cdWhInfoServiceImpl.setCdLocInfoDAO(cdLocInfoDAO);
		cdWhInfoServiceImpl.setUserDAO(userDAO);
		mockStatic(UserUtil.class); 
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
	}
	
	/**  
	* @Title: testCreateCdWhInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:47:21 
	*/ 
	@Test
	public void testCreateCdWhInfo() {
		cdWhInfoDAO.save((CdWhInfoDTO) anyObject());
		expectLastCall();
		expect(cdWhInfoDAO.getMaxRowId()).andReturn(9999L);
		cdLocInfoDAO.updateParentId(anyLong(), (String[]) anyObject());
		expectLastCall();
		replay(cdWhInfoDAO);
		replay(cdLocInfoDAO);
		String result = cdWhInfoServiceImpl.createCdWhInfo(new CdWhInfoDTO());
		assertEquals(result, "true");
		verify(cdWhInfoDAO);
		verify(cdLocInfoDAO);
	}

	/**  
	* @Title: testUpdateCdWhInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:26 
	*/ 
	@Test
	public void testUpdateCdWhInfo() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		CdLocInfoDTO temp = new CdLocInfoDTO();
		temp.setRowId(9999L);
		expectList.add(temp);
		expect(cdWhInfoDAO.update((CdWhInfoDTO) anyObject())).andReturn(1);
		expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(anyLong(), eq(""))).andReturn(expectList);
		cdLocInfoDAO.updateParentId(anyLong(), (String[])anyObject());
		expectLastCall().times(2);
		replay(cdWhInfoDAO);
		replay(cdLocInfoDAO);
		String result = cdWhInfoServiceImpl.updateCdWhInfo(new CdWhInfoDTO());
		assertEquals(result, "true");
		verify(cdWhInfoDAO);
		verify(cdLocInfoDAO);
	}

	/**  
	* @Title: testDeleteCdWhInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:31 
	*/ 
	@Test
	public void testDeleteCdWhInfo() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		CdLocInfoDTO temp = new CdLocInfoDTO();
		temp.setRowId(9999L);
		expectList.add(temp);
		expect(cdWhInfoDAO.delete(anyLong())).andReturn(1);
		expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(anyLong(), eq(""))).andReturn(expectList);
		cdLocInfoDAO.updateParentId(anyLong(), (String[])anyObject());
		expectLastCall();
		replay(cdWhInfoDAO);
		replay(cdLocInfoDAO);
		String result = cdWhInfoServiceImpl.deleteCdWhInfo(9999L);
		assertEquals(result, "true");
		verify(cdWhInfoDAO);
		verify(cdLocInfoDAO);
	}

	/**  
	* @Title: testDeleteCdWhInfoAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:35 
	*/ 
	@Test
	public void testDeleteCdWhInfoAll() {
		cdWhInfoDAO.deleteAll((List<Long>) anyObject());
		expectLastCall();
		replay(cdWhInfoDAO);
		String result = cdWhInfoServiceImpl.deleteCdWhInfoAll(new ArrayList<Long>());
		assertEquals(result, "true");
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testSearchCdWhInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:41 
	*/ 
	@Test
	public void testSearchCdWhInfos() {
		Pager<CdWhInfoDTO> param = new Pager<CdWhInfoDTO>();
		param.setCurrentPage(1L);
		param.setPageSize(10L);
		List<CdWhInfoDTO> expectList  = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expect(cdWhInfoDAO.searchCdWhInfos((Pager<CdWhInfoDTO>)anyObject(), (CdWhInfoDTO)anyObject())).andReturn(expectList);
		expect(cdWhInfoDAO.searchCdWhInfosCount((CdWhInfoDTO)anyObject())).andReturn(5L);
		replay(cdWhInfoDAO);
		Pager<CdWhInfoDTO> result = cdWhInfoServiceImpl.searchCdWhInfos(param, new CdWhInfoDTO());
		assertSame(result.getCurrentPage(), 1L);
		assertSame(result.getPageSize(), 10L);
		assertSame(result.getRecords().size(), 3);
		assertSame(result.getTotalRecords(), 5L);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testGetCdWhInfoById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:45 
	*/ 
	@Test
	public void testGetCdWhInfoById() {
		expect(cdWhInfoDAO.get(anyLong())).andReturn(new CdWhInfoDTO());
		replay(cdWhInfoDAO);
		CdWhInfoDTO result = cdWhInfoServiceImpl.getCdWhInfoById(9999L);
		assertNotNull(result);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testSaveOrUpdate  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:48 
	*/ 
	@Test
	public void testSaveOrUpdate() {
		boolean flag = true;
		expect(cdWhInfoDAO.get(anyLong())).andReturn(new CdWhInfoDTO());
		expect(cdWhInfoDAO.update((CdWhInfoDTO) anyObject())).andReturn(1);
		replay(cdWhInfoDAO);
		try {
			cdWhInfoServiceImpl.saveOrUpdate(new CdWhInfoDTO());
		} catch(Exception e){
			flag = false;
		}
		assertTrue(flag);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testGetCdWhInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:52 
	*/ 
	@Test
	public void testGetCdWhInfos() {
		List<CdWhInfoDTO> expectList = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expect(cdWhInfoDAO.getAll()).andReturn(expectList);
		replay(cdWhInfoDAO);
		List<CdWhInfoDTO> result = cdWhInfoServiceImpl.getCdWhInfos();
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testFindUserWhLoc  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:55 
	*/ 
	@Test
	public void testFindUserWhLoc() {
		List<Long> expectList = new ArrayList<Long>();
		expectList.add(9996L);
		expectList.add(9997L);
		expectList.add(9998L);
		expect(cdWhInfoDAO.findCdUserWh((String)anyObject(), anyLong())).andReturn(expectList);
		replay(cdWhInfoDAO);
		HashMap<String, String> result = cdWhInfoServiceImpl.findUserWhLoc("3", 9999L);
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testFindCdUserLoc  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:51:58 
	*/ 
	@Test
	public void testFindCdUserLoc() {
		List<Long> expectList = new ArrayList<Long>();
		expectList.add(9996L);
		expectList.add(9997L);
		expectList.add(9998L);
		expect(cdWhInfoDAO.findCdUserLoc((String)anyObject(), anyLong())).andReturn(expectList);
		replay(cdWhInfoDAO);
		List<Long> result = cdWhInfoServiceImpl.findCdUserLoc("3", 9999L);
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testFindWhLocTree  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:04 
	*/ 
	@Test
	public void testFindWhLocTree() {
		List<Long> expectIdList = new ArrayList<Long>();
		expectIdList.add(9996L);
		expectIdList.add(9997L);
		expectIdList.add(9998L);
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		CdLocInfoDTO temp = new CdLocInfoDTO();
		temp.setParentId(9999L);
		temp.setWhName("TEST");
		expectList.add(temp);
		expectList.add(temp);
		expectList.add(new CdLocInfoDTO());
		expect(cdWhInfoDAO.findCdUserLoc("TEST", 9996L)).andReturn(expectIdList);
		expect(cdLocInfoDAO.getAll()).andReturn(expectList);
		replay(cdWhInfoDAO);
		replay(cdLocInfoDAO);
		
		List result = cdWhInfoServiceImpl.findWhLocTree("TEST", 9996L);
		assertSame(result.size(), 2);
		verify(cdWhInfoDAO);
		verify(cdLocInfoDAO);
	}

	/**  
	* @Title: testSearchCdWhInfosByConditions  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:41 
	*/ 
	@Test
	public void testSearchCdWhInfosByConditions() {
		List<CdWhInfoDTO> expectList = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expect(cdWhInfoDAO.searchCdWhInfos((Pager<CdWhInfoDTO>) anyObject(), (CdWhInfoDTO)anyObject())).andReturn(expectList);
		expect(cdWhInfoDAO.searchCdWhInfosCount((CdWhInfoDTO)anyObject())).andReturn(5L);
		replay(cdWhInfoDAO);
		Pager<CdWhInfoDTO> result = cdWhInfoServiceImpl.searchCdWhInfosByConditions(1L, 10L, new CdWhInfoDTO());
		assertSame(result.getCurrentPage(), 1L);
		assertSame(result.getPageSize(), 10L);
		assertSame(result.getRecords().size(), 3);
		assertSame(result.getTotalRecords(), 5L);
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testSaveOrUpdate2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:45 
	*/ 
	@Test
	public void testSaveOrUpdate2() {
		List<CdWhInfoDTO> paramList = new ArrayList<CdWhInfoDTO>();
		paramList.add(new CdWhInfoDTO());
		paramList.add(new CdWhInfoDTO());
		expect(cdWhInfoDAO.searchCdWhByCode((CdWhInfoDTO) anyObject())).andReturn(new CdWhInfoDTO()).andReturn(null);
		expect(cdWhInfoDAO.update((CdWhInfoDTO) anyObject())).andReturn(1);
		cdWhInfoDAO.save((CdWhInfoDTO) anyObject());
		expectLastCall();
		replay(cdWhInfoDAO);
		String result = cdWhInfoServiceImpl.saveOrUpdate2(paramList, new BaseUser());
		assertTrue(result.startsWith("Import Success"));
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testUpdateWhFlag  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:49 
	*/ 
	@Test
	public void testUpdateWhFlag() {
		cdWhInfoDAO.updateWhFlag((List<Long>) anyObject());
		expectLastCall();
		replay(cdWhInfoDAO);
		String result = cdWhInfoServiceImpl.updateWhFlag(new ArrayList<Long>());
		assertTrue("true".equals(result));
		verify(cdWhInfoDAO);
	}

	/**  
	* @Title: testGetPhysicalWhInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:52 
	*/ 
	@Test
	public void testGetPhysicalWhInfos() {
		List<CdWhInfoDTO> expectList = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expect(cdWhInfoDAO.getAllPhysicalWh()).andReturn(expectList);
		replay(cdWhInfoDAO);
		List<CdWhInfoDTO> result = cdWhInfoServiceImpl.getPhysicalWhInfos();
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}
	
	/**  
	* @Title: testGetPhysicalWhInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:52:52 
	*/ 
	@Test
	public void testFindAvailableWhInfos() {
		UserDTO userExpect = new UserDTO();
		userExpect.setDutyType("3");
		List<CdWhInfoDTO> expectList = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		
		expect(userDAO.get((Long) anyObject())).andReturn(userExpect);
		expect(cdWhInfoDAO.findAvailableWhInfos((Long) anyObject())).andReturn(expectList);
		
		replay(cdWhInfoDAO);
		replay(userDAO);
		
		List<CdWhInfoDTO> result = cdWhInfoServiceImpl.findAvailableWhInfos(999L);
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}
	
	/**
	 * 
	 * @Title: testFindAvailablePhyWhInfos
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月23日 下午5:51:35
	 */
	@Test
	public void testFindAvailablePhyWhInfos() {
		UserDTO userExpect = new UserDTO();
		userExpect.setDutyType("3");
		List<CdWhInfoDTO> expectList = new ArrayList<CdWhInfoDTO>();
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		expectList.add(new CdWhInfoDTO());
		
		expect(userDAO.get((Long) anyObject())).andReturn(userExpect);
		expect(cdWhInfoDAO.findAvailablePhyWhInfos((Long) anyObject())).andReturn(expectList);
		
		replay(cdWhInfoDAO);
		replay(userDAO);
		
		List<CdWhInfoDTO> result = cdWhInfoServiceImpl.findAvailablePhyWhInfos(999L);
		assertSame(result.size(), 3);
		verify(cdWhInfoDAO);
	}
	
}
