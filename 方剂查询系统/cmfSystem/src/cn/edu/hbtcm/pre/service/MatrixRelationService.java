package cn.edu.hbtcm.pre.service;


import java.util.List;

import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MatrixRelationService {
	
	//根据方剂找方剂名
	public String findnameByPre(Prescription prescription);
	
	//向矩阵关系表中插入数据
	public void insertMatrix(MatrixRelation matrixRelation);
 
	//找含有同时含有source ,target两种药物的矩阵关系
	public List<MatrixRelation> findbySourceandTarget(String source ,String target);
	
	//查找所有矩阵关系
	public List<MatrixRelation> findAll();
	
	//显示所有矩阵关系
	public void Matrixshow();
	
	//通过两种药物找方剂名
	public List<String> findprenamebySourceandTarget(String source,
			String target);

	//向指定矩阵关系中添加方剂名
	public void insertPrename(String source,String target,String prename);
	
	//生成datagrid.json格式的字符串
	public String str(List<MatrixRelation> matrixRelations);
	
	//生成json文件
	public void createFile(String str);
}
