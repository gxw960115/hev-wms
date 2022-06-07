package com.haier.hevwms.takestock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.takestock.dao.OdsPdTempDAO;
import com.haier.hevwms.takestock.dao.OdsPdTempDtlDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsPdTempServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:28:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsPdTempServiceTest extends BasicTestCase {
	OdsPdTempServiceImpl ss = new OdsPdTempServiceImpl();
	private OdsPdTempDAO odsPdTempdao;

	private OdsPdTempDtlDAO odsPdTempDtlDao;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:31 
	*/ 
	@Before
	public void bf() {

		odsPdTempdao = EasyMock.createMock(OdsPdTempDAO.class);
		odsPdTempDtlDao = EasyMock.createMock(OdsPdTempDtlDAO.class);
		ss.setOdsPdTempdao(odsPdTempdao);
		ss.setOdsPdTempDtlDao(odsPdTempDtlDao);

	}

	/**
	 * 
	 * <p>
	 * Title: addPdTempOrder
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 增加临时盘点单
	 * 
	 * @param pdTempDTO
	 * @return
	 * @see com.haier.hevwms.takestock.service.OdsPdTempService#addPdTempOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */

	@Test
	public void addPdTempOrder() {

		try {
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);

			ss.addPdTempOrder(pdTempDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * 
	 * <p>
	 * Title: updateOrderStatus
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 更新状态
	 * 
	 * @param pdTempDTO
	 * @return
	 * @see com.haier.hevwms.takestock.service.OdsPdTempService#updateOrderStatus(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */

	@Test
	public void updateOrderStatus() {

		try {
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			pdTempDTO.setStatus("3");
            EasyMock.expect(odsPdTempdao.updateStatus(EasyMock.isA(OdsPdTempDTO.class))).andReturn(2);
            EasyMock.replay(odsPdTempdao);
			ss.updateOrderStatus(pdTempDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * 
	 * <p>
	 * Title: searchOdsPdTemps
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 分页查询
	 * 
	 * @param pdTempDTO
	 * @return
	 * @see com.haier.hevwms.takestock.service.OdsPdTempService#searchOdsPdTemps(com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO)
	 */

	@Test
	public void searchOdsPdTemps() {

		try {
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			Long pageSize = (long) 8;
			Long currentPage = (long) 10;
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(2L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.searchOdsPdTemps(pdTempDTO, pageSize, currentPage);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: orderCheck  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:48 
	*/ 
	@Test
	public void orderCheck() {

		try {
			String orderNo = "5";
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(2L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.orderCheck(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: orderCheck1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:53 
	*/ 
	@Test
	public void orderCheck1() {

		try {
			String orderNo = "5";
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			list.add(pdTempDTO);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(1L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.orderCheck(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCheck2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:28:58 
	*/ 
	@Test
	public void orderCheck2() {

		try {
			String orderNo = "5";
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			pdTempDTO.setStatus("1");
			list.add(pdTempDTO);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(1L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.orderCheck(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCheck3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:29:04 
	*/ 
	@Test
	public void orderCheck3() {

		try {
			String orderNo = "5";
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			pdTempDTO.setStatus("2");
			list.add(pdTempDTO);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(1L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.orderCheck(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: orderCheck4  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:29:09 
	*/ 
	@Test
	public void orderCheck4() {

		try {
			String orderNo = "5";
			List<OdsPdTempDTO> list=new ArrayList<OdsPdTempDTO>();
			OdsPdTempDTO pdTempDTO = (OdsPdTempDTO) getBean(OdsPdTempDTO.class);
			pdTempDTO.setStatus("3");
			list.add(pdTempDTO);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOsCount(EasyMock.isA(OdsPdTempDTO.class))).andReturn(1L);
			 EasyMock.expect(odsPdTempdao.searchOdsPdTempDTOs(EasyMock.isA(OdsPdTempDTO.class),EasyMock.anyLong(),EasyMock.anyLong())).andReturn(list);
	            EasyMock.replay(odsPdTempdao);
			ss.orderCheck(orderNo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}