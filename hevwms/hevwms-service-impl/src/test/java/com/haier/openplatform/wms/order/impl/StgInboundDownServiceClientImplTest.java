package com.haier.openplatform.wms.order.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.order.service.StgInboundDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
public class StgInboundDownServiceClientImplTest {
	private StgInboundDownServiceClientImpl clientImplMock = new StgInboundDownServiceClientImpl();
	private StgInboundDownService stgInboundDownServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		stgInboundDownServiceMock = EasyMock.createMock(StgInboundDownService.class);
		clientImplMock.setStgInboundDownService(stgInboundDownServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchStgInboundDowns() {
		clientImplMock.searchStgInboundDowns(new Pager<StgInboundDownDTO>(), new StgInboundDownDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStgInboundDownByParam() {
		clientImplMock.getStgInboundDownByParam(new StgInboundDownDTO());
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
		clientImplMock.getExportAmount(new StgInboundDownDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetStgInboundDownService() {
		clientImplMock.getStgInboundDownService();
	}
}
