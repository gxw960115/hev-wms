package com.haier.openplatform.wms.sto.impl;

import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebServiceContext;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sto.service.OdsStoCustService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:37
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsStoCustServiceClientImplTest {

    private OdsStoCustServiceClientImpl clientImplMock = new OdsStoCustServiceClientImpl();
    private OdsStoCustService odsStoCustServiceMock;
    private RfWsService rfWsServiceMock;

    @Before
    public void init(){
        odsStoCustServiceMock = EasyMock.createMock(OdsStoCustService.class);
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        clientImplMock.setOdsStoCustService(odsStoCustServiceMock);
        clientImplMock.setRfWsService(rfWsServiceMock);
    }

    @Test
    public void searchOdsStoCusts() {

        EasyMock.expect(odsStoCustServiceMock.searchOdsStoCusts(
                (Pager<OdsStoCustDTO>)EasyMock.anyObject(),
                (OdsStoCustDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsStoCustDTO>()).times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.searchOdsStoCusts(1L,10L,new OdsStoCustDTO());
    }

    @Test
    public void searchOdsStoCustsCount() {

        EasyMock.expect(odsStoCustServiceMock.searchOdsStoCustsCount(
                (OdsStoCustDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.searchOdsStoCustsCount(new OdsStoCustDTO());
    }

    @Test
    public void getStoCustNo() {
        EasyMock.expect(odsStoCustServiceMock.getStoCustNo()).andReturn("1111").times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.getStoCustNo();
    }

    @Test
    public void addStoCustInfo() {
        EasyMock.expect(odsStoCustServiceMock.addStoCustInfo(
                (OdsStoCustDTO)EasyMock.anyObject(),
                (List<OdsStoCustDTO>)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.addStoCustInfo(new OdsStoCustDTO(), new ArrayList<OdsStoCustDTO>());
    }

    @Test
    public void deleteStoCustByNo() {
        EasyMock.expect(odsStoCustServiceMock.deleteStoCustByNo(
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.deleteStoCustByNo("1");
    }

    @Test
    public void deleteStoCustByIds() {
        EasyMock.expect(odsStoCustServiceMock.deleteStoCustByIds(
                (List<Long>)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.deleteStoCustByIds(new ArrayList<Long>());
    }

    @Test
    public void stoApprove() {
        EasyMock.expect(odsStoCustServiceMock.stoApprove(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.stoApprove("1","m");
    }

    @Test
    public void orderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsStoCustServiceMock.checkStoCust(
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
        EasyMock.replay(odsStoCustServiceMock);
        clientImplMock.orderCheck(new OrderCheckInDTO(),"1");
    }

    @Test
    public void orderOgp() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsStoCustServiceMock.scanStatus(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsStoCustDTO>()).times(1);
        odsStoCustServiceMock.updateOgpInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(odsStoCustServiceMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
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
        EasyMock.replay(odsStoCustServiceMock);
        try {
            clientImplMock.orderOgp(new OrderIgpInDTO(),"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}