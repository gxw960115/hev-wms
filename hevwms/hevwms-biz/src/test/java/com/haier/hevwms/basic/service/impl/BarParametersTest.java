package com.haier.hevwms.basic.service.impl;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 * <p>
 * description:
 *
 * @author LiuJiazhen
 * @version v1.0.0
 * @date 2019/11/26 15:54
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/11/26      LJZ     v1.0.0      create
 */
public class BarParametersTest {

    @Test
    public void test1() {
        BarParameters bar = new BarParameters();

        bar.setDayCode(bar.getDayCode());
        bar.setMonthCode(bar.getMonthCode());
        bar.setYearCode(bar.getYearCode());
    }

}
