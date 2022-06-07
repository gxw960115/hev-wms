package com.haier.wms.exceltemplate.consume;

import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ExportOdsConsumeScanInfoListTemplet.java
 * @description: 领用订单-->扫描订单导出
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

public class ExportOdsConsumeScanInfoListTemplet extends
		AbstractExcelExportTemplate<OdsConsumeScanInfoDTO> {

	private List<OdsConsumeScanInfoDTO> odsConsumeScanInfoList;
	
	public ExportOdsConsumeScanInfoListTemplet(List<OdsConsumeScanInfoDTO> odsConsumeScanInfoList) {
		this.odsConsumeScanInfoList = odsConsumeScanInfoList;
		this.columnWidth = 4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"CONSUME_SCAN_INFO"};
	}

	/**
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Consume No.","Consume Item","Plant","Location","Material No","Material Desp","Qty","Unit","Barcode","Scanned By","Scanned Date"}};
	}

	@Override
	public String[] getCaptions() {
		return new String[]{"CONSUME_SCAN_INFO"};
	}

	/**
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 */
	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		final int size = odsConsumeScanInfoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsConsumeScanInfoDTO info = odsConsumeScanInfoList.get(i);
			
			createStyledCell(row,index++,info.getConsumeNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getConsumeItemNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getQty() == null ? "0" : info.getQty()+"",this.bodyRowStyle);
            createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getBarcode(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getCreateBy(),this.bodyRowStyle);
            if (null == info.getCreateDate()) {
            	createStyledCell(row,index++,"",this.bodyRowStyle);
			} else {
				createStyledCell(row,index++,DateFormatUtils.format(info.getCreateDate(), "yyyy-MM-dd"),this.bodyRowStyle);
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
