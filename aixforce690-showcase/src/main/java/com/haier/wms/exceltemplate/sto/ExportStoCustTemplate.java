package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**  
 * @Title:  ExportStoCustTemplate.java
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年12月19日
 * @version V1.0 
 */  
public class ExportStoCustTemplate extends AbstractExcelExportTemplate<OdsStoCustDTO> {

	List<OdsStoCustDTO> temp;

	public ExportStoCustTemplate(){

	}

	public ExportStoCustTemplate(List<OdsStoCustDTO> temp){
        this.temp = temp;
        this.columnWidth = 4000;
    }

    @Override
    public String[] getSheetNames() {
        return new String[]{"OdsStoCust"};
    }
    /** (non-Javadoc)
	 * <p>Title: getTitles</p>
	 * <p>Description:自定义表头 </p>
	 * @return
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()
	 */
    @Override
    public String[][] getTitles() {
        return new String[][]{{"Order No","Check Flag","Item No","Material No","Material Desp","Unit","Gi Plant","Gr Plant","Gi Location","Gr Location","Qty","Gi Finish Qty","Gr Finish Qty"}};
    }

    @Override
    public String[] getCaptions() {
        return new String[]{"OdsStoCust"};
    }
    /** (non-Javadoc)
	 * <p>Title: buildBody</p>
	 * <p>Description: 创建Excel主体</p>
	 * @param sheetIndex
	 * @see AbstractExcelExportTemplate#buildBody(int)
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

            OdsStoCustDTO info = temp.get(i);
            createStyledCell(row,index++,info.getStoNo(),this.bodyRowStyle);
            if ("1".equals(info.getCheckFlag())) {
                createStyledCell(row,index++,"Confirmed",this.bodyRowStyle);
            }else {
                createStyledCell(row,index++,"Not Confirmed",this.bodyRowStyle);
            }
            createStyledCell(row,index++,info.getStoItemNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGiPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGrPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGiLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getGrLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getQty()==null?"0":info.getQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getGiFinishQty()==null?"0":info.getGiFinishQty().intValue()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getGrFinishQty()==null?"0":info.getGrFinishQty().intValue()+"",this.bodyRowStyle);
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
