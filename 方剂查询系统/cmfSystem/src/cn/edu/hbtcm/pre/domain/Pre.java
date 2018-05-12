package cn.edu.hbtcm.pre.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Pre {

	private String dose;
	private String medname;
	public Pre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDose() {
		return dose;
	}
	public String getMedname() {
		return medname;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public void setMedname(String medname) {
		this.medname = medname;
	}
	@Override
	public String toString() {
		return "Pre [dose=" + dose + ", medname=" + medname + "]";
	}
	
}
