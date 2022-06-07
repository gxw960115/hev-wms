package com.haier.wms.controller.so;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import com.haier.openplatform.wms.so.service.OdsSoScanInfoServiceClient;
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
 * @Date: 2019/5/16 16:24
 * @Description:
 */
public class OdsSoScanInfoControllerTest {

    private HttpServletResponse response;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext context;
    private OdsSoScanInfoController odsSoScanInfoController = new OdsSoScanInfoController();
    private OdsSoScanInfoServiceClient odsSoScanInfoServiceClient;
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
        odsSoScanInfoServiceClient = EasyMock.createMock(OdsSoScanInfoServiceClient.class);
        odsSoScanInfoController.setOdsSoScanInfoServiceClient(odsSoScanInfoServiceClient);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsSoScanInfo() {
        OdsSoScanInfoDTO dto = new OdsSoScanInfoDTO();
        EasyMock.expect(odsSoScanInfoServiceClient.searchOdsPoScanInfoByPage(
                1L,10L,dto)
        ).andReturn(new Pager<OdsSoScanInfoDTO>());
        EasyMock.replay(odsSoScanInfoServiceClient);
        odsSoScanInfoController.searchOdsSoScanInfo(1L,10L,dto);
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsSoScanInfoAmount() {
        EasyMock.expect(odsSoScanInfoServiceClient.getExportAmount(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(25001L);
        EasyMock.replay(odsSoScanInfoServiceClient);
        odsSoScanInfoController.searchOdsSoScanInfoAmount(new OdsSoScanInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateOldBarcode() {
        EasyMock.expect(odsSoScanInfoServiceClient.updateOldBarcode(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn("1");
        EasyMock.replay(odsSoScanInfoServiceClient);
        odsSoScanInfoController.updateOldBarcode(new OdsSoScanInfoDTO());
    }
    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsSoScanInfo() {
        EasyMock.expect(odsSoScanInfoServiceClient.getOdsPoScanInfos(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsSoScanInfoDTO>());
        EasyMock.replay(odsSoScanInfoServiceClient);
        odsSoScanInfoController.exportOdsSoScanInfo(response,new OdsSoScanInfoDTO());
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
        odsSoScanInfoController.printSoDetail(request,response,
                "11111111111111111111","11","11");
    }
}