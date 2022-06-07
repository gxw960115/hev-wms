package com.haier.openplatform.wms.so.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.haier.hevwms.so.service.OdsSoScanInfoService;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.so.dto.OdsSoScanInfoDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: mahuansen
 * @Date: 2019/3/22 14:36
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,SpringApplicationContextHolder.class})
public class OdsSoScanInfoServiceClientImplTest {

    private OdsSoScanInfoServiceClientImpl clientImplMock = new OdsSoScanInfoServiceClientImpl();
    private OdsSoScanInfoService odsSoScanInfoServiceMock;
    private DruidDataSource datasource;
    private StgDnDownService stgDnDownService;
    private DruidPooledConnection connection;

    @Before
    public void init(){
        connection = EasyMock.createMock(DruidPooledConnection.class);
        datasource = EasyMock.createMock(DruidDataSource.class);
        stgDnDownService = EasyMock.createMock(StgDnDownService.class);
        odsSoScanInfoServiceMock = EasyMock.createMock(OdsSoScanInfoService.class);
        clientImplMock.setOdsSoScanInfoService(odsSoScanInfoServiceMock);
        PowerMockito.mockStatic(UserUtil.class,SpringApplicationContextHolder.class);
        PowerMockito.when(SpringApplicationContextHolder.getBean("dataSource")).thenReturn(datasource);
        PowerMockito.when(SpringApplicationContextHolder.getBean("stgDnDownService")).thenReturn(stgDnDownService);
    }

    @Test
    public void searchOdsPoScanInfoByPage() {
        EasyMock.expect(odsSoScanInfoServiceMock.searchOdsSoScanInfoByPage(
                (Pager<OdsSoScanInfoDTO>)EasyMock.anyObject(),
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new Pager<OdsSoScanInfoDTO>()).times(1);
        EasyMock.replay(odsSoScanInfoServiceMock);
        clientImplMock.searchOdsPoScanInfoByPage(1L,10L,new OdsSoScanInfoDTO());
    }

    @Test
    public void getExportAmount() {
        EasyMock.expect(odsSoScanInfoServiceMock.getExportAmount(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(1L).times(1);
        EasyMock.replay(odsSoScanInfoServiceMock);
        clientImplMock.getExportAmount(new OdsSoScanInfoDTO());
    }

    @Test
    public void getOdsPoScanInfos() {
        EasyMock.expect(odsSoScanInfoServiceMock.getOdsSoScanInfos(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ArrayList<OdsSoScanInfoDTO>()).times(1);
        EasyMock.replay(odsSoScanInfoServiceMock);
        clientImplMock.getOdsPoScanInfos(new OdsSoScanInfoDTO());
    }

    @Test
    public void printSoDetail() {
        List<StgDnDownDTO> list = new ArrayList<StgDnDownDTO>();
        List<String> l = new ArrayList<String>();
        String testloc = "111";
        l.add(testloc);
        StgDnDownDTO stgDnDownDTO = new StgDnDownDTO();
        stgDnDownDTO.setBilling("111");
        list.add(stgDnDownDTO);
        try {
            EasyMock.expect(datasource.getConnection()).andReturn(connection);
            EasyMock.expect(stgDnDownService.getStgDnDownsByParam(
                    (StgDnDownDTO)EasyMock.anyObject())
            ).andReturn(list);
            EasyMock.expect(stgDnDownService.getLocationNameByDnNo(
                    (String)EasyMock.anyObject())
            ).andReturn(l);
            EasyMock.replay(datasource);
            EasyMock.replay(stgDnDownService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        clientImplMock.printSoDetail("",new HashMap<String, Object>());
    }

    @Test
    public void updateOldBarcode() {
        EasyMock.expect(odsSoScanInfoServiceMock.updateOldBarcode(
                (OdsSoScanInfoDTO)EasyMock.anyObject())
        ).andReturn(new ExecuteResult<OdsSoScanInfoDTO>()).times(1);
        EasyMock.replay(odsSoScanInfoServiceMock);
        clientImplMock.updateOldBarcode(new OdsSoScanInfoDTO());
    }
}