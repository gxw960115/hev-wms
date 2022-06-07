package com.haier.hevwms.security.service.impl;

import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSearchModel;
import com.haier.openplatform.log.domain.OperationLog;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 11:15
 * @Description:
 */
public class OperationLogServiceImplTest {

    private OperationLogDAO operationLogDAO;
    private OperationLogServiceImpl operationLogService = new OperationLogServiceImpl();

    @Before
    public void init(){
        operationLogDAO = EasyMock.createMock(OperationLogDAO.class);
        operationLogService.setOperationLogDAO(operationLogDAO);
    }

    @Test
    public void save() {
        operationLogDAO.save((OperationLog)EasyMock.anyObject());
        EasyMock.expectLastCall();
        EasyMock.replay(operationLogDAO);
        operationLogService.save(new OperationLog());
    }

    @Test
    public void searchOperationLog() {
        OperationLogSearchModel logSearchModel = new OperationLogSearchModel();
        EasyMock.expect(operationLogDAO.searchOperationLog(
                logSearchModel)
        ).andReturn(new ArrayList<OperationLog>());
        EasyMock.expect(operationLogDAO.searchOperationLogCount(
                logSearchModel)
        ).andReturn(1L);
        EasyMock.replay(operationLogDAO);
        operationLogService.searchOperationLog(logSearchModel);
    }
}