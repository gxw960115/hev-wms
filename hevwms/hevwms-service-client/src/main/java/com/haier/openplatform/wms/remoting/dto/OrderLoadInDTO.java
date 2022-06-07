package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * @ClassName: OtcwmsOrderLoadInDTO
 * @Description: (这里用一句话描述这个类的作用)
 * @author Song Yinglong // Nicholas
 * @date 2015-11-16 下午2:01:17
 * @param
 */
public class OrderLoadInDTO implements Serializable {

	private static final long serialVersionUID = 6537751056757139711L;
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordertype; // 出入库类型
	private String orno; // 单号

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

}
