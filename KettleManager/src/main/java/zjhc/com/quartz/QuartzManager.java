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
 * @author rdv job��trigger��������ͬ������ڲ�ͬ������ Ĭ��ֻ֧��cron���ʽ
 */
public class QuartzManager {
	private static String JOB_GROUP_NAME = "DEFAULT_JOBGROUP_NAME";
	private static String TRIGGER_GROUP_NAME = "DEFAULT_TRIGGERGROUP_NAME";

	/***
	 * @Description: ���һ����ʱ����ʹ��Ĭ�ϵ�������������������������������
	 * @param sched
	 *            ������
	 * @param jobName
	 *            job����
	 * @param clazz
	 *            job
	 * @param time
	 *            cron���ʽ
	 */
	public static void addJob(Scheduler sched, String jobName,
			@SuppressWarnings("rawtypes") Class jobClass, String time) {
		try {
			// ��ȡJobDetail
			@SuppressWarnings("unchecked")
			JobDetail job = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, JOB_GROUP_NAME).build();
			// ��ȡTrigger
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(jobName, TRIGGER_GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(time))
					.build();
			// ���õ�����
			sched.scheduleJob(job, trigger);

			// ����������
			if (sched.isShutdown()) {
				sched.start();
			}
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	// ���һ����ʱ����
	public static void addJob(Scheduler sched, String jobName,
			String jobGroupName, String triggerName, String triggerGroupName,
			@SuppressWarnings("rawtypes") Class jobClass, String time) {
		try {
			// ��ȡJobDetail
			@SuppressWarnings("unchecked")
			JobDetail job = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			// ��ȡTrigger
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(triggerName, triggerGroupName)
					.withSchedule(CronScheduleBuilder.cronSchedule(time))
					.build();
			// ���õ�����
			sched.scheduleJob(job, trigger);

			// ����������
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
