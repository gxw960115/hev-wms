package com.haier.wms.exceltemplate.customer;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**  
 * @Title:  ExportCustomerOrdersTemplate.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 下午1:38:26   
 * @version V1.0 
 */  
public class ExportCustomerOrderTemplate extends AbstractExcelExportTemplate<OdsCustomerOrderDTO> {
    
	List<OdsCustomerOrderDTO> temp;
    
	public ExportCustomerOrderTemplate(){
		
	}
    
	public ExportCustomerOrderTemplate(List<OdsCustomerOrderDTO> temp){
        this.temp = temp;
        this.columnWidth = 4000;
    }
    
    @Override
    public String[] getSheetNames() {
        return new String[]{"CustomerOrders"};
    }
    /** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
    @Override
    public String[][] getTitles() {
        return new String[][]{{"Order No","Check Flag","Plant","Location","Material No","Material Desp","Require Qty","Scanned Qty","Unit","inOut Flag"}};
    }
    
    @Override
    public String[] getCaptions() {
        return new String[]{"CustomerOrders"};
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
            
            OdsCustomerOrderDTO info = temp.get(i);
            createStyledCell(row,index++,info.getCtrOrderNo(),this.bodyRowStyle);
            if ("1".equals(info.getCheckFlag())) {
            	createStyledCell(row,index++,"Confirmed",this.bodyRowStyle);
			}else {
				createStyledCell(row,index++,"Not Confirmed",this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getRequireQty()==null?"0":info.getRequireQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getFinishQty()==null?"0":info.getFinishQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            if ("1".equals(info.getInOutFlag())) {
            	createStyledCell(row,index++,"Delivered",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,"Not Delivered",this.bodyRowStyle);
			}
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
