package com.haier.openplatform.wms.report.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
* @Company: 青鸟软通
* @Title: SalesReturnReportDTO.java
* @Package com.haier.openplatform.wms.report.dto
* @author YanFengdan
* @date 2015-12-1 下午3:10:10
 */
public class SalesReturnReportDTO implements Serializable{

	private static final long serialVersionUID = 7683719418531731659L;

	/** 主键 */
	private Long rowId;
	private String location;//库存地点
	private String materialNo;//物料号
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private java.util.Date createDate=new Date();//创建日期
	private String begin;//开始时间
	private String end;//结束时间
	private String dnNo;//销售DN单号
	private String customerModel;//客户描述
	private String materialDesp;//物料描述
	private String barcode;//条码
	private String responsibleDepartment;//部门
	private String goodsClass;//产品分类
	private String crmComplainNo;
	private String reason;//原因
	private String createUser;//创建人
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}
	public java.util.Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDnNo() {
		return dnNo;
	}
	public void setDnNo(String dnNo) {
		this.dnNo = dnNo;
	}
	public String getCustomerModel() {
		return customerModel;
	}
	public void setCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}
	public String getMaterialDesp() {
		return materialDesp;
	}
	public void setMaterialDesp(String materialDesp) {
		this.materialDesp = materialDesp;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getResponsibleDepartment() {
		return responsibleDepartment;
	}
	public void setResponsibleDepartment(String responsibleDepartment) {
		this.responsibleDepartment = responsibleDepartment;
	}
	public String getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}
	public String getCrmComplainNo() {
		return crmComplainNo;
	}
	public void setCrmComplainNo(String crmComplainNo) {
		this.crmComplainNo = crmComplainNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
}
