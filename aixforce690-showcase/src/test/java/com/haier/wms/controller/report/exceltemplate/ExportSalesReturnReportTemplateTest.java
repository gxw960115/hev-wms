package com.haier.wms.controller.report.exceltemplate;

import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 14:52
 * @Description:
 */
public class ExportSalesReturnReportTemplateTest {

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void buildBody() {

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<SalesReturnReportDTO> list = new ArrayList<SalesReturnReportDTO>();
        SalesReturnReportDTO dto = new SalesReturnReportDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportSalesReturnReportTemplate export = new ExportSalesReturnReportTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}