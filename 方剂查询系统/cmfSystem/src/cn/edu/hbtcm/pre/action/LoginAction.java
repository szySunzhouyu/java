package cn.edu.hbtcm.pre.action;


import com.opensymphony.xwork2.*;

import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.service.AdminService;

import javax.swing.JOptionPane;

import org.apache.struts2.interceptor.*;



/**
 * 处理员工和经理登陆的Action
 */
public class LoginAction extends ActionSupport
{

	private AdminService adminService; 
	
	// 定义一个常量作为普通用户登录成功的Result名
	private final String AD_RESULT = "ad";
	
	// 封装请求参数
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// 处理用户请求
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		int result = adminService.validLogin(admin);
		if (result==adminService.LOGIN_USER) {
			//保存用户名到session中
			ctx.getSession().put(WebConstant.USER
					, admin.getusername());
			addActionMessage("登陆成功！");
			return AD_RESULT;
		}
		addActionMessage("用户名/密码不匹配");
		return ERROR;
	}
}