package com.haier.openplatform.wms.po.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StgPoDownDTO implements Serializable {

	private static final long serialVersionUID = 3636420960788657566L;

	/** ID */
	private Long rowId;

	/** 采购订单 */
	private java.lang.String poNo;

	/** 采购订单行项 */
	private java.lang.String poItemNo;

	/**
	 * 采购订单类型 
	 * 泰国NB:Normal stock PO ZAC:SET PO ZFOC:Free Of Charge PO ZRE:Return PO 
	 * 巴基斯坦NB:Normal stock PO ZAC:SET PO ZFOC:Free Of Charge PO ZRE:Return PO
	 */
	private java.lang.String poType;

	/** 确认控制：空（PO收货），0001（做inbound */
	private java.lang.String inboundFlag;

	/** 工厂 */
	private java.lang.String plant;

	/** 采购订单创建日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.lang.String poDocDate;

	/** 采购订单修改日期 */
	private java.lang.String poLastModifyDate;

	/** 采购订单创建 */
	private java.lang.String poCreateBy;

	/** 物料 */
	private java.lang.String materialNo;

	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号 */
	private String customerModel;

	/** 物料描述 */
	private String materialDesp;

	/** 采购订单数量 */
	private Long qty;

	/** 库存地点 */
	private java.lang.String poLocation;

	/** 行项目删除标 */
	private java.lang.String itemDeltet;

	/** PO关闭 */
	private java.lang.String poClose;

	/** 创建日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date createDate;

	/** 修改日期 */
	private java.util.Date modifyDate;

	/** 版本 */
	private java.lang.Long version;
	
	/** 发货日期 */
	private String deliverDate;
	
	/** 单位 */
	private String unit;
	
	/** 完成数量 */
	private Long finishQty;
	private String modifyBy;
	private String createBy;
	private String begin;
	private String end;
	private String userType;
	private Long userId;
	private String finishFlag;
	private String flag;
	private String vendorCode;
	private String vendorName;
	private String orderUnit;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Long getRowId() {
		return this.rowId;
	}

	public void setRowId(Long value) {
		this.rowId = value;
	}

	public java.lang.String getPoNo() {
		return this.poNo;
	}

	public void setPoNo(java.lang.String value) {
		this.poNo = value;
	}

	public java.lang.String getPoItemNo() {
		return this.poItemNo;
	}

	public void setPoItemNo(java.lang.String value) {
		this.poItemNo = value;
	}

	public java.lang.String getPoType() {
		return this.poType;
	}

	public void setPoType(java.lang.String value) {
		this.poType = value;
	}

	public java.lang.String getInboundFlag() {
		return this.inboundFlag;
	}

	public void setInboundFlag(java.lang.String value) {
		this.inboundFlag = value;
	}

	public java.lang.String getPlant() {
		return this.plant;
	}

	public void setPlant(java.lang.String value) {
		this.plant = value;
	}

	public java.lang.String getPoDocDate() {
		return this.poDocDate;
	}

	public void setPoDocDate(java.lang.String value) {
		this.poDocDate = value;
	}

	public java.lang.String getPoLastModifyDate() {
		return this.poLastModifyDate;
	}

	public void setPoLastModifyDate(java.lang.String value) {
		this.poLastModifyDate = value;
	}

	public java.lang.String getPoCreateBy() {
		return this.poCreateBy;
	}

	public void setPoCreateBy(java.lang.String value) {
		this.poCreateBy = value;
	}

	public java.lang.String getMaterialNo() {
		if (materialNo != null) {
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}

	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}

	public String getCustomerModel() {
		return this.customerModel;
	}

	public void setCustomerModel(String value) {
		this.customerModel = value;
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

	public java.lang.String getPoLocation() {
		if (poLocation != null) {
			poLocation = poLocation.toUpperCase();
		}
		return poLocation;
	}

	public void setPoLocation(java.lang.String value) {
		this.poLocation = value;
	}

	public java.lang.String getItemDeltet() {
		return this.itemDeltet;
	}

	public void setItemDeltet(java.lang.String value) {
		this.itemDeltet = value;
	}

	public java.lang.String getPoClose() {
		return this.poClose;
	}

	public void setPoClose(java.lang.String value) {
		this.poClose = value;
	}

	public java.lang.Long getVersion() {
		return this.version;
	}

	public void setVersion(java.lang.Long value) {
		this.version = value;
	}

	public String getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	public Long getFinishQty() {
		return finishQty;
	}

	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
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
	
	public String getFinishFlag() {
		return finishFlag;
	}

	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

	public java.util.Date getCreateDate() {
		if (createDate == null) {
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}

	public void setCreateDate(java.util.Date value) {
		if (value == null) {
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}

	public java.util.Date getModifyDate() {
		if (modifyDate == null) {
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}

	public void setModifyDate(java.util.Date value) {
		if (value == null) {
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

}
