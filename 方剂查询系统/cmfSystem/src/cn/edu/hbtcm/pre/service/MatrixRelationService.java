package cn.edu.hbtcm.pre.service;


import java.util.List;

import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Prescription;

public interface MatrixRelationService {
	
	//���ݷ����ҷ�����
	public String findnameByPre(Prescription prescription);
	
	//������ϵ���в�������
	public void insertMatrix(MatrixRelation matrixRelation);
 
	//�Һ���ͬʱ����source ,target����ҩ��ľ����ϵ
	public List<MatrixRelation> findbySourceandTarget(String source ,String target);
	
	//�������о����ϵ
	public List<MatrixRelation> findAll();
	
	//��ʾ���о����ϵ
	public void Matrixshow();
	
	//ͨ������ҩ���ҷ�����
	public List<String> findprenamebySourceandTarget(String source,
			String target);

	//��ָ�������ϵ����ӷ�����
	public void insertPrename(String source,String target,String prename);
	
	//����datagrid.json��ʽ���ַ���
	public String str(List<MatrixRelation> matrixRelations);
	
	//����json�ļ�
	public void createFile(String str);
}
