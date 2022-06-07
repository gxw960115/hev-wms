package com.haier.openplatform.wms.report.service.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.report.service.ConsignmentReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: ConsignmentReportServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:02:41
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class ConsignmentReportServiceClientImplTest {
	private ConsignmentReportServiceClientImpl clientImplMock = new ConsignmentReportServiceClientImpl();
	private ConsignmentReportService consignmentReportServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		consignmentReportServiceMock = EasyMock.createMock(ConsignmentReportService.class);
		clientImplMock.setConsignmentReportService(consignmentReportServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchConsignmentReport() {
		clientImplMock.searchConsignmentReport(new Pager<ConsignmentReportDTO>(), new ConsignmentReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetConsignmentReportInfos() {
		clientImplMock.getConsignmentReportInfos(new ConsignmentReportDTO());
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
		clientImplMock.getExportAmount(new ConsignmentReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetConsignmentReportService() {
		clientImplMock.getConsignmentReportService();
	}
}
