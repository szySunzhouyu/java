package cn.edu.hbtcm.pre.utils;

public class Test {
	public static void main(String[] args) {
		// 下面三个变量自己随便修改
		// 目标把第二个插入到第一个
		String s1 = "abcdefg";
		String s2 = "xxx";
		int i = 3;// 插入到第三位

		String newString = s1.substring(0, i) + s2 + s1.substring(i, s1.length());
		System.out.println("新的字符串: " + newString);
		}
}
