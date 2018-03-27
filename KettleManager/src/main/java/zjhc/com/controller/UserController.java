package zjhc.com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;









import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import zjhc.com.entity.Result;
import zjhc.com.entity.User;
import zjhc.com.service.UserService;
import zjhc.com.utils.CryptographyUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService userService;

	@RequestMapping("/login")
	public String login(User user ,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),CryptographyUtil.md5(user.getPassword(),"rdb"));
		//System.out.println(CryptographyUtil.md5(user.getPassword(),"rdb"));
		try {
			subject.login(token); // 登录验证
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login";
		}
		
	}
	
	//用户注销
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
	
	
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public String modifyPassword(User user,HttpServletResponse response){
		int resultTotal = 0;
		Result result = new Result();
		try {
			User u=userService.getByUserName(user.getUserName());
			user.setId(u.getId());
			resultTotal=userService.updatePassword(user);
			result.setSuccess("true");
			result.setMsg("修改成功");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setSuccess("false");
			result.setMsg(e.getMessage());	
		}
		String json_str=JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
		return json_str;
	}
}
