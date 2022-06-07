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
 * @Date 2019/3/19 13:49
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/19      LJZ     v1.0.0      create
 */
public class CdWhInfoTest {
    @Test
    public void test() {
        CdWhInfo target = new CdWhInfo();
        String[] strings = new String[1];
        Date date = new Date();
        target.setRowId(0L);
        target.setName("");
        target.setCode("");
        target.setCreateBy("");
        target.setModifyBy("");
        target.setFlag("");
        target.setVersion(0L);
        target.setCreateDate(date);
        target.setModifyDate(date);
        target.setChildren(strings);
        target.setLocations("");
        target.setRemark("");
        target.setNameFat("");
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getRowId();
        target.getName();
        target.getCode();
        target.getCreateBy();
        target.getModifyBy();
        target.getFlag();
        target.getVersion();
        target.getCreateDate();
        target.getModifyDate();
        target.getChildren();
        target.getLocations();
        target.getRemark();
        target.getNameFat();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}