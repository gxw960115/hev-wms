package com.haier.wms.template.stocktaking;

import java.text.SimpleDateFormat;
import java.util.List;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;

public class ExportStocktakingorderDtlTemplate extends AbstractExcelExportTemplate<OdsPdInfoDtlDTO> {
    List<OdsPdInfoDtlDTO> temp;

    public ExportStocktakingorderDtlTemplate() {
    }

    public ExportStocktakingorderDtlTemplate(List<OdsPdInfoDtlDTO> temp) {
        this.temp = temp;
        this.columnWidth = 4000;
    }


    @Override
    public String[] getSheetNames() {
        return new String[]{"StocktakingOrderDtl"};
    }

    @Override
    public String[][] getTitles() {
        return new String[][]{{"OrderNo", "Plant", "Location", "Bin", "MaterialNo", "Material Description", "BarCode", "Qty", "CreateBy", "CreateDate"}};
    }

    @Override
    public String[] getCaptions() {
        return new String[]{"StocktakingOrderDtlInfo"};
    }

    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = temp.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//Date类型转成String类型

        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + startIndex);
            row.setHeight((short) 300);
            int index = 0;

            OdsPdInfoDtlDTO info = temp.get(i);
            createStyledCell(row, index++, info.getOrderNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getPlant(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getLocation(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getBin(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialDesp(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getBarcode(), this.bodyRowStyle);
            if (info.getQty() != null) {
                createStyledCell(row, index++, info.getQty().toString(), this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            }
            createStyledCell(row, index++, info.getCreateBy(), this.bodyRowStyle);
            if (info.getCreateDate() != null) {
                createStyledCell(row, index++, sdf.format(info.getCreateDate()), this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, "", this.bodyRowStyle);
            }
        }
    }

    protected CellStyle getStringCellStyle() {
        Font font = workbook.createFont();
        //font.setColor(HSSFColor.BLUE_GREY.index);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(false);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle.setDataFormat((short) 49);
        short border = 1;
        setCellBorder(cellStyle, border, border, border, border);
        return cellStyle;
    }

}
