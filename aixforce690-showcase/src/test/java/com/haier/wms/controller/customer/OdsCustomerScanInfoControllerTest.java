package com.haier.wms.controller.customer;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerOrderDTO;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient;
import com.haier.openplatform.wms.remoting.dto.*;
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

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/30 15:20
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class,UserUtil.class})
public class OdsCustomerScanInfoControllerTest {

    private OdsCustomerScanInfoController odsCustomerScanInfoController = new OdsCustomerScanInfoController();
    private OdsCustomerScanInfoServiceClient odsCustomerScanInfoServiceClient;
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
        odsCustomerScanInfoServiceClient = EasyMock.createMock(OdsCustomerScanInfoServiceClient.class);
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        odsCustomerScanInfoController.setOdsCustomerScanInfoServiceClient(odsCustomerScanInfoServiceClient);
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
    public void searchCustomerScanInfo() {
        OdsCustomerScanInfoDTO odsCustomerOrderDTO = new OdsCustomerScanInfoDTO();
        odsCustomerOrderDTO.setBarcode("11111111111111");
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfos(
                1L,
                10L,
                odsCustomerOrderDTO)
        ).andReturn(new Pager<OdsCustomerScanInfoDTO>()).times(1);
        EasyMock.replay(request);
        EasyMock.replay(odsCustomerScanInfoServiceClient);
        odsCustomerScanInfoController.searchCustomerScanInfo(request,odsCustomerOrderDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchCustomerScanInfosAmount() {
        EasyMock.expect(odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfosCount(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsCustomerScanInfoServiceClient);
        odsCustomerScanInfoController.searchCustomerScanInfosAmount(request,response,new OdsCustomerScanInfoDTO());

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
        OdsCustomerScanInfoDTO odsCustomerScanInfoDTO = new OdsCustomerScanInfoDTO();
        odsCustomerScanInfoDTO.setBarcode("11");
        EasyMock.expect(odsCustomerScanInfoServiceClient.searchOdsCustomerScanInfos(
                1L,25000L,odsCustomerScanInfoDTO)
        ).andReturn(new Pager<OdsCustomerScanInfoDTO>());
        odsCustomerScanInfoController.exportExcel(odsCustomerScanInfoDTO,request,response);

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDelete() {
        try {
            EasyMock.expect(odsCustomerScanInfoServiceClient.orderDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderDeleteOutDTO());
            EasyMock.replay(odsCustomerScanInfoServiceClient);
            odsCustomerScanInfoController.orderDelete("111",
                    "111","111",
                    "11","111",
                    "111","111");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void ordersDelete() {
        try {
            EasyMock.expect(odsCustomerScanInfoServiceClient.ordersDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderDeleteOutDTO());
            EasyMock.replay(odsCustomerScanInfoServiceClient);
            odsCustomerScanInfoController.ordersDelete("111",
                    "111","111",
                    "11","111",
                    "111","111");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderScan() {
        try {
            EasyMock.expect(odsCustomerScanInfoServiceClient.orderScan(
                    (OrderUploadInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderUploadOutDTO());
            EasyMock.replay(odsCustomerScanInfoServiceClient);
            odsCustomerScanInfoController.orderScan("11","11",
                    "11","11",
                    "11","11",
                    "11","11",
                    "11","11");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderOgp() {
        try {
            EasyMock.expect(odsCustomerScanInfoServiceClient.orderOgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
            EasyMock.replay(odsCustomerScanInfoServiceClient);
            odsCustomerScanInfoController.orderOgp("11",
                    "11", "11",
                    "11",new OrderIgpInDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDelivery() {
        try {
            EasyMock.expect(odsCustomerScanInfoServiceClient.orderDelivery(
                    (OrderIgpInDTO)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
            EasyMock.replay(odsCustomerScanInfoServiceClient);
            odsCustomerScanInfoController.orderDelivery("111",new OrderIgpInDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void barcodeList() {
        EasyMock.expect(odsCustomerScanInfoServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(odsCustomerScanInfoServiceClient);
        odsCustomerScanInfoController.barcodeList("11","11","11","11","111");
    }
}