package zjhc.com.dao;

import zjhc.com.entity.User;

/***
 * �û�Dao
 * @author rdb
 *
 */
public interface UserDao {

	public User login(User user);
	
	public User getByUserName(String userName);
	
	public int updatePassword(User user);
}
