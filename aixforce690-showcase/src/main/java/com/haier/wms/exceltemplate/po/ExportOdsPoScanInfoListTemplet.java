package com.haier.wms.exceltemplate.po;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ExportOdsPoScanInfoListTemplet.java
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

public class ExportOdsPoScanInfoListTemplet extends AbstractExcelExportTemplate<OdsPoScanInfoDTO> {

	private List<OdsPoScanInfoDTO> odsPoScanInfoList;
	
	public ExportOdsPoScanInfoListTemplet(List<OdsPoScanInfoDTO> odsPoScanInfoList) {
		this.odsPoScanInfoList = odsPoScanInfoList;
		this.columnWidth = 4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"POSCANINFO"};
	}

	/**
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"OGP/IGP No","Order Type","PO Order No","PO Order Item","Plant","Location","BIN","MaterialNo","MaterialDesp",
			"Qty","Unit","Barcode","Scanned By","Scanned Date"}};
	}

	@Override
	public String[] getCaptions() {
		return new String[]{"POSCANINFO"};
	}

	/**
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 */
	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		final int size = odsPoScanInfoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsPoScanInfoDTO info = odsPoScanInfoList.get(i);

//			"OGP/IGP NO",
			createStyledCell(row,index++,info.getOrderNo(),this.bodyRowStyle);
//			"Order Type",
			if (info.getOrderType() != null) {
				if ("1".equals(info.getOrderType())) {
					createStyledCell(row,index++,"IN",this.bodyRowStyle);
				}else if("2".equals(info.getOrderType())) {
					createStyledCell(row,index++,"OUT",this.bodyRowStyle);
				}else {
					createStyledCell(row,index++,info.getOrderType(),this.bodyRowStyle);
				}
			}
//			"SAP Order No",
			createStyledCell(row,index++,info.getPoNo(),this.bodyRowStyle);
//			"SAP Order Item",
			createStyledCell(row,index++,info.getPoItemNo(),this.bodyRowStyle);
//			"Plant",
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
//			"Location",
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
//			"Bin",
			createStyledCell(row,index++,info.getBin(),this.bodyRowStyle);
//			"Material No ",
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
//			"Quantity",
			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty().toString(),this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
//			"Unit",
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
//			"BarCode",
			createStyledCell(row,index++,info.getBarcode(),this.bodyRowStyle);
//			"Scanned By",
			createStyledCell(row,index++,info.getScannedBy(),this.bodyRowStyle);
//			"Scanned Date"
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
