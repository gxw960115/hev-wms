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

import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称StocktakingServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StocktakingServiceClientImplTest {
	private OdsPdInfoService odsPdInfoServiceMock;
	private StocktakingServiceClientImpl clientImplMock = new StocktakingServiceClientImpl();

	@Before
	public void init() {
		odsPdInfoServiceMock = EasyMock.createMock(OdsPdInfoService.class);
		clientImplMock.setOdsPdInfoService(odsPdInfoServiceMock);
	}

	/**
	* @Title: testAddStocktakingOrder
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:23
	 */
	@Test
	public void testAddStocktakingOrder() {
		OdsPdInfoDTO dto = new OdsPdInfoDTO();
		clientImplMock.addStocktakingOrder(dto);
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchStocktakingOrder
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:27
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchStocktakingOrder() {
		OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();
		Pager<OdsPdInfo> temp = new Pager<OdsPdInfo>();
		temp.setTotalRecords(10L);
		List<OdsPdInfo> listInfo = temp.getRecords();
		OdsPdInfo odsPdInfo = new OdsPdInfo();
		odsPdInfo.setCreateBy("test");
		listInfo.add(odsPdInfo);

		EasyMock.expect(odsPdInfoServiceMock.searchOdsPdInfos((Pager<OdsPdInfo>)EasyMock.anyObject()
				,(OdsPdInfo)EasyMock.anyObject())).andReturn(temp).times(1);
		EasyMock.replay(odsPdInfoServiceMock);

		clientImplMock.searchStocktakingOrder(1L, 10L, odsPdInfoDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testUpdateStocktakingOrder
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:31
	 */
	@Test
	public void testUpdateStocktakingOrder() {
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
		ExecuteResult<OdsPdInfo> result = new ExecuteResult<OdsPdInfo>();
		OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();
		EasyMock.expect(odsPdInfoServiceMock.updateOrderStatus((OdsPdInfo)EasyMock.anyObject())).andReturn(result).times(1);
		EasyMock.replay(odsPdInfoServiceMock);

		clientImplMock.updateStocktakingOrder(odsPdInfoDTO);
	}

	/**
	* @Title: testGetOdsPdInfo
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:52
	 */
	@Test
	public void testGetOdsPdInfo() {
		List<OdsPdInfo> temp = new ArrayList<OdsPdInfo>();
		OdsPdInfo odsPdInfo = new OdsPdInfo();
		odsPdInfo.setCreateBy("test");
		temp.add(odsPdInfo);
		OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();

		EasyMock.expect(odsPdInfoServiceMock.getOdsPdInfo((OdsPdInfo)EasyMock.anyObject())).andReturn(temp).times(1);
		EasyMock.replay(odsPdInfoServiceMock);
		clientImplMock.getOdsPdInfo(odsPdInfoDTO);

		assertThat(1, is(1));
	}

	/**
	* @Title: testGetStocktakingOrderNo
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:57
	 */
	@Test
	public void testGetStocktakingOrderNo() {
		EasyMock.expect(odsPdInfoServiceMock.selectStocktakingOrderNo()).andReturn("we").times(1);
		EasyMock.replay(odsPdInfoServiceMock);

		clientImplMock.getStocktakingOrderNo();
		assertThat(1, is(1));
	}

	/**
	* @Title: testAddStocktakingOrders
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:00
	 */
	@Test
	public void testAddStocktakingOrders() {
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());

		List<OdsPdInfoDTO> pds = new ArrayList<OdsPdInfoDTO>();
		OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();
		pds.add(odsPdInfoDTO);
		EasyMock.expect(odsPdInfoServiceMock.createOdsPdInfo((OdsPdInfo)EasyMock.anyObject())).andReturn("we").times(1);
		EasyMock.replay(odsPdInfoServiceMock);

		clientImplMock.addStocktakingOrders(odsPdInfoDTO, pds);
	}

	/**
	* @Title: testDeleteStocktakingOrder
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:04
	 */
	@Test
	public void testDeleteStocktakingOrder() {
		BaseUser name = new BaseUser();
		name.setName("test");
		mockStatic(UserUtil.class);
		when(UserUtil.getCurrentUser()).thenReturn(name);
		ExecuteResult<OdsPdInfo> result = new ExecuteResult<OdsPdInfo>();
		OdsPdInfoDTO odsPdInfoDTO = new OdsPdInfoDTO();
		odsPdInfoDTO.setCreateBy("test");

		EasyMock.expect(odsPdInfoServiceMock.deleteOrder((OdsPdInfo)EasyMock.anyObject())).andReturn(result).times(1);
		EasyMock.replay(odsPdInfoServiceMock);

		clientImplMock.deleteStocktakingOrder(odsPdInfoDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchOdsPdInfosCount
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:08
	 */
	@Test
	public void testSearchOdsPdInfosCount() {
		OdsPdInfoDTO dto = new OdsPdInfoDTO();
		clientImplMock.searchOdsPdInfosCount(dto);
		assertThat(1, is(1));
	}

}
