package com.haier.wms.controller.inventory.exceltemplate;


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
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;


public class ExportOdsInventoryInfoDtlListTemplet extends AbstractExcelExportTemplate<OdsInventoryInfoDtlDTO>{
	
	private List<OdsInventoryInfoDtlDTO> infoList;
	
	public ExportOdsInventoryInfoDtlListTemplet(List<OdsInventoryInfoDtlDTO> infoList) {
		this.infoList = infoList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"Inventory Barcode"};
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location ","Bin","BarCode","Qty","Occupied qty","Unit","Remark","Material No","Material Description",
			"IGP NO","Order Item","Document Type","SAP Order No.","SAP Order Item","First In Date","Current Stock Days","Total Stock Days","Lock Status"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"Inventory Barcode"};
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
			
			OdsInventoryInfoDtlDTO info =infoList.get(i);
			
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getBin(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getBarcode(),this.bodyRowStyle);
			if(info.getQty() == null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,info.getQty()+"",this.bodyRowStyle);
			}
			if(info.getUseQty()==null){
				createStyledCell(row,index++,0+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,info.getUseQty()+"",this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getRemark(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getOrderItem(),this.bodyRowStyle);
			if ("DN".equals(info.getDocTpye())) {
				createStyledCell(row,index++,"Billing",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,info.getDocTpye(),this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getSapOrderNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getSapOrderItem(),this.bodyRowStyle);
			createStyledCell(row,index++,DataFormat.formatDate(info.getFirstInDate()),this.bodyRowStyle);
			if(info.getCurrentStockDays()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,info.getCurrentStockDays()+"",this.bodyRowStyle);
			}
			if(info.getTotalStockDays()==null){
				createStyledCell(row,index++,"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,info.getTotalStockDays()+"",this.bodyRowStyle);
			}
			if ("0".equals(info.getLockFlag())) {
				createStyledCell(row,index++,"Unlock",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,"Lock",this.bodyRowStyle);
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

