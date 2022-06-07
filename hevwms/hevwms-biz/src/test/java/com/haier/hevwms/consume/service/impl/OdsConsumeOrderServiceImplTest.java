package com.haier.hevwms.consume.service.impl;

import com.haier.hevwms.consume.dao.OdsConsumeOrderDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
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
 * @Date: 2019/4/2 13:59
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsConsumeOrderServiceImplTest {

    private OdsConsumeOrderServiceImpl clientImplMock = new OdsConsumeOrderServiceImpl();
    private UserDAO userDAOMock;
    private OdsConsumeOrderDAO odsConsumeOrderDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        userDAOMock = EasyMock.createMock(UserDAO.class);
        odsConsumeOrderDAOMock = EasyMock.createMock(OdsConsumeOrderDAO.class);
        clientImplMock.setUserDAO(userDAOMock);
        clientImplMock.setOdsConsumeOrderDAO(odsConsumeOrderDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeOrderByPage() {
        EasyMock.expect(odsConsumeOrderDAOMock.searchOdsConsumeOrderByPage(
                (Pager<OdsConsumeOrderDTO>)EasyMock.anyObject(),
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeOrderDTO>()).times(1);
        EasyMock.expect(odsConsumeOrderDAOMock.searchOdsConsumeOrderCount(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.searchOdsConsumeOrderByPage(new Pager<OdsConsumeOrderDTO>(),new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteConsumeOrder() {
        EasyMock.expect(odsConsumeOrderDAOMock.deleteAll(
                (List<Long>)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.deleteConsumeOrder(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void confirmConsumeOrder() {
        EasyMock.expect(odsConsumeOrderDAOMock.confirmConsumeOrder(
                (List<Long>)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.confirmConsumeOrder(new ArrayList<Long>(),"");
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
        EasyMock.expect(odsConsumeOrderDAOMock.searchOdsConsumeOrderCount(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.getExportAmount(new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsConsumeOrderListByParm() {
        EasyMock.expect(odsConsumeOrderDAOMock.getOdsConsumeOrderListByParm(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeOrderDTO>()).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.getOdsConsumeOrderListByParm(new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getConsumeSequence() {
        EasyMock.expect(odsConsumeOrderDAOMock.getConsumeSequence()).andReturn(1L).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.getConsumeSequence();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveConsumeOrder() {
        List<OdsConsumeOrderDTO> list = new ArrayList<OdsConsumeOrderDTO>();
        OdsConsumeOrderDTO odsConsumeOrderDTO = new OdsConsumeOrderDTO();
        odsConsumeOrderDTO.setConsumeNo("11111");
        list.add(odsConsumeOrderDTO);
        odsConsumeOrderDAOMock.save((OdsConsumeOrderDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.saveConsumeOrder(list,new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void checkConsumeOrderByPDA() {
        UserDTO userDTO = new UserDTO();
        userDTO.setDutyType("3");
        EasyMock.expect(odsConsumeOrderDAOMock.checkConsumeOrderByPDA(
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1)
                .andReturn("0").times(1)
                .andReturn(null).times(1)
                .andReturn("2").times(1);
        EasyMock.expect(userDAOMock.getUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(userDTO).times(1);
        EasyMock.expect(odsConsumeOrderDAOMock.checkConsumeOrderLoc(
                (String)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S").times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        EasyMock.replay(userDAOMock);
        clientImplMock.checkConsumeOrderByPDA(new OrderCheckInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanStatus() {

        EasyMock.expect(odsConsumeOrderDAOMock.scanStatus(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeOrderDTO>()).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);
        clientImplMock.scanStatus("");
    }
}