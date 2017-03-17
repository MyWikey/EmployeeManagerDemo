package cn.qdgr.employee.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer did;
	private String dname;
	private String ddesc;
	//员工集合属性
	private Set<Employee> emplyees = new HashSet<Employee>();
	
	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public Set<Employee> getEmplyees() {
		return emplyees;
	}

	public void setEmplyees(Set<Employee> emplyees) {
		this.emplyees = emplyees;
	}
	
	

}
