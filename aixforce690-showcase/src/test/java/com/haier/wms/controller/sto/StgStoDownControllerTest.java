package com.haier.wms.controller.sto;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
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

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:26
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,SessionConstants.class})
public class StgStoDownControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private StgStoDownServiceClient stgStoDownServiceClient;
    private StgStoDownController stgStoDownController = new StgStoDownController();
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
        session = EasyMock.createMock(HttpSession.class);
        context = EasyMock.createMock(ServletContext.class);
        stgStoDownServiceClient = EasyMock.createMock(StgStoDownServiceClient.class);
        stgStoDownController.setStgStoDownServiceClient(stgStoDownServiceClient);
        JSONObject jsonObject = new JSONObject();
        PageBean pageBean = new PageBean();
        jsonObject.put("user_duty_type","test");
        jsonObject.put(SessionSecurityConstants.KEY_USER_NAME,"test");
        jsonObject.put(SessionSecurityConstants.KEY_USER_ID,1L);
        PowerMockito.mockStatic(PageUtil.class,UserUtil.class,SessionConstants.class);
        PowerMockito.when(SessionConstants.getSession()).thenReturn(jsonObject);
        PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(pageBean);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void selectStgStoDowns() {
        StgStoDownDTO dto = new StgStoDownDTO();
        EasyMock.expect(stgStoDownServiceClient.searchStgStoDown(
                (Pager<StgStoDownDTO>)EasyMock.anyObject(),
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStoDownDTO>());
        EasyMock.replay(stgStoDownServiceClient);
        stgStoDownController.selectStgStoDowns(request,1L,10L,dto);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchList() {
        StgStoDownDTO dto = new StgStoDownDTO();
        EasyMock.expect(stgStoDownServiceClient.getStgStoDowns(
                dto)
        ).andReturn(new ArrayList<StgStoDownDTO>());
        EasyMock.replay(stgStoDownServiceClient);
        try {
            stgStoDownController.searchList(dto);
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
    public void searchStgStoDownAmount() {
        EasyMock.expect(stgStoDownServiceClient.getExportAmount(
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(stgStoDownServiceClient);
        stgStoDownController.searchStgStoDownAmount(request,response,new StgStoDownDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportStgStoDown() {
        EasyMock.expect(stgStoDownServiceClient.getStgStoDowns(
                (StgStoDownDTO)EasyMock.anyObject()
        )).andReturn(new ArrayList<StgStoDownDTO>());
        EasyMock.replay(stgStoDownServiceClient);
        try {
            stgStoDownController.exportStgStoDown(request,response,new StgStoDownDTO());
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
    public void downloadSto() {
        EasyMock.expect(stgStoDownServiceClient.downloadSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO());
        EasyMock.replay(stgStoDownServiceClient);
        stgStoDownController.downloadSto(request,response,"11","11","11");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void postOrder() {
        EasyMock.expect(stgStoDownServiceClient.postSto(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(stgStoDownServiceClient);
        stgStoDownController.postOrder("11","11","11","11");
    }
}