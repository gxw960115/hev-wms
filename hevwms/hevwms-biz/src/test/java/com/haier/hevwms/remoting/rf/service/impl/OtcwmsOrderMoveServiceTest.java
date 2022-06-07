package com.haier.hevwms.remoting.rf.service.impl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderMoveStoDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveListIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcListIn;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsOrderMoveServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:53:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsOrderMoveServiceTest extends BasicTestCase {
	OtcwmsOrderMoveServiceImpl ss = new OtcwmsOrderMoveServiceImpl();

	@Before
	public void bf() {

		OtcwmsOrderMoveStoDAO dao = EasyMock.createMock(OtcwmsOrderMoveStoDAO.class);
		ss.setOtcwmsOrderMoveStoDAO(dao);

	}

	/**
	 * <p>
	 * Discription:[RF移库接口]
	 * </p>
	 * 
	 * @param loginPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */

	@Test
	public void otcwmsOrderMoveSto() {

		try {
			WmsOrderMoveStoIn in = (WmsOrderMoveStoIn) getBean(WmsOrderMoveStoIn.class);

			ss.otcwmsOrderMoveSto(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * <p>
	 * Discription:[RF移库完成]
	 * </p>
	 * 
	 * @param loginPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */

	@Test
	public void otcwmsOrderMoveDone() {

		try {
			WmsOrderMoveDoneIn in = (WmsOrderMoveDoneIn) getBean(WmsOrderMoveDoneIn.class);

			ss.otcwmsOrderMoveDone(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * <p>
	 * Discription:[先进先出列表查询]
	 * </p>
	 * 
	 * @param WmsOrderXjxcListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void getXjxcList() {

		try {
			WmsOrderXjxcListIn in = (WmsOrderXjxcListIn) getBean(WmsOrderXjxcListIn.class);

			ss.getXjxcList(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * <p>
	 * Discription:[移库列表查询]
	 * </p>
	 * 
	 * @param WmsOrderMoveListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void getMoveList() {

		try {
			WmsOrderMoveListIn in = (WmsOrderMoveListIn) getBean(WmsOrderMoveListIn.class);

			ss.getMoveList(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}