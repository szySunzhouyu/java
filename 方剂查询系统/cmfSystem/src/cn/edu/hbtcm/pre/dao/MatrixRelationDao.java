package cn.edu.hbtcm.pre.dao;

import java.util.List;

import org.bson.types.ObjectId;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MatrixRelationDao extends BaseDao<MatrixRelation, ObjectId> {

	//���ݷ����ҷ�����
	public String findnameByPre(Prescription prescription);
	
	//������ϵ���в�������
	public void insertMatrix(MatrixRelation matrixRelation);
	
	//������λҩ�����Ҿ����ϵʵ��
	public List<MatrixRelation> findbySourceandTarget(String source ,String target);

	//������λҩ���ҷ�����
	public List<String> findprenamebySourceandTarget(String source ,String target);
	
	//����source��target��MatrixRelation��prename�ֶ��������
	public void insertPrename(String source,String target,String prename);
}
