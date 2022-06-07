package com.haier.openplatform.wms.order.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsOrderInfoDTO implements Serializable {

	/**
    * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 9122182049722608893L;

    /** 主键 */

	private Long rowId;

	/** 出入库单据号 */

	private String orderNo;

	/** 行项目 */

	private String orderItem;

	/** 出入库类型 1-入库 2-出库 */

	private String orderType;

	/** 凭证类型 STO/PO/INB/DN/GIFT/SCRAP/TAKE */

	private String docTpye;

	/** SAP凭证单号 */

	private String sapOrderNo;

	/** SAP行项目 */

	private String sapOrderItem;

	/** 批次号 */

	private String batchNo;

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

	/** 扫描数量 */

	private Long scannedQty;

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

	/** 车号 */

	private String carNo;

	/** 手工标记 0-系统生成 1-手工创建 */

	private String handFlag;

	/** 创建人 */

	private String createBy;

	/** 创建日期 */

	private java.util.Date createDate;

	/** 修改人 */

	private String modifyBy;

	/** 修改日期 */

	private java.util.Date modifyDate;

	/** 有效标记 0-有效 1-失效 */

	private String flag;

	/** 版本号 */

	private Long version;

	/** sap返回标志 默认0 成功1 失败2 锁定状态3 */

	private String sapFlag;

	/** sap返回信息 */

	private String sapMsg;

	/** sap凭证号 */

	private String sapDocNo;

	/** 传入SAP的ID号 */

	private Long sapSendId;

	/** 手持传入过账日期 */

	private String postingDate;

	/** 出入库成功标志 0-默认 1-成功 2-失败 */

	private String inOutFlag;

	/** 出入库信息 */

	private String inOutMsg;

	/** 需求数量 */

	private Long requireQty;

	/** 关闭标志 0-默认 1-关闭 */

	private String orderClose;

	/** 入门登记id */

	private Long carId;

	/** 预扫描标记 0-默认 1-已扫描 */

	private String presacnFlag;

	/** 审核标记 0-未审 1-审核成功 */

	private String checkFlag;

	/** 车号审核标记 0-创建 1-提交 2-审核成功 */

	private String carFlag;

	/** 人工干预过账字段 0-不干预 1-干预 */

	private String handPostFlag;

	//是否成功 S 成功 F 失败    sunyanfei
	private String status;
	//错误原因描述				sunyanfei
	private String msg;	
	//返回单号数据				sunyanfei
	private String orId;		
	private boolean successFlag = true;
	private String invoiceNo;
	private String lrNo;
	private String lrDate;
	private String transporterCode;
	private String transporterName;
	
	private String sapReturn;
	private String begin;
	private String end;
	private String userType;
	private Long userId;
	private String division;

	/**
	 * getSapReturn
	 * @return String
	 */
	public String getSapReturn() {
		return sapReturn;
	}

	/**
	 * setSapReturn
	 * @param sapReturn
	 */
	public void setSapReturn(String sapReturn) {
		this.sapReturn = sapReturn;
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
	 * getDivision
	 * @return String
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * setDivision
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}

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
	 * getOrderItem
	 * @return String
	 */
	public String getOrderItem() {
		return orderItem;
	}

	/**
	 * setOrderItem
	 * @param orderItem
	 */
	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	/**
	 * getOrderType
	 * @return String
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * setOrderType
	 * @param orderType
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * getDocTpye
	 * @return String
	 */
	public String getDocTpye() {
		return docTpye;
	}

	/**
	 * setDocTpye
	 * @param docTpye
	 */
	public void setDocTpye(String docTpye) {
		this.docTpye = docTpye;
	}

	/**
	 * getSapOrderNo
	 * @return String
	 */
	public String getSapOrderNo() {
		return sapOrderNo;
	}

	/**
	 * setSapOrderNo
	 * @param sapOrderNo
	 */
	public void setSapOrderNo(String sapOrderNo) {
		this.sapOrderNo = sapOrderNo;
	}

	/**
	 * getSapOrderItem
	 * @return String
	 */
	public String getSapOrderItem() {
		return sapOrderItem;
	}

	/**
	 * setSapOrderItem
	 * @param sapOrderItem
	 */
	public void setSapOrderItem(String sapOrderItem) {
		this.sapOrderItem = sapOrderItem;
	}

	/**
	 * getBatchNo
	 * @return String
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * setBatchNo
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
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
	 * getWarehouseCode
	 * @return String
	 */
	public String getWarehouseCode() {
		return warehouseCode;
	}

	/**
	 * setWarehouseCode
	 * @param warehouseCode
	 */
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * getWarehouseName
	 * @return String
	 */ 
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * setWarehouseName
	 * @param warehouseName
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
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
	 * getScannedQty
	 * @return Long
	 */
	public Long getScannedQty() {
		return scannedQty;
	}

	/**
	 * setScannedQty
	 * @param scannedQty
	 */
	public void setScannedQty(Long scannedQty) {
		this.scannedQty = scannedQty;
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
	 * getVendorCode
	 * @return String
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * setVendorCode
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
	 * getDeliveryDate
	 * @return Date
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
	 * getHandFlag
	 * @return String
	 */
	public String getHandFlag() {
		return handFlag;
	}

	/**
	 * setHandFlag
	 * @param handFlag
	 */
	public void setHandFlag(String handFlag) {
		this.handFlag = handFlag;
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
	public String getFlag() {
		return flag;
	}

	/**
	 * setFlag
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * getVersion
	 * @return Long
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
	 * getSapFlag
	 * @return String
	 */
	public String getSapFlag() {
		return sapFlag;
	}

	/**
	 * setSapFlag
	 * @param sapFlag
	 */
	public void setSapFlag(String sapFlag) {
		this.sapFlag = sapFlag;
	}

	/**
	 * getSapMsg
	 * @return String
	 */
	public String getSapMsg() {
		return sapMsg;
	}

	/**
	 * setSapMsg
	 * @param sapMsg
	 */
	public void setSapMsg(String sapMsg) {
		this.sapMsg = sapMsg;
	}

	/**
	 * getSapDocNo
	 * @return String
	 */
	public String getSapDocNo() {
		return sapDocNo;
	}

	/**
	 * setSapDocNo
	 * @param sapDocNo
	 */
	public void setSapDocNo(String sapDocNo) {
		this.sapDocNo = sapDocNo;
	}

	/**
	 * getSapSendId
	 * @return Long
	 */
	public Long getSapSendId() {
		return sapSendId;
	}

	/**
	 * setSapSendId
	 * @param sapSendId
	 */
	public void setSapSendId(Long sapSendId) {
		this.sapSendId = sapSendId;
	}

	/**
	 * getPostingDate
	 * @return String
	 */
	public String getPostingDate() {
		return postingDate;
	}

	/**
	 * setPostingDate
	 * @param postingDate
	 */
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * getInOutFlag
	 * @return String
	 */
	public String getInOutFlag() {
		return inOutFlag;
	}

	/**
	 * setInOutFlag
	 * @param inOutFlag
	 */
	public void setInOutFlag(String inOutFlag) {
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
	 * getRequireQty
	 * @return Long
	 */ 
	public Long getRequireQty() {
		return requireQty;
	}

	/**
	 * setRequireQty
	 * @param requireQty
	 */
	public void setRequireQty(Long requireQty) {
		this.requireQty = requireQty;
	}

	/**
	 * getOrderClose
	 * @return String
	 */ 
	public String getOrderClose() {
		return orderClose;
	}

	/**
	 * setOrderClose
	 * @param orderClose
	 */
	public void setOrderClose(String orderClose) {
		this.orderClose = orderClose;
	}

	/**
	 * getCarId
	 * @return Long
	 */
	public Long getCarId() {
		return carId;
	}

	/**
	 * setCarId
	 * @param carId
	 */
	public void setCarId(Long carId) {
		this.carId = carId;
	}

	/**
	 * getPresacnFlag
	 * @return String
	 */
	public String getPresacnFlag() {
		return presacnFlag;
	}

	/**
	 * setPresacnFlag
	 * @param presacnFlag
	 */
	public void setPresacnFlag(String presacnFlag) {
		this.presacnFlag = presacnFlag;
	}

	/**
	 * getCheckFlag
	 * @return String
	 */
	public String getCheckFlag() {
		return checkFlag;
	}

	/**
	 * setCheckFlag
	 * @param checkFlag
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	/**
	 * getCarFlag
	 * @return String
	 */
	public String getCarFlag() {
		return carFlag;
	}

	/**
	 * setCarFlag
	 * @param carFlag
	 */
	public void setCarFlag(String carFlag) {
		this.carFlag = carFlag;
	}

	/**
	 * getHandPostFlag
	 * @return String
	 */
	public String getHandPostFlag() {
		return handPostFlag;
	}

	/**
	 * setHandPostFlag
	 * @param handPostFlag
	 */
	public void setHandPostFlag(String handPostFlag) {
		this.handPostFlag = handPostFlag;
	}

	/**
	 * getStatus
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * setStatus
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * getMsg
	 * @return String
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * setMsg
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * getOrId
	 * @return String
	 */
	public String getOrId() {
		return orId;
	}

	/**
	 * setOrId
	 * @param orId
	 */
	public void setOrId(String orId) {
		this.orId = orId;
	}

	/**
	 * isSuccessFlag
	 * @return boolean
	 */
	public boolean isSuccessFlag() {
		return successFlag;
	}

	/**
	 * setSuccessFlag
	 * @param successFlag
	 */
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}

	/**
	 *  getInvoiceNo
	 * @return String
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * setInvoiceNo
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * getLrNo
	 * @return String
	 */
	public String getLrNo() {
		return lrNo;
	}

	/**
	 * setLrNo
	 * @param lrNo
	 */
	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	/**
	 * getTransporterCode
	 * @return String
	 */
	public String getTransporterCode() {
		return transporterCode;
	}

	/**
	 * setTransporterCode
	 * @param transporterCode
	 */
	public void setTransporterCode(String transporterCode) {
		this.transporterCode = transporterCode;
	}

	/**
	 * getTransporterName
	 * @return String
	 */
	public String getTransporterName() {
		return transporterName;
	}

	/**
	 * setTransporterName
	 * @param transporterName
	 */
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	/**
	 * getLrDate
	 * @return String
	 */
	public String getLrDate() {
		return lrDate;
	}

	/**
	 * setLrDate
	 * @param lrDate
	 */
	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
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
