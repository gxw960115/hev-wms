package com.haier.hevwms.order.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsOrderInfoDtl extends BaseDomain<Long> {
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 2288559840706258346L;

	/** 主键 */
 
	private Long rowId;
 
	/** 出入库类型 1-入库 2-出库 */
 
	private java.lang.String orderType;
 
	/** 凭证类型 STO/PO/INB/DN/GIFT/SCRAP/TAKE */
 
	private java.lang.String docType;
 
	/** SAP凭证单号 */
 
	private String sapOrderNo;
 
	/** SAP行项目 */
 
	private java.lang.String sapOrderItem;
 
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
	

	public java.lang.String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	

	public java.lang.String getDocType() {
		return this.docType;
	}
	
	public void setDocType(java.lang.String value) {
		this.docType = value;
	}
	

	public String getSapOrderNo() {
		return this.sapOrderNo;
	}
	
	public void setSapOrderNo(String value) {
		this.sapOrderNo = value;
	}
	

	public java.lang.String getSapOrderItem() {
		return this.sapOrderItem;
	}
	
	public void setSapOrderItem(java.lang.String value) {
		this.sapOrderItem = value;
	}
	

	public java.lang.String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(java.lang.String value) {
		this.batchNo = value;
	}
	

	public String getPlant() {
		return this.plant;
	}
	
	public void setPlant(String value) {
		this.plant = value;
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
			materialNo =materialNo.toUpperCase();
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
	

	public java.lang.String getBarcode() {
		return this.barcode;
	}
	
	public void setBarcode(java.lang.String value) {
		this.barcode = value;
	}
	

	public String getVendorCode() {
		return this.vendorCode;
	}
	
	public void setVendorCode(String value) {
		this.vendorCode = value;
	}
	

	public String getVendorName() {
		return this.vendorName;
	}
	
	public void setVendorName(String value) {
		this.vendorName = value;
	}
	

	public String getDeliveryCode() {
		return this.deliveryCode;
	}
	
	public void setDeliveryCode(String value) {
		this.deliveryCode = value;
	}
	

	public String getDeliveryName() {
		return this.deliveryName;
	}
	
	public void setDeliveryName(String value) {
		this.deliveryName = value;
	}
	

	public String getScannedBy() {
		return this.scannedBy;
	}
	
	public void setScannedBy(String value) {
		this.scannedBy = value;
	}
	

	public java.util.Date getScannedDate() {
		if (this.scannedDate == null){
			return null;
		} else {
			return (Date) this.scannedDate.clone();
		}
	}
	
	public void setScannedDate(java.util.Date value) {
		if (value == null){
			this.scannedDate = null;
		} else {
			this.scannedDate = (Date) value.clone();
		}
	}
	
	public java.util.Date getDeliveryDate() {
		if (this.deliveryDate == null){
			return null;
		} else {
			return (Date) this.deliveryDate.clone();
		}
	}
	
	public void setDeliveryDate(java.util.Date value) {
		if (value == null){
			this.deliveryDate = null;
		} else {
			this.deliveryDate = (Date) value.clone();
		}
	}
	
	public Long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(Long value) {
		this.orderId = value;
	}
	

	public String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(String value) {
		this.orderNo = value;
	}
	

	public String getCarNo() {
		return this.carNo;
	}
	
	public void setCarNo(String value) {
		this.carNo = value;
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
	

	public Long getQty() {
		return this.qty;
	}
	
	public void setQty(Long value) {
		this.qty = value;
	}
	

	public java.lang.String getOrderItem() {
		return this.orderItem;
	}
	
	public void setOrderItem(java.lang.String value) {
		this.orderItem = value;
	}
	

	public java.lang.String getSerialNo() {
		return this.serialNo;
	}
	
	public void setSerialNo(java.lang.String value) {
		this.serialNo = value;
	}
	

	public java.lang.String getFinishFlag() {
		return this.finishFlag;
	}
	
	public void setFinishFlag(java.lang.String value) {
		this.finishFlag = value;
	}
	

	public java.lang.String getInOutFlag() {
		return this.inOutFlag;
	}
	
	public void setInOutFlag(java.lang.String value) {
		this.inOutFlag = value;
	}
	

	public String getInOutMsg() {
		return this.inOutMsg;
	}
	
	public void setInOutMsg(String value) {
		this.inOutMsg = value;
	}

	public String getUsedFlag() {
		return usedFlag;
	}

	public void setUsedFlag(String usedFlag) {
		this.usedFlag = usedFlag;
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
}

