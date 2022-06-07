package com.haier.hevwms.basic.service.impl;

import static org.easymock.EasyMock.anyLong;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.hevwms.basic.dao.MdDictionaryDAO;
import com.haier.hevwms.basic.domain.MdDictionary;

/**   
* Copyright: Copyright (c) 2018 SJK
* 
* @ClassName: MdDictionaryServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: SJK
* @date: 2018年5月3日 上午10:41:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月3日     SJK           v1.0.0               修改原因
*/
public class MdDictionaryServiceImplTest {
	
	private MdDictionaryDAO mdDictionaryDAO;
	private MdDictionaryServiceImpl mdDictionaryServiceImpl = new MdDictionaryServiceImpl();
	
	/**  
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:39 
	*/ 
	@Before
	public void init(){
		mdDictionaryDAO = createMock(MdDictionaryDAO.class);
		mdDictionaryServiceImpl.setMdDictionaryDAO(mdDictionaryDAO);
	}
	
	/**  
	* @Title: testCreateMdDictionary  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:31 
	*/ 
	@Test
	public void testCreateMdDictionary() {
		mdDictionaryDAO.save((MdDictionary) anyObject());
		expectLastCall();
		replay(mdDictionaryDAO);
		ExecuteResult<MdDictionary> result = mdDictionaryServiceImpl.createMdDictionary(new MdDictionaryDTO());
		assertTrue(result.isSuccess());
		assertNotNull(result.getResult());
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testUpdateMdDictionary  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:21 
	*/ 
	@Test
	public void testUpdateMdDictionary() {
		expect(mdDictionaryDAO.update((MdDictionary) anyObject())).andReturn(1);
		replay(mdDictionaryDAO);
		ExecuteResult<MdDictionary> result = mdDictionaryServiceImpl.updateMdDictionary(new MdDictionaryDTO());
		assertTrue(result.isSuccess());
		assertNotNull(result.getResult());
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testDeleteMdDictionary  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:18 
	*/ 
	@Test
	public void testDeleteMdDictionary() {
		expect(mdDictionaryDAO.delete(anyLong())).andReturn(1);
		replay(mdDictionaryDAO);
		ExecuteResult<MdDictionary> result = mdDictionaryServiceImpl.deleteMdDictionary(9999L);
		assertTrue(result.isSuccess());
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testDeleteMdDictionaryAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:14 
	*/ 
	@Test
	public void testDeleteMdDictionaryAll() {
		mdDictionaryDAO.deleteAll((List<Long>) anyObject());
		expectLastCall();
		replay(mdDictionaryDAO);
		ExecuteResult<MdDictionary> result = mdDictionaryServiceImpl.deleteMdDictionaryAll(new ArrayList<Long>());
		assertTrue(result.isSuccess());
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testSearchAllMdDictionarys  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:03 
	*/ 
	@Test
	public void testSearchAllMdDictionarys() {
		List<MdDictionary> expectList = new ArrayList<MdDictionary>();
		expectList.add(new MdDictionary());
		expectList.add(new MdDictionary());
		expectList.add(new MdDictionary());
		expect(mdDictionaryDAO.searchMdDictionarys((Pager<MdDictionary>)anyObject(), (MdDictionary)anyObject())).andReturn(expectList);
		expect(mdDictionaryDAO.searchMdDictionarysCount((MdDictionary)anyObject())).andReturn(5L);
		replay(mdDictionaryDAO);
		Pager<MdDictionaryDTO> result = mdDictionaryServiceImpl.searchAllMdDictionarys(1L, 10L, new MdDictionaryDTO());
		assertSame(result.getRecords().size(), 3);
		assertSame(result.getTotalRecords(), 5L);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testGetMdDictionaryById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:46:00 
	*/ 
	@Test
	public void testGetMdDictionaryById() {
		expect(mdDictionaryDAO.get(anyLong())).andReturn(new MdDictionary());
		replay(mdDictionaryDAO);
		MdDictionary result = mdDictionaryServiceImpl.getMdDictionaryById(9999L);
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testGetMdDictionarys  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:56 
	*/ 
	@Test
	public void testGetMdDictionarys() {
		expect(mdDictionaryDAO.getAll()).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.getMdDictionarys();
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testFindAllKind  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:53 
	*/ 
	@Test
	public void testFindAllKind() {
		expect(mdDictionaryDAO.findAll((String) anyObject())).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.findAllKind("TEST");
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testFindAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:50 
	*/ 
	@Test
	public void testFindAll() {
		expect(mdDictionaryDAO.findAll((String) anyObject())).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.findAll("TEST");
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testFindAllKindType  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:48 
	*/ 
	@Test
	public void testFindAllKindType() {
		expect(mdDictionaryDAO.findAllKind()).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.findAllKindType();
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testDeleteDictionarys  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:44 
	*/ 
	@Test
	public void testDeleteDictionarys() {
		mdDictionaryDAO.deleteAll((List<Long>) anyObject());
		expectLastCall();
		replay(mdDictionaryDAO);
		String result = mdDictionaryServiceImpl.deleteDictionarys(new ArrayList<Long>());
		assertTrue("Success".equals(result));
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testGetDictionaryByCodeOrName  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:41 
	*/ 
	@Test
	public void testGetDictionaryByCodeOrName() {
		expect(mdDictionaryDAO.getDictionaryByCodeOrName((String)anyObject(),(String)anyObject())).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.getDictionaryByCodeOrName("TEST", "TEST");
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

	/**  
	* @Title: testGetIfCodeOrNameExist  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:45:38 
	*/ 
	@Test
	public void testGetIfCodeOrNameExist() {
		expect(mdDictionaryDAO.getIfCodeOrNameExist((String)anyObject(),(String)anyObject(), anyLong())).andReturn(new ArrayList<MdDictionary>());
		replay(mdDictionaryDAO);
		List<MdDictionary> result = mdDictionaryServiceImpl.getIfCodeOrNameExist("TEST", "TEST", 9999L);
		assertNotNull(result);
		verify(mdDictionaryDAO);
	}

}
