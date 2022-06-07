package com.haier.hevwms.so.domain;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.so.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 13:53
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class OdsSoGrInfoTest {

    @Test
    public void Test1() {
        OdsSoGrInfo target = new OdsSoGrInfo();

        Object obj = new Object();
        Date date = new Date();
        target.setRowId(0L);
        target.setOrderNo(obj);
        target.setOrderItem(obj);
        target.setOrderType(obj);
        target.setSapOrderNo(obj);
        target.setSapOrderItem(obj);
        target.setBatchNo(obj);
        target.setPlant(obj);
        target.setWarehouseCode(obj);
        target.setWarehouseName(obj);
        target.setLocation(obj);
        target.setMaterialNo(obj);
        target.setCustomerModel(obj);
        target.setMaterialDesp(obj);
        target.setScannedQty(new BigDecimal("0"));
        target.setUnit(obj);
        target.setVendorCode(obj);
        target.setVendorName(obj);
        target.setDeliveryCode(obj);
        target.setDeliveryName(obj);
        target.setDeliveryDate(date);
        target.setCarNo(obj);
        target.setHandFlag(obj);
        target.setCreateBy(obj);
        target.setCreateDate(date);
        target.setModifyBy(obj);
        target.setModifyDate(date);
        target.setFlag(obj);
        target.setVersion(new BigDecimal("0"));
        target.setSapFlag(obj);
        target.setSapMsg(obj);
        target.setSapDocNo(obj);
        target.setSapSendId(new BigDecimal("0"));
        target.setPostingDate(obj);
        target.setInOutFlag(obj);
        target.setInOutMsg(obj);
        target.setRequireQty(new BigDecimal("0"));
        target.setOrderClose(obj);
        target.setCarId(new BigDecimal("0"));
        target.setPresacnFlag(obj);
        target.setCheckFlag(obj);
        target.setCarFlag(obj);
        target.setHandPostFlag(obj);
        target.setVechileType(obj);
        target.setInvoiceNo(obj);
        target.setLrNo(obj);
        target.setLrDate(obj);
        target.setTransporterCode(obj);
        target.setSapDocYear("");
        target.setDnNo(obj);
        target.setDnItemNo(obj);

        target.getRowId();
        target.getOrderNo();
        target.getOrderItem();
        target.getOrderType();
        target.getSapOrderNo();
        target.getSapOrderItem();
        target.getBatchNo();
        target.getPlant();
        target.getWarehouseCode();
        target.getWarehouseName();
        target.getLocation();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getScannedQty();
        target.getUnit();
        target.getVendorCode();
        target.getVendorName();
        target.getDeliveryCode();
        target.getDeliveryName();
        target.getDeliveryDate();
        target.getCarNo();
        target.getHandFlag();
        target.getCreateBy();
        target.getCreateDate();
        target.getModifyBy();
        target.getModifyDate();
        target.getFlag();
        target.getVersion();
        target.getSapFlag();
        target.getSapMsg();
        target.getSapDocNo();
        target.getSapSendId();
        target.getPostingDate();
        target.getInOutFlag();
        target.getInOutMsg();
        target.getRequireQty();
        target.getOrderClose();
        target.getCarId();
        target.getPresacnFlag();
        target.getCheckFlag();
        target.getCarFlag();
        target.getHandPostFlag();
        target.getVechileType();
        target.getInvoiceNo();
        target.getLrNo();
        target.getLrDate();
        target.getTransporterCode();
        target.getSapDocYear();
        target.getDnNo();
        target.getDnItemNo();
    }
}