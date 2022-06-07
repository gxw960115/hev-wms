package com.haier.hevwms.order.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class StgDnDownTemp extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 182013028353213989L;

	/** ID(SEQ_STG_DN_DOWN_TEMP_ID) */
 
	private Long rowId;
 
	/** 销售DN单号 */
 
	private java.lang.String dnNo;
 
	/** 销售DN行项目 */
 
	private java.lang.String dnItemNo;
 
	/** 销售单号 */
 
	private java.lang.String sellNo;
 
	/** DN类型 发货/退货/寄售出/寄售退/寄售销售 */
 
	private java.lang.String sellOrderType;
 
	/** 工厂 */
 
	private java.lang.String plant;
 
	/** DN单创建日期 */
 
	private java.lang.String dnDocDate;
 
	/** DN单修改日期 */
 
	private java.lang.String dnLastModifyDate;
 
	/** DN单创建人 */
 
	private java.lang.String dnCreateBy;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private java.lang.String customerModel;
 
	/** 物料描述 */
 
	private java.lang.String materialDesp;
 
	/** DN单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private java.lang.String location;
 
	/** 客户编码 */
 
	private java.lang.String customerNo;
 
	/** 客户名称 */
 
	private java.lang.String customerName;
 
	/** 送达方编码 */
 
	private java.lang.String deliveryCode;
 
	/** 送达方名称 */
 
	private java.lang.String deliveryName;
 
	/** 客户要求到货日期 */
 
	private java.lang.String deliveryDate;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
 
	/** 关闭标志 默认-0 关闭-1 */
 
	private java.lang.String dnClose;
 
	/** 累计完成数量 */
 
	private Long finishQty;
 
	/** 单位 */
 
	private java.lang.String unit;
 
	/** 发货日期 */
 
	private java.lang.String deliverDate;
 
	/** 发票号 */
 
	private java.lang.String billing;
 
	/** 发票行项目 */
 
	private java.lang.String billingItem;
 
	/** 完成标志 默认-0 关闭-1 */
 
	private java.lang.String finishFlag;
 
	/** 有效标记 0-有效 1-失效 */
 
	private java.lang.String flag;
 
	/** 创建人 */
 
	private java.lang.String createBy;
 
	/** 修改人 */
 
	private java.lang.String modifyBy;
 
	/** 地区 */
 
	private java.lang.String region;
 
	/** 城市 */
 
	private java.lang.String city;
 
	/** 流水号#########(SEQ_STG_DN_DOWN_TEMP_STNO) */
 
	private Long stno;
 
	/** 1.待处理，空:已处理 */
 
	private java.lang.String dealFlag;
 
	/** 处理时间 */
 
	private java.util.Date dealTime;
 
	/** 处理描述 */
 
	private java.lang.String dealDesc;
 
	/** sap过账成功标记*/
	private java.lang.String sapFlag;
	
	/**
	 * sap 返回信息
	 */
	private java.lang.String sapMsg;
	
	/**
	 * sap 物料凭证号
	 */
	private java.lang.String sapDocNo;


	public Long getRowId() {
		return this.rowId;
	}
	
	public void setRowId(Long value) {
		this.rowId = value;
	}
	

	public java.lang.String getDnNo() {
		return this.dnNo;
	}
	
	public void setDnNo(java.lang.String value) {
		this.dnNo = value;
	}
	

	public java.lang.String getDnItemNo() {
		return this.dnItemNo;
	}
	
	public void setDnItemNo(java.lang.String value) {
		this.dnItemNo = value;
	}
	

	public java.lang.String getSellNo() {
		return this.sellNo;
	}
	
	public void setSellNo(java.lang.String value) {
		this.sellNo = value;
	}
	

	public java.lang.String getSellOrderType() {
		return this.sellOrderType;
	}
	
	public void setSellOrderType(java.lang.String value) {
		this.sellOrderType = value;
	}
	

	public java.lang.String getPlant() {
		return this.plant;
	}
	
	public void setPlant(java.lang.String value) {
		this.plant = value;
	}
	

	public java.lang.String getDnDocDate() {
		return this.dnDocDate;
	}
	
	public void setDnDocDate(java.lang.String value) {
		this.dnDocDate = value;
	}
	

	public java.lang.String getDnLastModifyDate() {
		return this.dnLastModifyDate;
	}
	
	public void setDnLastModifyDate(java.lang.String value) {
		this.dnLastModifyDate = value;
	}
	

	public java.lang.String getDnCreateBy() {
		return this.dnCreateBy;
	}
	
	public void setDnCreateBy(java.lang.String value) {
		this.dnCreateBy = value;
	}
	

	public java.lang.String getMaterialNo() {
		return this.materialNo;
	}
	
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	

	public java.lang.String getCustomerModel() {
		return this.customerModel;
	}
	
	public void setCustomerModel(java.lang.String value) {
		this.customerModel = value;
	}
	

	public java.lang.String getMaterialDesp() {
		return this.materialDesp;
	}
	
	public void setMaterialDesp(java.lang.String value) {
		this.materialDesp = value;
	}
	

	public Long getQty() {
		return this.qty;
	}
	
	public void setQty(Long value) {
		this.qty = value;
	}
	

	public java.lang.String getLocation() {
		return this.location;
	}
	
	public void setLocation(java.lang.String value) {
		this.location = value;
	}
	

	public java.lang.String getCustomerNo() {
		return this.customerNo;
	}
	
	public void setCustomerNo(java.lang.String value) {
		this.customerNo = value;
	}
	

	public java.lang.String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(java.lang.String value) {
		this.customerName = value;
	}
	

	public java.lang.String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	public void setDeliveryCode(java.lang.String value) {
		this.deliveryCode = value;
	}
	

	public java.lang.String getDeliveryName() {
		return this.deliveryName;
	}
	
	public void setDeliveryName(java.lang.String value) {
		this.deliveryName = value;
	}
	

	public java.lang.String getDeliveryDate() {
		return this.deliveryDate;
	}
	
	public void setDeliveryDate(java.lang.String value) {
		this.deliveryDate = value;
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
	

	public java.lang.String getDnClose() {
		return this.dnClose;
	}
	
	public void setDnClose(java.lang.String value) {
		this.dnClose = value;
	}
	

	public Long getFinishQty() {
		return this.finishQty;
	}
	
	public void setFinishQty(Long value) {
		this.finishQty = value;
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
	

	public java.lang.String getBilling() {
		return this.billing;
	}
	
	public void setBilling(java.lang.String value) {
		this.billing = value;
	}
	

	public java.lang.String getBillingItem() {
		return this.billingItem;
	}
	
	public void setBillingItem(java.lang.String value) {
		this.billingItem = value;
	}
	

	public java.lang.String getFinishFlag() {
		return this.finishFlag;
	}
	
	public void setFinishFlag(java.lang.String value) {
		this.finishFlag = value;
	}
	

	public java.lang.String getFlag() {
		return this.flag;
	}
	
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	

	public java.lang.String getCreateBy() {
		return this.createBy;
	}
	
	public void setCreateBy(java.lang.String value) {
		this.createBy = value;
	}
	

	public java.lang.String getModifyBy() {
		return this.modifyBy;
	}
	
	public void setModifyBy(java.lang.String value) {
		this.modifyBy = value;
	}
	

	public java.lang.String getRegion() {
		return this.region;
	}
	
	public void setRegion(java.lang.String value) {
		this.region = value;
	}
	

	public java.lang.String getCity() {
		return this.city;
	}
	
	public void setCity(java.lang.String value) {
		this.city = value;
	}
	

	public Long getStno() {
		return this.stno;
	}
	
	public void setStno(Long value) {
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
		this.dealTime = (Date) value.clone();
	}

	public java.lang.String getDealDesc() {
		return this.dealDesc;
	}
	
	public void setDealDesc(java.lang.String value) {
		this.dealDesc = value;
	}

	public java.lang.String getSapFlag() {
	    return sapFlag;
	}

	public void setSapFlag(java.lang.String sapFlag) {
	    this.sapFlag = sapFlag;
	}

	public java.lang.String getSapMsg() {
	    return sapMsg;
	}

	public void setSapMsg(java.lang.String sapMsg) {
	    this.sapMsg = sapMsg;
	}

	public java.lang.String getSapDocNo() {
	    return sapDocNo;
	}

	public void setSapDocNo(java.lang.String sapDocNo) {
	    this.sapDocNo = sapDocNo;
	}
	
	
}

