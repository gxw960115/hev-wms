package com.haier.hevwms.basic.domain;

import java.util.Date;

/**
 * @author sunhaoyu
 * 
 */
public class MdMatInfo {

    /**
     * 序列号
     */
    public static final long serialVersionUID = 5935496607119318672L;

    /** ID */

    public Long rowId;

    /** 物料号 */

    public java.lang.String materialNo;

    /** 客户型号 */

    public String customerModel;

    /** 物料描述 */

    public String materialDesp;

    /** 工厂 */

    public java.lang.String plant;

    /** 颜色 */

    public java.lang.String externalMatGroup;

    /** 毛重 */

    public java.lang.String grossWeight;

    /** 净重 */

    public java.lang.String netWeight;

    /** 尺寸 */

    public java.lang.String sizeDimension;

    /** 单位 */

    public java.lang.String basicUnit;

    /** 状态 */

    public java.lang.String plantStatus;

    /** 大类 */

    public java.lang.String division;

    /** 长 */

    public java.lang.Double length;

    /** 宽 */

    public java.lang.Double width;

    /** 高 */
    public java.lang.Double higth;

    /** 区分空调内外机，空为内机，X为外机 */

    public java.lang.String produceAttribute;

    /** 修改日期 */

    public java.util.Date modifyDate=new Date();

    /** 修改次数 */

    public java.lang.Long version;

    /** 有效状态 */

    public java.lang.String activestate;

    /** 创建人 */

    public java.lang.String createdBy;

    /** 创建日期 */

    public java.util.Date createdDate=new Date();

    /** 修改人 */

    public java.lang.String modifyBy;

    /** 备注 */

    public String remark;

    /** inOut */

    public java.lang.String inOut;
    public String produceModel;
    public String matScanType;

    public Long cbm;

    public Long getCbm() {
        return cbm;
    }

    public void setCbm(Long cbm) {
        this.cbm = cbm;
    }

    public Long getRowId() {
        return this.rowId;
    }

    public void setRowId(Long value) {
        this.rowId = value;
    }

    public java.lang.String getMaterialNo() {
        if (this.materialNo != null) {
            this.materialNo = this.materialNo.toUpperCase();
        }
        return this.materialNo;
    }

    public void setMaterialNo(java.lang.String value) {
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

    public java.lang.String getPlant() {
        return this.plant;
    }

    public void setPlant(java.lang.String value) {
        this.plant = value;
    }

    public java.lang.String getExternalMatGroup() {
        return this.externalMatGroup;
    }

    public void setExternalMatGroup(java.lang.String value) {
        this.externalMatGroup = value;
    }

    public java.lang.String getGrossWeight() {
        return this.grossWeight;
    }

    public void setGrossWeight(java.lang.String value) {
        this.grossWeight = value;
    }

    public java.lang.String getNetWeight() {
        return this.netWeight;
    }

    public void setNetWeight(java.lang.String value) {
        this.netWeight = value;
    }

    public java.lang.String getSizeDimension() {
        return this.sizeDimension;
    }

    public void setSizeDimension(java.lang.String value) {
        this.sizeDimension = value;
    }

    public java.lang.String getBasicUnit() {
        return this.basicUnit;
    }

    public void setBasicUnit(java.lang.String value) {
        this.basicUnit = value;
    }

    public java.lang.String getPlantStatus() {
        return this.plantStatus;
    }

    public void setPlantStatus(java.lang.String value) {
        this.plantStatus = value;
    }

    public java.lang.String getDivision() {
        return this.division;
    }

    public void setDivision(java.lang.String value) {
        this.division = value;
    }

    public java.lang.String getProduceAttribute() {
        return this.produceAttribute;
    }

    public void setProduceAttribute(java.lang.String value) {
        this.produceAttribute = value;
    }

    public java.util.Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(java.util.Date value) {
        this.modifyDate = value;
    }

    public java.lang.Long getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.Long value) {
        this.version = value;
    }

    public java.lang.String getActivestate() {
        return this.activestate;
    }

    public void setActivestate(java.lang.String value) {
        this.activestate = value;
    }

    public java.lang.String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(java.lang.String value) {
        this.createdBy = value;
    }

    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.util.Date value) {
        this.createdDate = value;
    }

    public java.lang.String getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(java.lang.String value) {
        this.modifyBy = value;
    }

    public String getRemark() {
        if (this.remark == null) {
            return null;
        }
        return this.remark.toUpperCase();
    }

    public void setRemark(String value) {
    	if (value == null){
    		this.remark = null;
    	} else {
    		this.remark = value;
    	}
    }

    public java.lang.String getInOut() {
        return this.inOut;
    }

    public void setInOut(java.lang.String value) {
        this.inOut = value;
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

    public java.lang.Double getLength() {
        return length;
    }

    public void setLength(java.lang.Double length) {
        this.length = length;
    }

    public java.lang.Double getWidth() {
        return width;
    }

    public void setWidth(java.lang.Double width) {
        this.width = width;
    }

    public java.lang.Double getHigth() {
        return higth;
    }

    public void setHigth(java.lang.Double higth) {
        this.higth = higth;
    }

}
