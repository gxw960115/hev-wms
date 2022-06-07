package com.haier.openplatform.wms.so.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsSoGrInfoDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -973299463196209018L;

	private Long rowId;

    private String orderNo;

    private String orderItem;

    private String orderType;

    private String sapOrderNo;

    private String sapOrderItem;

    private String batchNo;

    private String plant;

    private String warehouseCode;

    private String warehouseName;

    private String location;

    private String materialNo;

    private String customerModel;

    private String materialDesp;

    private Long scannedQty;

    private Long qty;

    private String unit;

    private String vendorCode;

    private String vendorName;

    private String deliveryCode;

    private String deliveryName;

    private Date deliveryDate;

    private String carNo;

    private String handFlag;

    private String createBy;

    private Date createDate;

    private String modifyBy;

    private Date modifyDate;

    private String flag;

    private Long version;

    private String sapFlag;

    private String sapMsg;

    private String sapDocNo;

    private Long sapSendId;

    private String postingDate;

    private String inOutFlag;

    private String inOutMsg;

    private Long requireQty;

    private String orderClose;

    private Long carId;

    private String presacnFlag;

    private String checkFlag;

    private String carFlag;

    private String handPostFlag;

    private String vechileType;

    private String invoiceNo;

    private String lrNo;

    private String lrDate;

    private String transporterCode;

    private String sapDocYear;

    private String dnNo;

    private String dnItemNo;

    private String begin;
    
    private String end;

    private String grQty;

    private String giQty;

    private String stodnNo;

    private String stoItem;

    private String stoNo;

    private String stodnItem;

    private String grPlant;

    private String grLocation;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSapOrderNo() {
        return sapOrderNo;
    }

    public void setSapOrderNo(String sapOrderNo) {
        this.sapOrderNo = sapOrderNo;
    }

    public String getSapOrderItem() {
        return sapOrderItem;
    }

    public void setSapOrderItem(String sapOrderItem) {
        this.sapOrderItem = sapOrderItem;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(String customerModel) {
        this.customerModel = customerModel;
    }

    public String getMaterialDesp() {
        return materialDesp;
    }

    public void setMaterialDesp(String materialDesp) {
        this.materialDesp = materialDesp;
    }

    public Long getScannedQty() {
        return scannedQty;
    }

    public void setScannedQty(Long scannedQty) {
        this.scannedQty = scannedQty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getHandFlag() {
        return handFlag;
    }

    public void setHandFlag(String handFlag) {
        this.handFlag = handFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Long getSapSendId() {
        return sapSendId;
    }

    public void setSapSendId(Long sapSendId) {
        this.sapSendId = sapSendId;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getInOutFlag() {
        return inOutFlag;
    }

    public void setInOutFlag(String inOutFlag) {
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

    public String getOrderClose() {
        return orderClose;
    }

    public void setOrderClose(String orderClose) {
        this.orderClose = orderClose;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPresacnFlag() {
        return presacnFlag;
    }

    public void setPresacnFlag(String presacnFlag) {
        this.presacnFlag = presacnFlag;
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

    public String getVechileType() {
        return vechileType;
    }

    public void setVechileType(String vechileType) {
        this.vechileType = vechileType;
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

    public String getLrDate() {
        return lrDate;
    }

    public void setLrDate(String lrDate) {
        this.lrDate = lrDate;
    }

    public String getTransporterCode() {
        return transporterCode;
    }

    public void setTransporterCode(String transporterCode) {
        this.transporterCode = transporterCode;
    }

    public String getSapDocYear() {
        return sapDocYear;
    }

    public void setSapDocYear(String sapDocYear) {
        this.sapDocYear = sapDocYear == null ? null : sapDocYear.trim();
    }

    public String getDnNo() {
        return dnNo;
    }

    public void setDnNo(String dnNo) {
        this.dnNo = dnNo;
    }

    public String getDnItemNo() {
        return dnItemNo;
    }

    public void setDnItemNo(String dnItemNo) {
        this.dnItemNo = dnItemNo;
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

    public String getGrQty() {
        return grQty;
    }

    public void setGrQty(String grQty) {
        this.grQty = grQty;
    }

    public String getGiQty() {
        return giQty;
    }

    public void setGiQty(String giQty) {
        this.giQty = giQty;
    }

    public String getStodnNo() {
        return stodnNo;
    }

    public void setStodnNo(String stodnNo) {
        this.stodnNo = stodnNo;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getStoItem() {
        return stoItem;
    }

    public void setStoItem(String stoItem) {
        this.stoItem = stoItem;
    }

    public String getStoNo() {
        return stoNo;
    }

    public void setStoNo(String stoNo) {
        this.stoNo = stoNo;
    }

    public String getStodnItem() {
        return stodnItem;
    }

    public void setStodnItem(String stodnItem) {
        this.stodnItem = stodnItem;
    }

    public String getGrPlant() {
        return grPlant;
    }

    public void setGrPlant(String grPlant) {
        this.grPlant = grPlant;
    }

    public String getGrLocation() {
        return grLocation;
    }

    public void setGrLocation(String grLocation) {
        this.grLocation = grLocation;
    }
}