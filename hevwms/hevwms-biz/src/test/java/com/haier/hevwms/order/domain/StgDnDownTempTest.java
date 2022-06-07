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
public class StgDnDownTempTest {
    @Test
    public void test() {
        StgDnDownTemp target = new StgDnDownTemp();
        Date date = new Date();
        target.setRowId(0L);
        target.setDnNo("");
        target.setDnItemNo("");
        target.setSellNo("");
        target.setSellOrderType("");
        target.setPlant("");
        target.setDnDocDate("");
        target.setDnLastModifyDate("");
        target.setDnCreateBy("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setQty(0L);
        target.setLocation("");
        target.setCustomerNo("");
        target.setCustomerName("");
        target.setDeliveryCode("");
        target.setDeliveryName("");
        target.setDeliveryDate("");
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setVersion(0L);
        target.setDnClose("");
        target.setFinishQty(0L);
        target.setUnit("");
        target.setDeliverDate("");
        target.setBilling("");
        target.setBillingItem("");
        target.setFinishFlag("");
        target.setFlag("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setRegion("");
        target.setCity("");
        target.setStno(0L);
        target.setDealFlag("");
        target.setDealTime(date);
        target.setDealDesc("");
        target.setSapFlag("");
        target.setSapMsg("");
        target.setSapDocNo("");

        target.getRowId();
        target.getDnNo();
        target.getDnItemNo();
        target.getSellNo();
        target.getSellOrderType();
        target.getPlant();
        target.getDnDocDate();
        target.getDnLastModifyDate();
        target.getDnCreateBy();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getQty();
        target.getLocation();
        target.getCustomerNo();
        target.getCustomerName();
        target.getDeliveryCode();
        target.getDeliveryName();
        target.getDeliveryDate();
        target.getCreateDate();
        target.getModifyDate();
        target.getVersion();
        target.getDnClose();
        target.getFinishQty();
        target.getUnit();
        target.getDeliverDate();
        target.getBilling();
        target.getBillingItem();
        target.getFinishFlag();
        target.getFlag();
        target.getCreateBy();
        target.getModifyBy();
        target.getRegion();
        target.getCity();
        target.getStno();
        target.getDealFlag();
        target.getDealTime();
        target.getDealDesc();
        target.getSapFlag();
        target.getSapMsg();
        target.getSapDocNo();

    }
}