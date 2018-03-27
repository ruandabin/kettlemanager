package zjhc.com.utils;

import org.apache.shiro.crypto.hash.Md5Hash;



/***
 * 加密工具
 * @author rdb
 *
 */
public class CryptographyUtil {
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}


public static void main(String[] args) {
	String password="123";
	
	System.out.println("Md5加密："+CryptographyUtil.md5(password, "rdb"));//Md5加密：0a8c05da8e9ff77c737b8de0973d8f76
	}
}