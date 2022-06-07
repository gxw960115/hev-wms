package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.OdsPoGrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
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
 * @Date: 2019/3/22 14:27
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsPoGrInfoServiceClientImplTest {

    private OdsPoGrInfoServiceClientImpl clientImplMock = new OdsPoGrInfoServiceClientImpl();
    private OdsPoGrInfoService odsPoGrInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPoGrInfoServiceMock = EasyMock.createMock(OdsPoGrInfoService.class);
        clientImplMock.setOdsPoGrInfoService(odsPoGrInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoGrInfoListByPage() {
        EasyMock.expect(odsPoGrInfoServiceMock.searchOdsPoGrInfoListByPage(
                (Pager<OdsPoGrInfoDTO>)EasyMock.anyObject(),
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsPoGrInfoDTO>()).times(1);
        EasyMock.replay(odsPoGrInfoServiceMock);
        clientImplMock.searchOdsPoGrInfoListByPage(1L,10L,new OdsPoGrInfoDTO());
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
        EasyMock.expect(odsPoGrInfoServiceMock.getExportAmout(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsPoGrInfoServiceMock);
        clientImplMock.getExportAmount(new OdsPoGrInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsPoGrInfoListByParm() {
        EasyMock.expect(odsPoGrInfoServiceMock.getListByParm(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoGrInfoDTO>()).times(1);
        EasyMock.replay(odsPoGrInfoServiceMock);
        clientImplMock.getOdsPoGrInfoListByParm(new OdsPoGrInfoDTO());
    }
}