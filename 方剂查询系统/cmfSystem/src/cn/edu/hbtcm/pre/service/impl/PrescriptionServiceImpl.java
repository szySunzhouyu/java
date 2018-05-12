package cn.edu.hbtcm.pre.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.utils.Format;
import net.sf.json.JSONObject;


public class PrescriptionServiceImpl implements PrescriptionService
{

	private PrescriptionDao prescriptionDao;

	public PrescriptionDao getPrescriptionDao() {
		return prescriptionDao;
	}

	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
	}


	@Override
	public Prescription findByName(String name) {
		// TODO Auto-generated method stub
		return prescriptionDao.findByName(name);
	}

	@Override
	public List<Prescription> findByFunction(String function) {
		// TODO Auto-generated method stub
		return prescriptionDao.findByFunction(function);
	}
	@Override
	public List<Prescription> findByAbstr(String abstr) {
		return prescriptionDao.findByAbstr(abstr);
	}
	public int save_(Prescription prescription){
		return prescriptionDao.save_(prescription);
	}
	//根据方剂名查询方剂里面的药物名
	public String findmedname(String name, int i){
		return prescriptionDao.findmedname(name,i);
	}
	public List<Prescription> findbymedname(String medname){
		return prescriptionDao.findbymedname(medname);
	}

	@Override
	public List<Prescription> findByNameBlur(String name) {
		return prescriptionDao.findByNameBlur(name);
	}

	@Override
	public List<Prescription> findAll() {
		return prescriptionDao.findAll();
	}
	@Override
	public List<Prescription> findByMajorfunction(String majorfunction){
		return prescriptionDao.findByMajorfunction(majorfunction);
	}
	@Override
	public List<Prescription> findByUse(String use){
		return prescriptionDao.findByUse(use);
	}

	@Override
	public String str(List<Prescription> prescriptions) {
		String str="";
		for (int i = 0; i < prescriptions.size(); i++) {
			//将得到的字符串转换成json串
			String jsonstr = JSONObject.fromObject(prescriptions.get(i)).toString();
			String str1 = Format.strFormat(jsonstr);
			if (i==prescriptions.size()-1) {
				str+=str1;
			}
			else {
				str+=str1+",";
			}
		}
		str=Format.strFormat2(str,prescriptions.size());
		return str;
	}
	
	public void createFile(String str){
		String filename="datagrid.json";
		Format.createFile(str,filename);
	}
}
