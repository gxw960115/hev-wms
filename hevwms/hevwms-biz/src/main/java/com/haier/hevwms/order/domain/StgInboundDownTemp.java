package com.haier.hevwms.order.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class StgInboundDownTemp extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = -5628527442986382544L;

	/** ID */
 
	private Long rowId;
 
	/** 采购订单号 */
 
	private java.lang.String poNo;
 
	/** 采购订单行项目 */
 
	private java.lang.String poItemNo;
 
	/** INBOUND 代码 */
 
	private java.lang.String inboundDeliveryNo;
 
	/** INBOUND创建日期 */
 
	private java.lang.String indCreateDate;
 
	/** INBOUND 最后修改日期 */
 
	private java.lang.String indLastModifyDate;
 
	/** INBOUND 行项目 */
 
	private java.lang.String inboundItemNo;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 采购订单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private java.lang.String inboundLocation;
 
	/** 版本号 */
 
	private java.lang.Long version;
 
	/** 单位 */
 
	private java.lang.String unit;
 
	/** 发货日期 */
 
	private java.lang.String deliverDate;
 
	/** 流水号 */
 
	private java.lang.Long stno;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 1.待处理，空:已处理 */
 
	private java.lang.String dealFlag;
 
	/** 处理时间 */
 
	private java.util.Date dealTime;
 
	/** 处理描述 */
 
	private java.lang.String dealDesc;
 


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
	

	public java.lang.String getInboundDeliveryNo() {
		return this.inboundDeliveryNo;
	}
	
	public void setInboundDeliveryNo(java.lang.String value) {
		this.inboundDeliveryNo = value;
	}
	

	public java.lang.String getIndCreateDate() {
		return this.indCreateDate;
	}
	
	public void setIndCreateDate(java.lang.String value) {
		this.indCreateDate = value;
	}
	

	public java.lang.String getIndLastModifyDate() {
		return this.indLastModifyDate;
	}
	
	public void setIndLastModifyDate(java.lang.String value) {
		this.indLastModifyDate = value;
	}
	

	public java.lang.String getInboundItemNo() {
		return this.inboundItemNo;
	}
	
	public void setInboundItemNo(java.lang.String value) {
		this.inboundItemNo = value;
	}
	

	public java.lang.String getMaterialNo() {
		if(materialNo!=null){
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
	

	public java.lang.String getInboundLocation() {
		if(inboundLocation!=null){
			inboundLocation = inboundLocation.toUpperCase();
		}
		return inboundLocation;
	}
	
	public void setInboundLocation(java.lang.String value) {
		this.inboundLocation = value;
	}
	

	public java.lang.Long getVersion() {
		return this.version;
	}
	
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}
	

	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	

	public java.lang.String getDeliverDate() {
		return this.deliverDate;
	}
	
	public void setDeliverDate(java.lang.String value) {
		this.deliverDate = value;
	}
	

	public java.lang.Long getStno() {
		return this.stno;
	}
	
	public void setStno(java.lang.Long value) {
		this.stno = value;
	}

	public java.lang.String getDealFlag() {
		return this.dealFlag;
	}
	
	public void setDealFlag(java.lang.String value) {
		this.dealFlag = value;
	}

	public java.util.Date getDealTime() {
		if (this.dealTime == null){
			return null;
		} else {
			return (Date) this.dealTime.clone();
		}
	}
	
	public void setDealTime(java.util.Date value) {
		if (value == null){
			this.dealTime = null;
		} else {
			this.dealTime = (Date) value.clone();
		}
	}

	public java.lang.String getDealDesc() {
		return this.dealDesc;
	}
	
	public void setDealDesc(java.lang.String value) {
		this.dealDesc = value;
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
}
