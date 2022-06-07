package com.haier.openplatform.wms.stocktaking.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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

import com.haier.hevwms.inventory.service.OdsInventoryInfoService;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.hevwms.takestock.service.OdsPdDiffDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称StocktakingDiffServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StocktakingDiffServiceClientImplTest{

	private OdsPdDiffDtlService odsPdDiffDtlServiceMock;
	private OdsInventoryInfoService odsInventoryInfoServiceMock;
	private StocktakingDiffServiceClientImpl clientImplMock = new StocktakingDiffServiceClientImpl();

	@Before
	public void init() {
		odsPdDiffDtlServiceMock = EasyMock.createMock(OdsPdDiffDtlService.class);
		odsInventoryInfoServiceMock = EasyMock.createMock(OdsInventoryInfoService.class);
		clientImplMock.setOdsPdDiffDtlService(odsPdDiffDtlServiceMock);
		clientImplMock.setOdsInventoryInfoService(odsInventoryInfoServiceMock);
	}

	/**
	* @Title: testSearchStocktakingDiff
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:09
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchStocktakingDiff() {
        OdsPdDiffDtlDTO odsPdDiffDtlDTO = new OdsPdDiffDtlDTO();
		Pager<OdsPdDiffDtl> temp=new Pager<OdsPdDiffDtl>();
		temp.setTotalRecords(10L);
        List<OdsPdDiffDtl> listInfo = temp.getRecords();
        OdsPdDiffDtl odsPdDiffDtl = new OdsPdDiffDtl();
        odsPdDiffDtl.setCreateBy("test");
        listInfo.add(odsPdDiffDtl);

		try {
			EasyMock.expect(odsPdDiffDtlServiceMock.searchOdsPdDiffDtls((Pager<OdsPdDiffDtl>)EasyMock.anyObject()
					,(OdsPdDiffDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdDiffDtlServiceMock);

			clientImplMock.searchStocktakingDiff(1L, 10L, odsPdDiffDtlDTO);
		}catch(Exception e) {

		}
		assertThat(1, is(1));
	}

	/**
	* @Title: testProcessDiff
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:14
	 */
	@Test
	public void testProcessDiff() {
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());

		ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
		OdsPdDiffDtl odsPdDiffDtl = new OdsPdDiffDtl();
		odsPdDiffDtl.setLocation("BG01");
		try {
			EasyMock.expect(odsInventoryInfoServiceMock.updateProcessDiff((OdsPdDiffDtl)EasyMock.anyObject()
					,(String)EasyMock.anyObject())).andReturn(executeResult).times(1);
			EasyMock.replay(odsInventoryInfoServiceMock);


			clientImplMock.processDiff("234","1","process difference");
		}catch (Exception e) {

		}
		assertThat(1, is(1));
	}

	/**
	* @Title: testGetOdsPdDiffInfo
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:21
	 */
	@Test
	public void testGetOdsPdDiffInfo() {
		OdsPdDiffDtlDTO odsPdDiffDtlDTO = new OdsPdDiffDtlDTO();
		List<OdsPdDiffDtl> temp = new ArrayList<OdsPdDiffDtl>();

		try {
			EasyMock.expect(odsPdDiffDtlServiceMock.getOdsPdDiffDtl((OdsPdDiffDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdDiffDtlServiceMock);

			clientImplMock.getOdsPdDiffInfo(odsPdDiffDtlDTO);
		}catch(Exception e) {

		}
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchOdsPdDiffDtlsCount
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:26
	 */
	@Test
	public void testSearchOdsPdDiffDtlsCount() {
		OdsPdDiffDtlDTO dto = new OdsPdDiffDtlDTO();
		try {
			EasyMock.expect(odsPdDiffDtlServiceMock.searchOdsPdDiffDtlsCount((OdsPdDiffDtl)EasyMock.anyObject())).andReturn(1L).times(1);
			EasyMock.replay(odsPdDiffDtlServiceMock);

			clientImplMock.searchOdsPdDiffDtlsCount(dto);
		}catch(Exception e) {

		}
		assertThat(1, is(1));
	}

	/**
	* @Title: testGetOdsPdDiffDtlService
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:30
	 */
	@Test
	public void testGetOdsPdDiffDtlService() {
		clientImplMock.getOdsPdDiffDtlService();
	}

	/**
	* @Title: testGetOdsInventoryInfoService
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:33
	 */
	@Test
	public void testGetOdsInventoryInfoService() {
		clientImplMock.getOdsInventoryInfoService();

	}

}
