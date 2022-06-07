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
import io.terminus.pampas.common.BaseUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

/**   
* Copyright: Copyright (c) 2018 SJK
* 
* @ClassName: MdMatInfoServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: SJK
* @date: 2018年5月4日 上午9:56:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月4日     SJK           v1.0.0               修改原因
*/
public class MdMatInfoServiceImplTest {
	
	private MdMatInfoDAO mdMatInfoDAO;
    private OperationLogDAO operationLogDAO;
    private MdMatInfoServiceImpl mdMatInfoServiceImpl = new MdMatInfoServiceImpl();
	/**  
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:55:41 
	*/ 
	@Before
	public void init (){
		mdMatInfoDAO = createMock(MdMatInfoDAO.class);
		operationLogDAO = createMock(OperationLogDAO.class);
		mdMatInfoServiceImpl.setMdMatInfoDAO(mdMatInfoDAO);
		mdMatInfoServiceImpl.setOperationLogDAO(operationLogDAO);
	}
	
	/**  
	* @Title: testCreateMdMatInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:44 
	*/ 
//	@Test
//	public void testCreateMdMatInfo() {
//		expect(mdMatInfoDAO.getMdMatInfoByParam((MdMatInfoDTO) anyObject())).andReturn(null);
//		mdMatInfoDAO.save((MdMatInfoDTO) anyObject());
//		expectLastCall();
//		replay(mdMatInfoDAO);
//		String result = mdMatInfoServiceImpl.createMdMatInfo(new MdMatInfoDTO());
//		assertTrue("true".equals(result));
//		verify(mdMatInfoDAO);
//	}

	/**  
	* @Title: testUpdateMdMatInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:48 
	*/ 
	@Test
	public void testUpdateMdMatInfo() {
		expect(mdMatInfoDAO.getCountByMaterialNoExceptSelf((MdMatInfoDTO) anyObject())).andReturn(0L);
		expect(mdMatInfoDAO.updateWithDivisionName((MdMatInfoDTO) anyObject())).andReturn(1);
		replay(mdMatInfoDAO);
		String result = mdMatInfoServiceImpl.updateMdMatInfo(new MdMatInfoDTO());
		assertTrue("true".equals(result));
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testDeleteMdMatInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:51 
	*/ 
	@Test
	public void testDeleteMdMatInfo() {
		expect(mdMatInfoDAO.delete(anyLong())).andReturn(1);
		replay(mdMatInfoDAO);
		ExecuteResult<MdMatInfoDTO> result = mdMatInfoServiceImpl.deleteMdMatInfo(9999L);
		assertTrue(result.isSuccess());
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testDeleteMdMatInfoAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:53 
	*/ 
	@Test
	public void testDeleteMdMatInfoAll() {
		mdMatInfoDAO.deleteAll((List<Long>) anyObject());
		expectLastCall();
		replay(mdMatInfoDAO);
		String result = mdMatInfoServiceImpl.deleteMdMatInfoAll(new ArrayList<Long>());
		assertTrue("true".equals(result));
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testSearchMdMatInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:56 
	*/ 
	@Test
	public void testSearchMdMatInfos() {
		List<MdMatInfoDTO> expectList = new ArrayList<MdMatInfoDTO>();
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expect(mdMatInfoDAO.searchMdMatInfos((Pager<MdMatInfoDTO>)anyObject(), (MdMatInfoDTO)anyObject())).andReturn(expectList);
		expect(mdMatInfoDAO.searchMdMatInfosCount((MdMatInfoDTO) anyObject())).andReturn(5L);
		replay(mdMatInfoDAO);
		Pager<MdMatInfoDTO> result = mdMatInfoServiceImpl
				.searchMdMatInfos(new Pager<MdMatInfoDTO>(), new MdMatInfoDTO());
		assertSame(result.getRecords().size(), 3);
		assertSame(result.getTotalRecords(), 5L);
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testGetMdMatInfoById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:54:59 
	*/ 
	@Test
	public void testGetMdMatInfoById() {
		expect(mdMatInfoDAO.get(anyLong())).andReturn(new MdMatInfoDTO());
		replay(mdMatInfoDAO);
		MdMatInfoDTO result = mdMatInfoServiceImpl.getMdMatInfoById(9999L);
		assertNotNull(result);
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testGetMdMatInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:55:02 
	*/ 
	@Test
	public void testGetMdMatInfos() {
		List<MdMatInfoDTO> expectList = new ArrayList<MdMatInfoDTO>();
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expect(mdMatInfoDAO.getAll()).andReturn(expectList);
		replay(mdMatInfoDAO);
		List<MdMatInfoDTO> result = mdMatInfoServiceImpl.getMdMatInfos();
		assertSame(result.size(), 3);
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testGetMdMatInfoByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:55:06 
	*/ 
	@Test
	public void testGetMdMatInfoByParam() {
		List<MdMatInfoDTO> expectList = new ArrayList<MdMatInfoDTO>();
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expectList.add(new MdMatInfoDTO());
		expect(mdMatInfoDAO.getMdMatInfoByParam((MdMatInfoDTO) anyObject())).andReturn(expectList);
		replay(mdMatInfoDAO);
		List<MdMatInfoDTO> result = mdMatInfoServiceImpl.getMdMatInfoByParam(new MdMatInfoDTO());
		assertSame(result.size(), 3);
		verify(mdMatInfoDAO);
	}

	/**  
	* @Title: testSaveOrUpdate  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年5月4日 上午9:55:09 
	*/ 
	@Test
	public void testSaveOrUpdate() {
		List<MdMatInfoDTO> paramList = new ArrayList<MdMatInfoDTO>();
		paramList.add(new MdMatInfoDTO());
		paramList.add(new MdMatInfoDTO());
		MdMatInfoDTO expectDTO = new MdMatInfoDTO();
		expectDTO.setCreatedDate(new Date());
		expectDTO.setModifyDate(new Date());
		expect(mdMatInfoDAO.getMdMatInfoByMaterialNo((String) anyObject())).andReturn(expectDTO).andReturn(null);
		expect(mdMatInfoDAO.update((MdMatInfoDTO) anyObject())).andReturn(1);
		mdMatInfoDAO.save((MdMatInfoDTO) anyObject());
		expectLastCall();
		operationLogDAO.save((OperationLogSaveModel) anyObject());
		expectLastCall().anyTimes();
		replay(mdMatInfoDAO);
		replay(operationLogDAO);
		String result = mdMatInfoServiceImpl.saveOrUpdate(paramList, new BaseUser());
		assertTrue(result.startsWith("Success"));
		verify(mdMatInfoDAO);
		verify(operationLogDAO);
	}

}
