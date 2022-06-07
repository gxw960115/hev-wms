package com.haier.openplatform.wms.po.dto;

import java.io.Serializable;
import java.util.Date;
// @DeleteFlag
public class OdsOrderInfoDtlDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7169842749453268622L;

	/** 主键 */
	 
	private Long rowId;
 
	/** 出入库类型 1-入库 2-出库 */
 
	private java.lang.String orderType;
 
	/** SAP凭证单号 */
 
	private String poNo;
 
	/** SAP行项目 */
 
	private java.lang.String poItemNo;
 
	/** 货架分区 */
	
	private String bin;
	
	/** 批次号 */
 
	private java.lang.String batchNo;
 
	/** 工厂 */
 
	private String plant;
 
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
 
	/** 条码 */
 
	private java.lang.String barcode;
 
	/** 供应商编号 */
 
	private String vendorCode;
 
	/** 供应商名称 */
 
	private String vendorName;
 
	/** 送达方编号 */
 
	private String deliveryCode;
 
	/** 送达方名称 */
 
	private String deliveryName;
 
	/** 扫描人 */
 
	private String scannedBy;
 
	/** 扫描日期 */
 
	private java.util.Date scannedDate;
 
	/** 发货日期 */
 
	private java.util.Date deliveryDate;
 
	/** 出入库单据id */
 
	private Long orderId;
 
	/** 出入库单据号 */
 
	private String orderNo;
 
	/** 车号 */
 
	private String carNo;
 
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
 
	/** 数量 */
 
	private Long qty;
 
	/** 行项目 */
 
	private java.lang.String orderItem;
 
	/** 流水号 */
 
	private java.lang.String serialNo;
 
	/** 汇总完成标志 0-默认 1-完成 */
 
	private java.lang.String finishFlag;
 
	/** 出入库成功标志 0-默认 1-成功 2-失败 */
 
	private java.lang.String inOutFlag;
 
	/** 出入库信息 */
 
	private String inOutMsg;
 
    private String usedFlag;
    private String begin;
    private String end;
    private String userType;
    private Long userId;
    /**
     * getRowId
     * @return Long
     */
	public Long getRowId() {
		return rowId;
	}
	/**
	 * setRowId
	 * @param rowId
	 */
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	/**
	 * getOrderType
	 * @return String
	 */
	public java.lang.String getOrderType() {
		return orderType;
	}
	/**
	 * setOrderType
	 * @param orderType
	 */
	public void setOrderType(java.lang.String orderType) {
		this.orderType = orderType;
	}
	/**
	 * getBatchNo
	 * @return String
	 */
	public java.lang.String getBatchNo() {
		return batchNo;
	}
	/**
	 * setBatchNo
	 * @param batchNo
	 */
	public void setBatchNo(java.lang.String batchNo) {
		this.batchNo = batchNo;
	}
	/**
	 * getPlant
	 * @return String
	 */
	public String getPlant() {
		return plant;
	}
	/**
	 * setPlant
	 * @param plant
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}
	/**
	 * getCustomerModel
	 * @return String
	 */
	public String getCustomerModel() {
		return customerModel;
	}
	/**
	 * setCustomerModel
	 * @param customerModel
	 */
	public void setCustomerModel(String customerModel) {
		this.customerModel = customerModel;
	}
	/**
	 * getLocation
	 * @return String
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * setLocation
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * getMaterialNo
	 * @return String
	 */
	public String getMaterialNo() {
		return materialNo;
	}
	/**
	 * setMaterialNo
	 * @param materialNo
	 */
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}/**
	 * getMaterialDesp
	 * @return String
	 */
	public String getMaterialDesp() {
		return materialDesp;
	}
	/**
	 * setMaterialDesp
	 * @param materialDesp
	 */
	public void setMaterialDesp(String materialDesp) {
		this.materialDesp = materialDesp;
	}
	/**
	 * getUnit
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * setUnit
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * getBarcode
	 * @return String
	 */
	public java.lang.String getBarcode() {
		return barcode;
	}
	/**
	 * setBarcode
	 * @param barcode
	 */
	public void setBarcode(java.lang.String barcode) {
		this.barcode = barcode;
	}
	/**
	 * getVendorCode
	 * @return String
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * setBarcode
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	/**
	 * getVendorName
	 * @return String
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * setVendorName
	 * @param vendorName
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * getDeliveryCode
	 * @return String
	 */
	public String getDeliveryCode() {
		return deliveryCode;
	}
	/**
	 * setDeliveryCode
	 * @param deliveryCode
	 */
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	/**
	 * getDeliveryName
	 * @return String
	 */
	public String getDeliveryName() {
		return deliveryName;
	}
	/**
	 * setDeliveryName
	 * @param deliveryName
	 */
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	/**
	 * getScannedBy
	 * @return String
	 */
	public String getScannedBy() {
		return scannedBy;
	}
	
	/**
	 * setScannedBy
	 * @param scannedBy
	 */
	public void setScannedBy(String scannedBy) {
		this.scannedBy = scannedBy;
	}
	/**
	 * getScannedDate
	 * @return String
	 */
	public java.util.Date getScannedDate() {
		if (scannedDate == null){
			return null;
		} else {
			return (Date) scannedDate.clone();
		}
	}
	
	/**
	 * setScannedDate
	 * @param scannedDate
	 */
	public void setScannedDate(java.util.Date scannedDate) {
		if (scannedDate == null){
			this.scannedDate = null;
		} else {
			this.scannedDate = (Date) scannedDate.clone();
		}
	}
	/**
	 * getDeliveryDate
	 * @return String
	 */
	public java.util.Date getDeliveryDate() {
		if (deliveryDate == null){
			return null;
		} else {
			return (Date) deliveryDate.clone();
		}
	}
	/**
	 * setDeliveryDate
	 * @param deliveryDate
	 */
	public void setDeliveryDate(java.util.Date deliveryDate) {
		if (deliveryDate == null){
			this.deliveryDate = null;
		} else {
			this.deliveryDate = (Date) deliveryDate.clone();
		}
	}
	/**
	 * getOrderId
	 * @return String
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * setOrderId
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * getOrderNo
	 * @return String
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * setOrderNo
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * getCarNo
	 * @return String
	 */
	public String getCarNo() {
		return carNo;
	}
	/**
	 * setCarNo
	 * @param carNo
	 */
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	/**
	 * getCreateBy
	 * @return String
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * setCreateBy
	 * @param createBy
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * getModifyBy
	 * @return String
	 */
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * setModifyBy
	 * @param modifyBy
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * getFlag
	 * @return String
	 */
	public java.lang.String getFlag() {
		return flag;
	}
	/**
	 * setFlag
	 * @param flag
	 */
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	/**
	 * getVersion
	 * @return String
	 */
	public Long getVersion() {
		return version;
	}
	/**
	 * setVersion
	 * @param version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	/**
	 * getQty
	 * @return String
	 */
	public Long getQty() {
		return qty;
	}
	/**
	 * setQty
	 * @param qty
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}
	/**
	 * getOrderItem
	 * @return String
	 */
	public java.lang.String getOrderItem() {
		return orderItem;
	}
	/**
	 * setOrderItem
	 * @param orderItem
	 */
	public void setOrderItem(java.lang.String orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * getSerialNo
	 * @return String
	 */
	public java.lang.String getSerialNo() {
		return serialNo;
	}
	/**
	 * setSerialNo
	 * @param serialNo
	 */
	public void setSerialNo(java.lang.String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * getFinishFlag
	 * @return String
	 */
	public java.lang.String getFinishFlag() {
		return finishFlag;
	}
	/**
	 * setFinishFlag
	 * @param finishFlag
	 */
	public void setFinishFlag(java.lang.String finishFlag) {
		this.finishFlag = finishFlag;
	}
	/**
	 * getInOutFlag
	 * @return String
	 */
	public java.lang.String getInOutFlag() {
		return inOutFlag;
	}
	/**
	 * setInOutFlag
	 * @param inOutFlag
	 */
	public void setInOutFlag(java.lang.String inOutFlag) {
		this.inOutFlag = inOutFlag;
	}
	/**
	 * getInOutMsg
	 * @return String
	 */
	public String getInOutMsg() {
		return inOutMsg;
	}
	/**
	 * setInOutMsg
	 * @param inOutMsg
	 */
	public void setInOutMsg(String inOutMsg) {
		this.inOutMsg = inOutMsg;
	}
	/**
	 * getUsedFlag
	 * @return String
	 */
	public String getUsedFlag() {
		return usedFlag;
	}
	/**
	 * setUsedFlag
	 * @param usedFlag
	 */
	public void setUsedFlag(String usedFlag) {
		this.usedFlag = usedFlag;
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
	 * @return String
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
	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}
	/**
	 * @param poNo the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	/**
	 * @return the poItemNo
	 */
	public java.lang.String getPoItemNo() {
		return poItemNo;
	}
	/**
	 * @param poItemNo the poItemNo to set
	 */
	public void setPoItemNo(java.lang.String poItemNo) {
		this.poItemNo = poItemNo;
	}
	/**
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}
	/**
	 * @param bin the bin to set
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}
    
}
