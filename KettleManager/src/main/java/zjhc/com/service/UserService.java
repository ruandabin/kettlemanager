package zjhc.com.service;

import zjhc.com.entity.User;

public interface UserService {
	
	/***
	 * ��¼
	 *@param user
	 *@return
	 */
	public User login(User user);
	
	public User getByUserName(String userName);
	
	public int  updatePassword(User user);

}
