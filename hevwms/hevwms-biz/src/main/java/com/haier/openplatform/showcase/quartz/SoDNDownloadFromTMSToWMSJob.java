package com.haier.openplatform.showcase.quartz;

import com.haier.hevwms.sapinterface.DownloadDnFromSap;
import com.haier.hevwms.sapinterface.DownloadSoDnFromTMS;
import com.haier.hevwms.sapinterface.DownloadStoDnFromTMS;
import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

public class SoDNDownloadFromTMSToWMSJob implements Job {


    private static final Logger logger = LoggerFactory.getLogger(SoDNDownloadFromTMSToWMSJob.class);


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("DN Download Job Start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));

        Calendar cal = Calendar.getInstance();
        //下载的结束日期
        String end = DateFormatUtils.format(cal, "yyyyMMdd");
        cal.add(Calendar.DATE, -1);
        //下载的开始日期
        String start = DateFormatUtils.format(cal, "yyyyMMdd");

        DownloadSoDnFromTMS sap = new DownloadSoDnFromTMS("", start, end, "System");
        sap.exchangeWithTMS();

        DownloadStoDnFromTMS tms = new DownloadStoDnFromTMS( start, end, "","System");
        tms.exchangeWithTMS();

        logger.info("DN Download Job End:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
    }
}
