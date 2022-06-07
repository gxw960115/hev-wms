package com.haier.hevwms.takestock.domain;

import java.io.Serializable;
import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;


public class OdsPdInfo extends BaseDomain<Long> implements Serializable {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418555206961545312L;

	/** 主键 */
 
	private Long rowId;
 
	/** 盘点单号 */
 
	private String orderNo;
 
	/** 盘点类型 0-库存地点 1-物料号 */
 
	private java.lang.String orderType;
 
	/** 盘点单状态 0-未盘 1-进行中 2-完成 */
 
	private java.lang.String orderStatus;
 
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
 
	/** 单位 */
 
	private String unit;
 
	/** 实际盘点数量 */
 
	private Long actualQty;
 
	/** 盘点开始时间 */
 
	private java.util.Date beginDate=new Date();
 
	/** 盘点结束时间 */
 
	private java.util.Date endDate=new Date();
 
	/** 创建人 */
 
	private String createBy;
 
	/** 创建日期 */
 
	private java.util.Date createDate=new Date();
 
	/** 修改人 */
 
	private String modifyBy;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate=new Date();
 
	/** 有效标记 0-有效 1-失效 */
 
	private java.lang.String flag;
 
	/** 版本号 */
 
	private Long version;
 
	private String begin;
	private String end;

	/**  */
    private String userType;
    
    /**  */
    private Long userId;
    
    private String bin;
    
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
	

	public String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(String value) {
		this.orderNo = value;
	}
	

	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	

	public java.lang.String getOrderStatus() {
		return this.orderStatus;
	}
	
	public void setOrderStatus(java.lang.String value) {
		this.orderStatus = value;
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
		if(location!=null){
			location = location.toUpperCase();
		}
		return location;
	}
	
	public void setLocation(String value) {
		this.location = value;
	}
	

	public String getMaterialNo() {
		if(materialNo!=null){
			materialNo= materialNo.toUpperCase();
		}
		return materialNo;
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
	

	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
	

	public Long getActualQty() {
		return this.actualQty;
	}
	
	public void setActualQty(Long value) {
		this.actualQty = value;
	}
	

	public java.util.Date getBeginDate() {
		if (this.beginDate == null){
			return null;
		} else {
			return (Date) this.beginDate.clone();
		}
	}
	
	public void setBeginDate(java.util.Date value) {
		if (value == null){
			this.beginDate = null;
		} else {
			this.beginDate = (Date) value.clone();
		}
	}
	

	public java.util.Date getEndDate() {
		if (this.endDate == null){
			return null;
		} else {
			return (Date) this.endDate.clone();
		}
	}
	
	public void setEndDate(java.util.Date value) {
		if (value == null){
			this.endDate = null;
		} else {
			this.endDate = (Date) value.clone();
		}
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

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

}

