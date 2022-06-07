package com.haier.hevwms.sapinterface;

import com.haier.hevwms.po.dao.OdsPoGrInfoDAO;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.AbstractList;
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
public class ReversePoToSapTest {

    private ReversePoToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsPoGrInfoDAO odsPoGrInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        String[] i = {"1111111111111"};
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsPoGrInfoDAOMock = EasyMock.createMock(OdsPoGrInfoDAO.class);
        clientImplMock = new ReversePoToSap(i,operationLogDAOMock,odsPoGrInfoDAOMock);
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
        odsPoGrInfoDTO.setBatchNo("1111");
        list.add(odsPoGrInfoDTO);
        EasyMock.expect(odsPoGrInfoDAOMock.searchList(
                (OdsPoGrInfoDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        odsPoGrInfoDAOMock.updateReverseResult((OdsPoGrInfoDTO)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(odsPoGrInfoDAOMock);
        clientImplMock.exchangeWithSap();

    }
}