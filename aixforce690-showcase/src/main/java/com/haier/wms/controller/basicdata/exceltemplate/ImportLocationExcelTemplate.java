package com.haier.wms.controller.basicdata.exceltemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.wms.util.ExcelFormat;

/**  
 * @ClassName: ImportLocationExcelTemplate  
 * @Description: (导入仓库地点)  
 * @author hanty  
 * @date 2015-4-20  
 */ 
public class ImportLocationExcelTemplate {

	/**  
	 * @Title: importInfo  
	 * @Description: (导入仓库地点)  
	 * @param fileData
	 * @param username
	 * @return
	 * @throws Exception
	 * @return List<CdLocInfoDTO> 
	 * @throws  
	 */  
	public List<CdLocInfoDTO> importInfo(byte[] fileData,String username) throws Exception {
		 File tempFile;
        List<CdLocInfoDTO> list = new ArrayList<CdLocInfoDTO>();
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
        // 读取excel内容，保存在对象中
        for (int i = sheet.getFirstRowNum() + 1; i < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
                try {
					if (row != null) {
						CdLocInfoDTO cdLocInfo = new CdLocInfoDTO();
						cdLocInfo.setCode(format.formatCellToString(row.getCell(0)));
						cdLocInfo.setName(format.formatCellToString(row.getCell(1)));
						cdLocInfo.setWhCode(format.formatCellToString(row.getCell(2)));
						cdLocInfo.setRemark(format.formatCellToString(row.getCell(3)));
						cdLocInfo.setLocationType(format.formatCellToString(row.getCell(4)));
						cdLocInfo.setModifyBy(username);
						list.add(cdLocInfo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
            }
        return list;
	}
}
