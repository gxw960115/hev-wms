package com.haier.openplatform.wms.customer.impl;

import com.haier.hevwms.customer.service.OdsCustomerOrderService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/21 16:28
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsCustomerOrderServiceClientImplTest {

    private OdsCustomerOrderServiceClientImpl clientImplMock = new OdsCustomerOrderServiceClientImpl();
    private OdsCustomerOrderService odsCustomerOrderServiceMock;
    private RfWsService rfWsServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsCustomerOrderServiceMock = EasyMock.createMock(OdsCustomerOrderService.class);
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        clientImplMock.setOdsCustomerOrderService(odsCustomerOrderServiceMock);
        clientImplMock.setRfWsService(rfWsServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerOrders() {
        EasyMock.expect(odsCustomerOrderServiceMock.searchOdsCustomerOrders(
                (Pager<OdsCustomerOrderDTO >)EasyMock.anyObject(),
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsCustomerOrderDTO>()).times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.searchOdsCustomerOrders(1L,10L,new OdsCustomerOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerOrdersCount() {
        EasyMock.expect(odsCustomerOrderServiceMock.searchOdsCustomerOrdersCount(
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.searchOdsCustomerOrdersCount(new OdsCustomerOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getCustomerOrderNo() {
        EasyMock.expect(odsCustomerOrderServiceMock.getCustomerOrderNo()).andReturn("0001").times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.getCustomerOrderNo();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void addCustomerOrderInfo() {
        EasyMock.expect(odsCustomerOrderServiceMock.addCustomerOrderInfo(
                (OdsCustomerOrderDTO)EasyMock.anyObject(),
                (List<OdsCustomerOrderDTO>)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.addCustomerOrderInfo(new OdsCustomerOrderDTO(),new ArrayList<OdsCustomerOrderDTO>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteCustomerOrderByCusNo() {
        EasyMock.expect(odsCustomerOrderServiceMock.deleteCustomerOrderByCusNo(
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.deleteCustomerOrderByCusNo("1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteCustomerOrderByIds() {
        EasyMock.expect(odsCustomerOrderServiceMock.deleteCustomerOrderByIds(
                (List<Long>)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.deleteCustomerOrderByIds(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void customerApprove() {
        EasyMock.expect(odsCustomerOrderServiceMock.customerApprove(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsCustomerOrderServiceMock);
        clientImplMock.customerApprove("1","1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderCheck() {
        OrderCheckOutDTO result = new OrderCheckOutDTO();
        EasyMock.expect(rfWsServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new RfLogResult()).times(1);
        EasyMock.expect(odsCustomerOrderServiceMock.checkCustomerOrder(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(result).times(1);
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
        EasyMock.replay(odsCustomerOrderServiceMock);
        EasyMock.replay(rfWsServiceMock);
        clientImplMock.orderCheck(new OrderCheckInDTO(),"");
    }
}