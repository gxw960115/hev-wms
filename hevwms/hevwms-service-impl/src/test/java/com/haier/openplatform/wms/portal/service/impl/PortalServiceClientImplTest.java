package com.haier.openplatform.wms.portal.service.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.portal.service.PortalService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: PortalServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:04:05
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class PortalServiceClientImplTest {
	private PortalServiceClientImpl clientImplMock = new PortalServiceClientImpl();
	private PortalService portalServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		portalServiceMock = EasyMock.createMock(PortalService.class);
		clientImplMock.setPortalService(portalServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetNoticeData() {
		clientImplMock.getNoticeData();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetToDoChartsData() {
		clientImplMock.getToDoChartsData();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetInventoryPieData() {
		clientImplMock.getInventoryPieData();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetPortalService() {
		clientImplMock.getPortalService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSaveSystemNotice() {
		EasyMock.expect(portalServiceMock.deleteNotice()).andReturn(12).times(1);
		EasyMock.expect(portalServiceMock.saveSystemNotice((NoticeInfoDTO)EasyMock.anyObject()))
			.andReturn(new ExecuteResult<NoticeInfoDTO>()).times(1);
		EasyMock.replay(portalServiceMock);
		clientImplMock.saveSystemNotice(new NoticeInfoDTO());
	}

}
