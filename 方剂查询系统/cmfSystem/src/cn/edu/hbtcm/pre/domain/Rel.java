package cn.edu.hbtcm.pre.domain;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Rel {

	private String source;
	private String target;
	
	public Rel(String source, String target) {
		super();
		this.source = source;
		this.target = target;
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
	public Rel() {
		super();
	}
	@Override
	public String toString() {
		return "Rel [source=" + source + ", target=" + target + "]";
	}
	
}
