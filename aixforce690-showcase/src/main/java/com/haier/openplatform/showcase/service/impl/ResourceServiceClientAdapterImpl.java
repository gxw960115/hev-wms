package com.haier.openplatform.showcase.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.haier.openplatform.hac.dto.HacResourceDTO;
import com.haier.openplatform.hac.resource.service.HacResourceServiceClient;
import com.haier.openplatform.showcase.service.ResourceServiceClientAdapter;
import com.haier.openplatform.util.HOPConstant;

@Component
public class ResourceServiceClientAdapterImpl implements ResourceServiceClientAdapter {

	private HacResourceServiceClient resourceServiceClient;
	
	private String appHacVersion;

	public void setResourceServiceClient(HacResourceServiceClient resourceServiceClient) {
		this.resourceServiceClient = resourceServiceClient;
	}

	public void setAppHacVersion(String appHacVersion) {
		this.appHacVersion = appHacVersion;
	}
	@Override
	public List<HacResourceDTO> getResource(String userCode,String language){
		return resourceServiceClient.getResourcesByAppAndUser(HOPConstant.getAppName(), StringUtils.isBlank(userCode) ? "" : userCode, language,appHacVersion);
	}

}
