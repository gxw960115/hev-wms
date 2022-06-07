package com.haier.hevwms.scrap.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.scrap.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 9:56
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class OdsScrapOrderTest {
    @Test
    public void test() {
        OdsScrapOrder target = new OdsScrapOrder();

        Date date = new Date();
        target.setRowId(0L);
        target.setScrapNo("");
        target.setScrapItemNo("");
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
        target.getDeliveryDate();
        target.setDeliveryDate(null);
        target.getDeliveryDate();
        target.setCreateBy("");
        target.setCreateDate(date);
        target.getCreateDate();
        target.setCreateDate(null);
        target.getCreateDate();
        target.setModifyBy("");
        target.setModifyDate(date);
        target.getModifyDate();
        target.setModifyDate(null);
        target.getModifyDate();
        target.setFlag("");
        target.setVersion(0L);
        target.setRequireQty(0L);
        target.setOrderClose("");
        target.setPresacnFlag("");
        target.setCheckFlag("");
        target.setFinishQty(0L);
        target.setCheckDate(date);
        target.getCheckDate();
        target.setCheckDate(null);
        target.getCheckDate();
        target.setCheckBy("");
        target.setFinishFlag("");

        target.getRowId();
        target.getScrapNo();
        target.getScrapItemNo();
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
        target.getPostingDate();
        target.setPostingDate("");
        target.getCostCenter();
        target.setCostCenter("");

    }
}
