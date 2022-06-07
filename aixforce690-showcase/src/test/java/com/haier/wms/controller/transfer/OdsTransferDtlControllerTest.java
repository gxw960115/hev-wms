package com.haier.wms.controller.transfer;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferDtlServiceClient;
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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:27
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,SessionConstants.class})
public class OdsTransferDtlControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private OdsTransferDtlServiceClient odsTransferDtlServiceClient;
    private OdsTransferDtlController odsTransferDtlController = new OdsTransferDtlController();

    @Before
    public void init(){

        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        session = EasyMock.createMock(HttpSession.class);
        context = EasyMock.createMock(ServletContext.class);
        odsTransferDtlServiceClient = EasyMock.createMock(OdsTransferDtlServiceClient.class);
        odsTransferDtlController.setOdsTransferDtlServiceClient(odsTransferDtlServiceClient);
        BaseUser baseUser = new BaseUser();
        baseUser.setName("111");
        PowerMockito.mockStatic(PageUtil.class,UserUtil.class,SessionConstants.class);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
    }

    @Test
    public void searchTransferDtl() {
        OdsTransferDtlDTO odsStoCustDTO = new OdsTransferDtlDTO();
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsTransferDtlServiceClient.searchOdsTransferDtls(
                1L,10L,odsStoCustDTO)
        ).andReturn(new Pager<OdsTransferDtlDTO>());
        EasyMock.replay(request);
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.searchTransferDtl(request,odsStoCustDTO);
    }

    @Test
    public void searchTransDtlsAmount() {
        EasyMock.expect(odsTransferDtlServiceClient.searchOdsTransferDtlsCount(
                (OdsTransferDtlDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.searchTransDtlsAmount(new OdsTransferDtlDTO());
    }

    @Test
    public void exportExcel() {
        OdsTransferDtlDTO odsTransferDtlDTO = new OdsTransferDtlDTO();
        EasyMock.expect(odsTransferDtlServiceClient.searchOdsTransferDtls(
                1L,25000L,odsTransferDtlDTO
        )).andReturn(new Pager<OdsTransferDtlDTO>());
        EasyMock.replay(odsTransferDtlServiceClient);
        try {
            odsTransferDtlController.exportExcel(odsTransferDtlDTO,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void orderDelete() {
        try {
            EasyMock.expect(odsTransferDtlServiceClient.orderDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderDeleteOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.orderDelete("111","111",
                "111","111",
                "111","111","11");
    }

    @Test
    public void ordersDelete() {
        try {
            EasyMock.expect(odsTransferDtlServiceClient.orderDelete(
                    (OrderDeleteInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderDeleteOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.ordersDelete("111","111",
                "111","111",
                "111","111","11");
    }

    @Test
    public void orderScan() {
        try {
            EasyMock.expect(odsTransferDtlServiceClient.orderScan(
                    (OrderUploadInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderUploadOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.orderScan("111","111",
                "111","111",
                "111","","11",
                "11","11","11");
    }

    @Test
    public void orderOgp() {
        try {
            EasyMock.expect(odsTransferDtlServiceClient.orderOgp(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.orderOgp("111","111",
                new OrderIgpInDTO());
    }

    @Test
    public void barcodeList() {
        EasyMock.expect(odsTransferDtlServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.barcodeList("111","111",
                "111","111",
                "111");
    }

    @Test
    public void orderPosting() {
        try {
            EasyMock.expect(odsTransferDtlServiceClient.orderPosting(
                    (OrderIgpInDTO)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new OrderIgpOutDTO());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        EasyMock.replay(odsTransferDtlServiceClient);
        odsTransferDtlController.orderPosting("111",new OrderIgpInDTO(),
                "111","111",
                "111");
    }
}