package cn.edu.hbtcm.pre.domain;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class MatrixRelation {
	
	@Id 
	private ObjectId oid;
	private String source;
	private String target;
	private List<String> prename;
	
	
	
	public List<String> getPrename() {
		return prename;
	}
	public void setPrename(List<String> prename) {
		this.prename = prename;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	public MatrixRelation() {
		super();
	}
	public ObjectId getOid() {
		return oid;
	}
	public void setOid(ObjectId oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "MatrixRelation [oid=" + oid + ", source=" + source
				+ ", target=" + target + ", prename=" + prename + "]";
	}
	
	
}
