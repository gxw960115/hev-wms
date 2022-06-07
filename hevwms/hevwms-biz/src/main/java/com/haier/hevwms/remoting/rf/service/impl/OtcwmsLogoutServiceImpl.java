package com.haier.hevwms.remoting.rf.service.impl;

import com.haier.hevwms.remoting.rf.dao.OtcwmsLogoutDAO;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutPara;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutResult;
import com.haier.hevwms.remoting.rf.service.OtcwmsLogoutService;
import com.haier.openplatform.showcase.util.CommonTool;

/** 
* @ClassName: OtcwmsLogoutServiceImpl 
* @Description: TODO(手持登出) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 下午1:26:47 
* @param 
*/ 
public class OtcwmsLogoutServiceImpl implements OtcwmsLogoutService {
	private OtcwmsLogoutDAO logoutDAO;

	public void setLogoutDAO(OtcwmsLogoutDAO logoutDAO) {
		this.logoutDAO = logoutDAO;
	}

	/* (非 Javadoc) 
	* <p>Title: userLogout</p> 
	* <p>Description: </p> 
	* @param logoutPara
	* @return 
	* @see com.haier.hevwms.remoting.rf.service.OtcwmsLogoutService#userLogout(com.haier.hevwms.remoting.rf.domain.logout.LogoutPara) 
	*/ 
	@Override
	public LogoutResult userLogout(LogoutPara logoutPara) {
		LogoutResult logoutResult = new LogoutResult();
		int updNum = 0;
		//必输项判断
		if(CommonTool.isNull(logoutPara.getUser())){
			logoutResult.setStatus("F");
			logoutResult.setMsg("user id not null!");
			return logoutResult;
		}
		updNum = logoutDAO.resetSign(logoutPara.getUser());
		if(updNum<1){
			logoutResult.setStatus("F");
			logoutResult.setMsg("login out faild!");
			return logoutResult;
		}
		logoutResult.setStatus("S");//成功
		logoutResult.setMsg("logout success!");
		return logoutResult;
	}
}
