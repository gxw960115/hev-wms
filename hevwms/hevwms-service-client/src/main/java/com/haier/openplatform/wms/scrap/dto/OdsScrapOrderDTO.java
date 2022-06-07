package com.haier.openplatform.wms.scrap.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsScrapOrderDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5854541284118701464L;

	private Long rowId;

    private String scrapNo;

    private String scrapItemNo;

    private String orderType;

    private String plant;
    
    private String bin;

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

    private String begin;
    
    private String end;

    //过账相关字段
    private String costCenter;
    private String postingDate;
    private String sapFlag;
    private String sapMsg;
    private String matDoc;
    private String docYear;
    private String inOutFlag;
    private String inOutMsg;
    
    public String getMatDoc() {
		return matDoc;
	}

	public void setMatDoc(String matDoc) {
		this.matDoc = matDoc;
	}

	public String getDocYear() {
		return docYear;
	}

	public void setDocYear(String docYear) {
		this.docYear = docYear;
	}

	public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    private Long qty ;
    
    private String basicUnit;
    
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getScrapNo() {
        return scrapNo;
    }

    public void setScrapNo(String scrapNo) {
        this.scrapNo = scrapNo;
    }

    public String getScrapItemNo() {
        return scrapItemNo;
    }

    public void setScrapItemNo(String scrapItemNo) {
        this.scrapItemNo = scrapItemNo;
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

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public String getBasicUnit() {
		return basicUnit;
	}

	public void setBasicUnit(String basicUnit) {
		this.basicUnit = basicUnit;
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
	
}