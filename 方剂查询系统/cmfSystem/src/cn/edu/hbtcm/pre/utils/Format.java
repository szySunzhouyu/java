package cn.edu.hbtcm.pre.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.struts2.ServletActionContext;


public class Format {
	//��ʽ���ַ���
	public static String strFormat(String str) {
		String str2=",\"bz\":\"<a class=\'btn_1\'  data-options=\'iconCls:\\\"icon-search\\\"\'>�鿴</a>\"";
		int i=str.length()-1;
		String newString = str.substring(0, i) + str2 + str.substring(i, str.length());
		return newString;
		
	}
	//����ļ�ͷ
	public static String strFormat2(String str,int length) {
		String str2="{\"total\":"+length+",\"rows\":[]}";
		int i=str2.length()-2;
		String newString = str2.substring(0, i) + str + str2.substring(i, str2.length());
		return newString;
		
	}
	//�����ļ����������
	public static void createFile(String str,String filename) {
		String url=ServletActionContext.getServletContext().getRealPath("/main/");
		File file = new File(url+filename);
		if(file.exists()){
			file.delete();
		}
		
		try {
			file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter pw = null;//����һ����
			pw = new OutputStreamWriter(fos,"UTF-8");//ȷ����������ļ��ͱ�
			pw.write(str);
			pw.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//����Ϊ��������
//	@Test
//	public void fun1() {
//		String string="{\"pre\":\"��÷��30g���񽷣�5g\",\"majorfunction\":\"\",\"function\":\"4Сʱ\",\"use\":\"��\",\"abstr\":\"��\",\"name\":\"��÷��\"}";
//		System.out.println(strFormat(string));
//	}
//	@Test
//	public void fun2() {
//		String string="{\"pre\":\"��÷��30g���񽷣�5g\",\"majorfunction\":\"\",\"function\":\"4Сʱ\",\"use\":\"��\",\"abstr\":\"��\",\"name\":\"��÷��\"}";
//		String strFormat = strFormat(string);
//		System.out.println(strFormat2(strFormat,3));
//	}
//	@Test
//	public void fun3() {
//		String string="{\"pre\":\"��÷��30g���񽷣�5g\",\"majorfunction\":\"\",\"function\":\"4Сʱ\",\"use\":\"��\",\"abstr\":\"��\",\"name\":\"��÷��\"}";
//		String strFormat = strFormat(string);
//		createFile(strFormat);
//	}
}
