package com.haier.openplatform.wms.sto.impl;

import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.xml.ws.WebServiceContext;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sto.service.OdsStoCustScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:37
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsStoCustScanInfoServiceClientImplTest {

    private OdsStoCustScanInfoServiceClientImpl clientImplMock = new OdsStoCustScanInfoServiceClientImpl();
    private RfWsService rfWsServiceMock;
    private OdsStoCustScanInfoService odsStoCustScanInfoServiceMock;

    @Before
    public void init(){
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        odsStoCustScanInfoServiceMock = EasyMock.createMock(OdsStoCustScanInfoService.class);
        clientImplMock.setRfWsService(rfWsServiceMock);
        clientImplMock.setOdsStoCustScanInfoService(odsStoCustScanInfoServiceMock);
    }

    @Test
    public void searchOdsStoCustScanInfoByPage() {

        EasyMock.expect(odsStoCustScanInfoServiceMock.searchOdsStoCustScanInfoByPage(
                (Pager<OdsStoCustScanInfoDTO>)EasyMock.anyObject(),
                (OdsStoCustScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsStoCustScanInfoDTO>()).times(1);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        clientImplMock.searchOdsStoCustScanInfoByPage(1L,10L,new OdsStoCustScanInfoDTO());


    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(odsStoCustScanInfoServiceMock.getExportAmount(
                (OdsStoCustScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        clientImplMock.getExportAmount(new OdsStoCustScanInfoDTO());
    }

    @Test
    public void getOdsStoCustScanInfos() {
        EasyMock.expect(odsStoCustScanInfoServiceMock.getOdsStoCustScanInfos(
                (OdsStoCustScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsStoCustScanInfoDTO>()).times(1);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        clientImplMock.getOdsStoCustScanInfos(new OdsStoCustScanInfoDTO());

    }

    @Test
    public void orderDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsStoCustScanInfoServiceMock.orderDelete(
                (WmsOrderDeleteIn)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        try {
            clientImplMock.orderDelete(new OrderDeleteInDTO(),"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ordersDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderDeleteInDTO d = new OrderDeleteInDTO();
        d.setBarcode("1111111");
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsStoCustScanInfoServiceMock.orderDelete(
                (WmsOrderDeleteIn)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        try {
            clientImplMock.ordersDelete(d,"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void orderScan() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsStoCustScanInfoServiceMock.orderScan(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        try {
            clientImplMock.orderScan(new OrderUploadInDTO(),"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void barcodeList() {
        WmsOrderDelListInDTO wmsOrderDelListInDTO = new WmsOrderDelListInDTO();
        wmsOrderDelListInDTO.setDocType("STOCUSTOUT");
        EasyMock.expect(odsStoCustScanInfoServiceMock.getListByParams(
                (OdsStoCustScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsStoCustScanInfoDTO>()).times(1);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsStoCustScanInfoServiceMock);
        clientImplMock.barcodeList(new WmsOrderDelListInDTO());
    }
}