package com.haier.openplatform.wms.transfer.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sapinterface.GoodsMovementToSap;
import com.haier.hevwms.transfer.service.OdsTransferDtlService;
import com.haier.hevwms.transfer.service.OdsTransferInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.rsa.certj.x.c;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:46
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsTransferDtlServiceClientImplTest {

    private OdsTransferDtlServiceClientImpl clientImplMock = new OdsTransferDtlServiceClientImpl();
    private RfWsService rfWsServiceMock;
    private OdsTransferDtlService odsTransferDtlServiceMock;
    private OdsTransferInfoService odsTransferInfoServiceMock;

    @Before
    public void init(){
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        odsTransferDtlServiceMock = EasyMock.createMock(OdsTransferDtlService.class);
        odsTransferInfoServiceMock = EasyMock.createMock(OdsTransferInfoService.class);
        clientImplMock.setRfWsService(rfWsServiceMock);
        clientImplMock.setOdsTransferDtlService(odsTransferDtlServiceMock);
        clientImplMock.setOdsTransferInfoService(odsTransferInfoServiceMock);
        clientImplMock.getContext();
        clientImplMock.getOdsTransferDtlService();
        clientImplMock.getOdsTransferInfoService();
        clientImplMock.getRfWsService();
    }

    @Test
    public void searchOdsTransferDtls() {

        EasyMock.expect(odsTransferDtlServiceMock.searchOdsTransferDtls(
                (Pager<OdsTransferDtlDTO>)EasyMock.anyObject(),
                (OdsTransferDtlDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsTransferDtlDTO>()).times(1);
        EasyMock.replay(odsTransferDtlServiceMock);
        clientImplMock.searchOdsTransferDtls(1L,10L,new OdsTransferDtlDTO());
    }

    @Test
    public void searchOdsTransferDtlsCount() {
        EasyMock.expect(odsTransferDtlServiceMock.searchOdsTransferDtlsCount(
                (OdsTransferDtlDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsTransferDtlServiceMock);
        clientImplMock.searchOdsTransferDtlsCount(new OdsTransferDtlDTO());
    }

    @Test
    public void orderDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("111111111111");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsTransferDtlServiceMock.orderDelete(
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
        EasyMock.replay(odsTransferDtlServiceMock);
        try {
            clientImplMock.orderDelete(orderDeleteInDTO,"1");
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
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("111111111111");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsTransferDtlServiceMock.orderDelete(
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
        EasyMock.replay(odsTransferDtlServiceMock);
        try {
            clientImplMock.ordersDelete(orderDeleteInDTO,"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void barcodeList() {
        OdsTransferDtlDTO odsTransferDtlDTO = new OdsTransferDtlDTO();
        odsTransferDtlDTO.setQty(1L);
        odsTransferDtlDTO.setBarcode("1111111111");
        odsTransferDtlDTO.setOrderNo("11111");
        odsTransferDtlDTO.setRowId(1L);
        WmsOrderDelListInDTO wmsOrderDelListInDTO = new WmsOrderDelListInDTO();
        wmsOrderDelListInDTO.setDocType("TRANSFER");
        List<OdsTransferDtlDTO> list = new ArrayList<OdsTransferDtlDTO>();
        list.add(odsTransferDtlDTO);
        EasyMock.expect(odsTransferDtlServiceMock.getListByParams(
                (OdsTransferDtlDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
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
        EasyMock.replay(odsTransferDtlServiceMock);
        clientImplMock.barcodeList(wmsOrderDelListInDTO);
    }

    @Test
    public void orderPosting() {
        EasyMock.expect(odsTransferDtlServiceMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
        EasyMock.replay(odsTransferDtlServiceMock);
        try {
            clientImplMock.orderPosting(new OrderIgpInDTO(),"1","1","1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void orderOgp() {

        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        List<OdsTransferInfoDTO> list_1 = new ArrayList<OdsTransferInfoDTO>();
        OdsTransferInfoDTO odsTransferInfoDTO_1 = new OdsTransferInfoDTO();
        odsTransferInfoDTO_1.setGiLocation("111");
        odsTransferInfoDTO_1.setGrLocation("111");
        list_1.add(odsTransferInfoDTO_1);

        List<OdsTransferInfoDTO> list_2 = new ArrayList<OdsTransferInfoDTO>();
        OdsTransferInfoDTO odsTransferInfoDTO_2 = new OdsTransferInfoDTO();
        odsTransferInfoDTO_2.setGiLocation("111");
        odsTransferInfoDTO_2.setGrLocation("222");
        list_2.add(odsTransferInfoDTO_2);
        OrderIgpInDTO orderIgpInDTO_1 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_2 = new OrderIgpInDTO();
        orderIgpInDTO_1.setDocType("TRANSFER");
        orderIgpInDTO_2.setDocType("Other");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsTransferInfoServiceMock.scanStatus(
                (String)EasyMock.anyObject())
        ).andReturn(list_1).times(1).andReturn(list_2).times(1);
        odsTransferDtlServiceMock.updateSapInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(odsTransferDtlServiceMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(2);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(2);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsTransferDtlServiceMock);
        EasyMock.replay(odsTransferInfoServiceMock);
        try {
            clientImplMock.orderOgp(orderIgpInDTO_1,"1","1");
            clientImplMock.orderOgp(orderIgpInDTO_2,"1","1");
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
        OrderUploadInDTO orderUploadInDTO = new OrderUploadInDTO();
        orderUploadInDTO.setDoctype("TRANSFER");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsTransferDtlServiceMock.scanTransfer(
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
        EasyMock.replay(odsTransferDtlServiceMock);
        try {
            clientImplMock.orderScan(orderUploadInDTO,"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
