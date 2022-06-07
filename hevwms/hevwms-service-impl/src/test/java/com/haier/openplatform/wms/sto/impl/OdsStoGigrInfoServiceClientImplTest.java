package com.haier.openplatform.wms.sto.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.sto.service.OdsStoGigrInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:37
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsStoGigrInfoServiceClientImplTest {

    private OdsStoGigrInfoServiceClientImpl clientImplMock = new OdsStoGigrInfoServiceClientImpl();
    private OdsStoGigrInfoService odsStoGigrInfoServiceMock;

    @Before
    public void init(){
        odsStoGigrInfoServiceMock = EasyMock.createMock(OdsStoGigrInfoService.class);
        clientImplMock.setOdsStoGigrInfoService(odsStoGigrInfoServiceMock);
    }

    @Test
    public void searchOdsStoGigrInfoByPage() {
        EasyMock.expect(odsStoGigrInfoServiceMock.getListByPage(
                (Pager<OdsStoGigrInfoDTO>)EasyMock.anyObject(),
                (OdsStoGigrInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsStoGigrInfoDTO>()).times(1);
        EasyMock.replay(odsStoGigrInfoServiceMock);
        clientImplMock.searchOdsStoGigrInfoByPage(1L,10L,new OdsStoGigrInfoDTO());
    }

    @Test
    public void getExportOdsStoGigrInfoAmount() {
        EasyMock.expect(odsStoGigrInfoServiceMock.getOdsStoGigrInfoCountByParm(
                (OdsStoGigrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsStoGigrInfoServiceMock);
        clientImplMock.getExportOdsStoGigrInfoAmount(new OdsStoGigrInfoDTO());
    }

    @Test
    public void getStoGigrInfoListByParm() {
        EasyMock.expect(odsStoGigrInfoServiceMock.getListByParm(
                (OdsStoGigrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsStoGigrInfoDTO>()).times(1);
        EasyMock.replay(odsStoGigrInfoServiceMock);
        clientImplMock.getStoGigrInfoListByParm(new OdsStoGigrInfoDTO());
    }
}