package cn.edu.hbtcm.pre.service;

import java.util.List;

import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;

public interface RelationService {
	
	//���ҩ��Ĺ�ϵ
	public void insertrelation(Relation relation);
	
	//��������ҩ���жϸù�ϵ�Ƿ����
	public boolean existsrelation(String soursce,String target);

	//�ҳ�ҩ������Rel
	public List<Rel> findonerelation(String Medname);
	
}
