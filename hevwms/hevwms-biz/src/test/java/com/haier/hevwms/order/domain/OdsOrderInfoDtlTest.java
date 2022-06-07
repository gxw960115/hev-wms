package com.haier.hevwms.order.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.order.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 21:02
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsOrderInfoDtlTest {
    @Test
    public void test() {
        OdsOrderInfoDtl target = new OdsOrderInfoDtl();
        Date date = new Date();
        target.setUserType("");
        target.setUserId(0L);
        target.setBegin("");
        target.setEnd("");
        target.setRowId(0L);
        target.setOrderType("");
        target.setDocType("");
        target.setSapOrderNo("");
        target.setSapOrderItem("");
        target.setBatchNo("");
        target.setPlant("");
        target.setCustomerModel("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setUnit("");
        target.setBarcode("");
        target.setVendorCode("");
        target.setVendorName("");
        target.setDeliveryCode("");
        target.setDeliveryName("");
        target.setScannedBy("");
        target.setScannedDate(date);
        target.setDeliveryDate(date);
        target.setOrderId(0L);
        target.setOrderNo("");
        target.setCarNo("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setQty(0L);
        target.setOrderItem("");
        target.setSerialNo("");
        target.setFinishFlag("");
        target.setInOutFlag("");
        target.setInOutMsg("");
        target.setUsedFlag("");
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getUserType();
        target.getUserId();
        target.getBegin();
        target.getEnd();
        target.getRowId();
        target.getOrderType();
        target.getDocType();
        target.getSapOrderNo();
        target.getSapOrderItem();
        target.getBatchNo();
        target.getPlant();
        target.getCustomerModel();
        target.getLocation();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getUnit();
        target.getBarcode();
        target.getVendorCode();
        target.getVendorName();
        target.getDeliveryCode();
        target.getDeliveryName();
        target.getScannedBy();
        target.getScannedDate();
        target.getDeliveryDate();
        target.getOrderId();
        target.getOrderNo();
        target.getCarNo();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getQty();
        target.getOrderItem();
        target.getSerialNo();
        target.getFinishFlag();
        target.getInOutFlag();
        target.getInOutMsg();
        target.getUsedFlag();
        target.getCreateDate();
        target.getModifyDate();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}