package zjhc.com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) {
		
		File f = new File("D:\\test\\ac.txt");
		String str = f.getAbsolutePath();
		str=str.replaceAll("\\\\", "/");
		System.out.println(str);
		
	}
}
