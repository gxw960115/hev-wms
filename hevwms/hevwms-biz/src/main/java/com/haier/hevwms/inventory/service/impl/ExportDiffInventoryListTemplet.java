package com.haier.hevwms.inventory.service.impl;


import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;

public class ExportDiffInventoryListTemplet extends AbstractExcelExportTemplate<OdsInventoryInfoDtl>{
	
	private List<OdsInventoryInfoDtl> odsInventoryInfoDtlList;
	
	public ExportDiffInventoryListTemplet(List<OdsInventoryInfoDtl> odsInventoryInfoDtlList) {
		this.odsInventoryInfoDtlList = odsInventoryInfoDtlList;
		this.columnWidth=4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"Invetory Total Report"};
	}
	

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Plant","Location ","Material No","BarCode","Quantity","WMS Qty","SAP Qty","Unit","Customer Model","Material Description"
			,"IGP NO","Order Item","Document Type","SAP Order No.","SAP Order Item","Current Stock Days","Total Stock Days"}};
	}
	@Override
	public String[] getCaptions() {
			return new String[]{"Invetory Total Report"};
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
			//物料号
			createStyledCell(row,index++,odsInventoryInfoDtl.getMaterialNo(),this.bodyRowStyle);
			//条码
			createStyledCell(row,index++,odsInventoryInfoDtl.getBarcode(),this.bodyRowStyle);
			//数量
			if(odsInventoryInfoDtl.getQty()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getQty().toString(),this.bodyRowStyle);
			}
			//WmsQty
			if(odsInventoryInfoDtl.getWmsQty()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getWmsQty().toString(),this.bodyRowStyle);
			}
			//SapQty
			if(odsInventoryInfoDtl.getSapQty()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getSapQty().toString(),this.bodyRowStyle);
			}
			//单位
			createStyledCell(row,index++,odsInventoryInfoDtl.getUnit(),this.bodyRowStyle);
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
			//条码当前库龄
			if(odsInventoryInfoDtl.getCurrentStockDays()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getCurrentStockDays().toString(),this.bodyRowStyle);
			}
	//		createStyledCell(row,index++,odsInventoryInfoDtl.getCurrentStockDays().toString(),this.bodyRowStyle);
			//条码总库龄
			if(odsInventoryInfoDtl.getTotalStockDays()==null){
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,odsInventoryInfoDtl.getTotalStockDays().toString(),this.bodyRowStyle);
			}
	//		createStyledCell(row,index++,odsInventoryInfoDtl.getTotalStockDays().toString(),this.bodyRowStyle);
		}
	}
	

}

