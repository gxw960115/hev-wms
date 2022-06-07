package com.haier.openplatform.wms.stocktaking.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.hevwms.takestock.service.OdsPdInfoDtlService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;

/**
 * @项目名称otcwms-service-impl
 * @类名称StocktakingDtlServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class StocktakingDtlServiceClientImplTest {

	private StocktakingDtlServiceClientImpl clientImplMock = new StocktakingDtlServiceClientImpl();
	private OdsPdInfoDtlService odsPdInfoDtlServiceMock;

	@Before
	public void init() {
		odsPdInfoDtlServiceMock = EasyMock.createMock(OdsPdInfoDtlService.class);
		clientImplMock.setOdsPdInfoDtlService(odsPdInfoDtlServiceMock);
	}

//	@Test
//	public void testSetOdsPdInfoDtlService() {
//		fail("Not yet implemented");
//	}

	/**
	* @Title: testSearchStocktakingOrderDtl
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:45
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchStocktakingOrderDtl() {
		Pager<OdsPdInfoDtl> temp = new Pager<OdsPdInfoDtl>();
		OdsPdInfoDtlDTO odsPdInfoDtlDTO = new OdsPdInfoDtlDTO();

		try {
			EasyMock.expect(odsPdInfoDtlServiceMock.searchOdsPdInfoDtls((Pager<OdsPdInfoDtl>)EasyMock.anyObject()
					,(OdsPdInfoDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdInfoDtlServiceMock);

			clientImplMock.searchStocktakingOrderDtl(1L, 10L, odsPdInfoDtlDTO);
		}catch (Exception e) {

		}
		assertThat(1, is(1));
	}

	/**
	* @Title: testGetOdsPdInfoDtls
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:51
	 */
	@Test
	public void testGetOdsPdInfoDtls() {
		OdsPdInfoDtlDTO odsPdInfoDtlDTO = new OdsPdInfoDtlDTO();
		List<OdsPdInfoDtl> temp = new ArrayList<OdsPdInfoDtl>();
		OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
		odsPdInfoDtl.setCreateBy("test");
		temp.add(odsPdInfoDtl);

		try {
			EasyMock.expect(odsPdInfoDtlServiceMock.getOdsPdInfoDtls((OdsPdInfoDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdInfoDtlServiceMock);
		}catch (Exception e) {

		}

		clientImplMock.getOdsPdInfoDtls(odsPdInfoDtlDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchStocktakingOrderDtlSum
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:55
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchStocktakingOrderDtlSum() {
		OdsPdInfoDtlDTO odsPdInfoDtlDTO = new OdsPdInfoDtlDTO();
		Pager<OdsPdInfoDtl> temp = new Pager<OdsPdInfoDtl>();
		temp.setTotalRecords(10L);
		List<OdsPdInfoDtl> listInfo = temp.getRecords();
		OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
		odsPdInfoDtl.setCreateBy("test");
		listInfo.add(odsPdInfoDtl);

		try {
			EasyMock.expect(odsPdInfoDtlServiceMock.searchOdsPdInfoDtlsBySum((Pager<OdsPdInfoDtl>)EasyMock.anyObject()
					,(OdsPdInfoDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdInfoDtlServiceMock);
		}catch (Exception e) {

		}
		clientImplMock.searchStocktakingOrderDtlSum(1L, 10L, odsPdInfoDtlDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchStocktakingOrderDtlSumList
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:45:59
	 */
	@Test
	public void testSearchStocktakingOrderDtlSumList() {
		OdsPdInfoDtlDTO odsPdInfoDtlDTO = new OdsPdInfoDtlDTO();
		List<OdsPdInfoDtl> dtls = new ArrayList<OdsPdInfoDtl>();
		OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
		odsPdInfoDtl.setCreateBy("test");
		dtls.add(odsPdInfoDtl);

		try {
			EasyMock.expect(odsPdInfoDtlServiceMock.searchOdsPdInfoDtlsBySum2((OdsPdInfoDtl)EasyMock.anyObject())).andReturn(dtls).times(1);
			EasyMock.replay(odsPdInfoDtlServiceMock);
		}catch (Exception e) {

		}
		clientImplMock.searchStocktakingOrderDtlSumList(odsPdInfoDtlDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testGetPdQtyDetail
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:03
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetPdQtyDetail() {
		OdsPdInfoDtlDTO odsPdInfoDtlDTO = new OdsPdInfoDtlDTO();
		Pager<OdsPdInfoDtl> temp = new  Pager<OdsPdInfoDtl>();
		temp.setTotalRecords(10L);
		List<OdsPdInfoDtl> listInfo = temp.getRecords();
		OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
		odsPdInfoDtl.setCreateBy("test");
		listInfo.add(odsPdInfoDtl);

		try {
			EasyMock.expect(odsPdInfoDtlServiceMock.pdQtyDetail((Pager<OdsPdInfoDtl>)EasyMock.anyObject(),
					(OdsPdInfoDtl)EasyMock.anyObject())).andReturn(temp).times(1);
			EasyMock.replay(odsPdInfoDtlServiceMock);
		}catch (Exception e) {

		}
		clientImplMock.getPdQtyDetail(1L, 10L, odsPdInfoDtlDTO);
		assertThat(1, is(1));
	}

	/**
	* @Title: testGetPdExportAmount
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:07
	 */
	@Test
	public void testGetPdExportAmount() {
		OdsPdInfoDtlDTO dto = new OdsPdInfoDtlDTO();
		clientImplMock.getPdExportAmount(dto);
		assertThat(1, is(1));
	}

	/**
	* @Title: testSearchOdsPdInfoDtlsCountBySum
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:46:11
	 */
	@Test
	public void testSearchOdsPdInfoDtlsCountBySum() {
		OdsPdInfoDtlDTO dto = new OdsPdInfoDtlDTO();
		clientImplMock.searchOdsPdInfoDtlsCountBySum(dto);
		assertThat(1, is(1));
	}

}
