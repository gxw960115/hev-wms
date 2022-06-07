package com.haier.wms.controller.sto;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:26
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class,SessionConstants.class})
public class StgStodnDownControllerTest {

    private StgStodnDownServiceClient stgStodnDownServiceClient;
    private HttpServletResponse response;
    private HttpServletRequest request;
    private StgStodnDownController stgStodnDownController = new StgStodnDownController();
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
        stgStodnDownServiceClient = EasyMock.createMock(StgStodnDownServiceClient.class);
        stgStodnDownController.setStgStodnDownServiceClient(stgStodnDownServiceClient);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SessionSecurityConstants.KEY_USER_NAME,"test");
        PowerMockito.mockStatic(PageUtil.class,UserUtil.class,SessionConstants.class);
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
    public void getlist() {
        StgStodnDownDTO dto = new StgStodnDownDTO();
        EasyMock.expect(stgStodnDownServiceClient.searchStgStodnDowns(
                1L,
                10L,
                dto)
        ).andReturn(new Pager<StgStodnDownDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        stgStodnDownController.getlist(dto,1L,10L);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchAmount() {
        EasyMock.expect(stgStodnDownServiceClient.getExportAmount(
                (StgStodnDownDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(stgStodnDownServiceClient);
        stgStodnDownController.searchAmount(new StgStodnDownDTO());
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
        EasyMock.expect(stgStodnDownServiceClient.getStgStodnDownListByParm(
                (StgStodnDownDTO)EasyMock.anyObject()
        )).andReturn(new ArrayList<StgStodnDownDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        try {
            stgStodnDownController.exportExcel(request,response,new StgStodnDownDTO());
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
    public void downloadStodn() {
        EasyMock.expect(stgStodnDownServiceClient.downloadStodn(
                (String)EasyMock.anyObject(),(String)EasyMock.anyObject(),(String)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO());
        EasyMock.replay(stgStodnDownServiceClient);
        stgStodnDownController.downloadStodn(request,response,"1111","111");
    }

    @Test
    public void postOrder() {
        EasyMock.expect(stgStodnDownServiceClient.postStodn(
                (String)EasyMock.anyObject(),(String)EasyMock.anyObject(),(String)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(stgStodnDownServiceClient);
        stgStodnDownController.postOrder("1111","111");
    }

    @Test
    public void stodnGiGr() {
        EasyMock.expect(stgStodnDownServiceClient.stodnGiGr((StgStoDnDTO)EasyMock.anyObject())
        ).andReturn(new OrderIgpOutDTO());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.stodnGiGr(stgStoDnDTO);
    }

    @Test
    public void downloadStodnFromTMS() {
        EasyMock.expect(stgStodnDownServiceClient.downloadStodnFromTMS((StgStoDnDTO)EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.downloadStodnFromTMS(request,response,stgStoDnDTO);
    }

    @Test
    public void selectStgStoDn() {
        EasyMock.expect(stgStodnDownServiceClient.searchStgStoDn((Pager<StgStoDnDTO>)EasyMock.anyObject(), (StgStoDnDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStoDnDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.selectStgStoDn(request,1L,2L,stgStoDnDTO);
    }

    @Test
    public void selectStoDnScanDetail() {
        EasyMock.expect(stgStodnDownServiceClient.searchScanDetail((Pager<StgStoDnDTO>)EasyMock.anyObject(), (StgStoDnDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStoDnDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.selectStoDnScanDetail(request,1L,2L,stgStoDnDTO);
    }

    @Test
    public void selectStoDnPost() {
        EasyMock.expect(stgStodnDownServiceClient.searchPostDetail((Pager<StgStoDnDTO>)EasyMock.anyObject(), (StgStoDnDTO)EasyMock.anyObject())
        ).andReturn(new Pager<StgStoDnDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.selectStoDnPost(request,1L,2L,stgStoDnDTO);
    }

    @Test
    public void checkStoDnNo() {
        EasyMock.expect(stgStodnDownServiceClient.checkStoDnNo((String) EasyMock.anyObject())
        ).andReturn(new InterfaceOutDTO());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
        stgStoDnDTO.setStodnNo("111");
        stgStodnDownController.checkStoDnNo("1","2","3","4","5","6");
    }

    @Test
    public void searchStoDnFromFactory() {
        EasyMock.expect(stgStodnDownServiceClient.searchStgStoDnDownsFromFactory((Pager<StgStodnDownDTO>) EasyMock.anyObject(),(StgStodnDownDTO) EasyMock.anyObject())
        ).andReturn(new Pager<StgStodnDownDTO>());
        EasyMock.replay(stgStodnDownServiceClient);
        StgStodnDownDTO stoDnDown = new StgStodnDownDTO();
        stoDnDown.setStodnNo("111");
        stgStodnDownController.searchStoDnFromFactory(stoDnDown,1L,2L);
    }
}