package com.haier.wms.controller.remoting;

import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.OdsPdTempDtlServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 14:37
 * @Description:
 */
public class OdsPdTempControllerTest {

    private OdsPdTempDtlServiceClient odsPdTempDtlServiceClient;
    private OdsPdTempController odsPdTempController = new OdsPdTempController();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPdTempDtlServiceClient = EasyMock.createMock(OdsPdTempDtlServiceClient.class);
        odsPdTempController.setOdsPdTempDtlServiceClient(odsPdTempDtlServiceClient);
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
        odsPdTempController.orderCheck(new OdsPdTempDtlDTO());
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
        odsPdTempController.orderScan(new OdsPdTempDtlDTO());
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

        EasyMock.expect(odsPdTempDtlServiceClient.offlineScan(
                (List<OdsPdTempDtlDTO>) EasyMock.anyObject())
        ).andReturn(new HashMap<String, String>());
        EasyMock.replay(odsPdTempDtlServiceClient);
        odsPdTempController.offlineScan("111","[{\"orderNo\":\"1111\"}]",
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
    public void orderDelete() {
        odsPdTempController.orderDelete(new OdsPdTempDtlDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDetail() {
        odsPdTempController.orderDetail(new OdsPdTempDtlDTO());
    }
}