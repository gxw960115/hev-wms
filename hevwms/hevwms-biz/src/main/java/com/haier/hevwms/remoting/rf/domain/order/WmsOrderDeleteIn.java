package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderDeleteIn {
	
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordertype; // 出入库类型
	private String orno; // 单号
	private String barcode; // 条码号
	private String bin;//库位
	
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

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrno() {
		return orno;
	}

	public void setOrno(String orno) {
		this.orno = orno;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	@Override
	public String toString() {
		return "WmsOrderDeleteIn [user=" + user + ", sign=" + sign + ", doctype=" + doctype + ", ordertype=" + ordertype
				+ ", orno=" + orno + ", barcode=" + barcode + ", bin=" + bin + "]";
	}

}
