package cn.edu.hbtcm.pre.service.impl;


import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.query.Query;

import cn.edu.hbtcm.pre.dao.AdminDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.service.AdminService;


public class AdminServiceImpl implements AdminService
{
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public int addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public Admin findByName(String username) {
		// TODO Auto-generated method stub
		return adminDao.findByName(username);
	}

	@Override
	public Admin findByNameAndPass(Admin user) {
		// TODO Auto-generated method stub
		return adminDao.findByNameAndPass(user);
	}
	public int validLogin(Admin admin){
		Admin admin2 = adminDao.findByNameAndPass(admin);
		if (admin2!=null)
		{
			return LOGIN_USER;
		}
		return LOGIN_FAIL;
	}

}
