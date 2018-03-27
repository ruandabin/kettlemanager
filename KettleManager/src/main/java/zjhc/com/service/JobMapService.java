package zjhc.com.service;

import java.util.List;
import java.util.Map;

import zjhc.com.entity.JobMap;

public interface JobMapService {
	
	public List<JobMap> listJobMap(Map<String,Object> map);
	
	public Long count(Map<String,Object> map);
	
	public int addJobMap(JobMap jobMap);
	
	public int deleteJobMap(Integer id);
	
	public int updateJobMap(JobMap jobMap);

}
