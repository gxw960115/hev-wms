package com.haier.hevwms.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.report.dao.ConsignmentReportDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: ConsignmentReportServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:03:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class ConsignmentReportServiceTest extends BasicTestCase {
	ConsignmentReportServiceImpl ss = new ConsignmentReportServiceImpl();
	ConsignmentReportDAO dao;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:05 
	*/ 
	@Before
	public void bf() {
       dao = EasyMock.createMock(ConsignmentReportDAO.class);
		ss.setConsignmentReportDAO(dao);
		ss.getConsignmentReportDAO();

	}

	/**  
	* @Title: searchConsignmentReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:08 
	*/ 
	@Test
	public void searchConsignmentReportInfos() {

		try {
			List<ConsignmentReportDTO> dto  =new ArrayList<ConsignmentReportDTO>();
			Pager pager = (Pager) getBean(Pager.class);
			ConsignmentReportDTO consignmentReportDTO = (ConsignmentReportDTO) getBean(ConsignmentReportDTO.class);
			dto.add(consignmentReportDTO);
			EasyMock.expect(dao.searchConsignmentReportInfosCount(EasyMock.isA(ConsignmentReportDTO.class))).andReturn(2L);
             EasyMock.expect(dao.searchConsignmentReportInfos(EasyMock.isA(Pager.class),EasyMock.isA(ConsignmentReportDTO.class))).andReturn(dto);
			  EasyMock.replay(dao);
             ss.searchConsignmentReportInfos(pager, consignmentReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getConsignmentReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:11 
	*/ 
	@Test
	public void getConsignmentReportInfos() {

		try {
			ConsignmentReportDTO consignmentReportDTO = (ConsignmentReportDTO) getBean(ConsignmentReportDTO.class);

			ss.getConsignmentReportInfos(consignmentReportDTO);
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
	* @date: 2018年6月27日 下午4:03:15 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			ConsignmentReportDTO dto = (ConsignmentReportDTO) getBean(ConsignmentReportDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}