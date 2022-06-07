package com.haier.openplatform.wms.scrap.impl;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sapinterface.ScrapToSap;
import com.haier.hevwms.scrap.dao.OdsScrapOrderDAO;
import com.haier.hevwms.scrap.service.OdsScrapOrderService;
import com.haier.hevwms.scrap.service.OdsScrapScanInfoService;
import com.haier.hevwms.scrap.service.ScrapPDAService;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.xml.ws.WebServiceContext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:32
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,BeanUtils.class,SpringApplicationContextHolder.class})
public class ScrapPDAServiceClientImplTest {

    private ScrapPDAServiceClientImpl clientImplMock = new ScrapPDAServiceClientImpl();
    private RfWsService rfWsServiceMock;
    private ScrapPDAService scrapPDAServiceMock;
    private OdsScrapOrderService odsScrapOrderServiceMock;
    private OdsScrapScanInfoService odsScrapScanInfoServiceMock;
    private OperationLogDAO operationLogDAO;
    private OdsScrapOrderDAO odsScrapOrderDAO;
    private ScrapToSap scrapToSap = null;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        rfWsServiceMock = EasyMock.createMock(RfWsService.class);
        scrapPDAServiceMock = EasyMock.createMock(ScrapPDAService.class);
        odsScrapOrderServiceMock = EasyMock.createMock(OdsScrapOrderService.class);
        odsScrapScanInfoServiceMock = EasyMock.createMock(OdsScrapScanInfoService.class);
        operationLogDAO = EasyMock.createMock(OperationLogDAO.class);
        odsScrapOrderDAO = EasyMock.createMock(OdsScrapOrderDAO.class);
        clientImplMock.setRfWsService(rfWsServiceMock);
        clientImplMock.setScrapPDAService(scrapPDAServiceMock);
        clientImplMock.setOdsScrapOrderService(odsScrapOrderServiceMock);
        clientImplMock.setOdsScrapScanInfoService(odsScrapScanInfoServiceMock);
        clientImplMock.getContext();
        clientImplMock.getRfWsService();
        clientImplMock.getScrapPDAService();
        clientImplMock.getOdsScrapOrderService();
        clientImplMock.getOdsScrapScanInfoService();

        PowerMockito.mockStatic(UserUtil.class,SpringApplicationContextHolder.class);
        PowerMockito.when(SpringApplicationContextHolder.getBean("operationLogDAO")).thenReturn(operationLogDAO);
        PowerMockito.when(SpringApplicationContextHolder.getBean("odsScrapOrderDAO")).thenReturn(odsScrapOrderDAO);
        scrapToSap = new ScrapToSap("1111","1",operationLogDAO,odsScrapOrderDAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderCheck() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsScrapOrderServiceMock.checkScrapOrderByPDA(
                (OrderCheckInDTO)EasyMock.anyObject())
        ).andReturn(new OrderCheckOutDTO()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        EasyMock.replay(odsScrapOrderServiceMock);
        clientImplMock.scrapOrderCheck(new OrderCheckInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderDownload() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        clientImplMock.scrapOrderDownload(new OrderLoadInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderDelete() {

        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(scrapPDAServiceMock.scrapOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        clientImplMock.scrapOrderDelete(new OrderDeleteInDTO(),"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrdersDelete() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        OrderDeleteInDTO orderDeleteInDTO = new OrderDeleteInDTO();
        orderDeleteInDTO.setBarcode("11111111111");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(scrapPDAServiceMock.scrapOrderDelete(
                (OrderDeleteInDTO)EasyMock.anyObject())
        ).andReturn(new OrderDeleteOutDTO()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        clientImplMock.scrapOrdersDelete(orderDeleteInDTO,"1");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderIgp() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(odsScrapOrderServiceMock.scanStatus(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapOrderDTO>()).times(1);
        scrapPDAServiceMock.updateSapInfo((OrderIgpInDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.expect(scrapPDAServiceMock.scrapOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        EasyMock.replay(odsScrapOrderServiceMock);
        try {
            clientImplMock.scrapOrderIgp(new OrderIgpInDTO(),"1","1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
    public void orderPosting() {
        EasyMock.expect(scrapPDAServiceMock.scrapOrderIgp(
                (WmsOrderIgpIn)EasyMock.anyObject())
        ).andReturn(new WmsOrderIgpOut()).times(1);
        EasyMock.replay(scrapPDAServiceMock);
        try {
            clientImplMock.orderPosting(new OrderIgpInDTO(),"1");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
    public void barcodeList() {
        EasyMock.expect(odsScrapScanInfoServiceMock.getOdsScrapScanInfos(
                (OdsScrapScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsScrapScanInfoDTO>()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsScrapScanInfoServiceMock);
        EasyMock.replay(scrapPDAServiceMock);
        clientImplMock.barcodeList(new WmsOrderDelListInDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void scrapOrderScan() {
        RfLogResult rfLogResult_1 = new RfLogResult();
        RfLogResult rfLogResult_2 = new RfLogResult();
        rfLogResult_1.setStatus("S");
        rfLogResult_2.setStatus("E");
        EasyMock.expect(scrapPDAServiceMock.checkSign(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject())
        ).andReturn(rfLogResult_1).times(1).andReturn(rfLogResult_2).times(1);
        EasyMock.expect(scrapPDAServiceMock.scanScrapCheck(
                (OrderUploadInDTO)EasyMock.anyObject())
        ).andReturn(new OrderUploadOutDTO()).times(1);
        scrapPDAServiceMock.writeLog((String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (WebServiceContext)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject(),
                EasyMock.anyObject(),
                EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(scrapPDAServiceMock);
        clientImplMock.scrapOrderScan(new OrderUploadInDTO(),"1");
    }
}
