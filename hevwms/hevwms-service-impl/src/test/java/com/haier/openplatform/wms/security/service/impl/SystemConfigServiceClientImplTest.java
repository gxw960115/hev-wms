package com.haier.openplatform.wms.security.service.impl;

import com.haier.hevwms.security.service.SystemConfigService;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/1 17:09
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class SystemConfigServiceClientImplTest {

    private SystemConfigServiceClientImpl clientImplMock = new SystemConfigServiceClientImpl();
    private SystemConfigService systemConfigServiceMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        systemConfigServiceMock = EasyMock.createMock(SystemConfigService.class);
        clientImplMock.setSystemConfigService(systemConfigServiceMock);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void fifoConfig() {
        systemConfigServiceMock.fifoConfig((String)EasyMock.anyObject(),(String)EasyMock.anyObject());
        EasyMock.expectLastCall().times(1);
        EasyMock.replay(systemConfigServiceMock);
        clientImplMock.fifoConfig("1","1");
    }
}