package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MatrixRelationDao extends BaseDao<MatrixRelation, ObjectId> {

	//根据方剂找方剂名
	public String findnameByPre(Prescription prescription);
	
	//向矩阵关系表中插入数据
	public void insertMatrix(MatrixRelation matrixRelation);
	
	//根据两位药名查找矩阵关系实体
	public List<MatrixRelation> findbySourceandTarget(String source ,String target);

	//根据两位药名找方剂名
	public List<String> findprenamebySourceandTarget(String source ,String target);
	
	//根据source，target向MatrixRelation中prename字段添加数据
	public void insertPrename(String source,String target,String prename);
}
