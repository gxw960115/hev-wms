package com.haier.openplatform.wms.consume.impl;

import com.haier.hevwms.consume.service.ConsumePDAService;
import com.haier.hevwms.consume.service.OdsConsumeOrderService;
import com.haier.hevwms.consume.service.OdsConsumeScanInfoService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.sapinterface.ConsumingToSap;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.*;
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
 * @Date: 2019/3/21 09:56
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class ConsumePDAServiceClientImplTest {

    private ConsumePDAServiceClientImpl clientImplMock = new ConsumePDAServiceClientImpl();
    private ConsumePDAService consumePDAServiceMock;
    private OdsConsumeOrderService odsConsumeOrderServiceMock;
    private OdsConsumeScanInfoService odsConsumeScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     */
    @Before
    public void init(){
        odsConsumeOrderServiceMock = EasyMock.createMock(OdsConsumeOrderService.class);
        consumePDAServiceMock=EasyMock.createMock(ConsumePDAService.class);
        odsConsumeScanInfoServiceMock = EasyMock.createMock(OdsConsumeScanInfoService.class);
        clientImplMock.setOdsConsumeOrderService(odsConsumeOrderServiceMock);
        clientImplMock.setConsumePDAService(consumePDAServiceMock);
        clientImplMock.setOdsConsumeScanInfoService(odsConsumeScanInfoServiceMock);

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     */
    @Test
    public void consumeOrderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderCheckOutDTO result = new OrderCheckOutDTO();
        EasyMock.expect(consumePDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsConsumeOrderServiceMock.checkConsumeOrderByPDA((OrderCheckInDTO)EasyMock.anyObject()))
                .andReturn(result).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        EasyMock.replay(odsConsumeOrderServiceMock);
        clientImplMock.consumeOrderCheck(new OrderCheckInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     */
    @Test
    public void consumeOrderDownload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(consumePDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        clientImplMock.consumeOrderDownload(new OrderLoadInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrderDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        EasyMock.expect(consumePDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(consumePDAServiceMock.consumeOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(outResult).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        clientImplMock.consumeOrderDelete(new OrderDeleteInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrdersDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("1111");
        OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
        EasyMock.expect(consumePDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(consumePDAServiceMock.consumeOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(outResult).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        clientImplMock.consumeOrdersDelete(orderDeleteInDTO,"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrderIgp() {

        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        WmsOrderIgpOut result = new WmsOrderIgpOut();
        OdsConsumeOrderDTO dto = new OdsConsumeOrderDTO();
        List<OdsConsumeOrderDTO> list = new ArrayList<OdsConsumeOrderDTO>();
        list.add(dto);
        EasyMock.expect(consumePDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsConsumeOrderServiceMock.scanStatus(
                (String)EasyMock.anyObject())
        ).andReturn(list).times(1);
        consumePDAServiceMock.updateSapInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(consumePDAServiceMock.consumeOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(result).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        EasyMock.replay(odsConsumeOrderServiceMock);
        try {
            clientImplMock.consumeOrderIgp(new OrderIgpInDTO(),"1","1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderPosting() {
        WmsOrderIgpOut result = new WmsOrderIgpOut();
        OrderIgpInDTO orderIgpInDTO = new OrderIgpInDTO();
        orderIgpInDTO.setOrno("11111111");
        EasyMock.expect(consumePDAServiceMock.consumeOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(result).times(1);
        EasyMock.replay(consumePDAServiceMock);
//        try {
//            clientImplMock.orderPosting(orderIgpInDTO,"1");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void barcodeList() {
        List<OdsConsumeScanInfoDTO> list = new ArrayList<OdsConsumeScanInfoDTO>();
        EasyMock.expect(odsConsumeScanInfoServiceMock.
                getOdsConsumeScanInfos((OdsConsumeScanInfoDTO)EasyMock.anyObject())).andReturn(list).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsConsumeScanInfoServiceMock);
        EasyMock.replay(consumePDAServiceMock);
        clientImplMock.barcodeList(new WmsOrderDelListInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrderScan() {
        RfLogResult rfLogResult = new RfLogResult();
        OrderUploadOutDTO outResult = new OrderUploadOutDTO();
        EasyMock.expect(consumePDAServiceMock.checkSign((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),(String)EasyMock.anyObject())).andReturn(rfLogResult).times(1);
        EasyMock.expect(consumePDAServiceMock.scanConsumeCheck((OrderUploadInDTO)EasyMock.anyObject()))
                .andReturn(outResult).times(1);
        consumePDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDAServiceMock);
        clientImplMock.consumeOrderScan(new OrderUploadInDTO(),"1");
    }
}