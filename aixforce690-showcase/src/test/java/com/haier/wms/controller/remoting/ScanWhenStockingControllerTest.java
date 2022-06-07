package com.haier.wms.controller.remoting;

import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.remoting.service.RfScanWhenPDClient;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 14:43
 * @Description:
 */
public class ScanWhenStockingControllerTest {

    private RfScanWhenPDClient rfScanWhenPDClient;
    private ScanWhenStockingController scanWhenStockingController = new ScanWhenStockingController();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        rfScanWhenPDClient = EasyMock.createMock(RfScanWhenPDClient.class);
        scanWhenStockingController.setRfScanWhenPDClient(rfScanWhenPDClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderCkeck() {
        EasyMock.expect(rfScanWhenPDClient.orderCheck(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.orderCkeck(new OrderCheckInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDownLoad() {
        EasyMock.expect(rfScanWhenPDClient.orderDownLoad(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.orderDownLoad(new OrderCheckInDTO());
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
        EasyMock.expect(rfScanWhenPDClient.orderScan(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.orderScan(new OrderUploadInDTO());
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
        EasyMock.expect(rfScanWhenPDClient.offlineScan(
                (List<OrderUploadInDTO>) EasyMock.anyObject())
        ).andReturn(new HashMap<String, String>());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.offlineScan("111","[{\"user\":\"1111\"}]",
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
    public void barcodeDetail() {
        EasyMock.expect(rfScanWhenPDClient.barcodeDetail(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.barcodeDetail(new OrderUploadInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderIogp() {
        EasyMock.expect(rfScanWhenPDClient.orderIogp(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.orderIogp(new OrderUploadInDTO());
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
        EasyMock.expect(rfScanWhenPDClient.orderDelete(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(rfScanWhenPDClient);
        scanWhenStockingController.orderDelete(new OrderUploadInDTO());
    }
}