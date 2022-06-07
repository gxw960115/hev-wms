package com.haier.wms.controller.consume;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import com.haier.openplatform.wms.consume.service.OdsConsumeScanInfoServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/30 14:09
 * @Description:
 */
@RunWith(PowerMockRunner.class)
public class OdsConsumeScanInfoControllerTest {

    private OdsConsumeScanInfoController odsConsumeScanInfoController = new OdsConsumeScanInfoController();
    private OdsConsumeScanInfoServiceClient odsConsumeScanInfoServiceClient;
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
        odsConsumeScanInfoServiceClient = EasyMock.createMock(OdsConsumeScanInfoServiceClient.class);
        odsConsumeScanInfoController.setOdsConsumeScanInfoServiceClient(odsConsumeScanInfoServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeScanInfo() {
        EasyMock.expect(odsConsumeScanInfoServiceClient.searchOdsConsumeScanInfoByPage(
                (Long)EasyMock.anyObject(),
                (Long)EasyMock.anyObject(),
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsConsumeScanInfoDTO>());
        EasyMock.replay(odsConsumeScanInfoServiceClient);
        odsConsumeScanInfoController.searchOdsConsumeScanInfo(1L,10L,new OdsConsumeScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeScanInfoAmount() {
        EasyMock.expect(odsConsumeScanInfoServiceClient.getExportAmount(
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsConsumeScanInfoServiceClient);
        odsConsumeScanInfoController.searchOdsConsumeScanInfoAmount(new OdsConsumeScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exportOdsConsumeScanInfo() {
        EasyMock.expect(odsConsumeScanInfoServiceClient.getOdsConsumeScanInfos(
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeScanInfoDTO>());
        EasyMock.replay(odsConsumeScanInfoServiceClient);
        try {
            odsConsumeScanInfoController.exportOdsConsumeScanInfo(request,response,new OdsConsumeScanInfoDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}