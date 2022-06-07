package com.haier.hevwms.customer.domain;
import java.util.Date;

import org.junit.Test;

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
public class OdsCustomerOrderTest {
    @Test
    public void test() {
        OdsCustomerOrder target = new OdsCustomerOrder();
        Date date = new Date();
        target.setRowId(0L);
        target.setCtrOrderNo("");
        target.setCtrItemNo("");
        target.setOrderType("");
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
        target.setCreateDate(date);
        target.setModifyBy("");
        target.setModifyDate(date);
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
        target.setBin("");
        target.setSapFlag("");
        target.setSapMsg("");
        target.setMatDoc("");
        target.setDocYear("");
        target.setPostingDate("");
        target.setInOutFlag("");
        target.setInOutMsg("");
        target.setCustomerCode("");
        target.setCustomerName("");
        target.setBegin("");
        target.setEnd("");
        target.setBasicUnit("");

        target.getRowId();
        target.getCtrOrderNo();
        target.getCtrItemNo();
        target.getOrderType();
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
        target.getCreateDate();
        target.getModifyBy();
        target.getModifyDate();
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
        target.getBin();
        target.getSapFlag();
        target.getSapMsg();
        target.getMatDoc();
        target.getDocYear();
        target.getPostingDate();
        target.getInOutFlag();
        target.getInOutMsg();
        target.getCustomerCode();
        target.getCustomerName();
        target.getBegin();
        target.getEnd();
        target.getBasicUnit();
    }
}