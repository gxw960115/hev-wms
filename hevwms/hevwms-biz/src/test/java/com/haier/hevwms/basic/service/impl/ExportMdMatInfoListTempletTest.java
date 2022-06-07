package com.haier.hevwms.basic.service.impl;

import com.haier.hevwms.basic.domain.MdMatInfo;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.impl.ExportDiffInventoryListTemplet;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.excel.ExcelExportTemplate;
import com.sap.conn.jco.JCoDestinationManager;
import io.terminus.pampas.common.UserUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/13 15:37
 * @Description:
 */
public class ExportMdMatInfoListTempletTest {

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
        List<MdMatInfo> list = new ArrayList<MdMatInfo>();
        MdMatInfo dto = new MdMatInfo();
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