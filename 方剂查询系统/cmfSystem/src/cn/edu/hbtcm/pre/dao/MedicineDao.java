package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MedicineDao extends BaseDao<Medicine, ObjectId> {
	
	//����ҩ����id��
	public int findIdbymedname(String medname);
	
    //����id��ҩ��
	public String findmednamebyId(int id);
	
	//����ҩ���ж��Ƿ���ڸ�ҩ��
	public boolean existsmed(String medname);
}
