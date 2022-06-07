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
public class MdDictionaryTest {
    @Test
    public void test() {
        MdDictionary target = new MdDictionary();
        target.setFlag("");
        target.setId(0L);
        target.setCode("");
        target.setName("");
        target.setKindCode("");
        target.setKindDescription("");
        target.setSort(0L);
        target.setNameFat("");
        target.setGmtCreate(new Date());
        target.setGmtModified(new Date());
        target.setCreateBy("");
        target.setLastModifiedBy("");

        target.getFlag();
        target.getId();
        target.getCode();
        target.getName();
        target.getKindCode();
        target.getKindDescription();
        target.getSort();
        target.getNameFat();
        target.getId();
        target.getGmtCreate();
        target.getGmtModified();
        target.getCreateBy();
        target.getLastModifiedBy();

    }
}