package zjhc.com.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import zjhc.com.entity.User;
import zjhc.com.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Resource
	UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName=(String)arg0.getPrincipal();//得到用户名
		User u=userService.getByUserName(userName);//从数据库获取该用户
		if(u != null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser",u);
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(u.getUserName(),u.getPassword(),"xx");
			return authcInfo;
		}
		return null;
	}
}
