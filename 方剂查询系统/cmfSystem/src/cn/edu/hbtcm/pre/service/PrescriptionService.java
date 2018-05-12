package cn.edu.hbtcm.pre.service;


import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.domain.Prescription;


public interface PrescriptionService
{
	//查找所有
	public List<Prescription> findAll();
	
	//根据方剂名字查找
	public Prescription findByName(String name);
	
	//根据方剂名字模糊查找
	public List<Prescription> findByNameBlur(String name);
	
	//根据主治查找
	public List<Prescription> findByFunction(String function);
	
	//根据主治查找
	public List<Prescription> findByMajorfunction(String majorfunction);
	
	//根据适用症状查找
	public List<Prescription> findByUse(String use);
	
	//根据摘要查找
	public List<Prescription> findByAbstr(String abstr);
	
	//添加实体
	public int save_(Prescription prescription);
	
	//根据方剂名查询方剂里面的药物名
	public String findmedname(String name, int i);
	
	//查找含有该药物名的方剂
	public List<Prescription> findbymedname(String medname);
	
	//生成datagrid.json格式的字符串
	public String str(List<Prescription> prescriptions);
	
	//生成json文件
	public void createFile(String str);
	
}