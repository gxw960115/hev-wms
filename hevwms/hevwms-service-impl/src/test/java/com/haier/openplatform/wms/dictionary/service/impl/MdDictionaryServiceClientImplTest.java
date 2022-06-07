package com.haier.openplatform.wms.dictionary.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.hevwms.basic.service.MdDictionaryService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: MdDictionaryServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:01:09
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class MdDictionaryServiceClientImplTest {
	private MdDictionaryServiceClientImpl clientImplMock = new MdDictionaryServiceClientImpl();
	private MdDictionaryService mdDictionaryServiceMock;
	
	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:01:12  void
	 */
	@Before
	public void init() {
		mdDictionaryServiceMock = EasyMock.createMock(MdDictionaryService.class);
		clientImplMock.setMdDictionaryService(mdDictionaryServiceMock);
	}

	/**
	 * @title: testGetMdDictionaryService
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:01:14  void
	 */
	@Test
	public void testGetMdDictionaryService() {
		clientImplMock.getMdDictionaryService();
	}

	/**
	 * @title: testGetMdDictionarys
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:01:16  void
	 */
	@Test
	public void testGetMdDictionarys() {
		clientImplMock.getMdDictionarys(new Pager<MdDictionaryDTO>(), new MdDictionaryDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetAllMdDictionarys() {
		clientImplMock.getAllMdDictionarys(1L, 10L, new MdDictionaryDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testAddMdDictionarys() {
		EasyMock.expect(mdDictionaryServiceMock.getDictionaryByCodeOrName((String)EasyMock.anyObject()
				,(String)EasyMock.anyObject())).andReturn(new ArrayList<MdDictionary>()).times(1);
		EasyMock.expect(mdDictionaryServiceMock.createMdDictionary((MdDictionaryDTO)EasyMock.anyObject()))
			.andReturn(new ExecuteResult<MdDictionary>()).times(1);
		EasyMock.replay(mdDictionaryServiceMock);
		
		clientImplMock.addMdDictionarys(new MdDictionaryDTO());
	}

//	@Test
//	public void testUpdateMdDictionary() {
//		List<MdDictionary> list = new ArrayList<MdDictionary>();
//		ExecuteResult<MdDictionary> executeResult = new ExecuteResult<MdDictionary>();
//		executeResult.isSuccess();
//		EasyMock.expect(mdDictionaryServiceMock.getIfCodeOrNameExist((String)EasyMock.anyObject()
//				,(String)EasyMock.anyObject(),(Long)EasyMock.anyObject())).andReturn(list).times(1);
//		EasyMock.expect(mdDictionaryServiceMock.updateMdDictionary((MdDictionaryDTO)EasyMock.anyObject()))
//			.andReturn(executeResult).times(1);
//		EasyMock.replay(mdDictionaryServiceMock);
//		clientImplMock.updateMdDictionary(new MdDictionaryDTO());
//	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteDictionarys() {
		clientImplMock.deleteDictionarys(new ArrayList<Long>());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteMdDictionarys() {
		clientImplMock.deleteMdDictionarys(new ArrayList<Long>());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchAllDictionInfoString() {
		List<MdDictionary> list = new ArrayList<MdDictionary>();
		list.add(new MdDictionary());
		EasyMock.expect(mdDictionaryServiceMock.findAllKind((String)EasyMock.anyObject())).andReturn(list).times(1);
		EasyMock.replay(mdDictionaryServiceMock);
		clientImplMock.searchAllDictionInfo("");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchAllDictionInfo() {
		clientImplMock.searchAllDictionInfo();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testFindDivisions() {
		List<MdDictionary> list = new ArrayList<MdDictionary>();
		list.add(new MdDictionary());
		EasyMock.expect(mdDictionaryServiceMock.findAll((String)EasyMock.anyObject())).andReturn(list).times(1);
		EasyMock.replay(mdDictionaryServiceMock);
		clientImplMock.findDivisions();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testFindAllKindType() {
		List<MdDictionary> temp = new ArrayList<MdDictionary>();
		temp.add(new MdDictionary());
		EasyMock.expect(mdDictionaryServiceMock.findAllKindType()).andReturn(temp).times(1);
		EasyMock.replay(mdDictionaryServiceMock);
		clientImplMock.findAllKindType();
	}

}
