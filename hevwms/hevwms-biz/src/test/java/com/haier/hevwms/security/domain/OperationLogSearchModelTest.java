package com.haier.hevwms.security.domain;

import org.junit.Test;

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
public class OperationLogSearchModelTest {

    @Test
    public void test() {
        OperationLogSearchModel model = new OperationLogSearchModel();
        model.setFrom(model.getFrom());
        model.setTo(model.getTo());
        model.setOperationLog(model.getOperationLog());
    }

}
