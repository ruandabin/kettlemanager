package zjhc.com.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

/***
 * 
 * @author rdv job和trigger的名称相同，存放在不同的组里 默认只支持cron表达式
 */
public class QuartzManager {
	private static String JOB_GROUP_NAME = "DEFAULT_JOBGROUP_NAME";
	private static String TRIGGER_GROUP_NAME = "DEFAULT_TRIGGERGROUP_NAME";

	/***
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
	 * @param sched
	 *            调度器
	 * @param jobName
	 *            job名称
	 * @param clazz
	 *            job
	 * @param time
	 *            cron表达式
	 */
	public static void addJob(Scheduler sched, String jobName,
			@SuppressWarnings("rawtypes") Class jobClass, String time) {
		try {
			// 获取JobDetail
			@SuppressWarnings("unchecked")
			JobDetail job = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, JOB_GROUP_NAME).build();
			// 获取Trigger
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(jobName, TRIGGER_GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(time))
					.build();
			// 配置调度器
			sched.scheduleJob(job, trigger);

			// 启动调度器
			if (sched.isShutdown()) {
				sched.start();
			}
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	// 添加一个定时任务
	public static void addJob(Scheduler sched, String jobName,
			String jobGroupName, String triggerName, String triggerGroupName,
			@SuppressWarnings("rawtypes") Class jobClass, String time) {
		try {
			// 获取JobDetail
			@SuppressWarnings("unchecked")
			JobDetail job = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			// 获取Trigger
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(triggerName, triggerGroupName)
					.withSchedule(CronScheduleBuilder.cronSchedule(time))
					.build();
			// 配置调度器
			sched.scheduleJob(job, trigger);

			// 启动调度器
			if (sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void modifyJobTime(Scheduler sched, String jobName,
			String time) {
		try {

			CronTrigger trigger = (CronTrigger) sched.getTrigger(TriggerKey
					.triggerKey(jobName, TRIGGER_GROUP_NAME));
			if(trigger == null){
				return;
			}
			
			String oldTime = trigger.getCronExpression();
			if(!oldTime.equalsIgnoreCase(time)){
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
