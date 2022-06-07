package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
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
 * @Date: 2019/5/16 15:17
 * @Description:
 */
public class ExportOdsStoCustScanInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsStoCustScanInfoDTO> list = new ArrayList<OdsStoCustScanInfoDTO>();
        OdsStoCustScanInfoDTO dto = new OdsStoCustScanInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsStoCustScanInfoListTemplet export = new ExportOdsStoCustScanInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}