package zjhc.com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zjhc.com.dao.UserDao;
import zjhc.com.entity.User;
import zjhc.com.service.UserService;
import zjhc.com.utils.CryptographyUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public User login(User user) {
		// TODO Auto-generated method stub
		
		return userDao.login(user);
	}

	public User getByUserName(String userName) {
		
		return userDao.getByUserName(userName);
	}

	//更改用户密码
	public int updatePassword(User user) {
		user.setPassword(CryptographyUtil.md5(user.getPassword(),"rdb"));
		return userDao.updatePassword(user);
	}

}
