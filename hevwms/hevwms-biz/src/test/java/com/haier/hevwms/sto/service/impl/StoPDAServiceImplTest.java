package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.so.dao.SoPDADAO;
import com.haier.hevwms.sto.dao.StoPDADAO;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 15:36
 * @Description:
 */
public class StoPDAServiceImplTest {

    private WmsLoginDAO wmsLoginDAO;
    private FileUploadDAO fileUploadDAO;
    private RfLogDAO rfLogDAO;
    private StoPDADAO stoPDADAO;

    private StoPDAServiceImpl stoPDAService = new StoPDAServiceImpl();

    @Before
    public void init(){
        wmsLoginDAO = EasyMock.createMock(WmsLoginDAO.class);
        fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
        rfLogDAO = EasyMock.createMock(RfLogDAO.class);
        stoPDADAO = EasyMock.createMock(StoPDADAO.class);

        stoPDAService.setWmsLoginDAO(wmsLoginDAO);
        stoPDAService.setFileUploadDAO(fileUploadDAO);
        stoPDAService.setRfLogDAO(rfLogDAO);
        stoPDAService.setStoPDADAO(stoPDADAO);
    }

    @Test
    public void checkSign() {
        UserDTO userDTO = new UserDTO();
        UploadFile uploadFile = new UploadFile();
        uploadFile.setVersions("1.0");
        userDTO.setEmail("1111111");
        EasyMock.expect(wmsLoginDAO.getRfUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(userDTO).times(1).andReturn(null).times(1);
        EasyMock.expect(fileUploadDAO.getPdaFileInfo()
        ).andReturn(uploadFile).times(1);
        EasyMock.replay(wmsLoginDAO);
        EasyMock.replay(fileUploadDAO);
        stoPDAService.checkSign("11","1","1.0");
    }

    @Test
    public void writeLog() {
        rfLogDAO.writeLog((RfLog)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfLogDAO);
        stoPDAService.writeLog("","","",
                null,"","",
                "","","");
    }

    @Test
    public void stoOrderDelete() {
        stoPDADAO.orderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(stoPDADAO);
        stoPDAService.stoOrderDelete(new OrderDeleteInDTO());
    }

    @Test
    public void scanStoCheck() {
        stoPDADAO.scanStoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stoPDAService.scanStoCheck(new OrderUploadInDTO());
    }

    @Test
    public void scanStodnCheck() {
        stoPDADAO.scanStodnCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stoPDAService.scanStodnCheck(new OrderUploadInDTO());
    }

    @Test
    public void stoOrderOgp() {
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        inpara.setPostingdate("2019-05-10");
        stoPDADAO.stoOrderOgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stoPDAService.stoOrderOgp(inpara);
    }

    @Test
    public void stodnOrderIgp() {
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        inpara.setPostingdate("2019-05-10");
        stoPDADAO.stodnOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        stoPDAService.stodnOrderIgp(inpara);
    }
}