package com.haier.wms.exceltemplate.so;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
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
 * @Date: 2019/5/16 15:16
 * @Description:
 */
public class ExportStgDnDownListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<StgDnDownDTO> list = new ArrayList<StgDnDownDTO>();
        StgDnDownDTO dto = new StgDnDownDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStgDnDownListTemplet export = new ExportStgDnDownListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}