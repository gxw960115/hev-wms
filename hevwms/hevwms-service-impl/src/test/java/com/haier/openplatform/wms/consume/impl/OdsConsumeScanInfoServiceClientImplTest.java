package com.haier.openplatform.wms.consume.impl;

import com.haier.hevwms.consume.service.OdsConsumeScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/21 15:26
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsConsumeScanInfoServiceClientImplTest {


    private OdsConsumeScanInfoServiceClientImpl clientImplMock = new OdsConsumeScanInfoServiceClientImpl();
    private OdsConsumeScanInfoService odsConsumeScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsConsumeScanInfoServiceMock = EasyMock.createMock(OdsConsumeScanInfoService.class);
        clientImplMock.setOdsConsumeScanInfoService(odsConsumeScanInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeScanInfoByPage() {
        Pager<OdsConsumeScanInfoDTO> pager = new Pager<OdsConsumeScanInfoDTO>();
        EasyMock.expect(odsConsumeScanInfoServiceMock.searchOdsConsumeScanInfoByPage(
                (Pager<OdsConsumeScanInfoDTO>)EasyMock.anyObject(),
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())).andReturn(pager).times(1);
        EasyMock.replay(odsConsumeScanInfoServiceMock);
        clientImplMock.searchOdsConsumeScanInfoByPage(1L,10L,new OdsConsumeScanInfoDTO());
        EasyMock.verify(odsConsumeScanInfoServiceMock);
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
        clientImplMock.getExportAmount(new OdsConsumeScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsConsumeScanInfos() {
        clientImplMock.getOdsConsumeScanInfos(new OdsConsumeScanInfoDTO());
    }
}