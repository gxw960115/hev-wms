package com.haier.hevwms.consume.service.impl;

import com.haier.hevwms.consume.dao.ConsumePDADAO;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
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

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/2 13:58
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class ConsumePDAServiceImplTest {

    private ConsumePDAServiceImpl clientImplMock = new ConsumePDAServiceImpl();
    private WmsLoginDAO wmsLoginDAOMock;
    private FileUploadDAO fileUploadDAOMock;
    private RfLogDAO rfLogDAOMock;
    private ConsumePDADAO consumePDADAOMock;

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
        consumePDADAOMock = EasyMock.createMock(ConsumePDADAO.class);
        clientImplMock.setWmsLoginDAO(wmsLoginDAOMock);
        clientImplMock.setFileUploadDAO(fileUploadDAOMock);
        clientImplMock.setRfLogDAO(rfLogDAOMock);
        clientImplMock.setConsumePDADAO(consumePDADAOMock);
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
        userDTO.setEmail("111");
        UploadFile pdaFile = new UploadFile();
        pdaFile.setVersions("1");
        EasyMock.expect(wmsLoginDAOMock.getRfUserByName(
                (String)EasyMock.anyObject())
        ).andReturn(userDTO).times(1).andReturn(null).times(1);
        EasyMock.expect(fileUploadDAOMock.getPdaFileInfo()).andReturn(pdaFile).times(1);
        EasyMock.replay(wmsLoginDAOMock);
        EasyMock.replay(fileUploadDAOMock);
        clientImplMock.checkSign("tom","1","1");
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
        clientImplMock.writeLog("",
                "",
                "",
                null,
                "",
                "",
                "",
                "",
                "");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrderDelete() {
        OrderDeleteInDTO orderCheckInDTO = new OrderDeleteInDTO();
        orderCheckInDTO.setBarcode("111");
        consumePDADAOMock.orderDelete(
                orderCheckInDTO,
                null);
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDADAOMock);
        //clientImplMock.consumeOrderDelete(orderCheckInDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanConsumeCheck() {

        consumePDADAOMock.scanConsumeCheck(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDADAOMock);
        clientImplMock.scanConsumeCheck(new OrderUploadInDTO());

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void consumeOrderIgp() {

        consumePDADAOMock.consumeOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (WmsOrderIgpOut)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(consumePDADAOMock);
        clientImplMock.consumeOrderIgp(new WmsOrderIgpIn());

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
        EasyMock.expect(consumePDADAOMock.scanStatus(
                        (String)EasyMock.anyObject())
        ).andReturn(123456L).times(1);
        EasyMock.replay(consumePDADAOMock);
        clientImplMock.scanStatus("123456");
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
        consumePDADAOMock.updateSapInfo(new OrderIgpInDTO());
        EasyMock.expectLastCall().times(1);
        consumePDADAOMock.updateSapInfo(new OrderIgpInDTO());
    }
}