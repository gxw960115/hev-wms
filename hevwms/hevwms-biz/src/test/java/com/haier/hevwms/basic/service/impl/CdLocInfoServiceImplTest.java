/**  
 * @Title: CdLocInfoServiceImplTest.java  
 * @Package com.haier.hevwms.basic.service.impl  
 * @Description: (用一句话描述该文件做什么)  
 * @author SJK  
 * @date 2018-4-25  
 * @version V1.0  
 */
package com.haier.hevwms.basic.service.impl;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.easymock.EasyMock.*;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.basic.dao.CdWhInfoDAO;

/**  
 * @ClassName: CdLocInfoServiceImplTest  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2018-4-25  
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class) 
public class CdLocInfoServiceImplTest {
	
	CdLocInfoDAO cdLocInfoDAO;
	CdWhInfoDAO cdWhInfoDAO;
	CdLocInfoServiceImpl cdLocInfoServiceImpl;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void initMock(){
	    cdLocInfoDAO = createMock(CdLocInfoDAO.class);
	    cdWhInfoDAO = createMock(CdWhInfoDAO.class);
	    cdLocInfoServiceImpl = new CdLocInfoServiceImpl();
	    cdLocInfoServiceImpl.setCdLocInfoDAO(cdLocInfoDAO);
	    cdLocInfoServiceImpl.setCdWhInfoDAO(cdWhInfoDAO);
	}
	
	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#getCdLocInfosByParentId(java.lang.Long)}.
	 */
	@Test
	public void testGetCdLocInfosByParentId() {
		List<CdLocInfoDTO> expectListAll = new ArrayList<CdLocInfoDTO>();
		expectListAll.add(new CdLocInfoDTO());
		expectListAll.add(new CdLocInfoDTO());
		expectListAll.add(new CdLocInfoDTO());
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		List<CdLocInfoDTO> resultList = new ArrayList<CdLocInfoDTO>();
		expect(cdLocInfoDAO.getCdLocInfosByParentIdIsNull(anyLong())).andReturn(expectListAll).times(1);
		expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(anyLong(),eq(""))).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		resultList = cdLocInfoServiceImpl.getCdLocInfosByParentId(9999L);
		assertSame(resultList.size(), 5);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#saveOrUpdate(com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO)}.
	 */
	@Test
	public void testSaveOrUpdate() {
		boolean flag = false;
		CdWhInfoDTO expectWh = new CdWhInfoDTO();
		CdLocInfoDTO expectLoc = new CdLocInfoDTO();
		expect(cdWhInfoDAO.searchCdWh((CdWhInfoDTO)anyObject())).andReturn(expectWh).times(1);
		expect(cdLocInfoDAO.searchCdLocation((CdLocInfoDTO)anyObject())).andReturn(expectLoc).times(1);
		expect(cdLocInfoDAO.update((CdLocInfoDTO)anyObject())).andReturn(1).times(1);
		replay(cdLocInfoDAO);
		try{
			cdLocInfoServiceImpl.saveOrUpdate(new CdLocInfoDTO());
			flag = true;
		} catch(Exception e){
			flag = false;
		}
		assertEquals(flag, true);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#saveOrUpdate2(java.util.List, io.terminus.pampas.common.BaseUser)}.
	 */
	@Test
	public void testSaveOrUpdate2() {
		CdWhInfoDTO expectWh = new CdWhInfoDTO();
		CdLocInfoDTO expectLoc = new CdLocInfoDTO();
		List<CdLocInfoDTO> list = new ArrayList<CdLocInfoDTO>();
		list.add(new CdLocInfoDTO());
		expect(cdWhInfoDAO.searchCdWhByCode((CdWhInfoDTO) anyObject())).andReturn(expectWh).times(1);
		expect(cdLocInfoDAO.searchCdLocByCode((CdLocInfoDTO) anyObject())).andReturn(expectLoc).times(1);
		expect(cdLocInfoDAO.update((CdLocInfoDTO)anyObject())).andReturn(1).times(1);
		replay(cdLocInfoDAO);
		String result = cdLocInfoServiceImpl.saveOrUpdate2(list, new BaseUser());
		assertTrue(result.startsWith("Import Success"));
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#findCdLocByCityName(com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO)}.
	 */
	@Test
	public void testFindCdLocByCityName() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expect(cdLocInfoDAO.findCdLocByCityName((CdLocInfoDTO) anyObject())).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		List<CdLocInfoDTO> result = cdLocInfoServiceImpl.findCdLocByCityName(new CdLocInfoDTO());
		assertSame(result.size(), 4);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#getCdTreeByParentId(java.lang.Long, java.lang.String)}.
	 */
	@Test
	public void testGetCdTreeByParentId() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(anyLong(),(String)anyObject())).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		List<CdLocInfoDTO> result = cdLocInfoServiceImpl.getCdTreeByParentId(9999L, "TEST");
		assertSame(result.size(), 4);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#updateFlag(java.util.List)}.
	 */
	@Test
	public void testUpdateFlag() {
		cdLocInfoDAO.updateFlag((List<Long>) anyObject());
		expectLastCall().times(1);
		replay(cdLocInfoDAO);
		String result = cdLocInfoServiceImpl.updateFlag(new ArrayList<Long>());
		assertEquals(result, "success");
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#searchCdLocInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO)}.
	 */
	@Test
	public void testSearchCdLocInfos() {
		Pager<CdLocInfoDTO> result = new Pager<CdLocInfoDTO>();
        List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
        expectList.add(new CdLocInfoDTO());
        Long expectCount = 5L;
        expect(cdLocInfoDAO.searchCdLocInfos((Pager<CdLocInfoDTO>)anyObject(), (CdLocInfoDTO)anyObject())).andReturn(expectList).times(1);
        expect(cdLocInfoDAO.searchCdLocInfosCount((CdLocInfoDTO)anyObject())).andReturn(expectCount).times(1);
        replay(cdLocInfoDAO);
        result = cdLocInfoServiceImpl.searchCdLocInfos(new Pager<CdLocInfoDTO>(), new CdLocInfoDTO());
        assertSame(result.getRecords().size(), 1);
        assertSame(result.getTotalRecords(), 5L);
        verify(cdLocInfoDAO);
        
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#searchCdLocInfoByCondition(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO)}.
	 */
	@Test
	public void testSearchCdLocInfoByCondition() {
		Long page = 1L;
		Long rows = 10L;
		Pager<CdLocInfoDTO> result = new Pager<CdLocInfoDTO>();
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
        expectList.add(new CdLocInfoDTO());
        Long expectCount = 5L;
        expect(cdLocInfoDAO.searchCdLocInfos((Pager<CdLocInfoDTO>)anyObject(), (CdLocInfoDTO)anyObject())).andReturn(expectList).times(1);
        expect(cdLocInfoDAO.searchCdLocInfosCount((CdLocInfoDTO)anyObject())).andReturn(expectCount).times(1);
        replay(cdLocInfoDAO);
        result = cdLocInfoServiceImpl.searchCdLocInfoByCondition(rows, page, new CdLocInfoDTO());
        assertSame(result.getRecords().size(), 1);
        assertSame(result.getTotalRecords(), 5L);
        assertSame(result.getPageSize(), 10L);
        assertSame(result.getCurrentPage(), 1L);
        verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#getCdLocInfos()}.
	 */
	@Test
	public void testGetCdLocInfos() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expect(cdLocInfoDAO.getAll()).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		List<CdLocInfoDTO> result = cdLocInfoServiceImpl.getCdLocInfos();
		assertSame(result.size(), 4);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#selectCdLocTree(long)}.
	 */
	@Test
	public void testSelectCdLocTree() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expect(cdLocInfoDAO.searchCdLocationTree(anyLong(),(String)anyObject())).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		List<CdLocInfoDTO> result = cdLocInfoServiceImpl.selectCdLocTree(9999L, "0");
		assertSame(result.size(), 4);
		verify(cdLocInfoDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#deleteCdLocInfoAll(java.util.List)}.
	 */
	@Test
	public void testDeleteCdLocInfoAll() {
		cdLocInfoDAO.deleteAll((List<Long>) anyObject());
		expectLastCall().times(1);
		replay(cdLocInfoDAO);
		String result = cdLocInfoServiceImpl.deleteCdLocInfoAll(new ArrayList<Long>());
		assertEquals(result, "success");
		verify(cdLocInfoDAO);
	}


	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdLocInfoServiceImpl#findCdLocInfosByWarehouse(java.lang.String)}.
	 */
	@Test
	public void testFindCdLocInfosByWarehouse() {
		List<CdLocInfoDTO> expectList = new ArrayList<CdLocInfoDTO>();
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expectList.add(new CdLocInfoDTO());
		expect(cdLocInfoDAO.findCdLocByWarehouse((String) anyObject())).andReturn(expectList).times(1);
		replay(cdLocInfoDAO);
		List<CdLocInfoDTO> result = cdLocInfoServiceImpl.findCdLocInfosByWarehouse("TEST");
		assertSame(result.size(), 4);
		verify(cdLocInfoDAO);
	}

	
	
	/**
	 * @Title: testCreateCdLocInfo
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月23日 下午4:29:01
	 */
	@Test
	public void testCreateCdLocInfo() {
		mockStatic(UserUtil.class); 
		BaseUser user = new BaseUser();
		user.setName("TEST");
		when(UserUtil.getCurrentUser()).thenReturn(user);
		
		CdLocInfoDTO cdLocInfoDTO = new CdLocInfoDTO();
		cdLocInfoDAO.save((CdLocInfoDTO) anyObject());
		expectLastCall();
		replay(cdLocInfoDAO);
		String result = cdLocInfoServiceImpl.createCdLocInfo(cdLocInfoDTO);
		assertTrue("success".equals(result));
		
		verify(cdLocInfoDAO);
	}
	
	/**
	 * @Title: testUpdateCdLocInfo
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月23日 下午4:32:11
	 */
	@Test
	public void testUpdateCdLocInfo() {
		mockStatic(UserUtil.class); 
		BaseUser user = new BaseUser();
		user.setName("TEST");
		when(UserUtil.getCurrentUser()).thenReturn(user);
		
		CdLocInfoDTO cdLocInfoDTO = new CdLocInfoDTO();
		cdLocInfoDAO.updateById((CdLocInfoDTO) anyObject());
		expectLastCall();
		replay(cdLocInfoDAO);
		String result = cdLocInfoServiceImpl.updateCdLocInfo(cdLocInfoDTO);
		assertTrue("success".equals(result));
		
		verify(cdLocInfoDAO);
	}
}
