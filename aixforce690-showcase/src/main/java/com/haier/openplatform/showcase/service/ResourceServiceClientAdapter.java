package com.haier.openplatform.showcase.service;

import java.util.List;

import com.haier.openplatform.hac.dto.HacResourceDTO;

public interface ResourceServiceClientAdapter {

	/**
	 * 取得当前系统、当前用户所具有的资源
	 * @param userCode
	 * @param language
	 * @return
	 */
	public List<HacResourceDTO> getResource(String userCode,String language);
	
}
