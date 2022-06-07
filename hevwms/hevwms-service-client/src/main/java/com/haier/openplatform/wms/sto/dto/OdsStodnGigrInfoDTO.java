package com.haier.openplatform.wms.sto.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * ODS_STODN_GIGR_INFO 表
 * STODN 出入库过账汇总表
 */
public class OdsStodnGigrInfoDTO implements Serializable {

    private static final long serialVersionUID = -8587612535531798791L;

    /**
     * 出入库订单号
     */
    private String orderNo;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 调拨单号
     */
    private String stoNo;

    /**
     * 调拨DN号
     */
    private String stodnNo;

    /**
     * 调拨DN行项目
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
     * 过账数量
     */
    private Integer qty;

    /**
     * 单位
     */
    private String unit;

    /**
     * 物料号
     */
    private String materialNo;

    /**
     * 物料描述
     */
    private String materialDesp;

    /**
     * TMS过账状态
     *  0-默认 1-成功 2-失败
     */
    private String tmsFlag;

    /**
     * TMS过账信息
     */
    private String tmsMsg;

    /**
     * 车辆信息
     */
    private String carNo;

    /**
     * transporter
     */
    private String transporter;

    /**
     * 过账时间
     */
    private String postDate;

    /**
     * 创建人/扫描人
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
     * 出入库状态
     */
    private String inOutFlag;

    /**
     * 出入库信息
     */
    private String inOutMsg;

    /**
     * 开始时间
     */
    private String begin;

    /**
     * 结束时间
     */
    private String end;

    private String flag;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
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

    public String getTmsFlag() {
        return tmsFlag;
    }

    public void setTmsFlag(String tmsFlag) {
        this.tmsFlag = tmsFlag;
    }

    public String getTmsMsg() {
        return tmsMsg;
    }

    public void setTmsMsg(String tmsMsg) {
        this.tmsMsg = tmsMsg;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "odsStodnGigrInfoDTO{" +
                "orderNo='" + orderNo + '\'' +
                ", orderType='" + orderType + '\'' +
                ", stoNo='" + stoNo + '\'' +
                ", stodnNo='" + stodnNo + '\'' +
                ", stodnItem='" + stodnItem + '\'' +
                ", plant='" + plant + '\'' +
                ", location='" + location + '\'' +
                ", qty=" + qty +
                ", unit='" + unit + '\'' +
                ", materialNo='" + materialNo + '\'' +
                ", materialDesp='" + materialDesp + '\'' +
                ", tmsFlag='" + tmsFlag + '\'' +
                ", tmsMsg='" + tmsMsg + '\'' +
                ", carNo='" + carNo + '\'' +
                ", transporter='" + transporter + '\'' +
                ", postDate='" + postDate + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", inOutFlag='" + inOutFlag + '\'' +
                ", inOutMsg='" + inOutMsg + '\'' +
                '}';
    }
}
