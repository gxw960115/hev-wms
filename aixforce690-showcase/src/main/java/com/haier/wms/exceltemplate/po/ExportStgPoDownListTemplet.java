package com.haier.wms.exceltemplate.po;

import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;


public class ExportStgPoDownListTemplet extends AbstractExcelExportTemplate<StgPoDownDTO>{
	
	private List<StgPoDownDTO> infoList;
	
	public ExportStgPoDownListTemplet(List<StgPoDownDTO> infoList){
		this.infoList = infoList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"PO_INFO"};
	}	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"PO NO","PO Item","PO Type","Qty","Finish Qty","Plant","Location","Material No ","Material Desp","PO Close","PO CreateDate","PO Last ChangeDate","PO CreateBy"}};
	}
	
	@Override
	public String[] getCaptions() {
		return new String[]{"PO_INFO"};
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
		final int size = infoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			StgPoDownDTO info =infoList.get(i);
			
			createStyledCell(row,index++,info.getPoNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPoItemNo() ,this.bodyRowStyle);
			createStyledCell(row,index++,info.getPoType() ,this.bodyRowStyle);
			if(info.getQty() == null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,info.getQty()+"" ,this.bodyRowStyle);
			}
			if(info.getFinishQty() == null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,info.getFinishQty()+"" ,this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getPlant() ,this.bodyRowStyle);
			createStyledCell(row,index++,info.getPoLocation() ,this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo() ,this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp() ,this.bodyRowStyle);
			if("0".equals(info.getPoClose())){
				createStyledCell(row,index++,"open",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"close",this.bodyRowStyle);
			}
			if(info.getCreateDate()!=null){
				createStyledCell(row,index++,DataFormat.formatDate(info.getCreateDate()) ,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"" ,this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getPoLastModifyDate() ,this.bodyRowStyle);
			createStyledCell(row,index++,info.getPoCreateBy() ,this.bodyRowStyle);
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
