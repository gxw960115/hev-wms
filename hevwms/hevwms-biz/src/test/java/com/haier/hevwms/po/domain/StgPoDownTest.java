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
public class StgPoDownTest {
    @Test
    public void test() {
        StgPoDown target = new StgPoDown();
        Date date = new Date();
        target.setBegin("");
        target.setEnd("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setRowId(0L);
        target.setPoNo("");
        target.setPoItemNo("");
        target.setPoType("");
        target.setInboundFlag("");
        target.setPlant("");
        target.setPoDocDate("");
        target.setPoLastModifyDate("");
        target.setPoCreateBy("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setQty(0L);
        target.setPoLocation("");
        target.setItemDeltet("");
        target.setPoClose("");
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setVersion(0L);
        target.setDeliverDate("");
        target.setUnit("");
        target.setFinishQty("");
        target.setUserType("");
        target.setUserId(0L);
        target.setFinishFlag("");
        target.setVendorCode("");
        target.setVendorName("");
        target.setOrderUnit("");
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getBegin();
        target.getEnd();
        target.getCreateBy();
        target.getModifyBy();
        target.getRowId();
        target.getPoNo();
        target.getPoItemNo();
        target.getPoType();
        target.getInboundFlag();
        target.getPlant();
        target.getPoDocDate();
        target.getPoLastModifyDate();
        target.getPoCreateBy();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getQty();
        target.getPoLocation();
        target.getItemDeltet();
        target.getPoClose();
        target.getCreateDate();
        target.getModifyDate();
        target.getVersion();
        target.getDeliverDate();
        target.getUnit();
        target.getFinishQty();
        target.getUserType();
        target.getUserId();
        target.getFinishFlag();
        target.getVendorCode();
        target.getVendorName();
        target.getOrderUnit();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();
    }
}