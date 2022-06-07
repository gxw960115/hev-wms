package com.haier.openplatform.showcase.domain.enu;

public enum AuthSourcceEnum {

	SOURCE_IDM("IDM", "内网用户中心"), SOURCE_IDS("IDS", "外网用户中心");
	private String type;
	private String description;

	private AuthSourcceEnum(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
}
