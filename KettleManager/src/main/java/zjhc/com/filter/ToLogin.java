package zjhc.com.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

public class ToLogin extends AccessControlFilter{


	 @Override
	 protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {  
	        
	        return true;  
	    }  
	 
	@Override
	protected boolean isAccessAllowed(ServletRequest arg0,
			ServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1)
			throws Exception {
		return false;
	}



}
