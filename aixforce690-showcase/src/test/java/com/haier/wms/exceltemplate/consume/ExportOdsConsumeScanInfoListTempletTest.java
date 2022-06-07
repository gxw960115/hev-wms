package com.haier.wms.exceltemplate.consume;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 15:04
 * @Description:
 */
public class ExportOdsConsumeScanInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsConsumeScanInfoDTO> list = new ArrayList<OdsConsumeScanInfoDTO>();
        OdsConsumeScanInfoDTO dto = new OdsConsumeScanInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsConsumeScanInfoListTemplet export = new ExportOdsConsumeScanInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}