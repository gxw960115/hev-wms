package com.haier.wms.exceltemplate.so;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
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
 * @Date: 2019/5/16 15:14
 * @Description:
 */
public class ExportOdsSoGrInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsSoGrInfoDTO> list = new ArrayList<OdsSoGrInfoDTO>();
        OdsSoGrInfoDTO dto = new OdsSoGrInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsSoGrInfoListTemplet export = new ExportOdsSoGrInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}