package com.haier.openplatform.wms.stocktaking.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsPdInfoDtlDTO implements Serializable {

    /**
     * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    private Long rowId;

    /**
     * 盘点单号
     */

    private String orderNo;

    /**
     * 工厂
     */

    private String plant;

    /**
     * 客户描述
     */

    private String customerModel;

    /**
     * 库存地点
     */

    private String location;

    /**
     * 物料号
     */

    private String materialNo;

    /**
     * 物料描述
     */

    private String materialDesp;

    /**
     * 单位
     */

    private String unit;

    /**
     * 条码
     */

    private String barcode;

    /**
     * 创建人
     */

    private String createBy;

    /**
     * 创建日期
     */

    private java.util.Date createDate = new Date();

    /**
     * 修改人
     */

    private String modifyBy;

    /**
     * 修改日期
     */

    private java.util.Date modifyDate = new Date();
    /**
     * 有效标记 0-有效 1-失效
     */
    private java.lang.String flag;
    /**
     * 版本号
     */
    private Long version;
    /**
     * 仓间，库位
     */
    private String subLocation;
    /**
     * 数量
     */
    private Long qty;


    private String bin;

    private String inveBin;

    private String pdBin;

    private Long locqty;

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

    public Long getInveQty() {
        return inveQty;
    }

    public void setInveQty(Long inveQty) {
        this.inveQty = inveQty;
    }

    private Long wmsqty;
    private Long sapqty;
    private String inveSub;
    private String inveBarcode;
    private Long inveRowId;
    private Long inveQty;

    private String begin;
    private String end;
    private String plantName;
    private String status;//删除标记

    private Long userId;
    private String userType;


    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    /**
     * getRowId
     *
     * @return Long
     */
    public Long getRowId() {
        return rowId;
    }

    /**
     * setRowId
     *
     * @param rowId
     */
    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    /**
     * getOrderNo
     *
     * @return String
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * setOrderNo
     *
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * getPlant
     *
     * @return String
     */
    public String getPlant() {
        return plant;
    }

    /**
     * setPlant
     *
     * @param plant
     */
    public void setPlant(String plant) {
        this.plant = plant;
    }

    /**
     * getCustomerModel
     *
     * @return String
     */
    public String getCustomerModel() {
        return customerModel;
    }

    /**
     * setCustomerModel
     *
     * @param customerModel
     */
    public void setCustomerModel(String customerModel) {
        this.customerModel = customerModel;
    }

    /**
     * getLocation
     *
     * @return String
     */
    public String getLocation() {
        return location;
    }

    /**
     * setLocation
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getMaterialNo
     *
     * @return String
     */
    public String getMaterialNo() {
        return materialNo;
    }

    /**
     * setMaterialNo
     *
     * @param materialNo
     */
    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    /**
     * getMaterialDesp
     *
     * @return String
     */
    public String getMaterialDesp() {
        return materialDesp;
    }

    /**
     * setMaterialDesp
     *
     * @param materialDesp
     */
    public void setMaterialDesp(String materialDesp) {
        this.materialDesp = materialDesp;
    }

    /**
     * getUnit
     *
     * @return String
     */
    public String getUnit() {
        return unit;
    }

    /**
     * setUnit
     *
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * getBarcode
     *
     * @return String
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * setBarcode
     *
     * @param barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * getCreateBy
     *
     * @return String
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * setCreateBy
     *
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * getCreateDate
     *
     * @return Date
     */
    public java.util.Date getCreateDate() {
        if (createDate == null) {
            return null;
        } else {
            return (Date) createDate.clone();
        }
    }

    /**
     * setCreateDate
     *
     * @param createDate
     */
    public void setCreateDate(java.util.Date value) {
        if (value == null) {
            this.createDate = null;
        } else {
            this.createDate = (Date) value.clone();
        }
    }

    /**
     * getModifyBy
     *
     * @return String
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * setModifyBy
     *
     * @param modifyBy
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * getModifyDate
     *
     * @return Date
     */
    public java.util.Date getModifyDate() {
        if (modifyDate == null) {
            return null;
        } else {
            return (Date) modifyDate.clone();
        }
    }

    /**
     * setModifyDate
     *
     * @param modifyDate
     */
    public void setModifyDate(java.util.Date value) {
        if (value == null) {
            this.modifyDate = null;
        } else {
            this.modifyDate = (Date) value.clone();
        }
    }

    /**
     * getFlag
     *
     * @return String
     */
    public java.lang.String getFlag() {
        return flag;
    }

    /**
     * setFlag
     *
     * @param flag
     */
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    /**
     * getVersion
     *
     * @return Long
     */
    public Long getVersion() {
        return version;
    }

    /**
     * setVersion
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * getSubLocation
     *
     * @return String
     */
    public String getSubLocation() {
        return subLocation;
    }

    /**
     * setSubLocation
     *
     * @param subLocation
     */
    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    /**
     * getQty
     *
     * @return Long
     */
    public Long getQty() {
        return qty;
    }

    /**
     * setQty
     *
     * @param qty
     */
    public void setQty(Long qty) {
        this.qty = qty;
    }

    /**
     * getLocqty
     *
     * @return Long
     */
    public Long getLocqty() {
        return locqty;
    }

    /**
     * setLocqty
     *
     * @param locqty
     */
    public void setLocqty(Long locqty) {
        this.locqty = locqty;
    }

    /**
     * getWmsqty
     *
     * @return Long
     */
    public Long getWmsqty() {
        return wmsqty;
    }

    /**
     * setWmsqty
     *
     * @param wmsqty
     */
    public void setWmsqty(Long wmsqty) {
        this.wmsqty = wmsqty;
    }

    /**
     * getSapqty
     *
     * @return Long
     */
    public Long getSapqty() {
        return sapqty;
    }

    /**
     * setSapqty
     *
     * @param sapqty
     */
    public void setSapqty(Long sapqty) {
        this.sapqty = sapqty;
    }

    /**
     * getInveSub
     *
     * @return String
     */
    public String getInveSub() {
        return inveSub;
    }

    /**
     * setInveSub
     *
     * @param inveSub
     */
    public void setInveSub(String inveSub) {
        this.inveSub = inveSub;
    }

    /**
     * getInveBarcode
     *
     * @return String
     */
    public String getInveBarcode() {
        return inveBarcode;
    }

    /**
     * setInveBarcode
     *
     * @param inveBarcode
     */
    public void setInveBarcode(String inveBarcode) {
        this.inveBarcode = inveBarcode;
    }

    /**
     * getInveRowId
     *
     * @return Long
     */
    public Long getInveRowId() {
        return inveRowId;
    }

    /**
     * setInveRowId
     *
     * @param inveRowId
     */
    public void setInveRowId(Long inveRowId) {
        this.inveRowId = inveRowId;
    }

    /**
     * getBegin
     *
     * @return String
     */
    public String getBegin() {
        return begin;
    }

    /**
     * setBegin
     *
     * @param begin
     */
    public void setBegin(String begin) {
        this.begin = begin;
    }

    /**
     * getEnd
     *
     * @return String
     */
    public String getEnd() {
        return end;
    }

    /**
     * setEnd
     *
     * @param end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * getSerialversionuid
     *
     * @return long
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * getStatus
     *
     * @return String
     */
    public String getStatus() {
        return status;
    }

    /**
     * setStatus
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * getPlantName
     *
     * @return String
     */
    public String getPlantName() {
        return plantName;
    }

    /**
     * setPlantName
     *
     * @param plantName
     */
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}
