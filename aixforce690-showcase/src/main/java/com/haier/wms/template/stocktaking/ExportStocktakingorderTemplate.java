package com.haier.wms.template.stocktaking;

import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;

public class ExportStocktakingorderTemplate extends AbstractExcelExportTemplate<OdsPdInfoDTO> {
    List<OdsPdInfoDTO> temp;
    public ExportStocktakingorderTemplate(){}
    public ExportStocktakingorderTemplate(List<OdsPdInfoDTO> temp){
        this.temp=temp;
        this.columnWidth=4000;
    }

    
    @Override
    public String[] getSheetNames() {
        return new String[]{"StocktakingOrder"};
    }

    @Override
    public String[][] getTitles() {
        return new String[][]{{"Order No.","Order Status","Plant","Location","Material No","Material Description","Actual Qty","Unit"}};
    }
    
    @Override
    public String[] getCaptions() {
        return new String[]{"StocktakingOrderInfo"};
    }
    
    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = temp.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);
        
        for(int i = 0; i < size; i++){
            Row row = sheet.createRow(i+startIndex); 
            row.setHeight((short)300);
            int index = 0;
            
            OdsPdInfoDTO info = temp.get(i);
            createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
            if ("0".equals(info.getOrderStatus())) {
            	createStyledCell(row,index++,"Ready",this.bodyRowStyle);
			} else if ("1".equals(info.getOrderStatus())) {
            	createStyledCell(row,index++,"Process",this.bodyRowStyle);
			} else if ("2".equals(info.getOrderStatus())) {
            	createStyledCell(row,index++,"Complete",this.bodyRowStyle);
			} else if ("3".equals(info.getOrderStatus())) {
            	createStyledCell(row,index++,"Delete",this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getActualQty()==null?"0":info.getActualQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
        }
    }
    
    protected CellStyle getStringCellStyle(){
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
        setCellBorder(cellStyle,border,border,border,border);
        return cellStyle;
    }

}
