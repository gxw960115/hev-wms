package com.haier.openplatform.wms.customer.impl;

import com.haier.hevwms.customer.service.OdsCustomerScanInfoService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
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
 * @Date: 2019/3/21 16:28
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsCustomerScanInfoServiceClientImplTest {

    private OdsCustomerScanInfoServiceClientImpl clientImplMock = new OdsCustomerScanInfoServiceClientImpl();
    private RfWsService rfWsServiceMock;
    private OdsCustomerScanInfoService odsCustomerScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        odsCustomerScanInfoServiceMock=EasyMock.createMock(OdsCustomerScanInfoService.class);
        clientImplMock.setRfWsService(rfWsServiceMock);
        clientImplMock.setOdsCustomerScanInfoService(odsCustomerScanInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerScanInfos() {
        EasyMock.expect(odsCustomerScanInfoServiceMock.searchOdsCustomerScanInfos(
                (Pager<OdsCustomerScanInfoDTO>)EasyMock.anyObject(),
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsCustomerScanInfoDTO>()).times(1);
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        clientImplMock.searchOdsCustomerScanInfos(1L,10L,new OdsCustomerScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerScanInfosCount() {
        EasyMock.expect(odsCustomerScanInfoServiceMock.searchOdsCustomerScanInfosCount(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        clientImplMock.searchOdsCustomerScanInfosCount(new OdsCustomerScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDelete() {
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new RfLogResult()).times(1);
        EasyMock.expect(odsCustomerScanInfoServiceMock.orderDelete(
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.orderDelete(new OrderDeleteInDTO(),"1");
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
    public void ordersDelete() {
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new RfLogResult()).times(1);
        EasyMock.expect(odsCustomerScanInfoServiceMock.orderDelete(
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.ordersDelete(new OrderDeleteInDTO(),"1");
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
    public void orderScan() {
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new RfLogResult()).times(1);
        EasyMock.expect(odsCustomerScanInfoServiceMock.scanCustomer(
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.orderScan(new OrderUploadInDTO(),"");
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
    public void orderDelivery() {

        EasyMock.expect(odsCustomerScanInfoServiceMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.orderDelivery(new OrderIgpInDTO());
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
    public void orderOgp() {
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new RfLogResult()).times(1);
        EasyMock.expect(odsCustomerScanInfoServiceMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.orderOgp(new OrderIgpInDTO(),"");
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
    public void barcodeList() {
        EasyMock.expect(odsCustomerScanInfoServiceMock.getListByParams(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsCustomerScanInfoDTO>()).times(1);
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        clientImplMock.barcodeList(new WmsOrderDelListInDTO());
    }
}