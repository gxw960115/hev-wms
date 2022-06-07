package com.haier.openplatform.wms.remoting.service.impl;

import com.haier.hevwms.remoting.rf.service.RfScanWhenPDService;
import com.haier.openplatform.wms.remoting.dto.*;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:30
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class RfScanWhenPDClientImplTest {

    private RfScanWhenPDClientImpl clientImplMock = new RfScanWhenPDClientImpl();
    private RfScanWhenPDService scanWhenPDServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        scanWhenPDServiceMock = EasyMock.createMock(RfScanWhenPDService.class);
        clientImplMock.setScanWhenPDService(scanWhenPDServiceMock);
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
        EasyMock.expect(scanWhenPDServiceMock.orderCkeck(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.orderCheck(new OrderCheckInDTO());

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
        EasyMock.expect(scanWhenPDServiceMock.orderDownLoad(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.orderDownLoad(new OrderCheckInDTO());
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
        EasyMock.expect(scanWhenPDServiceMock.orderScan(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.orderScan(new OrderUploadInDTO());
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
        EasyMock.expect(scanWhenPDServiceMock.offlineScan(
                (List<OrderUploadInDTO>)EasyMock.anyObject())
        ).andReturn(new HashMap<String, String>()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.offlineScan(new ArrayList<OrderUploadInDTO>());
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
        EasyMock.expect(scanWhenPDServiceMock.orderDelete(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.orderDelete(new OrderUploadInDTO());
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
        EasyMock.expect(scanWhenPDServiceMock.barcodeDetail(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.barcodeDetail(new OrderUploadInDTO());
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
        EasyMock.expect(scanWhenPDServiceMock.orderIogp(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        EasyMock.replay(scanWhenPDServiceMock);
        clientImplMock.orderIogp(new OrderUploadInDTO());
    }
}