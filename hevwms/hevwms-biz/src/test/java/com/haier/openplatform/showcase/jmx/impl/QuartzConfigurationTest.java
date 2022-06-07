package com.haier.openplatform.showcase.jmx.impl;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:17
 * @Description:
 */
public class QuartzConfigurationTest {

    private Scheduler scheduler;
    private SchedulerMetaData schedulerMetaData;
    private QuartzConfiguration quartzConfiguration = new QuartzConfiguration();

    @Before
    public void init(){
        scheduler = EasyMock.createMock(Scheduler.class);
        schedulerMetaData =EasyMock.createMock(SchedulerMetaData.class);
        quartzConfiguration.setScheduler(scheduler);
    }

    @Test
    public void isRunning() {
        quartzConfiguration.isRunning();
    }

    @Test
    public void getTriggerKeys() {
        quartzConfiguration.getTriggerKeys();
    }

    @Test
    public void jobPause() {
        quartzConfiguration.jobPause("111");
    }

    @Test
    public void jobResume() {
        quartzConfiguration.jobResume("111");
    }

    @Test
    public void getJobStatus() {
        quartzConfiguration.getJobStatus();
    }


    @Test
    public void resetJobCron() {
        quartzConfiguration.resetJobCron("11","11");
    }
}