package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class ExportStgStodnDownListTemplet extends AbstractExcelExportTemplate<StgStodnDownDTO>{
	
	private List<StgStodnDownDTO> stgStoDownList;
	
	public ExportStgStodnDownListTemplet(List<StgStodnDownDTO> stgStoDownList){
		this.stgStoDownList=stgStoDownList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"STO_DN_INFO"};
	}
	/**
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"STO NO","STO Item","STO DN NO","STO DN Item","Material No","Qty","Unit","Gr Plant","Gr Location","Gr Scan Qty","Gr Scan Flag"}};
	}
	
	@Override
	public String[] getCaptions() {
			return new String[]{"STO_DN_INFO"};
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
			
			StgStodnDownDTO info = stgStoDownList.get(i);
			createStyledCell(row,index++,info.getStoNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStodnNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStodnItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);

			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGrPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getGrLocation(),this.bodyRowStyle);
			if(info.getGrFinishQty()!=null){
				createStyledCell(row,index++,info.getGrFinishQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			if("0".equals(info.getGrFinishFlag())){
				createStyledCell(row,index++,"Not Finish",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"Finished",this.bodyRowStyle);
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
