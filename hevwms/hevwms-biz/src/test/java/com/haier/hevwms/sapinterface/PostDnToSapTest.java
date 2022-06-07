package com.haier.hevwms.sapinterface;

import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
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
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/26 11:18
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,JCoDestinationManager.class})
public class PostDnToSapTest {

    private String[] i = {"1111"};
    private PostDnToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsSoGrInfoDAO odsSoGrInfoDAOMock;

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
        odsSoGrInfoDAOMock = EasyMock.createMock(OdsSoGrInfoDAO.class);
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        clientImplMock = new PostDnToSap(i,operationLogDAOMock,odsSoGrInfoDAOMock);
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
        OdsSoGrInfoDTO odsPoGrInfoDTO = new OdsSoGrInfoDTO();
        odsPoGrInfoDTO.setBatchNo("111");
        list.add(odsPoGrInfoDTO);
        EasyMock.expect(odsSoGrInfoDAOMock.getOdsSoGrInfoListByOGP(
                (OdsSoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        odsSoGrInfoDAOMock.updatePostResult((OdsSoGrInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        operationLogDAOMock.save((OperationLogSaveModel)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(operationLogDAOMock);
        EasyMock.replay(odsSoGrInfoDAOMock);
        clientImplMock.exchangeWithSap();
    }
}