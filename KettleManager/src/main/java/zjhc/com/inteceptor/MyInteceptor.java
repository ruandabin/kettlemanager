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
						"XMLHttpRequest"))// �����ajax������Ӧͷ���У�x-requested-with��
											// </span><div
											// style="color: rgb(153, 51, 102);"><span
											// style="font-size:12px;"> {
											// </span></div><div
											// style="color: rgb(153, 51, 102);"><span
											// style="font-size:12px;">
											// response.setHeader("sessionstatus",
											// "timeout");//����Ӧͷ����session״̬
			response.getWriter().print("timeout"); // ��ӡһ������ֵ��û��һ�У���tabsҳ���޷�������<span
													// style="font-size:12px;">������������</span>��
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
