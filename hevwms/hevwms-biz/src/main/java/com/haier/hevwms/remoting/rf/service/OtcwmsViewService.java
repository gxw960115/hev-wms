package com.haier.hevwms.remoting.rf.service;

import java.util.List;

import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.login.Menu;

/**
 * <p>Description: [RF view手持接口 service]</p>
 * Created on 2013-8-2
 * @version 1.0
 */
public interface OtcwmsViewService {
	List<Location> getLocation(Long uid);
	List<Menu> getMenu(Long uid);
}
