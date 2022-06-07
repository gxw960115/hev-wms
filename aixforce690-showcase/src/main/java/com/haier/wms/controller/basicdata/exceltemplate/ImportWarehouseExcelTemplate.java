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

import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.wms.util.ExcelFormat;

/**  
 * @ClassName: ImportWarehouseExcelTemplate  
 * @Description: (导入仓库excel)  
 * @author fanrong
 * @date 2015-11-25 
 */ 
public class ImportWarehouseExcelTemplate {

//	private String mess;
	/**  
	 * @Title: importInfo  
	 * @Description: (导入仓库excel)  
	 * @param fileData
	 * @param name
	 * @return
	 * @throws Exception
	 * @return List<CdWhInfoDTO> 
	 * @throws  
	 */  
	public List<CdWhInfoDTO> importInfo(byte[] fileData,String name) throws Exception {
		 File tempFile;
        List<CdWhInfoDTO> list = new ArrayList<CdWhInfoDTO>();
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
//            mess = "success";
                try {
					if (row != null) {
						CdWhInfoDTO cdWhInfoDTO = new CdWhInfoDTO();
						cdWhInfoDTO.setModifyBy(name);
						cdWhInfoDTO.setCode(format.formatCellToString(row.getCell(0)));
						cdWhInfoDTO.setName(format.formatCellToString(row.getCell(1)));
						cdWhInfoDTO.setRemark(format.formatCellToString(row.getCell(2)));
						list.add(cdWhInfoDTO);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
            }
        return list;
	}
}