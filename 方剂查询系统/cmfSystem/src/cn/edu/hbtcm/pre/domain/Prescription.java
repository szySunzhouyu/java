package cn.edu.hbtcm.pre.domain;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

//ʹ��@Documentע��ָ��һ��������󽫱��־û���MongoDB��
@Entity
public class Prescription {
	@Id 
	private ObjectId oid;
	//������
	private String name;
	//�������
	@Embedded  
	private List<Pre> pre;  
	//����
	private String functions;
	//����
	private String majorfunction;
	//����֢״
	private String[] use;
	//ժҪ
	private String abstr;
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMajorfunction() {
		return majorfunction;
	}

	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public void setMajorfunction(String majorfunction) {
		this.majorfunction = majorfunction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	public List<Pre> getPre() {
		return pre;
	}
	public void setPre(List<Pre> pre) {
		this.pre = pre;
	}
	
	
	public String[] getUse() {
		return use;
	}

	public void setUse(String[] use) {
		this.use = use;
	}

	public String getAbstr() {
		return abstr;
	}
	public void setAbstr(String abstr) {
		this.abstr = abstr;
	}

	public ObjectId getOid() {
		return oid;
	}

	public void setOid(ObjectId oid) {
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Prescription [oid=" + oid + ", name=" + name + ", pre=" + pre + ", functions=" + functions
				+ ", majorfunction=" + majorfunction + ", use=" + Arrays.toString(use) + ", abstr=" + abstr + "]";
	}
	
}
