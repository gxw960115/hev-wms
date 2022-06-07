package com.haier.openplatform.wms.basicdata.impl;

import com.haier.openplatform.util.Pager;
import io.terminus.pampas.common.BaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: CdWhInfoServiceCilentImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:00:37
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class CdWhInfoServiceCilentImplTest {
	private CdWhInfoServiceCilentImpl clientImplMock = new CdWhInfoServiceCilentImpl();
	private CdWhInfoService cdWhInfoServiceMock;

	/**
	 * @title: init
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:39  void
	 */
	@Before
	public void init() {
		cdWhInfoServiceMock = EasyMock.createMock(CdWhInfoService.class);
		clientImplMock.setCdWhInfoService(cdWhInfoServiceMock);
	}
	
	/**
	 * @title: testGetCdWhInfoService
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:41  void
	 */
	@Test
	public void testGetCdWhInfoService() {
		clientImplMock.getCdWhInfoService();
	}

	/**
	 * @title: testFindWhlocalInfos
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:44  void
	 */
	@Test
	public void testFindWhlocalInfos() {
		EasyMock.expect(cdWhInfoServiceMock.findWhLocTree(
				(String)EasyMock.anyObject(),
				(Long)EasyMock.anyObject())
		).andReturn(new ArrayList<HashMap<String, Object>>()).times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.findWhlocalInfos("test", 120L);
	}

	/**
	 * @title: testSearchWhInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:46  void
	 */
	@Test
	public void testSearchWhInfo() {
		List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
		list.add(new CdWhInfoDTO());
		EasyMock.expect(cdWhInfoServiceMock.getCdWhInfos()).andReturn(list).times(1);
		EasyMock.replay(cdWhInfoServiceMock);

		clientImplMock.searchWhInfo();
	}

	/**
	 * @title: testSearchPhysicalWhInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:48  void
	 */
	@Test
	public void testSearchPhysicalWhInfo() {
		List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
		list.add(new CdWhInfoDTO());
		EasyMock.expect(cdWhInfoServiceMock.getPhysicalWhInfos()).andReturn(list).times(1);
		EasyMock.replay(cdWhInfoServiceMock);

		clientImplMock.searchPhysicalWhInfo();
	}

	/**
	 * @title: testSearchCdWhInfos
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:50  void
	 */
	@Test
	public void testSearchCdWhInfos() {
		EasyMock.expect(cdWhInfoServiceMock.searchCdWhInfosByConditions(
				(Long)EasyMock.anyObject(),
				(Long)EasyMock.anyObject(),
				(CdWhInfoDTO)EasyMock.anyObject())
		).andReturn(new Pager<CdWhInfoDTO>()).times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.searchCdWhInfos(10L, 10L, new CdWhInfoDTO());
	}

	/**
	 * @title: testCreateCdWhInfo
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月7日 上午11:00:53  void
	 */
	@Test
	public void testCreateCdWhInfo() {
		EasyMock.expect(cdWhInfoServiceMock.createCdWhInfo(
				(CdWhInfoDTO)EasyMock.anyObject())
		).andReturn("1").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.createCdWhInfo(new CdWhInfoDTO());
	}

	@Test
	public void testDeleteCdWhInfo() {
		EasyMock.expect(cdWhInfoServiceMock.deleteCdWhInfoAll(
				(List<Long>)EasyMock.anyObject())
		).andReturn("1").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.deleteCdWhInfo(new ArrayList<Long>());
	}

	@Test
	public void testUpdateCdWhInfo() {
		EasyMock.expect(cdWhInfoServiceMock.updateCdWhInfo(
				(CdWhInfoDTO)EasyMock.anyObject())
		).andReturn("1").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.updateCdWhInfo(new CdWhInfoDTO());
	}

	@Test
	public void testSaveOrUpdate() {
		EasyMock.expect(cdWhInfoServiceMock.saveOrUpdate2(
				(List<CdWhInfoDTO>)EasyMock.anyObject(),
				(BaseUser)EasyMock.anyObject())
		).andReturn("111").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.saveOrUpdate(new ArrayList<CdWhInfoDTO>(), new BaseUser());
	}

	@Test
	public void testUpdateWhFlag() {
		EasyMock.expect(cdWhInfoServiceMock.updateWhFlag(
				(List<Long>)EasyMock.anyObject())
		).andReturn("1111").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.updateWhFlag(new ArrayList<Long>());
	}

	@Test
	public void testDeleteCdWhInfoByRowids() {
		EasyMock.expect(cdWhInfoServiceMock.deleteCdWhInfoAll(
				(List<Long>)EasyMock.anyObject())
		).andReturn("1").times(1);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.deleteCdWhInfoByRowids("12");
	}

	@Test
	public void testFindCdUserLoc() {
		clientImplMock.findCdUserLoc("tes", 1002L);
	}

	@Test
	public void testSearchAvailableWh() {
		List<CdWhInfoDTO> list = new ArrayList<>();
		CdWhInfoDTO dto = new CdWhInfoDTO();
		dto.setName("1");
		dto.setCode("1");
		list.add(dto);
		EasyMock.expect(cdWhInfoServiceMock.findAvailableWhInfos(1L)).andReturn(list);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.searchAvailableWh(1L);
	}

	@Test
	public void testSearchAvailablePhyWh() {
		List<CdWhInfoDTO> list = new ArrayList<>();
		CdWhInfoDTO dto = new CdWhInfoDTO();
		dto.setName("1");
		dto.setCode("1");
		list.add(dto);
		EasyMock.expect(cdWhInfoServiceMock.findAvailablePhyWhInfos(1L)).andReturn(list);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.searchAvailablePhyWh(1L);
	}

	@Test
	public void testSearchAvailablePhyWhGap() {
		List<CdWhInfoDTO> list = new ArrayList<>();
		EasyMock.expect(cdWhInfoServiceMock.findAvailablePhyWhInfos(1L)).andReturn(list);
		EasyMock.replay(cdWhInfoServiceMock);
		clientImplMock.searchAvailablePhyWhGap(1L);
	}
}
