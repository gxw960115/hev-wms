package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.sto.dao.OdsStoGigrInfoDAO;
import com.haier.openplatform.wms.sto.dto.OdsStoGigrInfoDTO;
import com.sap.conn.jco.*;
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
 * @Date: 2019/4/26 11:17
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class PostStodnToSapTest {

    private PostStodnToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsStoGigrInfoDAO odsStoGigrInfoDAOMock;

    private JCoDestination destination;
    private JCoFunction function;
    private JCoRepository jCoRepository;
    private JCoStructure sapReturnParam;
    private JCoParameterList jCoFields_s;
    private JCoTable tableIn;
    private JCoParameterList jCoFields_t;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        try {
            destination =JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
            jCoRepository = destination.getRepository();
            function = jCoRepository.getFunction("ZMM_AEV_INT_SLOCTRANSFER");
        } catch (JCoException e) {
            e.printStackTrace();
        }
        String[] i = {"11111111"};
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsStoGigrInfoDAOMock = EasyMock.createMock(OdsStoGigrInfoDAO.class);
        clientImplMock = new PostStodnToSap(i,operationLogDAOMock,odsStoGigrInfoDAOMock);
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
        odsStoGigrInfoDTO.setBatchNo("11111111111");
        list.add(odsStoGigrInfoDTO);
        clientImplMock.exchangeWithSap();
    }
}