package com.haier.hevwms.inventory.service.impl;


import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.inventory.domain.StgSapStock;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;

public class ExportStgSapStockListTemplet extends AbstractExcelExportTemplate<StgSapStock>{
	
	private List<StgSapStock> stgSapStockList;
	
	public ExportStgSapStockListTemplet(List<StgSapStock> stgSapStockList) {
		this.stgSapStockList = stgSapStockList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"MB52"};
	}
	

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Location","Quantity","Unit","Material No","CustomerModel","Material Description"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"MB52"};
	}

	@Override
	protected void buildBody(int sheetIndex) {

		Sheet sheet = getSheet(sheetIndex);
		final int size = stgSapStockList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			StgSapStock stgSapStock =stgSapStockList.get(i);
			//库存地点
			createStyledCell(row,index++,stgSapStock.getLocation(),this.bodyRowStyle);
			//Quantity
			if(stgSapStock.getQty()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,stgSapStock.getQty().toString(),this.bodyRowStyle);
			}
	//		createStyledCell(row,index++,stgSapStock.getQty().toString(),this.bodyRowStyle);
			//单位
			createStyledCell(row,index++,stgSapStock.getUnit(),this.bodyRowStyle);
			//物料号
			createStyledCell(row,index++,stgSapStock.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,stgSapStock.getCustomerModel(),this.bodyRowStyle);
			//物料描述
			if(stgSapStock.getMaterialDesp()==null ||"".equals(stgSapStock.getMaterialDesp())){
				createStyledCell(row,index++," ",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,stgSapStock.getMaterialDesp(),this.bodyRowStyle);
			}
		}
	}
	

}

