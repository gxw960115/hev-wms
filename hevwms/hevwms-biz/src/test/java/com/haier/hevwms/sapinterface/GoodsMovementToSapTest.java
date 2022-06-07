package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.transfer.dao.OdsTransferInfoDAO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferInfoDTO;
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
 * @Date: 2019/4/28 09:55
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,JCoDestinationManager.class})
public class GoodsMovementToSapTest {

    private String i = "1111111111111";
    private GoodsMovementToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsTransferInfoDAO odsTransferInfoDAOMock;

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
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsTransferInfoDAOMock = EasyMock.createMock(OdsTransferInfoDAO.class);
        clientImplMock = new GoodsMovementToSap(i,operationLogDAOMock,odsTransferInfoDAOMock);
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
        List<OdsTransferInfoDTO> list = new ArrayList<OdsTransferInfoDTO>();
        OdsTransferInfoDTO odsTransferInfoDTO = new OdsTransferInfoDTO();
        odsTransferInfoDTO.setGrLocation("11111");
        odsTransferInfoDTO.setGiLocation("22222");
        list.add(odsTransferInfoDTO);
        EasyMock.expect(odsTransferInfoDAOMock.searchOdsTransferInfoList(
                (OdsTransferInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        odsTransferInfoDAOMock.updatePostResult((OdsTransferInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsTransferInfoDAOMock);
        clientImplMock.exchangeWithSap();
    }
}