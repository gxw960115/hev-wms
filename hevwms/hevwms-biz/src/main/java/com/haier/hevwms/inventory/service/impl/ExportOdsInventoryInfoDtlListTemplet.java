package com.haier.hevwms.inventory.service.impl;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;

public class ExportOdsInventoryInfoDtlListTemplet extends AbstractExcelExportTemplate<OdsInventoryInfoDtl>{
	
	private List<OdsInventoryInfoDtl> odsInventoryInfoDtlList;
	
	public ExportOdsInventoryInfoDtlListTemplet(List<OdsInventoryInfoDtl> odsInventoryInfoDtlList) {
		this.odsInventoryInfoDtlList = odsInventoryInfoDtlList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"Inventory Barcode"};
	}
	

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location ","division","BarCode","Quantity","Occupied qty","Unit","Material No","Customer Model","Material Description",
			"IGP NO","Order Item","Document Type","SAP Order No.","SAP Order Item","firstInDate","Current Stock Days","Total Stock Days"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"Inventory Barcode"};
	}

	@Override
	protected void buildBody(int sheetIndex) {

		Sheet sheet = getSheet(sheetIndex);
		final int size = odsInventoryInfoDtlList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsInventoryInfoDtl odsInventoryInfoDtl =odsInventoryInfoDtlList.get(i);
			
			//工厂
			createStyledCell(row,index++,odsInventoryInfoDtl.getPlant(),this.bodyRowStyle);
			//库存地点
			createStyledCell(row,index++,odsInventoryInfoDtl.getLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,odsInventoryInfoDtl.getDivision(),this.bodyRowStyle);
			//条码
			createStyledCell(row,index++,odsInventoryInfoDtl.getBarcode(),this.bodyRowStyle);
			//数量
			if(odsInventoryInfoDtl.getQty()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getQty(),this.bodyRowStyle);
			}
			//useQty
			if(odsInventoryInfoDtl.getUseQty()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getUseQty(),this.bodyRowStyle);
			}
			//单位
			createStyledCell(row,index++,odsInventoryInfoDtl.getUnit(),this.bodyRowStyle);
			//物料号
			createStyledCell(row,index++,odsInventoryInfoDtl.getMaterialNo(),this.bodyRowStyle);
			//客户描述
			createStyledCell(row,index++,odsInventoryInfoDtl.getCustomerModel(),this.bodyRowStyle);
			//物料描述
			createStyledCell(row,index++,odsInventoryInfoDtl.getMaterialDesp(),this.bodyRowStyle);
			//出入库单据号
			createStyledCell(row,index++,odsInventoryInfoDtl.getOrderNo(),this.bodyRowStyle);
			//行项目
			createStyledCell(row,index++,odsInventoryInfoDtl.getOrderItem(),this.bodyRowStyle);
			//凭证类型
			createStyledCell(row,index++,odsInventoryInfoDtl.getDocTpye(),this.bodyRowStyle);
			//SAP凭证单号
			createStyledCell(row,index++,odsInventoryInfoDtl.getSapOrderNo(),this.bodyRowStyle);
			//SAP行项目
			createStyledCell(row,index++,odsInventoryInfoDtl.getSapOrderItem(),this.bodyRowStyle);
			createStyledCell(row,index++,DataFormat.formatDate(odsInventoryInfoDtl.getFirstInDate()),this.bodyRowStyle);
			//条码当前库龄
			if(odsInventoryInfoDtl.getCurrentStockDays()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getCurrentStockDays(),this.bodyRowStyle);
			}
	//		createStyledCell(row,index++,odsInventoryInfoDtl.getCurrentStockDays().toString(),this.bodyRowStyle);
			//条码总库龄
			if(odsInventoryInfoDtl.getTotalStockDays()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getTotalStockDays(),this.bodyRowStyle);
			}
	//		createStyledCell(row,index++,odsInventoryInfoDtl.getTotalStockDays().toString(),this.bodyRowStyle);
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

