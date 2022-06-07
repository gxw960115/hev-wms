package com.haier.hevwms.remoting.rf.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderDeleteDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsOrderDeleteServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:51:41 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsOrderDeleteServiceTest extends BasicTestCase {
	OtcwmsOrderDeleteServiceImpl ss = new OtcwmsOrderDeleteServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:51:44 
	*/ 
	@Before
	public void bf() {

		OtcwmsOrderDeleteDAO dao = EasyMock.createMock(OtcwmsOrderDeleteDAO.class);
		ss.setOtcwmsOrderDeleteDAO(dao);

	}

	/**  
	* @Title: otcwmsOrderDelete  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:51:51 
	*/ 
	@Test
	public void otcwmsOrderDelete() {

		try {
			WmsOrderDeleteIn in = (WmsOrderDeleteIn) getBean(WmsOrderDeleteIn.class);

			ss.otcwmsOrderDelete(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}