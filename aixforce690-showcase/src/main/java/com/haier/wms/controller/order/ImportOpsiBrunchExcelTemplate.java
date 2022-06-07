package com.haier.wms.controller.order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.haier.wms.util.ExcelFormat;

/**
 * @ClassName: ImportExcelTemplate
 * @Description: 读取excel文件
 * 
 */
public class ImportOpsiBrunchExcelTemplate {
	// public String mess;

	/**
	 * @Title: importExcel
	 * @Description: 读取excel文件，封装对象
	 * @param @param fileData
	 * @param @return
	 * @param @throws Exception
	 * @return List<OdsContractInfoDTO>
	 * @throws
	 */
	public List<HashMap<String, Object>> importExcel(byte[] fileData)
			throws Exception {
		File tempFile;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		// 创建excel文件
		tempFile = File.createTempFile("excel", ".xlsx");
		FileOutputStream ots = new FileOutputStream(tempFile);
		// 将流写入文件
		ots.write(fileData);
		ots.flush();
		ots.close();
		FileInputStream is = new FileInputStream(tempFile);
		// 此方法创建自动判断2003还是2007
		Workbook workbook = WorkbookFactory.create(is);
		// 创建对工作表的引用
		Sheet sheet = workbook.getSheetAt(0);
		// 读取第一章表格内容
		Row row = null;
		ExcelFormat format = new ExcelFormat();
		int addSize = 0;
		int failSize = 0;
		int total = 0;
		// 读取excel内容，保存在对象中
		for (int i = 3; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			try {
				if (row != null) {
					total++;
					// 将excel中的内容保存在OdsContractInfoDTO
					String location = format.formatCellToString(row.getCell(0))
							.trim();
					if (location != null && !"".equals(location)) {
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("location",
								format.formatCellToString(row.getCell(0))
										.trim());
						map.put("matCode",
								format.formatCellToString(row.getCell(2))
										.trim());
						map.put("planDate",
								format.formatCellToString(row.getCell(7))
										.trim());
						map.put("qty",
								format.formatCellToDouble(row.getCell(8)));
						list.add(map);
					}

				}
			} catch (Exception e) {
				failSize++;
				continue;
			}
		}

		return list;

	}
}
