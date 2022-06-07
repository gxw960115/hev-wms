package com.haier.wms.controller.scrap;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import com.haier.openplatform.wms.scrap.service.OdsScrapScanInfoServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/16 15:02
 * @Description:
 */
public class OdsScrapScanInfoControllerTest {

    private OdsScrapScanInfoServiceClient odsScrapScanInfoServiceClient;
    private OdsScrapScanInfoController odsScrapScanInfoController = new OdsScrapScanInfoController();
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
        odsScrapScanInfoServiceClient = EasyMock.createMock(OdsScrapScanInfoServiceClient.class);
        odsScrapScanInfoController.setOdsScrapScanInfoServiceClient(odsScrapScanInfoServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapScanInfo() {
        OdsScrapScanInfoDTO dto = new OdsScrapScanInfoDTO();
        EasyMock.expect(odsScrapScanInfoServiceClient.searchOdsScrapScanInfoByPage(
                1L,10L,dto)
        ).andReturn(new Pager<OdsScrapScanInfoDTO>());
        EasyMock.replay(odsScrapScanInfoServiceClient);
        odsScrapScanInfoController.searchOdsScrapScanInfo(1L,10L,dto);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapScanInfoAmount() {
        EasyMock.expect(odsScrapScanInfoServiceClient.getExportAmount(
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(25001L);
        EasyMock.replay(odsScrapScanInfoServiceClient);
        odsScrapScanInfoController.searchOdsScrapScanInfoAmount(new OdsScrapScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsScrapScanInfo() {
        EasyMock.expect(odsScrapScanInfoServiceClient.getOdsScrapScanInfos(
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapScanInfoDTO>());
        EasyMock.replay(odsScrapScanInfoServiceClient);
        try {
            odsScrapScanInfoController.exportOdsScrapScanInfo(request,response,new OdsScrapScanInfoDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}