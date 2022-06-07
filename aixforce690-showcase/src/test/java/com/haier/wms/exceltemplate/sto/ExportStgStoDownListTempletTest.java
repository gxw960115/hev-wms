package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
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
 * @Date: 2019/5/16 15:20
 * @Description:
 */
public class ExportStgStoDownListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<StgStoDownDTO> list = new ArrayList<StgStoDownDTO>();
        StgStoDownDTO dto = new StgStoDownDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStgStoDownListTemplet export = new ExportStgStoDownListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}