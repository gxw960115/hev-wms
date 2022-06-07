package com.haier.hevwms.remoting.rf.service;

import com.haier.hevwms.remoting.rf.domain.logout.LogoutPara;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutResult;

/**
 * <p>Description: [RF手持接口 service]</p>
 * Created on 2013-8-2
 * @version 1.0
 */
public interface OtcwmsLogoutService {
	/**
	 * <p>Discription:[通用方法]</p>
	 * @param logoutPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	LogoutResult userLogout(LogoutPara logoutPara);
}
