package com.haier.wms.exceltemplate.customer;

import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.customer.dto.OdsCustomerStockDTO;

/**  
 * @Title:  ExportCustomerStocksTemplate.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:38:26   
 * @version V1.0 
 */  
public class ExportCustomerStockTemplate extends AbstractExcelExportTemplate<OdsCustomerStockDTO> {
    
	List<OdsCustomerStockDTO> temp;
    
	public ExportCustomerStockTemplate(){
		
	}
    
	public ExportCustomerStockTemplate(List<OdsCustomerStockDTO> temp){
        this.temp = temp;
        this.columnWidth = 4000;
    }
    
    @Override
    public String[] getSheetNames() {
        return new String[]{"CustomerStocks"};
    }
    /** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
    @Override
    public String[][] getTitles() {
        return new String[][]{{"Order No.","Item No","Finish Qty","Unit","Plant","Warehouse Code","Warehouse Name","GI Location","GR Location","Material No","Material Description","Customer Model","Do Flag","Create By"}};
    }
    
    @Override
    public String[] getCaptions() {
        return new String[]{"CustomerStocks"};
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
            
            OdsCustomerStockDTO info = temp.get(i);
//            createStyledCell(row,index++,info.getFinishQty() == null ? "0" : info.getFinishQty()+"",this.bodyRowStyle);
//            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getWarehouseCode(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getWarehouseName(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getCustomerModel(),this.bodyRowStyle);
//            createStyledCell(row,index++,info.getCreateBy(),this.bodyRowStyle);
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
