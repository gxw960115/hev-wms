package com.haier.openplatform.wms.report.service.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.report.service.StoIntransitReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: StoIntransitReportServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:03:12
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class StoIntransitReportServiceClientImplTest {
	private StoIntransitReportServiceClientImpl clientImplMock = new StoIntransitReportServiceClientImpl();
	private StoIntransitReportService stoIntransitReportServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		stoIntransitReportServiceMock = EasyMock.createMock(StoIntransitReportService.class);
		clientImplMock.setStoIntransitReportService(stoIntransitReportServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchStoIntransitReport() {
		clientImplMock.searchStoIntransitReport(new Pager<StoIntransitReportDTO>(), new StoIntransitReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStoIntransitPsiReportInfos() {
		clientImplMock.getStoIntransitPsiReportInfos(new StoIntransitReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetExportAmount() {
		clientImplMock.getExportAmount(new StoIntransitReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStoIntransitReportService() {
		clientImplMock.getStoIntransitReportService();
	}
}
