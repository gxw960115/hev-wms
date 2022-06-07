package com.haier.hevwms.takestock.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.takestock.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 14:07
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class OdsPdDiffDtlTest {
    @Test
    public void test() {
        OdsPdDiffDtl target = new OdsPdDiffDtl();
        Date date = new Date();
        target.setBegin("");
        target.setEnd("");
        target.setRowId(0L);
        target.setOrderNo("");
        target.setPlant("");
        target.setCustomerModel("");
        target.setLocation("");
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setDiffType("");
        target.setUnit("");
        target.setBarcode("");
        target.setInoutDate(date);
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setSubLocation("");
        target.setQty(0L);
        target.setInveSubLocation("");
        target.setProcessFlag("");
        target.setProcessReason("");
        target.setUserType("");
        target.setUserId(0L);
        target.setCreateDate(date);
        target.setModifyDate(date);

        target.getBegin();
        target.getEnd();
        target.getRowId();
        target.getOrderNo();
        target.getPlant();
        target.getCustomerModel();
        target.getLocation();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getDiffType();
        target.getUnit();
        target.getBarcode();
        target.getInoutDate();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getSubLocation();
        target.getQty();
        target.getInveSubLocation();
        target.getProcessFlag();
        target.getProcessReason();
        target.getUserType();
        target.getUserId();
        target.getCreateDate();
        target.getModifyDate();

    }
}