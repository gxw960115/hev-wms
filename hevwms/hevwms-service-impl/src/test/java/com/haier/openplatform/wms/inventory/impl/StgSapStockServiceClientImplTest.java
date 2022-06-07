package com.haier.openplatform.wms.inventory.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.hevwms.inventory.service.StgSapStockService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
public class StgSapStockServiceClientImplTest {
	private StgSapStockServiceClientImpl clientImplMock = new StgSapStockServiceClientImpl();
	private StgSapStockService stgSapStockServiceMock;
    private CdLocInfoService cdLocInfoServiceMock;
    private CdWhInfoService cdWhInfoServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
    @Before
	public void init() {
    	stgSapStockServiceMock = EasyMock.createMock(StgSapStockService.class);
    	cdLocInfoServiceMock = EasyMock.createMock(CdLocInfoService.class);
    	cdWhInfoServiceMock = EasyMock.createMock(CdWhInfoService.class);
		clientImplMock.setStgSapStockService(stgSapStockServiceMock);
		clientImplMock.setCdLocInfoService(cdLocInfoServiceMock);
		clientImplMock.setCdWhInfoService(cdWhInfoServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchActualStockGapList() {
		clientImplMock.searchActualStockGapList(new StgSapStockDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStgSapStockService() {
		clientImplMock.getStgSapStockService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetCdLocInfoService() {
		clientImplMock.getCdLocInfoService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchStgSapStockInfo() {
		clientImplMock.searchStgSapStockInfo(new Pager<StgSapStockDTO>(), new StgSapStockDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchActualStockGap() {
		clientImplMock.searchActualStockGap(new Pager<StgSapStockDTO>(), new StgSapStockDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStgSapInfoInfoByParams() {
		clientImplMock.getStgSapInfoInfoByParams(new StgSapStockDTO());
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
		clientImplMock.getExportAmount(new StgSapStockDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetCdWhInfoService() {
		clientImplMock.getCdWhInfoService();
	}
}
