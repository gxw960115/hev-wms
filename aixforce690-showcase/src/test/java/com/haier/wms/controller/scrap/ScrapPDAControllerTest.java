package com.haier.wms.controller.scrap;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.scrap.service.ScrapPDAServiceClient;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 15:02
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class})
public class ScrapPDAControllerTest {

    private ScrapPDAController scrapPDAController = new ScrapPDAController();
    private ScrapPDAServiceClient scrapPDAServiceClient;
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
        scrapPDAServiceClient = EasyMock.createMock(ScrapPDAServiceClient.class);
        scrapPDAController.setScrapPDAServiceClient(scrapPDAServiceClient);
        BaseUser baseUser = new BaseUser();
        baseUser.setName("111");
        PowerMockito.mockStatic(UserUtil.class);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
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
        EasyMock.expect(scrapPDAServiceClient.scrapOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderCheck("111","11",
                "11","11","11",
                "11","11");
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
        EasyMock.expect(scrapPDAServiceClient.scrapOrderDownload(
                (OrderLoadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderLoadOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderDownload("11","11",
                "11","11","11","11");
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
        EasyMock.expect(scrapPDAServiceClient.scrapOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderDelete("111","11",
                "11","11","11",
                "11","11");
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
        EasyMock.expect(scrapPDAServiceClient.scrapOrdersDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.ordersDelete("111","11",
                "11","11","11",
                "11","11");
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
            EasyMock.expect(scrapPDAServiceClient.scrapOrderIgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderIOgp("111","11",
                "11","11","111",
                new OrderIgpInDTO());
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
        try {
            EasyMock.expect(scrapPDAServiceClient.orderPosting(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderPosting("111",new OrderIgpInDTO(),
                "11");
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
        EasyMock.expect(scrapPDAServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.barcodeList("111","11",
                "11","11","11");
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
        EasyMock.expect(scrapPDAServiceClient.scrapOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(scrapPDAServiceClient);
        scrapPDAController.orderScan("111","11",
                "11","11","11",
                "11","11","11",
                "11","11");
    }
}