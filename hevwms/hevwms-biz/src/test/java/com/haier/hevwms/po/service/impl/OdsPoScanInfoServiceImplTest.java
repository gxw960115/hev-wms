package com.haier.hevwms.po.service.impl;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.hevwms.po.dao.OdsPoScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
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
 * @Date: 2019/4/22 13:57
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsPoScanInfoServiceImplTest {

    private OdsPoScanInfoServiceImpl clientImplMock = new OdsPoScanInfoServiceImpl();
    private OdsPoScanInfoDAO odsPoScanInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPoScanInfoDAOMock = EasyMock.createMock(OdsPoScanInfoDAO.class);
        clientImplMock.setOdsPoScanInfoDAO(odsPoScanInfoDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoScanInfoByPage() {
        EasyMock.expect(odsPoScanInfoDAOMock.searchOdsPoScanInfoByPage(
                (Pager<OdsPoScanInfoDTO>)EasyMock.anyObject(),
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoScanInfoDTO>()).times(1);
        EasyMock.expect(odsPoScanInfoDAOMock.searchOdsPoScanInfoCount(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsPoScanInfoDAOMock);
        clientImplMock.searchOdsPoScanInfoByPage(new Pager<OdsPoScanInfoDTO>(),new OdsPoScanInfoDTO());
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
        clientImplMock.getExportAmount(new OdsPoScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsPoScanInfos() {
        clientImplMock.getOdsPoScanInfos(new OdsPoScanInfoDTO());
    }
}