package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderXjxcIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String barcode; // 条码

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

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
