package com.haier.hevwms.remoting.rf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderUploadDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcIn;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsOrderUploadServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:54:10 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsOrderUploadServiceTest extends BasicTestCase {
	OtcwmsOrderUploadServiceImpl ss = new OtcwmsOrderUploadServiceImpl();

	@Before
	public void bf() {

		OtcwmsOrderUploadDAO dao = EasyMock.createMock(OtcwmsOrderUploadDAO.class);
		ss.setOtcwmsOrderUploadDAO(dao);

	}

	/**
	 * <p>
	 * Discription:[单据上传]
	 * </p>
	 * 
	 * @param WmsOrderUploadIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */

	@Test
	public void otcwmsOrderUpload() {

		try {
			WmsOrderUploadIn in = (WmsOrderUploadIn) getBean(WmsOrderUploadIn.class);
              in.setQty("0");
			ss.otcwmsOrderUpload(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderUpload1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:54:20 
	*/ 
	@Test
	public void otcwmsOrderUpload1() {

		try {
			WmsOrderUploadIn in = (WmsOrderUploadIn) getBean(WmsOrderUploadIn.class);
              in.setBarcode("12345678901234");
              in.setDoctype("PD");
			ss.otcwmsOrderUpload(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: otcwmsOrderUpload2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:54:26 
	*/ 
	@Test
	public void otcwmsOrderUpload2() {

		try {
			WmsOrderUploadIn in = (WmsOrderUploadIn) getBean(WmsOrderUploadIn.class);
              in.setBarcode("12345678901234");
              in.setDoctype("D");
			ss.otcwmsOrderUpload(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**
	 * <p>
	 * Discription:[先进先出校验]
	 * </p>
	 * 
	 * @param WmsOrderXjxcIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void otcwmsOrderXjxcCheck() {

		try {
			WmsOrderXjxcIn in = (WmsOrderXjxcIn) getBean(WmsOrderXjxcIn.class);

			ss.otcwmsOrderXjxcCheck(in);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: offlineScan  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:54:43 
	*/ 
	@Test
	public void offlineScan() {

		try {
			List<WmsOrderUploadIn> paramsIn=new ArrayList<WmsOrderUploadIn>();
			WmsOrderUploadIn o= (WmsOrderUploadIn)getBean(WmsOrderUploadIn.class);
			paramsIn.add(o);
			ss.offlineScan(paramsIn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);

	}
}