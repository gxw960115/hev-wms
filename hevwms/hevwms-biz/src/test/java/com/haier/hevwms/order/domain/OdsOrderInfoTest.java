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
public class OdsOrderInfoTest {
    @Test
    public void test() {
        OdsOrderInfo target = new OdsOrderInfo();
        Date date = new Date();
        target.setDivision("");
        target.setUserType("");
        target.setUserId(0L);
        target.setRowId(0L);
        target.setOrderNo("");
        target.setOrderItem("");
        target.setOrderType("");
        target.setDocTpye("");
        target.setSapOrderNo("");
        target.setSapOrderItem("");
        target.setBatchNo("");
        target.setPlant("");
        target.setWarehouseCode("");
        target.setWarehouseName("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setOrderQty(0L);
        target.setScannedQty(0L);
        target.setUnit("");
        target.setVendorCode("");
        target.setVendorName("");
        target.setDeliveryCode("");
        target.setDeliveryName("");
        target.setDeliveryDate(date);
        target.setCarNo("");
        target.setHandFlag("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setPostingDate("");
        target.setSapFlag("");
        target.setSapMsg("");
        target.setSapDocNo("");
        target.setTrueFlag(false);
        target.setSuccessFlag(false);
        target.setInOutFlag("");
        target.setInOutMsg("");
        target.setRequireQty(0L);
        target.setOrderClose("");
        target.setCarId(0L);
        target.setPresacnFlag("");
        target.setSapSendId(0L);
        target.setSapReturn("");
        target.setOut(null);
        target.setBegin("");
        target.setEnd("");
        target.setCheckFlag("");
        target.setCarFlag("");
        target.setHandPostFlag("");
        target.setInvoiceNo("");
        target.setLrNo("");
        target.setTransporterCode("");
        target.setTransporterName("");
        target.setLrDate("");
        target.setCreateDate(date);
        target.setModifyDate(date);

        target.getDivision();
        target.getUserType();
        target.getUserId();
        target.getRowId();
        target.getOrderNo();
        target.getOrderItem();
        target.getOrderType();
        target.getDocTpye();
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
        target.getOrderQty();
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
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getPostingDate();
        target.getSapFlag();
        target.getSapMsg();
        target.getSapDocNo();
        target.isTrueFlag();
        target.isSuccessFlag();
        target.getInOutFlag();
        target.getInOutMsg();
        target.getRequireQty();
        target.getOrderClose();
        target.getCarId();
        target.getPresacnFlag();
        target.getSapSendId();
        target.getSapReturn();
        target.getOut();
        target.getBegin();
        target.getEnd();
        target.getCheckFlag();
        target.getCarFlag();
        target.getHandPostFlag();
        target.getInvoiceNo();
        target.getLrNo();
        target.getTransporterCode();
        target.getTransporterName();
        target.getLrDate();
        target.getCreateDate();
        target.getModifyDate();
    }
}