package com.haier.hevwms.po.service.impl;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
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
 * @Date: 2019/4/22 13:56
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsPoGrInfoServiceImplTest {

    private OdsPoGrInfoServiceImpl clientImplMock = new OdsPoGrInfoServiceImpl();
    private OdsPoGrInfoDAO odsPoGrInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsPoGrInfoDAOMock = EasyMock.createMock(OdsPoGrInfoDAO.class);
        clientImplMock.setOdsPoGrInfoDAO(odsPoGrInfoDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsPoGrInfoListByPage() {
        EasyMock.expect(odsPoGrInfoDAOMock.searchOdsPoGrInfoListByPage(
                (Pager<OdsPoGrInfoDTO>)EasyMock.anyObject(),
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsPoGrInfoDTO>()).times(1);
        EasyMock.expect(odsPoGrInfoDAOMock.searchOdsPoGrInfoCount(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsPoGrInfoDAOMock);
        clientImplMock.searchOdsPoGrInfoListByPage(new Pager<OdsPoGrInfoDTO>(),new OdsPoGrInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getExportAmout() {
        clientImplMock.getExportAmout(new OdsPoGrInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getListByParm() {
        clientImplMock.getListByParm(new OdsPoGrInfoDTO());
    }
}