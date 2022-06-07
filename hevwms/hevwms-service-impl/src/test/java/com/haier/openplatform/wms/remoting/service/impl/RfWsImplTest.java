package com.haier.openplatform.wms.remoting.service.impl;

import com.haier.hevwms.customer.service.OdsCustomerOrderService;
import com.haier.hevwms.customer.service.OdsCustomerScanInfoService;
import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.login.LoginPara;
import com.haier.hevwms.remoting.rf.domain.login.LoginResult;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutPara;
import com.haier.hevwms.remoting.rf.domain.logout.LogoutResult;
import com.haier.hevwms.remoting.rf.domain.order.*;
import com.haier.hevwms.remoting.rf.service.*;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.WebServiceContext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:31
 * @Description:
 */
public class RfWsImplTest {

    private RfWsImpl clientImplMock = new RfWsImpl();
    private OtcwmsLoginService otcwmsLoginServiceMock;
    private OtcwmsLogoutService otcwmsLogoutServiceMock;
    private OtcwmsOrderCheckService otcwmsOrderCheckServiceMock;
    private OtcwmsOrderDeleteService otcwmsOrderDeleteServiceMock;
    private OtcwmsOrderUploadService otcwmsOrderUploadServiceMock;
    private OtcwmsOrderIgpService otcwmsOrderIgpServiceMock;
    private OtcwmsOrderConfirmService otcwmsOrderConfirmServiceMock;
    private OtcwmsOrderMoveService otcwmsOrderMoveServiceMock;
    private RfWsService rfWsServiceMock;
    private StgPoDownService stgPoDownServiceMock;
    private StgStoDownService stgStoDownServiceMock;
    private OdsPdInfoService odsPdInfoServiceMock;
    private OdsCustomerOrderService odsCustomerOrderServiceMock;
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

        otcwmsLoginServiceMock = EasyMock.createMock(OtcwmsLoginService.class);
        otcwmsLogoutServiceMock= EasyMock.createMock(OtcwmsLogoutService.class);
        otcwmsOrderCheckServiceMock = EasyMock.createMock(OtcwmsOrderCheckService.class);
        otcwmsOrderDeleteServiceMock = EasyMock.createMock(OtcwmsOrderDeleteService.class);
        otcwmsOrderUploadServiceMock = EasyMock.createMock(OtcwmsOrderUploadService.class);
        otcwmsOrderIgpServiceMock = EasyMock.createMock(OtcwmsOrderIgpService.class);
        otcwmsOrderConfirmServiceMock = EasyMock.createMock(OtcwmsOrderConfirmService.class);
        otcwmsOrderMoveServiceMock = EasyMock.createMock(OtcwmsOrderMoveService.class);
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        stgPoDownServiceMock = EasyMock.createMock(StgPoDownService.class);
        stgStoDownServiceMock = EasyMock.createMock(StgStoDownService.class);
        odsPdInfoServiceMock = EasyMock.createMock(OdsPdInfoService.class);
        odsCustomerOrderServiceMock = EasyMock.createMock(OdsCustomerOrderService.class);
        odsCustomerScanInfoServiceMock = EasyMock.createMock(OdsCustomerScanInfoService.class);

