package com.haier.openplatform.wms.consume.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.hevwms.consume.service.OdsConsumeOrderService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;

/**
 * @Auther: mahuansen2
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsConsumeOrderServiceClientImplTest {

    private OdsConsumeOrderServiceClientImpl clientImplMock = new OdsConsumeOrderServiceClientImpl();
    private OdsConsumeOrderService odsConsumeOrderServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init() {
        odsConsumeOrderServiceMock = EasyMock.createMock(OdsConsumeOrderService.class);
        clientImplMock.setOdsConsumeOrderService(odsConsumeOrderServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsConsumeOrderByPage() {
        EasyMock.expect(odsConsumeOrderServiceMock.searchOdsConsumeOrderByPage((Pager<OdsConsumeOrderDTO>)EasyMock.anyObject()
                ,(OdsConsumeOrderDTO)EasyMock.anyObject())).andReturn(new Pager<OdsConsumeOrderDTO>()).times(1);
        EasyMock.replay(odsConsumeOrderServiceMock);
        clientImplMock.searchOdsConsumeOrderByPage(1L, 10L, new OdsConsumeOrderDTO());
        EasyMock.verify(odsConsumeOrderServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteConsumeOrder() {
        clientImplMock.deleteConsumeOrder(new ArrayList<Long>());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void approveConsumeOrder() {
        clientImplMock.approveConsumeOrder(new ArrayList<Long>(),"");
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
        clientImplMock.getExportAmount(new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsConsumeOrderByList() {
        clientImplMock.getOdsConsumeOrderByList(new OdsConsumeOrderDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getConsumeSequence() {
        clientImplMock.getConsumeSequence();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveConsumeOrder() {
        clientImplMock.saveConsumeOrder(new ArrayList<OdsConsumeOrderDTO>(),new OdsConsumeOrderDTO());
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
        clientImplMock.updateCostCenter(new OdsConsumeOrderDTO());
    }
}