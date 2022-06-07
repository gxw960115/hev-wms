package com.haier.hevwms.customer.service.impl;

import com.haier.hevwms.customer.dao.OdsCustomerScanInfoDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
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
 * @Date: 2019/4/18 15:00
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsCustomerScanInfoServiceImplTest {

    private OdsCustomerScanInfoServiceImpl clientImplMock = new OdsCustomerScanInfoServiceImpl();
    private OdsCustomerScanInfoDAO odsCustomerScanInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsCustomerScanInfoDAOMock = EasyMock.createMock(OdsCustomerScanInfoDAO.class);
        clientImplMock.setOdsCustomerScanInfoDAO(odsCustomerScanInfoDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerScanInfos() {
        EasyMock.expect(odsCustomerScanInfoDAOMock.searchOdsCustomerScanInfos(
                (Pager<OdsCustomerScanInfoDTO>)EasyMock.anyObject(),
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsCustomerScanInfoDTO>()).times(1);
        EasyMock.expect(odsCustomerScanInfoDAOMock.searchOdsCustomerScanInfosCount(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.searchOdsCustomerScanInfos(
                new Pager<OdsCustomerScanInfoDTO>(),
                new OdsCustomerScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsCustomerScanInfosCount() {

        EasyMock.expect(odsCustomerScanInfoDAOMock.searchOdsCustomerScanInfosCount(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.searchOdsCustomerScanInfosCount(new OdsCustomerScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getListByParams() {
        EasyMock.expect(odsCustomerScanInfoDAOMock.getListByParams(
                (OdsCustomerScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsCustomerScanInfoDTO>()).times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.getListByParams(new OdsCustomerScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scanCustomer() {

        odsCustomerScanInfoDAOMock.scanCustomer(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.scanCustomer(new OrderUploadInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderDelete() {
        odsCustomerScanInfoDAOMock.deleteScanInfoByBarcode(
                (WmsOrderDeleteIn)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.orderDelete(new WmsOrderDeleteIn());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void orderOgp() {
        odsCustomerScanInfoDAOMock.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (WmsOrderIgpOut)EasyMock.anyObject()
        );
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsCustomerScanInfoDAOMock);
        clientImplMock.orderOgp(new WmsOrderIgpIn());
    }
}