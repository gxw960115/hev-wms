package com.haier.wms.controller.consume;

import com.alibaba.fastjson.JSON;
import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeOrderServiceClient;
import com.haier.wms.util.SessionConstants;
import net.sf.json.JSONObject;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/30 10:47
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {SessionConstants.class})
public class OdsConsumeOrderControllerTest {

    private OdsConsumeOrderController odsConsumeOrderController = new OdsConsumeOrderController();
    private OdsConsumeOrderServiceClient odsConsumeOrderServiceClient;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private JSON json;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        json = EasyMock.createMock(JSON.class);
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        odsConsumeOrderServiceClient = EasyMock.createMock(OdsConsumeOrderServiceClient.class);
        odsConsumeOrderController.setOdsConsumeOrderServiceClient(odsConsumeOrderServiceClient);
        JSONObject res=new JSONObject();
        res.put(SessionSecurityConstants.KEY_USER_NAME, "TEST");
        PowerMockito.mockStatic(SessionConstants.class);
        PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void serachOdsConsumeOrders() {
        EasyMock.expect(odsConsumeOrderServiceClient.searchOdsConsumeOrderByPage(
                (Long)EasyMock.anyObject(),
                (Long)EasyMock.anyObject(),
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsConsumeOrderDTO>());
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.serachOdsConsumeOrders(1L,10L,new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteConsumeOrder() {
        EasyMock.expect(odsConsumeOrderServiceClient.deleteConsumeOrder(
                (List<Long>)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.deleteConsumeOrder("111111111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void approveConsumeOrder() {
        EasyMock.expect(odsConsumeOrderServiceClient.approveConsumeOrder(
                (List<Long>)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.approveConsumeOrder("111111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getConsumeSequence() {
        EasyMock.expect(odsConsumeOrderServiceClient.getConsumeSequence()).andReturn("1");
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.getConsumeSequence();

    }

//    @Test
//    public void addConsumeOrder() {
//        EasyMock.expect(json.parseArray(
//                (String)EasyMock.anyObject(),
//                OdsConsumeOrderDTO.class)
//        ).andReturn(new ArrayList<OdsConsumeOrderDTO>()).times(1);
//        EasyMock.expect(odsConsumeOrderServiceClient.saveConsumeOrder(
//                (List<OdsConsumeOrderDTO>)EasyMock.anyObject(),
//                (OdsConsumeOrderDTO)EasyMock.anyObject())
//        ).andReturn("1").times(1);
//        EasyMock.replay(odsConsumeOrderServiceClient);
//        EasyMock.replay(json);
//        odsConsumeOrderController.addConsumeOrder(request,"11111",new OdsConsumeOrderDTO());
//    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchExportAmount() {

        EasyMock.expect(odsConsumeOrderServiceClient.getExportAmount(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.searchExportAmount(new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsConsumeOrder() {
        EasyMock.expect(odsConsumeOrderServiceClient.getOdsConsumeOrderByList(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeOrderDTO>());
        EasyMock.replay(odsConsumeOrderServiceClient);
        odsConsumeOrderController.exportOdsConsumeOrder(request,response,new OdsConsumeOrderDTO());
    }
}