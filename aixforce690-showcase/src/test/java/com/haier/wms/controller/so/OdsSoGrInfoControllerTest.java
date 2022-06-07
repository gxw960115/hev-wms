package com.haier.wms.controller.so;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.haier.openplatform.wms.so.service.OdsSoGrInfoServiceClient;
import com.haier.openplatform.wms.so.service.StgDnDownServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 16:23
 * @Description:
 */
public class OdsSoGrInfoControllerTest {

    private OdsSoGrInfoServiceClient odsSoGrInfoServiceClient;
    private StgDnDownServiceClient stgDnDownServiceClient;
    private CdLocInfoServiceClient cdLocInfoServiceClient;
    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private OdsSoGrInfoController odsSoGrInfoController = new OdsSoGrInfoController();
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
        odsSoGrInfoServiceClient = EasyMock.createMock(OdsSoGrInfoServiceClient.class);
        stgDnDownServiceClient = EasyMock.createMock(StgDnDownServiceClient.class);
        cdLocInfoServiceClient = EasyMock.createMock(CdLocInfoServiceClient.class);
        odsSoGrInfoController.setOdsSoGrInfoServiceClient(odsSoGrInfoServiceClient);
        odsSoGrInfoController.setStgDnDownServiceClient(stgDnDownServiceClient);
        odsSoGrInfoController.setCdLocInfoServiceClient(cdLocInfoServiceClient);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsSoGrInfo() {
        OdsSoGrInfoDTO dto = new OdsSoGrInfoDTO();
        EasyMock.expect(odsSoGrInfoServiceClient.searchOdsSoGrInfoListByPage(
                1L,10L,dto)
        ).andReturn(new Pager<OdsSoGrInfoDTO>());
        EasyMock.replay(odsSoGrInfoServiceClient);
        odsSoGrInfoController.searchOdsSoGrInfo(1L,10L,dto);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportCount() {
        EasyMock.expect(odsSoGrInfoServiceClient.getExportAmount(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(25001L);
        EasyMock.replay(odsSoGrInfoServiceClient);
        odsSoGrInfoController.exportCount(new OdsSoGrInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getSoGrInfoList() {
        EasyMock.expect(odsSoGrInfoServiceClient.getOdsSoGrInfoListByParm(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsSoGrInfoDTO>());
        EasyMock.replay(odsSoGrInfoServiceClient);
        odsSoGrInfoController.getSoGrInfoList(response,new OdsSoGrInfoDTO());
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
        odsSoGrInfoController.printOgp(request,response,"[{\"orderNo\":\"111\"}]");

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
        try {
            odsSoGrInfoController.printDn(request,response,"[{\"orderNo\":\"111\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}