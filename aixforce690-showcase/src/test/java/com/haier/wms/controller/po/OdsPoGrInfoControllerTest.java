package com.haier.wms.controller.po;

import com.haier.openplatform.excel.ExcelExportTemplate;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import com.haier.openplatform.wms.po.service.OdsPoGrInfoServiceClient;
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
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/5 15:33
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class OdsPoGrInfoControllerTest {

    private OdsPoGrInfoController odsPoGrInfoController = new OdsPoGrInfoController();
    private OdsPoGrInfoServiceClient odsPoGrInfoServiceClient;
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
        odsPoGrInfoServiceClient = EasyMock.createMock(OdsPoGrInfoServiceClient.class);
        request = EasyMock.createMock(HttpServletRequest.class);
        response = EasyMock.createMock(HttpServletResponse.class);
        session = EasyMock.createMock(HttpSession.class);
        servletContext = EasyMock.createMock(ServletContext.class);
        odsPoGrInfoController.setOdsPoGrInfoServiceClient(odsPoGrInfoServiceClient);

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoGrInfo() {
        EasyMock.expect(odsPoGrInfoServiceClient.searchOdsPoGrInfoListByPage(
                (Long)EasyMock.anyObject(),
                (Long)EasyMock.anyObject(),
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsPoGrInfoDTO>());
        EasyMock.replay(odsPoGrInfoServiceClient);
        odsPoGrInfoController.searchOdsPoGrInfo(1L,10L,new OdsPoGrInfoDTO());
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
        EasyMock.expect(odsPoGrInfoServiceClient.getExportAmount(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsPoGrInfoServiceClient);
        odsPoGrInfoController.exportCount(new OdsPoGrInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getPoGrInfoList() {
        EasyMock.expect(odsPoGrInfoServiceClient.getOdsPoGrInfoListByParm(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoGrInfoDTO>());
        EasyMock.replay(odsPoGrInfoServiceClient);
        odsPoGrInfoController.getPoGrInfoList(request,response,new OdsPoGrInfoDTO());
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
        EasyMock.expect(session.getServletContext()).andReturn(servletContext);
        EasyMock.expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
        EasyMock.replay(request);
        EasyMock.replay(session);
        EasyMock.replay(servletContext);

        odsPoGrInfoController.printDn(request,response,"[{\"orderNo\":\"111\"}]");
    }
}