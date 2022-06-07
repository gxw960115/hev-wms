package com.haier.wms.controller.po;

import com.haier.openplatform.wms.po.service.PoPDAServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 15:33
 * @Description:
 */
public class PoPDAControllerTest {

    private PoPDAServiceClient poPDAServiceClient;
    private PoPDAController poPDAController = new PoPDAController();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        poPDAServiceClient = EasyMock.createMock(PoPDAServiceClient.class);
        poPDAController.setPoPDAServiceClient(poPDAServiceClient);
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
        EasyMock.expect(poPDAServiceClient.poOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.orderCheck("111","11",
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
    public void giftPoCheck() {
        EasyMock.expect(poPDAServiceClient.giftPoOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.giftPoCheck("111","11",
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
        EasyMock.expect(poPDAServiceClient.poOrderDownload(
                (OrderLoadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderLoadOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.orderDownload("11","11",
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
        EasyMock.expect(poPDAServiceClient.poOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.orderDelete("111","11",
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
    public void giftPoDelete() {
        EasyMock.expect(poPDAServiceClient.giftPoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.giftPoDelete("111","11",
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
        EasyMock.expect(poPDAServiceClient.poOrdersDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.ordersDelete("111","11",
                "11","11","11",
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
    public void poOrderIOgp() {
        EasyMock.expect(poPDAServiceClient.poOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.poOrderIOgp("111","11",
                "11","11",
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
    public void giftPoOrderIOgp() {
        EasyMock.expect(poPDAServiceClient.giftPoOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.giftPoOrderIOgp("111","11",
                "11","11",
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
    public void barcodeList() {
        EasyMock.expect(poPDAServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.barcodeList("111","11",
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
        EasyMock.expect(poPDAServiceClient.poOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.orderScan("111","11",
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
    public void giftOrderScan() {
        EasyMock.expect(poPDAServiceClient.giftPoOrderScan(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(poPDAServiceClient);
        poPDAController.giftOrderScan("111","11",
                "11","11","11",
                "11","11","11",
                "11","11");
    }
}