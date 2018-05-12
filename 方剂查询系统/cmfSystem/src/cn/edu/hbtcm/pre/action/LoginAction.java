package cn.edu.hbtcm.pre.action;


import com.opensymphony.xwork2.*;

import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.service.AdminService;

import javax.swing.JOptionPane;

import org.apache.struts2.interceptor.*;



/**
 * ����Ա���;����½��Action
 */
public class LoginAction extends ActionSupport
{

	private AdminService adminService; 
	
	// ����һ��������Ϊ��ͨ�û���¼�ɹ���Result��
	private final String AD_RESULT = "ad";
	
	// ��װ�������
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// �����û�����
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		int result = adminService.validLogin(admin);
		if (result==adminService.LOGIN_USER) {
			//�����û�����session��
			ctx.getSession().put(WebConstant.USER
					, admin.getusername());
			addActionMessage("��½�ɹ���");
			return AD_RESULT;
		}
		addActionMessage("�û���/���벻ƥ��");
		return ERROR;
	}
}