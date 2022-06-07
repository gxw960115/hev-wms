package com.haier.wms.controller.order;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/17 17:57
 * @Description:
 */
public class ImportOpsiBrunchExcelTemplateTest {

    private ImportOpsiBrunchExcelTemplate importOpsiBrunchExcelTemplate = new ImportOpsiBrunchExcelTemplate();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void importExcel() {
        try {
            importOpsiBrunchExcelTemplate.importExcel(new byte[11]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}