package com.haier.hevwms.sapinterface;

import com.haier.hevwms.consume.dao.OdsConsumeOrderDAO;
import com.haier.hevwms.sapinterface.config.SapConnection;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.consume.dto.OdsConsumeOrderDTO;
import com.sap.conn.jco.*;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/23 13:35
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,JCoDestinationManager.class})
public class ConsumingToSapTest {

    private ConsumingToSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private OdsConsumeOrderDAO odsConsumeOrderDAOMock;
    private JCoDestination destination;
    private JCoFunction function;

    @Before
    public void init(){
        try {
            destination =JCoDestinationManager.getDestination(SapConnection.ABAP_MS);
        } catch (JCoException e) {
            e.printStackTrace();
        }
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        odsConsumeOrderDAOMock = EasyMock.createMock(OdsConsumeOrderDAO.class);
        function = EasyMock.createMock(JCoFunction.class);
        clientImplMock = new ConsumingToSap(operationLogDAOMock,odsConsumeOrderDAOMock);
        PowerMockito.mockStatic(UserUtil.class,JCoDestinationManager.class);
        try {
            PowerMockito.when(JCoDestinationManager.getDestination((String)EasyMock.anyObject())).thenReturn(destination);
        } catch (JCoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exchangeWithSap() {
        List<OdsConsumeOrderDTO> list = new ArrayList<OdsConsumeOrderDTO>();
        OdsConsumeOrderDTO odsConsumeOrderDTO = new OdsConsumeOrderDTO();
        odsConsumeOrderDTO.setConsumeNo("111");
        list.add(odsConsumeOrderDTO);
        try {
            EasyMock.expect(destination.getRepository().getFunction((String)EasyMock.anyObject())).andReturn(function);
        } catch (JCoException e) {
            e.printStackTrace();
        }
        EasyMock.expect(odsConsumeOrderDAOMock.getOdsConsumeOrderListByParm(
                (OdsConsumeOrderDTO)EasyMock.anyObject())
        ).andReturn(list).times(1);
        EasyMock.replay(odsConsumeOrderDAOMock);

        clientImplMock.exchangeWithSap();
    }
}