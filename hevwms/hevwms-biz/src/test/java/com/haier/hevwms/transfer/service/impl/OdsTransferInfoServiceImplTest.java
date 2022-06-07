package com.haier.hevwms.transfer.service.impl;

import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.transfer.dao.OdsTransferInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 16:39
 * @Description:
 */
public class OdsTransferInfoServiceImplTest {

    private OdsTransferInfoDAO odsTransferInfoDAO;
    private UserDAO userDAO;
    private OdsTransferInfoServiceImpl odsTransferInfoService = new OdsTransferInfoServiceImpl();

    @Before
    public void init(){
        odsTransferInfoDAO = EasyMock.createMock(OdsTransferInfoDAO.class);
        userDAO = EasyMock.createMock(UserDAO.class);
        odsTransferInfoService.setOdsTransferInfoDAO(odsTransferInfoDAO);
        odsTransferInfoService.setUserDAO(userDAO);
    }

    @Test
    public void searchTransferInfos() {

        Pager<OdsTransferInfoDTO> pager = new Pager<OdsTransferInfoDTO>();
        OdsTransferInfoDTO odsSoGrInfoDTO = new OdsTransferInfoDTO();
        EasyMock.expect(odsTransferInfoDAO.searchOdsTransferInfosCount(odsSoGrInfoDTO)).andReturn(1L);
        EasyMock.expect(odsTransferInfoDAO.searchOdsTransferInfos(
                pager,odsSoGrInfoDTO)
        ).andReturn(new ArrayList<OdsTransferInfoDTO>());
        EasyMock.replay(odsTransferInfoDAO);
        odsTransferInfoService.searchTransferInfos(pager,odsSoGrInfoDTO);
    }

    @Test
    public void getTransferOrderNo() {
        EasyMock.expect(odsTransferInfoDAO.selectOdsTransferInfoNo()).andReturn("11").times(1);
        EasyMock.replay(odsTransferInfoDAO);
        odsTransferInfoService.getTransferOrderNo();
    }

    @Test
    public void addTransferInfo() {
        List<OdsTransferInfoDTO> list = new ArrayList<OdsTransferInfoDTO>();
        OdsTransferInfoDTO odsTransferInfoDTO = new OdsTransferInfoDTO();
        odsTransferInfoDTO.setGiLocation("11");
        odsTransferInfoDTO.setQty(1L);
        list.add(odsTransferInfoDTO);
        odsTransferInfoDAO.save((OdsTransferInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsTransferInfoService.addTransferInfo(odsTransferInfoDTO,list);
    }

    @Test
    public void deleteTransferInfoByTransNo() {
        odsTransferInfoDAO.deleteTransferInfoByTransNo("11");
        EasyMock.expectLastCall();
        odsTransferInfoService.deleteTransferInfoByTransNo("11");
    }

    @Test
    public void deleteTransferInfoByIds() {
        odsTransferInfoDAO.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsTransferInfoService.deleteTransferInfoByIds(new ArrayList<Long>());
    }

    @Test
    public void transferApprove() {
        odsTransferInfoDAO.transferApprove("11","11");
        EasyMock.expectLastCall();
        odsTransferInfoService.transferApprove("11","11");
    }

    @Test
    public void searchOdsTransferInfosCount() {
        odsTransferInfoService.searchOdsTransferInfosCount(new OdsTransferInfoDTO());
    }

    @Test
    public void checkTransferInfo() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(userDAO.getUserByName((String)EasyMock.anyObject())).andReturn(user);
        EasyMock.expect(odsTransferInfoDAO.checkTransferOrderExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("1").
                times(1).andReturn("").times(1).andReturn("0").
                times(1).andReturn("2").times(1);
        EasyMock.expect(odsTransferInfoDAO.checkTransferLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("Y");
        odsTransferInfoService.checkTransferInfo(new OrderCheckInDTO());
    }

    @Test
    public void scanStatus() {
        odsTransferInfoService.scanStatus("11");
    }
}