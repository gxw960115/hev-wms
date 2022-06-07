package com.haier.wms.controller.po;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoScanInfoServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.easymock.EasyMock.anyObject;
import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 15:33
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsPoScanInfoControllerTest {

    private OdsPoScanInfoController odsPoScanInfoController = new OdsPoScanInfoController();
    private OdsPoScanInfoServiceClient odsPoScanInfoServiceClient;
    private PsiReportServiceClient psiReportServiceClient;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext servletContext;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPoScanInfoServiceClient = EasyMock.createMock(OdsPoScanInfoServiceClient.class);
        psiReportServiceClient = EasyMock.createMock(PsiReportServiceClient.class);
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        session = EasyMock.createMock(HttpSession.class);
        servletContext = EasyMock.createMock(ServletContext.class);
        odsPoScanInfoController.setOdsPoScanInfoServiceClient(odsPoScanInfoServiceClient);
        odsPoScanInfoController.setPsiReportServiceClient(psiReportServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoScanInfo() {
        EasyMock.expect(odsPoScanInfoServiceClient.searchOdsPoScanInfoByPage(
                (Long)EasyMock.anyObject(),
                (Long)EasyMock.anyObject(),
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsPoScanInfoDTO>());
        EasyMock.replay(odsPoScanInfoServiceClient);
        odsPoScanInfoController.searchOdsPoScanInfo(1L,10L,new OdsPoScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchPoScanInfoExportAmount() {
        EasyMock.expect(odsPoScanInfoServiceClient.getExportAmount(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsPoScanInfoServiceClient);
        odsPoScanInfoController.searchPoScanInfoExportAmount(new OdsPoScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportPoScanInfo() {
        EasyMock.expect(odsPoScanInfoServiceClient.getOdsPoScanInfos(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoScanInfoDTO>());
        EasyMock.replay(odsPoScanInfoServiceClient);
        try {
            odsPoScanInfoController.exportPoScanInfo(request,response,new OdsPoScanInfoDTO());
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
    public void printPoDetail() {
        EasyMock.expect(request.getSession()).andReturn(session);
        EasyMock.expect(session.getServletContext()).andReturn(servletContext);
        EasyMock.expect(servletContext.getRealPath((String) anyObject())).andReturn("/");
        EasyMock.replay(request);
        EasyMock.replay(session);
        EasyMock.replay(servletContext);
        odsPoScanInfoController.printPoDetail(request,response,"11111111111111111111","111");
    }
}