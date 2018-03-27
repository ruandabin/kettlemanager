package zjhc.com.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zjhc.com.entity.DataGrid;
import zjhc.com.entity.Echarts;
import zjhc.com.entity.FileTree;
import zjhc.com.entity.JobLog;
import zjhc.com.entity.PageBean;
import zjhc.com.entity.Result;
import zjhc.com.service.JobLogService;
import zjhc.com.utils.StringUtil;

@Controller
@RequestMapping("/admin/jobLog")
public class JobLogController {
	
	private final static Logger logger = LoggerFactory.getLogger(JobLogController.class);
	
	@Resource
	private JobLogService jobLogService;
	
	@RequestMapping(value="/listJobLog",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listJobLog(int page,int rows,JobLog jobLog){
		DataGrid dg = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		pageBean.setPageSize(rows);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("jobName", StringUtil.formatLike(jobLog.getJobName()));
		map.put("start",pageBean.getStart() );
		map.put("size",pageBean.getPageSize());
		List<JobLog> l=jobLogService.listJobLog(map);
		dg.setRows(l);
		dg.setTotal(jobLogService.count(map));
		String json_str=JSON.toJSONStringWithDateFormat(dg, "yyyy-MM-dd HH:mm:ss");
		return json_str;
		
	}
	
	@RequestMapping(value="/findLog",produces="text/html;charset=UTF-8")
	public void findLog(String path,HttpServletResponse response) throws IOException{
		 File f = new File(path);
		 //File f = new File("C:/kms8.log");
		if(f.exists()){
			FileInputStream is = new FileInputStream(f);
			byte[] buf=new byte[2048];
			int temp=-1;
			while((temp=is.read(buf))!=-1){
				
				response.getOutputStream().write(buf,0,temp);
				
			}
			response.getOutputStream().flush();
			
		}	
	}
	
	@RequestMapping(value="/listJobHisLog",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listJobHisLog(int page,int rows,JobLog jobLog){
		DataGrid dg = new DataGrid();
		PageBean pageBean = new PageBean();
		pageBean.setPage(page);
		pageBean.setPageSize(rows);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("jobName", StringUtil.formatLike(jobLog.getJobName()));
		map.put("start",pageBean.getStart() );
		map.put("size",pageBean.getPageSize());
		List<JobLog> l=jobLogService.listJobHisLog(map);
		dg.setRows(l);
		dg.setTotal(jobLogService.countHis(map));
		String json_str=JSON.toJSONStringWithDateFormat(dg, "yyyy-MM-dd HH:mm:ss");
		return json_str;
		
	}
	
	
	@RequestMapping(value="/downLog",produces="text/html;charset=UTF-8")
	public void downLog(String path,HttpServletResponse response) throws IOException{
		 File f = new File(path);
		 //File f = new File("C:/kms8.log");
		String fileName = f.getName();
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		if(f.exists()){
			FileInputStream is = new FileInputStream(f);
			byte[] buf=new byte[2048];
			int temp=-1;
			while((temp=is.read(buf))!=-1){
				
				response.getOutputStream().write(buf,0,temp);
				
			}
			response.getOutputStream().flush();
			is.close();	
		}	
	}

	@RequestMapping(value = "/listLogFile", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String listLogFile(FileTree ft,String path) {
		List<FileTree> list = new LinkedList<FileTree>();
		String filePath = new String();
		if (ft.getId()==null || ft.getId().equals("")) {
			ft.setId(path);
			ft.setText("全部文件");
			ft.setState("closed");
			list.add(ft);
		}else {
			filePath = ft.getId();
			File f = new File(filePath);
			if (f.exists()) {
				File[] fs = f.listFiles();
				for (File fileTemp : fs) {
					if (fileTemp.isFile()) {
						String ss=fileTemp.getAbsolutePath();
						ss=ss.replaceAll("\\\\", "/");
						//System.out.println(ss+"************************************");
						FileTree ftr = new FileTree(ss,//fileTemp.getAbsolutePath(),
								fileTemp.getName(), null, null, "open");
						list.add(ftr);
					} else {
						FileTree ftr = new FileTree(fileTemp.getAbsolutePath(),
								fileTemp.getName(), null, null, "closed");
						list.add(ftr);
					}
				}
			}
		}
		

		String json_str = JSON.toJSONStringWithDateFormat(list,
				"yyyy-MM-dd HH:mm:ss");
		return json_str;
	}
	
	@RequestMapping(value="/deleteFile",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteFile(String path,HttpServletResponse response){
		Result result = new Result();
		try {
			File f = new File(path);
			if(f.exists()){
				f.delete();
				logger.info("删除文件："+f.getName()+"成功。");
			}
			result.setSuccess("true");
			result.setMsg("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess("false");
			result.setMsg(e.getMessage());	
		}
		String json_str=JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
		return json_str;
	}
	
	
	//返回echarts指定需要的数据格式
	@RequestMapping(value="/jobLogAnalysis",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String jobLogAnalysis() throws ParseException{
		List<JobLog> l=jobLogService.listAllJobMap();
		String[] yAxis = new String[l.size()];
		Long[] series = new Long[l.size()];
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<l.size();i++){
			yAxis[i] =l.get(i).getJobName();
			series[i] = (fmt.parse(l.get(i).getEndTime()).getTime()/1000-fmt.parse(l.get(i).getStartTime()).getTime()/1000);
		}
		Echarts e = new Echarts(yAxis,series);
		
		String json_str=JSON.toJSONStringWithDateFormat(e, "yyyy-MM-dd HH:mm:ss");
		System.out.println(json_str);

		return json_str;
	}
	
}
