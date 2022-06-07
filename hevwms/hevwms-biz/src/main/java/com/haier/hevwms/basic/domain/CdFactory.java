package com.haier.hevwms.basic.domain;

import com.haier.openplatform.domain.BaseDomain;

public class CdFactory extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = -7617016014098855478L;

	/** rowId */
	
	private Long rowId;
 
	/** 工厂编码 */
 
	private java.lang.String code;
 
	/** 工厂名称 */
 
	private java.lang.String name;
 
	/** 事业部编码 */
 
	private java.lang.String deptCode;
 
	/** 事业部名称 */
 
	private java.lang.String deptName;
 
	/** 采购组织编码 */
 
	private java.lang.String salesCode;
 
	/** 采购组织名称 */
 
	private java.lang.String salesName;
 
	/** createdBy */
 
	private java.lang.String createdBy;
 
	/** createdDate */
 
	private String createdDate;
 
	/** modifyBy */
 
	private java.lang.String modifyBy;
 
	/** modifyDate */
 
	private String modifyDate;
 
	/** version */
 
	private java.lang.Long version;
	
	private String purCode;
	private String purName;
 


	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	

	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	

	public java.lang.String getDeptCode() {
		return this.deptCode;
	}
	
	public void setDeptCode(java.lang.String value) {
		this.deptCode = value;
	}
	

	public java.lang.String getDeptName() {
		return this.deptName;
	}
	
	public void setDeptName(java.lang.String value) {
		this.deptName = value;
	}
	

	public java.lang.String getSalesCode() {
		return this.salesCode;
	}
	
	public void setSalesCode(java.lang.String value) {
		this.salesCode = value;
	}
	

	public java.lang.String getSalesName() {
		return this.salesName;
	}
	
	public void setSalesName(java.lang.String value) {
		this.salesName = value;
	}
	

	public java.lang.String getCreatedBy() {
		return this.createdBy;
	}
	
	public void setCreatedBy(java.lang.String value) {
		this.createdBy = value;
	}
	

	public String getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(String value) {
		this.createdDate = value;
	}
	

	public java.lang.String getModifyBy() {
		return this.modifyBy;
	}
	
	public void setModifyBy(java.lang.String value) {
		this.modifyBy = value;
	}
	

	public String getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(String value) {
		this.modifyDate = value;
	}
	

	public java.lang.Long getVersion() {
		return this.version;
	}
	
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}

	public String getPurCode() {
		return purCode;
	}

	public void setPurCode(String purCode) {
		this.purCode = purCode;
	}

	public String getPurName() {
		return purName;
	}

	public void setPurName(String purName) {
		this.purName = purName;
	}
	

}

