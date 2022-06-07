package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
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
 * @Date: 2019/3/22 14:39
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StgStoDownServiceClientImplTest {

    private StgStoDownServiceClientImpl clientImplMock = new StgStoDownServiceClientImpl();
    private StgStoDownService stgStoDownServiceMock;

    @Before
    public void init(){
        stgStoDownServiceMock = EasyMock.createMock(StgStoDownService.class);
        clientImplMock.setStgStoDownService(stgStoDownServiceMock);
    }

    @Test
    public void searchStgStoDown() {
        EasyMock.expect(stgStoDownServiceMock.searchStgStoDowns(
                (Pager<StgStoDownDTO>)EasyMock.anyObject(),
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStoDownDTO>()).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.searchStgStoDown(new Pager<StgStoDownDTO>(),new StgStoDownDTO());
    }

    @Test
    public void createStgStoDown() {

    }

    @Test
    public void getStgStoDowns() {
        EasyMock.expect(stgStoDownServiceMock.getStgStoDowns(
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgStoDownDTO>()).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.getStgStoDowns(new StgStoDownDTO());
    }

    @Test
    public void closeStgStoDown() {
        EasyMock.expect(stgStoDownServiceMock.closeStgStoDown(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.closeStgStoDown("","");
    }

    @Test
    public void openStgStoDown() {
        EasyMock.expect(stgStoDownServiceMock.openStgStoDown(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.openStgStoDown("1","1");
    }

    @Test
    public void confirmSto() {
        EasyMock.expect(stgStoDownServiceMock.updateStoConfirm(
                (String)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.confirmSto("1111111");
    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(stgStoDownServiceMock.getExportAmount(
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.getExportAmount(new StgStoDownDTO());
    }

    @Test
    public void downloadSto() {
        EasyMock.expect(stgStoDownServiceMock.downloadSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.downloadSto("111","111","111","111");
    }

    @Test
    public void postSto() {
        InterfaceOutDTO result_1 = new InterfaceOutDTO();
        InterfaceOutDTO result_2 = new InterfaceOutDTO();
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_1 = new OrderGoodsTransOutDTO();
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_2 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_1.setStatus("0");
        orderGoodsTransOutDTO_2.setStatus("1");
        result_1.setStatus("S");
        result_2.setStatus("E");
        EasyMock.expect(stgStoDownServiceMock.postStodn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(result_1).times(1).andReturn(result_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.postSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(result_1).times(1).andReturn(result_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.postSto("1","1","1","1","1");
        clientImplMock.postSto("1","1","0","1","1");
    }

    @Test
    public void getGiLocationNameListBySTONO() {
        EasyMock.expect(stgStoDownServiceMock.getGiLocationNameListBySTONO(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<String>()).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.getGiLocationNameListBySTONO("1111");
    }

    @Test
    public void getGrLocationNameListBySTONO() {
        EasyMock.expect(stgStoDownServiceMock.getGrLocationNameListBySTONO(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<String>()).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.getGrLocationNameListBySTONO("1111");
    }
}