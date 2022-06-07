package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.hevwms.sto.service.StoPDAService;
import com.haier.openplatform.wms.remoting.dto.*;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:39
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StoPDAServiceClientImplTest {

    private StoPDAServiceClientImpl clientImplMock = new StoPDAServiceClientImpl();
    private StoPDAService stoPDAServiceMock;
    private StgStoDownService stgStoDownServiceMock;
    private StgStodnDownService stgStodnDownServiceMock;
    @Before
    public void init(){
        stoPDAServiceMock = EasyMock.createMock(StoPDAService.class);
        stgStoDownServiceMock = EasyMock.createMock(StgStoDownService.class);
        stgStodnDownServiceMock = EasyMock.createMock(StgStodnDownService.class);
        clientImplMock.setStoPDAService(stoPDAServiceMock);
        clientImplMock.setStgStodnDownService(stgStodnDownServiceMock);
        clientImplMock.setStgStoDownService(stgStoDownServiceMock);

    }

    @Test
    public void stoOrderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderCheckOutDTO result = new OrderCheckOutDTO();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.checkOrderByPDA(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(result).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.stoOrderCheck(new OrderCheckInDTO(),"1");
    }

    @Test
    public void stoOrderDownload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderLoadInDTO orderLoadInDTO_1 = new OrderLoadInDTO();
        OrderLoadInDTO orderLoadInDTO_2 = new OrderLoadInDTO();
        orderLoadInDTO_1.setOrdertype("1");
        orderLoadInDTO_2.setOrdertype("2");
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stgStodnDownServiceMock.downloadStodn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.expect(stgStoDownServiceMock.downloadSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(2);
        EasyMock.replay(stoPDAServiceMock);
        EasyMock.replay(stgStoDownServiceMock);
        EasyMock.replay(stgStodnDownServiceMock);
        clientImplMock.stoOrderDownload(orderLoadInDTO_1,"1","1");
        clientImplMock.stoOrderDownload(orderLoadInDTO_2,"1","1");

    }

    @Test
    public void stoOrderDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.stoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        clientImplMock.stoOrderDelete(new OrderDeleteInDTO(),"11");
    }

    @Test
    public void stoOrdersDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("111111111111");
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.stoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        clientImplMock.stoOrdersDelete(orderDeleteInDTO,"11");
    }

    @Test
    public void stoOrderIgp() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.stodnOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        clientImplMock.stoOrderIgp(new OrderIgpInDTO(),"1");
    }

    @Test
    public void stoOrderOgp() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderIgpInDTO orderIgpInDTO_1 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_2 = new OrderIgpInDTO();
        orderIgpInDTO_1.setOrderType("1");
        orderIgpInDTO_2.setOrderType("0");
        OrderIgpOutDTO orderIgpOutDTO_1 = new OrderIgpOutDTO();
        OrderIgpOutDTO orderIgpOutDTO_2 = new OrderIgpOutDTO();
        orderIgpOutDTO_1.setStatus("0");
        orderIgpOutDTO_2.setStatus("1");
        InterfaceOutDTO interfaceOutDTO_1 = new InterfaceOutDTO();
        InterfaceOutDTO interfaceOutDTO_2 = new InterfaceOutDTO();
        interfaceOutDTO_1.setStatus("S");
        interfaceOutDTO_2.setStatus("E");
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_1 = new OrderGoodsTransOutDTO();
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_2 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_1.setStatus("0");
        orderGoodsTransOutDTO_2.setStatus("1");

        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.stodnOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderIgpOutDTO_1).times(1).andReturn(orderIgpOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.postStodn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(interfaceOutDTO_1).times(1).andReturn(interfaceOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.expect(stoPDAServiceMock.stoOrderOgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderIgpOutDTO_1).times(1);
        EasyMock.expect(stgStoDownServiceMock.postSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(interfaceOutDTO_1).times(1).andReturn(interfaceOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(2);
        EasyMock.replay(stoPDAServiceMock);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.stoOrderOgp(orderIgpInDTO_1,"1");
        clientImplMock.stoOrderOgp(orderIgpInDTO_2,"1");
    }

    @Test
    public void barcodeList() {
        WmsOrderDelListInDTO wmsOrderDelListInDTO_1 = new WmsOrderDelListInDTO();
        WmsOrderDelListInDTO wmsOrderDelListInDTO_2 = new WmsOrderDelListInDTO();
        wmsOrderDelListInDTO_1.setOrderType("2");
        wmsOrderDelListInDTO_2.setOrderType("1");
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
//        clientImplMock.barcodeList(wmsOrderDelListInDTO_1);
//        clientImplMock.barcodeList(wmsOrderDelListInDTO_2);

    }

    @Test
    public void stoOrderUpload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.scanStoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        clientImplMock.stoOrderUpload(new OrderUploadInDTO(),"1");
    }

    @Test
    public void stodnOrderUpload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(stoPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stoPDAServiceMock.scanStodnCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        stoPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDAServiceMock);
        clientImplMock.stodnOrderUpload(new OrderUploadInDTO(),"111");
    }

    @Test
    public void inoutWarehouseSto() {
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_1 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_1.setStatus("1");
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_2 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_2.setStatus("0");
        EasyMock.expect(stgStoDownServiceMock.stoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.inoutWarehouseSto("1","1","1111");
        clientImplMock.inoutWarehouseSto("1","2","1111");
    }

    @Test
    public void stodnOrderUploadExcel() {
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_1 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_1.setStatus("1");
        OrderGoodsTransOutDTO orderGoodsTransOutDTO_2 = new OrderGoodsTransOutDTO();
        orderGoodsTransOutDTO_2.setStatus("0");
        EasyMock.expect(stgStoDownServiceMock.stoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.expect(stgStoDownServiceMock.stoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(orderGoodsTransOutDTO_1).times(1).andReturn(orderGoodsTransOutDTO_2).times(1);
        EasyMock.replay(stgStoDownServiceMock);
        clientImplMock.inoutWarehouseSto("1","1","1111");
        clientImplMock.stodnOrderUploadExcel(new OrderUploadInDTO());
    }
}
