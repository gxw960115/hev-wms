package com.haier.hevwms.consume.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.consume.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 13:50
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsConsumeOrderTest {
    @Test
    public void test() {
        OdsConsumeOrder target = new OdsConsumeOrder();

        Date date = new Date();
        target.setRowId(0L);
        target.setConsumeNo("");
        target.setConsumeItemNo("");
        target.setOrderType("");
        target.setPlant("");
        target.setWarehouseCode("");
        target.setWarehouseName("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setUnit("");
        target.setVendorCode("");
        target.setVendorName("");
        target.setDeliveryCode("");
        target.setDeliveryName("");
        target.setDeliveryDate(date);
        target.setCreateBy("");
        target.setCreateDate(date);
        target.setModifyBy("");
        target.setModifyDate(date);
        target.setFlag("");
        target.setVersion(0L);
        target.setRequireQty(0L);
        target.setOrderClose("");
        target.setPresacnFlag("");
        target.setCheckFlag("");
        target.setFinishQty(0L);
        target.setCheckDate(date);
        target.setCheckBy("");
        target.setFinishFlag("");

        target.getRowId();
        target.getConsumeNo();
        target.getConsumeItemNo();
        target.getOrderType();
        target.getPlant();
        target.getWarehouseCode();
        target.getWarehouseName();
        target.getLocation();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getUnit();
        target.getVendorCode();
        target.getVendorName();
        target.getDeliveryCode();
        target.getDeliveryName();
        target.getDeliveryDate();
        target.getCreateBy();
        target.getCreateDate();
        target.getModifyBy();
        target.getModifyDate();
        target.getFlag();
        target.getVersion();
        target.getRequireQty();
        target.getOrderClose();
        target.getPresacnFlag();
        target.getCheckFlag();
        target.getFinishQty();
        target.getCheckDate();
        target.getCheckBy();
        target.getFinishFlag();
    }
}