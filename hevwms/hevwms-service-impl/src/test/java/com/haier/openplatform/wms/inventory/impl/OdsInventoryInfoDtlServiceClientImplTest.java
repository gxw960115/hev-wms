package com.haier.openplatform.wms.inventory.impl;

import java.util.ArrayList;
import java.util.Date;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsInventoryInfoDtlServiceClientImplTest {

	private OdsInventoryInfoDtlServiceClientImpl clientImplMock = new OdsInventoryInfoDtlServiceClientImpl();
	private OdsInventoryInfoDtlService odsInventoryInfoDtlServiceMock;

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Before
	public void init() {
		odsInventoryInfoDtlServiceMock = EasyMock.createMock(OdsInventoryInfoDtlService.class);
		clientImplMock.setOdsInventoryInfoDtlService(odsInventoryInfoDtlServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchOdsInventoryInfoDtlDTOs(){
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO = new OdsInventoryInfoDtlDTO();
		odsInventoryInfoDtlDTO.setCreateDate(new Date());
		odsInventoryInfoDtlDTO.setFirstInDate(new Date());
		odsInventoryInfoDtlDTO.setModifyDate(new Date());
		EasyMock.expect(odsInventoryInfoDtlServiceMock.searchOdsInventoryInfoDtls(
				(Pager<OdsInventoryInfoDtl>)EasyMock.anyObject(),
				(OdsInventoryInfoDtl)EasyMock.anyObject())
		).andReturn(new Pager<OdsInventoryInfoDtl>()).times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.searchOdsInventoryInfoDtlDTOs(1L,10L,odsInventoryInfoDtlDTO);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void addInventory(){
		clientImplMock.addInventory(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testCreateOdsInventoryInfoDtlDTO() {
		clientImplMock.createOdsInventoryInfoDtlDTO(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testUpdateOdsInventoryInfoDtlDTO() {
		clientImplMock.updateOdsInventoryInfoDtlDTO(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteOdsInventoryInfoDtlDTO() {
		clientImplMock.deleteOdsInventoryInfoDtlDTO(10L);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testDeleteOdsInventoryInfoDtlDTOAll() {
		clientImplMock.deleteOdsInventoryInfoDtlDTOAll(new ArrayList<Long>());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsInventoryInfoDtlDTOById() {
		clientImplMock.getOdsInventoryInfoDtlDTOById(10L);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsInventoryInfoDtlDTOs() {
		clientImplMock.getOdsInventoryInfoDtlDTOs();
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testSearchDiffInventorys() {
		clientImplMock.searchDiffInventorys(new Pager<OdsInventoryInfoDtlDTO>(), new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetDiffInventoryByParam() {
		clientImplMock.getDiffInventoryByParam(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsInventoryInfoDtlDTOByParam() {
		clientImplMock.getOdsInventoryInfoDtlDTOByParam(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetOdsInventoryInfoDtlService() {
		clientImplMock.getOdsInventoryInfoDtlService();
	}

}
