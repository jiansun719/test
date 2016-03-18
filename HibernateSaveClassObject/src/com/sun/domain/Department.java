package com.sun.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private Integer id;
	private String name;
	
	private Set<Employee> employeeSet = new HashSet<Employee>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	@Override
	public String toString() {
		return "[" + this.id + "," + this.name + "]";
	}
	
	
}
