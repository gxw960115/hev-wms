/**  
 * @Title: CdFactoryServiceImplTest.java  
 * @Package com.haier.hevwms.basic.service.impl  
 * @Description: (用一句话描述该文件做什么)  
 * @author SJK  
 * @date 2018-4-24  
 * @version V1.0  
 */
package com.haier.hevwms.basic.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.PlantDTO;
import com.haier.hevwms.basic.dao.CdFactoryDAO;
import com.haier.hevwms.basic.domain.CdFactory;

/**  
 * @ClassName: CdFactoryServiceImplTest  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2018-4-24  
 */
public class CdFactoryServiceImplTest{
	
	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#createCdFactory(com.haier.hevwms.basic.domain.CdFactory)}.
	 */
	@Test
	public void testCreateCdFactory() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		ExecuteResult<CdFactory> result = new ExecuteResult<CdFactory>();
		cdFactoryDAO.save((CdFactory) EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.createCdFactory(new CdFactory());
		assertTrue(result.isSuccess());
		assertNotNull(result.getResult());
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#updateCdFactory(com.haier.hevwms.basic.domain.CdFactory)}.
	 */
	@Test
	public void testUpdateCdFactory() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		ExecuteResult<CdFactory> result = new ExecuteResult<CdFactory>();
		EasyMock.expect(cdFactoryDAO.update((CdFactory)EasyMock.anyObject())).andReturn(1).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.updateCdFactory(new CdFactory());
		assertTrue(result.isSuccess());
		assertNotNull(result.getResult());
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#deleteCdFactory(java.lang.Long)}.
	 */
	@Test
	public void testDeleteCdFactory() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		ExecuteResult<CdFactory> result = new ExecuteResult<CdFactory>();
		EasyMock.expect(cdFactoryDAO.delete(EasyMock.anyLong())).andReturn(1).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.deleteCdFactory(9999L);
		assertTrue(result.isSuccess());
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#deleteCdFactoryAll(java.util.List)}.
	 */
	@Test
	public void testDeleteCdFactoryAll() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		ExecuteResult<CdFactory> result = new ExecuteResult<CdFactory>();
		cdFactoryDAO.deleteAll((List<Long>) EasyMock.anyObject());
		EasyMock.expectLastCall();
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.deleteCdFactoryAll(new ArrayList<Long>());
		assertTrue(result.isSuccess());
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#searchCdFactorys(com.haier.openplatform.util.Pager, com.haier.hevwms.basic.domain.CdFactory)}.
	 */
	@Test
	public void testSearchCdFactorys() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		List<CdFactory> expectList = new ArrayList<CdFactory>();
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		List<CdFactory> resultList = new ArrayList<CdFactory>();
		EasyMock.expect(cdFactoryDAO.searchCdFactorys((Pager<CdFactory>)EasyMock.anyObject(), (CdFactory)EasyMock.anyObject()))
			.andReturn(expectList).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		resultList = cdFactoryServiceImpl.searchCdFactorys(new Pager<CdFactory>(), new CdFactory());
		assertNotNull(resultList);
		assertSame(resultList.size(), 4);
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#searchCdFactorysCount(com.haier.hevwms.basic.domain.CdFactory)}.
	 */
	@Test
	public void testSearchCdFactorysCount() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		Long result = 0L;
		EasyMock.expect(cdFactoryDAO.searchCdFactorysCount((CdFactory)EasyMock.anyObject()))
			.andReturn(10L).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.searchCdFactorysCount(new CdFactory());
		assertSame(result, 10L);
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#getCdFactoryById(java.lang.Long)}.
	 */
	@Test
	public void testGetCdFactoryById() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		CdFactory result = new CdFactory();
		CdFactory expectFactory = new CdFactory();
		expectFactory.setCode("TEST");
		EasyMock.expect(cdFactoryDAO.get(EasyMock.anyLong())).andReturn(expectFactory).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		result = cdFactoryServiceImpl.getCdFactoryById(9999L);
		assertNotNull(result);
		assertEquals(result.getCode(), "TEST");
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#getCdFactorys()}.
	 */
	@Test
	public void testGetCdFactorys() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		List<CdFactory> expectList = new ArrayList<CdFactory>();
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		List<CdFactory> resultList = new ArrayList<CdFactory>();
		EasyMock.expect(cdFactoryDAO.getAll()).andReturn(expectList).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		resultList = cdFactoryServiceImpl.getCdFactorys();
		assertNotNull(resultList);
		assertSame(resultList.size(), 4);
		EasyMock.verify(cdFactoryDAO);
	}

	/**
	 * Test method for {@link com.haier.hevwms.basic.service.impl.CdFactoryServiceImpl#searchCdFactorysByParams(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.security.dto.PlantDTO)}.
	 */
	@Test
	public void testSearchCdFactorysByParams() {
		CdFactoryDAO cdFactoryDAO = EasyMock.createMock(CdFactoryDAO.class);
		Pager<PlantDTO> resultPager = new Pager<PlantDTO>();
		List<CdFactory> expectList = new ArrayList<CdFactory>();
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		expectList.add(new CdFactory());
		Long expectCount = 4L;
		EasyMock.expect(cdFactoryDAO.searchCdFactorys((Pager<CdFactory>)EasyMock.anyObject(), (CdFactory)EasyMock.anyObject())).andReturn(expectList).times(1);
		EasyMock.expect(cdFactoryDAO.searchCdFactorysCount((CdFactory)EasyMock.anyObject())).andReturn(expectCount).times(1);
		EasyMock.replay(cdFactoryDAO);
		CdFactoryServiceImpl cdFactoryServiceImpl = new CdFactoryServiceImpl();
		cdFactoryServiceImpl.setCdFactoryDAO(cdFactoryDAO);
		resultPager = cdFactoryServiceImpl.searchCdFactorysByParams(1L, 10L, new PlantDTO());
		assertSame(resultPager.getRecords().size(), 4);
		assertSame(resultPager.getTotalRecords(), 4L);
		EasyMock.verify(cdFactoryDAO);
	}

}
