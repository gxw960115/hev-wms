package com.haier.openplatform.wms.basicdata.dto;

import java.io.Serializable;
import java.util.Date;

public class CdWhInfoDTO implements Serializable{
    

	/**
	 * @author Liujian
	 * @ 2015.10.15
	 */
	private static final long serialVersionUID = -7293464589478570141L;

	/** 主键 */
 
	private Long rowId;
 
	/** 名称 */
 
	private String name;
	
	private String nameFat;
 
	/** 代码 */
 
	private String code;
 
	/** 创建人 */
 
	private String createBy;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改人 */
 
	private String modifyBy;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 有效标记 0-有效 1-失效 */
 
	private java.lang.String flag;
 
	/** 版本号 */
 
	private Long version;
	
	private String[] children;
	
	private String locations;
 
	/** 备注 */
    private String remark;

	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String value) {
		this.code = value;
	}
	

	public String getCreateBy() {
		return this.createBy;
	}
	
	public void setCreateBy(String value) {
		this.createBy = value;
	}
	
	public String getModifyBy() {
		return this.modifyBy;
	}
	
	public void setModifyBy(String value) {
		this.modifyBy = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}
	
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	

	public Long getVersion() {
		return this.version;
	}
	
	public void setVersion(Long value) {
		this.version = value;
	}

	public String[] getChildren() {
		if(locations!=null){
			children=locations.split(",");
			return children.clone();
		} else if (children != null){
			return children.clone();
		} else {
			return null;
		}
	}

	public void setChildren(String[] children) {
		if (children == null){
			this.children = null;
		} else {
			this.children = children.clone();
		}
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNameFat() {
		if (name != null && code != null) {
			nameFat = name + "(" + code + ")";
		}
		return nameFat;
	}

	public void setNameFat(String nameFat) {
		this.nameFat = nameFat;
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
	public java.util.Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
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

