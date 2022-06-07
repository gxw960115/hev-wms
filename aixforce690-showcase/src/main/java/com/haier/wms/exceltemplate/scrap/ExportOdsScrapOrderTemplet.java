package com.haier.wms.exceltemplate.scrap;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ExportOdsScrapOrderTemplet.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月24日 下午3:23:00
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月24日		LJZ			v1.0.0			create
 */

public class ExportOdsScrapOrderTemplet extends AbstractExcelExportTemplate<OdsScrapOrderDTO> {

	private List<OdsScrapOrderDTO> odsScrapOrderDTOs;
	
	public ExportOdsScrapOrderTemplet(List<OdsScrapOrderDTO> odsScrapOrderDTOs) {
		this.odsScrapOrderDTOs = odsScrapOrderDTOs;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[]{"SCRAP_ORDER"};
	}

	@Override
	public String[][] getTitles() {
		return new String[][]{{"Order No.","Check Flag","Plant","Location","Material No","Material Desp","Require Qty","Scanned Qty","Unit","Delete Flag","Sap Flag","Sap Msg"}};
	}

	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		final int size = odsScrapOrderDTOs.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		for (int i = 0; i < size; i++) {
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			
			OdsScrapOrderDTO info = odsScrapOrderDTOs.get(i);
			
//			createStyledCell(row,index++,info.getConsumeNo(),this.bodyRowStyle);
            if ("1".equals(info.getCheckFlag())) {
            	createStyledCell(row,index++,"Confirmed",this.bodyRowStyle);
			}else {
				createStyledCell(row,index++,"Not Confirmed",this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getRequireQty() == null ? "0" : info.getRequireQty()+"",this.bodyRowStyle);
			createStyledCell(row,index++,info.getFinishQty() == null ? "0" : info.getFinishQty()+"",this.bodyRowStyle);
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
            if ("0".equals(info.getFlag())) {
            	createStyledCell(row,index++,"Not Delete",this.bodyRowStyle);
            } else if ("1".equals(info.getFlag())) {
            	createStyledCell(row,index++,"Delete",this.bodyRowStyle);
            } 
            if ("0".equals(info.getSapFlag())) {
            	createStyledCell(row,index++,"unDelivery",this.bodyRowStyle);
			} else if ("1".equals(info.getSapFlag())) {
            	createStyledCell(row,index++,"Posting Success",this.bodyRowStyle);
			} else if ("2".equals(info.getSapFlag())) {
            	createStyledCell(row,index++,"Posting Failure",this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getSapMsg(),this.bodyRowStyle);
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
