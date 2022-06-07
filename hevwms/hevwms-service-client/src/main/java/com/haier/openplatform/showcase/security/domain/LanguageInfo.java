package com.haier.openplatform.showcase.security.domain;

import com.haier.openplatform.domain.BaseDomain;

public class LanguageInfo extends BaseDomain<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6591296978576514779L;
	private String languageCode;
	private String languageName;
	private String defaultFlag;
	private Integer taxisNo;
	
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	public Integer getTaxisNo() {
		return taxisNo;
	}
	public void setTaxisNo(Integer taxisNo) {
		this.taxisNo = taxisNo;
	}
}
