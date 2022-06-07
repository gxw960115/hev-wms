package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * @ClassName: OtcwmsOrderCheckInDTO
 * @Description: (手持输入验证单据)
 * @author Song Yinglong // Nicholas
 * @date 2015-11-6 下午2:37:34
 * @param
 */
public class OrderCheckInDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user; // 登陆账号
	private String sign; // 签名
	private String doctype; // 单据类型
	private String ordertype; // 出入库类型
	private String orno; // 单号
	private String dnType; // dn类型，billing，srn，consigentout，consigmentin
	private String dutyType;
	private String returnType;  //po退货类型：101  102  122

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

	public String getDnType() {
		return dnType;
	}

	public void setDnType(String dnType) {
		this.dnType = dnType;
	}

	public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

}
