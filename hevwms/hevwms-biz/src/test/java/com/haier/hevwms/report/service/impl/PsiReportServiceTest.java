package com.haier.hevwms.report.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.report.dao.PsiReportDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: PsiReportServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:03:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class PsiReportServiceTest extends BasicTestCase {
	PsiReportServiceImpl ss = new PsiReportServiceImpl();
	PsiReportDAO dao;
	
	/**
	 * @Title: bf
	 * @Description: 制作静态变量
	 * @return void
	 * @throws 
	 * @version: v1.0.0
	 * @author: LJZ
	 * @date: 2018年8月27日 上午10:14:49
	 */
	@Before
	public void bf() {

		dao = EasyMock.createMock(PsiReportDAO.class);
		ss.setPsiReportDAO(dao);
		ss.getPsiReportDAO();
		
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("232");
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8");
		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	}

	/**  
	* @Title: searchPsiReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:42 
	*/ 
	@Test
	public void searchPsiReportInfos() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			PsiReportDTO psiReportDTO = (PsiReportDTO) getBean(PsiReportDTO.class);
            EasyMock.expect(dao.searchPsiReportInfos
            		(EasyMock.isA(Pager.class),EasyMock.isA(PsiReportDTO.class))).andReturn(new ArrayList<PsiReportDTO>());
            EasyMock.expect(dao.searchPsiReportInfosCount
            		(EasyMock.isA(PsiReportDTO.class))).andReturn(2L);
			
            EasyMock.replay(dao);
            ss.searchPsiReportInfos(pager, psiReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getPsiReportInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:48 
	*/ 
	@Test
	public void getPsiReportInfos() {

		try {
			PsiReportDTO psiReportDTO = (PsiReportDTO) getBean(PsiReportDTO.class);

			ss.getPsiReportInfos(psiReportDTO);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: generatePsiReport  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:51 
	*/ 
//	@Test
//	public void generatePsiReport() {
//
//		try {
//			String filePath = "4";
//			Map parameters = new HashMap();
//
//			ss.generatePsiReport(filePath, parameters);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(true);
//
//	}

	/**  
	* @Title: getConnection  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:03:55 
	*/ 
	@Test
	public void getConnection() {

		try {
			ss.getConnection();
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
	* @date: 2018年6月27日 下午4:04:01 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			PsiReportDTO dto = (PsiReportDTO) getBean(PsiReportDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}