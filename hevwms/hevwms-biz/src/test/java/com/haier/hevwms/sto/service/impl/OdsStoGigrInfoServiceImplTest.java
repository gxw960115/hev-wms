package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 15:35
 * @Description:
 */
public class OdsStoGigrInfoServiceImplTest {

    private OdsStoGigrInfoDAO odsStoGigrInfoDAO;
    private OdsStoGigrInfoServiceImpl odsStoGigrInfoService = new OdsStoGigrInfoServiceImpl();

    @Before
    public void init(){
        odsStoGigrInfoDAO = EasyMock.createMock(OdsStoGigrInfoDAO.class);
        odsStoGigrInfoService.setOdsStoGigrInfoDAO(odsStoGigrInfoDAO);
    }

    @Test
    public void getListByPage() {
        Pager<OdsStoGigrInfoDTO> pager = new Pager<OdsStoGigrInfoDTO>();
        OdsStoGigrInfoDTO odsStoCustScanInfoDTO = new OdsStoGigrInfoDTO();
        EasyMock.expect(odsStoGigrInfoDAO.searchOdsStoGiGrInfos(
                pager,odsStoCustScanInfoDTO)
        ).andReturn(new ArrayList<OdsStoGigrInfoDTO>());
        EasyMock.expect(odsStoGigrInfoDAO.searchOdsStoGiGrInfosCount(
                odsStoCustScanInfoDTO)
        ).andReturn(1L);
        EasyMock.replay(odsStoGigrInfoDAO);
        odsStoGigrInfoService.getListByPage(pager,odsStoCustScanInfoDTO);
    }

    @Test
    public void getOdsStoGigrInfoCountByParm() {
        odsStoGigrInfoService.getOdsStoGigrInfoCountByParm(new OdsStoGigrInfoDTO());
    }

    @Test
    public void getListByParm() {
        odsStoGigrInfoService.getListByParm(new OdsStoGigrInfoDTO());
    }

    @Test
    public void updateByOrderNo() {
        odsStoGigrInfoService.updateByOrderNo("11", "123", "23424");
    }
}
