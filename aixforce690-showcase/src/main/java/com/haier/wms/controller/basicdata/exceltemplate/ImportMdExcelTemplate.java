package com.haier.wms.controller.basicdata.exceltemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.wms.util.ExcelFormat;

/**  
 * @ClassName: ImportMdExcelTemplate  
 * @Description: TODO(导入物料excel)  
 * @author fanrong  
 * @date 2015-11-18 
 */ 
public class ImportMdExcelTemplate {

//	private String mess;
	/**  
	 * @Title: importMdMatInfo  
	 * @Description: TODO(导入物料excel)  
	 * @param fileData
	 * @param name
	 * @return
	 * @throws Exception
	 * @return List<MdMatInfoDTO> 
	 * @throws  
	 */  
	public List<MdMatInfoDTO> importMdMatInfo(byte[] fileData,String name) throws Exception {
		 File tempFile;
        List<MdMatInfoDTO> list = new ArrayList<MdMatInfoDTO>();
        // 创建excel文件
        tempFile = File.createTempFile("excel", ".xls");
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
                    MdMatInfoDTO mdMatInfo = new MdMatInfoDTO();
                    mdMatInfo.setMaterialNo(format.formatCellToString(row.getCell(0)));
                    mdMatInfo.setCustomerModel(row.getCell(1) == null? "" : format.formatCellToString(row.getCell(1)));
                    mdMatInfo.setMaterialDesp(row.getCell(2) == null? "" : format.formatCellToString(row.getCell(2)));
                    mdMatInfo.setPlant(row.getCell(3) == null? "" : format.formatCellToString(row.getCell(3)));
                    mdMatInfo.setExternalMatGroup(row.getCell(4) == null? "" : format.formatCellToString(row.getCell(4)));
                    mdMatInfo.setGrossWeight(row.getCell(5) == null? "" : format.formatCellToString(row.getCell(5)));
                    mdMatInfo.setNetWeight(row.getCell(6) == null? "" : format.formatCellToString(row.getCell(6)));
                    mdMatInfo.setSizeDimension(row.getCell(7) == null? "" : format.formatCellToString(row.getCell(7)));
                    mdMatInfo.setBasicUnit(row.getCell(8) == null? "" : format.formatCellToString(row.getCell(8)));
                    mdMatInfo.setDivision(row.getCell(9) == null? "" : format.formatCellToString(row.getCell(9)));
                    mdMatInfo.setInOut(row.getCell(10) == null? "" : format.formatCellToString(row.getCell(10)));
                    mdMatInfo.setProduceAttribute(row.getCell(10) == null? "" : format.formatCellToString(row.getCell(10)));
                    mdMatInfo.setMatScanType(row.getCell(11) == null? "" : format.formatCellToString(row.getCell(11)));
                    mdMatInfo.setRemark(row.getCell(12) == null? "" : format.formatCellToString(row.getCell(12)));
                    
                    if (row.getCell(13) != null) {
                        mdMatInfo.setLength(format.formatCellToDouble(row.getCell(13)));
                    }
                    
                    if (row.getCell(14) != null) {
                        mdMatInfo.setWidth(format.formatCellToDouble(row.getCell(14)));
                    }
                    
                    if (row.getCell(15) != null) {
                        mdMatInfo.setHigth(format.formatCellToDouble(row.getCell(15)));
                    }
                    
                    mdMatInfo.setModifyBy(name);
                    mdMatInfo.setModifyDate(new Date());
                    mdMatInfo.setActivestate("0");
                    list.add(mdMatInfo);
                }
				} catch (Exception e) {
					e.printStackTrace();
				}
				
            }
        return list;
	}
	
}