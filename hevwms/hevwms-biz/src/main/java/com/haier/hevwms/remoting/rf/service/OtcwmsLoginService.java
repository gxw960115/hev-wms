package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.login.LoginPara;
import com.haier.hevwms.remoting.rf.domain.login.LoginResult;
/** 
* @ClassName: OtcwmsLoginService 
* @Description: TODO(手持接口的用户登录) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 上午10:58:59 
* @param 
*/ 
public interface OtcwmsLoginService {
	
	/** 
	* @Title: userLogin 
	* @Description: TODO(手持接口用户登录) 
	* @param @param loginPara
	* @param @return    设定文件 
	* @return LoginResult    返回类型 
	* @throws 
	*/ 
	LoginResult userLogin(LoginPara loginPara,String version);
}
