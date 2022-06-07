package com.haier.wms.template.stocktaking;

import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
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
 * @Date: 2019/5/16 15:23
 * @Description:
 */
public class ExportDispatchPlanTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<MdMatInfoDTO> list = new ArrayList<MdMatInfoDTO>();
        MdMatInfoDTO dto = new MdMatInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportDispatchPlanTemplate export = new ExportDispatchPlanTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}