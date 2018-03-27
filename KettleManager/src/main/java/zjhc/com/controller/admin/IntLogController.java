package zjhc.com.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zjhc.com.entity.DataGrid;
import zjhc.com.entity.OrdsLog;
import zjhc.com.utils.HttpUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
/***
 * �ӿ���־��ѯcontroller
 * @author rdb
 *
 */
@Controller
@RequestMapping("/admin/intLog")
public class IntLogController {

	  /***
	   * ��ȡ��־�嵥
	   * @return
	   * @throws Exception
	   */
	  @RequestMapping(value="/listOrdsLogs",produces="text/html;charset=UTF-8")
	  @ResponseBody
	  public String listOrdsLogs(int page,int rows,OrdsLog ords) throws Exception{
		  String url = "http://10.145.198.143:8081/ords/data_service/monitor/OrdsLog?page="+(page-1);//��־�嵥
		  System.out.println("���ýӿ�:"+url);
		//  String url = "http://10.145.198.143:8081/ords/data_service/monitor/OrdsLog";//��־�嵥
		  String url_count = "http://10.145.198.143:8081/ords/data_service/monitor/OrdsLogCount";//��־������
	      String rest_json = HttpUtil.getJsonStr(url); 
	      String rest_count_json = HttpUtil.getJsonStr(url_count);
	      JSONObject jsonObject = JSON.parseObject(rest_json);
	      ArrayList<OrdsLog> OrdsLogs = JSON.parseObject(jsonObject.getString("items"), new TypeReference<ArrayList<OrdsLog>>() {});
	      DataGrid dg = new DataGrid();
	      dg.setRows(OrdsLogs);
	      jsonObject = JSON.parseObject(rest_count_json);
	      JSONArray jsonArray = JSON.parseArray(jsonObject.getString("items"));
	      for (Object obj : jsonArray) {
	    	  jsonObject = (JSONObject) obj; 
	    	  dg.setTotal(jsonObject.getLongValue("total"));
	        }
	      String json_str=JSON.toJSONStringWithDateFormat(dg, "yyyy-MM-dd HH:mm:ss");
		  //System.out.println(json_str);
		  return json_str;
	  }
}
