package com.haier.hevwms.remoting.rf.service.impl;

import java.util.List;

import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.login.Menu;
import com.haier.hevwms.remoting.rf.service.OtcwmsViewService;
/**
 * <p>Description: [手持 - 登录]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public class OtcwmsViewServiceImpl implements OtcwmsViewService {
	private WmsLoginDAO loginDAO;

	public void setLoginDAO(WmsLoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public List<Location> getLocation(Long uid)
	{
		return loginDAO.getUserLocation(uid);
	}
	@Override
	public List<Menu> getMenu(Long uid)
	{
		return loginDAO.getUserMenu(uid);
	}
}
