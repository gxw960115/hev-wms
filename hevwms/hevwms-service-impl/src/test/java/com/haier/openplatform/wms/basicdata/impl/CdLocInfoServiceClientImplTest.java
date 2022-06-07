package com.haier.openplatform.wms.basicdata.impl;

import io.terminus.pampas.common.BaseUser;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: CdLocInfoServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午10:49:39
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class CdLocInfoServiceClientImplTest {
	private CdLocInfoServiceClientImpl clientImplMock = new CdLocInfoServiceClientImpl();
	private CdLocInfoService cdLocInfoServiceMock;

	/**
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:40
	 */
	@Before
	public void init() {
		cdLocInfoServiceMock = EasyMock.createMock(CdLocInfoService.class);
		clientImplMock.setCdLocInfoService(cdLocInfoServiceMock);
	}
	/**
	* @Title: testGetCdLocInfoService  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:44
	 */
	@Test
	public void testGetCdLocInfoService() {
		clientImplMock.getCdLocInfoService();
	}

	/**
	* @Title: testSearchCdLocInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:46
	 */
	@Test
	public void testSearchCdLocInfo() {
		clientImplMock.searchCdLocInfo(new Pager<CdLocInfoDTO>(), new CdLocInfoDTO());
	}

	/**
	* @Title: testSearchCdLocInfoByCondition  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:49
	 */
	@Test
	public void testSearchCdLocInfoByCondition() {
		clientImplMock.searchCdLocInfoByCondition(10L, 10L, new CdLocInfoDTO());
	}

	/**
	* @Title: testCreateLocInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:52
	 */
	@Test
	public void testCreateLocInfos() {
		clientImplMock.createLocInfos(new CdLocInfoDTO());
	}

	/**
	* @Title: testDeleteLocInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:55
	 */
	@Test
	public void testDeleteLocInfo() {
		clientImplMock.deleteLocInfo(new ArrayList<Long>());
	}

	/**
	* @Title: testDeleteLocInfoByIds  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:49:58
	 */
	@Test
	public void testDeleteLocInfoByIds() {
		clientImplMock.deleteLocInfoByIds("1234");
	}

	/**
	* @Title: testUpdateLocInfo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:01
	 */
	@Test
	public void testUpdateLocInfo() {
		clientImplMock.updateLocInfo(new CdLocInfoDTO());
	}

	/**
	* @Title: testSelectLocTree  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:03
	 */
	@Test
	public void testSelectLocTree() {
		clientImplMock.selectLocTree(109L, "0");
	}

	/**
	* @Title: testGetCdLocInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:10
	 */
	@Test
	public void testGetCdLocInfos() {
		clientImplMock.getCdLocInfos();
	}

	/**
	* @Title: testSaveOrUpdate  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:13
	 */
	@Test
	public void testSaveOrUpdate() {
		clientImplMock.saveOrUpdate(new ArrayList<CdLocInfoDTO>(), new BaseUser());
	}

	/**
	* @Title: testGetCdLocInfosByParentId  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:16
	 */
	@Test
	public void testGetCdLocInfosByParentId() {
		clientImplMock.getCdLocInfosByParentId(1004L);
	}

	/**
	* @Title: testDeleteLocInfoByRowids  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:18
	 */
	@Test
	public void testDeleteLocInfoByRowids() {
		clientImplMock.deleteLocInfoByRowids("1234");
	}

	/**
	* @Title: testGetCdTreeByParentId  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-8 下午2:50:21
	 */
	@Test
	public void testGetCdTreeByParentId() {
		clientImplMock.getCdTreeByParentId(10L, "dn");
	}

}
