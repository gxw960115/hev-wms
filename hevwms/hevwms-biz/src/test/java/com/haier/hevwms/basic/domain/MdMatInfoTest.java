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
public class MdMatInfoTest {
    @Test
    public void test() {
        MdMatInfo target = new MdMatInfo();
        target.setCbm(0L);
        target.setRowId(0L);
        target.setMaterialNo("");
        target.setCustomerModel("");
        target.setMaterialDesp("");
        target.setPlant("");
        target.setExternalMatGroup("");
        target.setGrossWeight("");
        target.setNetWeight("");
        target.setSizeDimension("");
        target.setBasicUnit("");
        target.setPlantStatus("");
        target.setDivision("");
        target.setProduceAttribute("");
        target.setModifyDate(new Date());
        target.setVersion(0L);
        target.setActivestate("");
        target.setCreatedBy("");
        target.setCreatedDate(new Date());
        target.setModifyBy("");
        target.setRemark("");
        target.setInOut("");
        target.setProduceModel("");
        target.setMatScanType("");
        target.setLength(0.0D);
        target.setWidth(0.0D);
        target.setHigth(0.0D);

        target.getCbm();
        target.getRowId();
        target.getMaterialNo();
        target.getCustomerModel();
        target.getMaterialDesp();
        target.getPlant();
        target.getExternalMatGroup();
        target.getGrossWeight();
        target.getNetWeight();
        target.getSizeDimension();
        target.getBasicUnit();
        target.getPlantStatus();
        target.getDivision();
        target.getProduceAttribute();
        target.getModifyDate();
        target.getVersion();
        target.getActivestate();
        target.getCreatedBy();
        target.getCreatedDate();
        target.getModifyBy();
        target.getRemark();
        target.getInOut();
        target.getProduceModel();
        target.getMatScanType();
        target.getLength();
        target.getWidth();
        target.getHigth();

    }
}