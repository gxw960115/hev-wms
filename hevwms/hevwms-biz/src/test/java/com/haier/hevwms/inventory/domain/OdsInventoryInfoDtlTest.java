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
public class OdsInventoryInfoDtlTest {
    @Test
    public void test() {
        OdsInventoryInfoDtl target = new OdsInventoryInfoDtl();
        Date date = new Date();
        target.setBin("");
        target.setLockFlag("");
        target.setDivision("");
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
        target.setOrderNo("");
        target.setOrderItem("");
        target.setDocTpye("");
        target.setSapOrderNo("");
        target.setSapOrderItem("");
        target.setTotalStockDays(0L);
        target.setCurrentStockDays(0L);
        target.setBatchNo("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setQty(0L);
        target.setUseQty(0L);
        target.setPallet("");
        target.setSubLocation("");
        target.setWmsQty(0L);
        target.setSapQty(0L);
        target.setFirstInDate(date);
        target.setRemark("");
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setCustomerFlag("");
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getBin();
        target.getLockFlag();
        target.getDivision();
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
        target.getOrderNo();
        target.getOrderItem();
        target.getDocTpye();
        target.getSapOrderNo();
        target.getSapOrderItem();
        target.getTotalStockDays();
        target.getCurrentStockDays();
        target.getBatchNo();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getQty();
        target.getUseQty();
        target.getPallet();
        target.getSubLocation();
        target.getWmsQty();
        target.getSapQty();
        target.getFirstInDate();
        target.getRemark();
        target.getCreateDate();
        target.getModifyDate();
        target.getCustomerFlag();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}