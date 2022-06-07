package com.haier.wms.exceltemplate.transfer;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
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
 * @Date: 2019/5/16 15:22
 * @Description:
 */
public class ExportTransferDtlTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsTransferDtlDTO> list = new ArrayList<OdsTransferDtlDTO>();
        OdsTransferDtlDTO dto = new OdsTransferDtlDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportTransferDtlTemplate export = new ExportTransferDtlTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}