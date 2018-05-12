package cn.edu.hbtcm.pre.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.MatrixRelationDao;
import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;

public class MatrixRelationDaoImpl extends BaseDaoImpl<MatrixRelation, ObjectId>
implements MatrixRelationDao {

	protected MatrixRelationDaoImpl(Datastore ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String findnameByPre(Prescription prescription) {
		// TODO Auto-generated method stub
		String s=prescription.getName();
		return s;
	}
	@Override
	public void insertMatrix(MatrixRelation matrixRelation) {
		// TODO Auto-generated method stub
		ds.save(matrixRelation);
	}
	@Override
	public List<MatrixRelation> findbySourceandTarget(String source,
			String target) {
		// TODO Auto-generated method stub
	    Query<MatrixRelation> query = createQuery().field("source").equal(source).field("target").equal(target);
		return find(query).asList();
	}
	@Override
	public List<String> findprenamebySourceandTarget(String source,
			String target) {
		// TODO Auto-generated method stub
		Query<MatrixRelation> query = createQuery().field("source").equal(source).field("target").equal(target);
		MatrixRelation matrixRelation=findOne(query);
		
		return matrixRelation.getPrename();
	}
	
	public void insertPrename(String source,String target,String prename) {
		// TODO Auto-generated method stub
		Query<MatrixRelation> q = createQuery().field("source").equal(source).field("target").equal(target);
		UpdateOperations<MatrixRelation> ops=ds.createUpdateOperations(MatrixRelation.class).add("prename", prename);
		ds.update(q, ops);
	}
}
