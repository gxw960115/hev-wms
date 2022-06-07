package com.haier.hevwms.transfer.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.transfer.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 10:21
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class OdsTransferInfoTest {
    @Test
    public void test() {
        OdsTransferInfo target = new OdsTransferInfo();
        Date date = new Date();
        target.setRowId(0L);
        target.setTransNo("");
        target.setTransItemNo("");
        target.setQty(0L);
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setCustomerModel("");
        target.setItemDelete("");
        target.setUnit("");
        target.setPlant("");
        target.setGiLocation("");
        target.setGrLocation("");
        target.setTransClose("");
        target.setFlag("");
        target.setCreateDate(date);
        target.setCreateBy("");
        target.setModifyDate(date);
        target.setModifyBy("");
        target.setGiDate("");
        target.setGiFlag("");
        target.setVersion(0L);
        target.setFinishQty(0L);
        target.setFinishFlag("");
        target.setOrderStatus("");
        target.setOrderType("");
        target.setWarehouseCode("");
        target.setWarehouseName("");
        target.setBeginDate(date);
        target.setEndDate(date);
        target.setSapFlag("");
        target.setSapMsg("");
        target.setSapDocNo("");
        target.setRemark("");
        target.setPrescanFlag("");
        target.setCheckFlag("");
        target.setCheckBy("");
        target.setBegin("");
        target.setEnd("");

        target.getRowId();
        target.getTransNo();
        target.getTransItemNo();
        target.getQty();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getCustomerModel();
        target.getItemDelete();
        target.getUnit();
        target.getPlant();
        target.getGiLocation();
        target.getGrLocation();
        target.getTransClose();
        target.getFlag();
        target.getCreateDate();
        target.getCreateBy();
        target.getModifyDate();
        target.getModifyBy();
        target.getGiDate();
        target.getGiFlag();
        target.getVersion();
        target.getFinishQty();
        target.getFinishFlag();
        target.getOrderStatus();
        target.getOrderType();
        target.getWarehouseCode();
        target.getWarehouseName();
        target.getBeginDate();
        target.getEndDate();
        target.getSapFlag();
        target.getSapMsg();
        target.getSapDocNo();
        target.getRemark();
        target.getPrescanFlag();
        target.getCheckFlag();
        target.getCheckBy();
        target.getBegin();
        target.getEnd();

    }
}