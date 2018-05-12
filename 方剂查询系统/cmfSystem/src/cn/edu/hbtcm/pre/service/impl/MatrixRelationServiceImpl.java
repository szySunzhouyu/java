package cn.edu.hbtcm.pre.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import cn.edu.hbtcm.pre.dao.MatrixRelationDao;
import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.dao.RelationDao;
import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Relation;
import cn.edu.hbtcm.pre.service.MatrixRelationService;
import cn.edu.hbtcm.pre.service.MedicineService;
import cn.edu.hbtcm.pre.utils.Format;
import net.sf.json.JSONObject;

public class MatrixRelationServiceImpl implements MatrixRelationService {

	private MatrixRelationDao matrixRelationDao;
	private RelationDao relationDao;
	private MedicineDao medicineDao;
	private PrescriptionDao prescriptionDao;
	private List<Prescription> prescriptions;
	private String medname;
	public static  int medall=93;

	public MatrixRelationDao getMatrixRelationDao() {
		return matrixRelationDao;
	}


	public void setMatrixRelationDao(MatrixRelationDao matrixRelationDao) {
		this.matrixRelationDao = matrixRelationDao;
	}


	public RelationDao getRelationDao() {
		return relationDao;
	}


	public void setRelationDao(RelationDao relationDao) {
		this.relationDao = relationDao;
	}


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


	@Override
	public String findnameByPre(Prescription prescription) {
		// TODO Auto-generated method stub
		return matrixRelationDao.findnameByPre(prescription);
	}


	


	@Override
	public void Matrixshow() {
		// TODO Auto-generated method stub
		
		
		List<Prescription> prescriptions;
		prescriptions=prescriptionDao.findAll();
		//System.out.println(prescription);
		for(Prescription prescription:prescriptions){
			for(int i=0;i<prescription.getPre().size();i++){
				//取Prescription方剂中的第i味药
				String Medname=prescriptionDao.findmedname(prescription.getName(),i);
				//通过药名返回Id值
				for(int m=i+1;m<prescription.getPre().size();m++){
					String medname = prescriptionDao.findmedname(prescription.getName(),m);
					MatrixRelation matrixRelation=new MatrixRelation();
					List<String> prename=new ArrayList<String>();
					//System.out.println(medname+" "+Medname);
					//System.out.println(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty()+"   "+matrixRelationDao.findbySourceandTarget(Medname,medname).isEmpty());
					if(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty()
							&& matrixRelationDao.findbySourceandTarget(Medname,medname).isEmpty()){
						//System.out.println("sadasdas");
						matrixRelation.setSource(Medname);
						matrixRelation.setTarget(medname);
						prename.add(prescription.getName());
						matrixRelation.setPrename(prename);
						matrixRelationDao.insertMatrix(matrixRelation);
					}
					else{
						if(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty())
							matrixRelationDao.insertPrename(Medname, medname, prescription.getName());
						else
							matrixRelationDao.insertPrename(medname, Medname, prescription.getName());
					}
					//System.out.println(matrixRelation);
				}//m
			  }//i
			}//pre
		
	
	}


	@Override
	public void insertMatrix(MatrixRelation matrixRelation) {
		// TODO Auto-generated method stub
		matrixRelationDao.insertMatrix(matrixRelation);
	}


	@Override
	public List<MatrixRelation> findbySourceandTarget(String source,
			String target) {
		// TODO Auto-generated method stub
		
		return matrixRelationDao.findbySourceandTarget(source, target);
	}


	@Override
	public List<String> findprenamebySourceandTarget(String source,
			String target) {
		// TODO Auto-generated method stub
		return matrixRelationDao.findprenamebySourceandTarget(source, target);
	}
	
	@Override
	public void insertPrename(String source,String target,String prename) {
		// TODO Auto-generated method stub
		matrixRelationDao.insertPrename(source,target,prename);
	}


	@Override
	public List<MatrixRelation> findAll() {
		// TODO Auto-generated method stub
		return matrixRelationDao.findAll();
	}
	
	public String str(List<MatrixRelation> matrixRelations) {
		String str="";
		for (int i = 0; i < matrixRelations.size(); i++) {
			//将得到的字符串转换成json串
			String jsonstr = JSONObject.fromObject(matrixRelations.get(i)).toString();
			String str1 = Format.strFormat(jsonstr);
			if (i==matrixRelations.size()-1) {
				str+=str1;
			}
			else {
				str+=str1+",";
			}
		}
		str=Format.strFormat2(str,matrixRelations.size());
		return str;
	}
	public void createFile(String str){
		String filename="datagrid2.json";
		Format.createFile(str,filename);
	}
}
