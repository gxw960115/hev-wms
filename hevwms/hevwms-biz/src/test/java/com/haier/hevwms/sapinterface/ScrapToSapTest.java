package com.haier.hevwms.sapinterface;

import com.haier.hevwms.scrap.dao.OdsScrapOrderDAO;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.openplatform.wms.scrap.dto.OdsScrapOrderDTO;
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
 * @Date: 2019/4/23 16:52
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class ScrapToSapTest {

    private ScrapToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsScrapOrderDAO odsScrapOrderDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsScrapOrderDAOMock = EasyMock.createMock(OdsScrapOrderDAO.class);
        clientImplMock = new ScrapToSap(operationLogDAOMock,odsScrapOrderDAOMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void exchangeWithSap() {
        List<OdsScrapOrderDTO> list = new ArrayList<OdsScrapOrderDTO>();
        OdsScrapOrderDTO odsScrapOrderDTO = new OdsScrapOrderDTO();
        odsScrapOrderDTO.setScrapNo("111");
        list.add(odsScrapOrderDTO);
        EasyMock.expect(odsScrapOrderDAOMock.getOdsScrapOrderListByParm(
                (OdsScrapOrderDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        EasyMock.replay(odsScrapOrderDAOMock);
        clientImplMock.exchangeWithSap();
    }
}