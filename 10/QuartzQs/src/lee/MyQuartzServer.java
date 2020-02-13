package lee;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class MyQuartzServer
{
	public static void main(String[] args)
	{
		MyQuartzServer server = new MyQuartzServer();
		try
		{
			server.startScheduler();
		}
		catch (SchedulerException ex)
		{
			ex.printStackTrace();
		}
	}
	// ִ�е���
	private void startScheduler() throws SchedulerException
	{
		// ʹ�ù�������������ʵ��
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// ��Jobʵ���ഴ��JobDetailʵ��
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
			.withIdentity("fkJob").build();
		// ����Trigger���󣬸ö������һ���򵥵ĵ�����
		// ָ���������ظ�����50�Σ�ÿ�μ��60��
		Trigger trigger = TriggerBuilder.newTrigger()
             .withIdentity(TriggerKey.triggerKey("fkTrigger" , "fkTriggerGroup"))
             .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                 .withIntervalInSeconds(60)
                 .repeatForever())
             .startNow()
             .build();

		// ����������ҵ��trigger��������
		scheduler.scheduleJob(jobDetail, trigger );
		// ��ʼ����
		scheduler.start();
	}
}