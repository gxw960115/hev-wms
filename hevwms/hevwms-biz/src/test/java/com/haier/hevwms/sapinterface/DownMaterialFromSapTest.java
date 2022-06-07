package com.haier.hevwms.sapinterface;

import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.security.dao.OperationLogDAO;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/29 09:35
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class DownMaterialFromSapTest {

    private DownMaterialFromSap clientImplMock = null;
    private OperationLogDAO operationLogDAOMock;
    private MdMatInfoDAO mdMatInfoDAOMock;

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        operationLogDAOMock = EasyMock.createMock(OperationLogDAO.class);
        mdMatInfoDAOMock = EasyMock.createMock(MdMatInfoDAO.class);
        clientImplMock = new DownMaterialFromSap("AAA",
                "2019-04-29",
                "2019-04-30",
                "2019-04-29",
                "2019-04-29",
                operationLogDAOMock,
                mdMatInfoDAOMock);
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
        clientImplMock.exchangeWithSap();
    }
}