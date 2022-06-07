package com.haier.wms.exceltemplate.customer;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.wms.exceltemplate.consume.ExportOdsConsumeOrderTemplet;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 15:05
 * @Description:
 */
public class ExportCustomerOrderTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsCustomerOrderDTO> list = new ArrayList<OdsCustomerOrderDTO>();
        OdsCustomerOrderDTO dto = new OdsCustomerOrderDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportCustomerOrderTemplate export = new ExportCustomerOrderTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}