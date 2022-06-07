package com.haier.openplatform.wms.sto.dto;

import com.haier.openplatform.wms.util.NotNull;

import java.io.Serializable;
import java.util.Date;

public class StgStoDnDTO implements Serializable {

    private static final long serialVersionUID = -5141737541575745830L;

    /**
     * id
     */
    private Long rowId;

    /**
     * 出入库订单号
     */
    private String orderNo;

    /**
     * 调拨单号
     */
    @NotNull(fileName = "调拨单号")
    private String stoNo;

    /**
     * sto行项目
     */
    @NotNull(fileName = "STO行项目")
    private String stoItem;

    /**
     * 订单类型
     */
    @NotNull(fileName = "订单类型")
    private String orderType;

    /**
     * STODN号
     */
    @NotNull(fileName = "STODN号")
    private String stodnNo;

    /**
     * dn行项目
     */
    @NotNull(fileName = "STODN行项目")
    private String stoDnItem;

    /**
     * 条码
     */
    private String barcode;

    /**
     * 工厂
     */
    @NotNull(fileName = "工厂")
    private String plant;

    /**
     * 库位
     */
    @NotNull(fileName = "库位")
    private String location;

    /**
     * 订单数量
     */
    @NotNull(fileName = "订单数量")
    private Long qty;

    /**
     * 单位
     */
    @NotNull(fileName = "单位")
    private String unit;

    /**
     * 物料号
     */
    @NotNull(fileName = "物料号")
    private String materialNo;

    /**
     * 物料描述
     */
//    @NotNull(fileName = "物料描述")
    private String materialDesp;

    /**
     * 送达方代码
     */
//    @NotNull(fileName = "送达方代码")
    private String deliveryCode;

    /**
     * 送达方名称
     */
//    @NotNull(fileName = "送达方名称")
    private String deliveryName;

    /**
     * 送达方地址
     */
//    @NotNull(fileName = "送达方地址")
    private String deliveryAddress;

    /**
     * 送达方地址
     */
    @NotNull(fileName = "调拨工厂")
    private String grPlant;

    /**
     * 送达方地址
     */
    @NotNull(fileName = "调拨库位")
    private String grLocation;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后修改人
     */
    private String modifyBy;

    /**
     * 最后修改时间
     */
    private Date modifyDate;

    /**
     * 入库完成数量
     */
    private String grQty;

    /**
     * 入库完成标识
     * 0:未完成
     * S:完成
     */
    private String grFlag;

    /**
     * 最后入库时间
     */
    private Date grDate;

    /**
     * 出库完成数量
     */
    private String giQty;

    /**
     * 出库完成标识
     * 0:未完成
     * S:完成
     */
    private String giFlag;

    /**
     * 最后出库时间
     */
    private Date giDate;

    /**
     * 创建开始时间
     */
    private String begin;

    /**
     * 创建结束时间
     */
    private String end;

    private String carNo;

    private String postDate;

    private String transporter;

    private String tmsFlag;

    /**
     * SAP过账状态
     */
    private String sapFlag;

    /**
     * bin
     */
    private String bin;

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

    public String getStoNo() {
        return stoNo;
    }

    public void setStoNo(String stoNo) {
        this.stoNo = stoNo;
    }

    public String getStoItem() {
        return stoItem;
    }

    public void setStoItem(String stoItem) {
        this.stoItem = stoItem;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getStodnNo() {
        return stodnNo;
    }

    public void setStodnNo(String stodnNo) {
        this.stodnNo = stodnNo;
    }

    public String getStoDnItem() {
        return stoDnItem;
    }

    public void setStoDnItem(String stoDnItem) {
        this.stoDnItem = stoDnItem;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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

    public String getGrQty() {
        return grQty;
    }

    public void setGrQty(String grQty) {
        this.grQty = grQty;
    }

    public String getGrFlag() {
        return grFlag;
    }

    public void setGrFlag(String grFlag) {
        this.grFlag = grFlag;
    }

    public Date getGrDate() {
        return grDate;
    }

    public void setGrDate(Date grDate) {
        this.grDate = grDate;
    }

    public String getGiQty() {
        return giQty;
    }

    public void setGiQty(String giQty) {
        this.giQty = giQty;
    }

    public String getGiFlag() {
        return giFlag;
    }

    public void setGiFlag(String giFlag) {
        this.giFlag = giFlag;
    }

    public Date getGiDate() {
        return giDate;
    }

    public void setGiDate(Date giDate) {
        this.giDate = giDate;
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

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    public String getTmsFlag() {
        return tmsFlag;
    }

    public void setTmsFlag(String tmsFlag) {
        this.tmsFlag = tmsFlag;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getSapFlag() {
        return sapFlag;
    }

    public void setSapFlag(String sapFlag) {
        this.sapFlag = sapFlag;
    }

    @Override
    public String toString() {
        return "StgStoDnDTO{" +
                "rowId=" + rowId +
                ", orderNo='" + orderNo + '\'' +
                ", stoNo='" + stoNo + '\'' +
                ", stoItem='" + stoItem + '\'' +
                ", orderType='" + orderType + '\'' +
                ", stodnNo='" + stodnNo + '\'' +
                ", stoDnItem='" + stoDnItem + '\'' +
                ", barcode='" + barcode + '\'' +
                ", plant='" + plant + '\'' +
                ", location='" + location + '\'' +
                ", qty=" + qty +
                ", unit='" + unit + '\'' +
                ", materialNo='" + materialNo + '\'' +
                ", materialDesp='" + materialDesp + '\'' +
                ", deliveryCode='" + deliveryCode + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", grPlant='" + grPlant + '\'' +
                ", grLocation='" + grLocation + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", grQty='" + grQty + '\'' +
                ", grFlag='" + grFlag + '\'' +
                ", grDate=" + grDate +
                ", giQty='" + giQty + '\'' +
                ", giFlag='" + giFlag + '\'' +
                ", giDate=" + giDate +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", carNo='" + carNo + '\'' +
                ", postDate='" + postDate + '\'' +
                ", transporter='" + transporter + '\'' +
                ", tmsFlag='" + tmsFlag + '\'' +
                ", bin='" + bin + '\'' +
                '}';
    }
}
