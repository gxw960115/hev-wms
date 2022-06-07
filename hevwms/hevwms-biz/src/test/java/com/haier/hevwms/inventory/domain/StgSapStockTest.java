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
 * @Date 2019/3/19 21:01
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class StgSapStockTest {
    @Test
    public void test() {
        StgSapStock target = new StgSapStock();
        Date date = new Date();
        target.setUserType("");
        target.setUserId(0L);
        target.setBegin("");
        target.setEnd("");
        target.setRowId(0L);
        target.setLocation("");
        target.setSapDownDate("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setQty(0L);
        target.setUnit("");
        target.setBatchNo("");
        target.setVersion(0L);
        target.setPlant("");
        target.setCustomerModel("");
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
        target.getLocation();
        target.getSapDownDate();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getQty();
        target.getUnit();
        target.getBatchNo();
        target.getVersion();
        target.getPlant();
        target.getCustomerModel();
        target.getCreateDate();
        target.getModifyDate();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}