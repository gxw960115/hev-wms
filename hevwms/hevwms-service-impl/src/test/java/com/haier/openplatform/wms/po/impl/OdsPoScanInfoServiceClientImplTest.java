package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.OdsPoScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:28
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsPoScanInfoServiceClientImplTest {

    private OdsPoScanInfoServiceClientImpl clientImplMock = new OdsPoScanInfoServiceClientImpl();
    private OdsPoScanInfoService odsPoScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPoScanInfoServiceMock= EasyMock.createMock(OdsPoScanInfoService.class);
        clientImplMock.setOdsPoScanInfoService(odsPoScanInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoScanInfoByPage() {
        EasyMock.expect(odsPoScanInfoServiceMock.searchOdsPoScanInfoByPage(
                (Pager<OdsPoScanInfoDTO>)EasyMock.anyObject(),
                (OdsPoScanInfoDTO)EasyMock.anyObject())).andReturn(new Pager<OdsPoScanInfoDTO>()).times(1);
        EasyMock.replay(odsPoScanInfoServiceMock);
        clientImplMock.searchOdsPoScanInfoByPage(1L,10L,new OdsPoScanInfoDTO());
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
        EasyMock.expect(odsPoScanInfoServiceMock.getExportAmount(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsPoScanInfoServiceMock);
        clientImplMock.getExportAmount(new OdsPoScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsPoScanInfos() {
        EasyMock.expect(odsPoScanInfoServiceMock.getOdsPoScanInfos(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoScanInfoDTO>()).times(1);
        EasyMock.replay(odsPoScanInfoServiceMock);
        clientImplMock.getOdsPoScanInfos(new OdsPoScanInfoDTO());
    }
}