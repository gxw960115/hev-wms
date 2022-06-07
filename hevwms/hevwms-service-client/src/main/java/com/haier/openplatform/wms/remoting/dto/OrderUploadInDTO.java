package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: OrderUploadInDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月6日 下午3:59:53
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月6日		LJZ			v1.0.0			create
 */

public class OrderUploadInDTO implements Serializable {

	private static final long serialVersionUID = 9159940160653514628L;
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
	 * @Fields location : (库存地点)
	 */
	private String location;
	/**
	 * @Fields sublocation : (sub库存地点)
	 */
	private String sublocation;
	/**
	 * @Fields version : (版本)
	 */
	private String version;
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
	/**
	 * @Fields qty : (数量)
	 */
	private String qty;
	/**
	 * @Fields bin (仓位)
	 */
	private String bin;
	/**
	 * @Fields remark : (备注)
	 */
	private String remark;
	
	private String returnType;  //po退货类型
	
	private String oldBarcode;

	private String plant;

	private String stodn;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSublocation() {
		return sublocation;
	}

	public void setSublocation(String sublocation) {
		this.sublocation = sublocation;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getOldBarcode() {
		return oldBarcode;
	}

	public void setOldBarcode(String oldBarcode) {
		this.oldBarcode = oldBarcode;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getStodn() {
		return stodn;
	}

	public void setStodn(String stodn) {
		this.stodn = stodn;
	}

	@Override
	public String toString() {
		return "OrderUploadInDTO{" +
				"user='" + user + '\'' +
				", sign='" + sign + '\'' +
				", doctype='" + doctype + '\'' +
				", location='" + location + '\'' +
				", sublocation='" + sublocation + '\'' +
				", version='" + version + '\'' +
				", ordertype='" + ordertype + '\'' +
				", orno='" + orno + '\'' +
				", barcode='" + barcode + '\'' +
				", qty='" + qty + '\'' +
				", bin='" + bin + '\'' +
				", remark='" + remark + '\'' +
				", returnType='" + returnType + '\'' +
				", oldBarcode='" + oldBarcode + '\'' +
				", plant='" + plant + '\'' +
				", stodn='" + stodn + '\'' +
				'}';
	}

}
