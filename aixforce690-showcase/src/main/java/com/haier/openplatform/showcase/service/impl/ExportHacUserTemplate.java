package com.haier.openplatform.showcase.service.impl;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.showcase.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.hac.security.domain.User;

public class ExportHacUserTemplate extends AbstractExcelExportTemplate<User>{

	@Override
	public String[] getSheetNames() {
		return new String[]{"用户模板"};
	}

	@Override
	public String[][] getTitles() {
		return new String[][]{{"登录名","用户名","邮箱","电话"}};
	}
	@Override
	public String[] getCaptions() {
		return new String[]{"用户模板信息"};
	}
	@Override
	protected void buildBody(int sheetIndex) {
		Sheet sheet = getSheet(sheetIndex);
		int startIndex = this.getBodyStartIndex(sheetIndex);
		sheet.setDefaultColumnStyle(0, getStringCellStyle());
		sheet.setDefaultColumnStyle(1, getStringCellStyle());
		sheet.setDefaultColumnStyle(2, getStringCellStyle());
		sheet.setDefaultColumnStyle(3, getStringCellStyle());
		for(int i = 0; i < 1; i++){
			Row row = sheet.createRow(i+startIndex);
			row.setHeight((short)300);
			int index = 0;
			/**
			 * 此处从dubbo服务来接受数据
			 */
			createStyledCell(row,index++,"0123456(实例)",getStringCellStyle());
			createStyledCell(row,index++,"张三(实例)",getStringCellStyle());
			createStyledCell(row,index++,"zhangs@haier.com(实例)",getStringCellStyle());
			createStyledCell(row,index++,"12345678(实例)",getStringCellStyle());
		}
		
	}
	protected CellStyle getStringCellStyle(){
		Font font = workbook.createFont();
		//font.setColor(HSSFColor.BLUE_GREY.index);
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
