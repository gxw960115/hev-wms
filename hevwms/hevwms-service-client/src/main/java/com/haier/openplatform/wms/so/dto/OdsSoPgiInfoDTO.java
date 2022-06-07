package com.haier.openplatform.wms.so.dto;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsSoPgiInfoDTO extends BaseDomain<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -343677554117516473L;

	/** 主键 */

	private Long rowId;

	/** 出入库单据号 */

	private String orderNo;

	/** 行项目 */

	private java.lang.String orderItem;

	/** 出入库类型 1-入库 2-出库 */

	private java.lang.String orderType;

	/** 凭证类型 STO/PO/INB/DN/GIFT/SCRAP/TAKE */

	private java.lang.String docTpye;

	/** SAP凭证单号 */

	private String sapOrderNo;

	/** SAP行项目 */

	private java.lang.String sapOrderItem;

	/** 批次号 */

	private java.lang.String batchNo;

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

	/** 订单数量 */

	private Long orderQty;

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

	private java.lang.String handFlag;

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

	/** 手持传入过账日期 */ 

	private boolean trueFlag;
	private boolean successFlag = true;
	
	/** sap返回标志 默认0 成功1 失败2 锁定状态3 */
	 
	private java.lang.String sapFlag;
 
	/** sap返回信息 */
 
	private String sapMsg;
 
	/** sap凭证号 */
 
	private java.lang.String sapDocNo;
 
	/** 传入SAP的ID号 */
 
	private Long sapSendId;
 
	/** 手持传入过账日期 */
 
	private java.lang.String postingDate;
 
	/** 出入库成功标志 0-默认 1-成功 2-失败 */
 
	private java.lang.String inOutFlag;
 
	/** 出入库信息 */
 
	private String inOutMsg;
 
	/** 需求数量 */
 
	private Long requireQty;
 
	/** 关闭标志 0-默认 1-关闭 */
 
	private java.lang.String orderClose;
 
	/** 入门登记id */
 
	private Long carId;
 
	/** 预扫描标记 0-默认 1-已扫描 */
 
	private java.lang.String presacnFlag;
	
	private String invoiceNo;
	private String lrNo;
	private String lrDate;
	private String transporterCode;
	private String transporterName;
	
	
	private String sapReturn;
	private String begin;
	private String end;
	
	private String checkFlag;
	
	private String userType;
	private Long userId;
	private String carFlag;
	private String handPostFlag;
	
	private String division;

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
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

	public java.lang.String getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(java.lang.String value) {
		this.orderItem = value;
	}

	public java.lang.String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}

	public java.lang.String getDocTpye() {
		return this.docTpye;
	}

	public void setDocTpye(java.lang.String value) {
		this.docTpye = value;
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
			materialNo = materialNo.toUpperCase();
		}
		return materialNo;
	}

	public void setMaterialNo(String value) {
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

	public Long getOrderQty() {
		return this.orderQty;
	}

	public void setOrderQty(Long value) {
		this.orderQty = value;
	}

	public Long getScannedQty() {
		return this.scannedQty;
	}

	public void setScannedQty(Long value) {
		this.scannedQty = value;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String value) {
		this.unit = value;
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

	public String getCarNo() {
		return this.carNo;
	}

	public void setCarNo(String value) {
		this.carNo = value;
	}

	public java.lang.String getHandFlag() {
		return this.handFlag;
	}

	public void setHandFlag(java.lang.String value) {
		this.handFlag = value;
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

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	 
	public String getSapFlag() {
		return sapFlag;
	}

	public void setSapFlag(String sapFlag) {
		this.sapFlag = sapFlag;
	}

	public String getSapMsg() {
		return sapMsg;
	}

	public void setSapMsg(String sapMsg) {
		this.sapMsg = sapMsg;
	}

	public String getSapDocNo() {
		return sapDocNo;
	}

	public void setSapDocNo(String sapDocNo) {
		this.sapDocNo = sapDocNo;
	}

	public boolean isTrueFlag() {
		return trueFlag;
	}

	public void setTrueFlag(boolean trueFlag) {
		this.trueFlag = trueFlag;
	}

	public boolean isSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}

	public java.lang.String getInOutFlag() {
		return inOutFlag;
	}

	public void setInOutFlag(java.lang.String inOutFlag) {
		this.inOutFlag = inOutFlag;
	}

	public String getInOutMsg() {
		return inOutMsg;
	}

	public void setInOutMsg(String inOutMsg) {
		this.inOutMsg = inOutMsg;
	}

	public Long getRequireQty() {
		return requireQty;
	}

	public void setRequireQty(Long requireQty) {
		this.requireQty = requireQty;
	}

	public java.lang.String getOrderClose() {
		return orderClose;
	}

	public void setOrderClose(java.lang.String orderClose) {
		this.orderClose = orderClose;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public java.lang.String getPresacnFlag() {
		return presacnFlag;
	}

	public void setPresacnFlag(java.lang.String presacnFlag) {
		this.presacnFlag = presacnFlag;
	}

	public void setSapSendId(Long sapSendId) {
		this.sapSendId = sapSendId;
	}

	public Long getSapSendId() {
		return sapSendId;
	}

	public String getSapReturn() {
		return sapReturn;
	}

	public void setSapReturn(String sapReturn) {
		this.sapReturn = sapReturn;
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

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getCarFlag() {
		return carFlag;
	}

	public void setCarFlag(String carFlag) {
		this.carFlag = carFlag;
	}

	public String getHandPostFlag() {
		return handPostFlag;
	}

	public void setHandPostFlag(String handPostFlag) {
		this.handPostFlag = handPostFlag;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getTransporterCode() {
		return transporterCode;
	}

	public void setTransporterCode(String transporterCode) {
		this.transporterCode = transporterCode;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
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
