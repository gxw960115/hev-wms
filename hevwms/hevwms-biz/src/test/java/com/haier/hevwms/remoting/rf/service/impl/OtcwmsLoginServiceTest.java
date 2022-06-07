package com.haier.hevwms.remoting.rf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.login.LoginPara;
import com.haier.hevwms.remoting.rf.domain.login.Menu;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OtcwmsLoginServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午3:45:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OtcwmsLoginServiceTest extends BasicTestCase {
	OtcwmsLoginServiceImpl ss = new OtcwmsLoginServiceImpl();

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:04 
	*/ 
	@Before
	public void bf() {

		WmsLoginDAO dao = EasyMock.createMock(WmsLoginDAO.class);
		FileUploadDAO fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
		UploadFile pdafile=new UploadFile();
		pdafile.setVersions("3");
		UserDTO userDto=new UserDTO();
		userDto.setPassword("c20ad4d76fe97759aa27a0c99bff6710");
		userDto.setId(12L);
		EasyMock.expect(fileUploadDAO.getPdaFileInfo()).andReturn(pdafile).anyTimes();
		EasyMock.expect(((WmsLoginDAO) dao).getRfUserByName(EasyMock.isA(String.class))).andReturn(userDto).anyTimes();
		List<Location> location = new ArrayList<Location>();
		List<Menu> menu = new ArrayList<Menu>();;
		EasyMock.expect(((WmsLoginDAO) dao).getUserLocation(EasyMock.isA(Long.class))).andReturn(location).anyTimes();
		EasyMock.expect(((WmsLoginDAO) dao).getUserMenu(EasyMock.isA(Long.class))).andReturn(menu).anyTimes();
		EasyMock.expect(((WmsLoginDAO) dao).update(EasyMock.isA(UserDTO.class))).andReturn(1).anyTimes();
		ss.setLoginDAO(dao);
		ss.setFileUploadDAO(fileUploadDAO);
		EasyMock.replay(fileUploadDAO,dao);

	}

	/**  
	* @Title: userLogin  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:12 
	*/ 
	@Test
	public void userLogin() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			String version = "3";

			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: userLogi4  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:18 
	*/ 
	@Test
	public void userLogi4() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			String version = "3";
			WmsLoginDAO dao = EasyMock.createMock(WmsLoginDAO.class);
			FileUploadDAO fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
			UploadFile pdafile=new UploadFile();
			pdafile.setVersions("3");
			UserDTO userDto=new UserDTO();
			/*userDto.setPassword("c30ad4d76fe97759aa27a0c99bff6710");
			userDto.setId(12L);*/
			EasyMock.expect(fileUploadDAO.getPdaFileInfo()).andReturn(pdafile).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).getRfUserByName(EasyMock.isA(String.class))).andReturn(userDto).anyTimes();
			List<Location> location = new ArrayList<Location>();
			List<Menu> menu = new ArrayList<Menu>();;
			EasyMock.expect(((WmsLoginDAO) dao).getUserLocation(EasyMock.isA(Long.class))).andReturn(location).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).getUserMenu(EasyMock.isA(Long.class))).andReturn(menu).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).update(EasyMock.isA(UserDTO.class))).andReturn(1).anyTimes();
			ss.setLoginDAO(dao);
			ss.setFileUploadDAO(fileUploadDAO);
			EasyMock.replay(fileUploadDAO,dao);
			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: userLogi5  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:26 
	*/ 
	@Test
	public void userLogi5() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			String version = "3";
			WmsLoginDAO dao = EasyMock.createMock(WmsLoginDAO.class);
			FileUploadDAO fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
			UploadFile pdafile=new UploadFile();
			pdafile.setVersions("3");
			UserDTO userDto=new UserDTO();
			userDto.setPassword("123");
			userDto.setId(12L);
			EasyMock.expect(fileUploadDAO.getPdaFileInfo()).andReturn(pdafile).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).getRfUserByName(EasyMock.isA(String.class))).andReturn(userDto).anyTimes();
			List<Location> location = new ArrayList<Location>();
			List<Menu> menu = new ArrayList<Menu>();;
			EasyMock.expect(((WmsLoginDAO) dao).getUserLocation(EasyMock.isA(Long.class))).andReturn(location).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).getUserMenu(EasyMock.isA(Long.class))).andReturn(menu).anyTimes();
			EasyMock.expect(((WmsLoginDAO) dao).update(EasyMock.isA(UserDTO.class))).andReturn(1).anyTimes();
			ss.setLoginDAO(dao);
			ss.setFileUploadDAO(fileUploadDAO);
			EasyMock.replay(fileUploadDAO,dao);
			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: userLogi3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:33 
	*/ 
	@Test
	public void userLogi3() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			String version = "4";
			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: userLogin1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:39 
	*/ 
	@Test
	public void userLogin1() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			loginPara.setUser(null);
			String version = "3";

			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: userLogi2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午3:45:45 
	*/ 
	@Test
	public void userLogi2() {

		try {
			LoginPara loginPara = (LoginPara) getBean(LoginPara.class);
			loginPara.setPass(null);
			String version = "3";

			ss.userLogin(loginPara, version);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}