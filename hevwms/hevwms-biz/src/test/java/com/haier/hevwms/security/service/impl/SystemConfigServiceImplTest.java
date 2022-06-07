package com.haier.hevwms.security.service.impl;

import com.haier.hevwms.security.dao.SystemConfigDAO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 11:15
 * @Description:
 */
public class SystemConfigServiceImplTest {

    private SystemConfigDAO systemConfigDAO;
    private SystemConfigServiceImpl systemConfigService = new SystemConfigServiceImpl();

    @Before
    public void init(){
        systemConfigDAO = EasyMock.createMock(SystemConfigDAO.class);
        systemConfigService.setSystemConfigDAO(systemConfigDAO);
    }

    @Test
    public void fifoConfig() {
        systemConfigDAO.fifoConfig(
                (String)EasyMock.anyObject(),
                (String)EasyMock.anyObject()
        );
        EasyMock.expectLastCall();
        EasyMock.replay(systemConfigDAO);
        systemConfigService.fifoConfig("11","11");
    }
}