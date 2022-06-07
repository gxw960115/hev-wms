package com.haier.wms.exceltemplate.transfer;

import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;

public class ExportTransferDtlTemplate extends AbstractExcelExportTemplate<OdsTransferDtlDTO> {
    
	List<OdsTransferDtlDTO> temp;
    
	public ExportTransferDtlTemplate(){
		
	}
    
	public ExportTransferDtlTemplate(List<OdsTransferDtlDTO> temp){
        this.temp = temp;
        this.columnWidth = 4000;
    }
    
    @Override
    public String[] getSheetNames() {
        return new String[]{"TransferDetails"};
    }
    /** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
    @Override
    public String[][] getTitles() {
        return new String[][]{{"Trans No","Item No","Qty","Unit","Plant","Gi Location","Gr Location","Material No","Material Desp"}};
    }
    
    @Override
    public String[] getCaptions() {
        return new String[]{"TransferDetails"};
    }
    /** (non-Javadoc)  
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 * @param sheetIndex  
	 * @see com.haier.openplatform.excel.AbstractExcelExportTemplate#buildBody(int)  
	 */
    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = temp.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);
        
        for(int i = 0; i < size; i++){
            Row row = sheet.createRow(i+startIndex); 
            row.setHeight((short)300);
            int index = 0;
            
            OdsTransferDtlDTO info = temp.get(i);
            createStyledCell(row,index++,info.getTransNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getTransItemNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getQty() == null ? "0" : info.getQty()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGiLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGrLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
        }
    }
    
    protected CellStyle getStringCellStyle(){
        Font font = workbook.createFont();
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
