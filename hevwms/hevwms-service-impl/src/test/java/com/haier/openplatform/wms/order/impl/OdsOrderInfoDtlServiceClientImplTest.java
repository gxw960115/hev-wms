package com.haier.openplatform.wms.order.impl;

import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.po.impl.OdsOrderInfoDtlServiceClientImpl;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @项目名称otcwms-service-impl
 * @类名称OdsOrderInfoDtlServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
public class OdsOrderInfoDtlServiceClientImplTest {
	private OdsOrderInfoDtlServiceClientImpl clientImplMock = new OdsOrderInfoDtlServiceClientImpl();
	private OdsOrderInfoDtlService odsOrderInfoDtlServiceMock;

	/**
	* @Title: init
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:23
	 */
	@Before
	public void init() {
		odsOrderInfoDtlServiceMock = EasyMock.createMock(OdsOrderInfoDtlService.class);
		clientImplMock.setOdsOrderInfoDtlService(odsOrderInfoDtlServiceMock);
	}

	/**
	* @Title: testSearchOdsOrderDtls
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:27
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchOdsOrderDtls() {
		Pager<OdsOrderInfoDtlDTO> pager2=new Pager<OdsOrderInfoDtlDTO>();
		OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();

		EasyMock.expect(odsOrderInfoDtlServiceMock.searchOdsOrderInfoDtls((Pager<OdsOrderInfoDtlDTO>)EasyMock.anyObject()
				,(OdsOrderInfoDtlDTO)EasyMock.anyObject())).andReturn(pager2).times(1);
		EasyMock.replay(odsOrderInfoDtlServiceMock);

		clientImplMock.searchOdsOrderDtls(1L, 10L, odsOrderInfoDtlDTO);
	}

	/**
	* @Title: testGetExportAmount
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:31
	 */
	@Test
	public void testGetExportAmount() {
		OdsOrderInfoDtlDTO odsOrderInfoDtl = new OdsOrderInfoDtlDTO();
		clientImplMock.getExportAmount(odsOrderInfoDtl);
	}

	/**
	* @Title: testSerchOdsOrderDtlsBy
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:34
	 */
	@Test
	public void testSerchOdsOrderDtlsBy() {
		clientImplMock.serchOdsOrderDtlsBy("", "", new Date(), new Date());
	}

	/**
	* @Title: testGetOdsOrderInfoDtls
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:38
	 */
	@Test
	public void testGetOdsOrderInfoDtls() {
		OdsOrderInfoDtlDTO odsOrderInfoDtl = new OdsOrderInfoDtlDTO();
		clientImplMock.getOdsOrderInfoDtls(odsOrderInfoDtl);
	}

	/**
	* @Title: directDispatch
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午1:47:38
	 */
	@Test
	public void directDispatch() throws InvocationTargetException, IllegalAccessException {
		clientImplMock.directDispatch("423q4", "353453", "435436");
	}
}
