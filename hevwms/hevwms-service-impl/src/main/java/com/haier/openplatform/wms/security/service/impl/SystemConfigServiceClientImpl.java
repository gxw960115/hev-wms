package com.haier.openplatform.wms.security.service.impl;



import org.apache.log4j.Logger;

import com.haier.hevwms.security.service.SystemConfigService;
import com.haier.openplatform.wms.security.service.SystemConfigServiceClient;


public class SystemConfigServiceClientImpl implements SystemConfigServiceClient {
	private Logger logger = Logger.getLogger(SystemConfigServiceClientImpl.class);
	
	private SystemConfigService systemConfigService;
	
	public SystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	public void setSystemConfigService(SystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}

	@Override
	public String fifoConfig(String fifoFlag, String fifoPeroid) {
		try{
			systemConfigService.fifoConfig(fifoFlag, fifoPeroid);
		} catch(Exception e){
			logger.debug(e.getMessage());
			return "fail";
		}
		return "success";
	}

}
