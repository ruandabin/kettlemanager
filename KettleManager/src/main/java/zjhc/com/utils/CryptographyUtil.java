package zjhc.com.utils;

import org.apache.shiro.crypto.hash.Md5Hash;



/***
 * ���ܹ���
 * @author rdb
 *
 */
public class CryptographyUtil {
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}


public static void main(String[] args) {
	String password="123";
	
	System.out.println("Md5���ܣ�"+CryptographyUtil.md5(password, "rdb"));//Md5���ܣ�0a8c05da8e9ff77c737b8de0973d8f76
	}
}