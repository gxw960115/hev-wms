package com.haier.hevwms.order.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class StgInboundDown extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 2033113404295780102L;

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
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	private String deliverDate;
	
	private String createBy;
	
	private String unit;
	private String begin;
	private String end;
	private Long finishQty;
	
	private String userType;
	private Long userId;
	private String finishFlag;
	

	public Long getFinishQty() {
		return finishQty;
	}

	public void setFinishQty(Long finishQty) {
		this.finishQty = finishQty;
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
			materialNo= materialNo.toUpperCase();
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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	
	

}

