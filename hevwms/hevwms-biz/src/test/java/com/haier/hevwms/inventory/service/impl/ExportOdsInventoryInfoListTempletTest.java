package com.haier.hevwms.inventory.service.impl;

import com.haier.hevwms.inventory.domain.OdsInventoryInfo;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/13 17:20
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
        List<OdsInventoryInfo> list = new ArrayList<OdsInventoryInfo>();
        OdsInventoryInfo dto = new OdsInventoryInfo();
        list.add(dto);
        ExportOdsInventoryInfoListTemplet export = new ExportOdsInventoryInfoListTemplet(list);
        try {
            export.doExport(outputStream, dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}