package com.haier.openplatform.wms.inventory.impl;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * 阿达萨达
 * 阿萨德撒大
 * 打算的撒
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class SearchStockAgeReportClientImplTest {
	private SearchStockAgeReportClientImpl clientImplMock = new SearchStockAgeReportClientImpl();
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
	public void testGetOdsInventoryInfoDtlService() {
		clientImplMock.getOdsInventoryInfoDtlService();
		
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetStockAgeReport() {
		Pager<OdsInventoryInfoDtlDTO> pager = new Pager<OdsInventoryInfoDtlDTO>();
		OdsInventoryInfoDtlDTO dto = new OdsInventoryInfoDtlDTO();
		Pager<OdsInventoryInfoDtl> page = new Pager<OdsInventoryInfoDtl>();
		List<OdsInventoryInfoDtl> li = new ArrayList<OdsInventoryInfoDtl>();
		li.add(new OdsInventoryInfoDtl());
		page.setRecords(li);
		
		EasyMock.expect(odsInventoryInfoDtlServiceMock.searchOdsInventoryInfoDtls((Pager<OdsInventoryInfoDtl>)EasyMock.anyObject()
				,(OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(page).times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.getStockAgeReport(pager, dto);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testGetInventoryInfoDtlByParams() {
		OdsInventoryInfoDtlDTO dto = new OdsInventoryInfoDtlDTO();
		List<OdsInventoryInfoDtl> list = new ArrayList<OdsInventoryInfoDtl>();
		list.add(new OdsInventoryInfoDtl());
		
		EasyMock.expect(odsInventoryInfoDtlServiceMock.getOdsInventoryInfoDtlByParam((OdsInventoryInfoDtl)EasyMock.anyObject()))
			.andReturn(list).times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.getInventoryInfoDtlByParams(dto);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSapQtyDetail() {
		EasyMock.expect(odsInventoryInfoDtlServiceMock.sapQtyDetail((Pager<OdsInventoryInfoDtl>)EasyMock.anyObject()
				,(OdsInventoryInfoDtl)EasyMock.anyObject())).andReturn(new Pager<OdsInventoryInfoDtl>()).times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.sapQtyDetail(new Pager<OdsInventoryInfoDtlDTO>(), new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testBarcodeRemarkUpdate() {
		mockStatic(UserUtil.class);
		BaseUser name = new BaseUser();
		name.setName("test");
		when(UserUtil.getCurrentUser()).thenReturn(name);
		EasyMock.expect(odsInventoryInfoDtlServiceMock.updateBarcodeRemark((OdsInventoryInfoDtl)EasyMock.anyObject()))
			.andReturn(new ExecuteResult<OdsInventoryInfoDtl>()).times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.barcodeRemarkUpdate(new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void testUpdateBarcodeStatus() {
		List<OdsInventoryInfoDtlDTO> list = new ArrayList<OdsInventoryInfoDtlDTO>();
		list.add(new OdsInventoryInfoDtlDTO());
		EasyMock.expect(odsInventoryInfoDtlServiceMock.updateBarcodeStatus((String)EasyMock.anyObject()
				,(String)EasyMock.anyObject())).andReturn("").times(1);
		EasyMock.replay(odsInventoryInfoDtlServiceMock);
		clientImplMock.updateBarcodeStatus(list, "");
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
		clientImplMock.getExportAmount(new OdsInventoryInfoDtlDTO());
	}

}
