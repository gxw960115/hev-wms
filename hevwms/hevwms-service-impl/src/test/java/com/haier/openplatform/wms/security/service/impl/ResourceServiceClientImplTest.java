package com.haier.openplatform.wms.security.service.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.security.service.ResourceService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: ResourceServiceClientImplTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月5日 上午10:34:36
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月5日		LJZ			v1.0.0			create
 */
public class ResourceServiceClientImplTest {
	
	private ResourceService resourceService;
	private ResourceServiceClientImpl target;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init(){
		resourceService = EasyMock.createMock(ResourceService.class);
		target = new ResourceServiceClientImpl();
		target.setResourceService(resourceService);
		target.getResourceService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@SuppressWarnings({"all"})
	@Test
	public void testSearchResource() {
		Pager<ResourceDTO> temp = new Pager<ResourceDTO>();
		List<ResourceDTO> listInfoCaseDtos = new ArrayList<ResourceDTO>();
		ResourceDTO temp2 = new ResourceDTO();
		temp2.setType(0);
		listInfoCaseDtos.add(temp2);
		
		temp.setRecords(listInfoCaseDtos);
		expect(resourceService.searchResources((Pager<ResourceDTO>) anyObject(),(ResourceDTO) anyObject())).andReturn(temp);
		
		replay(resourceService);
		Pager<ResourceDTO> result = target.searchResource(11L, 11L, (ResourceDTO) anyObject());
		assertNotNull(result);
		verify(resourceService);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteResourceMessage() {
		ExecuteResult<ResourceDTO> resultTestCaseExecuteResult = new ExecuteResult<ResourceDTO>();
		expect(resourceService.deleteResource(11L)).andReturn(resultTestCaseExecuteResult);
		
		replay(resourceService);
		String result = target.deleteResourceMessage("11");
		assertNotNull(result);
		verify(resourceService);
	}

//	@Test
//	public void testGetResourceService() {
//		ResourceService resu = target.getResourceService();
//		assertNotNull(resu);
//	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testCreateResource() {
		ResourceDTO temp = (ResourceDTO) anyObject();
		expect(resourceService.createResource(temp)).andReturn(new ExecuteResult<ResourceDTO>());
		
		replay(resourceService);
		String result = target.createResource(temp);
		assertNotNull(result);
		verify(resourceService);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSelectResourceTree() {
		List<ResourceDTO> temp = new ArrayList<ResourceDTO>();
		expect(resourceService.selectResourceTree((ResourceDTO) anyObject())).andReturn(temp);
		
		replay(resourceService);
		target.selectResourceTree(11);
		assertNotNull(true);
		verify(resourceService);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testUpdateResource() {
		ExecuteResult<ResourceDTO> resultTestCase = new ExecuteResult<ResourceDTO>();
		ResourceDTO temp = (ResourceDTO) anyObject();
		expect(resourceService.updateResource(temp)).andReturn(resultTestCase);
		
		
		replay(resourceService);
		target.updateResource(temp);
		assertNotNull(true);
		verify(resourceService);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetParentResource() {
		List<ResourceDTO> listTestCaseDtos = new ArrayList<ResourceDTO>();
		expect(resourceService.getParentResource((ResourceDTO) anyObject())).andReturn(listTestCaseDtos);
		
		
		
		replay(resourceService);
		List<ResourceDTO> result = target.getParentResource(11);
		assertNotNull(result);
	}

}
