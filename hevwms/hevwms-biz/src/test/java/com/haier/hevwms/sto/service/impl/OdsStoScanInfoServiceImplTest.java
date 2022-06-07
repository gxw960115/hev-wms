package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.sto.dao.OdsStoScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoScanInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 15:36
 * @Description:
 */
public class OdsStoScanInfoServiceImplTest {

    private OdsStoScanInfoDAO odsStoScanInfoDAO;
    private OdsStoScanInfoServiceImpl odsStoScanInfoService = new OdsStoScanInfoServiceImpl();

    @Before
    public void init(){
        odsStoScanInfoDAO = EasyMock.createMock(OdsStoScanInfoDAO.class);
        odsStoScanInfoService.setOdsStoScanInfoDAO(odsStoScanInfoDAO);
    }

    @Test
    public void searchOdsStoScanInfoByPage() {
        Pager<OdsStoScanInfoDTO> pager = new Pager<OdsStoScanInfoDTO>();
        OdsStoScanInfoDTO odsStoCustScanInfoDTO = new OdsStoScanInfoDTO();
        EasyMock.expect(odsStoScanInfoDAO.searchOdsStoScanInfoByPage(
                pager,odsStoCustScanInfoDTO)
        ).andReturn(new ArrayList<OdsStoScanInfoDTO>());
        EasyMock.expect(odsStoScanInfoDAO.searchOdsStoScanInfoCount(
                odsStoCustScanInfoDTO)
        ).andReturn(1L);
        EasyMock.replay(odsStoScanInfoDAO);
        odsStoScanInfoService.searchOdsStoScanInfoByPage(pager,odsStoCustScanInfoDTO);
    }

    @Test
    public void getExportAmount() {
        odsStoScanInfoService.getExportAmount(new OdsStoScanInfoDTO());
    }

    @Test
    public void getOdsStoScanInfos() {
        odsStoScanInfoService.getOdsStoScanInfos(new OdsStoScanInfoDTO());
    }

    @Test
    public void getListByBarcodes() {
        odsStoScanInfoService.getListByBarcodes("11","11");
    }
}