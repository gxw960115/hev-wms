package com.haier.wms.controller.scrap;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapOrderServiceClient;
import com.haier.wms.util.PageUtil;
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
 * @Date: 2019/5/16 15:01
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsScrapOrderControllerTest {

    private OdsScrapOrderServiceClient odsScrapOrderServiceClient;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private OdsScrapOrderController odsScrapOrderController = new OdsScrapOrderController();
    private JSONObject jsonObject;

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
        odsScrapOrderServiceClient = EasyMock.createMock(OdsScrapOrderServiceClient.class);
        odsScrapOrderController.setOdsScrapOrderServiceClient(odsScrapOrderServiceClient);
        jsonObject = new JSONObject();
        jsonObject.put("_user_name","test");
        PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
        PowerMockito.when(SessionConstants.getSession()).thenReturn(jsonObject);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void serachOdsScrapOrders() {
        OdsScrapOrderDTO dto = new OdsScrapOrderDTO();
        EasyMock.expect(odsScrapOrderServiceClient.searchOdsScrapOrderByPage(
                1L,10L,dto)
        ).andReturn(new Pager<OdsScrapOrderDTO>());
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.serachOdsScrapOrders(1L,10L,dto);

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceClient.deleteScrapOrder(
                (List<Long>)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.deleteScrapOrder("1111,1111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void approveScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceClient.approveScrapOrder(
                (List<Long>)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.approveScrapOrder("11111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getScrapSequence() {
        odsScrapOrderController.getScrapSequence();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void addScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceClient.saveScrapOrder(
                (List<OdsScrapOrderDTO>)EasyMock.anyObject(),
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn("11");
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.addScrapOrder(request,"[{\"scrapNo\":\"111\"}]",new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchExportAmount() {
        EasyMock.expect(odsScrapOrderServiceClient.getExportAmount(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(25001L);
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.searchExportAmount(new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceClient.getOdsScrapOrderByList(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapOrderDTO>());
        EasyMock.replay(odsScrapOrderServiceClient);
        odsScrapOrderController.exportOdsScrapOrder(request,response,new OdsScrapOrderDTO());
    }
}