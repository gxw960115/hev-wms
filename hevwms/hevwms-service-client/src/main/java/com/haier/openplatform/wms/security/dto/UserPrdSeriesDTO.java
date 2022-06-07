package com.haier.openplatform.wms.security.dto;

import com.haier.openplatform.domain.BaseDomain;
/**
 * <p>Description: 基础数据用户物料组表的domain类</p>
 * Created on 2013-8-5
 * @author  <a href="mailto: chennsh@neusoft.com">陈乃帅</a>
 * @version 1.0
 */
public class UserPrdSeriesDTO extends BaseDomain<Long> {
    
	private static final long serialVersionUID = 4405049156236747300L;
	/** 用户ID */
	private java.lang.Long userId;
	/** 物料组编码 */
	private java.lang.String wlzCd;

	public java.lang.Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.String getWlzCd() {
		return this.wlzCd;
	}
	
	public void setWlzCd(java.lang.String value) {
		this.wlzCd = value;
	}
	

}

