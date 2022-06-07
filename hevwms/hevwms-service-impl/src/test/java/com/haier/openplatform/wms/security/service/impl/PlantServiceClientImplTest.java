package com.haier.openplatform.wms.security.service.impl;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;

import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.basic.domain.CdFactory;
import com.haier.hevwms.basic.service.CdFactoryService;
import com.haier.openplatform.showcase.util.Paging;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.security.dto.PlantDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: PlantServiceClientImplTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月4日 上午9:31:17
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月4日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class PlantServiceClientImplTest {

	private CdFactoryService plantService;
	private PlantServiceClientImpl target;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		plantService = EasyMock.createMock(CdFactoryService.class);
		target = new PlantServiceClientImpl();
		target.setPlantService(plantService);
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
	}
	/**
	 * @Title: testSearchPlantByParams
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月4日 上午9:45:04
	 */
	@Test
	public void testSearchPlantByParams() {
		PlantDTO temp = new PlantDTO();
		expect(plantService.searchCdFactorysByParams(11L,11L,temp)).andReturn(new Pager<PlantDTO>());
		replay(plantService);
		Pager<PlantDTO> result = target.searchPlantByParams(11L, 11L, temp);
		assertNotNull(result);
	}
	
	/**
	 * @Title: testSearchPlant
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年9月4日 下午1:40:09
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchPlant() {
		List<CdFactory> listInfoTestCase = new ArrayList<CdFactory>();
		
		expect(plantService.searchCdFactorys((Pager<CdFactory>) anyObject(),(CdFactory) anyObject())).andReturn(listInfoTestCase);
		
		expect(plantService.searchCdFactorysCount((CdFactory) anyObject())).andReturn(11L);
		
		replay(plantService);
		Pager<PlantDTO> result = target.searchPlant(11L, 11L,new PlantDTO());
		assertNotNull(result);
		
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchPlantByCodeAndName() {
		List<CdFactory> listInfoTestCase = new ArrayList<CdFactory>();
		expect(plantService.searchCdFactorys((Pager<CdFactory>) anyObject(),(CdFactory) anyObject())).andReturn(listInfoTestCase);
		
		expect(plantService.searchCdFactorysCount((CdFactory) anyObject())).andReturn(11L);
		
		replay(plantService);
		Paging<PlantDTO> result = target.searchPlantByCodeAndName("", "");
		assertNotNull(result);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testAddPlant() {
		PlantDTO plantDTO = new PlantDTO();
		ExecuteResult<CdFactory> executeResultTestCase = new ExecuteResult<CdFactory>();
		expect(plantService.createCdFactory((CdFactory) anyObject())).andReturn(executeResultTestCase);
		
		replay(plantService);
		String result = target.addPlant(plantDTO);
		assertNotNull(result);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testUpdatePlant() {
		PlantDTO plantDTO = new PlantDTO();
		ExecuteResult<CdFactory> executeResultTestCase = new ExecuteResult<CdFactory>();
		expect(plantService.updateCdFactory((CdFactory) anyObject())).andReturn(executeResultTestCase);
		
		replay(plantService);
		String result = target.updatePlant(plantDTO);
		assertNotNull(result);
	}
	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeletePlant() {
		ExecuteResult<CdFactory> executeResultTestCase = new ExecuteResult<CdFactory>();
		expect(plantService.deleteCdFactory(11L)).andReturn(executeResultTestCase);
		
		replay(plantService);
		String result = target.deletePlant("11");
		assertNotNull(result);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchAll() {
		List<CdFactory> rowsTestCase = new ArrayList<CdFactory>();
		CdFactory temp = new CdFactory();
		rowsTestCase.add(temp);
		expect(plantService.getCdFactorys()).andReturn(rowsTestCase);
		
		replay(plantService);
		List<CdFactoryDTO> result = target.searchAll();
		assertNotNull(result);
	}
	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testDeletePlantsByIds() {
		ExecuteResult<CdFactory> rowsTestCase = new ExecuteResult<CdFactory>();
//		CdFactory temp = new CdFactory();
		expect(plantService.deleteCdFactoryAll((List<Long>) anyObject())).andReturn(rowsTestCase);
		
		replay(plantService);
		String result = target.deletePlantsByIds("");
		assertNotNull(result);
	}
}
