package com.haier.hevwms.customer.service.impl;

import com.haier.hevwms.customer.dao.OdsCustomerStockDAO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/18 15:01
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsCustomerStockServiceImplTest {

    private OdsCustomerStockDAO odsCustomerStockDAO;
    private OdsCustomerStockServiceImpl odsCustomerStockService = new OdsCustomerStockServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsCustomerStockDAO = EasyMock.createMock(OdsCustomerStockDAO.class);
        odsCustomerStockService.setOdsCustomerStockDAO(odsCustomerStockDAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void test(){
        odsCustomerStockService.setOdsCustomerStockDAO(odsCustomerStockDAO);
    }

}