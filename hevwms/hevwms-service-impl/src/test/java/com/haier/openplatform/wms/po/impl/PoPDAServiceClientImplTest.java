package com.haier.openplatform.wms.po.impl;

import com.haier.hevwms.po.service.OdsPoScanInfoService;
import com.haier.hevwms.po.service.PoPDAService;
import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.*;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:28
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,SpringApplicationContextHolder.class})
public class PoPDAServiceClientImplTest {

    private PoPDAServiceClientImpl clientImplMock = new PoPDAServiceClientImpl();
    private StgPoDownService stgPoDownServiceMock;
    private PoPDAService poPDAServiceMock;
    private OdsPoScanInfoService odsPoScanInfoServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        stgPoDownServiceMock = EasyMock.createMock(StgPoDownService.class);
        poPDAServiceMock = EasyMock.createMock(PoPDAService.class);
        odsPoScanInfoServiceMock = EasyMock.createMock(OdsPoScanInfoService.class);
        clientImplMock.setPoPDAService(poPDAServiceMock);
        clientImplMock.setStgPoDownService(stgPoDownServiceMock);
        PowerMockito.mockStatic(UserUtil.class,SpringApplicationContextHolder.class);
        PowerMockito.when(SpringApplicationContextHolder.getBean("odsPoScanInfoService")).thenReturn(odsPoScanInfoServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderCheck() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(stgPoDownServiceMock.checkPo(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
         clientImplMock.poOrderCheck(new OrderCheckInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderCheck(){

        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(stgPoDownServiceMock.checkGiftPo(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO());
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.giftPoOrderCheck(new OrderCheckInDTO(),"111");

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderDownload() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(stgPoDownServiceMock.downloadPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("S").times(1);
        EasyMock.expect(stgPoDownServiceMock.getPoMaterialList(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OrderMatListDTO>()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.poOrderDownload(new OrderLoadInDTO(),"1");

    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderDelete() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.poOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.poOrderDelete(new OrderDeleteInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderDelete(){
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.giftPoOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO());
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.giftPoOrderDelete(new OrderDeleteInDTO(),"123");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrdersDelete() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        OrderDeleteInDTO dto = new OrderDeleteInDTO();
        dto.setBarcode("1");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.poOrderDelete((OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.poOrdersDelete(dto,"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderIgp() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        OrderIgpOutDTO outResult2 = new OrderIgpOutDTO();
        outResult.setStatus("0");
        outResult2.setStatus("1");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.poOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(outResult).times(1).andReturn(outResult2).times(1);
        EasyMock.expect(stgPoDownServiceMock.postPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("S").times(1);
        EasyMock.expect(stgPoDownServiceMock.poGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        EasyMock.expect(stgPoDownServiceMock.poGoodsDelivery(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(new OrderGoodsTransOutDTO()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.poOrderIgp(new OrderIgpInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderIgp(){
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        RfLogResult rfLogResult_1 = new RfLogResult();
        rfLogResult_1.setStatus("E");
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        outResult.setStatus("S");
        OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
        ret.setStatus("0");
        OrderGoodsTransOutDTO ret_1 = new OrderGoodsTransOutDTO();
        ret_1.setStatus("1");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1).andReturn(rfLogResult_1).times(1);
        EasyMock.expect(poPDAServiceMock.giftPoOrderIgp(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(outResult);
        EasyMock.expect(stgPoDownServiceMock.postPo(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn("S").times(1).andReturn("E").times(1);
        EasyMock.expect(stgPoDownServiceMock.giftPoGoodsReceive(
                (OrderIgpInDTO)EasyMock.anyObject())
        ).andReturn(ret).times(1).andReturn(ret_1).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        EasyMock.replay(stgPoDownServiceMock);
        clientImplMock.giftPoOrderIgp(new OrderIgpInDTO(),"111");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void barcodeList() {
        List<OdsPoScanInfoDTO> list = new ArrayList<OdsPoScanInfoDTO>();
        OdsPoScanInfoDTO odsPoScanInfoDTO = new OdsPoScanInfoDTO();
        odsPoScanInfoDTO.setBarcode("11111111111111111111111111111");
        list.add(odsPoScanInfoDTO);
        WmsOrderDelListInDTO wmsOrderDelListInDTO = new WmsOrderDelListInDTO();
        wmsOrderDelListInDTO.setOrderNo("1");
        wmsOrderDelListInDTO.setUser("1");
        wmsOrderDelListInDTO.setOrderType("1");
        EasyMock.expect(odsPoScanInfoServiceMock.getOdsPoScanInfos(
                (OdsPoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(list);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.barcodeList(wmsOrderDelListInDTO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void poOrderScan() {
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.scanPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.poOrderScan(new OrderUploadInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void giftPoOrderScan(){
        RfLogResult rfLogResult = new RfLogResult();
        rfLogResult.setStatus("S");
        EasyMock.expect(poPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult).times(1);
        EasyMock.expect(poPDAServiceMock.scanGiftPoCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO());
        poPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(poPDAServiceMock);
        clientImplMock.giftPoOrderScan(new OrderUploadInDTO(),"111");

    }

}
