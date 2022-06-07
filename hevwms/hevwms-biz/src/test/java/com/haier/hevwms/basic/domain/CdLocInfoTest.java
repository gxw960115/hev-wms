package com.haier.hevwms.basic.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.basic.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/19 13:48
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class CdLocInfoTest {
    @Test
    public void test() {
        CdLocInfo target = new CdLocInfo();
        Date date = new Date();
        target.setChkDisabled("");
        target.setLocationType("");
        target.setRowId(0L);
        target.setName("");
        target.setCode("");
        target.setParentId(0L);
        target.setCreateBy("");
        target.setModifyBy("");
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setFlag("");
        target.setVersion(0L);
        target.setWhCode("");
        target.setWhName("");
        target.setChecked(false);
        target.setCityCode("");
        target.setCityName("");
        target.setRemark("");
        target.setNameFat("");
        target.setValidArea(0.0F);
        target.setHeight(0.0F);
        target.setRentFee(0.0F);
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getChkDisabled();
        target.getLocationType();
        target.getRowId();
        target.getName();
        target.getCode();
        target.getParentId();
        target.getCreateBy();
        target.getModifyBy();
        target.getCreateDate();
        target.getModifyDate();
        target.getFlag();
        target.getVersion();
        target.getWhCode();
        target.getWhName();
        target.isChecked();
        target.getCityCode();
        target.getCityName();
        target.getRemark();
        target.getNameFat();
        target.getValidArea();
        target.getHeight();
        target.getRentFee();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();
    }
}