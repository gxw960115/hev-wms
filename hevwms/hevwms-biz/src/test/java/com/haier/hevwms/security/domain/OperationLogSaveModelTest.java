package com.haier.hevwms.security.domain;

import org.junit.Test;

import java.util.Date;

/**
 * Copyright © 2019 LiuJiazhen
 * <p>
 * description:
 *
 * @author LiuJiazhen
 * @version v1.0.0
 * @date 2019/11/26 16:08
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/11/26      LJZ     v1.0.0      create
 */
public class OperationLogSaveModelTest {

    @Test
    public void test() {
        OperationLogSaveModel model = new OperationLogSaveModel();
        model.gmtCreate = null;
        model.gmtModified = null;
        model.setGmtCreate(model.getGmtCreate());
        model.setGmtModified(model.getGmtModified());

        Date date = new Date();
        model.setGmtModified(date);
        model.setGmtCreate(date);
        model.getGmtCreate();
        model.getGmtModified();
    }

}
