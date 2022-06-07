package com.haier.openplatform.showcase.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.haier.openplatform.hac.dto.UserMergeDTO;
import com.haier.openplatform.hac.service.HacUserServiceCli;
import com.haier.openplatform.showcase.domain.enu.AuthSourcceEnum;
import com.haier.openplatform.showcase.service.HacUserServiceCliAdapter;
import com.haier.openplatform.showcase.utils.PasswordEncryptUtil;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.HOPConstant;

public class HacUserServiceCliAdapterImpl implements HacUserServiceCliAdapter {

	private UserMergeDTO user = new UserMergeDTO();
	
	private HacUserServiceCli hacUserServiceCli;
	/**
	 * 认证源,idm or ids
	 */
	private String authSourcce;
	/**
	 * 协作应用id
	 */
	private String coSessionId;
	/**
	 * 协作应用名
	 */
	private String IdsAppName;
	/**
	 * 协作应用密钥
	 */
	private String passwdKey;
	
	public void setHacUserServiceCli(HacUserServiceCli hacUserServiceCli) {
		this.hacUserServiceCli = hacUserServiceCli;
	}

	public void setAuthSourcce(String authSourcce) {
		this.authSourcce = authSourcce;
	}

	public void setCoSessionId(String coSessionId) {
		this.coSessionId = coSessionId;
	}

	public void setIdsAppName(String idsAppName) {
		IdsAppName = idsAppName;
	}

	public void setPasswdKey(String passwdKey) {
		this.passwdKey = passwdKey;
	}

	public void init(){
		user.setHaierDataSrc(HOPConstant.getAppName());
		user.setIdmOu(HOPConstant.getAppName());
		user.setCoSessionId(coSessionId);
		user.setAppName(IdsAppName);
		user.setPasswdKey(passwdKey);
		user.setRegistSrc(authSourcce);
	}
	
	public ExecuteResult<UserMergeDTO> userLogin(String userCode,String pwd,String clientIp){
		ExecuteResult<UserMergeDTO> result = null;
		if(StringUtils.isBlank(userCode)){
			result = new ExecuteResult<UserMergeDTO>();
			result.addErrorMessage("用户账号不能为空");
			return result;
		}
		if(StringUtils.isBlank(pwd)){
			result = new ExecuteResult<UserMergeDTO>();
			result.addErrorMessage("密码不能为空");
			return result;
		}
		user.setUserName(userCode);
		try {
			user.setPassword(PasswordEncryptUtil.getDESPlusInstance().encrypt(pwd));
		} catch (Exception e) {
			result = new ExecuteResult<UserMergeDTO>();
			result.addErrorMessage("密码加密内部错误,请联系管理员");
			return result;
		}
		if(AuthSourcceEnum.SOURCE_IDM.getType().equals(authSourcce)){
			//TODO
		}else if(AuthSourcceEnum.SOURCE_IDS.getType().equals(authSourcce)){
			user.setClientIp(clientIp);
		}
		user.setHaierDataSrc(HOPConstant.getAppName());
		return hacUserServiceCli.mergeUserLogin(user);
	}

}
