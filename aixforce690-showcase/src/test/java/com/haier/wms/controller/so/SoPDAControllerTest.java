package com.haier.wms.controller.so;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.so.service.SoPDAServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:24
 * @Description:
 */
public class SoPDAControllerTest {

    private SoPDAServiceClient soPDAServiceClient;
    private SoPDAController soPDAController = new SoPDAController();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        soPDAServiceClient = EasyMock.createMock(SoPDAServiceClient.class);
        soPDAController.setSoPDAServiceClient(soPDAServiceClient);
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
        EasyMock.expect(soPDAServiceClient.soOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.orderCheck("111","11",
                "11","11","11",
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
    public void orderDownload() {
        EasyMock.expect(soPDAServiceClient.soOrderDownload(
                (OrderLoadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderLoadOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.orderDownload("11","11",
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
        EasyMock.expect(soPDAServiceClient.soOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.orderDelete("111","11",
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
    public void giftSoDelete() {
        EasyMock.expect(soPDAServiceClient.giftSoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.giftSoDelete("111","11",
                "11","11","11",
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
    public void ordersDelete() {
        EasyMock.expect(soPDAServiceClient.soOrdersDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.ordersDelete("111","11",
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
    public void soOrderIOgp() {

        EasyMock.expect(soPDAServiceClient.soOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.soOrderIOgp("111","11",
                "11","11",new OrderIgpInDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftSoOrderIOgp() {
        EasyMock.expect(soPDAServiceClient.giftSoOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.giftSoOrderIOgp("111","11",
                "11","11",new OrderIgpInDTO());
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
        EasyMock.expect(soPDAServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.barcodeList("111","11",
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
        EasyMock.expect(soPDAServiceClient.soOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.orderScan("111","11",
                "11","11","11",
                "11","11","11",
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
    public void giftSoScan() {
        EasyMock.expect(soPDAServiceClient.giftSoOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.giftSoScan("111","11",
                "11","11","11",
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
    public void fifoGet() {
        EasyMock.expect(soPDAServiceClient.getFifo(
                (WmsOrderDelListInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.fifoGet("111","11",
                "1",new WmsOrderDelListInDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderScanOldBarcode() {
        EasyMock.expect(soPDAServiceClient.soOrderScanOldBarcode(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(soPDAServiceClient);
        soPDAController.orderScanOldBarcode("111","11",
                "11","11","11",
                "11","11","11",
                "11","11","1");
    }
}