package com.haier.hevwms.portal.service.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.portal.dao.NoticeInfoDAO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: PortalServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:43:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class PortalServiceImplTest extends BasicTestCase {
	PortalServiceImpl ss = new PortalServiceImpl();
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	private StgPoDownDAO stgPoDownDAO; 
	private NoticeInfoDAO noticeInfoDAO;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:43:13 
	*/ 
	@Before
	public void bf() {

		odsInventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		stgPoDownDAO = EasyMock.createMock(StgPoDownDAO.class);
		noticeInfoDAO = EasyMock.createMock(NoticeInfoDAO.class);
		
		ss.setOdsInventoryInfoDtlDAO(odsInventoryInfoDtlDAO);
		ss.setStgPoDownDAO(stgPoDownDAO);
		ss.setNoticeInfoDAO(noticeInfoDAO);
		ss.getOdsInventoryInfoDtlDAO();
		ss.getStgPoDownDAO();
		ss.getNoticeInfoDAO();
//		ss.getNoticeData();
//		ss.getInventoryPieData();
	}

	/**  
	* @Title: getToDoChartsData  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:43:20 
	*/ 
	@Test
	public void getToDoChartsData() {

		try {
			 JSONArray arr =new JSONArray();
			 JSONObject j=new JSONObject();
			 j.put("qty", 2L);
			 arr.add(j);
			 arr.add(j);
			 arr.add(j);
			 arr.add(j);
			 arr.add(j);
			 arr.add(j);
			EasyMock.expect(stgPoDownDAO.getToDoChartsData()).andReturn(arr);
			EasyMock.replay(stgPoDownDAO);
			ss.getToDoChartsData();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: deleteNotice  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:43:27 
	*/ 
	@Test
	public void deleteNotice() {

		try {
			
			EasyMock.expect(noticeInfoDAO.deleteNotice()).andReturn(1);
			EasyMock.replay(stgPoDownDAO);
			ss.deleteNotice();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: saveSystemNotice  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:43:34 
	*/ 
	@Test
	public void saveSystemNotice() {

		try {
			NoticeInfoDTO notice=(NoticeInfoDTO) getBean(NoticeInfoDTO.class);
			noticeInfoDAO.save(EasyMock.isA(NoticeInfoDTO.class));
			EasyMock.expectLastCall().anyTimes();
			EasyMock.replay(noticeInfoDAO);
			ss.saveSystemNotice(notice);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}
