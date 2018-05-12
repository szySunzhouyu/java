package cn.edu.hbtcm.pre.dao;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Admin;

import com.google.code.morphia.dao.DAO;

public interface AdminDao extends BaseDao<Admin, ObjectId>{
	//��ӹ���Ա���ɹ�����1��ʧ�ܷ���0
	public int addAdmin(Admin admin);
	//�������ֲ��ҹ���Ա
	public Admin findByName(String username);
	public Admin findByNameAndPass(Admin user);
}
