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
public class CdFactoryTest {
    @Test
    public void test() {
        CdFactory target = new CdFactory();
        target.setRowId(0L);
        target.setCode("");
        target.setName("");
        target.setDeptCode("");
        target.setDeptName("");
        target.setSalesCode("");
        target.setSalesName("");
        target.setCreatedBy("");
        target.setCreatedDate("");
        target.setModifyBy("");
        target.setModifyDate("");
        target.setVersion(0L);
        target.setPurCode("");
        target.setPurName("");
        target.setGmtCreate(new Date());
        target.setGmtModified(new Date());
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getRowId();
        target.getCode();
        target.getName();
        target.getDeptCode();
        target.getDeptName();
        target.getSalesCode();
        target.getSalesName();
        target.getCreatedBy();
        target.getCreatedDate();
        target.getModifyBy();
        target.getModifyDate();
        target.getVersion();
        target.getPurCode();
        target.getPurName();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}