package com.haier.openplatform.showcase.jmx.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.openplatform.showcase.jmx.QuartzExposeMethodInterface;

/**
 * 运行期管理quartz接口实现
 * @author 01311917
 *
 */
public class QuartzConfiguration implements QuartzExposeMethodInterface{
	
	private static final Logger LOG = LoggerFactory.getLogger(QuartzConfiguration.class);

	private Scheduler scheduler;

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	/**
	 * 判断定时任务是否在运行
	 * @return
	 */
	@Override
	public boolean isRunning(){
		try {
			return !scheduler.isShutdown();
		} catch (SchedulerException e) {
			LOG.error("",e);
			return false;
		}
	}
	
	/**
	 * 获取所有的triggerkey
	 * @return
	 */
	@Override
	public String getTriggerKeys(){
		StringBuilder triggerGroupBuilder = new StringBuilder();
		Set<TriggerKey> triggerKeys = getTriggerKeySet();
		for(TriggerKey tk : triggerKeys){
			triggerGroupBuilder.append(tk.toString());
			triggerGroupBuilder.append("\r\n");
		}
		return triggerGroupBuilder.toString();
	}
	
	private Set<TriggerKey> getTriggerKeySet(){
		Set<TriggerKey> triggerKeySet = new HashSet<TriggerKey>();
		try{
			List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
			if(triggerGroupNames == null || triggerGroupNames.isEmpty()){
				return triggerKeySet;
			}
			for(String triggerGroupName : triggerGroupNames){
				GroupMatcher<TriggerKey> triggerGroup = GroupMatcher.triggerGroupEquals(triggerGroupName);
				triggerKeySet.addAll(scheduler.getTriggerKeys(triggerGroup));
			}
			return triggerKeySet;
		}catch (SchedulerException e) {
			return null;
		}
	}
	
	/**
	 * 暂停某一个trigger,triggerKey为空则暂停所有
	 * @param triggerKey
	 * @return
	 */
	@Override
	public String jobPause(String triggerKey){
		try{
			if(StringUtils.isEmpty(triggerKey)){
				scheduler.pauseAll();
				return "pause all job success!";
			}
			Set<TriggerKey> triggerKeys = getTriggerKeySet();
			for(TriggerKey tmpTriggerKey : triggerKeys){
				if(!triggerKey.equals(tmpTriggerKey.toString())){
					continue;
				}
				scheduler.pauseTrigger(tmpTriggerKey);
				return "pause " + triggerKey + " success!";
			}
			return "triggerKey " + triggerKey + " not exist,pause failed!";
		}catch (SchedulerException e) {
			return "pause exception,error=" + e.getMessage();
		}
	}
	
	/**
	 * 唤醒暂停的trigger,triggerKey为空则唤醒所有trigger
	 * @param triggerKey
	 * @return
	 */
	@Override
	public String jobResume(String triggerKey){
		try{
			if(StringUtils.isEmpty(triggerKey)){
				scheduler.resumeAll();
				return "resume all job success!";
			}
			Set<TriggerKey> triggerKeys = getTriggerKeySet();
			for(TriggerKey tmpTriggerKey : triggerKeys){
				if(!triggerKey.equals(tmpTriggerKey.toString())){
					continue;
				}
				scheduler.resumeTrigger(tmpTriggerKey);
				return "resume " + triggerKey + " success!";
			}
			return "triggerKey " + triggerKey + " not exist,resume failed!";
		}catch (SchedulerException e) {
			return "resume exception,error=" + e.getMessage();
		}
	}
	
	/**
	 * job 重新初始化
	 * @return
	 */
	@Override
	public String jobReschedule(){
		try {
			if(scheduler.isShutdown()){
				return "quartz already shutdown,start failed!";
			}
			Set<TriggerKey> triggerKeys = getTriggerKeySet();
			for(TriggerKey tk : triggerKeys){
				Trigger trigger = scheduler.getTrigger(tk);
				JobKey jobKey = trigger.getJobKey();
				JobDetail jobDetail = scheduler.getJobDetail(jobKey);
				scheduler.unscheduleJob(tk);
				scheduler.scheduleJob(jobDetail, trigger);
			}
		} catch (SchedulerException e) {
			LOG.error("",e);
			return "reschedule exception,exception=" + e.getMessage();
		}
		return "reschedule successful!";
	}
	
	@Override
	public String getJobStatus(){
		StringBuilder builder = new StringBuilder();
		try{
			Set<TriggerKey> triggerKeys = getTriggerKeySet();
			for(TriggerKey tk : triggerKeys){
				TriggerState state = scheduler.getTriggerState(tk);
				builder.append(tk.toString());
				builder.append(":");
				builder.append(state.name());
				builder.append("\r\n");
			}
		}catch (SchedulerException e) {
			LOG.error("",e);
			return "getJobStatus exception,exception=" + e.getMessage(); 
		}
		return builder.toString();
	}
	
	@Override
	public boolean isJobClustered(){
		try {
			return scheduler.getMetaData().isJobStoreClustered();
		} catch (SchedulerException e) {
			return false;
		}
	}
	
	@Override
	public String resetJobCron(String triggerKey,String cron){
		try{
			Set<TriggerKey> triggerKeys = getTriggerKeySet();
			for(TriggerKey tk : triggerKeys){
				if(!triggerKey.equals(tk.toString())){
					continue;
				}
				CronTriggerImpl cronTrigger = (CronTriggerImpl)scheduler.getTrigger(tk);
				cronTrigger.setCronExpression(cron);
				scheduler.rescheduleJob(tk, cronTrigger);
			}
			return "reset job cron success,trigger=" + triggerKey;
		}catch (ParseException e) {
			LOG.error("",e);
			return "cron set error,exception=" + e.getMessage(); 
		}catch (SchedulerException e) {
			LOG.error("",e);
			return "resetJobCron exception,exception=" + e.getMessage(); 
		}
	}
}
