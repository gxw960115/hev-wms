package com.haier.openplatform.showcase.service;

import com.haier.openplatform.hac.dto.UserMergeDTO;
import com.haier.openplatform.util.ExecuteResult;

public interface HacUserServiceCliAdapter {

	/**
	 * 用户认证
	 * @param userCode   用户登录账号
	 * @param pwd        密码
	 * @param clientIp   登录用户ip
	 * @return
	 */
	public ExecuteResult<UserMergeDTO> userLogin(String userCode,String pwd,String clientIp);
}
