package cn.edu.hbtcm.pre.dao.impl;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.AdminDao;
import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.domain.Prescription;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;



public class AdminDaoImpl extends BaseDaoImpl<Admin, ObjectId>
	implements AdminDao{
	protected AdminDaoImpl(Datastore ds)
	{
		super(ds);	
	}

	@Override
	public int addAdmin(Admin admin) {
		//用户名相同时插入失败,失败返回0，成功返回1
		if (findByName(admin.getusername())==null) {
			super.save_(admin);
			return 1;
		}
		return 0;
	}

	@Override
	public Admin findByNameAndPass(Admin admin) {
		Query<Admin> query = createQuery().field("username").equal(admin.getUsername()).field("password").equal(admin.getPassword());
		return super.findOne(query);
	}

	@Override
	public Admin findByName(String username) {
		
		Query<Admin> query = createQuery().field("username").equal(username);
		return super.findOne(query);
	}
	
	
}