package com.haier.hevwms.order.service.impl;

import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.dao.OdsTransferInventoryDAO;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/13 16:10
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class})
public class OdsTransferInventoryServiceImplTest {

    private OdsTransferInventoryDAO odsTransferInventoryDAO;//311移库单
    private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
    private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
    private OdsOrderInfoDAO odsOrderInfoDAO;
    private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
    private OdsTransferInventoryServiceImpl odsTransferInventoryService = new OdsTransferInventoryServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsTransferInventoryDAO=EasyMock.createMock(OdsTransferInventoryDAO.class);
        odsInventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
        odsOrderInfoDtlDAO = EasyMock.createMock(OdsOrderInfoDtlDAO.class);
        odsOrderInfoDAO = EasyMock.createMock(OdsOrderInfoDAO.class);
        odsBarcodeHistoryDAO = EasyMock.createMock(OdsBarcodeHistoryDAO.class);
        odsTransferInventoryService.setOdsTransferInventoryDAO(odsTransferInventoryDAO);
        odsTransferInventoryService.setOdsInventoryInfoDtlDAO(odsInventoryInfoDtlDAO);
        odsTransferInventoryService.setOdsOrderInfoDtlDAO(odsOrderInfoDtlDAO);
        odsTransferInventoryService.setOdsOrderInfoDAO(odsOrderInfoDAO);
        odsTransferInventoryService.setOdsBarcodeHistoryDAO(odsBarcodeHistoryDAO);
        BaseUser baseUser = new BaseUser();
        baseUser.setName("test");
        PowerMockito.mockStatic(UserUtil.class);
        PowerMockito.when(UserUtil.getCurrentUser()).thenReturn(baseUser);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void selectTransferInventoryOrderNo() {
        EasyMock.expect(odsTransferInventoryDAO.selectTransferInventoryOrderNo(
                (String)EasyMock.anyObject())
        ).andReturn("1111111111111111111111111");
        EasyMock.replay(odsTransferInventoryDAO);
        odsTransferInventoryService.selectTransferInventoryOrderNo();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void createOdsTransInventoryInfo() {
        odsTransferInventoryDAO.save((OdsTransferInventoryDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsTransferInventoryService.createOdsTransInventoryInfo(new OdsTransferInventoryDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchTransInventoryInfos() {
        Pager<OdsTransferInventoryDTO> pager = new Pager<OdsTransferInventoryDTO>();
        OdsTransferInventoryDTO odsTransferInventoryDTO = new OdsTransferInventoryDTO();
        EasyMock.expect(odsTransferInventoryDAO.searchTransInventoryInfos(
                pager,odsTransferInventoryDTO)
        ).andReturn(new ArrayList<OdsTransferInventoryDTO>());
        EasyMock.expect(odsTransferInventoryDAO.searchOdsTransInfosCount(
                odsTransferInventoryDTO)
        ).andReturn(1L);
        EasyMock.replay(odsTransferInventoryDAO);
        odsTransferInventoryService.searchTransInventoryInfos(pager,odsTransferInventoryDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOrder() {

        List<OdsOrderInfoDtlDTO> orderDtl = new ArrayList<OdsOrderInfoDtlDTO>();
        OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();
        odsOrderInfoDtlDTO.setMaterialNo("1");
        odsOrderInfoDtlDTO.setQty(1L);
        orderDtl.add(odsOrderInfoDtlDTO);
        EasyMock.expect(odsOrderInfoDtlDAO.searchOrderDtlBySapOrderNo(
                (String)EasyMock.anyObject())
        ).andReturn(orderDtl);
        odsInventoryInfoDtlDAO.updateUseQtyBySapOrderNo(
                (OdsInventoryInfoDtl)EasyMock.anyObject(),
                (Long)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsTransferInventoryDAO.updateTransOrderStatus((OdsTransferInventoryDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsOrderInfoDtlDAO.searchOrderDtlBySapOrderNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsOrderInfoDtlDAO.deleteOrderDtlBySapOrderNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsOrderInfoDAO.deleteOrderBySapOrderNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsBarcodeHistoryDAO.deleteBacodeInfoBySapOrderNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(odsOrderInfoDtlDAO);
        EasyMock.replay(odsInventoryInfoDtlDAO);
        EasyMock.replay(odsTransferInventoryDAO);
        EasyMock.replay(odsOrderInfoDAO);
        EasyMock.replay(odsBarcodeHistoryDAO);
        odsTransferInventoryService.deleteOrder(new OdsTransferInventoryDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getList() {
        EasyMock.expect(odsTransferInventoryDAO.getList(
                (OdsTransferInventoryDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsTransferInventoryDTO>());
        EasyMock.replay(odsTransferInventoryDAO);
        odsTransferInventoryService.getList(new OdsTransferInventoryDTO());
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
        EasyMock.expect(odsTransferInventoryDAO.searchOdsTransInfosCount(
                (OdsTransferInventoryDTO)EasyMock.anyObject())
        ).andReturn(1L);
        EasyMock.replay(odsTransferInventoryDAO);
        odsTransferInventoryService.getExportAmount(new OdsTransferInventoryDTO());
    }
}
