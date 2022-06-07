package com.haier.hevwms.po.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

/**
* @ClassName: StgPoDown
* @Description: PO订单的实体类
*
*/
public class StgPoDown extends BaseDomain<Long> {
   
	private static final long serialVersionUID = 3636420960788657566L;

	/** ID */
 
	private Long rowId;
 
	/** 采购订单号 */
 
	private java.lang.String poNo;
 
	/** 采购订单行项目 */
 
	private java.lang.String poItemNo;
 
	/** 采购订单类型 泰国： NB:Normal stock PO ZAC:SET PO ZFOC:Free Of Charge PO ZRE:Return PO 巴基斯坦： NB:Normal stock PO ZAC:SET PO ZFOC:Free Of Charge PO ZRE:Return PO */
 
	private java.lang.String poType;
 
	/** 确认控制：空（PO收货），0001（做inbound） */
 
	private java.lang.String inboundFlag;
 
	/** 工厂 */
 
	private java.lang.String plant;
 
	/** 采购订单创建日期 */
 
	private java.lang.String poDocDate;
 
	/** 采购订单修改日期 */
 
	private java.lang.String poLastModifyDate;
 
	/** 采购订单创建人 */
 
	private java.lang.String poCreateBy;
 
	/** 物料号 */
 
	private java.lang.String materialNo;
 
	/** 客户型号，将描述以冒号分为前客户型号后物料描述两部分分别读取,冒号前 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 采购订单数量 */
 
	private Long qty;
 
	/** 库存地点 */
 
	private java.lang.String poLocation;
 
	/** 行项目删除标记 */
 
	private java.lang.String itemDeltet;
 
	/** PO关闭 */
 
	private java.lang.String poClose;
 
	/** 创建日期 */
 
	private java.util.Date createDate;
 
	/** 修改日期 */
 
	private java.util.Date modifyDate;
 
	/** 版本号 */
 
	private java.lang.Long version;
	
	/** 发货日期*/
	private String deliverDate;
	
	/** 单位 */
	private String unit;
	
	private String finishQty;
	
	private String modifyBy;
	
	private String createBy;
	
	private String begin;
	
	private String end;
    
	private String userType;
    
	private Long userId;
    
	private String finishFlag;
	
	private String vendorCode;
	private String vendorName;
	private String orderUnit;

	/**
	 * @Description: 属性Begin的get方法
	 * @return Begin
	 */
	public String getBegin() {
		return begin;
	}
	
	/**
	 * @Description: 属性Begin的set方法
	 * Begin
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}
	
	/**
	 * @Description: 属性 End的get方法
	 * @return End
	 */
	public String getEnd() {
		return end;
	}
	
	/**
	 * @Description: 属性End的set方法
	 * End
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	
	/**
	 * @Description: 属性CreateBy的get方法
	 * @return CreateBy
	 */
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * @Description: 属性CreateBy的set方法
	 * CreateBy
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	/**
	 * @Description: 属性modifyBy的get方法
	 * @return modifyBy
	 */
	public String getModifyBy() {
		return modifyBy;
	}
	
	/**
	 * @Description: 属性modifyBy的set方法
	 * modifyBy
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
	/**
	 * @Description: 属性RowId的get方法
	 * @return RowId
	 */
	public Long getRowId() {
		return this.rowId;
	}
	
	/**
	 * @Description: 属性RowId的set方法
	 * RowId
	 */
	public void setRowId(Long value) {
		this.rowId = value;
	}
	
	/**
	 * @Description: 属性PoNo的get方法
	 * @return PoNo
	 */
	public java.lang.String getPoNo() {
		return this.poNo;
	}
	
	/**
	 * @Description: 属性 PoNo的set方法
	 * PoNo
	 */
	public void setPoNo(java.lang.String value) {
		this.poNo = value;
	}
	
	/**
	 * @Description: 属性 PoItemNo的get方法
	 * @return PoItemNo
	 */
	public String getPoItemNo() {
		return this.poItemNo;
	}
	
	/**
	 * @Description: 属性 PoItemNo的set方法
	 * PoItemNo
	 */
	public void setPoItemNo(java.lang.String value) {
		this.poItemNo = value;
	}
	
	/**
	 * @Description: 属性 PoType的get方法
	 * @return PoType
	 */
	public String getPoType() {
		return this.poType;
	}
	
	/**
	 * @Description: 属性 PoType的set方法
	 * PoType
	 */
	public void setPoType(java.lang.String value) {
		this.poType = value;
	}
	
	/**
	 * @Description: 属性 InboundFlag的get方法
	 * @return InboundFlag
	 */
	public String getInboundFlag() {
		return this.inboundFlag;
	}
	
	/**
	 * @Description: 属性 InboundFlag的set方法
	 * InboundFlag
	 */
	public void setInboundFlag(java.lang.String value) {
		this.inboundFlag = value;
	}
	
	/**
	 * @Description: 属性 Plant的get方法
	 * @return Plant
	 */
	public java.lang.String getPlant() {
		return this.plant;
	}
	
	/**
	 * @Description: 属性 Plant的set方法
	 * Plant
	 */
	public void setPlant(java.lang.String value) {
		this.plant = value;
	}
	
	/**
	 * @Description: 属性 PoDocDate的get方法
	 * @return PoDocDate
	 */
	public java.lang.String getPoDocDate() {
		return this.poDocDate;
	}
	
	/**
	 * @Description: 属性PoDocDate的set方法
	 * PoDocDate
	 */
	public void setPoDocDate(java.lang.String value) {
		this.poDocDate = value;
	}
	
