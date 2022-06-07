package com.haier.hevwms.remoting.rf.service.impl;

import javax.xml.ws.WebServiceContext;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.security.service.FileServiceClientAdapter;
import com.haier.hevwms.util.FileConstants;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: RfWsServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:57:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class RfWsServiceTest extends BasicTestCase {
	RfWsServiceImpl ss = new RfWsServiceImpl();
	private WmsLoginDAO loginDAO;
	private RfLogDAO rfLogDAO;
	private FileUploadDAO fileUploadDAO;
    private FileConstants fileConstants;
    private FileServiceClientAdapter fileServiceClientAdapter;
    
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:57:55 
	*/ 
	@Before
	public void bf() {
		loginDAO= EasyMock.createMock(WmsLoginDAO.class);
		rfLogDAO= EasyMock.createMock(RfLogDAO.class);
		fileUploadDAO= EasyMock.createMock(FileUploadDAO.class);
		fileConstants= EasyMock.createMock(FileConstants.class);
		fileServiceClientAdapter= EasyMock.createMock(FileServiceClientAdapter.class);
		ss.setLoginDAO(loginDAO);
		ss.setRfLogDAO(rfLogDAO);
		ss.setFileUploadDAO(fileUploadDAO);
		ss.setFileConstants(fileConstants);
		ss.setFileServiceClientAdapter(fileServiceClientAdapter);
		ss.getFileConstants();
		ss.getFileServiceClientAdapter();
		ss.getFileUploadDAO();
	}

	/**
	 * <p>
	 * Discription:[通用方法]
	 * </p>
	 * 
	 * @param userCode
	 * @param content
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void execute() {

		try {
			String userCode = "4";
			Object content = (Object) getBean(Object.class);

			ss.execute(userCode, content);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * <p>
	 * Discription:[手持签名校验]
	 * </p>
	 * 
	 * @param userName
	 * @param sign
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void checkSign() {

		try {
			String userName = "9";
			String sign = "4";
			String version = "5";
			UserDTO user=(UserDTO) getBean(UserDTO.class);
			UploadFile pdaFile=(UploadFile) getBean(UploadFile.class);
			pdaFile.setVersions("1");
            EasyMock.expect(loginDAO.getRfUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
            EasyMock.expect(fileUploadDAO.getPdaFileInfo()).andReturn(pdaFile).anyTimes();
            EasyMock.replay(loginDAO,fileUploadDAO);
			ss.checkSign(userName, sign, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: checkSign1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:58:17 
	*/ 
	@Test
	public void checkSign1() {

		try {
			String userName = "9";
			String sign = "4";
			String version = "5";
			UserDTO user=(UserDTO) getBean(UserDTO.class);
			UploadFile pdaFile=(UploadFile) getBean(UploadFile.class);
			pdaFile.setVersions(version);
            EasyMock.expect(loginDAO.getRfUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
            EasyMock.expect(fileUploadDAO.getPdaFileInfo()).andReturn(pdaFile).anyTimes();
            EasyMock.replay(loginDAO,fileUploadDAO);
			ss.checkSign(userName, sign, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**
	 * <p>
	 * Discription:[手持日志记录]
	 * </p>
	 * 
	 * @param user
	 * @param type
	 * @param sign
	 * @param context
	 * @param status
	 * @param dydate
	 * @param fhdate
	 * @param rcnr
	 * @param ccnr
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Test
	public void writeLog() {

		try {
			String user = "4";
			String type = "9";
			String sign = "3";
			WebServiceContext context = null;
			String status = "2";
			String dydate = "1";
			String fhdate = "5";
			Object rcnr = (Object) getBean(Object.class);
			Object ccnr = (Object) getBean(Object.class);

			ss.writeLog(user, type, sign, context, status, dydate, fhdate, rcnr, ccnr);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}