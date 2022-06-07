package com.haier.hevwms.remoting.rf.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.OtcwmsLogoutDAO;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutPara;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsLogoutServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:46:03 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsLogoutServiceTest extends BasicTestCase {
	OtcwmsLogoutServiceImpl ss = new OtcwmsLogoutServiceImpl();
	OtcwmsLogoutDAO dao;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:06 
	*/ 
	@Before
	public void bf() {

		dao = EasyMock.createMock(OtcwmsLogoutDAO.class);
		ss.setLogoutDAO(dao);

	}

	/**  
	* @Title: userLogout  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:14 
	*/ 
	@Test
	public void userLogout() {

		try {
			LogoutPara logoutPara = (LogoutPara) getBean(LogoutPara.class);
			logoutPara.setUser(null);
			ss.userLogout(logoutPara);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: userLogout1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:20 
	*/ 
	@Test
	public void userLogout1() {

		try {

			LogoutPara logoutPara = (LogoutPara) getBean(LogoutPara.class);
			EasyMock.expect(dao.resetSign(logoutPara.getUser())).andReturn(3).anyTimes();
			EasyMock.replay(dao);
			ss.userLogout(logoutPara);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: userLogout2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:46:24 
	*/ 
	@Test
	public void userLogout2() {

		try {
			EasyMock.expect(dao.resetSign(EasyMock.isA(String.class))).andReturn(0).anyTimes();
			LogoutPara logoutPara = (LogoutPara) getBean(LogoutPara.class);
			EasyMock.replay(dao);
			ss.userLogout(logoutPara);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	 
}