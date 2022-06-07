package com.haier.hevwms.sto.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: StgStodnDown.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月14日 下午2:56:08
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月14日		LJZ			v1.0.0			create
 */

public class StgStoDnDown implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7259310423729371116L;

	private Long rowId;

    private String stoNo;

    private String stoItemNo;

    private String stodnNo;

    private String stodnItemNo;

    private Long qty;

    private String materialNo;

    private String unit;

    private String giLocation;

    private String message;

    private Long giFinishQty;

    private String giFinishFlag;

    private String giFlag;

    private Long grFinishQty;

    private String grFinishFlag;

    private String grFlag;

    private String giSapFlag;

    private String grSapFlag;

    private String giSapMsg;

    private String giDoc;

    private String grSapMsg;

    private String grDoc;

    private String remark;

    private String flag;

    private String createBy;

    private Date createDate;

    private String modifyBy;

    private Date modifyDate;

    private String sapFlag;

    private String prescanFlag;

    private String giPlant;

    private String giDate;

    private String grDate;

    private String submitBy;

    private String grPlant;

    private String grLocation;

    private String customerModel;

    private String materialDesp;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGiLocation() {
        return giLocation;
    }

    public void setGiLocation(String giLocation) {
        this.giLocation = giLocation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getGiFinishQty() {
        return giFinishQty;
    }

    public void setGiFinishQty(Long giFinishQty) {
        this.giFinishQty = giFinishQty;
    }

    public String getGiFinishFlag() {
        return giFinishFlag;
    }

    public void setGiFinishFlag(String giFinishFlag) {
        this.giFinishFlag = giFinishFlag;
    }

    public String getGiFlag() {
        return giFlag;
    }

    public void setGiFlag(String giFlag) {
        this.giFlag = giFlag;
    }

    public Long getGrFinishQty() {
        return grFinishQty;
    }

    public void setGrFinishQty(Long grFinishQty) {
        this.grFinishQty = grFinishQty;
    }

    public String getGrFinishFlag() {
        return grFinishFlag;
    }

    public void setGrFinishFlag(String grFinishFlag) {
        this.grFinishFlag = grFinishFlag;
    }

    public String getGrFlag() {
        return grFlag;
    }

    public void setGrFlag(String grFlag) {
        this.grFlag = grFlag;
    }

    public String getGiSapFlag() {
        return giSapFlag;
    }

    public void setGiSapFlag(String giSapFlag) {
        this.giSapFlag = giSapFlag;
    }

    public String getGrSapFlag() {
        return grSapFlag;
    }

    public void setGrSapFlag(String grSapFlag) {
        this.grSapFlag = grSapFlag;
    }

    public String getGiSapMsg() {
        return giSapMsg;
    }

    public void setGiSapMsg(String giSapMsg) {
        this.giSapMsg = giSapMsg;
    }

    public String getGiDoc() {
        return giDoc;
    }

    public void setGiDoc(String giDoc) {
        this.giDoc = giDoc;
    }

    public String getGrSapMsg() {
        return grSapMsg;
    }

    public void setGrSapMsg(String grSapMsg) {
        this.grSapMsg = grSapMsg;
    }

    public String getGrDoc() {
        return grDoc;
    }

    public void setGrDoc(String grDoc) {
        this.grDoc = grDoc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getSapFlag() {
        return sapFlag;
    }

    public void setSapFlag(String sapFlag) {
        this.sapFlag = sapFlag;
    }

    public String getPrescanFlag() {
        return prescanFlag;
    }

    public void setPrescanFlag(String prescanFlag) {
        this.prescanFlag = prescanFlag;
    }

    public String getGiPlant() {
        return giPlant;
    }

    public void setGiPlant(String giPlant) {
        this.giPlant = giPlant;
    }

    public String getGiDate() {
        return giDate;
    }

    public void setGiDate(String giDate) {
        this.giDate = giDate;
    }

    public String getGrDate() {
        return grDate;
    }

    public void setGrDate(String grDate) {
        this.grDate = grDate;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
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
}