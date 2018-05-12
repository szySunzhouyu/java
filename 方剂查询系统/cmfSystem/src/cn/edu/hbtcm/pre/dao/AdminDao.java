package cn.edu.hbtcm.pre.dao;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Admin;

import com.google.code.morphia.dao.DAO;

public interface AdminDao extends BaseDao<Admin, ObjectId>{
	//添加管理员，成功返回1，失败返回0
	public int addAdmin(Admin admin);
	//根据名字查找管理员
	public Admin findByName(String username);
	public Admin findByNameAndPass(Admin user);
}
