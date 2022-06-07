package com.haier.hevwms.takestock.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.takestock.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 14:07
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class OdsPdInfoTest {
    @Test
    public void test() {
        OdsPdInfo target = new OdsPdInfo();
        Date date = new Date();
        target.setBegin("");
        target.setEnd("");
        target.setRowId(0L);
        target.setOrderNo("");
        target.setOrderType("");
        target.setOrderStatus("");
        target.setPlant("");
        target.setWarehouseCode("");
        target.setWarehouseName("");
        target.setCustomerModel("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setUnit("");
        target.setActualQty(0L);
        target.setBeginDate(date);
        target.setEndDate(date);
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setUserType("");
        target.setUserId(0L);
        target.setCreateDate(date);
        target.setModifyDate(date);

        target.getBegin();
        target.getEnd();
        target.getRowId();
        target.getOrderNo();
        target.getOrderType();
        target.getOrderStatus();
        target.getPlant();
        target.getWarehouseCode();
        target.getWarehouseName();
        target.getCustomerModel();
        target.getLocation();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getUnit();
        target.getActualQty();
        target.getBeginDate();
        target.getEndDate();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getUserType();
        target.getUserId();
        target.getCreateDate();
        target.getModifyDate();
    }
}