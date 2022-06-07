package com.haier.wms.template.stocktaking;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;
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
 * @Date: 2019/5/16 15:28
 * @Description:
 */
public class ExportStocktakingorderTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsPdInfoDTO> list = new ArrayList<OdsPdInfoDTO>();
        OdsPdInfoDTO dto = new OdsPdInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStocktakingorderTemplate export = new ExportStocktakingorderTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}