package com.haier.hevwms.inventory.service.impl;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;

public class ExportOdsBarcodeHistoryListTemplet extends AbstractExcelExportTemplate<OdsBarcodeHistory>{
	
	private List<OdsBarcodeHistory> odsBarcodeHistoryList;
	
	public ExportOdsBarcodeHistoryListTemplet(List<OdsBarcodeHistory> odsBarcodeHistoryList) {
		this.odsBarcodeHistoryList =odsBarcodeHistoryList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"BarCode History"};
	}
	

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location ","BarCode","Quantity","Unit","Material No","Customer Model","Material Description","InoutType",
								"Inout Date","OGP/IGP NO.","Order Item","Document Type","SAP Order No.","SAP Order Item"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"BarCode History"};
	}

	@Override
	protected void buildBody(int sheetIndex) {

		Sheet sheet = getSheet(sheetIndex);
		final int size = odsBarcodeHistoryList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsBarcodeHistory odsBarcodeHistory =odsBarcodeHistoryList.get(i);
			
			//工厂
			createStyledCell(row,index++,odsBarcodeHistory.getPlant(),this.bodyRowStyle);
			//库存地点
			createStyledCell(row,index++,odsBarcodeHistory.getLocation(),this.bodyRowStyle);
			//条码
			createStyledCell(row,index++,odsBarcodeHistory.getBarcode(),this.bodyRowStyle);
			//数量
			if(odsBarcodeHistory.getQty()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsBarcodeHistory.getQty(),this.bodyRowStyle);
			}			
			//单位
			createStyledCell(row,index++,odsBarcodeHistory.getUnit(),this.bodyRowStyle);
			//物料号
			createStyledCell(row,index++,odsBarcodeHistory.getMaterialNo(),this.bodyRowStyle);
			//客户描述
			createStyledCell(row,index++,odsBarcodeHistory.getCustomerModel(),this.bodyRowStyle);
			//物料描述
			createStyledCell(row,index++,odsBarcodeHistory.getMaterialDesp(),this.bodyRowStyle);
			//InoutType
			if("1".equals(odsBarcodeHistory.getInoutType())){
				createStyledCell(row,index++,"In Warehouse",this.bodyRowStyle);
			}else if("2".equals(odsBarcodeHistory.getInoutType())){
				createStyledCell(row,index++,"Out Warehouse",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"",this.bodyRowStyle);
			}
			//Inout Date
			createStyledCell(row,index++,odsBarcodeHistory.getInoutDate().toString(),this.bodyRowStyle);
			//出入库单据号
			createStyledCell(row,index++,odsBarcodeHistory.getOrderNo(),this.bodyRowStyle);
			//行项目
			createStyledCell(row,index++,odsBarcodeHistory.getOrderItem(),this.bodyRowStyle);
			//凭证类型
			createStyledCell(row,index++,odsBarcodeHistory.getDocTpye(),this.bodyRowStyle);
			//SAP凭证单号
			createStyledCell(row,index++,odsBarcodeHistory.getSapOrderNo(),this.bodyRowStyle);
			//SAP行项目
			createStyledCell(row,index++,odsBarcodeHistory.getSapOrderItem(),this.bodyRowStyle);
		}
	}
	private void createStyledCell(Row row, int index, double cellValue,
			CellStyle cellStyle) {
		Cell cell = row.createCell(index);
		cell.setCellValue(cellValue);
		cell.setCellStyle(cellStyle);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
	}
	

}

