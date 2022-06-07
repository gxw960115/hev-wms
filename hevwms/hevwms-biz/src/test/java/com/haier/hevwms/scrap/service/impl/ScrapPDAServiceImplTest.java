package com.haier.hevwms.scrap.service.impl;

import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.scrap.dao.ScrapPDADAO;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 10:33
 * @Description:
 */
public class ScrapPDAServiceImplTest {

    private WmsLoginDAO wmsLoginDAO;
    private FileUploadDAO fileUploadDAO;
    private RfLogDAO rfLogDAO;
    private ScrapPDADAO scrapPDADAO;
    private ScrapPDAServiceImpl scrapPDAService = new ScrapPDAServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        wmsLoginDAO = EasyMock.createMock(WmsLoginDAO.class);
        fileUploadDAO = EasyMock.createMock(FileUploadDAO.class);
        rfLogDAO = EasyMock.createMock(RfLogDAO.class);
        scrapPDADAO = EasyMock.createMock(ScrapPDADAO.class);
        scrapPDAService.setWmsLoginDAO(wmsLoginDAO);
        scrapPDAService.setFileUploadDAO(fileUploadDAO);
        scrapPDAService.setRfLogDAO(rfLogDAO);
        scrapPDAService.setScrapPDADAO(scrapPDADAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
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
        scrapPDAService.checkSign("11","1","1.0");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void writeLog() {
        rfLogDAO.writeLog((RfLog)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfLogDAO);
        scrapPDAService.writeLog("","","",
                null,"","",
                "","","");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderDelete() {
        scrapPDADAO.orderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDADAO);
        scrapPDAService.scrapOrderDelete(new OrderDeleteInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanScrapCheck() {
        scrapPDADAO.scanScrapCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDADAO);
        scrapPDAService.scanScrapCheck(new OrderUploadInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderIgp() {
        WmsOrderIgpIn orderIgpInDTO = new WmsOrderIgpIn();
        orderIgpInDTO.setPostingdate("2019-04-12");
        scrapPDADAO.scrapOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (WmsOrderIgpOut)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDADAO);
        scrapPDAService.scrapOrderIgp(orderIgpInDTO);
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
        scrapPDAService.scanStatus("111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateSapInfo() {
        scrapPDADAO.updateSapInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(scrapPDADAO);
        scrapPDAService.updateSapInfo(new OrderIgpInDTO());
    }
}