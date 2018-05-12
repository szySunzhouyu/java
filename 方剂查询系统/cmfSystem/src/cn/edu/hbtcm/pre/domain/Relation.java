package cn.edu.hbtcm.pre.domain;

import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Relation {

	 @Id 
	 private ObjectId oid;
	 @Embedded  
	 private List<Rel> rel;
	public ObjectId getOid() {
		return oid;
	}
	public void setOid(ObjectId oid) {
		this.oid = oid;
	}
	
	public Relation() {
		super();
	}
	public List<Rel> getRel() {
		return rel;
	}
	public void setRel(List<Rel> rel) {
		this.rel = rel;
	}
	@Override
	public String toString() {
		return "Relation [oid=" + oid + ", " + rel + "]";
	}
	
}
