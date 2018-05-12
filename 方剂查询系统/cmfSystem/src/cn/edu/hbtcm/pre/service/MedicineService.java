package cn.edu.hbtcm.pre.service;

import java.util.List;

import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MedicineService {
	
	//根据药名找id号
	public int findIdbymedname(String medname);
	
	//根据id找药名
	public String findmednamebyId(int id);
	
	//添加数据
	public int saveEntity(Medicine medicine);
	
	//判断药物是否存在数据库
	public boolean exsitmed(String medname);
	

}
