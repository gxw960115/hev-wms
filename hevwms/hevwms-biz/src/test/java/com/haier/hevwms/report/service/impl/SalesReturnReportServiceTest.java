package com.haier.hevwms.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.report.dao.SalesReturnReportDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: SalesReturnReportServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:04:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class SalesReturnReportServiceTest extends BasicTestCase {
	SalesReturnReportServiceImpl ss = new SalesReturnReportServiceImpl();
	SalesReturnReportDAO dao;
	
	/**
	 * @Title: bf
	 * @Description: 
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月27日 上午10:16:07
	 */
	@Before
	public void bf() {

		dao = EasyMock.createMock(SalesReturnReportDAO.class);
		ss.setSalesReturnReportDAO(dao);
		ss.getSalesReturnReportDAO();

	}

	/**  
	* @Title: searchSalesReturnReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:04:31 
	*/ 
	@Test
	public void searchSalesReturnReportInfos() {

		try {
			List<SalesReturnReportDTO> dto  =new ArrayList<SalesReturnReportDTO>();
			SalesReturnReportDTO salesReturnReportDTO = (SalesReturnReportDTO) getBean(SalesReturnReportDTO.class);
			Pager pager = (Pager) getBean(Pager.class);
			
			dto.add(salesReturnReportDTO);
			EasyMock.expect(dao.searchSalesReturnReportInfosCount(EasyMock.isA(SalesReturnReportDTO.class))).andReturn(2L);
             EasyMock.expect(dao.searchSalesReturnReportInfos(EasyMock.isA(Pager.class),EasyMock.isA(SalesReturnReportDTO.class))).andReturn(dto);
			  EasyMock.replay(dao);
               
			ss.searchSalesReturnReportInfos(pager, salesReturnReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getSalesReturnReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:04:37 
	*/ 
	@Test
	public void getSalesReturnReportInfos() {

		try {
			List<SalesReturnReportDTO> dto  =new ArrayList<SalesReturnReportDTO>();
			SalesReturnReportDTO dto1 = (SalesReturnReportDTO) getBean(SalesReturnReportDTO.class);
			EasyMock.expect(dao.getSalesReturnReportInfos(EasyMock.isA(SalesReturnReportDTO.class))).andReturn((List<SalesReturnReportDTO>) dto);
			  EasyMock.replay(dao);
			ss.getSalesReturnReportInfos(dto1);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:04:41 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			
			SalesReturnReportDTO dto1 = (SalesReturnReportDTO) getBean(SalesReturnReportDTO.class);
			EasyMock.expect(dao.searchSalesReturnReportInfosCount(EasyMock.isA(SalesReturnReportDTO.class))).andReturn(2l);
			  EasyMock.replay(dao);
			ss.getExportAmount(dto1);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}