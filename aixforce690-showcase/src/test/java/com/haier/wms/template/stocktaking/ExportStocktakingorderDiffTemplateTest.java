package com.haier.wms.template.stocktaking;

import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;
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
 * @Date: 2019/5/16 15:24
 * @Description:
 */
public class ExportStocktakingorderDiffTemplateTest {

    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<OdsPdDiffDtlDTO> list = new ArrayList<OdsPdDiffDtlDTO>();
        OdsPdDiffDtlDTO dto = new OdsPdDiffDtlDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStocktakingorderDiffTemplate export = new ExportStocktakingorderDiffTemplate(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}