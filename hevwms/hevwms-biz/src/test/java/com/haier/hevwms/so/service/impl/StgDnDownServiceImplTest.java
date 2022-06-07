package com.haier.hevwms.so.service.impl;

import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.so.dao.SoPDADAO;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 13:39
 * @Description:
 */
public class StgDnDownServiceImplTest {

    private StgDnDownDAO stgDnDownDAO;
    private UserDAO userDAO;
    private SoPDADAO soPDADAO;
    private StgDnDownServiceImpl stgDnDownService = new StgDnDownServiceImpl();

    @Before
    public void init(){
        stgDnDownDAO = EasyMock.createMock(StgDnDownDAO.class);
        userDAO = EasyMock.createMock(UserDAO.class);
        soPDADAO = EasyMock.createMock(SoPDADAO.class);
        stgDnDownService.setStgDnDownDAO(stgDnDownDAO);
        stgDnDownService.setUserDAO(userDAO);
        stgDnDownService.setSoPDADAO(soPDADAO);
    }

    @Test
    public void searchStgDnDowns() {
        Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
        StgDnDownDTO stgDnDownDTO = new StgDnDownDTO();
        EasyMock.expect(stgDnDownDAO.searchStgDnDownsCount(
                stgDnDownDTO)
        ).andReturn(1L);
        EasyMock.expect(stgDnDownDAO.searchStgDnDownListByPage(
                pager,stgDnDownDTO)
        ).andReturn(new ArrayList<StgDnDownDTO>());
        EasyMock.replay(stgDnDownDAO);
        stgDnDownService.searchStgDnDowns(pager,stgDnDownDTO);
    }

    @Test
    public void searchStgDnReverse() {
        Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
        StgDnDownDTO stgDnDownDTO = new StgDnDownDTO();
        EasyMock.expect(stgDnDownDAO.searchStgDnDownsCount(
                stgDnDownDTO)
        ).andReturn(1L);
        EasyMock.expect(stgDnDownDAO.searchStgDnReverse(
                pager,stgDnDownDTO)
        ).andReturn(new ArrayList<StgDnDownDTO>());
        EasyMock.replay(stgDnDownDAO);
        stgDnDownService.searchStgDnReverse(pager,stgDnDownDTO);

    }

    @Test
    public void getStgDnDownsByParam() {
        stgDnDownService.getStgDnDownsByParam(new StgDnDownDTO());
    }

    @Test
    public void getExportAmount() {
        stgDnDownService.getExportAmount(new StgDnDownDTO());
    }

    @Test
    public void checkSo() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(stgDnDownDAO.checkSoExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Close").times(1)
                .andReturn("Not Support").times(1)
                .andReturn("").times(1)
                .andReturn("A").times(1);
        EasyMock.expect(userDAO.getUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(user);
        EasyMock.expect(stgDnDownDAO.checkSoLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("Y");
        EasyMock.replay(stgDnDownDAO);
        EasyMock.replay(userDAO);
        stgDnDownService.checkSo(new OrderCheckInDTO());
    }

    @Test
    public void getSoMaterialList() {
        stgDnDownService.getSoMaterialList("1");
    }

    @Test
    public void soGoodsReceive() {
        soPDADAO.soGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stgDnDownService.soGoodsReceive(new OrderIgpInDTO());
    }

    @Test
    public void soGoodsDelivery() {
        soPDADAO.soGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stgDnDownService.soGoodsDelivery(new OrderIgpInDTO());
    }

    @Test
    public void giftSoGoodsDelivery() {
        soPDADAO.giftSoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stgDnDownService.giftSoGoodsDelivery(new OrderIgpInDTO());
    }

    @Test
    public void getLocationNameByDnNo() {
        stgDnDownService.getLocationNameByDnNo("11");
    }

    @Test
    public void getFifoList() {
        EasyMock.expect(stgDnDownDAO.getFifoList(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OrderDelDetialDTO>());
        EasyMock.replay(stgDnDownDAO);
        stgDnDownService.getFifoList(new WmsOrderDelListInDTO(),"11","11");
    }

    @Test
    public void dnReverse() {
        stgDnDownDAO.dnReverse(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.replay(stgDnDownDAO);
        stgDnDownService.dnReverse(new OrderIgpInDTO());
    }

    @Test
    public void searchDirectDispatchDn() {
        Pager<StgDnDownDTO> pager = new Pager<StgDnDownDTO>();
        StgDnDownDTO stgDnDownDTO = new StgDnDownDTO();
        EasyMock.expect(stgDnDownDAO.searchDirectDispatchDnCount(
                stgDnDownDTO)
        ).andReturn(1L);
        EasyMock.expect(stgDnDownDAO.searchDirectDispatchDn(
                pager,stgDnDownDTO)
        ).andReturn(new ArrayList<StgDnDownDTO>());
        EasyMock.replay(stgDnDownDAO);
        stgDnDownService.searchDirectDispatchDn(pager,stgDnDownDTO);
    }
}
