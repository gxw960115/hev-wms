package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

public class OrderGiGrDTO implements Serializable {

    private static final long serialVersionUID = -2537657703321316254L;

    /**
     * 0-正确 1-错误
     */
    private String status;
    /**
     * 描述
     */
    private String msg;
    /**
     * 出入库订单号
     */
    private String orderNo;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "OrderGiGrDTO{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
