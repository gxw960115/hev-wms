package com.haier.hevwms.basic.service.impl;

import com.sap.conn.jco.JCoDestinationManager;
import io.terminus.pampas.common.UserUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/13 15:21
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {HSSFCell.class})
public class ExcelFormatTest {

    private ExcelFormat excelFormat = new ExcelFormat();
    private HSSFCell cell;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        cell = EasyMock.createMock(HSSFCell.class);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void formatCellToString() {
        EasyMock.expect(cell.getCellType()
        )
                .andReturn(0).times(1)
                .andReturn(2).times(1)
                .andReturn(3).times(1)
                .andReturn(4).times(1)
                .andReturn(5).times(1);
        EasyMock.expect(cell.getNumericCellValue()).andReturn(1D).times(2);
        EasyMock.expect(cell.getBooleanCellValue()).andReturn(true).times(1);
        EasyMock.replay(cell);
        excelFormat.formatCellToString(cell);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void formatCellToDouble() {
        EasyMock.expect(cell.getCellType()
        )
                .andReturn(0).times(1)
                .andReturn(2).times(1)
                .andReturn(3).times(1)
                .andReturn(4).times(1)
                .andReturn(5).times(1);
        EasyMock.expect(cell.getNumericCellValue()).andReturn(1D).times(2);
        EasyMock.expect(cell.getBooleanCellValue()).andReturn(true).times(1);
        EasyMock.replay(cell);
        excelFormat.formatCellToDouble(cell);
    }
}