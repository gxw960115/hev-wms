package com.haier.hevwms.sapinterface;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
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
public class RePostStoToSapTest {

    private RePostStoToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsStoGigrInfoDAO odsStoGigrInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        String[] i = {"11111"};
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsStoGigrInfoDAOMock = EasyMock.createMock(OdsStoGigrInfoDAO.class);
        clientImplMock = new RePostStoToSap(i,operationLogDAOMock,odsStoGigrInfoDAOMock);
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
        List<OdsStoGigrInfoDTO> list = new ArrayList<OdsStoGigrInfoDTO>();
        OdsStoGigrInfoDTO odsStoGigrInfoDTO = new OdsStoGigrInfoDTO();
        odsStoGigrInfoDTO.setBatchNo("1111");
        list.add(odsStoGigrInfoDTO);
        EasyMock.expect(odsStoGigrInfoDAOMock.searchList(
                (OdsStoGigrInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        odsStoGigrInfoDAOMock.updatePostResult((OdsStoGigrInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        clientImplMock.exchangeWithSap();
    }
}