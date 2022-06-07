package com.haier.wms.exceltemplate.consume;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.wms.controller.report.exceltemplate.ExportConsignmentReportTemplate;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 15:03
 * @Description:
 */
public class ExportOdsConsumeOrderTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsConsumeOrderDTO> list = new ArrayList<OdsConsumeOrderDTO>();
        OdsConsumeOrderDTO dto = new OdsConsumeOrderDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsConsumeOrderTemplet export = new ExportOdsConsumeOrderTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}