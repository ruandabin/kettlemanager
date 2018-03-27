package jobMapTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import zjhc.com.entity.JobLog;
import zjhc.com.entity.JobMap;
import zjhc.com.service.JobLogService;
import zjhc.com.service.JobMapService;

public class JobTest {

	private ApplicationContext ac;
	
	@Before
	public void getAppCon(){
		ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void findJobTest(){
//		JobMapService jobMapService=(JobMapService) ac.getBean("jobMapService");
//		List<JobMap> l=jobMapService.findJobMap();
//		String jsonStr=JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss");
//		System.out.println(jsonStr);
	}
	
	@Test
	public void findJobLogTest(){
//		JobLogService jobLogService=(JobLogService) ac.getBean("jobLogService");
//		List<JobLog> l= jobLogService.findLog();
//		String jsonStr=JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss");
//		System.out.println(jsonStr);
	}
	
}
