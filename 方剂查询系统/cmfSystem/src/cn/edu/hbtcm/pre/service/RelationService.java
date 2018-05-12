package cn.edu.hbtcm.pre.service;

import java.util.List;

import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;

public interface RelationService {
	
	//添加药物的关系
	public void insertrelation(Relation relation);
	
	//根据两种药物判断该关系是否存在
	public boolean existsrelation(String soursce,String target);

	//找出药物名找Rel
	public List<Rel> findonerelation(String Medname);
	
}
