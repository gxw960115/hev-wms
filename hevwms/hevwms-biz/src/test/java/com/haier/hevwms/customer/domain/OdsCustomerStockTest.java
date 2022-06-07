package com.haier.hevwms.customer.domain;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.customer.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 13:51
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsCustomerStockTest {
    @Test
    public void test() {
        OdsCustomerStock target = new OdsCustomerStock();
        Date date = new Date();
        target.setRowId(0L);
        target.setPlant("");
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
        target.setCreateDate(date);
        target.setModifyBy("");
        target.setModifyDate(date);
        target.setFlag("");
        target.setVersion(0L);
        target.setQty(0L);
        target.setUseQty(0L);
        target.setPallet("");
        target.setSubLocation("");
        target.setSubLocationFlag("");
        target.setBatchTime(0L);
        target.setFirstInDate(date);
        target.setRemark("");
        target.setLockFlag("");
        target.setBin("");

        target.getRowId();
        target.getPlant();
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
        target.getCreateDate();
        target.getModifyBy();
        target.getModifyDate();
        target.getFlag();
        target.getVersion();
        target.getQty();
        target.getUseQty();
        target.getPallet();
        target.getSubLocation();
        target.getSubLocationFlag();
        target.getBatchTime();
        target.getFirstInDate();
        target.getRemark();
        target.getLockFlag();
        target.getBin();
    }
}