package com.haier.openplatform.wms.basicdata.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunhaoyu
 * 
 */
public class MdMatInfoDTO implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = -8511545876401374805L;

    /** ID */

    public Long rowId;

    /** 物料号 */

    public String materialNo;

    /** 客户型号 */

    public String customerModel;

    /** 物料描述 */

    public String materialDesp;

    /** 工厂code */

    public String plant;
    
    /** 工厂name */
    public String name;

    /** 颜色 */

    public String externalMatGroup;

    /** 毛重 */

    public String grossWeight;

    /** 净重 */

    public String netWeight;

    /** 尺寸 */

    public String sizeDimension;

    /** 单位 */

    public String basicUnit;

    /** 状态 */

    public String plantStatus;

    /** 大类 */

    public String division;
    
    /** 大类 */

    public String divisionName;

    /** 长 */

    public Double length;

    /** 宽 */

    public Double width;

    /** 高 */
    public Double higth;

    /** 区分空调内外机，空为内机，X为外机 */

    public String  produceAttribute;

    /** 修改日期 */ 

    public Date  modifyDate;

    /** 修改次数 */

    public Long version;

    /** 有效状态 */

    public String activestate;

    /** 创建人 */

    public String createdBy;

    /** 创建日期 */

    public Date createdDate;

    /** 修改人 */

    public String modifyBy;

    /** 备注 */

    public String remark;

    /** inOut */

    public String inOut;
    public String produceModel;
   
    /** 类型 */

    public String matScanType;
    
    
    /** 上下市状态*/
    public String marketStatus;
    
    /** 包装箱专用号*/
    public String packageNo;
    public Long cbm;
    public String location;
    public String orderUnit;
    public Long orderBasicFactor;
    public Long orderFactor;
    public String issueUnit;
    public Long issueBasicFactor;
    public Long issueFactor;
    public String matType;
    public String mrpCode;
    public String purchaseGroup;
    public String oldMat;
    public Double volume;
    public String volumeUnit;
    public String measureUnit;
    

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
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

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getExternalMatGroup() {
        return externalMatGroup;
    }

    public void setExternalMatGroup(String externalMatGroup) {
        this.externalMatGroup = externalMatGroup;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getSizeDimension() {
        return sizeDimension;
    }

    public void setSizeDimension(String sizeDimension) {
        this.sizeDimension = sizeDimension;
    }

    public String getBasicUnit() {
        return basicUnit;
    }

    public void setBasicUnit(String basicUnit) {
        this.basicUnit = basicUnit;
    }

    public String getPlantStatus() {
        return plantStatus;
    }

    public void setPlantStatus(String plantStatus) {
        this.plantStatus = plantStatus;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @Description: 属性 divisionName 的get方法
     * @return divisionName
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * @Description: 属性 divisionName 的set方法
     * divisionName
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHigth() {
        return higth;
    }

    public void setHigth(Double higth) {
        this.higth = higth;
    }

    public String getProduceAttribute() {
        return produceAttribute;
    }

    public void setProduceAttribute(String produceAttribute) {
        this.produceAttribute = produceAttribute;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getActivestate() {
        return activestate;
    }

    public void setActivestate(String activestate) {
        this.activestate = activestate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getProduceModel() {
        return produceModel;
    }

    public void setProduceModel(String produceModel) {
        this.produceModel = produceModel;
    }

    public String getMatScanType() {
        return matScanType;
    }

    public void setMatScanType(String matScanType) {
        this.matScanType = matScanType;
    }
     

    public String getMarketStatus() {
		return marketStatus;
	}

	public void setMarketStatus(String marketStatus) {
		this.marketStatus = marketStatus;
	}

	public String getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(String packageNo) {
		this.packageNo = packageNo;
	}

	public Long getCbm() {
        return cbm;
    }

    public void setCbm(Long cbm) {
        this.cbm = cbm;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	public Long getOrderBasicFactor() {
		return orderBasicFactor;
	}

	public void setOrderBasicFactor(Long orderBasicFactor) {
		this.orderBasicFactor = orderBasicFactor;
	}

	public Long getOrderFactor() {
		return orderFactor;
	}

	public void setOrderFactor(Long orderFactor) {
		this.orderFactor = orderFactor;
	}

	public String getIssueUnit() {
		return issueUnit;
	}

	public void setIssueUnit(String issueUnit) {
		this.issueUnit = issueUnit;
	}

	public Long getIssueBasicFactor() {
		return issueBasicFactor;
	}

	public void setIssueBasicFactor(Long issueBasicFactor) {
		this.issueBasicFactor = issueBasicFactor;
	}

	public Long getIssueFactor() {
		return issueFactor;
	}

	public void setIssueFactor(Long issueFactor) {
		this.issueFactor = issueFactor;
	}

	public String getMatType() {
		return matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	public String getMrpCode() {
		return mrpCode;
	}

	public void setMrpCode(String mrpCode) {
		this.mrpCode = mrpCode;
	}

	public String getPurchaseGroup() {
		return purchaseGroup;
	}

	public void setPurchaseGroup(String purchaseGroup) {
		this.purchaseGroup = purchaseGroup;
	}

	public String getOldMat() {
		return oldMat;
	}

	public void setOldMat(String oldMat) {
		this.oldMat = oldMat;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	/**
    * <p>Title: toString</p>
    * <p>Description: </p>
    * @return
    * @see java.lang.Object#toString()
     */
    public String toString() {
        return "material_code: " + this.materialNo + ", material_desp: "
                + this.materialDesp + ", customer_model: " + this.customerModel
                + ", plant: " + this.plant + ", external_mat_group: "
                + this.externalMatGroup + ", gross_weight: " + this.grossWeight
                + ", net_weight: " + this.netWeight + ", size_dimension: "
                + this.sizeDimension + ", basic_unit: " + this.basicUnit
                + ", plant_status: " + this.plantStatus + ", division: "
                + this.division + ", produce_attr: " + this.produceAttribute
                + ", modify_dt: " + this.modifyDate + ", version: "
                + this.version + ", active_state: " + this.activestate
                + ", create_by: " + this.createdBy + ", create_dt: "
                + this.createdDate + ", modify_by: " + this.modifyBy
                + ", remark: " + this.remark + ", in_out: " + this.inOut
                + ", mat_scan_type: " + this.matScanType + ", produce_model: "
                + this.produceModel + ", cbm: " + this.cbm + ", length: "
                + this.length + ", width: " + this.width + ", height: "
                + this.higth;
    }

}
