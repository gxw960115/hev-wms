package com.haier.openplatform.wms.security.dto;

import com.haier.openplatform.domain.BaseDomain;
/**
 * <p>Description: 基础数据用户客户表的domain类</p>
 * Created on 2013-8-15
 * @author  <a href="mailto: chennsh@neusoft.com">陈乃帅</a>
 * @version 1.0
 */
public class UserCustomerDTO extends BaseDomain<Long> {
	private static final long serialVersionUID = 8410141170215818076L;
	/** 用户ID */
	private java.lang.Long userId;
	/** 开票方编码 */
	private java.lang.String kpfCd;

	public java.lang.Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.String getKpfCd() {
		return this.kpfCd;
	}
	
	public void setKpfCd(java.lang.String value) {
		this.kpfCd = value;
	}
	

}

