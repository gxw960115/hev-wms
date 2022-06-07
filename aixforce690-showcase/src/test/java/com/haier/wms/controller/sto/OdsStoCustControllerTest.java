package com.haier.wms.controller.sto;

import com.haier.openplatform.hac.dto.AgentPager;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoCustScanInfoServiceClient;
import com.haier.openplatform.wms.sto.service.OdsStoCustServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.codehaus.jackson.map.Serializers;
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
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:25
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class})
public class OdsStoCustControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private OdsStoCustServiceClient odsStoCustServiceClient;
    private OdsStoCustScanInfoServiceClient odsStoCustScanInfoServiceClient;
    private OdsStoCustController odsStoCustController = new OdsStoCustController();
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        odsStoCustServiceClient = EasyMock.createMock(OdsStoCustServiceClient.class);
        odsStoCustScanInfoServiceClient = EasyMock.createMock(OdsStoCustScanInfoServiceClient.class);
        odsStoCustController.setOdsStoCustServiceClient(odsStoCustServiceClient);
        odsStoCustController.setOdsStoCustScanInfoServiceClient(odsStoCustScanInfoServiceClient);
        PageBean pageBean = new PageBean();
        BaseUser baseUser = new BaseUser();
        baseUser.setName("111");
        PowerMockito.mockStatic(PageUtil.class,UserUtil.class);
        PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(pageBean);
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
    public void searchStoCust() {
        OdsStoCustDTO odsStoCustDTO = new OdsStoCustDTO();
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsStoCustServiceClient.searchOdsStoCusts(
                1L,10L,odsStoCustDTO)
        ).andReturn(new Pager<OdsStoCustDTO>());
        EasyMock.replay(request);
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.searchStoCust(request,odsStoCustDTO);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void addStoCust() {
        EasyMock.expect(odsStoCustServiceClient.addStoCustInfo(
                (OdsStoCustDTO)EasyMock.anyObject(),(List<OdsStoCustDTO>)EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.addStoCust(new OdsStoCustDTO(),"[{\"stoNo\":\"111\"}]");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getStoCustNo() {
        EasyMock.expect(odsStoCustServiceClient.getStoCustNo()
        ).andReturn("11");
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.getStoCustNo();
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteStoCustByCusNo() {
        OdsStoCustDTO odsStoCustDTO = new OdsStoCustDTO();
        odsStoCustDTO.setCreateBy("111");
        EasyMock.expect(odsStoCustServiceClient.deleteStoCustByNo((String)EasyMock.anyObject())
        ).andReturn("success");
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.deleteStoCustByCusNo(odsStoCustDTO);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteStoCustByIds() {
        EasyMock.expect(odsStoCustServiceClient.deleteStoCustByIds((List<Long> )EasyMock.anyObject())
        ).andReturn("success");
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.deleteStoCustByIds("11111111");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchStoCustsAmount() {
        EasyMock.expect(odsStoCustServiceClient.searchOdsStoCustsCount(
                (OdsStoCustDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.searchStoCustsAmount(request,response,new OdsStoCustDTO());
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
        OdsStoCustDTO odsStoCustDTO = new OdsStoCustDTO();
        EasyMock.expect(odsStoCustServiceClient.searchOdsStoCusts(
                1L,25000L,odsStoCustDTO)
        ).andReturn(new Pager<OdsStoCustDTO>());
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.exportExcel(odsStoCustDTO,request,response);
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
        EasyMock.expect(odsStoCustServiceClient.stoApprove(
                "1","111")
        ).andReturn("1");
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.customerApprove("1");
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
        OdsStoCustScanInfoDTO odsStoCustDTO = new OdsStoCustScanInfoDTO();
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsStoCustScanInfoServiceClient.searchOdsStoCustScanInfoByPage(
                1L,10L,odsStoCustDTO)
        ).andReturn(new Pager<OdsStoCustScanInfoDTO>());
        EasyMock.replay(request);
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.searchCustomerScanInfo(request,odsStoCustDTO);
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
        EasyMock.expect(odsStoCustScanInfoServiceClient.getExportAmount(
                (OdsStoCustScanInfoDTO)EasyMock.anyObject()
        )).andReturn(1L);
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.searchCustomerScanInfosAmount(request,response,new OdsStoCustScanInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportExcel1() {
        OdsStoCustScanInfoDTO odsStoCustScanInfoDTO = new OdsStoCustScanInfoDTO();
        EasyMock.expect(odsStoCustScanInfoServiceClient.searchOdsStoCustScanInfoByPage(
                1L,25000L,odsStoCustScanInfoDTO)
        ).andReturn(new Pager<OdsStoCustScanInfoDTO>());
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.exportExcel(odsStoCustScanInfoDTO,request,response);
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
        EasyMock.expect(odsStoCustServiceClient.orderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject()
        )).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.orderCheck("111","111",
                "111","11",
                "111","11",
                "11");
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
            EasyMock.expect(odsStoCustScanInfoServiceClient.orderDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject()
            )).andReturn(new OrderDeleteOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.orderDelete("111","111",
                "111","11",
                "111","11",
                "11");
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
            EasyMock.expect(odsStoCustScanInfoServiceClient.ordersDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject()
            )).andReturn(new OrderDeleteOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.ordersDelete("111","111",
                "111","11",
                "111","11",
                "11");
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

        EasyMock.expect(odsStoCustScanInfoServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject()
        )).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.barcodeList("111","111",
                "111","11",
                "111");
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
            EasyMock.expect(odsStoCustScanInfoServiceClient.orderScan(
                    (OrderUploadInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject()
            )).andReturn(new OrderUploadOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsStoCustScanInfoServiceClient);
        odsStoCustController.orderScan("111","111",
                "111","11",
                "111","111",
                "111","111",
                "111","111");
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
            EasyMock.expect(odsStoCustServiceClient.orderOgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject()
            )).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsStoCustServiceClient);
        odsStoCustController.orderOgp("111","111",
                "111","11",
                new OrderIgpInDTO());
    }
}