package cn.edu.hbtcm.pre.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.dao.RelationDao;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;
import cn.edu.hbtcm.pre.service.RelationService;

public class RelationServiceImpl implements RelationService {
	private RelationDao relationDao;
	private PrescriptionDao prescriptionDao;
	
	
	
	public RelationDao getRelationDao() {
		return relationDao;
	}

	public void setRelationDao(RelationDao relationDao) {
		this.relationDao = relationDao;
	}
	@Override
	public void insertrelation(Relation relation){
		//TODO Auto-generated method stub
		relationDao.insertrelation(relation);
	}

	@Override
	public boolean existsrelation(String source, String target) {
		// TODO Auto-generated method stub
		return relationDao.existsrelation(source, target);
	}

	@Override
	public List<Rel> findonerelation(String Medname) {
		// TODO Auto-generated method stub

		
		List<Rel> rels=new ArrayList<Rel>();
		//String Medname="����";
		
		

		
			//System.out.println(Medname);
		//������ŷ�����ȡ����ҩ��
		String medname;
		List<Prescription> prescription;
		//�������id��ֵ
		
		//����ͨ��ҩ�����ҵ��ķ�������
		prescription=prescriptionDao.findbymedname(Medname);
		//System.out.println(prescription);

		//System.out.println(x);
		//�����ҳ����ķ�������
		for(Prescription Prescription:prescription){
			//ȡÿ������������ҩ��
			for(int i=0;i<Prescription.getPre().size();i++){
				//ȡPrescription�����еĵ�iζҩ
				medname=prescriptionDao.findmedname(Prescription.getName(),i);
				Rel rel=new Rel();
				//System.out.println(Medname+" "+medname);
				if(!Medname.equals(medname)){
					
					rel.setSource(Medname);
					rel.setTarget(medname);
					rels.add(rel);
					
				}

				
				
			}
		}
		//System.out.println(relation);
		
		//printMatrix(a);
		return rels;
	}

	public PrescriptionDao getPrescriptionDao() {
		return prescriptionDao;
	}

	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}



}
