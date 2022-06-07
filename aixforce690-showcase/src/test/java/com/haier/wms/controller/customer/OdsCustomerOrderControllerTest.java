package com.haier.wms.controller.customer;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerOrderServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @Auther: mahuansen
 * @Date: 2019/4/30 14:19
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class,UserUtil.class})
public class OdsCustomerOrderControllerTest {

    private OdsCustomerOrderController odsCustomerOrderController = new OdsCustomerOrderController();
    private OdsCustomerOrderServiceClient odsCustomerOrderServiceClient;
    private HttpServletResponse response;
    private HttpServletRequest request;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsCustomerOrderServiceClient = EasyMock.createMock(OdsCustomerOrderServiceClient.class);
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        odsCustomerOrderController.setOdsCustomerOrderServiceClient(odsCustomerOrderServiceClient);
        BaseUser baseUser = new BaseUser();
        baseUser.setName("TEST");
        PowerMockito.mockStatic(PageUtil.class,SessionConstants.class,UserUtil.class);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchCustomerOrder() {
        OdsCustomerOrderDTO odsCustomerOrderDTO = new OdsCustomerOrderDTO();
        odsCustomerOrderDTO.setBasicUnit("11");
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsCustomerOrderServiceClient.searchOdsCustomerOrders(
                1L,
                10L,
                odsCustomerOrderDTO)
        ).andReturn(new Pager<OdsCustomerOrderDTO>()).times(1);
        EasyMock.replay(request);
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.searchCustomerOrder(request,odsCustomerOrderDTO);

    }

//    @Test
//    public void addCustomerOrder() {
//        PowerMockito.mockStatic(JSON.class);
//        PowerMockito.when(JSON.parseArray(
//                (String)EasyMock.anyObject(),
//                OdsCustomerOrderDTO.class)
//        ).thenReturn(new ArrayList<OdsCustomerOrderDTO>());
//        EasyMock.expect(odsCustomerOrderServiceClient.addCustomerOrderInfo(
//                (OdsCustomerOrderDTO)EasyMock.anyObject(),
//                (List<OdsCustomerOrderDTO>)EasyMock.anyObject())
//        ).andReturn("1");
//        EasyMock.replay(odsCustomerOrderServiceClient);
//        odsCustomerOrderController.addCustomerOrder(new OdsCustomerOrderDTO(),"1");
//    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getCustomerOrderNo() {
        EasyMock.expect(odsCustomerOrderServiceClient.getCustomerOrderNo()).andReturn("11");
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.getCustomerOrderNo();
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
        OdsCustomerOrderDTO odsCustomerOrderDTO = new OdsCustomerOrderDTO();
        odsCustomerOrderDTO.setCreateBy("TEST");
        EasyMock.expect(odsCustomerOrderServiceClient.deleteCustomerOrderByCusNo(
                (String)EasyMock.anyObject())
        ).andReturn("success").times(1).andReturn("error").times(1);
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.deleteCustomerOrderByCusNo(odsCustomerOrderDTO);
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
        EasyMock.expect(odsCustomerOrderServiceClient.deleteCustomerOrderByIds(
                (List<Long>)EasyMock.anyObject())
        ).andReturn("1");
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.deleteCustomerOrderByIds("1111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchCustomerOrdersAmount() {
        EasyMock.expect(odsCustomerOrderServiceClient.searchOdsCustomerOrdersCount(
                (OdsCustomerOrderDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.searchCustomerOrdersAmount(request,response,new OdsCustomerOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportExcel() {
        OdsCustomerOrderDTO odsCustomerOrderDTO = new OdsCustomerOrderDTO();
        odsCustomerOrderDTO.setCreateBy("1111");
        EasyMock.expect(odsCustomerOrderServiceClient.searchOdsCustomerOrders(
                1L,
                25000L,
                odsCustomerOrderDTO)
        ).andReturn(new Pager<OdsCustomerOrderDTO>());
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.exportExcel(odsCustomerOrderDTO,request,response);
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
        EasyMock.expect(odsCustomerOrderServiceClient.customerApprove(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.customerApprove("11");
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
        EasyMock.expect(odsCustomerOrderServiceClient.orderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(odsCustomerOrderServiceClient);
        odsCustomerOrderController.orderCheck(
                "11","11",
                "11","11",
                "11","11",
                "11");
    }
}