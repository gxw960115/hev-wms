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
public class OdsMoveInventoryTest {
    @Test
    public void test() {
        OdsMoveInventory target = new OdsMoveInventory();
        Date date = new Date();
        target.setRowId(0L);
        target.setPlant("");
        target.setBarcode("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setUnit("");
        target.setQty(0L);
        target.setSourceLocation("");
        target.setTargeLocation("");
        target.setSapFlag("");
        target.setSapMsg("");
        target.setSapDocNo("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setInSapFlag("");
        target.setSerialNo("");
        target.setSourceSubLocation("");
        target.setTargeSubLocation("");
        target.setFinishFlag("");
        target.setSapSendId(0L);
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getRowId();
        target.getPlant();
        target.getBarcode();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getUnit();
        target.getQty();
        target.getSourceLocation();
        target.getTargeLocation();
        target.getSapFlag();
        target.getSapMsg();
        target.getSapDocNo();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getInSapFlag();
        target.getSerialNo();
        target.getSourceSubLocation();
        target.getTargeSubLocation();
        target.getFinishFlag();
        target.getSapSendId();
        target.getCreateDate();
        target.getModifyDate();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}