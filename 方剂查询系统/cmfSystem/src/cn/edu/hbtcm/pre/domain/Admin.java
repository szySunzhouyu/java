package cn.edu.hbtcm.pre.domain;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

//使用@Document注解指明一个领域对象将被持久化到MongoDB中
@Entity
public class Admin {
	@Id 
	private ObjectId oid;
	private String username;
	private String password;
	private String email;
	public Admin(ObjectId oid, String username, String password, String email) {
		super();
		this.oid = oid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ObjectId getOid() {
		return oid;
	}
	public void setOid(ObjectId oid) {
		this.oid = oid;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [oid=" + oid + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
