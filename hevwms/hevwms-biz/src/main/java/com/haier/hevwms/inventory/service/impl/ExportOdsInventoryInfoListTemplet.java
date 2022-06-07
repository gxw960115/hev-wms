package com.haier.hevwms.inventory.service.impl;


import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.inventory.domain.OdsInventoryInfo;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;

public class ExportOdsInventoryInfoListTemplet extends AbstractExcelExportTemplate<OdsInventoryInfo>{
	
	private List<OdsInventoryInfo> odsInventoryInfoList;
	
	public ExportOdsInventoryInfoListTemplet(List<OdsInventoryInfo> odsInventoryInfoList) {
		this.odsInventoryInfoList = odsInventoryInfoList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"INVENTORY"};
	}
	

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Division","Location ","WMSQty","Unit","Material No","Customer Model","Material Description","Customer Model"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"INVENTORY"};
	}

	@Override
	protected void buildBody(int sheetIndex) {

		Sheet sheet = getSheet(sheetIndex);
		final int size = odsInventoryInfoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsInventoryInfo odsInventoryInfo =odsInventoryInfoList.get(i);
			
			//工厂
			createStyledCell(row,index++,odsInventoryInfo.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,odsInventoryInfo.getDivision(),this.bodyRowStyle);
			//库存地点
			createStyledCell(row,index++,odsInventoryInfo.getLocation(),this.bodyRowStyle);
			//库存数量
			if(odsInventoryInfo.getWmsQty()==null){
				createStyledCell(row,index++,0,this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfo.getWmsQty(),this.bodyRowStyle);
			}
			//单位
			createStyledCell(row,index++,odsInventoryInfo.getUnit(),this.bodyRowStyle);
			//物料号
			createStyledCell(row,index++,odsInventoryInfo.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,odsInventoryInfo.getCustomerModel(),this.bodyRowStyle);
			//物料描述
			if(odsInventoryInfo.getMaterialDesp()==null ||"".equals(odsInventoryInfo.getMaterialDesp())){
				createStyledCell(row,index++,"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfo.getMaterialDesp(),this.bodyRowStyle);
			}
			//客户描述
			if(odsInventoryInfo.getCustomerModel()==null ||"".equals(odsInventoryInfo.getCustomerModel())){
				createStyledCell(row,index++,"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfo.getCustomerModel(),this.bodyRowStyle);
			}
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

