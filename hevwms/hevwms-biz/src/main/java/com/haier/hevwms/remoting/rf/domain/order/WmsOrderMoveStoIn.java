package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderMoveStoIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String serialno; // 流水号
	private String barcode; // 条码号
	private String sublocation; // 仓间代码

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

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getSublocation() {
		return sublocation;
	}

	public void setSublocation(String sublocation) {
		this.sublocation = sublocation;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
