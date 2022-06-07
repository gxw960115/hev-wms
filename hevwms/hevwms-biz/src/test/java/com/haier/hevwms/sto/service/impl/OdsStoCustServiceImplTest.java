package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.sto.dao.OdsStoCustDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 14:47
 * @Description:
 */
public class OdsStoCustServiceImplTest {

    private OdsStoCustDAO odsStoCustDAO;
    private UserDAO userDAO;
    private OdsStoCustServiceImpl odsStoCustService = new OdsStoCustServiceImpl();

    @Before
    public void init(){
        odsStoCustDAO = EasyMock.createMock(OdsStoCustDAO.class);
        userDAO = EasyMock.createMock(UserDAO.class);
        odsStoCustService.setOdsStoCustDAO(odsStoCustDAO);
        odsStoCustService.setUserDAO(userDAO);
    }

    @Test
    public void searchOdsStoCusts() {
        Pager<OdsStoCustDTO> pager = new Pager<OdsStoCustDTO>();
        OdsStoCustDTO odsStoCustDTO = new OdsStoCustDTO();
        EasyMock.expect(odsStoCustDAO.searchOdsStoCusts(
                pager,odsStoCustDTO)
        ).andReturn(new ArrayList<OdsStoCustDTO>());
        EasyMock.expect(odsStoCustDAO.searchOdsStoCustsCount(
                odsStoCustDTO)
        ).andReturn(1L);
        EasyMock.replay(odsStoCustDAO);
        odsStoCustService.searchOdsStoCusts(pager,odsStoCustDTO);
    }

    @Test
    public void searchOdsStoCustsCount() {
        odsStoCustService.searchOdsStoCustsCount(new OdsStoCustDTO());
    }

    @Test
    public void getStoCustNo() {
        EasyMock.expect(odsStoCustDAO.selectOdsStoCustNo()).andReturn("11");
        EasyMock.replay(odsStoCustDAO);
        odsStoCustService.getStoCustNo();
    }

    @Test
    public void addStoCustInfo() {
        List<OdsStoCustDTO> list = new ArrayList<OdsStoCustDTO>();
        OdsStoCustDTO odsStoCustDTO = new OdsStoCustDTO();
        odsStoCustDTO.setBasicUnit("11");
        odsStoCustDTO.setQty(1L);
        list.add(odsStoCustDTO);
        odsStoCustDAO.save((OdsStoCustDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsStoCustService.addStoCustInfo(odsStoCustDTO,list);
    }

    @Test
    public void deleteStoCustByNo() {
        odsStoCustDAO.deleteStoCustByNo("11");
        EasyMock.expectLastCall();
        odsStoCustService.deleteStoCustByNo("11");
    }

    @Test
    public void deleteStoCustByIds() {
        odsStoCustDAO.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsStoCustService.deleteStoCustByIds(new ArrayList<Long>());
    }

    @Test
    public void stoApprove() {
        odsStoCustDAO.stoApprove("11","11");
        EasyMock.expectLastCall();
        odsStoCustService.stoApprove("11","11");
    }

    @Test
    public void checkStoCust() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(odsStoCustDAO.checkStoCustExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("1").times(1).andReturn("").times(1).andReturn("0").times(1).andReturn("2").times(1);
        EasyMock.expect(userDAO.getUserByName((String)EasyMock.anyObject())).andReturn(user);
        EasyMock.expect(odsStoCustDAO.checkStoCustLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S");
        EasyMock.replay(odsStoCustDAO);
        EasyMock.replay(userDAO);
        odsStoCustService.checkStoCust(new OrderCheckInDTO());
    }

    @Test
    public void scanStatus() {
        odsStoCustService.scanStatus("11");
    }

    @Test
    public void orderOgp() {
        WmsOrderIgpIn in = new WmsOrderIgpIn();
        WmsOrderIgpIn in_1 = new WmsOrderIgpIn();
        in.setOrderType("1");
        in_1.setOrderType("2");
        odsStoCustDAO.orderOgpIn((WmsOrderIgpIn)EasyMock.anyObject(),(WmsOrderIgpOut)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsStoCustDAO.orderOgpOut((WmsOrderIgpIn)EasyMock.anyObject(),(WmsOrderIgpOut)EasyMock.anyObject());
        EasyMock.expectLastCall();

        EasyMock.replay(odsStoCustDAO);
        odsStoCustService.orderOgp(in);
        odsStoCustService.orderOgp(in_1);
    }

    @Test
    public void updateOgpInfo() {
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        OrderIgpInDTO inpara_1 = new OrderIgpInDTO();
        inpara.setOrderType("1");
        inpara_1.setOrderType("2");

        odsStoCustDAO.updateOgpInInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsStoCustDAO.updateOgpOutInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();

        odsStoCustService.updateOgpInfo(inpara);
        odsStoCustService.updateOgpInfo(inpara_1);
    }
}