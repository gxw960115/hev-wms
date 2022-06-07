package com.haier.hevwms.basic.domain;

import com.haier.openplatform.domain.BaseDomain;

public class MdDictionary extends BaseDomain<Long> {

	private static final long serialVersionUID = 3012864259549853035L;

	private Long id;

	private java.lang.String code;

	private java.lang.String name;
	private String nameFat;

	private java.lang.String kindCode;

	private java.lang.String kindDescription;

	private java.lang.Long sort;

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String value) {
		this.name = value;
	}

	public java.lang.String getKindCode() {
		return this.kindCode;
	}

	public void setKindCode(java.lang.String value) {
		this.kindCode = value;
	}

	public java.lang.String getKindDescription() {
		return this.kindDescription;
	}

	public void setKindDescription(java.lang.String value) {
		this.kindDescription = value;
	}

	public java.lang.Long getSort() {
		return this.sort;
	}

	public void setSort(java.lang.Long value) {
		this.sort = value;
	}

	public String getNameFat() {
		if (name != null && code != null) {
			nameFat = name + "(" + code + ")";
		}
		return nameFat;
	}

	public void setNameFat(String nameFat) {
		this.nameFat = nameFat;
	}

}
