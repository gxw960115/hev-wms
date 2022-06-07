package com.haier.hevwms.sto.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.sto.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 10:16
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class StgStoDownTest {
    @Test
    public void test() {
        StgStoDown target = new StgStoDown();
        target.setGrFinishQty(0L);
        target.setGiFinishQty(0L);
        target.setBegin("");
        target.setEnd("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setRowId(0L);
        target.setStoNo("");
        target.setStoItemNo("");
        target.setGiPlant("");
        target.setGrPlant("");
        target.setPurOrg("");
        target.setStoDocDate("");
        target.setStoLastModifyDate("");
        target.setStoCreateBy("");
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setQty(0L);
        target.setItemDeltet("");
        target.setStoClose("");
        target.setGrLocation("");
        target.setGrDate("");
        target.setGiLocation("");
        target.setGiDate("");
        target.setCreateDate(new Date());
        target.setModifyDate(new Date());
        target.setVersion(0L);
        target.setUnit("");
        target.setPrescanFlag("");
        target.setUserType("");
        target.setUserId(0L);
        target.setGiFinishFlag("");
        target.setFlag("");
        target.setGrFinishFlag("");
        target.setCheckFlag("");
        target.setStoDnNo("");

        target.getGrFinishQty();
        target.getGiFinishQty();
        target.getBegin();
        target.getEnd();
        target.getCreateBy();
        target.getModifyBy();
        target.getRowId();
        target.getStoNo();
        target.getStoItemNo();
        target.getGiPlant();
        target.getGrPlant();
        target.getPurOrg();
        target.getStoDocDate();
        target.getStoLastModifyDate();
        target.getStoCreateBy();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getQty();
        target.getItemDeltet();
        target.getStoClose();
        target.getGrLocation();
        target.getGrDate();
        target.getGiLocation();
        target.getGiDate();
        target.getCreateDate();
        target.getModifyDate();
        target.getVersion();
        target.getUnit();
        target.getPrescanFlag();
        target.getUserType();
        target.getUserId();
        target.getGiFinishFlag();
        target.getFlag();
        target.getGrFinishFlag();
        target.getCheckFlag();
        target.getStoDnNo();

    }
}