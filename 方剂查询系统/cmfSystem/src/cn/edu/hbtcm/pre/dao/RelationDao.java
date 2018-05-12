package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;

public interface RelationDao extends BaseDao<Relation,ObjectId>{
	
	//添加relation
	public void insertrelation(Relation relation);
	
	//根据sourse,target判断是否存在满足条件的relation
	public boolean existsrelation(String sourse,String target);
	
	//查询list类型的Rel，以列表显示
	public List<Rel> findRel();
	
	//查询Rel，以Relation显示
	public List<Relation> findRelation();

}
