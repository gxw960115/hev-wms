package com.haier.openplatform.wms.sto.dto;

import java.io.Serializable;
import java.util.Date;

public class OdsStodnScanInfoDTO implements Serializable {

    private static final long serialVersionUID = -3395059768262527352L;

    /**
     * 订单出入库类型
     */
    private String orderType;

    /**
     * bin
     */
    private String bin;

    /**
     * STO订单
     */
    private String stoNo;

    /**
     * STODN号
     */
    private String stodnNo;

    /**
     * STODN行项目
     */
    private String stodnItem;

    /**
     * 工厂
     */
    private String plant;

    /**
     * 库位
     */
    private String location;

    /**
     * 物料
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
     * 扫描条码
     */
    private String barcode;

    /**
     * 车辆号
     */
    private String carNo;

    /**
     * 扫描人
     */
    private String createBy;

    /**
     * 扫描时间
     */
    private Date createDate;

    /**
     * 扫描数量
     */
    private Integer qty;

    /**
     * 扫描备注
     */
    private String remark;

    /**
     * 过账时间
     */
    private String postDate;

    /**
     * transporter
     */
    private String transporter;

    /**
     * 过帐单号
     */
    private String orderNo;

    private String begin;
    private String end;

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

    public String getStodnNo() {
        return stodnNo;
    }

    public void setStodnNo(String stodnNo) {
        this.stodnNo = stodnNo;
    }

    public String getStodnItem() {
        return stodnItem;
    }

    public void setStodnItem(String stodnItem) {
        this.stodnItem = stodnItem;
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
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    @Override
    public String toString() {
        return "OdsStodnScanInfoDTO{" +
                "orderType='" + orderType + '\'' +
                ", bin='" + bin + '\'' +
                ", stoNo='" + stoNo + '\'' +
                ", stodnNo='" + stodnNo + '\'' +
                ", stodnItem='" + stodnItem + '\'' +
                ", plant='" + plant + '\'' +
                ", location='" + location + '\'' +
                ", materialNo='" + materialNo + '\'' +
                ", materialDesp='" + materialDesp + '\'' +
                ", unit='" + unit + '\'' +
                ", barcode='" + barcode + '\'' +
                ", carNo='" + carNo + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", qty='" + qty + '\'' +
                ", remark='" + remark + '\'' +
                ", postDate='" + postDate + '\'' +
                ", transporter='" + transporter + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
