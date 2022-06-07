package com.haier.hevwms.remoting.rf.domain.order;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 * <p>
 * description:
 *
 * @author LiuJiazhen
 * @version v1.0.0
 * @date 2019/11/26 16:57
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/11/26      LJZ     v1.0.0      create
 */
public class SubLocationTest {

    @Test
    public void test() {
        SubLocation loc = new SubLocation();
        loc.setCode("");
        loc.setDesc("");

        loc.getCode();
        loc.getDesc();
    }
}
