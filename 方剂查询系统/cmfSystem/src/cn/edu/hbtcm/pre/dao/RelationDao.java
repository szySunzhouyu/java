package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;

public interface RelationDao extends BaseDao<Relation,ObjectId>{
	
	//���relation
	public void insertrelation(Relation relation);
	
	//����sourse,target�ж��Ƿ��������������relation
	public boolean existsrelation(String sourse,String target);
	
	//��ѯlist���͵�Rel�����б���ʾ
	public List<Rel> findRel();
	
	//��ѯRel����Relation��ʾ
	public List<Relation> findRelation();

}
