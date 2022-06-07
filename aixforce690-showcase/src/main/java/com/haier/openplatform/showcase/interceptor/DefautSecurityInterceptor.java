package com.haier.openplatform.showcase.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.haier.openplatform.hac.dto.HacResourceDTO;
import com.haier.openplatform.hac.resource.dto.enu.ResourceTypeEnum;
import com.haier.openplatform.security.AbstractAuthenticator;
import com.haier.openplatform.security.Authentication;
import com.haier.openplatform.showcase.service.ResourceServiceClientAdapter;

/**
 * @author hanty
 * 
 */
public class DefautSecurityInterceptor extends AbstractAuthenticationInterceptor {

	private ResourceServiceClientAdapter resourceServiceClientAdapter; 
	/**
	 * 被忽略不被安全检查的url
	 */ 
	private List<String> ignoralList = new ArrayList<String>();
	 

	public List<String> getIgnoralList() {
		return ignoralList;
	}

	public void setIgnoralList(List<String> ignoralList) {
		this.ignoralList = ignoralList;
	} 

	public void setResourceServiceClientAdapter(
			ResourceServiceClientAdapter resourceServiceClientAdapter) {
		this.resourceServiceClientAdapter = resourceServiceClientAdapter;
	}
	
	@Override
	public Authentication getAuthentication(String userCode, HttpServletRequest request) { 
		List<HacResourceDTO> resources = resourceServiceClientAdapter.getResource(userCode, "zh_CN"); 
		Authentication authentication = new Authentication();
		for(HacResourceDTO resource : resources){
			ResourceTypeEnum resourceType = ResourceTypeEnum.toEnum(resource.getType());
			if(resourceType == ResourceTypeEnum.URL_RESOURCE || resourceType == ResourceTypeEnum.TODO_RESOURCE){
				authentication.getUrlResources().add(resource.getUrl());
				if(StringUtils.isNotEmpty(resource.getCode())){
					authentication.getComponentResources().add(resource.getCode());
				}
			}else if(resourceType == ResourceTypeEnum.COMPONENT_RESOURCE){
				authentication.getComponentResources().add(resource.getCode());
			}
		}
		return authentication;
	}
	
	@Override
	protected AbstractAuthenticator getAuthenticator(Authentication authentication) {
		return new AbstractAuthenticator(authentication) {
			@Override
			public boolean hasUrlAuth(String url) {
				String actualUrl = StringUtils.defaultIfEmpty(url, "/");
				if(!actualUrl.startsWith("/")){
					actualUrl = "/" + url;
				}
				for(String resource : getAuthentication().getUrlResources()){
					if(actualUrl.startsWith(resource)){
						return true;
					}
				}
				for(String resource : ignoralList){
					if(actualUrl.startsWith(resource)){
						return true;
					}
				}
				//HOP4.0不采用.action提交
				/*if(!url.contains(SUFFIX)){
					return true;
				}*/
				return false;
			}
		};
	} 
}
