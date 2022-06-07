package com.haier.wms.controller.po.exceltemplate;

import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.wms.util.ExcelFormat;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ImportPoReceiptExcelTemplate
 * @Description: (导入直发派遣入库Po单excel)
 * @author fanrong
 * @date 2015-11-25
 */
public class ImportPoReceiptExcelTemplate {

    private static final Logger logger = Logger.getLogger(ImportPoReceiptExcelTemplate.class);

//	private String mess;
    /**
     * @Title: importInfo
     * @Description: (导入直发派遣入库Po单excel)
     * @param fileData
     * @param name
     * @return
     * @throws Exception
     * @return List<CdWhInfoDTO>
     * @throws
     */
    public List<OrderUploadInDTO> importInfo(byte[] fileData, String name) throws Exception {
        File tempFile;
        List<OrderUploadInDTO> list = new ArrayList<OrderUploadInDTO>();
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
                    OrderUploadInDTO inpara = new OrderUploadInDTO();
                    inpara.setUser(name);
                    inpara.setOrno(format.formatCellToString(row.getCell(0)));//orderNo`
                    inpara.setBarcode(format.formatCellToString(row.getCell(1)));  //barcode
                    inpara.setDoctype(format.formatCellToString(row.getCell(2)));//doctype  PO   so  STODN   STO
                    inpara.setOrdertype(format.formatCellToString(row.getCell(3)));//orderType  po1   so2  STODN1  STO2
                    inpara.setBin(format.formatCellToString(row.getCell(4)));//bin or location 可null
                    inpara.setQty(format.formatCellToString(row.getCell(5)));//qty 可null
                    inpara.setRemark(format.formatCellToString(row.getCell(6)));//remark 可null
                    inpara.setVersion("HEV");
//						inpara.setSign(format.formatCellToString(row.getCell(4)));//sign 固定值 95ec63e3e6f06fca6d9fa6065da4a9cd
//						inpara.setReturnType(format.formatCellToString(row.getCell(8)));//returnType
                    list.add(inpara);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        logger.info(list);
        return list;
    }
}
