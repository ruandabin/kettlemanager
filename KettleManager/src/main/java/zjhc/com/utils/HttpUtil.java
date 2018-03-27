package zjhc.com.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpUtil {
	
	
	public static String  getJsonStr(String url) throws IOException{
		 CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
	     HttpGet httpget = new HttpGet(url); // 创建httpget实例
	     CloseableHttpResponse response = null;
	     try {
			 response = httpclient.execute(httpget);
			 HttpEntity entity=(HttpEntity) response.getEntity(); // 获取返回实体
			 return EntityUtils.toString(entity, "utf-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(response != null){
				response.close(); // 关闭流和释放系统资源      
			}
		}
	    return null;	
	}
	
}
