package cn.edu.hbtcm.pre.utils;

public class Test {
	public static void main(String[] args) {
		// �������������Լ�����޸�
		// Ŀ��ѵڶ������뵽��һ��
		String s1 = "abcdefg";
		String s2 = "xxx";
		int i = 3;// ���뵽����λ

		String newString = s1.substring(0, i) + s2 + s1.substring(i, s1.length());
		System.out.println("�µ��ַ���: " + newString);
		}
}
