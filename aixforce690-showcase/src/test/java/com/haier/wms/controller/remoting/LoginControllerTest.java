package com.haier.wms.controller.remoting;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.remoting.service.RfWsClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 11:14
 * @Description:
 */
public class LoginControllerTest {

    private LoginController loginController = new LoginController();
    private RfWsClient rfWsClient;
    private HttpServletRequest request;
    private HttpServletResponse response;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        rfWsClient = EasyMock.createMock(RfWsClient.class);
        loginController.setRfWsClient(rfWsClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void userLogin() {
        try {
            EasyMock.expect(rfWsClient.otcwmsLogin(
                    (LoginParaDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new LoginResultDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.userLogin("111","111","111",request);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void userLogout() {
        try {
            EasyMock.expect(rfWsClient.otcwmsLogout(
                    (LogoutParaDTO)EasyMock.anyObject())
            ).andReturn(new LogoutResultDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.userLogout("111","111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderCheck() {
        try {
            EasyMock.expect(rfWsClient.otcwmsOrderCheck(
                    (OrderCheckInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderCheckOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.orderCheck("111","111",
                "111","111",
                "111","111",
                "111");
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
        try {
            EasyMock.expect(rfWsClient.otcwmsOrderDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderDeleteOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.orderDelete("111","111",
                "111","111",
                "111","111",
                "111");
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
        try {
            EasyMock.expect(rfWsClient.otcwmsOrderUpload(
                    (OrderUploadInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderUploadOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.orderScan("111","111",
                "111","111",
                "111","111",
                "111","11","11","11");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderIOgp() {

        try {
            EasyMock.expect(rfWsClient.otcwmsOrderIgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.orderIOgp("111","111",
                "111","111",new OrderIgpInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDownload() {
        try {
            EasyMock.expect(rfWsClient.otcwmsOrderLoad(
                    (OrderLoadInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderLoadOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(rfWsClient);
        loginController.orderDownload("111","111",
                "111","111",
                "111","111");
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

        EasyMock.expect(rfWsClient.otcwmsBarcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(rfWsClient);
        loginController.barcodeList("111","111",
                "111","111",
                "111");
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
        EasyMock.expect(rfWsClient.offlineScan(
                (List<OrderUploadInDTO>) EasyMock.anyObject())
        ).andReturn(new HashMap<String, String>());
        EasyMock.replay(rfWsClient);
        loginController.offlineScan("111","[{\"user\":\"1111\"}]",
                "111","111",
                "111");
    }
}