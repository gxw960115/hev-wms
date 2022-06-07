package com.haier.wms.template.stocktaking;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

public class ExportDispatchPlanTemplate extends AbstractExcelExportTemplate<MdMatInfoDTO>{
    private List<MdMatInfoDTO> mats;

    public ExportDispatchPlanTemplate(List<MdMatInfoDTO> mats) {
        this.mats = mats;
        this.columnWidth = 4000;
    }

    @Override
    public String[] getSheetNames() {
        return new String[] { "Dispatch Plan Template" };
    }

    @Override
    public String[][] getTitles() {

        return new String[][] { {} };
    }

    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);

        DataFormat format = workbook.createDataFormat();
        this.bodyRowStyle.setDataFormat(format.getFormat("@"));
        final int size = mats.size();
        Row frow = sheet.createRow(0);

        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 8000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);
        sheet.setColumnWidth(8, 4000);
        sheet.setColumnWidth(9, 4000);
        this.bodyRowStyle.setWrapText(true);
        frow.setHeight((short) 800);
        sheet.createRow(1).setHeight((short) 800);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 9));

        createStyledCell1(
                frow,
                0,
                "Instructions:\n1st  Input Plan Qty,Plan Date,From,To  before importing the file.The all input Plan Qty,Plan Date,From,To must be same.\n2nd The Plan Date input format is "
                        + com.haier.openplatform.showcase.util.DataFormat
                                .formatDate(new Date())
                        + ".\n3rd The From and To  input,for example:From:LHS TO:BWP."
                         , this.bodyRowStyle);

        Row srow = sheet.createRow(2);
        srow.setHeight((short) 400);
        createStyledCell2(srow, 0, "Division", this.titleRowStyle);
        createStyledCell2(srow, 1, "Material No", this.titleRowStyle);
        createStyledCell2(srow, 2, "Plan Qty", this.titleRowStyle);
        createStyledCell2(srow, 3, "Unit", this.titleRowStyle);
        createStyledCell2(srow, 4, "Customer Model", this.titleRowStyle);
        createStyledCell2(srow, 5, "Material Desp", this.titleRowStyle);
        createStyledCell2(srow, 6, "Color", this.titleRowStyle);
        createStyledCell2(srow, 7, "Plan Date", this.titleRowStyle);
        createStyledCell2(srow, 8, "From", this.titleRowStyle);
        createStyledCell2(srow, 9, "To", this.titleRowStyle);

        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + 3);
            row.setHeight((short) 300);
            int index = 0;
            MdMatInfoDTO md = mats.get(i);
            createStyledCell2(row, index++, md.getDivision(), this.bodyRowStyle);
            createStyledCell2(row, index++, md.getMaterialNo(),
                    this.bodyRowStyle);
            createStyledCell2(row, index++, "", this.bodyRowStyle);
            createStyledCell2(row, index++, md.getBasicUnit(),
                    this.bodyRowStyle);
            createStyledCell2(row, index++, md.getCustomerModel(),
                    this.bodyRowStyle);
            createStyledCell2(row, index++, md.getMaterialDesp(),
                    this.bodyRowStyle);
            createStyledCell2(row, index++, md.getExternalMatGroup(),
                    this.bodyRowStyle);
            createStyledCell2(row, index++, "", this.bodyRowStyle);
            createStyledCell2(row, index++, "", this.bodyRowStyle);
            createStyledCell2(row, index++, "", this.bodyRowStyle);
        }
    }

    private void createStyledCell2(Row row, int index, String cellValue,
            CellStyle cellStyle) {
        Cell cell = row.createCell(index);

        cell.setCellValue(cellValue);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
    }

    protected void createStyledCell1(Row row, int index, String cellValue,
            CellStyle cellStyle) {
        Cell cell = row.createCell(index);
        cell.setCellValue(cellValue);
        cell.setCellStyle(cellStyle);
        // cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    }
}
