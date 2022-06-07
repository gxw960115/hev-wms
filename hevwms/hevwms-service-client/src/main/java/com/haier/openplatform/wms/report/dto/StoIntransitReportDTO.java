package com.haier.openplatform.wms.report.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportDTO.java
* @Package com.haier.openplatform.wms.report.dto
* @author YanFengdan
* @date 2015-12-2 上午10:07:33
 */
public class StoIntransitReportDTO implements Serializable{

	private static final long serialVersionUID = -6618629013628872068L;
	
	/** 主键 */
	private Long rowId;
	private String stoNo;//STO订单号
	private String materialNo;//物料号
	private String division;//大类
	private String customerModel;//客户描述
	private String materialDesp;//物料描述
	private String giPlt;
	private String giLoc;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private java.util.Date giDate;//创建日期
	private String grPlt;
	private String grLoc;
	private String barcode;
	private Long giQty;
	private Long intrasitQty;
	private String unit;
	private String giDateBegin;
	private String giDateEnd;
	
	public String getStoNo() {
		return stoNo;
	}
	public void setStoNo(String stoNo) {
		this.stoNo = stoNo;
	}
	public String getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
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
	public String getGiPlt() {
		return giPlt;
	}
	public void setGiPlt(String giPlt) {
		this.giPlt = giPlt;
	}
	public String getGiLoc() {
		return giLoc;
	}
	public void setGiLoc(String giLoc) {
		this.giLoc = giLoc;
	}
	public java.util.Date getGiDate() {
		if (giDate == null){
			return null;
		} else {
			return (Date) giDate.clone();
		}
	}
	public void setGiDate(java.util.Date giDate) {
		if (giDate == null){
			this.giDate = null;
		} else {
			this.giDate = (Date) giDate.clone();
		}
	}
	public String getGrPlt() {
		return grPlt;
	}
	public void setGrPlt(String grPlt) {
		this.grPlt = grPlt;
	}
	public String getGrLoc() {
		return grLoc;
	}
	public void setGrLoc(String grLoc) {
		this.grLoc = grLoc;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Long getGiQty() {
		return giQty;
	}
	public void setGiQty(Long giQty) {
		this.giQty = giQty;
	}
	public Long getIntrasitQty() {
		return intrasitQty;
	}
	public void setIntrasitQty(Long intrasitQty) {
		this.intrasitQty = intrasitQty;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public String getGiDateBegin() {
		return giDateBegin;
	}
	public void setGiDateBegin(String giDateBegin) {
		this.giDateBegin = giDateBegin;
	}
	public String getGiDateEnd() {
		return giDateEnd;
	}
	public void setGiDateEnd(String giDateEnd) {
		this.giDateEnd = giDateEnd;
	}

}
