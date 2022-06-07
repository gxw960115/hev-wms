package com.haier.hevwms.basic.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class CdLocInfo extends BaseDomain<Long> {

	/**
	 * 
	 *@author Liujian
	 *@2015.10.15
	 */
	private static final long serialVersionUID = -6205420928905230567L;

	/** 主键 */

	private Long rowId;

	/** 名称 */

	private String name;

	private String nameFat;

	/** 代码 */

	private String code;

	/** 父id 库存地点的上级仓库 */

	private Long parentId;

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

	private String whCode;
	
	private String whName;
	
	private String cityCode;
	
	private String cityName;
	
	/** 备注 */
	private String remark;
	
	/** 有效面积 */
	private Float validArea;
	
	/** 高度*/
	private Float height;
	
	/** 租金*/
	private Float rentFee;
	
	/** 仓库地点类型 */
	private String locationType;
	
	
	private String chkDisabled="false";
	
	public String getChkDisabled() {
		return chkDisabled;
	}

	public void setChkDisabled(String chkDisabled) {
		this.chkDisabled = chkDisabled;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	private boolean checked = false;


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

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long value) {
		this.parentId = value;
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

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getWhName() {
		return whName;
	}

	public void setWhName(String whName) {
		this.whName = whName;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public Float getValidArea() {
		return validArea;
	}

	public void setValidArea(Float validArea) {
		this.validArea = validArea;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getRentFee() {
		return rentFee;
	}

	public void setRentFee(Float rentFee) {
		this.rentFee = rentFee;
	}
	
	

}


