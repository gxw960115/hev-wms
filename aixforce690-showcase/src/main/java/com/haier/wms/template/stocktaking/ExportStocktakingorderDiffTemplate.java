package com.haier.wms.template.stocktaking;

import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;

public class ExportStocktakingorderDiffTemplate extends
        AbstractExcelExportTemplate<OdsPdDiffDtlDTO> {
    List<OdsPdDiffDtlDTO> temp;

    public ExportStocktakingorderDiffTemplate() {
    }

    public ExportStocktakingorderDiffTemplate(List<OdsPdDiffDtlDTO> temp) {
        this.temp = temp;
        this.columnWidth = 4000;
    }

    @Override
    public String[] getSheetNames() {
        return new String[] { "StocktakingOrderDiff" };
    }

    @Override
    public String[][] getTitles() {
    	return new String[][]{{"Order No.","Diff Type","Process Flag","Plant","Location","Barcode","Qty","Unit","Material No","Material Description","BarCode IGP Date","Stock Audit Date","Modify By","Modify Date"}};
    }

    @Override
    public String[] getCaptions() {
        return new String[] { "StocktakingOrderDiffInfo" };
    }

    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = temp.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);
        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + startIndex);
            row.setHeight((short) 300);
            int index = 0;

            OdsPdDiffDtlDTO info = temp.get(i);
            
            createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
            if ("0".equals(info.getDiffType())) {
            	createStyledCell(row,index++,"Inventory profit",this.bodyRowStyle);
			} else if ("1".equals(info.getDiffType())) {
            	createStyledCell(row,index++,"Inventory loss",this.bodyRowStyle);
			} else if ("2".equals(info.getDiffType())) {
            	createStyledCell(row,index++,"Bin difference",this.bodyRowStyle);
			}
            if ("0".equals(info.getProcessFlag())) {
            	createStyledCell(row,index++,"not process",this.bodyRowStyle);
            } else if ("1".equals(info.getProcessFlag())) {
            	createStyledCell(row,index++,"processed",this.bodyRowStyle);
            }
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getBarcode(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getQty()==null?"0":info.getQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
            if (null == info.getInoutDate()) {
            	createStyledCell(row,index++,"",this.bodyRowStyle);
            } else {
            	createStyledCell(row,index++,DateFormatUtils.format(info.getInoutDate(), "yyyy-MM-dd"),this.bodyRowStyle);
            }
            if (null == info.getCreateDate()) {
            	createStyledCell(row,index++,"",this.bodyRowStyle);
            } else {
            	createStyledCell(row,index++,DateFormatUtils.format(info.getCreateDate(), "yyyy-MM-dd"),this.bodyRowStyle);
            }
            createStyledCell(row,index++,info.getModifyBy(),this.bodyRowStyle);
            if (null == info.getModifyDate()) {
            	createStyledCell(row,index++,"",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,DateFormatUtils.format(info.getModifyDate(), "yyyy-MM-dd"),this.bodyRowStyle);
			}
        }
    }

    protected CellStyle getStringCellStyle() {
        Font font = workbook.createFont();
        // font.setColor(HSSFColor.BLUE_GREY.index);
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
