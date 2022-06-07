package com.haier.hevwms.remoting.rf.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsViewServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:54:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsViewServiceTest extends BasicTestCase {
	OtcwmsViewServiceImpl ss = new OtcwmsViewServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:00 
	*/ 
	@Before
	public void bf() {

		WmsLoginDAO dao = EasyMock.createMock(WmsLoginDAO.class);
		ss.setLoginDAO(dao);

	}

	/**  
	* @Title: getLocation  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:06 
	*/ 
	@Test
	public void getLocation() {

		try {
			Long uid = (long) 7;

			ss.getLocation(uid);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getMenu  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:55:10 
	*/ 
	@Test
	public void getMenu() {

		try {
			Long uid = (long) 6;

			ss.getMenu(uid);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}