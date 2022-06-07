package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderXjxcListIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordno; // 单号

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

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getOrdno() {
		return ordno;
	}

	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}
}
