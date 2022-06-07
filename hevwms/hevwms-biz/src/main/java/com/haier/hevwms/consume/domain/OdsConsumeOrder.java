package com.haier.hevwms.consume.domain;

import java.io.Serializable;
import java.util.Date;

public class OdsConsumeOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7076783893712072768L;

	private Long rowId;

    private String consumeNo;

    private String consumeItemNo;

    private String orderType;

    private String plant;

    private String warehouseCode;

    private String warehouseName;

    private String location;

    private String materialNo;

    private String customerModel;

    private String materialDesp;

    private String unit;

    private String vendorCode;

    private String vendorName;

    private String deliveryCode;

    private String deliveryName;

    private Date deliveryDate;

    private String createBy;

    private Date createDate;

    private String modifyBy;

    private Date modifyDate;

    private String flag;

    private Long version;

    private Long requireQty;

    private String orderClose;

    private String presacnFlag;

    private String checkFlag;

    private Long finishQty;

    private Date checkDate;

    private String checkBy;

    private String finishFlag;
    
    private String postingDate;
    
    private String costCenter;
    
    private String glAccount;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getConsumeNo() {
        return consumeNo;
    }

    public void setConsumeNo(String consumeNo) {
        this.consumeNo = consumeNo;
    }

    public String getConsumeItemNo() {
        return consumeItemNo;
    }

    public void setConsumeItemNo(String consumeItemNo) {
        this.consumeItemNo = consumeItemNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
    	if (this.deliveryDate == null) {
			return null;
		}else {
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

    public Long getFinishQty() {
        return finishQty;
    }

    public void setFinishQty(Long finishQty) {
        this.finishQty = finishQty;
    }

    public Date getCheckDate() {
    	if (this.checkDate == null) {
			return null;
		} else {
			return (Date) this.checkDate.clone();
		}
    }

    public void setCheckDate(Date checkDate) {
    	if (checkDate == null) {
			this.checkDate = null;
		} else {
			this.checkDate = (Date) checkDate.clone();
		}
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
    }

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getGlAccount() {
		return glAccount;
	}

	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}
    
    
}