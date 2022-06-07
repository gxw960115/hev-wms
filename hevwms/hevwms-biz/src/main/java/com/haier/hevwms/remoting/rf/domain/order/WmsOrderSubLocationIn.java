package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderSubLocationIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String location;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
