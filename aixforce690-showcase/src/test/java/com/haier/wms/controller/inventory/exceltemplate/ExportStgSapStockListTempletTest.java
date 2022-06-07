package com.haier.wms.controller.inventory.exceltemplate;

import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 10:32
 * @Description:
 */
public class ExportStgSapStockListTempletTest {

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void buildBody() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("1.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<StgSapStockDTO> list = new ArrayList<StgSapStockDTO>();
        StgSapStockDTO dto = new StgSapStockDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportStgSapStockListTemplet export = new ExportStgSapStockListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}