package com.haier.hevwms.so.service.impl;

import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
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
public class OdsSoGrInfoServiceImplTest {

    private OdsSoGrInfoDAO odsSoGrInfoDAO;
    private OdsSoGrInfoServiceImpl odsSoGrInfoService = new OdsSoGrInfoServiceImpl();

    @Before
    public void init(){
        odsSoGrInfoDAO = EasyMock.createMock(OdsSoGrInfoDAO.class);
        odsSoGrInfoService.setOdsSoGrInfoDAO(odsSoGrInfoDAO);
    }

    @Test
    public void searchOdsSoGrInfoListByPage() {
        Pager<OdsSoGrInfoDTO> pager = new Pager<OdsSoGrInfoDTO>();
        OdsSoGrInfoDTO odsSoGrInfoDTO = new OdsSoGrInfoDTO();
        EasyMock.expect(odsSoGrInfoDAO.searchOdsSoGrInfoCount(odsSoGrInfoDTO)).andReturn(1L);
        EasyMock.expect(odsSoGrInfoDAO.searchOdsSoGrInfoListByPage(
                pager,odsSoGrInfoDTO)
        ).andReturn(new ArrayList<OdsSoGrInfoDTO>());
        EasyMock.replay(odsSoGrInfoDAO);
        odsSoGrInfoService.searchOdsSoGrInfoListByPage(pager,odsSoGrInfoDTO);

    }

    @Test
    public void getExportAmout() {
        odsSoGrInfoService.getExportAmout(new OdsSoGrInfoDTO());
    }

    @Test
    public void getListByParm() {
        odsSoGrInfoService.getListByParm(new OdsSoGrInfoDTO());
    }
}