package cn.edu.hbtcm.pre.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.domain.Pre;
import cn.edu.hbtcm.pre.domain.Prescription;




public class PrescriptionDaoImpl extends BaseDaoImpl<Prescription, ObjectId>
	implements PrescriptionDao{
	protected PrescriptionDaoImpl(Datastore ds)
	{
		super(ds);	
	}

	public Prescription findByName(String name) {
		Query<Prescription> query = createQuery().field("name").equal(name);
		return findOne(query);
	}

	public List<Prescription> findByFunction(String functions) {
		// TODO Auto-generated method stub
		Query<Prescription> query = createQuery().field("functions").contains(functions);
		return find(query).asList();
	}

	public List<Prescription> findByAbstr(String abstr) {
		// TODO Auto-generated method stub
		Query<Prescription> query = createQuery().field("abstr").contains(abstr);
		return find(query).asList();
	}
	public String findmedname(String name, int i){
		Prescription prescription = findByName(name);
		Pre pre = prescription.getPre().get(i);
		return pre.getMedname();
	}
	public List<Prescription> findbymedname(String medname){
		Query<Prescription> query = createQuery().field("pre.medname").contains(medname);
		return find(query).asList();
	}
	public List<Prescription> findByMajorfunction(String majorfunction){
		//TODO Auto-generated method stub
		Query<Prescription> query = createQuery().field("majorfunction").contains(majorfunction);
		return find(query).asList();
	}
	public List<Prescription> findByUse(String use){
		//TODO Auto-generated method stub
		Query<Prescription> query =createQuery().field("use").contains(use);
		return find(query).asList();
	}
	@Override
	public List<Prescription> findByNameBlur(String name) {
		Query<Prescription> query = createQuery().field("name").contains(name);
		return find(query).asList();
	}
}