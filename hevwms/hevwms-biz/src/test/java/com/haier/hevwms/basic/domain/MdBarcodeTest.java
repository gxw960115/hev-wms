package com.haier.hevwms.basic.domain;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.basic.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 14:22
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class MdBarcodeTest {
    @Test
    public void test() {
        MdBarcode target = new MdBarcode();
        target.setBarcodeNum(0L);
        target.setProductLine("");
        target.setBarFlag("");
        target.setCreateDateB("");
        target.setCreateDateE("");
        target.setBarCodeNum("");
        target.setCreateDate("");
        target.setRowId(0L);
        target.setMaterialNo("");
        target.setMaterialDesp("");
        target.setBarcode("");
        target.setStNo("");
        target.setCreateBy("");

        target.getBarcodeNum();
        target.getProductLine();
        target.getBarFlag();
        target.getCreateDateB();
        target.getCreateDateE();
        target.getBarCodeNum();
        target.getCreateDate();
        target.getRowId();
        target.getMaterialNo();
        target.getMaterialDesp();
        target.getBarcode();
        target.getStNo();
        target.getCreateBy();

    }
}