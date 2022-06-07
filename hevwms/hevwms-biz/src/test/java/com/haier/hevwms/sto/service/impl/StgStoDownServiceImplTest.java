package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.basic.dao.OdsHistoryLogDAO;
import com.haier.hevwms.sapinterface.DownloadStoFromSap;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.sto.dao.StoPDADAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 15:36
 * @Description:
 */
public class StgStoDownServiceImplTest {

    private StgStoDownDAO stgStoDownDAO;
    private OdsHistoryLogDAO odsHistoryLogDAO;
    private UserDAO userDAO;
    private StoPDADAO stoPDADAO;

    private StgStoDownServiceImpl stgStoDownService = new StgStoDownServiceImpl();

    @Before
    public void init(){
        stgStoDownDAO = EasyMock.createMock(StgStoDownDAO.class);
        odsHistoryLogDAO = EasyMock.createMock(OdsHistoryLogDAO.class);
        userDAO = EasyMock.createMock(UserDAO.class);
        stoPDADAO = EasyMock.createMock(StoPDADAO.class);

        stgStoDownService.setStgStoDownDAO(stgStoDownDAO);
        stgStoDownService.setOdsHistoryLogDAO(odsHistoryLogDAO);
        stgStoDownService.setUserDAO(userDAO);
        stgStoDownService.setStoPDADAO(stoPDADAO);
    }


    @Test
    public void searchStgStoDowns() {
        Pager<StgStoDownDTO> pager = new Pager<StgStoDownDTO>();
        StgStoDownDTO odsStoCustScanInfoDTO = new StgStoDownDTO();
        EasyMock.expect(stgStoDownDAO.searchStgStoDowns(
                pager,odsStoCustScanInfoDTO)
        ).andReturn(new ArrayList<StgStoDownDTO>());
        EasyMock.expect(stgStoDownDAO.searchStgStoDownsCount(
                odsStoCustScanInfoDTO)
        ).andReturn(1L);
        EasyMock.replay(stgStoDownDAO);
        stgStoDownService.searchStgStoDowns(pager,odsStoCustScanInfoDTO);
    }

    @Test
    public void getStgStoDownById() {
        stgStoDownService.getStgStoDownById(1L);
    }

    @Test
    public void getStgStoDowns() {
        stgStoDownService.getStgStoDowns(new StgStoDownDTO());
    }

    @Test
    public void closeStgStoDown() {
        stgStoDownService.closeStgStoDown("","");
    }

    @Test
    public void openStgStoDown() {
        stgStoDownService.openStgStoDown("","");
    }

    @Test
    public void updateStoConfirm() {
        stgStoDownService.updateStoConfirm("11");
    }

    @Test
    public void getExportAmount() {
        stgStoDownService.getExportAmount(new StgStoDownDTO());
    }

    @Test
    public void checkStoReceive() {

        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(stgStoDownDAO.checkStoReceiveExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Y");
        EasyMock.expect(userDAO.getUserByName((String)EasyMock.anyObject())).andReturn(user);
        EasyMock.expect(stgStoDownDAO.checkStoReceiveLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("Y");
        EasyMock.replay(stgStoDownDAO);
        EasyMock.replay(userDAO);
        stgStoDownService.checkStoReceive(new OrderCheckInDTO());
    }

    @Test
    public void checkStoDelivery() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        EasyMock.expect(stgStoDownDAO.checkStoDeliveryExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Y");
        EasyMock.expect(userDAO.getUserByName((String)EasyMock.anyObject())).andReturn(user);
        EasyMock.expect(stgStoDownDAO.checkStoDeliveryLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("Y");
        EasyMock.replay(stgStoDownDAO);
        EasyMock.replay(userDAO);
        stgStoDownService.checkStoDelivery(new OrderCheckInDTO());
    }

    @Test
    public void stoGoodsDelivery() {
        stoPDADAO.stoGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stgStoDownService.stoGoodsDelivery(new OrderIgpInDTO());
    }

    @Test
    public void stoGoodsReceive() {
        stoPDADAO.stoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderGoodsTransOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stgStoDownService.stoGoodsReceive(new OrderIgpInDTO());
    }

    @Test
    public void checkOrderByPDA() {
        UserDTO user = new UserDTO();
        user.setDutyType("3");
        OrderCheckInDTO dto = new OrderCheckInDTO();
        dto.setDoctype("STO");
        OrderCheckInDTO dto_1 = new OrderCheckInDTO();
        dto_1.setDoctype("STODN");
        EasyMock.expect(stgStoDownDAO.checkStoDeliveryExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Y").times(2);
        EasyMock.expect(userDAO.getUserByName((String)EasyMock.anyObject())).andReturn(user).times(2);
        EasyMock.expect(stgStoDownDAO.checkStoDeliveryLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S");
        EasyMock.expect(stgStoDownDAO.checkStoReceiveExist(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn("Y").times(2);
        EasyMock.expect(stgStoDownDAO.checkStoReceiveLoc(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (Long)EasyMock.anyObject())
        ).andReturn("S");
        EasyMock.replay(stgStoDownDAO);
        EasyMock.replay(userDAO);
        stgStoDownService.checkOrderByPDA(dto);
        stgStoDownService.checkOrderByPDA(dto_1);
    }

    @Test
    public void getGiLocationNameListBySTONO() {
        stgStoDownService.getGiLocationNameListBySTONO("11");
    }

    @Test
    public void getGrLocationNameListBySTONO() {
        stgStoDownService.getGrLocationNameListBySTONO("11");
    }
}