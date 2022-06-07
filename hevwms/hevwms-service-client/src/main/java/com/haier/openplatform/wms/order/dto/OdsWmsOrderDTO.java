
package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;


public class OdsWmsOrderDTO implements Serializable {
    

	/**
	 * 
	 */

	/** 主键 */
 
	private Long rowId;
 
	/** 单据号 */
 
	private String wmsOrderNo;
 
	/** 行项目 */
 
	private java.lang.String wmsOrderItem;
 
	/** 出入库类型 1-入库 2-出库 */
 
	private java.lang.String orderType;
 
	/** 凭证类型 GIFT/SCRAP */
 
	private java.lang.String docTpye;
 
	/** 工厂 */
 
	private String plant;
 
	/** 仓库代码 */
 
	private String warehouseCode;
 
	/** 仓库名称 */
 
	private String warehouseName;
 
	/** 库存地点 */
 
	private String location;
 
	/** 物料号 */
 
	private String materialNo;
 
	/** 客户描述 */
 
	private String customerModel;
 
	/** 物料描述 */
 
	private String materialDesp;
 
	/** 单位 */
 
	private String unit;
 
	/** 供应商编号 */
 
	private String vendorCode;
 
	/** 供应商名称 */
 
	private String vendorName;
 
	/** 送达方编号 */
 
	private String deliveryCode;
 
	/** 送达方名称 */
 
	private String deliveryName;
 
	/** 发货日期 */
 
	private java.util.Date deliveryDate;
 
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
 
	/** 需求数量 */
 
	private Long requireQty;
 
	/** 关闭标志 0-默认 1-关闭 */
 
	private java.lang.String orderClose;
 
	/** 预扫描标记 0-默认 1-已扫描 */
 
	private java.lang.String presacnFlag;
 
	/** 审核标记 0-未审 1-审核成功 */
 
	private java.lang.String checkFlag;
 
	/** 累计完成数量 */
 
	private Long finishQty;
 
	/** 审核日期 */
 
	private java.util.Date checkDate;
 
	/** 审核人 */
 
	private java.lang.String checkBy;
 
	/** 完成标志 0-默认 1-完成 */
 
	private java.lang.String finishFlag;
 

    private String begin;
    private String end;
    private String userType;
    private Long userId;
    
    /**
     * getUserType
     * @return String
     */
	public String getUserType() {
		return userType;
	}

	/**
	 * setUserType
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * getUserId
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * setUserId
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * getRowId
	 * @return Long
	 */
	public Long getRowId() {
		return this.rowId;
	}
	
	/**
	 * setRowId
	 * @param value
	 */
	public void setRowId(Long value) {
		this.rowId = value;
	}
	
	/**
	 * getWmsOrderNo
	 * @return String
	 */
	public String getWmsOrderNo() {
		return this.wmsOrderNo;
	}
	
	/**
	 * setWmsOrderNo
	 * @param value
	 */
	public void setWmsOrderNo(String value) {
		this.wmsOrderNo = value;
	}
	
	/**
	 * getWmsOrderItem
	 * @return String
	 */
	public java.lang.String getWmsOrderItem() {
		return this.wmsOrderItem;
	}
	
	/**
	 * setWmsOrderItem
	 * @param value
	 */
	public void setWmsOrderItem(java.lang.String value) {
		this.wmsOrderItem = value;
	}
	
	/**
	 * getOrderType
	 * @return String
	 */
	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	/**
	 * setOrderType
	 * @param value
	 */
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	
	/**
	 * getDocTpye
	 * @return String
	 */
	public java.lang.String getDocTpye() {
		return this.docTpye;
	}
	
	/**
	 * setDocTpye
	 * @param value
	 */
	public void setDocTpye(java.lang.String value) {
		this.docTpye = value;
	}
	
	/**
	 * getPlant
	 * @return String
	 */
	public String getPlant() {
		return this.plant;
	}
	
	/**
	 * setPlant
	 * @param value
	 */
	public void setPlant(String value) {
		this.plant = value;
	}
	
	/**
	 *  getWarehouseCode
	 * @return String
	 */
	public String getWarehouseCode() {
		return this.warehouseCode;
	}
	
	/**
	 * setWarehouseCode
	 * @param value
	 */
	public void setWarehouseCode(String value) {
		this.warehouseCode = value;
	}
	
	/**
	 * getWarehouseName
	 * @return String
	 */
	public String getWarehouseName() {
		return this.warehouseName;
	}
	
	/**
	 * setWarehouseName
	 * @param value
	 */
	public void setWarehouseName(String value) {
		this.warehouseName = value;
	}
	
	/**
	 * getLocation
	 * @return String
	 */
	public String getLocation() {
		if(location!=null){
			location = location.toUpperCase();
		}
		return location;
	}
	
	/**
	 * setLocation
	 * @param value
	 */
	public void setLocation(String value) {
		this.location = value;
	}
	
