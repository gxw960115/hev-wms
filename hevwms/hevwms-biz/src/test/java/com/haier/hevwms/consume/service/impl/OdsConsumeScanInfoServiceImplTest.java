package com.haier.hevwms.consume.service.impl;

import com.haier.hevwms.consume.dao.OdsConsumeScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/2 13:59
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsConsumeScanInfoServiceImplTest {

    private OdsConsumeScanInfoServiceImpl clientImplMock = new OdsConsumeScanInfoServiceImpl();
    private OdsConsumeScanInfoDAO odsConsumeScanInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsConsumeScanInfoDAOMock = EasyMock.createMock(OdsConsumeScanInfoDAO.class);
        clientImplMock.setOdsConsumeScanInfoDAO(odsConsumeScanInfoDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeScanInfoByPage() {

        EasyMock.expect(odsConsumeScanInfoDAOMock.searchOdsConsumeScanInfoByPage(
                (Pager<OdsConsumeScanInfoDTO>)EasyMock.anyObject(),
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeScanInfoDTO>()).times(1);
        EasyMock.expect(odsConsumeScanInfoDAOMock.searchOdsConsumeScanInfoCount(
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsConsumeScanInfoDAOMock);
        clientImplMock.searchOdsConsumeScanInfoByPage(
                new Pager<OdsConsumeScanInfoDTO>(),
                new OdsConsumeScanInfoDTO());

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getExportAmount() {

        EasyMock.expect(odsConsumeScanInfoDAOMock.searchOdsConsumeScanInfoCount(
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsConsumeScanInfoDAOMock);
        clientImplMock.getExportAmount(new OdsConsumeScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsConsumeScanInfos() {
        EasyMock.expect(odsConsumeScanInfoDAOMock.getListByParam(
                (OdsConsumeScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsConsumeScanInfoDTO>()).times(1);
        EasyMock.replay(odsConsumeScanInfoDAOMock);
        clientImplMock.getOdsConsumeScanInfos(new OdsConsumeScanInfoDTO());
    }
}