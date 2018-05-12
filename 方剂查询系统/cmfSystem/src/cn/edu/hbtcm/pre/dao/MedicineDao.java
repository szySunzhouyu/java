package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MedicineDao extends BaseDao<Medicine, ObjectId> {
	
	//根据药名找id号
	public int findIdbymedname(String medname);
	
    //根据id找药名
	public String findmednamebyId(int id);
	
	//根据药名判断是否存在该药物
	public boolean existsmed(String medname);
}
