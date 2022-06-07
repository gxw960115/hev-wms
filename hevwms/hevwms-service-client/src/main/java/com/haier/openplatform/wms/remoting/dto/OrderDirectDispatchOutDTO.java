package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

public class OrderDirectDispatchOutDTO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -3610460552068501019L;

    String stodnNo;

    String dnNo;

    String status;

    String msg;

    String igpOrderNo;

    String ogpOrderNo;

    public String getStodnNo() {
        return stodnNo;
    }

    public void setStodnNo(String stodnNo) {
        this.stodnNo = stodnNo;
    }

    public String getDnNo() {
        return dnNo;
    }

    public void setDnNo(String dnNo) {
        this.dnNo = dnNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIgpOrderNo() {
        return igpOrderNo;
    }

    public void setIgpOrderNo(String igpOrderNo) {
        this.igpOrderNo = igpOrderNo;
    }

    public String getOgpOrderNo() {
        return ogpOrderNo;
    }

    public void setOgpOrderNo(String ogpOrderNo) {
        this.ogpOrderNo = ogpOrderNo;
    }

}
