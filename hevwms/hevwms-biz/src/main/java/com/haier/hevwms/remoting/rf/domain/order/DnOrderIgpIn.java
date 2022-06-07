package com.haier.hevwms.remoting.rf.domain.order;

public class DnOrderIgpIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordertype; // 出入库类型
	private String orno; // 单号
	private String location; // 库存地点
	private String postingdate; // 过账日期
	private String carno; // 车号
	private String version; // 泰国/巴基斯坦

	private String resDt;
	private String gooddt;
	private String crmdt;
	private String reasondt;

	public String getResDt() {
		return resDt;
	}

	public void setResDt(String resDt) {
		this.resDt = resDt;
	}

	public String getGooddt() {
		return gooddt;
	}

	public void setGooddt(String gooddt) {
		this.gooddt = gooddt;
	}

	public String getCrmdt() {
		return crmdt;
	}

	public void setCrmdt(String crmdt) {
		this.crmdt = crmdt;
	}

	public String getReasondt() {
		return reasondt;
	}

	public void setReasondt(String reasondt) {
		this.reasondt = reasondt;
	}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
