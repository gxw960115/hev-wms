package com.haier.openplatform.showcase.jmx;

/**
 * 用户暴露对quartz的管理接口,以实现运行期调用
 * @author 01311917
 *
 */
public interface QuartzExposeMethodInterface {

	/**
	 * 判断定时任务是否在运行
	 * @return
	 */
	public boolean isRunning();   
	/**
	 * 判断任务是否支持集群化调度
	 * @return
	 */
	public boolean isJobClustered();
	/**
	 * 获取所有的triggerkey
	 * @return
	 */
	public String getTriggerKeys();
	/**
	 * 暂停某一个trigger,triggerKey为空则暂停所有
	 * @param triggerKey
	 * @return
	 */
	public String jobPause(String triggerKey);
	/**
	 * 唤醒暂停的trigger,triggerKey为空则唤醒所有trigger
	 * @param triggerKey
	 * @return
	 */
	public String jobResume(String triggerKey);
	/**
	 * job 重新初始化
	 * @return
	 */
    public String jobReschedule();  
    /**
     * 获取job的状态
     * @return
     */
    public String getJobStatus();
    /**
     * 重置cron表达式
     * @param triggerKey
     * @param cron
     * @return
     */
    public String resetJobCron(String triggerKey,String cron);
}
