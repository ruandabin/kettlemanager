package zjhc.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zjhc.com.dao.JobMapDao;
import zjhc.com.entity.JobMap;
import zjhc.com.service.JobMapService;

@Service("jobMapService")
public class JobMapServiceImpl implements JobMapService {

	@Resource
	private JobMapDao jobMapDao;

	public int addJobMap(JobMap jobMap) {
		// TODO Auto-generated method stub
		return jobMapDao.addJobMap(jobMap);
	}

	public int deleteJobMap(Integer id) {
		// TODO Auto-generated method stub
		return jobMapDao.deleteJobMap(id);
	}

	public List<JobMap> listJobMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jobMapDao.listJobMap(map);
	}

	public Long count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jobMapDao.count(map);
	}

	public int updateJobMap(JobMap jobMap) {
		// TODO Auto-generated method stub
		return jobMapDao.updateJobMap(jobMap);
	}

}
