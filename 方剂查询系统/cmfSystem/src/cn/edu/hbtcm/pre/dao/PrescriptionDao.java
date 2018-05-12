package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Prescription;

import com.google.code.morphia.dao.DAO;

public interface PrescriptionDao extends BaseDao<Prescription, ObjectId>{
	//根据方剂名字精确查找
	public Prescription findByName(String name);
	//根据方剂名字模糊查找
	public List<Prescription> findByNameBlur(String name);
	//根据主治模糊查找
	public List<Prescription> findByFunction(String function);
	//根据主治模糊查找
	public List<Prescription> findByMajorfunction(String majorfunction);
	//根据适用症状查找
	public List<Prescription> findByUse(String use);
	//根据摘要模糊查找
	public List<Prescription> findByAbstr(String abstr);
	
	
	//根据方剂名查询方剂里面的第几位药物名
	public String findmedname(String name, int i);
	//根据药名查询所有方剂
	public List<Prescription> findbymedname(String medname);
}
