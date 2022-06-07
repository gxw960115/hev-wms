package com.haier.wms.controller.consume;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.service.ConsumePDAServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.wms.util.PageBean;
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

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/30 09:50
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class,UserUtil.class})
public class ConsumePDAControllerTest {

    private ConsumePDAController consumePDAController = new ConsumePDAController();
    private ConsumePDAServiceClient consumePDAServiceClient;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        consumePDAServiceClient = EasyMock.createMock(ConsumePDAServiceClient.class);
        consumePDAController.setConsumePDAServiceClient(consumePDAServiceClient);

        PowerMockito.mockStatic(PageUtil.class,SessionConstants.class,UserUtil.class);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(new BaseUser());
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
        EasyMock.expect(consumePDAServiceClient.consumeOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.orderCheck("1",
                "1","1",
                "1","1",
                "1","1");
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
        EasyMock.expect(consumePDAServiceClient.consumeOrderDownload(
                (OrderLoadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderLoadOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.orderDownload("11","1",
                "1","1",
                "1","1");
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
        EasyMock.expect(consumePDAServiceClient.consumeOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.orderDelete("11","1",
                "1","1",
                "1","1");
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
        EasyMock.expect(consumePDAServiceClient.consumeOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.ordersDelete("11","1",
                "1","1",
                "1","1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderIOgp() {
        try {
            EasyMock.expect(consumePDAServiceClient.consumeOrderIgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
            EasyMock.replay(consumePDAServiceClient);
            consumePDAController.poOrderIOgp("","",new OrderIgpInDTO());
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
        try {

            EasyMock.expect(consumePDAServiceClient.orderPosting(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
            EasyMock.replay(consumePDAServiceClient);
            consumePDAController.orderPosting("",new OrderIgpInDTO(),"");
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
        EasyMock.expect(consumePDAServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.barcodeList("11",
                "111","111",
                "1111","1111");
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
        EasyMock.expect(consumePDAServiceClient.consumeOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(consumePDAServiceClient);
        consumePDAController.orderScan("111","111",
                "111","111",
                "111","111",
                "111","11",
                "111","111");
    }
}