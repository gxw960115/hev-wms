package com.haier.hevwms.customer.service.impl;

import com.haier.hevwms.customer.dao.OdsCustomerOrderDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
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
 * @Date: 2019/4/18 15:00
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsCustomerOrderServiceImplTest {

    private OdsCustomerOrderServiceImpl clientImplMock = new OdsCustomerOrderServiceImpl();
    private OdsCustomerOrderDAO odsCustomerOrderDAOMock;
    private UserDAO userDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsCustomerOrderDAOMock=EasyMock.createMock(OdsCustomerOrderDAO.class);
        userDAOMock = EasyMock.createMock(UserDAO.class);
        clientImplMock.setOdsCustomerOrderDAO(odsCustomerOrderDAOMock);
        clientImplMock.setUserDAO(userDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerOrders() {
        EasyMock.expect(odsCustomerOrderDAOMock.searchOdsCustomerOrders(
                (Pager<OdsCustomerOrderDTO>)EasyMock.anyObject(),
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsCustomerOrderDTO>()).times(1);
        EasyMock.expect(odsCustomerOrderDAOMock.searchOdsCustomerOrdersCount(
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.searchOdsCustomerOrders(
                new Pager<OdsCustomerOrderDTO>(),
                new OdsCustomerOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerOrdersCount() {
        EasyMock.expect(odsCustomerOrderDAOMock.searchOdsCustomerOrdersCount(
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.searchOdsCustomerOrdersCount(new OdsCustomerOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getCustomerOrderNo() {
        EasyMock.expect(odsCustomerOrderDAOMock.selectOdsCustomerOrderNo()
        ).andReturn("1").times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.getCustomerOrderNo();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void addCustomerOrderInfo() {
        List<OdsCustomerOrderDTO> list = new ArrayList<OdsCustomerOrderDTO>();
        OdsCustomerOrderDTO odsCustomerOrderDTO = new OdsCustomerOrderDTO();
        odsCustomerOrderDTO.setCreateBy("11");
        list.add(odsCustomerOrderDTO);
        odsCustomerOrderDAOMock.save((OdsCustomerOrderDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.addCustomerOrderInfo(new OdsCustomerOrderDTO(),list);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteCustomerOrderByCusNo() {
        odsCustomerOrderDAOMock.deleteCustomerOrderByCusNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.deleteCustomerOrderByCusNo("111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteCustomerOrderByIds() {
        odsCustomerOrderDAOMock.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.deleteCustomerOrderByIds(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void customerApprove() {
        odsCustomerOrderDAOMock.customerApprove(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        clientImplMock.customerApprove("11","11");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void checkCustomerOrder() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(odsCustomerOrderDAOMock.checkCustomerOrderExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("1").times(1)
                .andReturn("").times(1)
                .andReturn("0").times(1)
                .andReturn("2").times(1);
        EasyMock.expect(userDAOMock.getUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(user).times(1);
        EasyMock.expect(odsCustomerOrderDAOMock.checkCustomerLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S").times(1);
        EasyMock.replay(odsCustomerOrderDAOMock);
        EasyMock.replay(userDAOMock);
        clientImplMock.checkCustomerOrder(new OrderCheckInDTO());
    }
}