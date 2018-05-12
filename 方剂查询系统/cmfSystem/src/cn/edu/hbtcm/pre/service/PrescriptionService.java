package cn.edu.hbtcm.pre.service;


import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.domain.Prescription;


public interface PrescriptionService
{
	//��������
	public List<Prescription> findAll();
	
	//���ݷ������ֲ���
	public Prescription findByName(String name);
	
	//���ݷ�������ģ������
	public List<Prescription> findByNameBlur(String name);
	
	//�������β���
	public List<Prescription> findByFunction(String function);
	
	//�������β���
	public List<Prescription> findByMajorfunction(String majorfunction);
	
	//��������֢״����
	public List<Prescription> findByUse(String use);
	
	//����ժҪ����
	public List<Prescription> findByAbstr(String abstr);
	
	//���ʵ��
	public int save_(Prescription prescription);
	
	//���ݷ�������ѯ���������ҩ����
	public String findmedname(String name, int i);
	
	//���Һ��и�ҩ�����ķ���
	public List<Prescription> findbymedname(String medname);
	
	//����datagrid.json��ʽ���ַ���
	public String str(List<Prescription> prescriptions);
	
	//����json�ļ�
	public void createFile(String str);
	
}