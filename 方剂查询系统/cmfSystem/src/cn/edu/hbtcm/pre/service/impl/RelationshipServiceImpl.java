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
import cn.edu.hbtcm.pre.service.RelationshipService;

public class RelationshipServiceImpl implements RelationshipService {
	private static  int medall=93;
	private MedicineDao medicineDao;
	private PrescriptionDao prescriptionDao;
	private List<Prescription> prescription;
	private String Medname;
	private String medname;
	
	
	public MedicineDao getMedicineDao() {
		return medicineDao;
	}
	public void setMedicineDao(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}
	public PrescriptionDao getPrescriptionDao() {
		return prescriptionDao;
	}
	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}
	public int[][] getMatrix(){
		int[][] a;
		
		a=new int[medall][medall];
		//邻接矩阵初始化
		for(int m=0;m<medall;m++)
			for(int n=0;n<medall;n++)
				a[m][n]=0;
		
		
		
		
		//用来存放id的值
		int x,y;
		//返回找到的所以方剂集合
		prescription=prescriptionDao.findAll();
		//System.out.println(prescription);
		for(Prescription Prescription:prescription){
			for(int i=0;i<Prescription.getPre().size();i++){
				//取Prescription方剂中的第i味药
				Medname=prescriptionDao.findmedname(Prescription.getName(),i);
				//通过药名返回Id值
				x=medicineDao.findIdbymedname(Medname);
				for(int m=i+1;m<Prescription.getPre().size();m++){
					medname=prescriptionDao.findmedname(Prescription.getName(),m);
					//根据取出的药名找id号
					y=medicineDao.findIdbymedname(medname);
					a[x][y]=a[x][y]+1;
					a[y][x]=a[y][x]+1;
				}
			}
		}
		
		
	return a;
		
  }
	public  void printMatrix(int b[][]){
		int count=0;
		for(int m=0;m<medall;m++)
			for(int n=0;n<medall;n++){
				if(count % medall==0)
					System.out.println();
				System.out.print(b[m][n]+" ");
				count+=1;
			}
	}
	

}
