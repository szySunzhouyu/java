package cn.edu.hbtcm.pre.dao.impl;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;

import cn.edu.hbtcm.pre.common.dao.impl.BaseDaoImpl;
import cn.edu.hbtcm.pre.dao.RelationDao;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;

public  class RelationDaoImpl extends BaseDaoImpl<Relation,ObjectId> 
 implements RelationDao{
	protected RelationDaoImpl(Datastore ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}
	  public void insertrelation(Relation relation){
	    	ds.save(relation);
	    }
	@Override
	public boolean existsrelation(String sourse, String target) {
		// TODO Auto-generated method stub
		Query<Relation> query = createQuery().field("rel.sourse").equal(sourse).field("rel.target").equal(target);
		return exists(query);
	}
	@Override
	public List<Rel> findRel() {
		// TODO Auto-generated method stub
		Query<Relation> query = createQuery();
		Relation relation=findOne(query);
		List<Rel> rel=relation.getRel();
		return rel;
		
	}
	@Override
	public List<Relation> findRelation() {
		// TODO Auto-generated method stub
		List<Rel> query =(List<Rel>) createQuery().field("rel");
	
		return find().asList();
	}

}
