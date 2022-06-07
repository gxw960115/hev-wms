package com.haier.wms.controller.so;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
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

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:25
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class StgSoDownControllerTest {

    private StgDnDownServiceClient stgDnDownService;
    private StgSoDownController stgSoDownController = new StgSoDownController();
    private JSONObject jsonObject;
    private HttpServletRequest request;
    private HttpServletResponse response;
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
        stgDnDownService = EasyMock.createMock(StgDnDownServiceClient.class);
        stgSoDownController.setStgDnDownService(stgDnDownService);
        jsonObject = new JSONObject();
        jsonObject.put("_user_name","test");
        jsonObject.put("user_duty_type","test");
        jsonObject.put(SessionSecurityConstants.KEY_USER_ID,Long.valueOf(1));
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
    public void selectDnDowns() {
        EasyMock.expect(stgDnDownService.searchStgDnDown(
                (Pager<StgDnDownDTO>)EasyMock.anyObject(),(StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgDnDownDTO>());
        EasyMock.replay(stgDnDownService);
        stgSoDownController.selectDnDowns(request,1L,10L,new StgDnDownDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchStgDnDownAmount() {
        EasyMock.expect(stgDnDownService.getExportAmount(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(25001L);
        EasyMock.replay(stgDnDownService);
        stgSoDownController.searchStgDnDownAmount(request,response,new StgDnDownDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportStgDnDown() {
        EasyMock.expect(stgDnDownService.getStgDnDownsByParam(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgDnDownDTO>());
        EasyMock.replay(stgDnDownService);
        stgSoDownController.exportStgDnDown(request,response,new StgDnDownDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void downloadSo() {
        try {
            EasyMock.expect(stgDnDownService.downStgDnDown(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new InterfaceOutDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EasyMock.replay(stgDnDownService);
        try {
            stgSoDownController.downloadSo(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject());
        } catch (Exception e) {
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
    public void postDn() {
        try {
            EasyMock.expect(stgDnDownService.postDn(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new InterfaceOutDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EasyMock.replay(stgDnDownService);
        try {
            stgSoDownController.postDn(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject());
        } catch (Exception e) {
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
    public void postGiftDn() {
        try {
            EasyMock.expect(stgDnDownService.postGiftDn(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject())
            ).andReturn(new InterfaceOutDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EasyMock.replay(stgDnDownService);
        try {
            stgSoDownController.postGiftDn(
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject(),
                    (String)EasyMock.anyObject());
        } catch (Exception e) {
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
    public void inoutWarehouse() {
        stgSoDownController.inoutWarehouse(request,response,"11","111","111");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftInoutWarehouse() {
        stgSoDownController.giftInoutWarehouse(request,response,"11","11","111");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchDnReverse() {
        EasyMock.expect(stgDnDownService.searchStgDnReverse(
                (Pager<StgDnDownDTO>)EasyMock.anyObject(),(StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgDnDownDTO>());
        EasyMock.replay(stgDnDownService);
        stgSoDownController.searchDnReverse(request,1L,10L,new StgDnDownDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void dnReverse() {
        EasyMock.expect(stgDnDownService.dnReverse(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(stgDnDownService);
        stgSoDownController.dnReverse(request,1L,10L,new StgDnDownDTO(),new OrderIgpInDTO());
    }
}