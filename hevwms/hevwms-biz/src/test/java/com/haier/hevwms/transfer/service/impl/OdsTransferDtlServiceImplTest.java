package com.haier.hevwms.transfer.service.impl;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.transfer.dao.OdsTransferDtlDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 16:38
 * @Description:
 */
public class OdsTransferDtlServiceImplTest {

    private OdsTransferDtlDAO odsTransferDtlDAO;
    private OdsTransferDtlServiceImpl odsTransferDtlService = new OdsTransferDtlServiceImpl();

    @Before
    public void init(){
        odsTransferDtlDAO = EasyMock.createMock(OdsTransferDtlDAO.class);
        odsTransferDtlService.setOdsTransferDtlDAO(odsTransferDtlDAO);
    }

    @Test
    public void searchOdsTransferDtls() {
        Pager<OdsTransferDtlDTO> pager = new Pager<OdsTransferDtlDTO>();
        OdsTransferDtlDTO odsSoGrInfoDTO = new OdsTransferDtlDTO();
        EasyMock.expect(odsTransferDtlDAO.searchOdsTransferDtlsCount(odsSoGrInfoDTO)).andReturn(1L);
        EasyMock.expect(odsTransferDtlDAO.searchOdsTransferDtls(
                pager,odsSoGrInfoDTO)
        ).andReturn(new ArrayList<OdsTransferDtlDTO>());
        EasyMock.replay(odsTransferDtlDAO);
        odsTransferDtlService.searchOdsTransferDtls(pager,odsSoGrInfoDTO);
    }

    @Test
    public void searchOdsTransferDtlsCount() {
        odsTransferDtlService.searchOdsTransferDtlsCount(new OdsTransferDtlDTO());
    }

    @Test
    public void getListByParams() {
        odsTransferDtlService.getListByParams(new OdsTransferDtlDTO());
    }

    @Test
    public void orderOgp() {
        odsTransferDtlDAO.orderOgp(
                (WmsOrderIgpIn)EasyMock.anyObject(),
                (WmsOrderIgpOut)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsTransferDtlService.orderOgp(new WmsOrderIgpIn());
    }

    @Test
    public void scanTransfer() {
        odsTransferDtlDAO.scanTransfer(
                (OrderUploadInDTO)EasyMock.anyObject(),
                (OrderUploadOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsTransferDtlService.scanTransfer(new OrderUploadInDTO());
    }

    @Test
    public void orderDelete() {
        odsTransferDtlDAO.deleteScanInfoByBarcode(
                (WmsOrderDeleteIn)EasyMock.anyObject(),
                (OrderDeleteOutDTO)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        odsTransferDtlService.orderDelete(new WmsOrderDeleteIn());

    }

    @Test
    public void scanStatus() {
        odsTransferDtlService.scanStatus("11");

    }

    @Test
    public void updateSapInfo() {
        odsTransferDtlService.updateSapInfo(new OrderIgpInDTO());
    }
}