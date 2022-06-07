package com.haier.hevwms.scrap.service.impl;

import com.haier.hevwms.scrap.dao.OdsScrapScanInfoDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.scrap.dto.OdsScrapScanInfoDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 10:32
 * @Description:
 */
public class OdsScrapScanInfoServiceImplTest {

    private OdsScrapScanInfoDAO odsScrapScanInfoDAO;
    private OdsScrapScanInfoServiceImpl odsScrapScanInfoService = new OdsScrapScanInfoServiceImpl();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        odsScrapScanInfoDAO = EasyMock.createMock(OdsScrapScanInfoDAO.class);
        odsScrapScanInfoService.setOdsScrapScanInfoDAO(odsScrapScanInfoDAO);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchOdsScrapScanInfoByPage() {
        Pager<OdsScrapScanInfoDTO> pager = new Pager<OdsScrapScanInfoDTO>();
        OdsScrapScanInfoDTO odsScrapScanInfoDTO = new OdsScrapScanInfoDTO();
        EasyMock.expect(odsScrapScanInfoDAO.searchOdsScrapScanInfoByPage(
                pager,odsScrapScanInfoDTO)
        ).andReturn(new ArrayList<OdsScrapScanInfoDTO>());
        EasyMock.expect(odsScrapScanInfoDAO.searchOdsScrapScanInfoCount(
                odsScrapScanInfoDTO)
        ).andReturn(1L);
        EasyMock.replay(odsScrapScanInfoDAO);
        odsScrapScanInfoService.searchOdsScrapScanInfoByPage(pager,odsScrapScanInfoDTO);
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
        odsScrapScanInfoService.getExportAmount(new OdsScrapScanInfoDTO());
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void getOdsScrapScanInfos() {
        odsScrapScanInfoService.getOdsScrapScanInfos(new OdsScrapScanInfoDTO());
    }
}