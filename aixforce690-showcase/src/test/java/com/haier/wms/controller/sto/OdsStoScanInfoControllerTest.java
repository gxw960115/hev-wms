package com.haier.wms.controller.sto;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoScanInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
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

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:26
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,UserUtil.class})
public class OdsStoScanInfoControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private OdsStoScanInfoServiceClient odsStoScanInfoServiceClient;
    private OdsStoScanInfoController odsStoScanInfoController = new OdsStoScanInfoController();
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
        odsStoScanInfoServiceClient = EasyMock.createMock(OdsStoScanInfoServiceClient.class);
        odsStoScanInfoController.setOdsStoScanInfoServiceClient(odsStoScanInfoServiceClient);
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
    public void searchOdsStoScanInfo() {
        OdsStoScanInfoDTO dto = new OdsStoScanInfoDTO();
        EasyMock.expect(odsStoScanInfoServiceClient.searchOdsStoScanInfoByPage(
                1L,
                10L,
                dto)
        ).andReturn(new Pager<OdsStoScanInfoDTO>());
        EasyMock.replay(odsStoScanInfoServiceClient);
        odsStoScanInfoController.searchOdsStoScanInfo(1L,10L,dto);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsStoScanInfoAmount() {
        EasyMock.expect(odsStoScanInfoServiceClient.getExportAmount(
                (OdsStoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsStoScanInfoServiceClient);
        odsStoScanInfoController.searchOdsStoScanInfoAmount(new OdsStoScanInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsStoScanInfo() {
        EasyMock.expect(odsStoScanInfoServiceClient.getOdsStoScanInfos(
                (OdsStoScanInfoDTO)EasyMock.anyObject()
        )).andReturn(new ArrayList<OdsStoScanInfoDTO>());
        EasyMock.replay(odsStoScanInfoServiceClient);
        try {
            odsStoScanInfoController.exportOdsStoScanInfo(request,response,new OdsStoScanInfoDTO());
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
    public void printSoDetail() {
        EasyMock.expect(request.getSession()).andReturn(session);
        EasyMock.expect(session.getServletContext()).andReturn(context);
        EasyMock.expect(context.getRealPath("/")).andReturn("/test");
        EasyMock.replay(request);
        EasyMock.replay(session);
        EasyMock.replay(context);
        odsStoScanInfoController.printSoDetail(request,response,
                "111","111");
    }
}