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

public class ExportStocktakingorderDtlSumTemplate extends AbstractExcelExportTemplate<OdsPdInfoDtlDTO> {
    List<OdsPdInfoDtlDTO> temp;
    public ExportStocktakingorderDtlSumTemplate(){}
    public ExportStocktakingorderDtlSumTemplate(List<OdsPdInfoDtlDTO> temp){
        this.temp=temp;
        this.columnWidth=6000;
    }

    
    @Override
    public String[] getSheetNames() {
        return new String[]{"StocktakingOrderDtl"};
    }

    @Override
    public String[][] getTitles() {
        return new String[][]{{"OrderNo","Plant","Location","Location Physical Count Qty","Wms Qty"
        		,"SAP Qty","Material No","Customer Model","Material Description"}};
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
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date类型转成String类型 
        
        for(int i = 0; i < size; i++){
            Row row = sheet.createRow(i+startIndex); 
            row.setHeight((short)300);
            int index = 0;
            
            OdsPdInfoDtlDTO info = temp.get(i);
            createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocqty().toString(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getWmsqty().toString(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getSapqty().toString(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getCustomerModel(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
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
