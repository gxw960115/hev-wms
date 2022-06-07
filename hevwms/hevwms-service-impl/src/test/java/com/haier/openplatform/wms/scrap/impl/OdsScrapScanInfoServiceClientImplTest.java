package com.haier.openplatform.wms.scrap.impl;

import com.haier.hevwms.scrap.service.OdsScrapScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:32
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsScrapScanInfoServiceClientImplTest {

    private OdsScrapScanInfoServiceClientImpl clientImplMock = new OdsScrapScanInfoServiceClientImpl();
    private OdsScrapScanInfoService odsScrapScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsScrapScanInfoServiceMock = EasyMock.createMock(OdsScrapScanInfoService.class);
        clientImplMock.setOdsScrapScanInfoService(odsScrapScanInfoServiceMock);
        clientImplMock.getOdsScrapScanInfoService();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapScanInfoByPage() {
        EasyMock.expect(odsScrapScanInfoServiceMock.searchOdsScrapScanInfoByPage(
                (Pager<OdsScrapScanInfoDTO>)EasyMock.anyObject(),
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsScrapScanInfoDTO>()).times(1);
        EasyMock.replay(odsScrapScanInfoServiceMock);
        clientImplMock.searchOdsScrapScanInfoByPage(1L,10L,new OdsScrapScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getExportAmount() {
        EasyMock.expect(odsScrapScanInfoServiceMock.getExportAmount(
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsScrapScanInfoServiceMock);
        clientImplMock.getExportAmount(new OdsScrapScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsScrapScanInfos() {
        EasyMock.expect(odsScrapScanInfoServiceMock.getOdsScrapScanInfos(
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapScanInfoDTO>()).times(1);
        EasyMock.replay(odsScrapScanInfoServiceMock);
        clientImplMock.getOdsScrapScanInfos(new OdsScrapScanInfoDTO());
    }
}
