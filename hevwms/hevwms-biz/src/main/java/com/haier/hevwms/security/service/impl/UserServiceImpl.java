package com.haier.hevwms.security.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.security.dao.ResourceDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.security.service.UserService;
import com.haier.openplatform.hmc.domain.Email;
import com.haier.openplatform.hmc.domain.Recipient;
import com.haier.openplatform.hmc.sender.email.EmailBuilder;
import com.haier.openplatform.hmc.sender.email.SendEmailService;
import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.session.listener.MaxSessionUtil;
import com.haier.openplatform.showcase.util.CacheNames;
import com.haier.openplatform.showcase.util.Env;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.PasswordUtil;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.security.domain.enu.UserStatusEnum;
import com.haier.openplatform.wms.security.dto.UserDTO;


public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class);

	private static final int PASSWORD_TIP_DAYS = 10;// 密码过期10天提前提醒
	private static final int DAY_MILLISECONDS = 24 * 60 * 60 * 1000;// 一天的毫秒数
	private UserDAO userDAO;
	private ResourceDAO resourceDAO;
	private CdLocInfoDAO cdLocInfoDAO;
	private CacheManager cacheManager;
	private SendEmailService emailSender;
	private EmailBuilder emailBuilder;

	public SendEmailService getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(SendEmailService emailSender) {
		this.emailSender = emailSender;
	}

	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public void setEmailBuilder(EmailBuilder emailBuilder) {
		this.emailBuilder = emailBuilder;
	}

	public ExecuteResult<UserDTO> createUser(UserDTO user) {
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
		UserDTO existedUser = userDAO.getUserByName(StringUtils.trim(user.getName()));
		if (existedUser != null) {
			executeResult.addErrorMessage(user.getName()+" already existed!");
			return executeResult;
		}
		// 保存
		user.setName(StringUtils.trim(user.getName()));
		user.setNickName(StringUtils.trim(user.getNickName()));
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setCreateBy(UserUtil.getCurrentUser().getName());
		user.setLastModifiedBy(UserUtil.getCurrentUser().getName());
		user.setPassword(PasswordUtil.encrypt(user.getPassword()));
		user.setLoginAttemptTimes(0);
		user.setPasswordExpireTime(calculatePasswordExpireDate());
		user.setPasswordModifiedFlag(0);
		userDAO.save(user);

		if (!"1".equals(user.getDutyType())) {
			this.createUserWhLoc(user);
		}
		executeResult.setResult(user);
		return executeResult;
	}

	public void createUserWhLoc(UserDTO user) {
	    logger.debug("Entering createUserWhLoc...");
	    if (user == null || user.getWhLocs() == null || user.getWhLocs().length() == 0) {
	        logger.debug("User is null or warehouse location is null, return...");
	        return;
	    }
		String[] whs = user.getWhLocs().split(",");
		if (whs == null || whs.length == 0) {
		    logger.debug("Warehouse location is null, return...");
            return;
		}
		logger.debug("User type is: " + user.getDutyType());
		for (String wh : whs) {
		    logger.debug("Warehouse id: " + wh);
		    
			if ("2".equals(user.getDutyType())) {
				List<CdLocInfoDTO> list = cdLocInfoDAO.getCdLocInfosByParentIdNotnull(Long.parseLong(wh),"");
				// 仓库存储
				if (list == null || list.size() == 0) {
				    logger.debug("The size of location list for warehouse " + wh + " is null, continue...");
				} else {
				    logger.debug("The size of location list for warehouse " + wh + " is " + list.size());
				    for (CdLocInfoDTO cdLocInfo : list) {
				        if (cdLocInfo != null) {
				            logger.debug("User Id: " + user.getId() + ", Duty Type: " + user.getDutyType() + ", Location ID: " + cdLocInfo.getRowId()
	                                + ", Location Code: " + cdLocInfo.getCode() + ", Warehouse ID: " + wh);
	                        userDAO.saveUserWhLoc(user.getId(), user.getDutyType(), cdLocInfo.getRowId(), cdLocInfo.getCode(), Long.parseLong(wh));
				        } else {
				            logger.debug("Location is NULL, continue...");
				        }
				        
	                }
				}
				
			} else {
			    
				// location存储
				if(wh!=null && !"".equals(wh)){
					CdLocInfoDTO cdLocInfo = cdLocInfoDAO.get(Long.parseLong(wh));
					if (cdLocInfo != null) {
					    userDAO.saveUserWhLoc(user.getId(), user.getDutyType(), cdLocInfo.getRowId(), cdLocInfo.getCode(), cdLocInfo.getParentId());
					}
				}
				
			}
		}
		logger.debug("Exiting createUserWhLoc...");

	}

	public void deleteUserWhLoc(UserDTO user) {
		userDAO.deleteUserWhLoc(user.getId());
	}

	@Override
	public Pager<UserDTO> searchUser(Pager<UserDTO> pager, UserDTO user) {
		List<UserDTO> records = userDAO.searchUser(pager, user);
		long totalRecords = userDAO.searchUserCount(user);
		return Pager.cloneFromPager(pager, totalRecords, records);
	}

	@Override
	public UserDTO getUserById(Long id) {
		return (UserDTO) userDAO.get(id);
	}

	@Override
	public ExecuteResult<?> deleteUser(Long userId) {
		ExecuteResult<?> result = new ExecuteResult<Object>();
		// 检查是否还存在引用
		userDAO.delete(userId);
		return result;
	}

	@Override
	public ExecuteResult<UserDTO> confirmUpdatePassword(String name,
			String encode, String password, String confirmpassword) {
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
		UserDTO dbUser = (UserDTO) userDAO.getUserByName(name);
		if (dbUser == null) {
			executeResult.addErrorMessage("Username input errors");
			return executeResult;
		}
		if (!password.equals(confirmpassword)) {
			executeResult.addErrorMessage("Two password input inconsistent");
			return executeResult;
		}
		if (!encode.equals(dbUser.getEncode())) {
			executeResult.addErrorMessage("Modify password link failure");
			return executeResult;
		}
		if (!PasswordUtil.isValidPassword(password)) {
			executeResult.addErrorMessage("Account password is at least 8, subject to the requirements of uppercase and lowercase letters, numbers, special characters ,choosing three from four");
			return executeResult;
		} else {
			// 修改密码
			String newPassword = PasswordUtil.encrypt(confirmpassword);
			dbUser.setPassword(newPassword);
			dbUser.setEncode(null);// 清空验证码
			dbUser.setGmtModified(new Date());
			dbUser.setLastModifiedBy(name);
			dbUser.setPasswordExpireTime(calculatePasswordExpireDate());
			dbUser.setPasswordModifiedFlag(1);
			this.userDAO.update(dbUser);
			return executeResult;
		}
	}

	@Override
	public ExecuteResult<UserDTO> getUserEmailByName(String name, String email) {
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
//		Locale language = (Locale) ActionContext.getContext().getSession()
//				.get(SessionSecurityConstants.KEY_LOCAL_LANGUAGE);
		UserDTO dbUser = (UserDTO) userDAO.getUserByName(name);
		// 判断输入的邮箱和用户的邮箱是否相同
		if (dbUser == null) {
			executeResult.addErrorMessage("Enter the user name does not exist");
			return executeResult;
		} else if (!StringUtils.equalsIgnoreCase(email, dbUser.getEmail())) {
			executeResult.addErrorMessage("Enter the user name and the mailbox does not match");
			return executeResult;
		} else {
			return executeResult;
		}
	}

	@Override
	public ExecuteResult<UserDTO> updateUserEncode(String name) {
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
//		Locale language = (Locale) ActionContext.getContext().getSession()
//				.get(SessionSecurityConstants.KEY_LOCAL_LANGUAGE);
		UserDTO dbUser = (UserDTO) userDAO.getUserByName(name);
		// 生成随机验证码
		String encode = UUID.randomUUID().toString();
		// 更新用户的验证码
		dbUser.setEncode(encode);// 修改验证码
		dbUser.setGmtModified(new Date());
		dbUser.setLastModifiedBy(name);
		dbUser.setPasswordExpireTime(calculatePasswordExpireDate());
		dbUser.setPasswordModifiedFlag(1);
		this.userDAO.update(dbUser);

		// 增加发送邮件方法后使用到的链接
		String retirevepasswordurl = Env.getProperty(Env.APP_URL);
		// 组装对应的更改密码地址
		// 增加发送邮件方法后使用到的链接
		String updatePwdUrl = retirevepasswordurl
				+ "/security/toRetrieveUpdatePassword.action?encode=" + encode;
		// 调用发送邮件方法将地址发送给用户
		Email email = new Email();
		Recipient recipient = new Recipient();
		recipient.setUserName("HopAdmin");
		recipient.setEmailAddress(Env.getProperty(Env.APP_EAMIL.isEmpty()
				|| Env.APP_EAMIL == null ? "" : Env.APP_EAMIL));
		email.setSender(recipient);
		Recipient toRecipient = new Recipient();
		toRecipient.setUserName(name);
		toRecipient.setEmailAddress(dbUser.getEmail());
		List<Recipient> toRecipientList = new ArrayList<Recipient>();
		toRecipientList.add(toRecipient);
		email.setToRecipient(toRecipientList);
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("appName", Env.getProperty(Env.APP_NAME.isEmpty()
				|| Env.APP_NAME == null ? "" : Env.APP_NAME));
		parameters.put("appUrl", updatePwdUrl);
		emailBuilder.buildEmail("update_password_tip", email, parameters);
		emailSender.sendEmail(email);
		return executeResult;
	}

	@Override
	public ExecuteResult<UserDTO> updateUser(UserDTO user) {
		ExecuteResult<UserDTO> result = new ExecuteResult<UserDTO>();
		UserDTO dbUser = (UserDTO) userDAO.get(user.getId());
		if (dbUser == null) {
			result.addErrorMessage("The user does not exist or has been deleted");
			return result;
		}
		// 重名检查
		if (!dbUser.getName().equals(user.getName())) {
			UserDTO namedUser = userDAO.getUserByName(user.getName());
			if (namedUser != null) {
				result.addErrorMessage(user.getName()+" already existed");
				return result;
			}
		}
		// 关联部门
		//resetUserDepartmentInfo(user, dbUser);
		// 修改
		dbUser.setGmtModified(new Date());
		dbUser.setEmail(user.getEmail());
		dbUser.setName(user.getName());
		dbUser.setNickName(StringUtils.trim(user.getNickName()));
		dbUser.setLastModifiedBy(UserUtil.getCurrentUser().getName());
		dbUser.setStatus(user.getStatus());
		dbUser.setExpiredTime(user.getExpiredTime());
		dbUser.setDutyType(user.getDutyType());
		dbUser.setProductDivision(user.getProductDivision());
		if (user.getPassword() != null && !"".equals(user.getPassword())){
			dbUser.setPassword(PasswordUtil.encrypt(user.getPassword()));
		} 
		// 删除对应仓库
		deleteUserWhLoc(user);
		// 保存对应仓库
		if (!"1".equals(user.getDutyType())) {
			this.createUserWhLoc(user);
		}
		userDAO.update(dbUser);
		result.setResult(dbUser);
		return result;
	}


	// @SuppressWarnings("unchecked")
	@Override
	public ExecuteResult<UserDTO> login(String userName, String password,
			String ipAddress) {
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
//		Locale language = (Locale) ActionContext.getContext().getSession()
//				.get(SessionSecurityConstants.KEY_LOCAL_LANGUAGE);
		UserDTO userInfo = userDAO.getUserByName(userName);
		final String errorMsg = "User name or password is incorrect, continuous mismatched 5 times, the account will be disabled";

		// 用户名和密码以及用户状态是否匹配
		if (userInfo == null) {
			executeResult.addErrorMessage(errorMsg);
			return executeResult;
		}
		if (UserStatusEnum.toEnum(userInfo.getStatus()) == UserStatusEnum.INACTIVE) {
			executeResult.addErrorMessage(errorMsg);
			return executeResult;
		}
		if (!userInfo.getPassword().equals(PasswordUtil.encrypt(password))) {
			doPasswordNotMatch(userInfo);
			executeResult.addErrorMessage(errorMsg);
			return executeResult;
		}

		/*
		 * //不允许同一账号在多处同时登陆 Cache sessionCache =
		 * cacheManager.getCache(CacheNames.CACHE_NAME_SESSION); String key =
		 * MaxSessionUtil.generateMaxSessionKey(userInfo.getName());
		 * ValueWrapper valueWrapper = sessionCache.get(key); Map<String,
		 * Integer> sessionMap = null; if(valueWrapper == null ||
		 * valueWrapper.get() == null){ sessionMap = new HashMap<String,
		 * Integer>(); }else{ sessionMap = (Map<String, Integer>)
		 * valueWrapper.get(); } boolean localLogin =
		 * sessionMap.containsKey(ipAddress); int size =
		 * sessionMap.keySet().size(); if((localLogin && size > 1)
		 * ||(!localLogin && size >= 1)){//在除本机外的其他多个地方登录过
		 * executeResult.addErrorMessage
		 * (I18N_RESOLVER.getMessage("user.already.elsewhere.login")); return
		 * executeResult; } sessionMap.put(ipAddress,
		 * localLogin?sessionMap.get(ipAddress)+1:1); sessionCache.put(key,
		 * sessionMap);
		 */

		// 更新用户信息
		userInfo.setLastLoginIp(userInfo.getCurrentLoginIp());
		userInfo.setLastLoginTime(new Date());
		userInfo.setLoginFaildTime(null);
		userInfo.setLoginAttemptTimes(0);
		userInfo.setCurrentLoginIp(ipAddress);
		executeResult.setResult(userInfo);
		// 清理缓存
		cacheManager.getCache(CacheNames.CACHE_NAME_USER).evict(
				CacheNames.USER_KEY_PREFIX + userInfo.getId());
		return executeResult;
	}

	private void doPasswordNotMatch(UserDTO userInfo) {
		final long accountLockTime = 60 * 60 * 1000L;// 登陆1小时内尝试5次
		if (userInfo.getLoginFaildTime() == null) {
			userInfo.setLoginFaildTime(new Date());
		} else if (userInfo.getLoginFaildTime().getTime() + accountLockTime < System
				.currentTimeMillis()) {
			userInfo.setLoginFaildTime(new Date());
			userInfo.setLoginAttemptTimes(0);
		}
		userInfo.setLoginAttemptTimes((userInfo.getLoginAttemptTimes() == null ? 0
				: userInfo.getLoginAttemptTimes()) + 1);// 错误次数累加
		final Integer loginTimes = 5;// 最多可以连续登陆5次密码错误
		if (userInfo.getLoginAttemptTimes() >= loginTimes) {
			userInfo.setStatus(UserStatusEnum.INACTIVE.getStatus());// 自动锁定
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ExecuteResult<UserDTO> logout(LoginContext context) {
		// 清理用户资源缓存
		List<String> moduleNames = resourceDAO.getmoduleNames();
		for (String moduleName : moduleNames) {
			if (moduleName != null && !moduleName.isEmpty()) {
				cacheManager.getCache(CacheNames.CACHE_NAME_RESOURCE).evict(
						Env.getProperty(Env.KEY_SERVER_NAME) + ":resource:"
								+ context.getUserId() + ":" + moduleName);
			}
		}
		ExecuteResult<UserDTO> executeResult = new ExecuteResult<UserDTO>();
		Cache sessionCache = cacheManager
				.getCache(CacheNames.CACHE_NAME_SESSION);
		String key = MaxSessionUtil
				.generateMaxSessionKey(context.getUserName());
		ValueWrapper valueWrapper = sessionCache.get(key);
		if (valueWrapper == null) {
			return executeResult;
		}
		Map<String, Integer> sessionMap = (Map<String, Integer>) valueWrapper
				.get();
		if (sessionMap != null) {
			Integer sessions = sessionMap.get(context.getIp());
			if (sessions == null || sessions <= 1) {
				sessionMap.remove(context.getIp());
			} else {
				sessionMap.put(context.getIp(), sessions - 1);
			}
			sessionCache.put(key, sessionMap);
		}
		return executeResult;
	}

	private Date calculatePasswordExpireDate() {
		Calendar clendar = Calendar.getInstance();
		clendar.add(Calendar.MONTH, 2);// 2个月后密码过期
		return clendar.getTime();
	}

	@Override
	public void updatePassword(Long userId, String password) {
		String newPassword = PasswordUtil.encrypt(password);
		UserDTO user = getUserById(userId);
		if (user == null) {
			return;
		}
		user.setPassword(newPassword);
		user.setGmtModified(new Date());
		user.setLastModifiedBy(UserUtil.getCurrentUser().getName());//登录信息没完成前，报错，测试可设置常量
		user.setPasswordExpireTime(calculatePasswordExpireDate());
		user.setPasswordModifiedFlag(1);
		this.userDAO.update(user);
	}

	@Override
	public ExecuteResult<Boolean> shouldTipPassword(UserDTO user) {
		ExecuteResult<Boolean> executeResult = new ExecuteResult<Boolean>();
		Integer flag = user.getPasswordModifiedFlag();
		if (flag == null || flag == 0) {
			executeResult.addErrorMessage("First landing system must modify the default password");
			return executeResult;
		}
		// 密码是否即将过期，
		Date now = formatDate(new Date());
		Date expireDate = formatDate(user.getPasswordExpireTime());
		Date tipDay = DateUtils.addDays(expireDate, -PASSWORD_TIP_DAYS);
		long expiredTime = now.getTime() - tipDay.getTime();
		long exprireDays = expiredTime / DAY_MILLISECONDS;// 到期天数
		if (exprireDays >= 0) {
			if (exprireDays < PASSWORD_TIP_DAYS) {
				executeResult.addErrorMessage("Your password will expired, please change your password.");
			} else {
				executeResult.addErrorMessage("Your password has expired, please change your password.");
			}
		}
		return executeResult;
	}

	// 去除时间中的时分秒和毫秒
	private Date formatDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	@Override
	public String getExpiredDate(UserDTO user) {
		if (user.getExpiredTime() != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
			String expiredTime = dateFormat.format(user.getExpiredTime());
			String nowTime = dateFormat.format(new Date());
			long expiredDate = Long.parseLong(expiredTime)
					- Long.parseLong(nowTime);
			if (expiredDate > 0 && expiredDate < 7) {
				String[] admin = Env.getProperty(Env.SYS_ADMIN).split(",");
				StringBuffer result = new StringBuffer();
				if (admin.length > 0) {
					for (String ad : admin) {
						UserDTO adminInfo = this.getUserByName(ad);
						result = result.append("-" + adminInfo.getNickName()
								+ "(Email:" + adminInfo.getEmail() + ");");
					}
					String info = "Your password has "+String.valueOf(expiredDate)+" days expired, please change your password";
					return info;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public UserDTO getUserByName(String name) {
		return userDAO.getUserByName(name);
	}

	@Override
	public List<UserDTO> getAll() {
		return userDAO.getAll();
	}

	@Override
	public ExecuteResult<UserDTO> updateExpiredUser(UserDTO user) {
		ExecuteResult<UserDTO> result = new ExecuteResult<UserDTO>();
		UserDTO dbUser = (UserDTO) userDAO.get(user.getId());
		if (dbUser == null) {
			result.addErrorMessage("The user does not exist or has been deleted");
			return result;
		}
		// 重名检查
		if (!dbUser.getName().equals(user.getName())) {
			UserDTO namedUser = userDAO.getUserByName(user.getName());
			if (namedUser != null) {
				result.addErrorMessage(user.getName()+" already existed");
				return result;
			}
		}
		// 关联部门
		//resetUserDepartmentInfo(user, dbUser);
		// 修改
		dbUser.setGmtModified(new Date());
		dbUser.setEmail(user.getEmail());
		dbUser.setName(user.getName());
		dbUser.setNickName(StringUtils.trim(user.getNickName()));
		dbUser.setLastModifiedBy(UserUtil.getCurrentUser().getName());
		dbUser.setStatus(user.getStatus());
		dbUser.setExpiredTime(user.getExpiredTime());
		userDAO.update(dbUser);
		result.setResult(user);
		return result;
	}

	@Override
	public Pager<UserDTO> getUsersByGroupId(Pager<UserDTO> pager, UserDTO user) {
		List<UserDTO> users = userDAO.getUsersByGroupId(pager, user);
		long size = userDAO.getUsersByGroupIdCount(user);
		return Pager.cloneFromPager(pager, size, users);
	}
	
    @Override
    public ExecuteResult<UserDTO> mergeUserLogin(UserDTO user) {
        ExecuteResult<UserDTO> result = new ExecuteResult<UserDTO>();
        UserDTO userSta = userDAO.getUserByName(user.getName());
        if (userSta == null){
        	result.addErrorMessage("Account does not exist, please check!");
        	return result;
        }
        if (new Date().getTime()>userSta.getExpiredTime().getTime()){
        	result.addErrorMessage("Account is expired, please contact with administrator!");
        	return result;
        }
        if (0==userSta.getStatus()){
        	result.addErrorMessage("Account is invalid, please contact with administrator!");
        	return result;
        }else if (2==userSta.getStatus()){
        	result.addErrorMessage("User has been locked, please contact with administrator!");
        	return result;
        }
        UserDTO userdto=userDAO.mergeUserLogin(user);//验证用户密码
        if(userdto==null){
            result.addErrorMessage("Username or Password is incorrect!");
        }
        userSta.setLastLoginIp(user.getCurrentLoginIp());
        if (result.isSuccess()){
        	userSta.setLastLoginTime(new Date());
        } else {
        	userSta.setLoginFaildTime(new Date());
        }
        userDAO.update(userSta);
        
        result.setResult(userdto);
        return result;
    }  
    
	/**
	 * @param cdLocInfoDAO
	 */
	public void setCdLocInfoDAO(CdLocInfoDAO cdLocInfoDAO) {
		this.cdLocInfoDAO = cdLocInfoDAO;
	}
	
	/**
	* @Title: getExpiredList
	* @Description: 获取两个月未登录用户列表，将状态改为2
	* @param 
	* @return
	* @throws
	*/
	@Override
	public void lockExpiredUsers() {
		List<UserDTO> expiredUserList = userDAO.getExpiredList();
		for (UserDTO user:expiredUserList){
			if (1 == user.getStatus()){
				user.setStatus(2);
				userDAO.update(user);
			}
		}
	}
	
}
