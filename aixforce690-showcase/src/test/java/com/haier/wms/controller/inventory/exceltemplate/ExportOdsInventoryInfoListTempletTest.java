package com.haier.wms.controller.inventory.exceltemplate;

import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 10:31
 * @Description:
 */
public class ExportOdsInventoryInfoListTempletTest {

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
        List<OdsInventoryInfoDTO> list = new ArrayList<OdsInventoryInfoDTO>();
        OdsInventoryInfoDTO dto = new OdsInventoryInfoDTO();
        dto.setMaterialNo("111");
        list.add(dto);
        ExportOdsInventoryInfoListTemplet export = new ExportOdsInventoryInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}