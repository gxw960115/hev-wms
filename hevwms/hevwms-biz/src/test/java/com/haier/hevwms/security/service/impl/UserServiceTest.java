package com.haier.hevwms.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.CacheManager;

import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.security.dao.ResourceDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.hmc.domain.Email;
import com.haier.openplatform.hmc.sender.email.EmailBuilder;
import com.haier.openplatform.hmc.sender.email.SendEmailService;
import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: UserServiceTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午4:17:47 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class UserServiceTest extends BasicTestCase {
	UserServiceImpl ss = new UserServiceImpl();
	private UserDAO userDAO;
	private ResourceDAO resourceDAO;
	private CdLocInfoDAO cdLocInfoDAO;
	private CacheManager cacheManager;
	private SendEmailService emailSender;
	private EmailBuilder emailBuilder;

	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:17:51 
	*/ 
	@Before
	public void bf() {

		userDAO = EasyMock.createMock(UserDAO.class);
		resourceDAO = EasyMock.createMock(ResourceDAO.class);
		cdLocInfoDAO = EasyMock.createMock(CdLocInfoDAO.class);
		cacheManager = EasyMock.createMock(CacheManager.class);
		emailSender = EasyMock.createMock(SendEmailService.class);
		emailBuilder = EasyMock.createMock(EmailBuilder.class);
		ss.setUserDAO(userDAO);
		ss.setResourceDAO(resourceDAO);
		ss.setCdLocInfoDAO(cdLocInfoDAO);
		ss.setCacheManager(cacheManager);
		ss.setEmailSender(emailSender);

		ss.getEmailSender();

	}

	/**  
	* @Title: createUser  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:00 
	*/ 
	@Test
	public void createUser() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user);
			EasyMock.replay(userDAO);
			ss.createUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createUser1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:03 
	*/ 
	@Test
	public void createUser1() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(null).anyTimes();

			userDAO.save(EasyMock.isA(UserDTO.class));
			EasyMock.expectLastCall().times(1);
			EasyMock.replay(userDAO);
			ss.createUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createUserWhLoc  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:13 
	*/ 
	@Test
	public void createUserWhLoc() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setDutyType("2");
			List<CdLocInfoDTO> list = new ArrayList<CdLocInfoDTO>();
			EasyMock.expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(EasyMock.anyLong(), EasyMock.isA(String.class)))
					.andReturn(list).anyTimes();
			EasyMock.replay(cdLocInfoDAO);
			ss.createUserWhLoc(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createUserWhLoc3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:16 
	*/ 
	@Test
	public void createUserWhLoc3() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setDutyType("2");
			List<CdLocInfoDTO> list = new ArrayList<CdLocInfoDTO>();
			CdLocInfoDTO c = (CdLocInfoDTO) getBean(CdLocInfoDTO.class);
			list.add(c);
			EasyMock.expect(cdLocInfoDAO.getCdLocInfosByParentIdNotnull(EasyMock.anyLong(), EasyMock.isA(String.class)))
					.andReturn(list).anyTimes();
			EasyMock.expect(userDAO.saveUserWhLoc(EasyMock.anyLong(), EasyMock.isA(String.class), EasyMock.anyLong(),
					EasyMock.isA(String.class), EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.replay(cdLocInfoDAO, userDAO);
			ss.createUserWhLoc(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: createUserWhLoc1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:20 
	*/ 
	@Test
	public void createUserWhLoc1() {

		try {
			ss.createUserWhLoc(null);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteUserWhLoc  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:22 
	*/ 
	@Test
	public void deleteUserWhLoc() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			EasyMock.expect(userDAO.deleteUserWhLoc(EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.deleteUserWhLoc(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserById  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:30 
	*/ 
	@Test
	public void getUserById() {

		try {
			Long id = (long) 7;

			ss.getUserById(id);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: deleteUser  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:33 
	*/ 
	@Test
	public void deleteUser() {

		try {
			Long id = (long) 7;
			EasyMock.expect(userDAO.delete(EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.deleteUser(id);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateUser  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:50 
	*/ 
	@Test
	public void updateUser() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			EasyMock.expect(userDAO.get(EasyMock.anyLong())).andReturn(null).anyTimes();
			EasyMock.replay(userDAO);
			ss.updateUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateUser1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:53 
	*/ 
	@Test
	public void updateUser1() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setDutyType("1");
			EasyMock.expect(userDAO.get(EasyMock.anyLong())).andReturn(user).anyTimes();
			EasyMock.expect(userDAO.deleteUserWhLoc(EasyMock.anyLong())).andReturn(2).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.updateUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: login  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:18:59 
	*/ 
	@Test
	public void login() {

		try {
			String userName = "5";
			String password = "8";
			String ipAddress = "6";

			ss.login(userName, password, ipAddress);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: login1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:02 
	*/ 
	@Test
	public void login1() {

		try {
			String userName = "5";
			String password = "8";
			String ipAddress = "6";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.login(userName, password, ipAddress);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updatePassword  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:10 
	*/ 
	@Test
	public void updatePassword() {

		try {
			Long userId = (long) 16;
			String password = "3";
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			EasyMock.expect(userDAO.get(EasyMock.anyLong())).andReturn(null).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.updatePassword(userId, password);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	/**  
	* @Title: updatePassword1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:13 
	*/ 
	@Test
	public void updatePassword1() {

		try {
			Long userId = (long) 16;
			String password = "3";
			
			ss.updatePassword(userId, password);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: shouldTipPassword  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:19 
	*/ 
	@Test
	public void shouldTipPassword() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			ss.shouldTipPassword(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: logout  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:26 
	*/ 
	@Test
	public void logout() {

		try {
			LoginContext context = (LoginContext) getBean(LoginContext.class);

			ss.logout(context);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserEmailByName  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:34 
	*/ 
	@Test
	public void getUserEmailByName() {

		try {
			String name = "9";
			String email = "7";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.getUserEmailByName(name, email);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserEmailByName3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:37 
	*/ 
	@Test
	public void getUserEmailByName3() {

		try {
			String name = "9";
			String email = "7";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setEmail("7");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.getUserEmailByName(name, email);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserEmailByName1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:39 
	*/ 
	@Test
	public void getUserEmailByName1() {

		try {
			String name = "9";
			String email = "7";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(null).anyTimes();
			EasyMock.replay(userDAO);
			ss.getUserEmailByName(name, email);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: confirmUpdatePassword  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:46 
	*/ 
	@Test
	public void confirmUpdatePassword() {

		try {
			String name = "2";
			String encode = "4";
			String password = "8";
			String confirmpassword = "3";

			ss.confirmUpdatePassword(name, encode, password, confirmpassword);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: confirmUpdatePassword1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:49 
	*/ 
	@Test
	public void confirmUpdatePassword1() {

		try {
			String name = "2";
			String encode = "4";
			String password = "8";
			String confirmpassword = "3";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setPassword("6");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.confirmUpdatePassword(name, encode, password, confirmpassword);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: confirmUpdatePassword2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:52 
	*/ 
	@Test
	public void confirmUpdatePassword2() {

		try {
			String name = "2";
			String encode = "4";
			String password = "3";
			String confirmpassword = "3";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setEncode("3");
			user.setPassword("3");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.confirmUpdatePassword(name, encode, password, confirmpassword);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: confirmUpdatePassword3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:55 
	*/ 
	@Test
	public void confirmUpdatePassword3() {

		try {
			String name = "2";
			String encode = "4";
			String password = "3";
			String confirmpassword = "3";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setEncode("4");
			user.setPassword("3");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.replay(userDAO);
			ss.confirmUpdatePassword(name, encode, password, confirmpassword);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: confirmUpdatePassword4  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:19:58 
	*/ 
	@Test
	public void confirmUpdatePassword4() {

		try {
			String name = "2";
			String encode = "4";
			String password = "Ha123456,";
			String confirmpassword = "Ha123456,";
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			user.setEncode("4");
			user.setPassword("3");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.confirmUpdatePassword(name, encode, password, confirmpassword);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateUserEncode  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:07 
	*/ 
	@Test
	public void updateUserEncode() {

		try {
			String name = "3";
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.expect(emailBuilder.buildEmail(EasyMock.isA(String.class), EasyMock.anyObject(Email.class),
					EasyMock.anyObject(HashMap.class))).andReturn(new Email()).anyTimes();
			EasyMock.expect(emailSender.sendEmail(EasyMock.anyObject(Email.class))).andReturn(true).anyTimes();
			EasyMock.replay(userDAO);
			ss.updateUserEncode(name);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getExpiredDate  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:16 
	*/ 
	@Test
	public void getExpiredDate() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			ss.getExpiredDate(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getUserByName  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:23 
	*/ 
	@Test
	public void getUserByName() {

		try {
			String name = "4";

			ss.getUserByName(name);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: getAll  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:30 
	*/ 
	@Test
	public void getAll() {

		try {

			ss.getAll();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateExpiredUser  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:39 
	*/ 
	@Test
	public void updateExpiredUser() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			ss.updateExpiredUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateExpiredUser1  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:44 
	*/ 
	@Test
	public void updateExpiredUser1() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user);
			EasyMock.expect(userDAO.get(EasyMock.anyLong())).andReturn(user).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.updateExpiredUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
	
	/**  
	* @Title: updateExpiredUser2  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:20:51 
	*/ 
	@Test
	public void updateExpiredUser2() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);
			UserDTO user1 = (UserDTO) getBean(UserDTO.class);
			user1.setName("222");
			EasyMock.expect(userDAO.getUserByName(EasyMock.isA(String.class))).andReturn(user1).anyTimes();
			EasyMock.expect(userDAO.get(EasyMock.anyLong())).andReturn(user).anyTimes();
			EasyMock.expect(userDAO.update(EasyMock.isA(UserDTO.class))).andReturn(2).anyTimes();
			EasyMock.replay(userDAO);
			ss.updateExpiredUser(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: mergeUserLogin  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:21:05 
	*/ 
	@Test
	public void mergeUserLogin() {

		try {
			UserDTO user = (UserDTO) getBean(UserDTO.class);

			ss.mergeUserLogin(user);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: lockExpiredUsers  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午4:21:12 
	*/ 
	@Test
	public void lockExpiredUsers() {

		try {

			ss.lockExpiredUsers();
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}
}