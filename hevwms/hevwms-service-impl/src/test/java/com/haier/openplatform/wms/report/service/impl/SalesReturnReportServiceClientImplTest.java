package com.haier.openplatform.wms.report.service.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.report.service.SalesReturnReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: SalesReturnReportServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:02:55
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class SalesReturnReportServiceClientImplTest {
	private SalesReturnReportServiceClientImpl clientImplMock = new SalesReturnReportServiceClientImpl();
	private SalesReturnReportService salesReturnReportServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		salesReturnReportServiceMock = EasyMock.createMock(SalesReturnReportService.class);
		clientImplMock.setSalesReturnReportService(salesReturnReportServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchSalesReturnReport() {
		clientImplMock.searchSalesReturnReport(new Pager<SalesReturnReportDTO>(), new SalesReturnReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetSalesReturnReportInfos() {
		clientImplMock.getSalesReturnReportInfos(new SalesReturnReportDTO());
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
		clientImplMock.getExportAmount(new SalesReturnReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetSalesReturnReportService() {
		clientImplMock.getSalesReturnReportService();
	}
}
