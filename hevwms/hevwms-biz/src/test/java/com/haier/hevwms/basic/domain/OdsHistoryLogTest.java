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
public class OdsHistoryLogTest {
    @Test
    public void test() {
        OdsHistoryLog target = new OdsHistoryLog();
        Date date = new Date();
        target.setRowId(0L);
        target.setOperationBy("");
        target.setOperationDate(date);
        target.setOperationCode("");
        target.setOperationContent("");
        target.setCreateBy("");
        target.setCreateDate(date);
        target.setGmtCreate(date);
        target.setGmtModified(date);
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getRowId();
        target.getOperationBy();
        target.getOperationDate();
        target.getOperationCode();
        target.getOperationContent();
        target.getCreateBy();
        target.getCreateDate();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}