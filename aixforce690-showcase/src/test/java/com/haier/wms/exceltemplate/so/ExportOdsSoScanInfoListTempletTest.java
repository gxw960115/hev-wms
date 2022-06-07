package com.haier.wms.exceltemplate.so;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
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
 * @Date: 2019/5/16 15:15
 * @Description:
 */
public class ExportOdsSoScanInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsSoScanInfoDTO> list = new ArrayList<OdsSoScanInfoDTO>();
        OdsSoScanInfoDTO dto = new OdsSoScanInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsSoScanInfoListTemplet export = new ExportOdsSoScanInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}