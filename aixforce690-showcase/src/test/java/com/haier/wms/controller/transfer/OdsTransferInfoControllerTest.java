package com.haier.wms.controller.transfer;

import com.haier.openplatform.hac.dto.AgentPager;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
import com.haier.openplatform.wms.transfer.service.OdsTransferInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import net.sf.json.JSONObject;
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

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:27
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,SessionConstants.class})
public class OdsTransferInfoControllerTest {

    private OdsTransferInfoServiceClient odsTransferInfoServiceClient;
    private OdsTransferInfoController odsTransferInfoController = new OdsTransferInfoController();
    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;

    @Before
    public void init(){
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        session = EasyMock.createMock(HttpSession.class);
        context = EasyMock.createMock(ServletContext.class);
        odsTransferInfoServiceClient = EasyMock.createMock(OdsTransferInfoServiceClient.class);
        odsTransferInfoController.setOdsTransferInfoServiceClient(odsTransferInfoServiceClient);
        JSONObject jsonObject = new JSONObject();
        PageBean pageBean = new PageBean();
        BaseUser baseUser = new BaseUser();
        baseUser.setName("111");
        jsonObject.put("user_duty_type","test");
        jsonObject.put(SessionSecurityConstants.KEY_USER_NAME,"test");
        jsonObject.put(SessionSecurityConstants.KEY_USER_ID,1L);
        PowerMockito.mockStatic(PageUtil.class,UserUtil.class,SessionConstants.class);
        PowerMockito.when(SessionConstants.getSession()).thenReturn(jsonObject);
        PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(pageBean);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
    }

    @Test
    public void searchTransferOrder() {
        OdsTransferInfoDTO odsStoCustDTO = new OdsTransferInfoDTO();
        EasyMock.expect(request.getParameter("page")).andReturn("1");
        EasyMock.expect(request.getParameter("rows")).andReturn("10");
        EasyMock.expect(odsTransferInfoServiceClient.searchOdsTransferInfos(
                1L,10L,odsStoCustDTO)
        ).andReturn(new Pager<OdsTransferInfoDTO>());
        EasyMock.replay(request);
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.searchTransferOrder(request,odsStoCustDTO);
    }

    @Test
    public void getTransferOrderNo() {
        EasyMock.expect(odsTransferInfoServiceClient.getTransferOrderNo()).andReturn("11");
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.getTransferOrderNo();
    }

    @Test
    public void addTransferInfo() {
        EasyMock.expect(odsTransferInfoServiceClient.addTranferInfo(
                (OdsTransferInfoDTO)EasyMock.anyObject(),
                (List<OdsTransferInfoDTO>)EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.addTransferInfo(new OdsTransferInfoDTO(),"[{\"transNo\":\"111\"}]");
    }

    @Test
    public void deleteTransferInfoByTransNo() {
        OdsTransferInfoDTO odsTransferInfoDTO = new OdsTransferInfoDTO();
        odsTransferInfoDTO.setCreateBy("111");
        EasyMock.expect(odsTransferInfoServiceClient.deleteTransferInfoByTransNo(
                (String)EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.deleteTransferInfoByTransNo(odsTransferInfoDTO);
    }

    @Test
    public void deleteTransferInfoByIds() {
        EasyMock.expect(odsTransferInfoServiceClient.deleteTransferInfoByIds(
                (List<Long>) EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.deleteTransferInfoByIds("1111");
    }

    @Test
    public void transferApprove() {
        EasyMock.expect(odsTransferInfoServiceClient.transferApprove(
                "111",
                "111")
        ).andReturn("11");
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.transferApprove("111");
    }

    @Test
    public void searchTransferInfosAmount() {
        EasyMock.expect(odsTransferInfoServiceClient.searchOdsTransferInfosCount(
                (OdsTransferInfoDTO) EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.searchTransferInfosAmount(request,response,new OdsTransferInfoDTO());
    }

    @Test
    public void exportExcel() {
        OdsTransferInfoDTO odsTransferInfoDTO = new OdsTransferInfoDTO();
        EasyMock.expect(odsTransferInfoServiceClient.searchOdsTransferInfos(
                1L,25000L,odsTransferInfoDTO)
        ).andReturn(new AgentPager<OdsTransferInfoDTO>());
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.exportExcel(odsTransferInfoDTO,request,response);
    }

    @Test
    public void orderCheck() {
        EasyMock.expect(odsTransferInfoServiceClient.orderCheck(
                (OrderCheckInDTO) EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(odsTransferInfoServiceClient);
        odsTransferInfoController.orderCheck("11",
                "","11","11","11","11","111");
    }
}