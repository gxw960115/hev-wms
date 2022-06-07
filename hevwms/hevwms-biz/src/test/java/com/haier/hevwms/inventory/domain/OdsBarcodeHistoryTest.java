package com.haier.hevwms.inventory.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.inventory.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 21:00
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsBarcodeHistoryTest {
    @Test
    public void test() {
        OdsBarcodeHistory target = new OdsBarcodeHistory();
        Date date = new Date();

        target.setUserType("");
        target.setUserId(0L);
        target.setBegin("");
        target.setEnd("");
        target.setRowId(0L);
        target.setPlant("");
        target.setWarehouseCode("");
        target.setWarehouseName("");
        target.setCustomerModel("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setUnit("");
        target.setBarcode("");
        target.setInoutType("");
        target.setInoutDate(date);
        target.setOrderItem("");
        target.setDocTpye("");
        target.setSapOrderNo("");
        target.setSapOrderItem("");
        target.setBatchNo("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setOrderNo("");
        target.setQty(0L);
        target.setSubLocation("");
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
        target.getPlant();
        target.getWarehouseCode();
        target.getWarehouseName();
        target.getCustomerModel();
        target.getLocation();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getUnit();
        target.getBarcode();
        target.getInoutType();
        target.getInoutDate();
        target.getOrderItem();
        target.getDocTpye();
        target.getSapOrderNo();
        target.getSapOrderItem();
        target.getBatchNo();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getOrderNo();
        target.getQty();
        target.getSubLocation();
        target.getCreateDate();
        target.getModifyDate();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}