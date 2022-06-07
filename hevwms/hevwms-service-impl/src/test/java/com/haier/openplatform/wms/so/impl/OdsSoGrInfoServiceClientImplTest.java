package com.haier.openplatform.wms.so.impl;

import com.haier.hevwms.so.service.OdsSoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
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
 * @Date: 2019/3/22 14:36
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsSoGrInfoServiceClientImplTest {

    private OdsSoGrInfoServiceClientImpl clientImplMock = new OdsSoGrInfoServiceClientImpl();
    private OdsSoGrInfoService odsSoGrInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsSoGrInfoServiceMock = EasyMock.createMock(OdsSoGrInfoService.class);
        clientImplMock.setOdsSoGrInfoService(odsSoGrInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsSoGrInfoListByPage() {
        EasyMock.expect(odsSoGrInfoServiceMock.searchOdsSoGrInfoListByPage(
                (Pager<OdsSoGrInfoDTO>)EasyMock.anyObject(),
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsSoGrInfoDTO>()).times(1);
        EasyMock.replay(odsSoGrInfoServiceMock);
        clientImplMock.searchOdsSoGrInfoListByPage(1L,10L,new OdsSoGrInfoDTO());
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
        EasyMock.expect(odsSoGrInfoServiceMock.getExportAmout(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsSoGrInfoServiceMock);
        clientImplMock.getExportAmount(new OdsSoGrInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsSoGrInfoListByParm() {
        EasyMock.expect(odsSoGrInfoServiceMock.getListByParm(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsSoGrInfoDTO>()).times(1);
        EasyMock.replay(odsSoGrInfoServiceMock);
        clientImplMock.getOdsSoGrInfoListByParm(new OdsSoGrInfoDTO());
    }
}