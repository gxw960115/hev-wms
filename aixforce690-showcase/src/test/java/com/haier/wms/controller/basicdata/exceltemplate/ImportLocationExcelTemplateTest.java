package com.haier.wms.controller.basicdata.exceltemplate;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 14:29
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({WorkbookFactory.class,File.class})
public class ImportLocationExcelTemplateTest {

    private ImportLocationExcelTemplate importLocationExcelTemplate = new ImportLocationExcelTemplate();

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
            importLocationExcelTemplate.importInfo(new byte[10],"111");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}