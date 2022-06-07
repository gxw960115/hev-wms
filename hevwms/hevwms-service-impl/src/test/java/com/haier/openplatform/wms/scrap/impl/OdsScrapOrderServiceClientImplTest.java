package com.haier.openplatform.wms.scrap.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.scrap.service.OdsScrapOrderService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:31
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsScrapOrderServiceClientImplTest {

    private OdsScrapOrderServiceClientImpl clientImplMock = new OdsScrapOrderServiceClientImpl();
    private OdsScrapOrderService odsScrapOrderServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsScrapOrderServiceMock = EasyMock.createMock(OdsScrapOrderService.class);
        clientImplMock.setOdsScrapOrderService(odsScrapOrderServiceMock);
        clientImplMock.getOdsScrapOrderService();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapOrderByPage() {
        EasyMock.expect(odsScrapOrderServiceMock.searchOdsScrapOrderByPage(
                (Pager<OdsScrapOrderDTO>)EasyMock.anyObject(),
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsScrapOrderDTO>()).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.searchOdsScrapOrderByPage(1L,10L,new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceMock.deleteScrapOrder(
                (List<Long>)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.deleteScrapOrder(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void approveScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceMock.confirmScrapOrder(
                (List<Long>)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.approveScrapOrder(new ArrayList<Long>(),"");
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
        EasyMock.expect(odsScrapOrderServiceMock.getExportAmount(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.getExportAmount(new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsScrapOrderByList() {
        EasyMock.expect(odsScrapOrderServiceMock.getOdsScrapOrderListByParm(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapOrderDTO>()).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.getOdsScrapOrderByList(new OdsScrapOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getScrapSequence() {
        EasyMock.expect(odsScrapOrderServiceMock.getScrapSequence()).andReturn("1").times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.getScrapSequence();

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveScrapOrder() {
        EasyMock.expect(odsScrapOrderServiceMock.saveScrapOrder(
                (List<OdsScrapOrderDTO>)EasyMock.anyObject(),
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn("1").times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.saveScrapOrder(new ArrayList<OdsScrapOrderDTO>(),new OdsScrapOrderDTO());
    }
    
    /** 
    * @Title: updateCostCenter 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param     设定文件 
    * @return void    返回类型 
    * @throws 
    */
    @Test
    public void updateCostCenter() {
        EasyMock.expect(odsScrapOrderServiceMock.updateCostCenter(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(1).times(1);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.updateCostCenter(new OdsScrapOrderDTO());
    }
}
