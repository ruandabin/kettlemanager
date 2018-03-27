package zjhc.com.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zjhc.com.entity.DataGrid;
import zjhc.com.entity.JobMap;
import zjhc.com.entity.PageBean;
import zjhc.com.entity.Result;
import zjhc.com.service.JobMapService;
import zjhc.com.utils.StringUtil;


@Controller
@RequestMapping("/admin/jobMap")
public class JobMapController {

	Logger log = LoggerFactory.getLogger(JobMapController.class);
	@Resource
	private JobMapService jobMapService;
	
	
	@RequestMapping(value="/listJobMap",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listJobMap(int page,int rows,JobMap jobMap){
		DataGrid dg = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		pageBean.setPageSize(rows);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("jobName", StringUtil.formatLike(jobMap.getJobName()));
		map.put("start",pageBean.getStart() );
		map.put("size",pageBean.getPageSize());
		List<JobMap> l=jobMapService.listJobMap(map);
		dg.setRows(l);
		dg.setTotal(jobMapService.count(map));
		String json_str=JSON.toJSONStringWithDateFormat(dg, "yyyy-MM-dd HH:mm:ss");
		log.info("---------查询到的job List--------->"+json_str);
		return json_str;
	}
	
	@RequestMapping(value="/saveJobMap",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveJobMap(JobMap jobMap){
		int resultTotal = 0;
		Result result = new Result();
		try {
			resultTotal = jobMapService.addJobMap(jobMap);
			result.setSuccess("true");
			result.setMsg("添加成功");	
			log.info("---------添加resultTotal--------->"+resultTotal);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess("false");
			result.setMsg(e.getMessage());	
		}
		String json_str=JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
		log.info("---------存储job结果--------->"+json_str);
		return json_str ;
	}
	
	@RequestMapping(value="/deleteJobMap",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteJobMap(String ids){
		int resultTotal = 0;
		Result result = new Result();
		String []idsStr=ids.split(",");
		try {
			for(int i=0;i<idsStr.length;i++){
				resultTotal=jobMapService.deleteJobMap(Integer.parseInt(idsStr[i]));
			}
			result.setSuccess("true");
			result.setMsg("删除成功");
			log.info("---------删除resultTotal--------->"+resultTotal);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess("false");
			result.setMsg(e.getMessage());	
		}
		String json_str=JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
		log.info("---------删除job结果--------->"+json_str);
		return json_str ;
	}
	
	@RequestMapping(value="/updateJobMap",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateJobMap(JobMap jobMap){
		
		int resultTotal = 0;
		Result result = new Result();
		try {
	        resultTotal=jobMapService.updateJobMap(jobMap);
			result.setSuccess("true");
			result.setMsg("修改成功");	
			log.info("---------修改resultTotal--------->"+resultTotal);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess("false");
			result.setMsg(e.getMessage());	
		}
		String json_str=JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
		log.info("---------删除job结果--------->"+json_str);
		return json_str ;
	}
}
