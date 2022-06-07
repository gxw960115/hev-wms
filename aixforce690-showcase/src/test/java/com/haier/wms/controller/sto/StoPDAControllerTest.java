package com.haier.wms.controller.sto;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.sto.service.StoPDAServiceClient;
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

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:26
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,SessionConstants.class})
public class StoPDAControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private StoPDAServiceClient stoPDAServiceClient;
    private StoPDAController stoPDAController = new StoPDAController();
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
        stoPDAServiceClient = EasyMock.createMock(StoPDAServiceClient.class);
        stoPDAController.setStoPDAServiceClient(stoPDAServiceClient);
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
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderCheck() {

        EasyMock.expect(stoPDAServiceClient.stoOrderCheck(
                (OrderCheckInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.orderCheck("111","111",
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
    public void orderDownload() {
        EasyMock.expect(stoPDAServiceClient.stoOrderDownload(
                (OrderLoadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderLoadOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.orderDownload("111","111",
                "111","111",
                "111","111","11");
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
        EasyMock.expect(stoPDAServiceClient.stoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.orderDelete("111","111",
                "111","111",
                "111","111","11");
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
        EasyMock.expect(stoPDAServiceClient.stoOrdersDelete(
                (OrderDeleteInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.ordersDelete("111","111",
                "111","111",
                "111","111","11");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderIOgp() {
        EasyMock.expect(stoPDAServiceClient.stoOrderOgp(
                (OrderIgpInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.poOrderIOgp("111","111",
                "111","111",
                "111",new OrderIgpInDTO());
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
        EasyMock.expect(stoPDAServiceClient.barcodeList(
                (WmsOrderDelListInDTO)EasyMock.anyObject())
        ).andReturn(new WmsOrderDelListOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.barcodeList("111","111",
                "111","111",
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
        EasyMock.expect(stoPDAServiceClient.stoOrderUpload(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.orderScan("111","111",
                "111","111",
                "111","","11",
                "11","11","11");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void stodnScan() {
        EasyMock.expect(stoPDAServiceClient.stodnOrderUpload(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        EasyMock.replay(stoPDAServiceClient);
        stoPDAController.stodnScan("111","111",
                "111","111",
                "111","","11",
                "11","11","11");
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
        stoPDAController.inoutWarehouse(request,response,
                "111","111","111");
    }

    @Test
    public void stodnScanDelete() {
        stoPDAController.stodnScanDelete("1","2","2",
                "111","111","111","23");
    }

    @Test
    public void stodnBarcodeList() {
        stoPDAController.stodnBarcodeList("1","2","2",
                "111","111");
    }

    @Test
    public void stodnOutScan() {
        stoPDAController.stodnOutScan("1","2","2",
                "111","111","23","23","213","24","23");
    }
}