package com.haier.openplatform.wms.so.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.so.service.OdsSoScanInfoService;
import com.haier.hevwms.so.service.SoPDAService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:36
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,SpringApplicationContextHolder.class})
public class SoPDAServiceClientImplTest {

    private SoPDAServiceClientImpl clientImplMock = new SoPDAServiceClientImpl();
    private StgDnDownService stgDnDownServiceMock;
    private SoPDAService soPDAServiceMock;
    private OdsSoScanInfoService odsSoScanInfoService;

    @Before
    public void init(){
        stgDnDownServiceMock = EasyMock.createMock(StgDnDownService.class);
        soPDAServiceMock = EasyMock.createMock(SoPDAService.class);
        odsSoScanInfoService = EasyMock.createMock(OdsSoScanInfoService.class);
        clientImplMock.setSoPDAService(soPDAServiceMock);
        clientImplMock.setStgDnDownService(stgDnDownServiceMock);
        PowerMockito.mockStatic(UserUtil.class,SpringApplicationContextHolder.class);
        PowerMockito.when(SpringApplicationContextHolder.getBean("odsSoScanInfoService")).thenReturn(odsSoScanInfoService);
    }

    @Test
    public void soOrderCheck() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        RfLogResult rfLogResult_1 = new RfLogResult();
        rfLogResult_1.setStatus("E");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1).andReturn(rfLogResult_1).times(1);
        EasyMock.expect(stgDnDownServiceMock.checkSo(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.soOrderCheck(new OrderCheckInDTO(),"1");

    }

    @Test
    public void soOrderDownload() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(stgDnDownServiceMock.downloadDnFromSAP(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO()).times(1);
        EasyMock.expect(stgDnDownServiceMock.getSoMaterialList(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OrderMatListDTO>()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.soOrderDownload(new OrderLoadInDTO(),"1");
    }

    @Test
    public void soOrderDelete() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.soOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.soOrderDelete(new OrderDeleteInDTO(),"1");
    }

    @Test
    public void giftSoOrderDelete(){
        RfLogResult rfLogResult =new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.giftSoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        soPDAServiceMock.writeLog(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.giftSoOrderDelete(new OrderDeleteInDTO(),"11");
    }

    @Test
    public void soOrdersDelete() {
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("1111111111111111111111111");
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.soOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.soOrdersDelete(orderDeleteInDTO,"1");
    }

    @Test
    public void soOrderIgp() {
        RfLogResult rfLogResult = new RfLogResult();
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        OrderIgpInDTO orderIgpInDTO_1 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_2 = new OrderIgpInDTO();
        rfLogResult.setStatus("S");
        outResult.setStatus("0");
        orderIgpInDTO_1.setOrderType("1");
        orderIgpInDTO_2.setOrderType("2");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.soOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(outResult).times(1);
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
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.soOrderIgp(new OrderIgpInDTO(),"1");
    }

    @Test
    public void giftSoOrderIgp(){
        RfLogResult rfLogResult =new RfLogResult();
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        InterfaceOutDTO postResult = new InterfaceOutDTO();
        OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
        ret.setStatus("0");
        postResult.setStatus("S");
        rfLogResult.setStatus("S");
        outResult.setStatus("0");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.giftSoOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(outResult).times(1);
        EasyMock.expect(stgDnDownServiceMock.postDn(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(postResult).times(1);
        EasyMock.expect(stgDnDownServiceMock.giftSoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.giftSoOrderIgp(new OrderIgpInDTO(),"1");

    }

    @Test
    public void barcodeList() {
        List<OdsSoScanInfoDTO> list = new ArrayList<OdsSoScanInfoDTO>();
        OdsSoScanInfoDTO odsSoScanInfoDTO = new OdsSoScanInfoDTO();
        odsSoScanInfoDTO.setBarcode("11111111111");
        odsSoScanInfoDTO.setQty(100L);
        odsSoScanInfoDTO.setSoNo("11111111111");
        odsSoScanInfoDTO.setRowId(111L);
        list.add(odsSoScanInfoDTO);
        EasyMock.expect(odsSoScanInfoService.getOdsSoScanInfos(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(list);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        EasyMock.replay(odsSoScanInfoService);
        clientImplMock.barcodeList(new WmsOrderDelListInDTO());

    }

    @Test
    public void soOrderScan() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.scanSoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.soOrderScan(new OrderUploadInDTO(),"1");
    }

    @Test
    public void giftSoOrderScan(){
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.scanGiftSoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.giftSoOrderScan(new OrderUploadInDTO(),"111");

    }

    @Test
    public void soOrderScanOldBarcode() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(soPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(soPDAServiceMock.scanSoOldBarcodeCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        soPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDAServiceMock);
        clientImplMock.soOrderScanOldBarcode(new OrderUploadInDTO(),"1");
    }

    @Test
    public void getFifo() {
        EasyMock.expect(stgDnDownServiceMock.getFifoList(
                (WmsOrderDelListInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO()).times(1);
        EasyMock.replay(stgDnDownServiceMock);
        clientImplMock.getFifo(new WmsOrderDelListInDTO(),"1","1");
    }

    @Test
    public void soOrderScanBarcodeExcel() {
        clientImplMock.soOrderScanBarcodeExcel(new OrderUploadInDTO());
    }
}
