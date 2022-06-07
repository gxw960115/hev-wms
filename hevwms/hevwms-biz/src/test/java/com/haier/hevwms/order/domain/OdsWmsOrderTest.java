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
public class OdsWmsOrderTest {
    @Test
    public void test() {
        OdsWmsOrder target = new OdsWmsOrder();
        Date date = new Date();
        target.setUserType("");
        target.setUserId(0L);
        target.setRowId(0L);
        target.setWmsOrderNo("");
        target.setWmsOrderItem("");
        target.setOrderType("");
        target.setDocTpye("");
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
        target.setModifyBy("");
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
        target.setBegin("");
        target.setEnd("");
        target.setCreateDate(date);
        target.setModifyDate(date);

        target.getUserType();
        target.getUserId();
        target.getRowId();
        target.getWmsOrderNo();
        target.getWmsOrderItem();
        target.getOrderType();
        target.getDocTpye();
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
        target.getModifyBy();
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
        target.getBegin();
        target.getEnd();
        target.getCreateDate();
        target.getModifyDate();
    }
}