package com.haier.openplatform.wms.report.service.impl;

import java.util.HashMap;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.report.service.PsiReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @className: PsiReportServiceClientImplTest.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年9月7日 上午11:02:48
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月7日		LJZ			v1.0.0			create
 */
public class PsiReportServiceClientImplTest {
	private PsiReportServiceClientImpl clientImplMock = new PsiReportServiceClientImpl();
	private PsiReportService psiReportServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		psiReportServiceMock = EasyMock.createMock(PsiReportService.class);
		clientImplMock.setPsiReportService(psiReportServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchPsiReport() {
		clientImplMock.searchPsiReport(new Pager<PsiReportDTO>(), new PsiReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetPsiReportInfos() {
		clientImplMock.getPsiReportInfos(new PsiReportDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetPsiReportService() {
		clientImplMock.getPsiReportService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGeneratePsiReport() {
		clientImplMock.generatePsiReport("", new HashMap<String,Object>());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testConn() {
		clientImplMock.conn();
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
		clientImplMock.getExportAmount(new PsiReportDTO());
	}

}
