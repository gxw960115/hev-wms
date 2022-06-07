package com.haier.hevwms.so.service.impl;

import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.so.dao.SoPDADAO;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 13:24
 * @Description:
 */
public class SoPDAServiceImplTest {

    private WmsLoginDAO wmsLoginDAO;
    private FileUploadDAO fileUploadDAO;
    private RfLogDAO rfLogDAO;
    private SoPDADAO soPDADAO;

    private SoPDAServiceImpl soPDAService = new SoPDAServiceImpl();

    @Before
    public void init(){
        wmsLoginDAO = EasyMock.createMock(WmsLoginDAO.class);
        fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
        rfLogDAO = EasyMock.createMock(RfLogDAO.class);
        soPDADAO = EasyMock.createMock(SoPDADAO.class);

        soPDAService.setWmsLoginDAO(wmsLoginDAO);
        soPDAService.setFileUploadDAO(fileUploadDAO);
        soPDAService.setRfLogDAO(rfLogDAO);
        soPDAService.setSoPDADAO(soPDADAO);
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
        soPDAService.checkSign("11","1","1.0");
    }

    @Test
    public void writeLog() {
        rfLogDAO.writeLog((RfLog)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfLogDAO);
        soPDAService.writeLog("","","",
                null,"","",
                "","","");
    }

    @Test
    public void soOrderDelete() {
        soPDADAO.orderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDADAO);
        soPDAService.soOrderDelete(new OrderDeleteInDTO());
    }

    @Test
    public void giftSoOrderDelete() {
        soPDADAO.giftSoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(soPDADAO);
        soPDAService.giftSoOrderDelete(new OrderDeleteInDTO());

    }

    @Test
    public void scanSoCheck() {
        soPDADAO.scanSoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        soPDAService.scanSoCheck(new OrderUploadInDTO());
    }

    @Test
    public void scanSoOldBarcodeCheck() {
        soPDADAO.scanSoOldBarcodeCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        soPDAService.scanSoOldBarcodeCheck(new OrderUploadInDTO());
    }

    @Test
    public void scanGiftSoCheck() {
        soPDADAO.scanGiftSoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        soPDAService.scanGiftSoCheck(new OrderUploadInDTO());
    }

    @Test
    public void soOrderIgp() {
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        inpara.setPostingdate("2019-05-10");

        soPDADAO.soOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        soPDAService.soOrderIgp(new OrderIgpInDTO());
    }

    @Test
    public void giftSoOrderIgp() {
        OrderIgpInDTO inpara = new OrderIgpInDTO();
        inpara.setPostingdate("2019-05-10");

        soPDADAO.soOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        soPDAService.giftSoOrderIgp(new OrderIgpInDTO());
    }
}