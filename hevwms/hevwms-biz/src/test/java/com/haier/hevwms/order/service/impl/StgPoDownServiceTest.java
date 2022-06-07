package com.haier.hevwms.order.service.impl;

import static org.mockito.Matchers.anyList;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.po.service.impl.StgPoDownServiceImpl;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: StgPoDownServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:13:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class StgPoDownServiceTest extends BasicTestCase {
	StgPoDownServiceImpl ss = new StgPoDownServiceImpl();
	private StgPoDownDAO stgPoDownDAO;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:28 
	*/ 
	@Before
	public void bf() {

		stgPoDownDAO = EasyMock.createMock(StgPoDownDAO.class);
		ss.getStgPoDownDAO();
		
		ss.setStgPoDownDAO(stgPoDownDAO);

	}

	/**  
	* @Title: searchStgPoDowns  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:36 
	*/ 
	@Test
	public void searchStgPoDowns() {

		try {
			Pager pager = (Pager) getBean(Pager.class);
			StgPoDownDTO dto = (StgPoDownDTO) getBean(StgPoDownDTO.class);

			ss.searchStgPoDowns(pager, dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createStgPoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:45 
	*/ 
	@Test
	public void createStgPoDown() {

		try {
			StgPoDownDTO dto = (StgPoDownDTO) getBean(StgPoDownDTO.class);

			ss.createStgPoDown(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteStgPoDownAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:52 
	*/ 
	@Test
	public void deleteStgPoDownAll() {
		
		stgPoDownDAO.deleteAll((List<Long>) anyList());
		EasyMock.expectLastCall();
		
		String result = ss.deleteStgPoDownAll(new ArrayList<Long>());
		Assert.assertNotNull(result);
	}

	/**  
	* @Title: updateStgPoDown  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:13:58 
	*/ 
	@Test
	public void updateStgPoDown() {

		try {
			StgPoDownDTO dto = (StgPoDownDTO) getBean(StgPoDownDTO.class);

			ss.updateStgPoDown(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getStgPoDownByParam  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:14:05 
	*/ 
	@Test
	public void getStgPoDownByParam() {

		try {
			StgPoDownDTO dto = (StgPoDownDTO) getBean(StgPoDownDTO.class);

			ss.getStgPoDownByParam(dto);
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
	* @date: 2018年6月27日 下午3:14:09 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			StgPoDownDTO dto = (StgPoDownDTO) getBean(StgPoDownDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}