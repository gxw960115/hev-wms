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
public class OdsStoCustDTO implements Serializable {

    private static final long serialVersionUID = 1671761643195423891L;

    private Long rowId;
    private String stoNo;
    private String stoItemNo;
    private String checkFlag;
    private String giPlant;
    private String grPlant;
    private String giLocation;
    private String grLocation;
    private String materialNo;
    private String materialDesp;
    private String unit;
    private Long qty;
    private Long giFinishQty;
    private String giFinishFlag;
    private Long grFinishQty;
    private String grFinishFlag;
    private Date giDate;
    private Date grDate;
    private String remark;
    private String createBy;
    private String checkBy;
    private Date createDate;
    private Date checkDate;
    private String modifyBy;
    private Date modifyDate;
    private String itemDelete;
    private String flag;
    private String postingDateIn;
    private String transporterNameIn;
    private String postingDateOut;
    private String transporterNameOut;
    private String inFlag;
    private String inMsg;
    private String outFlag;
    private String outMsg;
    private String begin;
    private String end;
    private String basicUnit;

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

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        if (checkDate == null) {
            this.checkDate = null;
        } else {
            this.checkDate = (Date) checkDate.clone();
        }
    }

    public String getBasicUnit() {
        return basicUnit;
    }

    public void setBasicUnit(String basicUnit) {
        this.basicUnit = basicUnit;
    }

    public String getGiPlant() {
        return giPlant;
    }

    public void setGiPlant(String giPlant) {
        this.giPlant = giPlant;
    }

    public String getGrPlant() {
        return grPlant;
    }

    public void setGrPlant(String grPlant) {
        this.grPlant = grPlant;
    }

    public String getGiLocation() {
        return giLocation;
    }

    public void setGiLocation(String giLocation) {
        this.giLocation = giLocation;
    }

    public String getGrLocation() {
        return grLocation;
    }

    public void setGrLocation(String grLocation) {
        this.grLocation = grLocation;
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
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

    public Date getGiDate() {
        return giDate;
    }

    public void setGiDate(Date giDate) {
        if (giDate == null) {
            this.giDate = null;
        } else {
            this.giDate = (Date) giDate.clone();
        }
    }

    public Date getGrDate() {
        return grDate;
    }

    public void setGrDate(Date grDate) {
        if (grDate == null) {
            this.grDate = null;
        } else {
            this.grDate = (Date) grDate.clone();
        }
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        if (modifyDate == null) {
            this.modifyDate = null;
        } else {
            this.modifyDate = (Date) modifyDate.clone();
        }
    }

    public String getItemDelete() {
        return itemDelete;
    }

    public void setItemDelete(String itemDelete) {
        this.itemDelete = itemDelete;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPostingDateIn() {
        return postingDateIn;
    }

    public void setPostingDateIn(String postingDateIn) {
        this.postingDateIn = postingDateIn;
    }

    public String getTransporterNameIn() {
        return transporterNameIn;
    }

    public void setTransporterNameIn(String transporterNameIn) {
        this.transporterNameIn = transporterNameIn;
    }

    public String getPostingDateOut() {
        return postingDateOut;
    }

    public void setPostingDateOut(String postingDateOut) {
        this.postingDateOut = postingDateOut;
    }

    public String getTransporterNameOut() {
        return transporterNameOut;
    }

    public void setTransporterNameOut(String transporterNameOut) {
        this.transporterNameOut = transporterNameOut;
    }

    public String getInFlag() {
        return inFlag;
    }

    public void setInFlag(String inFlag) {
        this.inFlag = inFlag;
    }

    public String getInMsg() {
        return inMsg;
    }

    public void setInMsg(String inMsg) {
        this.inMsg = inMsg;
    }

    public String getOutFlag() {
        return outFlag;
    }

    public void setOutFlag(String outFlag) {
        this.outFlag = outFlag;
    }

    public String getOutMsg() {
        return outMsg;
    }

    public void setOutMsg(String outMsg) {
        this.outMsg = outMsg;
    }
}