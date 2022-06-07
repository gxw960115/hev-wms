package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
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
 * @Date: 2019/3/22 14:27
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsOrderInfoDtlServiceClientImplTest {

    private OdsOrderInfoDtlServiceClientImpl clientImplMock = new OdsOrderInfoDtlServiceClientImpl();
    private OdsOrderInfoDtlService odsOrderInfoDtlServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsOrderInfoDtlServiceMock = EasyMock.createMock(OdsOrderInfoDtlService.class);
        clientImplMock.setOdsOrderInfoDtlService(odsOrderInfoDtlServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsOrderDtls() {
        EasyMock.expect(odsOrderInfoDtlServiceMock.searchOdsOrderInfoDtls(
                (Pager<OdsOrderInfoDtlDTO>)EasyMock.anyObject(),
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsOrderInfoDtlDTO>()).times(1);
        EasyMock.replay(odsOrderInfoDtlServiceMock);
        clientImplMock.searchOdsOrderDtls(1L,10L,new OdsOrderInfoDtlDTO());
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
        EasyMock.expect(odsOrderInfoDtlServiceMock.getExportAmount(
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsOrderInfoDtlServiceMock);
        clientImplMock.getExportAmount(new OdsOrderInfoDtlDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void serchOdsOrderDtlsBy() {

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfoDtls() {
        EasyMock.expect(odsOrderInfoDtlServiceMock.getOdsOrderInfoDtls(
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsOrderInfoDtlDTO>()).times(1);
        EasyMock.replay(odsOrderInfoDtlServiceMock);
        clientImplMock.getOdsOrderInfoDtls(new OdsOrderInfoDtlDTO());
    }
}