        clientImplMock.setOtcwmsLoginService(otcwmsLoginServiceMock);
        clientImplMock.setOtcwmsLogoutService(otcwmsLogoutServiceMock);
        clientImplMock.setOtcwmsOrderCheckService(otcwmsOrderCheckServiceMock);
        clientImplMock.setOtcwmsOrderDeleteService(otcwmsOrderDeleteServiceMock);
        clientImplMock.setOtcwmsOrderUploadService(otcwmsOrderUploadServiceMock);
        clientImplMock.setOtcwmsOrderIgpService(otcwmsOrderIgpServiceMock);
        clientImplMock.setOtcwmsOrderConfirmService(otcwmsOrderConfirmServiceMock);
        clientImplMock.setOtcwmsOrderMoveService(otcwmsOrderMoveServiceMock);
        clientImplMock.setRfWsService(rfWsServiceMock);
        clientImplMock.setStgPoDownService(stgPoDownServiceMock);
        clientImplMock.setStgStoDownService(stgStoDownServiceMock);
        clientImplMock.setOdsPdInfoService(odsPdInfoServiceMock);
        clientImplMock.setOdsCustomerOrderService(odsCustomerOrderServiceMock);
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
    public void test1() {
        clientImplMock.test("111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void otcwmsLogin() {
        EasyMock.expect(otcwmsLoginServiceMock.userLogin(
                (LoginPara)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new LoginResult()).times(1);
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
        EasyMock.replay(otcwmsLoginServiceMock);
        EasyMock.replay(rfWsServiceMock);
        try {
            clientImplMock.otcwmsLogin(new LoginParaDTO(),"1");
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
    public void otcwmsLogout() {
        EasyMock.expect(otcwmsLogoutServiceMock.userLogout(
                (LogoutPara)EasyMock.anyObject())
        ).andReturn(new LogoutResult()).times(1);
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
        EasyMock.replay(otcwmsLogoutServiceMock);
        EasyMock.replay(rfWsServiceMock);
        try {
            clientImplMock.otcwmsLogout(new LogoutParaDTO());
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
    public void otcwmsOrderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderCheckInDTO orderCheckInDTO_1 = new OrderCheckInDTO();
        OrderCheckInDTO orderCheckInDTO_2 = new OrderCheckInDTO();
        orderCheckInDTO_1.setDoctype("PD");
        orderCheckInDTO_2.setDoctype("CUSTOMER");
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsPdInfoServiceMock.checkPdInfo(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
        EasyMock.expect(odsCustomerOrderServiceMock.checkCustomerOrder(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
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
        EasyMock.replay(odsPdInfoServiceMock);
        EasyMock.replay(odsCustomerOrderServiceMock);
        try {
            clientImplMock.otcwmsOrderCheck(orderCheckInDTO_1,"1");
            clientImplMock.otcwmsOrderCheck(orderCheckInDTO_2,"1");
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
    public void otcwmsOrderDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(otcwmsOrderDeleteServiceMock.otcwmsOrderDelete(
                (WmsOrderDeleteIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderDeleteOut()).times(1);
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
        EasyMock.replay(otcwmsOrderDeleteServiceMock);
        try {
            clientImplMock.otcwmsOrderDelete(new OrderDeleteInDTO(),"1");
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
    public void otcwmsOrderUpload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        OrderUploadInDTO orderUploadInDTO_1 = new OrderUploadInDTO();
        OrderUploadInDTO orderUploadInDTO_2 = new OrderUploadInDTO();
        orderUploadInDTO_1.setDoctype("PO");
        orderUploadInDTO_2.setDoctype("CUSTOMER");
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).
                andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stgPoDownServiceMock.scanPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
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
        EasyMock.expectLastCall().times(2);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        try {
            clientImplMock.otcwmsOrderUpload(orderUploadInDTO_1,"1");
            clientImplMock.otcwmsOrderUpload(orderUploadInDTO_2,"1");
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
    public void otcwmsOrderIgp() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderIgpInDTO orderIgpInDTO_1 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_2 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_3 = new OrderIgpInDTO();
        OrderIgpInDTO orderIgpInDTO_4 = new OrderIgpInDTO();
        orderIgpInDTO_1.setDocType("DN");
        orderIgpInDTO_1.setOrderType("1");
        orderIgpInDTO_2.setDocType("PD");
        orderIgpInDTO_2.setOrno("1");
        orderIgpInDTO_3.setDocType("CUSTOMER");
        orderIgpInDTO_4.setDocType("");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1)
                .andReturn(rfLogResult_2).times(1)
                .andReturn(rfLogResult_1).times(1)
                .andReturn(rfLogResult_2).times(1);
        EasyMock.expect(otcwmsOrderIgpServiceMock.otcwmsDnOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
        EasyMock.expect(otcwmsOrderIgpServiceMock.otcwmsOrderIgp(
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
        EasyMock.expectLastCall().times(4);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(otcwmsOrderIgpServiceMock);
        try {
            clientImplMock.otcwmsOrderIgp(orderIgpInDTO_1,"1");
            clientImplMock.otcwmsOrderIgp(orderIgpInDTO_2,"1");
            clientImplMock.otcwmsOrderIgp(orderIgpInDTO_3,"1");
            clientImplMock.otcwmsOrderIgp(orderIgpInDTO_4,"1");
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
    public void otcwmsOrderLoad() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderLoadInDTO orderLoadInDTO = new OrderLoadInDTO();
        orderLoadInDTO.setDoctype("PO");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(stgPoDownServiceMock.downloadPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())).andReturn("S").times(1);
        EasyMock.expect(stgPoDownServiceMock.getPoMaterialList(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OrderMatListDTO>()).times(1);
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
        EasyMock.replay(stgPoDownServiceMock);
        try {
            clientImplMock.otcwmsOrderLoad(orderLoadInDTO,"1");
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
    public void otcwmsBarcodeList() {
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
        EasyMock.replay(odsCustomerScanInfoServiceMock);
        EasyMock.replay(rfWsServiceMock);
//        clientImplMock.otcwmsBarcodeList(new WmsOrderDelListInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void offlineScan() {
        EasyMock.expect(otcwmsOrderUploadServiceMock.offlineScan(
                (List<WmsOrderUploadIn>)EasyMock.anyObject())
        ).andReturn(new HashMap<String, String>()).times(1);
        EasyMock.replay(otcwmsOrderUploadServiceMock);
        clientImplMock.offlineScan(new ArrayList<OrderUploadInDTO>());
    }
}