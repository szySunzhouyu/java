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
		//String Medname="茯苓";
		
		

		
			//System.out.println(Medname);
		//用来存放方剂中取出的药名
		String medname;
		List<Prescription> prescription;
		//用来存放id的值
		
		//返回通过药名所找到的方剂集合
		prescription=prescriptionDao.findbymedname(Medname);
		//System.out.println(prescription);

		//System.out.println(x);
		//将查找出来的方剂遍历
		for(Prescription Prescription:prescription){
			//取每个方剂的所有药物
			for(int i=0;i<Prescription.getPre().size();i++){
				//取Prescription方剂中的第i味药
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
