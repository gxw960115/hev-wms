package com.haier.hevwms.order.service.impl;

import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.domain.OdsOrderInfo;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderIgpDAO;
import com.haier.hevwms.remoting.rf.domain.Returnentity;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.sto.dao.StgStoDownDAO;
import com.haier.hevwms.sto.dao.StgStodnDownDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDownDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/13 16:09
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class OdsOrderInfoServiceImplTest {

    private OdsOrderInfoDAO odsOrderInfoDAO;
    private StgStoDownDAO stgStoDownDAO;
    private OtcwmsOrderIgpDAO otcwmsOrderIgpDAO;
    private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
    private StgStodnDownDAO StgStodnDownDAO;
    private OdsOrderInfoServiceImpl odsOrderInfoService = new OdsOrderInfoServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsOrderInfoDAO = EasyMock.createMock(OdsOrderInfoDAO.class);
        stgStoDownDAO = EasyMock.createMock(StgStoDownDAO.class);
        otcwmsOrderIgpDAO = EasyMock.createMock(OtcwmsOrderIgpDAO.class);
        odsOrderInfoDtlDAO = EasyMock.createMock(OdsOrderInfoDtlDAO.class);
        StgStodnDownDAO = EasyMock.createMock(StgStodnDownDAO.class);

        odsOrderInfoService.setOdsOrderInfoDAO(odsOrderInfoDAO);
        odsOrderInfoService.setStgStoDownDAO(stgStoDownDAO);
        odsOrderInfoService.setOtcwmsOrderIgpDAO(otcwmsOrderIgpDAO);
        odsOrderInfoService.setOdsOrderInfoDtlDAO(odsOrderInfoDtlDAO);
        odsOrderInfoService.setStgStodnDownDAO(StgStodnDownDAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveOdsInfoDtls() {
        List<OdsOrderInfoDtlDTO> orderList = new ArrayList<OdsOrderInfoDtlDTO>();
        List<StgStodnDownDTO> list = new ArrayList<StgStodnDownDTO>();
        StgStodnDownDTO stgStodnDownDTO = new StgStodnDownDTO();
        stgStodnDownDTO.setMaterialNo("aaa");
        stgStodnDownDTO.setStodnItemNo("111");
        list.add(stgStodnDownDTO);
        OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();
        odsOrderInfoDtlDTO.setMaterialNo("aaa");
        odsOrderInfoDtlDTO.setBarcode("1111111111111");
        orderList.add(odsOrderInfoDtlDTO);
        EasyMock.expect(StgStodnDownDAO.getListByParam(
                (StgStodnDownDTO)EasyMock.anyObject())
        ).andReturn(list);
        EasyMock.expect(odsOrderInfoDtlDAO.getListByParam(
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(orderList);
        odsOrderInfoDtlDAO.save((OdsOrderInfoDtlDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        StgStodnDownDAO.updateFinishQty("2222");
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(StgStodnDownDAO);
        EasyMock.replay(odsOrderInfoDtlDAO);
        odsOrderInfoService.saveOdsInfoDtls("1111,2222,333");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void savePreScan() {
        List<OdsOrderInfoDtlDTO> orderList = new ArrayList<OdsOrderInfoDtlDTO>();
        OdsOrderInfoDtlDTO odsOrderInfoDtlDTO = new OdsOrderInfoDtlDTO();
        odsOrderInfoDtlDTO.setMaterialNo("aaa");
        odsOrderInfoDtlDTO.setBarcode("1111111111111");
        orderList.add(odsOrderInfoDtlDTO);
        EasyMock.expect(odsOrderInfoDtlDAO.getListByParam(
                (OdsOrderInfoDtlDTO)EasyMock.anyObject())
        ).andReturn(orderList);
        otcwmsOrderIgpDAO.orderOgp((WmsOrderIgpIn)EasyMock.anyObject(),(WmsOrderIgpOut)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsOrderInfoDtlDAO);
        EasyMock.replay(otcwmsOrderIgpDAO);
        odsOrderInfoService.savePreScan("111,222,333","2019-05-10");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void createOdsOrderInfo() {
        odsOrderInfoDAO.save((OdsOrderInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        odsOrderInfoService.createOdsOrderInfo(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateOdsOrderInfo() {
        EasyMock.expect(odsOrderInfoDAO.update((OdsOrderInfoDTO)EasyMock.anyObject())).andReturn(1);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.updateOdsOrderInfo(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOdsOrderInfo() {
        EasyMock.expect(odsOrderInfoDAO.delete((Long)EasyMock.anyObject())).andReturn(1);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.deleteOdsOrderInfo(1L);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOdsOrderInfoAll() {
        odsOrderInfoDAO.deleteAll((List<Long>)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.deleteOdsOrderInfoAll((List<Long>)EasyMock.anyObject());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsOrderInfos() {
        Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfo = new OdsOrderInfoDTO();
        EasyMock.expect(odsOrderInfoDAO.searchOdsOrderInfos(pager,odsOrderInfo)
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.expect(odsOrderInfoDAO.searchOdsOrderInfosCount(odsOrderInfo)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.searchOdsOrderInfos(pager,odsOrderInfo);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOrderNos() {
        Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfo = new OdsOrderInfoDTO();
        EasyMock.expect(odsOrderInfoDAO.searchOrderNos(pager,odsOrderInfo)
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.expect(odsOrderInfoDAO.searchOrderNosCount(odsOrderInfo)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.searchOrderNos(pager,odsOrderInfo);

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchStoDNDetail() {
        Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfo = new OdsOrderInfoDTO();
        EasyMock.expect(odsOrderInfoDAO.searchStoDNDetail(pager,odsOrderInfo)
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.expect(odsOrderInfoDAO.searchStoDNDetailCount(odsOrderInfo)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.searchStoDNDetail(pager,odsOrderInfo);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOgpDetailsByStodnNo() {
        Pager<OdsOrderInfoDtlDTO> pager = new Pager<OdsOrderInfoDtlDTO>();
        OdsOrderInfoDtlDTO odsOrderInfo = new OdsOrderInfoDtlDTO();
        EasyMock.expect(odsOrderInfoDtlDAO.searchOgpDetailsByStodnNo(pager,odsOrderInfo)
        ).andReturn(new ArrayList<OdsOrderInfoDtlDTO>());
        EasyMock.expect(odsOrderInfoDtlDAO.searchOgpDetailsByStodnNoCount(odsOrderInfo)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDtlDAO);
        odsOrderInfoService.searchOgpDetailsByStodnNo(pager,odsOrderInfo);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOgpDetailsByStodnNoList() {
        OdsOrderInfoDtlDTO odsOrderInfoDtl = new OdsOrderInfoDtlDTO();
        EasyMock.expect(odsOrderInfoDtlDAO.searchOgpDetailsByStodnNo(
                null,odsOrderInfoDtl)).andReturn(new ArrayList<OdsOrderInfoDtlDTO>());
        EasyMock.replay(odsOrderInfoDtlDAO);
        odsOrderInfoService.searchOgpDetailsByStodnNoList(odsOrderInfoDtl);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfoById() {
        EasyMock.expect(odsOrderInfoDAO.get(1L)).andReturn(new OdsOrderInfoDTO());
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.getOdsOrderInfoById(1L);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsOrderInfos() {
        List<StgStoDownDTO> stoList = new ArrayList<StgStoDownDTO>();
        StgStoDownDTO stgStoDownDTO = new StgStoDownDTO();
        stgStoDownDTO.setCheckFlag("11");
        stoList.add(stgStoDownDTO);

        List<OdsOrderInfoDTO> orderList = new ArrayList<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfoDTO = new OdsOrderInfoDTO();
        odsOrderInfoDTO.setOrderType("11");
        orderList.add(odsOrderInfoDTO);
        EasyMock.expect(stgStoDownDAO.getListByParam(
                (StgStoDownDTO)EasyMock.anyObject())
        ).andReturn(stoList);
        EasyMock.expect(odsOrderInfoDAO.getAllByName(
                (OdsOrderInfoDTO)EasyMock.anyObject())
        ).andReturn(orderList);
        EasyMock.replay(stgStoDownDAO);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.getOdsOrderInfos(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteOdsOrderInfoDtlByNo() {
        odsOrderInfoDtlDAO.deleteOdsOrderInfoDtlByNo((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        odsOrderInfoService.deleteOdsOrderInfoDtlByNo("11,11");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getListByParam() {
        EasyMock.expect(odsOrderInfoDAO.getListByParam(
                (OdsOrderInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.getListByParam(new OdsOrderInfo());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getListByName() {
        EasyMock.expect(odsOrderInfoDAO.getAllByName(
                (OdsOrderInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.getListByName(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveInOrder() {
        odsOrderInfoDAO.save((OdsOrderInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.saveInOrder(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deltGfOrder() {
        odsOrderInfoService.deltGfOrder(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void findCarList() {
        odsOrderInfoService.findCarList(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void postOrder() {
        odsOrderInfoService.postOrder("","");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void createOrderNo() {
        EasyMock.expect(odsOrderInfoDAO.createOrderNo()).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.createOrderNo("11111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void saveOdsInfoDtlsByInvetory() {
        odsOrderInfoService.saveOdsInfoDtlsByInvetory("11","11");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void updateFinishQty() {
        StgStodnDownDAO.cleanFinishQty((String)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(StgStodnDownDAO);
        odsOrderInfoService.updateFinishQty("111,111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void inOutWarehouse() {
        odsOrderInfoService.inOutWarehouse("11","11","11");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void iogpCancel() {
        EasyMock.expect(odsOrderInfoDAO.iogpCancel(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (WmsOrderIgpOut)EasyMock.anyObject()
        )).andReturn("1");
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.iogpCancel(new OdsOrderInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void postOrderPlus() {
        List<OdsOrderInfoDTO> odsList = new ArrayList<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfoDTO = new OdsOrderInfoDTO();
        odsOrderInfoDTO.setSapFlag("1");
        odsOrderInfoDTO.setOrderType("1");
        odsList.add(odsOrderInfoDTO);

        List<OdsOrderInfoDTO> odsList_1 = new ArrayList<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfoDTO_1 = new OdsOrderInfoDTO();
        odsOrderInfoDTO_1.setSapFlag("1");
        odsOrderInfoDTO_1.setOrderType("2");
        odsList_1.add(odsOrderInfoDTO_1);

        EasyMock.expect(odsOrderInfoDAO.getListByParam(
                (OdsOrderInfoDTO)EasyMock.anyObject())
        ).andReturn(odsList).times(1).andReturn(odsList_1).times(1);
        otcwmsOrderIgpDAO.orderMakeStorageIn(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (Returnentity)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        otcwmsOrderIgpDAO.orderMakeStorageOut(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (Returnentity)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        EasyMock.replay(otcwmsOrderIgpDAO);
        EasyMock.replay(odsOrderInfoDAO);
        try {
            odsOrderInfoService.postOrderPlus("111","11");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOIGPOrderInfo() {
        Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
        OdsOrderInfoDTO odsOrderInfoDTO = new OdsOrderInfoDTO();
        EasyMock.expect(odsOrderInfoDAO.searchOIGPOrderInfo(pager,odsOrderInfoDTO)
        ).andReturn(new ArrayList<OdsOrderInfoDTO>());
        EasyMock.expect(odsOrderInfoDAO.searchOIGPOrderInfoCount(odsOrderInfoDTO)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.searchOIGPOrderInfo(pager,odsOrderInfoDTO);
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
        OdsOrderInfoDTO odsOrderInfoDTO = new OdsOrderInfoDTO();
        EasyMock.expect(odsOrderInfoDAO.searchOdsOrderInfosCount(odsOrderInfoDTO)).andReturn(1L);
        EasyMock.replay(odsOrderInfoDAO);
        odsOrderInfoService.getExportAmount(odsOrderInfoDTO);
    }
}