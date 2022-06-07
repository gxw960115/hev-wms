package com.haier.hevwms.scrap.service.impl;

import com.haier.hevwms.scrap.dao.OdsScrapOrderDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 10:32
 * @Description:
 */
public class OdsScrapOrderServiceImplTest {

    private OdsScrapOrderDAO odsScrapOrderDAO;
    private UserDAO userDAO;
    private OdsScrapOrderServiceImpl odsScrapOrderService = new OdsScrapOrderServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsScrapOrderDAO = EasyMock.createMock(OdsScrapOrderDAO.class);
        userDAO = EasyMock.createMock(UserDAO.class);
        odsScrapOrderService.setOdsScrapOrderDAO(odsScrapOrderDAO);
        odsScrapOrderService.setUserDAO(userDAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapOrderByPage() {
        Pager<OdsScrapOrderDTO> pager = new Pager<OdsScrapOrderDTO>();
        OdsScrapOrderDTO odsScrapOrderDTO = new OdsScrapOrderDTO();
        EasyMock.expect(odsScrapOrderDAO.searchOdsScrapOrderByPage(
                pager,odsScrapOrderDTO)
        ).andReturn(new ArrayList<OdsScrapOrderDTO>());
        EasyMock.expect(odsScrapOrderDAO.searchOdsScrapOrderCount(
                odsScrapOrderDTO)
        ).andReturn(1L);
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.searchOdsScrapOrderByPage(pager,odsScrapOrderDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteScrapOrder() {
        EasyMock.expect(odsScrapOrderDAO.deleteAll(
                (List<Long>)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.deleteScrapOrder(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void confirmScrapOrder() {
        EasyMock.expect(odsScrapOrderDAO.confirmScrapOrder(
                (List<Long>)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.confirmScrapOrder(new ArrayList<Long>(),"11");
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
        EasyMock.expect(odsScrapOrderDAO.searchOdsScrapOrderCount(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.getExportAmount(new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsScrapOrderListByParm() {
        EasyMock.expect(odsScrapOrderDAO.getOdsScrapOrderListByParm(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapOrderDTO>());
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.getOdsScrapOrderListByParm(new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getScrapSequence() {
        EasyMock.expect(odsScrapOrderDAO.getScrapSequence()).andReturn(111L);
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.getScrapSequence();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveScrapOrder() {
        List<OdsScrapOrderDTO> list = new ArrayList<OdsScrapOrderDTO>();
        OdsScrapOrderDTO odsScrapOrderDTO = new OdsScrapOrderDTO();
        odsScrapOrderDTO.setScrapNo("11111111111");
        list.add(odsScrapOrderDTO);
        odsScrapOrderDAO.save((OdsScrapOrderDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(odsScrapOrderDAO);
        odsScrapOrderService.saveScrapOrder(list,odsScrapOrderDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void checkScrapOrderByPDA() {
        OrderCheckInDTO orderCheckInDTO = new OrderCheckInDTO();
        orderCheckInDTO.setOrno("11111");
        UserDTO user = new UserDTO();
        user.setId(11L);
        user.setDutyType("3");
        EasyMock.expect(odsScrapOrderDAO.checkScrapOrderByPDA(
                "11111")
        ).andReturn("1")
                .times(1).andReturn("")
                .times(1).andReturn("0")
                .times(1).andReturn("2")
                .times(1);
        EasyMock.expect(userDAO.getUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(user);
        EasyMock.expect(odsScrapOrderDAO.checkScrapOrderLoc("11111",11L)).andReturn("S");
        EasyMock.replay(odsScrapOrderDAO);
        EasyMock.replay(userDAO);
        odsScrapOrderService.checkScrapOrderByPDA(orderCheckInDTO);
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
        odsScrapOrderService.scanStatus("111");
    }
}