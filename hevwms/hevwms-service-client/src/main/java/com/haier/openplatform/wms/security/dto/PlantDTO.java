package com.haier.openplatform.wms.security.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class PlantDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
    * @Fields rowId : 主键
    */
    private Long rowId;
	 
	/**
	* @Fields code : 工厂编码
	*/
	@FormParam(value = "plantCode") 
	private java.lang.String code;
 
	/**
	* @Fields name : 工厂名称
	*/
	@FormParam(value = "plantName") 
	private java.lang.String name;
 
 
	/**
	* @Fields deptCode : 事业部编码
	*/
	private java.lang.String deptCode;
 
 
	/**
	* @Fields deptName : 事业部名称
	*/
	private java.lang.String deptName;
 
	/**
	* @Fields salesCode : 采购组织编码
	*/
	@FormParam(value = "salesCode")
	private java.lang.String salesCode;
 
	/**
	* @Fields salesName : 采购组织名称
	*/
	@FormParam(value = "salesName")
	private java.lang.String salesName;
 
 
	/**
	* @Fields createdBy : 创建者
	*/
	private java.lang.String createdBy;
 
 
	/**
	* @Fields createdDate : 创建日期
	*/
	private java.lang.String createdDate;
 
 
	/**
	* @Fields modifyBy : 修改者
	*/
	private java.lang.String modifyBy;
 
 
	/**
	* @Fields modifyDate :修改日期
	*/
	private java.lang.String modifyDate;
 
 
	/**
	* @Fields version : 版本
	*/
	private java.lang.Long version;
	/**
	* @Fields purCode : 采购编码
	*/
	@FormParam(value = "purCode")
	private String purCode;
	
	/**
	* @Fields purName : 采购名称
	*/
	@FormParam(value = "purName")
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
	

	public java.lang.String getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(java.lang.String value) {
		this.createdDate = value;
	}
	

	public java.lang.String getModifyBy() {
		return this.modifyBy;
	}
	
	public void setModifyBy(java.lang.String value) {
		this.modifyBy = value;
	}
	

	public java.lang.String getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(java.lang.String value) {
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
