package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.sto.dto.OdsStodnGigrInfoDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: ExportOdsStoGigrInfoListTemplet.java
 * @description: 
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年11月15日 下午6:02:06
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年11月15日		LJZ			v1.0.0			create
 */

public class ExportOdsStoDnGigrInfoListTemplet extends AbstractExcelExportTemplate<OdsStodnGigrInfoDTO> {

	private List<OdsStodnGigrInfoDTO> odsStoDnGigrInfoList;

	public ExportOdsStoDnGigrInfoListTemplet(List<OdsStodnGigrInfoDTO> odsStoDnGigrInfoList) {
		this.odsStoDnGigrInfoList = odsStoDnGigrInfoList;
		this.columnWidth = 4000;
	}
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"ODS_STODN_GIGR_INFO"};
	}

	/**
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"Order NO","Order Type","Scanned Qty","Unit","Material No","Material Desp","STO NO","STO DN NO","Plant","Location","SAP Flag","SAP Msg","Post By","Post Date","Car No","TranspoterName","Create Date"}};
	}

	@Override
	public String[] getCaptions() {
		return new String[]{"ODS_STODN_GIGR_INFO"};
	}

	/**
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 */
	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		final int size = odsStoDnGigrInfoList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;

			OdsStodnGigrInfoDTO info = odsStoDnGigrInfoList.get(i);
			
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
			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty().toString(),this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}

			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStoNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getStodnNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
			if ("0".equals(info.getTmsFlag())) {
            	createStyledCell(row,index++,"generation",this.bodyRowStyle);
			} else if ("1".equals(info.getTmsFlag())) {
            	createStyledCell(row,index++,"posted success",this.bodyRowStyle);
			} else if ("2".equals(info.getTmsFlag())) {
            	createStyledCell(row,index++,"posted failed",this.bodyRowStyle);
			} else if ("3".equals(info.getTmsFlag())) {
				createStyledCell(row,index++,"locked",this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getTmsMsg(),this.bodyRowStyle);
            if (StringUtils.isNotBlank(info.getCreateBy())) {
            	createStyledCell(row,index++,info.getCreateBy(),this.bodyRowStyle);
			}else {
				createStyledCell(row,index++,info.getCreateBy(),this.bodyRowStyle);
			}
            createStyledCell(row,index++,info.getPostDate(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getCarNo(),this.bodyRowStyle);
            createStyledCell(row,index++,info.getTransporter(),this.bodyRowStyle);
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
