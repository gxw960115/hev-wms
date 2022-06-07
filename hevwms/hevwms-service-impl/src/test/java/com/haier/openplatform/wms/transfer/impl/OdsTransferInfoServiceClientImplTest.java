package com.haier.openplatform.wms.transfer.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.transfer.service.OdsTransferInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:46
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsTransferInfoServiceClientImplTest {

    private OdsTransferInfoServiceClientImpl clientImplMock = new OdsTransferInfoServiceClientImpl();
    private OdsTransferInfoService odsTransferInfoServiceMock;
    private RfWsService rfWsServiceMock;

    @Before
    public void init(){
        odsTransferInfoServiceMock = EasyMock.createMock(OdsTransferInfoService.class);
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        clientImplMock.setOdsTransferInfoService(odsTransferInfoServiceMock);
        clientImplMock.setRfWsService(rfWsServiceMock);
    }

    @Test
    public void searchOdsTransferInfos() {

        EasyMock.expect(odsTransferInfoServiceMock.searchTransferInfos(
                (Pager<OdsTransferInfoDTO>)EasyMock.anyObject(),
                (OdsTransferInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsTransferInfoDTO>()).times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.searchOdsTransferInfos(1L,10L,new OdsTransferInfoDTO());

    }

    @Test
    public void getTransferOrderNo() {
        EasyMock.expect(odsTransferInfoServiceMock.getTransferOrderNo()).andReturn("11111").times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.getTransferOrderNo();
    }

    @Test
    public void addTranferInfo() {
        EasyMock.expect(odsTransferInfoServiceMock.addTransferInfo(
                (OdsTransferInfoDTO)EasyMock.anyObject(),
                (List<OdsTransferInfoDTO>)EasyMock.anyObject())
        ).andReturn("111").times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.addTranferInfo(new OdsTransferInfoDTO(),new ArrayList<OdsTransferInfoDTO>());
    }

    @Test
    public void deleteTransferInfoByTransNo() {
        EasyMock.expect(odsTransferInfoServiceMock.deleteTransferInfoByTransNo(
                (String)EasyMock.anyObject())
        ).andReturn("11").times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.deleteTransferInfoByTransNo("1");
    }

    @Test
    public void transferApprove() {
        EasyMock.expect(odsTransferInfoServiceMock.transferApprove(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.transferApprove("1111","111");
    }

    @Test
    public void deleteTransferInfoByIds() {
        EasyMock.expect(odsTransferInfoServiceMock.deleteTransferInfoByIds(
                (List<Long>)EasyMock.anyObject())
        ).andReturn("11").times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.deleteTransferInfoByIds(new ArrayList<Long>());
    }

    @Test
    public void searchOdsTransferInfosCount() {
        EasyMock.expect(odsTransferInfoServiceMock.searchOdsTransferInfosCount(
                (OdsTransferInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.searchOdsTransferInfosCount(new OdsTransferInfoDTO());
    }

    @Test
    public void orderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderCheckInDTO orderUploadInDTO = new OrderCheckInDTO();
        orderUploadInDTO.setDoctype("TRANSFER");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsTransferInfoServiceMock.checkTransferInfo(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
        rfWsServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(rfWsServiceMock);
        EasyMock.replay(odsTransferInfoServiceMock);
        clientImplMock.orderCheck(orderUploadInDTO,"1");

    }
}