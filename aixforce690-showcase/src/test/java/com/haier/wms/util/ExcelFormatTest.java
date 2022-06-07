package com.haier.wms.util;

import org.apache.poi.ss.usermodel.Cell;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/17 18:02
 * @Description:
 */
public class ExcelFormatTest {

    private ExcelFormat excelFormat =new ExcelFormat();
    private Cell cell;

    @Before
    public void init(){
        cell = EasyMock.createMock(Cell.class);
    }

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