	/**
	 * getMaterialNo
	 * @return String
	 */
	public String getMaterialNo() {
		if(materialNo!=null){
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}
	
	/**
	 * setMaterialNo
	 * @param value
	 */
	public void setMaterialNo(String value) {
		this.materialNo = value;
	}
	
	/**
	 * getCustomerModel
	 * @return String
	 */
	public String getCustomerModel() {
		return this.customerModel;
	}
	
	/**
	 * setCustomerModel
	 * @param value
	 */
	public void setCustomerModel(String value) {
		this.customerModel = value;
	}
	
	/**
	 * getMaterialDesp
	 * @return String
	 */
	public String getMaterialDesp() {
		return this.materialDesp;
	}
	
	/**
	 * setMaterialDesp
	 * @param value
	 */
	public void setMaterialDesp(String value) {
		this.materialDesp = value;
	}
	
	/**
	 * getUnit
	 * @return String
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * setUnit
	 * @param value
	 */
	public void setUnit(String value) {
		this.unit = value;
	}
	
	/**
	 * getVendorCode
	 * @return String
	 */
	public String getVendorCode() {
		return this.vendorCode;
	}
	
	/**
	 * setVendorCode
	 * @param value
	 */
	public void setVendorCode(String value) {
		this.vendorCode = value;
	}
	
	/**
	 * getVendorName
	 * @return String
	 */
	public String getVendorName() {
		return this.vendorName;
	}
	
	/**
	 * setVendorName
	 * @param value
	 */
	public void setVendorName(String value) {
		this.vendorName = value;
	}
	
	/**
	 * getDeliveryCode
	 * @return String
	 */
	public String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	/**
	 * setDeliveryCode
	 * @param value
	 */
	public void setDeliveryCode(String value) {
		this.deliveryCode = value;
	}
	
	/**
	 * getDeliveryName
	 * @return String
	 */
	public String getDeliveryName() {
		return this.deliveryName;
	}
	
	/**
	 * setDeliveryName
	 * @param value
	 */
	public void setDeliveryName(String value) {
		this.deliveryName = value;
	}
	
	/**
	 * getDeliveryDate
	 * @return Date
	 */
	public java.util.Date getDeliveryDate() {
		if (deliveryDate == null){
			return null;
		} else {
			return (Date) this.deliveryDate.clone();
		}
	}
	
	/**
	 * setDeliveryDate
	 * @param value
	 */
	public void setDeliveryDate(java.util.Date value) {
		if (value == null){
			this.deliveryDate = null;
		} else {
			this.deliveryDate = (Date) value.clone();
		}
	}
	
	/**
	 * getCreateBy
	 * @return String
	 */
	public String getCreateBy() {
		return this.createBy;
	}
	
	/**
	 * setCreateBy
	 * @param value
	 */
	public void setCreateBy(String value) {
		this.createBy = value;
	}
	
	/**
	 * getModifyBy
	 * @return String
	 */
	public String getModifyBy() {
		return this.modifyBy;
	}
	
	/**
	 * setModifyBy
	 * @param value
	 */
	public void setModifyBy(String value) {
		this.modifyBy = value;
	}

	/**
	 * getFlag
	 * @return String
	 */
	public java.lang.String getFlag() {
		return this.flag;
	}
	
	/**
	 * setFlag
	 * @param value
	 */
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	/**
	 * getVersion
	 * @return Long
	 */
	public Long getVersion() {
		return this.version;
	}
	
	/**
	 * setVersion
	 * @param value
	 */
	public void setVersion(Long value) {
		this.version = value;
	}
	
	/**
	 * getRequireQty
	 * @return Long
	 */
	public Long getRequireQty() {
		return this.requireQty;
	}
	
	/**
	 * setRequireQty
	 * @param value
	 */
	public void setRequireQty(Long value) {
		this.requireQty = value;
	}
	
	/**
	 * getOrderClose
	 * @return String
	 */
	public java.lang.String getOrderClose() {
		return this.orderClose;
	}
	
	/**
	 * setOrderClose
	 * @param value
	 */
	public void setOrderClose(java.lang.String value) {
		this.orderClose = value;
	}
	
	/**
	 * getPresacnFlag
	 * @return String
	 */ 
	public java.lang.String getPresacnFlag() {
		return this.presacnFlag;
	}
	
	/**
	 * setPresacnFlag
	 * @param value
	 */
	public void setPresacnFlag(java.lang.String value) {
		this.presacnFlag = value;
	}
	
	/**
	 * getCheckFlag
	 * @return String
	 */
	public java.lang.String getCheckFlag() {
		return this.checkFlag;
	}
	
	/**
	 * setCheckFlag
	 * @param value
	 */
	public void setCheckFlag(java.lang.String value) {
		this.checkFlag = value;
	}
	
	/**
	 * getFinishQty
	 * @return Long
	 */
	public Long getFinishQty() {
		return this.finishQty;
	}
	
	/**
	 * setFinishQty
	 * @param value
	 */
	public void setFinishQty(Long value) {
		this.finishQty = value;
	}
	
	/**
	 * getCheckDate
	 * @return Date
	 */
	public java.util.Date getCheckDate() {
		if (checkDate == null){
			return null;
		} else {
			return (Date) this.checkDate.clone();
		}
	}
	
	/**
	 * setCheckDate
	 * @param value
	 */
	public void setCheckDate(java.util.Date value) {
		if (value == null){
			this.checkDate = null;
		} else {
			this.checkDate = (Date) value.clone();
		}
	}
	
	/**
	 * getCheckBy
	 * @return String
	 */
	public java.lang.String getCheckBy() {
		return this.checkBy;
	}
	
	/**
	 * setCheckBy
	 * @param value
	 */
	public void setCheckBy(java.lang.String value) {
		this.checkBy = value;
	}
	
	/**
	 * getFinishFlag
	 * @return String
	 */
	public java.lang.String getFinishFlag() {
		return this.finishFlag;
	}
	
	/**
	 * setFinishFlag
	 * @param value
	 */
	public void setFinishFlag(java.lang.String value) {
		this.finishFlag = value;
	}

	/**
	 * getBegin
	 * @return String
	 */
	public String getBegin() {
		return begin;
	}

	/**
	 * setBegin
	 * @param begin
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * getEnd
	 * @return String
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * setEnd
	 * @param end
	 */
	public void setEnd(String end) {
		this.end = end;
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

