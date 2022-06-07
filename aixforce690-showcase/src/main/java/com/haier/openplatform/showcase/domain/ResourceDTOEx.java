package com.haier.openplatform.showcase.domain;

import com.haier.openplatform.hac.dto.HacResourceDTO;

public class ResourceDTOEx extends HacResourceDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3395844350200811361L;
	/**
	 * member_app表id
	 */
	private Long wmaId;
	
	public Long getWmaId() {
		return wmaId;
	}
	public void setWmaId(Long wmaId) {
		this.wmaId = wmaId;
	}
	
}
