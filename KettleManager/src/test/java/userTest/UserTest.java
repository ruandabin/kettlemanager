package userTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zjhc.com.entity.User;
import zjhc.com.service.UserService;



public class UserTest {
	@Test
	public void loginTest(){
		@SuppressWarnings("resource")
		ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) ac.getBean("userService");
		User u=new User();
		u.setPassword("123");
		u.setUserName("rdb");
		User resultUser=us.getByUserName("rdb");
		if(resultUser == null || resultUser.equals("")){
			System.out.println("111");
		}else{
			System.out.println(resultUser.getNickName()+""+resultUser.getRoleName());
		}
		
	}

}
