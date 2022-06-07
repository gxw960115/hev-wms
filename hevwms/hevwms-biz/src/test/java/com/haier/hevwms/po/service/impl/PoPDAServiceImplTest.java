package com.haier.hevwms.po.service.impl;

import com.haier.hevwms.po.dao.PoPDADAO;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/22 13:57
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class PoPDAServiceImplTest {

    private PoPDAServiceImpl clientImplMock = new PoPDAServiceImpl();
    private WmsLoginDAO wmsLoginDAOMock;
    private FileUploadDAO fileUploadDAOMock;
    private RfLogDAO rfLogDAOMock;
    private PoPDADAO poPDADAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        wmsLoginDAOMock = EasyMock.createMock(WmsLoginDAO.class);
        fileUploadDAOMock = EasyMock.createMock(FileUploadDAO.class);
        rfLogDAOMock = EasyMock.createMock(RfLogDAO.class);
        poPDADAOMock = EasyMock.createMock(PoPDADAO.class);

        clientImplMock.setWmsLoginDAO(wmsLoginDAOMock);
        clientImplMock.setFileUploadDAO(fileUploadDAOMock);
        clientImplMock.setRfLogDAO(rfLogDAOMock);
        clientImplMock.setPoPDADAO(poPDADAOMock);
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
        EasyMock.expect(wmsLoginDAOMock.getRfUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(userDTO).times(1).andReturn(null).times(1);
        EasyMock.expect(fileUploadDAOMock.getPdaFileInfo()
        ).andReturn(uploadFile).times(1);
        EasyMock.replay(wmsLoginDAOMock);
        EasyMock.replay(fileUploadDAOMock);
        clientImplMock.checkSign("11","1","1.0");

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
        rfLogDAOMock.writeLog((RfLog)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfLogDAOMock);
        clientImplMock.writeLog("","","",
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
    public void poOrderDelete() {
        poPDADAOMock.orderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.poOrderDelete(new OrderDeleteInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderDelete(){
        poPDADAOMock.giftPoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.giftPoOrderDelete(new OrderDeleteInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanPoCheck() {
        poPDADAOMock.scanPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.scanPoCheck(new OrderUploadInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanGiftPoCheck(){
        poPDADAOMock.scanGiftPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.scanGiftPoCheck(new OrderUploadInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderIgp() {
        OrderIgpInDTO orderIgpInDTO = new OrderIgpInDTO();
        orderIgpInDTO.setPostingdate("2019-04-12");
        poPDADAOMock.poOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.poOrderIgp(orderIgpInDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderIgp(){
        OrderIgpInDTO orderIgpInDTO = new OrderIgpInDTO();
        orderIgpInDTO.setPostingdate("2019-04-12");
        poPDADAOMock.giftPoOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (OrderIgpOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDADAOMock);
        clientImplMock.giftPoOrderIgp(orderIgpInDTO);
    }
}