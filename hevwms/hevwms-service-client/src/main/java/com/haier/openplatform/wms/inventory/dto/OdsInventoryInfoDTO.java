
package com.haier.openplatform.wms.inventory.dto;

import com.haier.openplatform.domain.BaseDomain;

import java.util.Date;

public class OdsInventoryInfoDTO extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202870683153665455L;

	/** 主键 */
 
	private Long rowId;
 
	/** 工厂 */
 
	private String plant;
 
	/** 仓库代码 */
 
	private String warehouseCode;
 
	/** 仓库名称 */
 
	private String warehouseName;
 
	/** 客户描述 */
 
	private String customerModel;
 
	/** 库存地点 */
 
	private String location;
 
	/** 物料号 */
 
	private String materialNo;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 库存数量 */
 
	private Long wmsQty;
 
	/** 单位 */
 
	private String unit;
 
	/** 批次号 */
 
	private java.lang.String batchNo;
 
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
	
	private String begin;
	private String end;
	
	private String subLocation;
	private String userType;
	private Long userId;
	
	private String division;
	private String bin;

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

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
	

	public String getPlant() {
		return this.plant;
	}
	
	public void setPlant(String value) {
		this.plant = value;
	}
	

	public String getWarehouseCode() {
		return this.warehouseCode;
	}
	
	public void setWarehouseCode(String value) {
		this.warehouseCode = value;
	}
	

	public String getWarehouseName() {
		return this.warehouseName;
	}
	
	public void setWarehouseName(String value) {
		this.warehouseName = value;
	}
	

	public String getCustomerModel() {
		return this.customerModel;
	}
	
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	

	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String value) {
		this.location = value;
	}
	

	public String getMaterialNo() {
		if (this.materialNo != null) {
			this.materialNo = this.materialNo.toUpperCase();
		}
		return this.materialNo;
	}
	
	public void setMaterialNo(String value) {
		this.materialNo = value;
	}
	

	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	

	public Long getWmsQty() {
		return this.wmsQty;
	}
	
	public void setWmsQty(Long value) {
		this.wmsQty = value;
	}
	

	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
	

	public java.lang.String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(java.lang.String value) {
		this.batchNo = value;
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

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
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

