package com.haier.wms.controller.inventory.exceltemplate;


import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;


public class ExportActualStockGapTemplate extends AbstractExcelExportTemplate<StgSapStockDTO>{
	
	private List<StgSapStockDTO> stgSapStockList;
	
	public ExportActualStockGapTemplate(List<StgSapStockDTO> stgSapStockList) {
		this.stgSapStockList = stgSapStockList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"MB52 Gap"};
	}

	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location","Material","SAP Qty","GAP"
			,"Customer Model","Material Desc","Unit"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"MB52 Gap"};
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
		final int size = stgSapStockList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			StgSapStockDTO stgSapStock =stgSapStockList.get(i);
			createStyledCell(row,index++,stgSapStock.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,stgSapStock.getLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,stgSapStock.getMaterialNo(),this.bodyRowStyle);
			Long sapQty = stgSapStock.getQty()==null?Long.valueOf(0L):stgSapStock.getQty();
			createNumberCell(row,index++,sapQty);
			createStyledCell(row,index++,stgSapStock.getCustomerModel(),this.bodyRowStyle);
			if(stgSapStock.getMaterialDesp()==null ||"".equals(stgSapStock.getMaterialDesp())){
				createStyledCell(row,index++," ",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,stgSapStock.getMaterialDesp(),this.bodyRowStyle);
			}
			createStyledCell(row,index++,stgSapStock.getUnit(),this.bodyRowStyle);
		}
	}
	/**
	 * 创建数字格式单元格 SJK
	 * @param row
	 * @param index
	 * @param cellValue
	 * @return
	 */
	private Cell createNumberCell(Row row,int index,long cellValue){

		Cell cell = row.createCell(index);
		cell.setCellValue(cellValue);
		
		Font font = workbook.createFont();
		//font.setColor(HSSFColor.BLUE_GREY.index);
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setWrapText(false);
		cellStyle.setFont(font);
		cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		cellStyle.setFillPattern(CellStyle.FINE_DOTS);
//		
//		DataFormat format = workbook.createDataFormat(); 
//		cellStyle.setDataFormat(format.getFormat("#")); 
		short border = 1;
		setCellBorder(cellStyle,border,border,border,border);
		cell.setCellStyle(cellStyle);
		
		return cell;
	}

}

