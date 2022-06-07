package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderCheckIn {
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordertype; // 出入库类型
	private String orno; // 单号
	private String itemNo;
	private String dnType; // dn类型

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

	/**
	 * @Description: 属性 itemNo 的get方法
	 * @return itemNo
	 */
	public String getItemNo() {
		return itemNo;
	}

	/**
	 * @Description: 属性 itemNo 的set方法 itemNo
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDnType() {
		return dnType;
	}

	public void setDnType(String dnType) {
		this.dnType = dnType;
	}

}
