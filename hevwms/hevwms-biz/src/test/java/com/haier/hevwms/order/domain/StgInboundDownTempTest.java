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
public class StgInboundDownTempTest {
    @Test
    public void test() {
        StgInboundDownTemp target = new StgInboundDownTemp();
        target.setRowId(0L);
        target.setPoNo("");
        target.setPoItemNo("");
        target.setInboundDeliveryNo("");
        target.setIndCreateDate("");
        target.setIndLastModifyDate("");
        target.setInboundItemNo("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setQty(0L);
        target.setInboundLocation("");
        target.setVersion(0L);
        target.setUnit("");
        target.setDeliverDate("");
        target.setStno(0L);
        target.setDealFlag("");
        target.setDealTime(new Date());
        target.setDealDesc("");
        target.setCreateDate(new Date());


        target.getRowId();
        target.getPoNo();
        target.getPoItemNo();
        target.getInboundDeliveryNo();
        target.getIndCreateDate();
        target.getIndLastModifyDate();
        target.getInboundItemNo();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getQty();
        target.getInboundLocation();
        target.getVersion();
        target.getUnit();
        target.getDeliverDate();
        target.getStno();
        target.getDealFlag();
        target.getDealTime();
        target.getDealDesc();
        target.getCreateDate();

    }
}