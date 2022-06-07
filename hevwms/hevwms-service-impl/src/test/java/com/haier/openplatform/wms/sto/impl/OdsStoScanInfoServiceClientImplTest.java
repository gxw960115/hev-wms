package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.OdsStoScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:38
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsStoScanInfoServiceClientImplTest {

    private OdsStoScanInfoServiceClientImpl clientImplMock = new OdsStoScanInfoServiceClientImpl();
    private OdsStoScanInfoService odsStoScanInfoServiceMock;

    @Before
    public void init(){
        odsStoScanInfoServiceMock = EasyMock.createMock(OdsStoScanInfoService.class);
        clientImplMock.setOdsStoScanInfoService(odsStoScanInfoServiceMock);
    }

    @Test
    public void searchOdsStoScanInfoByPage() {
        EasyMock.expect(odsStoScanInfoServiceMock.searchOdsStoScanInfoByPage(
                (Pager<OdsStoScanInfoDTO>)EasyMock.anyObject(),
                (OdsStoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsStoScanInfoDTO>()).times(1);
        EasyMock.replay(odsStoScanInfoServiceMock);
        clientImplMock.searchOdsStoScanInfoByPage(1L,10L,new OdsStoScanInfoDTO());
    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(odsStoScanInfoServiceMock.getExportAmount(
                (OdsStoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsStoScanInfoServiceMock);
        clientImplMock.getExportAmount(new OdsStoScanInfoDTO());
    }

    @Test
    public void getOdsStoScanInfos() {

        EasyMock.expect(odsStoScanInfoServiceMock.getOdsStoScanInfos(
                (OdsStoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsStoScanInfoDTO>()).times(1);
        EasyMock.replay(odsStoScanInfoServiceMock);
        clientImplMock.getOdsStoScanInfos(new OdsStoScanInfoDTO());
    }

    @Test
    public void printStoDetail() {
        clientImplMock.printStoDetail("",new HashMap<String, Object>());
    }
}