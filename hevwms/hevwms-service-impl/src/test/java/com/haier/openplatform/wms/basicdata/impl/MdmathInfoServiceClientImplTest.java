package com.haier.openplatform.wms.basicdata.impl;

import io.terminus.pampas.common.BaseUser;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.service.MdMatInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 */
public class MdmathInfoServiceClientImplTest {
	private MdmathInfoServiceClientImpl clientImplMock = new MdmathInfoServiceClientImpl();
	private MdMatInfoService mdMatInfoServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Before
	public void init() {
		mdMatInfoServiceMock = EasyMock.createMock(MdMatInfoService.class);
		clientImplMock.setMdMatInfoService(mdMatInfoServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testGetMdMatInfoService() {
		clientImplMock.getMdMatInfoService();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testSearchMdmaInfo() {
		clientImplMock.searchMdmaInfo(new Pager<MdMatInfoDTO>(), new MdMatInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testCreateMdmatInfos() {
		clientImplMock.createMdmatInfos(new MdMatInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testDeleteMdmatInfo() {
		clientImplMock.deleteMdmatInfo(new ArrayList<Long>());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testUpdateMdmatInfo() {
		clientImplMock.updateMdmatInfo(new MdMatInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testGetMdMatInfoByParam() {
		clientImplMock.getMdMatInfoByParam(new MdMatInfoDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testImportMaterialInfo() {
		clientImplMock.importMaterialInfo(new ArrayList<MdMatInfoDTO>(), new BaseUser());
	}
}