	/**
	 * @Description: 属性PoLastModifyDate的get方法
	 * @return PoLastModifyDate
	 */
	public java.lang.String getPoLastModifyDate() {
		return this.poLastModifyDate;
	}
	
	/**
	 * @Description: 属性 PoLastModifyDate 的set方法
	 * PoLastModifyDate
	 */
	public void setPoLastModifyDate(java.lang.String value) {
		this.poLastModifyDate = value;
	}
	
	/**
	 * @Description: 属性 PoCreateBy 的get方法
	 * @return PoCreateBy
	 */
	public java.lang.String getPoCreateBy() {
		return this.poCreateBy;
	}
	
	/**
	 * @Description: 属性 PoCreateBy 的set方法
	 * PoCreateBy
	 */
	public void setPoCreateBy(java.lang.String value) {
		this.poCreateBy = value;
	}
	
	/**
	 * @Description: 属性 MaterialNo的get方法
	 * @return MaterialNo
	 */
	public java.lang.String getMaterialNo() {
		if(materialNo!=null){
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	/**
	 * @Description: 属性 MaterialNo的set方法
	 * MaterialNo
	 */
	public void setMaterialNo(java.lang.String value) {
		this.materialNo = value;
	}
	
	/**
	 * @Description: 属性 CustomerModel 的get方法
	 * @return CustomerModel
	 */
	public String getCustomerModel() {
		return this.customerModel;
	}
	
	/**
	 * @Description: 属性CustomerModel的set方法
	 * CustomerModel
	 */
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	
	/**
	 * @Description: 属性 MaterialDesp的get方法
	 * @return MaterialDesp
	 */
	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	/**
	 * @Description: 属性 MaterialDesp的set方法
	 * MaterialDesp
	 */
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	
	/**
	 * @Description: 属性 Qty 的get方法
	 * @return Qty
	 */
	public Long getQty() {
		return this.qty;
	}
	
	/**
	 * @Description: 属性 Qty的set方法
	 * Qty
	 */
	public void setQty(Long value) {
		this.qty = value;
	}
	
	/**
	 * @Description: 属性 PoLocation的get方法
	 * @return PoLocation
	 */
	public java.lang.String getPoLocation() {
		if(poLocation!=null){
			poLocation = poLocation.toUpperCase();
		}
		return poLocation;
	}
	
	/**
	 * @Description: 属性 PoLocation的set方法
	 * PoLocation
	 */
	public void setPoLocation(java.lang.String value) {
		this.poLocation = value;
	}
	
	/**
	 * @Description: 属性 ItemDeltet的get方法
	 * @return ItemDeltet
	 */
	public java.lang.String getItemDeltet() {
		return this.itemDeltet;
	}
	
	/**
	 * @Description: 属性 ItemDeltet 的set方法
	 * ItemDeltet
	 */
	public void setItemDeltet(java.lang.String value) {
		this.itemDeltet = value;
	}
	
	/**
	 * @Description: 属性 PoClose的get方法
	 * @return PoClose
	 */
	public java.lang.String getPoClose() {
		return this.poClose;
	}
	
	/**
	 * @Description: 属性PoClose的set方法
	 * PoClose
	 */
	public void setPoClose(java.lang.String value) {
		this.poClose = value;
	}
	
	/**
	 * @Description: 属性 CreateDate的get方法
	 * @return CreateDate
	 */
	public java.util.Date getCreateDate() {
		if (this.createDate == null){
			return null;
		} else {
			return (Date) this.createDate.clone();
		}
	}
	
	/**
	 * @Description: 属性CreateDate的set方法
	 * CreateDate
	 */
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	
	/**
	 * @Description: 属性ModifyDate的get方法
	 * @return ModifyDate
	 */
	public java.util.Date getModifyDate() {
		if (this.modifyDate == null){
			return null;
		} else {
			return (Date) this.modifyDate.clone();
		}
	}
	
	/**
	 * @Description: 属性 ModifyDate 的set方法
	 * ModifyDate
	 */
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}
	
	/**
	 * @Description: 属性Version的get方法
	 * @return Version
	 */
	public java.lang.Long getVersion() {
		return this.version;
	}
	
	/**
	 * @Description: 属性 Version 的set方法
	 * Version
	 */
	public void setVersion(java.lang.Long value) {
		this.version = value;
	}
	
	/**
	 * @Description: 属性 DeliverDate 的get方法
	 * @return DeliverDate
	 */
	public String getDeliverDate() {
		return deliverDate;
	}
	
	/**
	 * @Description: 属性DeliverDate的set方法
	 * DeliverDate
	 */
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	
	/**
	 * @Description: 属性 Unit的get方法
	 * @return Unit
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * @Description: 属性Unit的set方法
	 * Unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * @Description: 属性 FinishQty的get方法
	 * @return FinishQty
	 */
	public String getFinishQty() {
		return finishQty;
	}
	
	/**
	 * @Description: 属性 FinishQty 的set方法
	 * FinishQty
	 */
	public void setFinishQty(String finishQty) {
		this.finishQty = finishQty;
	}
	
	/**
	 * @Description: 属性UserType的get方法
	 * @return UserType
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * @Description: 属性UserType的set方法
	 * UserType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * @Description: 属性UserId的get方法
	 * @return UserId
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * @Description: 属性UserId的set方法
	 * UserId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * @Description: 属性 FinishFlag的get方法
	 * @return FinishFlag
	 */
	public String getFinishFlag() {
		return finishFlag;
	}
	
	/**
	 * @Description: 属性 FinishFlag的set方法
	 * FinishFlag
	 */
	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
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

