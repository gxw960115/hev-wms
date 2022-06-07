package com.haier.wms.exceltemplate.sto;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;

public class ExportStgStoDownListTemplet extends AbstractExcelExportTemplate<StgStoDownDTO>{
	
	private List<StgStoDownDTO> stgStoDownList;
	
	public ExportStgStoDownListTemplet(List<StgStoDownDTO> stgStoDownList){
		this.stgStoDownList=stgStoDownList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"STO_INFO"};
	}	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"STO NO","STO Item","Material No ","Material Desp","Qty","Gi Scan Qty","Gr Scan Qty","Unit","Gi Plant","Gi Location","Gr Plant","Gr Location","STO CreateDate","STO Last ChangeDate","STO CreateBy","Item Delete","STO Close"}};
	}
	
	@Override
	public String[] getCaptions() {
			return new String[]{"STO_INFO"};
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
		final int size = stgStoDownList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			StgStoDownDTO info = stgStoDownList.get(i);
			createStyledCell(row,index++,info.getStoNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			if(info.getGiFinishQty()!=null){
				createStyledCell(row,index++,info.getGiFinishQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			if(info.getGrFinishQty()!=null){
				createStyledCell(row,index++,info.getGrFinishQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGiPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGiLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGrPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGrLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoDocDate(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoLastModifyDate(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoCreateBy(),this.bodyRowStyle);
			if("1".equals(info.getItemDeltet())){
				createStyledCell(row,index++,"Delete",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"",this.bodyRowStyle);
			}
			if("1".equals(info.getStoClose())){
				createStyledCell(row,index++,"Finish",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"Normal",this.bodyRowStyle);
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
