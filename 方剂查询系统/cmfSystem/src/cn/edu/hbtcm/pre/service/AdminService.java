package cn.edu.hbtcm.pre.service;




import cn.edu.hbtcm.pre.domain.Admin;


public interface AdminService
{
	// 登录失败
	public static final int LOGIN_FAIL = -1;
	// 登陆成功
	public static final int LOGIN_USER = 1;
	//添加用户，成功返回1，失败返回0
	public int addAdmin(Admin admin);
	//根据名字查找用户
	public Admin findByName(String username);
	//查找名字和密码匹配的用户
	public Admin findByNameAndPass(Admin user);
	//用户登录
	public int validLogin(Admin admin);
}