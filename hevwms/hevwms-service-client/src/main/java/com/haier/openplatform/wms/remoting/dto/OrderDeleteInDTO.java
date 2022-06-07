package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderDeleteInDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:51:47
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class OrderDeleteInDTO implements Serializable {

	private static final long serialVersionUID = 72027323753878222L;
	
	/**
	 * @Fields user : (登陆账号)
	 */
	private String user;
	/**
	 * @Fields sign : (签名)
	 */
	private String sign;
	/**
	 * @Fields doctype : (单据类型)
	 */
	private String doctype;
	/**
	 * @Fields ordertype : (出入库类型)
	 */
	private String ordertype;
	/**
	 * @Fields orno : (单号)
	 */
	private String orno;
	/**
	 * @Fields barcode : (条码号)
	 */
	private String barcode;

	private String bin;
	
	private String qty;
	
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "OrderDeleteInDTO [user=" + user + ", sign=" + sign + ", doctype=" + doctype + ", ordertype=" + ordertype
				+ ", orno=" + orno + ", barcode=" + barcode + ", bin=" + bin + "]";
	}

}
