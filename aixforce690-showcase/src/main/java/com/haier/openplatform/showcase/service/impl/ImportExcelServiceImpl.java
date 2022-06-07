package com.haier.openplatform.showcase.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.openplatform.hac.security.domain.User;
import com.haier.openplatform.showcase.service.ImportExcelService;
import com.haier.openplatform.util.ExecuteResult;

public class ImportExcelServiceImpl implements ImportExcelService {
	private static final Logger log = LoggerFactory.getLogger(ImportExcelServiceImpl.class);
	@Override
	public ExecuteResult<User> importExcel(byte[] fileData) {
		ExecuteResult<User> result = new ExecuteResult<User>();
		File tempFile;
		try {
			tempFile = File.createTempFile("excel", ".xlsx");
			FileOutputStream ots=new FileOutputStream(tempFile);
	    	ots.write(fileData);
	        ots.flush();
	        ots.close();
	        XSSFWorkbook wb; // 工作薄
			Sheet sheet; // 工作表
			FileInputStream f = new FileInputStream(tempFile);
			wb = new XSSFWorkbook(f);
			sheet = wb.getSheetAt(0);
			int rowNum = sheet.getPhysicalNumberOfRows();// 返回物理行数
			/* String type = ""; */
			for (int i = 2; i < rowNum; i++) {
				Row row = sheet.getRow(i);// 获取第i行数据
				if (!"".equals(getHSSTextString(row, 0).toString())) {
					/**
					 * 此处 用dubbo服务来 将数据存入数据库
					 */
					String name = getHSSTextString(row, 0);
					String nickName = getHSSTextString(row, 1);
					String email = getHSSTextString(row, 2);
					String phone = getHSSTextString(row, 3);
				}
			}
		} catch (IOException e) {
			log.debug("",e);
		}
		return result;
	}
	private String getHSSTextString(Row row, int colNum) {
		Cell cell = row.getCell(colNum);
		if (null != cell) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:

				return "";

			case HSSFCell.CELL_TYPE_STRING:
				return cell.getStringCellValue().trim();
			case HSSFCell.CELL_TYPE_BLANK: // 空值
				return "";
			case HSSFCell.CELL_TYPE_ERROR: // 故障
				return "";
			default:
				return "";
			}
		} else {
			return "";
		}
	}

}
