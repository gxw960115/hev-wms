package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.sto.dao.OdsStoCustScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 14:47
 * @Description:
 */
public class OdsStoCustScanInfoServiceImplTest {

    private OdsStoCustScanInfoDAO odsStoCustScanInfoDAO;
    private OdsStoCustScanInfoServiceImpl odsStoCustScanInfoService = new OdsStoCustScanInfoServiceImpl();

    @Before
    public void init(){
        odsStoCustScanInfoDAO = EasyMock.createMock(OdsStoCustScanInfoDAO.class);
        odsStoCustScanInfoService.setOdsStoCustScanInfoDAO(odsStoCustScanInfoDAO);
    }

    @Test
    public void searchOdsStoCustScanInfoByPage() {
        Pager<OdsStoCustScanInfoDTO> pager = new Pager<OdsStoCustScanInfoDTO>();
        OdsStoCustScanInfoDTO odsStoCustScanInfoDTO = new OdsStoCustScanInfoDTO();
        EasyMock.expect(odsStoCustScanInfoDAO.searchOdsStoCustScanInfoByPage(
                pager,odsStoCustScanInfoDTO)
        ).andReturn(new ArrayList<OdsStoCustScanInfoDTO>());
        EasyMock.expect(odsStoCustScanInfoDAO.searchOdsStoCustScanInfoCount(
                odsStoCustScanInfoDTO)
        ).andReturn(1L);
        EasyMock.replay(odsStoCustScanInfoDAO);
        odsStoCustScanInfoService.searchOdsStoCustScanInfoByPage(pager,odsStoCustScanInfoDTO);
    }

    @Test
    public void getExportAmount() {
        odsStoCustScanInfoService.getExportAmount(new OdsStoCustScanInfoDTO());
    }

    @Test
    public void getOdsStoCustScanInfos() {
        odsStoCustScanInfoService.getOdsStoCustScanInfos(new OdsStoCustScanInfoDTO());
    }

    @Test
    public void getListByParams() {
        odsStoCustScanInfoService.getListByParams(new OdsStoCustScanInfoDTO());
    }

    @Test
    public void orderScan() {
        OrderUploadInDTO inpara = new OrderUploadInDTO();
        inpara.setOrdertype("1");
        OrderUploadInDTO inpara_2 = new OrderUploadInDTO();
        inpara_2.setOrdertype("2");
        odsStoCustScanInfoDAO.orderScanIn(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsStoCustScanInfoDAO.orderScanOut(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        EasyMock.replay(odsStoCustScanInfoDAO);
        odsStoCustScanInfoService.orderScan(inpara);

    }

    @Test
    public void orderDelete() {
        odsStoCustScanInfoDAO.deleteScanInfoByBarcode(
                (WmsOrderDeleteIn)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsStoCustScanInfoService.orderDelete(new WmsOrderDeleteIn());
    }
}