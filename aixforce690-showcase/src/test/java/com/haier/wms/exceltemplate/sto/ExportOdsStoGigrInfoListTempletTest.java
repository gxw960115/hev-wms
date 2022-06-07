package com.haier.wms.exceltemplate.sto;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
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
 * @Date: 2019/5/16 15:18
 * @Description:
 */
public class ExportOdsStoGigrInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsStoGigrInfoDTO> list = new ArrayList<OdsStoGigrInfoDTO>();
        OdsStoGigrInfoDTO dto = new OdsStoGigrInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsStoGigrInfoListTemplet export = new ExportOdsStoGigrInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}