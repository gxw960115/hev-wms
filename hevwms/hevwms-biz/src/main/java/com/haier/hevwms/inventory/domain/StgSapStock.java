package com.haier.hevwms.inventory.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class StgSapStock extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971724514022498228L;

	/** ID */
 
	private Long rowId;
 
	/** 库存地点 */
 
	private java.lang.String location;
 
	/** 库存日期，下载日期 */
 
	private java.lang.String sapDownDate;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 数量 */
 
	private Long qty;
 
	/** 单位 */
 
	private java.lang.String unit;
 
	/** 批次号 */
 
	private java.lang.String batchNo;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	private String plant;
	
	private String customerModel;
	
	private String begin;
	private String end;
	
	private String userType;
	private Long userId;


	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public java.lang.String getLocation() {
		return this.location;
	}
	
	public void setLocation(java.lang.String value) {
		this.location = value;
	}
	

	public java.lang.String getSapDownDate() {
		return this.sapDownDate;
	}
	
	public void setSapDownDate(java.lang.String value) {
		this.sapDownDate = value;
	}
	

	public java.lang.String getMaterialNo() {
		if (this.materialNo != null) {
			this.materialNo = this.materialNo.toUpperCase();
		}
		return this.materialNo;
	}
	
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	

	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	

	public Long getQty() {
		return this.qty;
	}
	
	public void setQty(Long value) {
		this.qty = value;
	}
	

	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	

	public java.lang.String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(java.lang.String value) {
		this.batchNo = value;
	}
	
	public java.lang.Long getVersion() {
		return this.version;
	}
	
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}
	
	public java.util.Date getCreateDate() {
		if (this.createDate == null){
			return null;
		} else {
			return (Date) this.createDate.clone();
		}
	}
	
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	
	public java.util.Date getModifyDate() {
		if (this.modifyDate == null){
			return null;
		} else {
			return (Date) this.modifyDate.clone();
		}
	}
	
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
}

