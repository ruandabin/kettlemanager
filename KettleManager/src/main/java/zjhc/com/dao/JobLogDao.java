package zjhc.com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import zjhc.com.entity.JobLog;

/***
 * »’÷æ≤È—Ødao
 * @author rdb
 *
 */
public interface JobLogDao {

	public List<JobLog> listJobLog(Map<String,Object> map);
	
	public Long count(Map<String,Object> map);
	
	public List<JobLog> listHisLog(Map<String,Object> map);
	
	public Long countHis(Map<String,Object> map);
	
	public List<JobLog> listAllJobLog();

}
