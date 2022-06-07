package com.haier.wms.exceltemplate.po;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
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
 * @Date: 2019/5/16 15:10
 * @Description:
 */
public class ExportOdsPoScanInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsPoScanInfoDTO> list = new ArrayList<OdsPoScanInfoDTO>();
        OdsPoScanInfoDTO dto = new OdsPoScanInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsPoScanInfoListTemplet export = new ExportOdsPoScanInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}