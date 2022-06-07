package com.haier.hevwms.takestock.domain;

import java.util.Date;

import com.haier.openplatform.domain.BaseDomain;

public class OdsPdInfoDtl extends BaseDomain<Long> {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /** 主键 */

    private Long rowId;

    /** 盘点单号 */

    private String orderNo;

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

    private String barcode;

    /** 创建人 */

    private String createBy;

    /** 创建日期 */

    private java.util.Date createDate = new Date();

    /** 修改人 */

    private String modifyBy;

    /** 修改日期 */

    private java.util.Date modifyDate = new Date();

    /** 有效标记 0-有效 1-失效 */

    private java.lang.String flag;

    /** 版本号 */

    private Long version;

    /** 仓间，库位 */

    private String subLocation;

    /** 数量 */

    private Long qty;
    
    /** 仓位 */
    private String bin;
    
    private String inveBin;
    private String pdBin;
    
    private Long locqty;
    private Long wmsqty;
    private Long sapqty;
    private String inveSub;
    private String inveBarcode;
    private Long inveRowId;
    private Long inveQty;

    private String begin;
    private String end;
    private String plantName;
    private String status;// 删除标记 0-默认 1-删除
    
    /**  */
    private String userType;
    
    /**  */
    private Long userId;
    
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
	if (location != null) {
	    location = location.toUpperCase();
	}
	return location;
    }

    public void setLocation(String value) {
	this.location = value;
    }

    public String getMaterialNo() {
	if (materialNo != null) {
	    materialNo = materialNo.toUpperCase();
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

    public String getBarcode() {
	return this.barcode;
    }

    public void setBarcode(String value) {
	this.barcode = value;
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

    public String getSubLocation() {
	return this.subLocation;
    }

    public void setSubLocation(String value) {
	this.subLocation = value;
    }

    public Long getQty() {
	return this.qty;
    }

    public void setQty(Long value) {
	this.qty = value;
    }

    public Long getLocqty() {
	return locqty;
    }

    public void setLocqty(Long locqty) {
	this.locqty = locqty;
    }

    public Long getWmsqty() {
	return wmsqty;
    }

    public void setWmsqty(Long wmsqty) {
	this.wmsqty = wmsqty;
    }

    public Long getSapqty() {
	return sapqty;
    }

    public void setSapqty(Long sapqty) {
	this.sapqty = sapqty;
    }

    public String getInveSub() {
	return inveSub;
    }

    public void setInveSub(String inveSub) {
	this.inveSub = inveSub;
    }

    public String getInveBarcode() {
	return inveBarcode;
    }

    public void setInveBarcode(String inveBarcode) {
	this.inveBarcode = inveBarcode;
    }

    public Long getInveRowId() {
	return inveRowId;
    }

    public void setInveRowId(Long inveRowId) {
	this.inveRowId = inveRowId;
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

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

	public Long getInveQty() {
		return inveQty;
	}

	public void setInveQty(Long inveQty) {
		this.inveQty = inveQty;
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

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getInveBin() {
		return inveBin;
	}

	public void setInveBin(String inveBin) {
		this.inveBin = inveBin;
	}

	public String getPdBin() {
		return pdBin;
	}

	public void setPdBin(String pdBin) {
		this.pdBin = pdBin;
	}

}
