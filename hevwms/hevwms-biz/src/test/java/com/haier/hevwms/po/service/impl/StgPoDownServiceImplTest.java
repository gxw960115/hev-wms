package com.haier.hevwms.po.service.impl;

import com.haier.hevwms.po.dao.PoPDADAO;
import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.StgPoDownDTO;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.dto.UserDTO;
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
 * @Date: 2019/4/22 13:57
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StgPoDownServiceImplTest {

    private StgPoDownServiceImpl clientImplMock = new StgPoDownServiceImpl();
    private StgPoDownDAO stgPoDownDAOMock;
    private UserDAO userDAOMock;
    private PoPDADAO poPDADAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        stgPoDownDAOMock = EasyMock.createMock(StgPoDownDAO.class);
        userDAOMock = EasyMock.createMock(UserDAO.class);
        poPDADAOMock = EasyMock.createMock(PoPDADAO.class);
        clientImplMock.setStgPoDownDAO(stgPoDownDAOMock);
        clientImplMock.setUserDAO(userDAOMock);
        clientImplMock.setPoPDADAO(poPDADAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteStgPoDownAll() {
        stgPoDownDAOMock.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stgPoDownDAOMock);
        clientImplMock.deleteStgPoDownAll(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchStgPoDowns() {
        EasyMock.expect(stgPoDownDAOMock.searchStgPoDowns(
                (Pager<StgPoDownDTO>)EasyMock.anyObject(),
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgPoDownDTO>()).times(1);
        EasyMock.expect(stgPoDownDAOMock.searchStgPoDownsCount(
                (StgPoDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(stgPoDownDAOMock);
        clientImplMock.searchStgPoDowns(new Pager<StgPoDownDTO>(),new StgPoDownDTO());
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
        stgPoDownDAOMock.save((StgPoDownDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stgPoDownDAOMock);
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
    public void updateStgPoDown() {
//        stgPoDownDAOMock.update((StgPoDownDTO)EasyMock.anyObject());
//        EasyMock.expectLastCall().times(1);
//        EasyMock.replay(stgPoDownDAOMock);
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
    public void checkPo() {
        UserDTO userDTO = new UserDTO();
        userDTO.setDutyType("3");
        OrderCheckInDTO orderCheckInDTO_1 = new OrderCheckInDTO();
        OrderCheckInDTO orderCheckInDTO_2 = new OrderCheckInDTO();
        OrderCheckInDTO orderCheckInDTO_3 = new OrderCheckInDTO();
        OrderCheckInDTO orderCheckInDTO_4 = new OrderCheckInDTO();
        orderCheckInDTO_1.setOrdertype("1");
        orderCheckInDTO_2.setOrdertype("2");
        orderCheckInDTO_2.setReturnType("101");
        orderCheckInDTO_3.setOrdertype("2");
        orderCheckInDTO_3.setReturnType("122");
        orderCheckInDTO_4.setOrdertype("3");
        EasyMock.expect(stgPoDownDAOMock.checkPoExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Close").times(1)
                .andReturn("").times(1)
                .andReturn("2").times(1)
                .andReturn("1").times(1);
        EasyMock.expect(userDAOMock.getUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(userDTO).times(1);
        EasyMock.expect(stgPoDownDAOMock.checkPoLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S").times(1);
        EasyMock.replay(stgPoDownDAOMock);
        EasyMock.replay(userDAOMock);
        clientImplMock.checkPo(orderCheckInDTO_1);
        clientImplMock.checkPo(orderCheckInDTO_2);
        clientImplMock.checkPo(orderCheckInDTO_3);
        clientImplMock.checkPo(orderCheckInDTO_4);
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
        //clientImplMock.postPo("111","1111","111","111","111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poGoodsReceive() {
        poPDADAOMock.poGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.poGoodsReceive(new OrderIgpInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poGoodsDelivery() {
        poPDADAOMock.poGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.poGoodsDelivery(new OrderIgpInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getPoMaterialList() {
        clientImplMock.getPoMaterialList("111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanPoCheck() {
        stgPoDownDAOMock.scanPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stgPoDownDAOMock);
        clientImplMock.scanPoCheck(new OrderUploadInDTO());
    }
}