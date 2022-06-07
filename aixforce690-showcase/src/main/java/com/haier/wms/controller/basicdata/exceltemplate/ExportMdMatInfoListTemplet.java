package com.haier.wms.controller.basicdata.exceltemplate;


import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

public class ExportMdMatInfoListTemplet extends AbstractExcelExportTemplate<MdMatInfoDTO>{
	
	private List<MdMatInfoDTO> infoList;
	
	public ExportMdMatInfoListTemplet(List<MdMatInfoDTO> infoList) {
		this.infoList = infoList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"MATERIAL"};
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Material No","Material Desp" ,"Unit", "Plant", "Mrp Code", "Old Mat", "Length", "Width", "Height", "Measure Unit", "Volume", "Volume Unit", "Remark"}};
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
			
			MdMatInfoDTO info =infoList.get(i);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getBasicUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMrpCode(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getOldMat(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLength()==null?"":info.getLength()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getWidth()==null?"":info.getWidth()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getHigth()==null?"":info.getHigth()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getMeasureUnit(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getVolume()==null?"":info.getVolume()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getVolumeUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getRemark(),this.bodyRowStyle);
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

