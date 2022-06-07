package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: WmsOrderIgpInDTO.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月7日 上午10:59:29
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月7日		LJZ			v1.0.0			create
 */

public class OrderIgpInDTO implements Serializable {

	private static final long serialVersionUID = -2830160039424400195L;
	
	/**
	 * @Fields user : (// 登陆账号)
	 */
	private String user;
	/**
	 * @Fields sign : (// 签名)
	 */
	private String sign;
	/**
	 * @Fields doctype : (//单据类型)
	 */
	private String docType;
	/**
	 * @Fields ordertype : (//出入库类型)
	 */
	private String orderType;
	/**
	 * @Fields orno : (//单号)
	 */
	private String orno;
	/**
	 * @Fields location : (//库存地点)
	 */
	private String location;
	/**
	 * @Fields postingdate : (//过账日期)
	 */
	private String postingdate;
	private String glAccount;
	private String costCenter;
	/**
	 * @Fields carno : (//车号)
	 */
	private String carNo;
	/**
	 * @Fields version : (版本)
	 */
	private String version;

	private String resDt;

	private String gooddt;

	private String crmdt;

	private String reasondt;
	// 车辆类型
	private String vehicleType;

	private String transpoterName;

	private String lrNo;

	private String lrDate;

	private String invoiceNo;
	
	private String returnType;

	private String bin;

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

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getTranspoterName() {
		return transpoterName;
	}

	public void setTranspoterName(String transpoterName) {
		this.transpoterName = transpoterName;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	@Override
	public String toString() {
		return "OrderIgpInDTO{" +
				"user='" + user + '\'' +
				", sign='" + sign + '\'' +
				", docType='" + docType + '\'' +
				", orderType='" + orderType + '\'' +
				", orno='" + orno + '\'' +
				", location='" + location + '\'' +
				", postingdate='" + postingdate + '\'' +
				", glAccount='" + glAccount + '\'' +
				", costCenter='" + costCenter + '\'' +
				", carNo='" + carNo + '\'' +
				", version='" + version + '\'' +
				", resDt='" + resDt + '\'' +
				", gooddt='" + gooddt + '\'' +
				", crmdt='" + crmdt + '\'' +
				", reasondt='" + reasondt + '\'' +
				", vehicleType='" + vehicleType + '\'' +
				", transpoterName='" + transpoterName + '\'' +
				", lrNo='" + lrNo + '\'' +
				", lrDate='" + lrDate + '\'' +
				", invoiceNo='" + invoiceNo + '\'' +
				", returnType='" + returnType + '\'' +
				", bin='" + bin + '\'' +
				'}';
	}
}
