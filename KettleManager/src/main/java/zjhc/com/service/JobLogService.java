package zjhc.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import zjhc.com.entity.JobLog;
import zjhc.com.entity.JobMap;


public interface JobLogService {

	public List<JobLog> listJobLog(Map<String,Object> map);
	
	public List<JobLog> listAllJobMap();
	
	public Long count(Map<String,Object> map);
	
	public List<JobLog> listJobHisLog(Map<String,Object> map);
	
	public Long countHis(Map<String,Object> map);
	
	
}
