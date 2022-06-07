package com.haier.wms.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;

/**
 * excel格式化类
 *
 * @author yuq
 *
 */
public class ExcelFormat {
	/**
	 * 将excel表格的内容转string
	 *
	 * @param cell
	 * @return String
	 */
	public String formatCellToString(Cell cell) {

		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:// 数值型
			String numberValue = String.valueOf(cell.getNumericCellValue());
//			if(numberValue.lastIndexOf(".") == -1) {
//				return numberValue.substring(0, numberValue.lastIndexOf("E"));
//			}
//			return numberValue.replace(".","").substring(0, numberValue.lastIndexOf("E")-1);
			return numberValue;
//            return cell.getRichStringCellValue().toString();
		case HSSFCell.CELL_TYPE_STRING: // 字符串型
			return cell.getRichStringCellValue().toString();
		case HSSFCell.CELL_TYPE_FORMULA:// 公式型
			String value = "NaN";
			try {
				value = String.valueOf(cell.getNumericCellValue());
			} catch (Exception e) {
				if (("NaN").equals(value))// 如果获取的数据值为非法值,则转换为获取字符串
				{
					return cell.getRichStringCellValue().toString();
				}
			}
			return value;

		case HSSFCell.CELL_TYPE_BOOLEAN:// 布尔
			return String.valueOf(cell.getBooleanCellValue());
		case HSSFCell.CELL_TYPE_BLANK:// 空值
			return "";
		case HSSFCell.CELL_TYPE_ERROR:// 出错
			return "";
		default:
			return cell.getRichStringCellValue().toString();
		}
	}

	/**
	 * 将excel表格内容转double
	 *
	 * @param cell
	 * @return double
	 */
	public double formatCellToDouble(Cell cell) {
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:// 数值型
			return cell.getNumericCellValue();
		case HSSFCell.CELL_TYPE_STRING: // 字符串型
			return Double.parseDouble(cell.getRichStringCellValue().toString());
		case HSSFCell.CELL_TYPE_BLANK:// 空值
			return 0;
		case HSSFCell.CELL_TYPE_ERROR:// 出错
			return 0;
		default:
			return Double.parseDouble(cell.getRichStringCellValue().toString());
		}
	}
}
