package com.haier.wms.controller.sto;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoCustDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.service.OdsStoGigrInfoServiceClient;
import com.haier.openplatform.wms.sto.service.StgStoDownServiceClient;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:25
 * @Description:
 */
public class OdsStoGigrInfoControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private OdsStoGigrInfoServiceClient odsStoGigrInfoServiceClient;
    private StgStoDownServiceClient stgStoDownServiceClient;
    private StgStodnDownServiceClient stgStodnDownServiceClient;

    private OdsStoGigrInfoController odsStoGigrInfoController = new OdsStoGigrInfoController();
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
        odsStoGigrInfoServiceClient = EasyMock.createMock(OdsStoGigrInfoServiceClient.class);
        stgStoDownServiceClient = EasyMock.createMock(StgStoDownServiceClient.class);
        stgStodnDownServiceClient = EasyMock.createMock(StgStodnDownServiceClient.class);
        odsStoGigrInfoController.setOdsStoGigrInfoServiceClient(odsStoGigrInfoServiceClient);
        odsStoGigrInfoController.setStgStoDownServiceClient(stgStoDownServiceClient);
        odsStoGigrInfoController.setStgStodnDownServiceClient(stgStodnDownServiceClient);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getListByPage() {
        OdsStoGigrInfoDTO dto = new OdsStoGigrInfoDTO();
        EasyMock.expect(odsStoGigrInfoServiceClient.searchOdsStoGigrInfoByPage(
                1L,
                10L,
                dto)
        ).andReturn(new Pager<OdsStoGigrInfoDTO>());
        EasyMock.replay(odsStoGigrInfoServiceClient);
        odsStoGigrInfoController.getListByPage(dto,1L,10L);
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
        EasyMock.expect(odsStoGigrInfoServiceClient.getExportOdsStoGigrInfoAmount(
                (OdsStoGigrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsStoGigrInfoServiceClient);
        odsStoGigrInfoController.searchAmount(new OdsStoGigrInfoDTO());
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
        EasyMock.expect(odsStoGigrInfoServiceClient.getStoGigrInfoListByParm(
                (OdsStoGigrInfoDTO)EasyMock.anyObject()
        )).andReturn(new ArrayList<OdsStoGigrInfoDTO>());
        EasyMock.replay(odsStoGigrInfoServiceClient);
        odsStoGigrInfoController.exportExcel(request,response,new OdsStoGigrInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void printOgp() {
        EasyMock.expect(request.getSession()).andReturn(session);
        EasyMock.expect(session.getServletContext()).andReturn(context);
        EasyMock.expect(context.getRealPath("/")).andReturn("/test");
        EasyMock.replay(request);
        EasyMock.replay(session);
        EasyMock.replay(context);
        odsStoGigrInfoController.printOgp(request,response,
                "[{\"orderNo\":\"1111\"}]");
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void printDn() {
        EasyMock.expect(request.getSession()).andReturn(session);
        EasyMock.expect(session.getServletContext()).andReturn(context);
        EasyMock.expect(context.getRealPath("/")).andReturn("/test");
        EasyMock.replay(request);
        EasyMock.replay(session);
        EasyMock.replay(context);
        odsStoGigrInfoController.printDn(request,response,
                "[{\"orderNo\":\"1111\"}]");
    }
}