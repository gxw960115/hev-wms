package com.haier.hevwms.remoting.rf.domain.order;

public class WmsOrderUploadIn {
	private String user;		// 登陆账号
	private String sign;		// 签名
	private String doctype;		//单据类型

	private String location;	//库存地点
	private String sublocation;	//sub库存地点
	private String version;		//版本
	private String ordertype;	//出入库类型
	private String orno;		//单号
	private String barcode;		//条码号
	private String qty;			//数量
	private String carno;		//车号 泰国 dn 出库使用
	
	private String remark; //备注信息
	
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSublocation() {
		return sublocation;
	}

	public void setSublocation(String sublocation) {
		this.sublocation = sublocation;
	}

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
