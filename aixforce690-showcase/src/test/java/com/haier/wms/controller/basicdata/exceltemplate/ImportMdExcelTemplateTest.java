package com.haier.wms.controller.basicdata.exceltemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 14:32
 * @Description:
 */
@RunWith(PowerMockRunner.class)
public class ImportMdExcelTemplateTest {

    private ImportMdExcelTemplate importMdExcelTemplate = new ImportMdExcelTemplate();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void importMdMatInfo() {
        try {
            importMdExcelTemplate.importMdMatInfo(new byte[10],"111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}