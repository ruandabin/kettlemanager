package zjhc.com.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInteceptor extends HandlerInterceptorAdapter{
	 @Override    
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (request.getHeader("x-requested-with") != null
				&& request.getHeader("x-requested-with").equalsIgnoreCase(
						"XMLHttpRequest"))// 如果是ajax请求响应头会有，x-requested-with；
											// </span><div
											// style="color: rgb(153, 51, 102);"><span
											// style="font-size:12px;"> {
											// </span></div><div
											// style="color: rgb(153, 51, 102);"><span
											// style="font-size:12px;">
											// response.setHeader("sessionstatus",
											// "timeout");//在响应头设置session状态
			response.getWriter().print("timeout"); // 打印一个返回值，没这一行，在tabs页中无法跳出（<span
													// style="font-size:12px;">导航栏能跳出</span>）
		return true;
	}

	    @Override    
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {    
	        System.out.println("===========HandlerInterceptor1 postHandle");    
	    }    
	    @Override    
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {    
	        System.out.println("===========HandlerInterceptor1 afterCompletion");    
	    }    
}
