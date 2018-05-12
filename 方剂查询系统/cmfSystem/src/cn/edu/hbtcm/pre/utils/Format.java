package cn.edu.hbtcm.pre.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.struts2.ServletActionContext;


public class Format {
	//格式化字符串
	public static String strFormat(String str) {
		String str2=",\"bz\":\"<a class=\'btn_1\'  data-options=\'iconCls:\\\"icon-search\\\"\'>查看</a>\"";
		int i=str.length()-1;
		String newString = str.substring(0, i) + str2 + str.substring(i, str.length());
		return newString;
		
	}
	//添加文件头
	public static String strFormat2(String str,int length) {
		String str2="{\"total\":"+length+",\"rows\":[]}";
		int i=str2.length()-2;
		String newString = str2.substring(0, i) + str + str2.substring(i, str2.length());
		return newString;
		
	}
	//创建文件并添加内容
	public static void createFile(String str,String filename) {
		String url=ServletActionContext.getServletContext().getRealPath("/main/");
		File file = new File(url+filename);
		if(file.exists()){
			file.delete();
		}
		
		try {
			file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter pw = null;//定义一个流
			pw = new OutputStreamWriter(fos,"UTF-8");//确认流的输出文件和编
			pw.write(str);
			pw.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//以下为测试内容
//	@Test
//	public void fun1() {
//		String string="{\"pre\":\"乌梅：30g，蜀椒：5g\",\"majorfunction\":\"\",\"function\":\"4小时\",\"use\":\"有\",\"abstr\":\"有\",\"name\":\"乌梅丸\"}";
//		System.out.println(strFormat(string));
//	}
//	@Test
//	public void fun2() {
//		String string="{\"pre\":\"乌梅：30g，蜀椒：5g\",\"majorfunction\":\"\",\"function\":\"4小时\",\"use\":\"有\",\"abstr\":\"有\",\"name\":\"乌梅丸\"}";
//		String strFormat = strFormat(string);
//		System.out.println(strFormat2(strFormat,3));
//	}
//	@Test
//	public void fun3() {
//		String string="{\"pre\":\"乌梅：30g，蜀椒：5g\",\"majorfunction\":\"\",\"function\":\"4小时\",\"use\":\"有\",\"abstr\":\"有\",\"name\":\"乌梅丸\"}";
//		String strFormat = strFormat(string);
//		createFile(strFormat);
//	}
}
