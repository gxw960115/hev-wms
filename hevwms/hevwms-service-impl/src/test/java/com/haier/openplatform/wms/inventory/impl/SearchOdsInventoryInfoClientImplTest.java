package com.haier.openplatform.wms.inventory.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.inventory.service.OdsInventoryInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
public class SearchOdsInventoryInfoClientImplTest {
	private SearchOdsInventoryInfoClientImpl clientImplMock = new SearchOdsInventoryInfoClientImpl();
	private OdsInventoryInfoService odsInventoryInfoServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		odsInventoryInfoServiceMock = EasyMock.createMock(OdsInventoryInfoService.class);
		clientImplMock.setOdsInventoryInfoService(odsInventoryInfoServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsInventoryInfoService() {
		clientImplMock.getOdsInventoryInfoService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchOdsInventoryInfo() {
		clientImplMock.searchOdsInventoryInfo(new Pager<OdsInventoryInfoDTO>(), new OdsInventoryInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetInventoryInfoByParams() {
		clientImplMock.getInventoryInfoByParams(new OdsInventoryInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testWmsQtyDetail() {
		clientImplMock.wmsQtyDetail(new Pager<OdsInventoryInfoDTO>(), new OdsInventoryInfoDTO());
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
		clientImplMock.getExportAmount(new OdsInventoryInfoDTO());
	}

}
