package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:28
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StgPoDownServiceClientImplTest {

    private StgPoDownServiceClientImpl clientImplMock = new StgPoDownServiceClientImpl();
    private StgPoDownService stgPoDownServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        stgPoDownServiceMock= EasyMock.createMock(StgPoDownService.class);
        clientImplMock.setStgPoDownService(stgPoDownServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchStgPoDown() {
        EasyMock.expect(stgPoDownServiceMock.searchStgPoDowns(
                (Pager<StgPoDownDTO>)EasyMock.anyObject(),
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgPoDownDTO>()).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.searchStgPoDown(new Pager<StgPoDownDTO>(),new StgPoDownDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void createStgPoDown() {
        EasyMock.expect(stgPoDownServiceMock.createStgPoDown(
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.createStgPoDown(new StgPoDownDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteStgPoDown() {
        EasyMock.expect(stgPoDownServiceMock.deleteStgPoDownAll(
                (List<Long>)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.deleteStgPoDown(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateStgPoDown() {
        EasyMock.expect(stgPoDownServiceMock.updateStgPoDown(
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.updateStgPoDown(new StgPoDownDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getStgPoDownByParam() {
        EasyMock.expect(stgPoDownServiceMock.getStgPoDownByParam(
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgPoDownDTO>()).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.getStgPoDownByParam(new StgPoDownDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getExportAmount() {
        EasyMock.expect(stgPoDownServiceMock.getExportAmount(
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.getExportAmount(new StgPoDownDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void downloadPo() {
        EasyMock.expect(stgPoDownServiceMock.downloadPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.downloadPo("1","1","1","1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void postPo() {
        OrderGoodsTransOutDTO ret_1 = new OrderGoodsTransOutDTO();
        OrderGoodsTransOutDTO ret_2 = new OrderGoodsTransOutDTO();
        ret_1.setStatus("0");
        ret_2.setStatus("1");
        EasyMock.expect(stgPoDownServiceMock.postPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("S").times(1).andReturn("E").times(1);
        EasyMock.expect(stgPoDownServiceMock.poGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret_1).times(1).andReturn(ret_2).times(1);
        EasyMock.expect(stgPoDownServiceMock.poGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.postPo("1","1","1","1","1");
        clientImplMock.postPo("1","2","1","1","1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void inoutWarehousePo() {
        EasyMock.expect(stgPoDownServiceMock.poGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.expect(stgPoDownServiceMock.poGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.inoutWarehousePo("1","1","1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void postGiftPo(){
        OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
        ret.setStatus("0");
        OrderGoodsTransOutDTO ret_1 = new OrderGoodsTransOutDTO();
        ret_1.setStatus("1");
        EasyMock.expect(stgPoDownServiceMock.postPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("S").times(1).andReturn("E").times(1);
        EasyMock.expect(stgPoDownServiceMock.giftPoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret).times(1).andReturn(ret_1).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.postGiftPo("111","111","111","111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftInoutWarehousePo(){
        OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
        OrderGoodsTransOutDTO ret_1 = new OrderGoodsTransOutDTO();
        ret.setStatus("0");
        ret_1.setStatus("1");
        EasyMock.expect(stgPoDownServiceMock.giftPoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret).times(1).andReturn(ret_1).times(1);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.giftInoutWarehousePo("111","111","111");
    }
}