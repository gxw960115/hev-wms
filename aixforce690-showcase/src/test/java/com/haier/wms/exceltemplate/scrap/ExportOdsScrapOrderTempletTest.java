package com.haier.wms.exceltemplate.scrap;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
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
 * @Date: 2019/5/16 15:13
 * @Description:
 */
public class ExportOdsScrapOrderTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsScrapOrderDTO> list = new ArrayList<OdsScrapOrderDTO>();
        OdsScrapOrderDTO dto = new OdsScrapOrderDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsScrapOrderTemplet export = new ExportOdsScrapOrderTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}