package com.haier.wms.controller.basicdata.exceltemplate;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 11:11
 * @Description:
 */
@RunWith(PowerMockRunner.class)
public class ExportMdMatInfoListTempletTest{

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
        List<MdMatInfoDTO> list = new ArrayList<MdMatInfoDTO>();
        MdMatInfoDTO dto = new MdMatInfoDTO();
        dto.setMaterialNo("111");
        dto.setLength(1D);
        dto.setWidth(2D);
        dto.setHigth(3D);
        list.add(dto);
        ExportMdMatInfoListTemplet export = new ExportMdMatInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}