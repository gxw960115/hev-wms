package com.haier.hevwms.po.service.impl;

import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/22 13:56
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsOrderInfoDtlServiceImplTest {

    private OdsOrderInfoDtlServiceImpl clientImplMock = new OdsOrderInfoDtlServiceImpl();
    private OdsOrderInfoDtlDAO odsOrderInfoDtlDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsOrderInfoDtlDAOMock = EasyMock.createMock(OdsOrderInfoDtlDAO.class);
        clientImplMock.setOdsOrderInfoDtlDAO(odsOrderInfoDtlDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateOdsOrderInfoDtl() {
        OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();
        odsOrderInfoDtlDTO.setBarcode("1111");
//        odsOrderInfoDtlDAOMock.update((OdsOrderInfoDtlDTO)EasyMock.anyObject());
        clientImplMock.updateOdsOrderInfoDtl(odsOrderInfoDtlDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOdsOrderInfoDtl() {
        Long l = 100L;
//        odsOrderInfoDtlDAOMock.delete((Long)EasyMock.anyObject());
//        EasyMock.expectLastCall().times(1);
//        EasyMock.replay(odsOrderInfoDtlDAOMock);
        clientImplMock.deleteOdsOrderInfoDtl(l);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOdsOrderInfoDtlAll() {
        odsOrderInfoDtlDAOMock.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsOrderInfoDtlDAOMock);
        clientImplMock.deleteOdsOrderInfoDtlAll(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsOrderInfoDtls() {
        EasyMock.expect(odsOrderInfoDtlDAOMock.searchOdsOrderInfoDtls(
                (Pager<OdsOrderInfoDtlDTO>)EasyMock.anyObject(),
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsOrderInfoDtlDTO>()).times(1);
        EasyMock.expect(odsOrderInfoDtlDAOMock.searchOdsOrderInfoDtlsCount(
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsOrderInfoDtlDAOMock);
        clientImplMock.searchOdsOrderInfoDtls(new Pager<OdsOrderInfoDtlDTO>(),new OdsOrderInfoDtlDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void save() {
        odsOrderInfoDtlDAOMock.save((OdsOrderInfoDtlDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsOrderInfoDtlDAOMock);
        clientImplMock.save(new OdsOrderInfoDtlDTO());

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfoDtls() {
        clientImplMock.getOdsOrderInfoDtls(new OdsOrderInfoDtlDTO());
    }

    /**
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void directDispatchCollect() {
        clientImplMock.directDispatchCollect("1","11","24");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfoDtlById() {
        clientImplMock.getOdsOrderInfoDtlById(1L);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfoDtls1() {
        clientImplMock.getOdsOrderInfoDtls();
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
        clientImplMock.getExportAmount(new OdsOrderInfoDtlDTO());
    }
}
