package com.haier.openplatform.showcase.quartz;

import io.terminus.pampas.common.UserUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.quartz.JobExecutionContext;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/14 09:41
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {UserUtil.class,Calendar.class,DateFormatUtils.class})
public class DNDownloadFromSAPToWMSJobTest {
}