package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
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
 * @Date: 2019/5/16 15:21
 * @Description:
 */
public class ExportStoCustTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsStoCustDTO> list = new ArrayList<OdsStoCustDTO>();
        OdsStoCustDTO dto = new OdsStoCustDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStoCustTemplate export = new ExportStoCustTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}