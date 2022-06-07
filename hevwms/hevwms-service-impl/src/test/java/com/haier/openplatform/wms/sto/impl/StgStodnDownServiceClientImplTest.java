package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:39
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StgStodnDownServiceClientImplTest {

    private StgStodnDownServiceClientImpl clientImplMock = new StgStodnDownServiceClientImpl();
    private StgStodnDownService stgStodnDownServiceMock;

    @Before
    public void init(){
        stgStodnDownServiceMock = EasyMock.createMock(StgStodnDownService.class);
        clientImplMock.setStgStodnDownService(stgStodnDownServiceMock);
    }

    @Test
    public void searchStgStodnDowns() {
        EasyMock.expect(stgStodnDownServiceMock.searchStgStodnDowns(
                (Pager<StgStodnDownDTO>)EasyMock.anyObject(),
                (StgStodnDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStodnDownDTO>()).times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.searchStgStodnDowns(1L,10L,new StgStodnDownDTO());
    }

    @Test
    public void getStgStodnDownListByParm() {
        EasyMock.expect(stgStodnDownServiceMock.getStgStodnDownListByParm(
                (StgStodnDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgStodnDownDTO>()).times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.getStgStodnDownListByParm(new StgStodnDownDTO());
    }

    @Test
    public void postStnDn() {
        EasyMock.expect(stgStodnDownServiceMock.postStnDn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.postStnDn("1","1");
    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(stgStodnDownServiceMock.getExportAmount(
                (StgStodnDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.getExportAmount(new StgStodnDownDTO());
    }

    @Test
    public void downloadStodn() {

        EasyMock.expect(stgStodnDownServiceMock.downloadStodn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.downloadStodn("1","1","1");
    }

    @Test
    public void getGrLocationNameListByStodnNo() {
        EasyMock.expect(stgStodnDownServiceMock.getGrLocationNameListByStodnNo(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<String>()).times(1);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.getGrLocationNameListByStodnNo("1111");
    }

    @Test
    public void searchStgStoDnDownsFromFactory() {
        Pager<StgStodnDownDTO> pager = new Pager<>();
        StgStodnDownDTO dto = new StgStodnDownDTO();
        clientImplMock.searchStgStoDnDownsFromFactory(pager, dto);
    }
}
