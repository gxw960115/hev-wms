package com.haier.openplatform.wms.sto.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Package: com.haier.openplatform.wms.sto.dto
 * @Description: 用一句话描述该文件做什么
 * @Author: ZhangLL
 * @Date: 2018/12/18
 * @Version: V1.0
 */
public class OdsStoCustScanInfoDTO implements Serializable {

    private static final long serialVersionUID = -5370145327834212538L;

    private Long rowId;

    private String orderType;

    private String bin;

    private String stoNo;

    private String stoItemNo;

    private String stodnNo;

    private String stodnItemNo;

    private String batchNo;

    private String plant;

    private String customerModel;

    private String location;

    private String materialNo;

    private String materialDesp;

    private String unit;

    private String barcode;

    private String vendorCode;

    private String vendorName;

    private String deliveryCode;

    private String deliveryName;

    private String scannedBy;

    private Date scannedDate;

    private Date deliveryDate;

    private Long orderId;

    private String orderNo;

    private String carNo;

    private String createBy;

    private Date createDate;

    private String modifyBy;

    private Date modifyDate;

    private String flag;

    private Long version;

    private Long qty;

    private String orderItem;

    private String serialNo;

    private String finishFlag;

    private String inOutFlag;

    private String inOutMsg;

    private String usedFlag;

    private String subLocation;

    private String remark;

    private String begin;
    
    private String end;
    
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getStoNo() {
        return stoNo;
    }

    public void setStoNo(String stoNo) {
        this.stoNo = stoNo;
    }

    public String getStoItemNo() {
        return stoItemNo;
    }

    public void setStoItemNo(String stoItemNo) {
        this.stoItemNo = stoItemNo;
    }

    public String getStodnNo() {
		return stodnNo;
	}

	public void setStodnNo(String stodnNo) {
		this.stodnNo = stodnNo;
	}

	public String getStodnItemNo() {
		return stodnItemNo;
	}

	public void setStodnItemNo(String stodnItemNo) {
		this.stodnItemNo = stodnItemNo;
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

    public String getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(String customerModel) {
        this.customerModel = customerModel;
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

    public String getMaterialDesp() {
        return materialDesp;
    }

    public void setMaterialDesp(String materialDesp) {
        this.materialDesp = materialDesp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getScannedBy() {
        return scannedBy;
    }

    public void setScannedBy(String scannedBy) {
        this.scannedBy = scannedBy;
    }

    public Date getScannedDate() {
    	if (this.scannedDate == null) {
			return null;
		} else {
			return (Date) this.scannedDate.clone();
		}
    }

    public void setScannedDate(Date scannedDate) {
    	if (scannedDate == null) {
			this.scannedDate = null;
		} else {
			this.scannedDate = (Date) scannedDate.clone();
		}
    }

    public Date getDeliveryDate() {
    	if (this.deliveryDate == null) {
			return null;
		} else {
			return (Date) this.deliveryDate.clone();
		}
    }

    public void setDeliveryDate(Date deliveryDate) {
    	if (deliveryDate == null) {
			this.deliveryDate = null;
		} else {
			this.deliveryDate = (Date) deliveryDate.clone();
		}
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
    	if (this.createDate == null) {
			return null;
		} else {
			return (Date) this.createDate.clone();
		}
    }

    public void setCreateDate(Date createDate) {
    	if (createDate == null) {
			this.createDate = null;
		} else {
			this.createDate = (Date) createDate.clone();
		}
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
    	if (this.modifyDate == null) {
			return null;
		} else {
			return (Date) this.modifyDate.clone();
		}
    }

    public void setModifyDate(Date modifyDate) {
    	if (modifyDate == null) {
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) modifyDate.clone();
		}
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
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

    public String getUsedFlag() {
        return usedFlag;
    }

    public void setUsedFlag(String usedFlag) {
        this.usedFlag = usedFlag;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}