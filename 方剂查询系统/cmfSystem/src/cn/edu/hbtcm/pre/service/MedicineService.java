package cn.edu.hbtcm.pre.service;

import java.util.List;

import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MedicineService {
	
	//����ҩ����id��
	public int findIdbymedname(String medname);
	
	//����id��ҩ��
	public String findmednamebyId(int id);
	
	//�������
	public int saveEntity(Medicine medicine);
	
	//�ж�ҩ���Ƿ�������ݿ�
	public boolean exsitmed(String medname);
	

}
