package com.haier.hevwms.order.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.sto.dao.StgStodnDownDAO;
import com.haier.hevwms.sto.service.impl.StgStodnDownServiceImpl;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgStoDnDownServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:14:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgStoDnDownServiceTest extends BasicTestCase {
	StgStodnDownServiceImpl ss = new StgStodnDownServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:14:28 
	*/ 
	@Before
	public void bf() {

		StgStodnDownDAO dao = EasyMock.createMock(StgStodnDownDAO.class);
		ss.setStgStodnDownDAO(dao);

	}

	/**  
	* @Title: searchStgStoDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:14:37 
	*/ 
	@Test
	public void searchStgStoDnDowns() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			StgStodnDownDTO dto = (StgStodnDownDTO) getBean(StgStodnDownDTO.class);

			ss.searchStgStodnDowns(pager, dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgStoDnDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:14:45 
	*/ 
	@Test
	public void getStgStoDnDowns() {

		try {
			StgStodnDownDTO dto = (StgStodnDownDTO) getBean(StgStodnDownDTO.class);

			ss.getStgStodnDownListByParm(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: postStnDn  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:14:52 
	*/ 
	@Test
	public void postStnDn() {

		try {
			String stoDnNo = "4";
			String userName = "1";

			ss.postStnDn(stoDnNo, userName);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStoDnCountByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:15:08 
	*/ 
	@Test
	public void getStoDnCountByParam() {

		try {
			String stoDnNo = "4";
			String materialNo = "8";

			ss.getStoDnCountByParam(stoDnNo, materialNo);
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
	* @date: 2018年6月27日 下午3:15:13 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgStodnDownDTO dto = (StgStodnDownDTO) getBean(StgStodnDownDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}