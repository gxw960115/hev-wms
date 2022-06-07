package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ExportodsStoScanInfoListTemplet.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月18日 下午4:07:40
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月18日		LJZ			v1.0.0			create
 */

public class ExportOdsStoScanInfoListTemplet extends
		AbstractExcelExportTemplate<OdsStoScanInfoDTO> {

	private List<OdsStoScanInfoDTO> odsStoScanInfoList;
	
	public ExportOdsStoScanInfoListTemplet(List<OdsStoScanInfoDTO> odsStoScanInfoList) {
		this.odsStoScanInfoList = odsStoScanInfoList;
		this.columnWidth = 4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"STO_SCAN_INFO"};
	}

	/**
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Order NO","Order Type","STO NO","STO Item NO","STO DN NO","STO DN Item NO","Plant","Location","Bin",
			"Material No","Material Desp","Qty","Unit","Barcode","Scanned By","Scanned Date"}};
	}

	@Override
	public String[] getCaptions() {
		return new String[]{"STO_SCAN_INFO"};
	}

	/**
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 */
	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		final int size = odsStoScanInfoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsStoScanInfoDTO info = odsStoScanInfoList.get(i);
			
			createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
			if (info.getOrderType() != null) {
				if ("1".equals(info.getOrderType())) {
					createStyledCell(row,index++,"IN",this.bodyRowStyle);
				}else if("2".equals(info.getOrderType())) {
					createStyledCell(row,index++,"OUT",this.bodyRowStyle);
				}else {
					createStyledCell(row,index++,info.getOrderType(),this.bodyRowStyle);
				}
			}
			createStyledCell(row,index++,info.getStoNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStodnNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStodnItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getBin(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty().toString(),this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getBarcode(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getScannedBy(),this.bodyRowStyle);
			if(info.getScannedDate()!=null){
				createStyledCell(row,index++,DataFormat.formatDate(info.getScannedDate()),this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"",this.bodyRowStyle);
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
