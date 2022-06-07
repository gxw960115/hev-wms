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
public class DnOrderIgpInTest {

    @Test
    public void test() {
        DnOrderIgpIn in = new DnOrderIgpIn();
        in.setResDt("");
        in.setGooddt("");
        in.setCrmdt("");
        in.setReasondt("");
        in.setUser("");
        in.setSign("");
        in.setDoctype("");
        in.setOrdertype("");
        in.setOrno("");
        in.setLocation("");
        in.setPostingdate("");
        in.setCarno("");
        in.setVersion("");

        in.getResDt();
        in.getGooddt();
        in.getCrmdt();
        in.getReasondt();
        in.getUser();
        in.getSign();
        in.getDoctype();
        in.getOrdertype();
        in.getOrno();
        in.getLocation();
        in.getPostingdate();
        in.getCarno();
        in.getVersion();
    }
}
