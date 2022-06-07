package com.haier.hevwms.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.report.dao.StoIntransitReportDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StoIntransitReportServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:04:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StoIntransitReportServiceTest extends BasicTestCase {
	StoIntransitReportServiceImpl ss = new StoIntransitReportServiceImpl();
	StoIntransitReportDAO dao;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:05:01 
	*/ 
	@Before
	public void bf() {

		dao = EasyMock.createMock(StoIntransitReportDAO.class);
		ss.setStoIntransitReportDAO(dao);
		ss.getStoIntransitReportDAO();

	}

	/**  
	* @Title: searchStoIntransitReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:05:03 
	*/ 
	@Test
	public void searchStoIntransitReportInfos() {

		try {
			List<StoIntransitReportDTO> dto  =new ArrayList<StoIntransitReportDTO>();
			Pager pager = (Pager) getBean(Pager.class);
			StoIntransitReportDTO stoIntransitReportDTO = (StoIntransitReportDTO) getBean(StoIntransitReportDTO.class);
			dto.add(stoIntransitReportDTO);
			EasyMock.expect(dao.searchStoIntransitReportInfosCount(EasyMock.isA(StoIntransitReportDTO.class))).andReturn(2L);
            EasyMock.expect(dao.searchStoIntransitReportInfos(EasyMock.isA(Pager.class),EasyMock.isA(StoIntransitReportDTO.class))).andReturn(dto);
			  EasyMock.replay(dao);
			ss.searchStoIntransitReportInfos(pager, stoIntransitReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStoIntransitReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:05:07 
	*/ 
	@Test
	public void getStoIntransitReportInfos() {

		try {
			StoIntransitReportDTO stoIntransitReportDTO = (StoIntransitReportDTO) getBean(StoIntransitReportDTO.class);

			ss.getStoIntransitReportInfos(stoIntransitReportDTO);
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
	* @date: 2018年6月27日 下午4:05:11 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StoIntransitReportDTO stoIntransitReportDTO = (StoIntransitReportDTO) getBean(StoIntransitReportDTO.class);

			ss.getExportAmount(stoIntransitReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}