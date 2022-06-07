package com.haier.wms.controller.basicdata.exceltemplate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 15:00
 * @Description:
 */
public class ImportWarehouseExcelTemplateTest {

    private ImportWarehouseExcelTemplate importWarehouseExcelTemplate = new ImportWarehouseExcelTemplate();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void importInfo() {
        try {
            importWarehouseExcelTemplate.importInfo(new byte[10],"111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}