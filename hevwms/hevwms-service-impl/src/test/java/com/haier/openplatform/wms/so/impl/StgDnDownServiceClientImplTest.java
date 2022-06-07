package com.haier.openplatform.wms.so.impl;

import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
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
public class StgDnDownServiceClientImplTest {

    private StgDnDownServiceClientImpl clientImplMock = new StgDnDownServiceClientImpl();
    private StgDnDownService stgDnDownServiceMock;

    @Before
    public void init(){
        stgDnDownServiceMock = EasyMock.createMock(StgDnDownService.class);
        clientImplMock.setStgDnDownService(stgDnDownServiceMock);
    }

    @Test
    public void searchStgDnDown() {
        EasyMock.expect(stgDnDownServiceMock.searchStgDnDowns(
                (Pager<StgDnDownDTO>)EasyMock.anyObject(),
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgDnDownDTO>()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.searchStgDnDown(new Pager<StgDnDownDTO>(),new StgDnDownDTO());
    }

    @Test
    public void searchStgDnReverse() {
        EasyMock.expect(stgDnDownServiceMock.searchStgDnReverse(
                (Pager<StgDnDownDTO>)EasyMock.anyObject(),
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgDnDownDTO>()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.searchStgDnReverse(new Pager<StgDnDownDTO>(),new StgDnDownDTO());
    }

    @Test
    public void downStgDnDown() {
        EasyMock.expect(stgDnDownServiceMock.downloadDnFromSAP(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        try {
            clientImplMock.downStgDnDown("11","11","11","11");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStgDnDownsByParam() {
        EasyMock.expect(stgDnDownServiceMock.getStgDnDownsByParam(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgDnDownDTO>()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.getStgDnDownsByParam(new StgDnDownDTO());
    }

    @Test
    public void postDn() {
        EasyMock.expect(stgDnDownServiceMock.postDn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.expect(stgDnDownServiceMock.soGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.expect(stgDnDownServiceMock.soGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.postDn("1","1","1","1");
//        clientImplMock.postDn("1","0","1","1");
    }

    @Test
    public void postGiftDn(){
        InterfaceOutDTO result = new InterfaceOutDTO();
        result.setStatus("S");
        OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
        ret.setStatus("0");
        EasyMock.expect(stgDnDownServiceMock.postDn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(result);
        EasyMock.expect(stgDnDownServiceMock.giftSoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret);
        clientImplMock.postGiftDn("11","11","11","11");
    }

    @Test
    public void inoutWarehousePo(){
        OrderGoodsTransOutDTO orderGoodsTransOutDTO = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO.setStatus("0");
        EasyMock.expect(stgDnDownServiceMock.soGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO);
        EasyMock.expect(stgDnDownServiceMock.soGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.inoutWarehousePo("1","2","1");
        clientImplMock.inoutWarehousePo("1","1","1");
    }

    @Test
    public void giftInoutWarehousePo(){
        OrderGoodsTransOutDTO orderGoodsTransOutDTO = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO.setStatus("0");
        EasyMock.expect(stgDnDownServiceMock.giftSoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.giftInoutWarehousePo("1","1","1");
    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(stgDnDownServiceMock.getExportAmount(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.getExportAmount(new StgDnDownDTO());
    }

    @Test
    public void dnReverse() {
        EasyMock.expect(stgDnDownServiceMock.dnReverse(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.dnReverse(new OrderIgpInDTO());
    }
}