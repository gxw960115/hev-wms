package com.haier.hevwms.sapinterface;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
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
 * @Date: 2019/4/26 09:54
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class RePostSoToSapTest {

    private RePostSoToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsSoGrInfoDAO odsSoGrInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        String[] i = {"1111111"};
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsSoGrInfoDAOMock = EasyMock.createMock(OdsSoGrInfoDAO.class);
        clientImplMock = new RePostSoToSap(i,operationLogDAOMock,odsSoGrInfoDAOMock);
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
        List<OdsSoGrInfoDTO> list = new ArrayList<OdsSoGrInfoDTO>();
        OdsSoGrInfoDTO odsSoGrInfoDTO = new OdsSoGrInfoDTO();
        odsSoGrInfoDTO.setBatchNo("1111111111111111");
        list.add(odsSoGrInfoDTO);
        EasyMock.expect(odsSoGrInfoDAOMock.getOdsSoGrInfoListByParm(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        odsSoGrInfoDAOMock.updatePostResult((OdsSoGrInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        clientImplMock.exchangeWithSap();
    }
}