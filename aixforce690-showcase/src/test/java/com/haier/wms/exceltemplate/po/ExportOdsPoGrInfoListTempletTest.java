package com.haier.wms.exceltemplate.po;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
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
 * @Date: 2019/5/16 15:09
 * @Description:
 */
public class ExportOdsPoGrInfoListTempletTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsPoGrInfoDTO> list = new ArrayList<OdsPoGrInfoDTO>();
        OdsPoGrInfoDTO dto = new OdsPoGrInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsPoGrInfoListTemplet export = new ExportOdsPoGrInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}