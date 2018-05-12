package cn.edu.hbtcm.pre.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Relation;

public class MedicineDaoImpl extends BaseDaoImpl<Medicine, ObjectId>
implements MedicineDao {

	protected MedicineDaoImpl(Datastore ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int findIdbymedname(String medname) {
		// TODO Auto-generated method stub
		Query<Medicine> query = createQuery().field("medname").equal(medname);
		Medicine medicine=findOne(query);
		int id=medicine.getId();
		return id;
	}

	public String findmednamebyId(int id) {
		Query<Medicine> query = createQuery().field("id").equal(id);
		Medicine medicine=findOne(query);
		String medname=medicine.getMedname();
		return medname;
	}

	public boolean existsmed(String medname) {
		// TODO Auto-generated method stub
		Query<Medicine> query = createQuery().field("medname").equal(medname);
		return exists(query);
		
	}
	
	

}
