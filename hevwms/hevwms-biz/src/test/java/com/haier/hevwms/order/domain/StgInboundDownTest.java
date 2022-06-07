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
public class StgInboundDownTest {
    @Test
    public void test() {
        StgInboundDown target = new StgInboundDown();
        target.setFinishQty(0L);
        target.setBegin("");
        target.setEnd("");
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
        target.setCreateDate(new Date());
        target.setModifyDate(new Date());
        target.setVersion(0L);
        target.setDeliverDate("");
        target.setCreateBy("");
        target.setUnit("");
        target.setUserType("");
        target.setUserId(0L);
        target.setFinishFlag("");

        target.getFinishQty();
        target.getBegin();
        target.getEnd();
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
        target.getCreateDate();
        target.getModifyDate();
        target.getVersion();
        target.getDeliverDate();
        target.getCreateBy();
        target.getUnit();
        target.getUserType();
        target.getUserId();
        target.getFinishFlag();

    }
}