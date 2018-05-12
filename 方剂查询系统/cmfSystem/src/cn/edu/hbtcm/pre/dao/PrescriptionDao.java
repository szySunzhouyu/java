package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Prescription;

import com.google.code.morphia.dao.DAO;

public interface PrescriptionDao extends BaseDao<Prescription, ObjectId>{
	//���ݷ������־�ȷ����
	public Prescription findByName(String name);
	//���ݷ�������ģ������
	public List<Prescription> findByNameBlur(String name);
	//��������ģ������
	public List<Prescription> findByFunction(String function);
	//��������ģ������
	public List<Prescription> findByMajorfunction(String majorfunction);
	//��������֢״����
	public List<Prescription> findByUse(String use);
	//����ժҪģ������
	public List<Prescription> findByAbstr(String abstr);
	
	
	//���ݷ�������ѯ��������ĵڼ�λҩ����
	public String findmedname(String name, int i);
	//����ҩ����ѯ���з���
	public List<Prescription> findbymedname(String medname);
}
