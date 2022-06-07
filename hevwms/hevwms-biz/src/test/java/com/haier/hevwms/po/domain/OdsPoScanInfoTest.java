package com.haier.hevwms.po.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.po.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 13:52
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsPoScanInfoTest {
    @Test
    public void test() {
        OdsPoScanInfo target = new OdsPoScanInfo();

        Date date = new Date();
        target.setRowId(0L);
        target.setOrderType("");
        target.setBin("");
        target.setPoNo("");
        target.setPoItemNo("");
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
        target.setCreateDate(date);
        target.setModifyBy("");
        target.setModifyDate(date);
        target.setFlag("");
        target.setVersion(0L);
        target.setQty(0L);
        target.setOrderItem("");
        target.setSerialNo("");
        target.setFinishFlag("");
        target.setInOutFlag("");
        target.setInOutMsg("");
        target.setUsedFlag("");
        target.setSubLocation("");
        target.setRemark("");

        target.getRowId();
        target.getOrderType();
        target.getBin();
        target.getPoNo();
        target.getPoItemNo();
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
        target.getCreateDate();
        target.getModifyBy();
        target.getModifyDate();
        target.getFlag();
        target.getVersion();
        target.getQty();
        target.getOrderItem();
        target.getSerialNo();
        target.getFinishFlag();
        target.getInOutFlag();
        target.getInOutMsg();
        target.getUsedFlag();
        target.getSubLocation();
        target.getRemark();

    }
}