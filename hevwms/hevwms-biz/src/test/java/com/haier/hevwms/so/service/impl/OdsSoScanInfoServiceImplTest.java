package com.haier.hevwms.so.service.impl;

import com.haier.hevwms.so.dao.OdsSoScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 13:24
 * @Description:
 */
public class OdsSoScanInfoServiceImplTest {

    private OdsSoScanInfoDAO odsSoScanInfoDAO;
    private OdsSoScanInfoServiceImpl odsSoScanInfoService = new OdsSoScanInfoServiceImpl();

    @Before
    public void init(){
        odsSoScanInfoDAO = EasyMock.createMock(OdsSoScanInfoDAO.class);
        odsSoScanInfoService.setOdsSoScanInfoDAO(odsSoScanInfoDAO);
    }

    @Test
    public void searchOdsSoScanInfoByPage() {
        Pager<OdsSoScanInfoDTO> pager = new Pager<OdsSoScanInfoDTO>();
        OdsSoScanInfoDTO dto = new OdsSoScanInfoDTO();
        EasyMock.expect(odsSoScanInfoDAO.searchOdsSoScanInfoByPage(
                pager,dto)
        ).andReturn(new ArrayList<OdsSoScanInfoDTO>());
        EasyMock.expect(odsSoScanInfoDAO.searchOdsSoScanInfoCount(
                dto)
        ).andReturn(1L);
        EasyMock.replay(odsSoScanInfoDAO);
        odsSoScanInfoService.searchOdsSoScanInfoByPage(pager,dto);
    }

    @Test
    public void getExportAmount() {
        odsSoScanInfoService.getExportAmount(new OdsSoScanInfoDTO());
    }

    @Test
    public void getOdsSoScanInfos() {
        odsSoScanInfoService.getOdsSoScanInfos(new OdsSoScanInfoDTO());
    }

    @Test
    public void getListByBarcodes() {
        odsSoScanInfoService.getListByBarcodes("11");
    }

    @Test
    public void updateOldBarcode() {
        EasyMock.expect(odsSoScanInfoDAO.updateOldBarcode(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1);
        EasyMock.replay(odsSoScanInfoDAO);
        odsSoScanInfoService.updateOldBarcode(new OdsSoScanInfoDTO());
    }
}