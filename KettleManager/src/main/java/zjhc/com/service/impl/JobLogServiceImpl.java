package zjhc.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zjhc.com.dao.JobLogDao;
import zjhc.com.entity.JobLog;
import zjhc.com.service.JobLogService;

@Service("jobLogService")
public class JobLogServiceImpl implements JobLogService {

	@Resource
	private JobLogDao jobLogDao;
	
	public List<JobLog> listJobLog(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return jobLogDao.listJobLog(map);
	}

	public Long count(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return jobLogDao.count(map);
	}

	public List<JobLog> listJobHisLog(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jobLogDao.listHisLog(map);
	}

	public Long countHis(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return jobLogDao.countHis(map);
	}

	public List<JobLog> listAllJobMap() {
		// TODO Auto-generated method stub
		return jobLogDao.listAllJobLog();
	}

}
