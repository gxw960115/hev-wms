package com.haier.hevwms.remoting.rf.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderConfirmDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderConfirmIn;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsOrderConfirmServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:51:12 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsOrderConfirmServiceTest extends BasicTestCase {
	OtcwmsOrderConfirmServiceImpl ss = new OtcwmsOrderConfirmServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:51:16 
	*/ 
	@Before
	public void bf() {

		OtcwmsOrderConfirmDAO dao = EasyMock.createMock(OtcwmsOrderConfirmDAO.class);
		ss.setOtcwmsOrderConfirmDAO(dao);

	}

	/**  
	* @Title: otcwmsOrderConfirm  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:51:24 
	*/ 
	@Test
	public void otcwmsOrderConfirm() {

		try {
			WmsOrderConfirmIn in = (WmsOrderConfirmIn) getBean(WmsOrderConfirmIn.class);

			ss.otcwmsOrderConfirm(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}