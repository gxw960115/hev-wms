package com.haier.hevwms.sapinterface;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.so.dao.OdsSoGrInfoDAO;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
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
public class PostPoToSapTest {

    private String[] i = {"1111"};
    private PostPoToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsPoGrInfoDAO odsPoGrInfoDAOMock;
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
        odsPoGrInfoDAOMock = EasyMock.createMock(OdsPoGrInfoDAO.class);
        clientImplMock = new PostPoToSap(i,operationLogDAOMock,odsPoGrInfoDAOMock);
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
        List<OdsPoGrInfoDTO> list = new ArrayList<OdsPoGrInfoDTO>();
        OdsPoGrInfoDTO odsPoGrInfoDTO = new OdsPoGrInfoDTO();
        odsPoGrInfoDTO.setBatchNo("111");
        list.add(odsPoGrInfoDTO);
        EasyMock.expect(odsPoGrInfoDAOMock.searchList(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        clientImplMock.exchangeWithSap();
    }
}