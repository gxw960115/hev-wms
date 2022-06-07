package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.sap.conn.jco.*;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/23 13:46
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,JCoDestinationManager.class})
public class DownloadDnFromSapTest {

    private DownloadDnFromSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private StgDnDownDAO stgDnDownDAOMock;

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
            function = jCoRepository.getFunction("ZSD_HEV_WMS_DOWNLOAD_DN");
        } catch (JCoException e) {
            e.printStackTrace();
        }
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        stgDnDownDAOMock = EasyMock.createMock(StgDnDownDAO.class);
        clientImplMock = new DownloadDnFromSap(operationLogDAOMock,stgDnDownDAOMock,"2018-04-23","2019-05-24","111");
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
        EasyMock.expect(stgDnDownDAOMock.getStgDnDownListByParam(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<StgDnDownDTO>()).times(1);
        EasyMock.expect(stgDnDownDAOMock.ifScanningStart(
                (StgDnDownDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        stgDnDownDAOMock.bankupDeletedItems((StgDnDownDTO)EasyMock.anyObject());
        stgDnDownDAOMock.deleteByDnItems((StgDnDownDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(2);
        EasyMock.replay(stgDnDownDAOMock);
        clientImplMock.exchangeWithSap();
    }
}