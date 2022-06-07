package com.haier.hevwms.security.service.impl;

import org.apache.log4j.Logger;

import com.haier.hevwms.security.dao.SystemConfigDAO;
import com.haier.hevwms.security.service.SystemConfigService;

/**
 * @author WangXuzheng
 *
 */
public class SystemConfigServiceImpl implements SystemConfigService {
    Logger logger = Logger.getLogger(SystemConfigServiceImpl.class);
    
    private SystemConfigDAO systemConfigDAO ;

	public SystemConfigDAO getSystemConfigDAO() {
		return systemConfigDAO;
	}

	public void setSystemConfigDAO(SystemConfigDAO systemConfigDAO) {
		this.systemConfigDAO = systemConfigDAO;
	}

	@Override
	public void fifoConfig(String fifoFlag, String fifoPeriod) {
		systemConfigDAO.fifoConfig(fifoFlag, fifoPeriod);
		
	}

}
