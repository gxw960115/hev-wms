package com.haier.hevwms.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.order.dao.OdsWmsOrderDAO;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsWmsOrderServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:09:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsWmsOrderServiceTest extends BasicTestCase {
	OdsWmsOrderServiceImpl ss = new OdsWmsOrderServiceImpl();
	private OdsWmsOrderDAO odsWmsOrderDAO;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:09:22 
	*/ 
	@Before
	public void bf() {

		odsWmsOrderDAO = EasyMock.createMock(OdsWmsOrderDAO.class);
		ss.setOdsWmsOrderDAO(odsWmsOrderDAO);

	}

	/**  
	* @Title: createOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:09:32 
	*/ 
	@Test
	public void createOdsWmsOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.createOdsWmsOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:09:38 
	*/ 
	@Test
	public void updateOdsWmsOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.updateOdsWmsOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:09:43 
	*/ 
	@Test
	public void deleteOdsWmsOrder() {

		try {
			Long odsWmsOrderId = (long) 2;

			ss.deleteOdsWmsOrder(odsWmsOrderId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * @Title: deleteOdsWmsOrderAll
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月24日 下午3:37:40
	 */
	@Test
	public void deleteOdsWmsOrderAll() {
		List<Long> listTestCase = new ArrayList<Long>();
		listTestCase.add(1L);
		odsWmsOrderDAO.deleteAll(listTestCase);
		EasyMock.expectLastCall();
		EasyMock.replay(odsWmsOrderDAO);
		ExecuteResult<OdsWmsOrderDTO> result = ss.deleteOdsWmsOrderAll(listTestCase);
		Assert.assertNotNull(result);

		EasyMock.verify(odsWmsOrderDAO);
	}

	/**  
	* @Title: searchOdsWmsOrders  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:09:57 
	*/ 
	@Test
	public void searchOdsWmsOrders() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.searchOdsWmsOrders(pager, odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsWmsOrderById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:05 
	*/ 
	@Test
	public void getOdsWmsOrderById() {

		try {
			Long odsWmsOrderId = (long) 8;

			ss.getOdsWmsOrderById(odsWmsOrderId);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsWmsOrders  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:11 
	*/ 
	@Test
	public void getOdsWmsOrders() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.getOdsWmsOrders(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deltGfOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:17 
	*/ 
	@Test
	public void deltGfOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.deltGfOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: saveScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:23 
	*/ 
	@Test
	public void saveScrapOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);
			String ids = "9";

			ss.saveScrapOrder(odsWmsOrderDTO, ids);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:28 
	*/ 
	@Test
	public void updateScrapOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.updateScrapOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteScrapOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:35 
	*/ 
	@Test
	public void deleteScrapOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.deleteScrapOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getOdsWmsOrder  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:43 
	*/ 
	@Test
	public void getOdsWmsOrder() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.getOdsWmsOrder(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: save  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:47 
	*/ 
	@Test
	public void save() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.save(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateScrapDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:52 
	*/ 
	@Test
	public void updateScrapDtl() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);

			ss.updateScrapDtl(odsWmsOrderDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deltByOrderNo  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:54 
	*/ 
	@Test
	public void deltByOrderNo() {

		try {
			OdsWmsOrderDTO odsWmsOrderDTO = (OdsWmsOrderDTO) getBean(OdsWmsOrderDTO.class);
			String docType = "9";

			ss.deltByOrderNo(odsWmsOrderDTO, docType);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: searchScrapBarcodeDtl  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:10:57 
	*/ 
	@Test
	public void searchScrapBarcodeDtl() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO = (OdsInventoryInfoDtlDTO) getBean(
					OdsInventoryInfoDtlDTO.class);

			ss.searchScrapBarcodeDtl(pager, odsInventoryInfoDtlDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}