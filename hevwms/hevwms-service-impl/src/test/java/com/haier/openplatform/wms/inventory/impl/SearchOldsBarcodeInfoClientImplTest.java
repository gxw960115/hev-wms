package com.haier.openplatform.wms.inventory.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.inventory.service.OdsBarcodeHistoryService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
public class SearchOldsBarcodeInfoClientImplTest {
	private SearchOldsBarcodeInfoClientImpl clientImplMock = new SearchOldsBarcodeInfoClientImpl();
	private OdsBarcodeHistoryService odsBarcodeHistoryServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		odsBarcodeHistoryServiceMock = EasyMock.createMock(OdsBarcodeHistoryService.class);
		clientImplMock.setOdsBarcodeHistoryService(odsBarcodeHistoryServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsBarcodeHistoryService() {
		clientImplMock.getOdsBarcodeHistoryService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchOdsBarcodeInfo() {
		clientImplMock.searchOdsBarcodeInfo(new Pager<OdsBarcodeHistoryDTO>(), new OdsBarcodeHistoryDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsBarcodeInfoByParams() {
		clientImplMock.getOdsBarcodeInfoByParams(new OdsBarcodeHistoryDTO());
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
		clientImplMock.getExportAmount(new OdsBarcodeHistoryDTO());
	}

}
