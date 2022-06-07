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


public class ExportStgSapStockListTemplet extends AbstractExcelExportTemplate<StgSapStockDTO>{
	
	private List<StgSapStockDTO> infoList;
	
	public ExportStgSapStockListTemplet(List<StgSapStockDTO> infoList) {
		this.infoList = infoList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"MB52"};
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location","SAP Qty","WMS Qty","GAP","Unit","Material No","Material Description","MRP Controller","Price","Total Value","Create Date"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"MB52"};
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
			int wmsQty = 0,sapQty = 0;
			StgSapStockDTO info = infoList.get(i);
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
			if(info.getSapQty()==null){
				createNumberCell(row,index++,0L);
			}else{
				createNumberCell(row,index++,info.getSapQty());
				sapQty = info.getSapQty().intValue();
			}
			if(info.getWmsQty()==null){
				createNumberCell(row,index++,0L);
			}else{
				createNumberCell(row,index++,info.getWmsQty());
				wmsQty = info.getWmsQty().intValue();
			}
			createNumberCell(row,index++,wmsQty - sapQty);
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMrpController(),this.bodyRowStyle);
			createStyledCell(row,index++,null == info.getPrice() ? "0":info.getPrice()+"",this.bodyRowStyle);
			createStyledCell(row,index++,null == info.getTotalValue()?"0":info.getTotalValue()+"",this.bodyRowStyle);
			createStyledCell(row,index++,info.getSapDownDate(),this.bodyRowStyle);
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
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setWrapText(false);
		cellStyle.setFont(font);
		cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		cellStyle.setFillPattern(CellStyle.FINE_DOTS);
		short border = 1;
		setCellBorder(cellStyle,border,border,border,border);
		cell.setCellStyle(cellStyle);
		
		return cell;
	}

}

