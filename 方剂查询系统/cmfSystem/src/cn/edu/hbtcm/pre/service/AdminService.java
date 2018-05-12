package cn.edu.hbtcm.pre.service;




import cn.edu.hbtcm.pre.domain.Admin;


public interface AdminService
{
	// ��¼ʧ��
	public static final int LOGIN_FAIL = -1;
	// ��½�ɹ�
	public static final int LOGIN_USER = 1;
	//����û����ɹ�����1��ʧ�ܷ���0
	public int addAdmin(Admin admin);
	//�������ֲ����û�
	public Admin findByName(String username);
	//�������ֺ�����ƥ����û�
	public Admin findByNameAndPass(Admin user);
	//�û���¼
	public int validLogin(Admin admin);
}