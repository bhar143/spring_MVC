package com.greatlearning.springDEMO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Department")
	private String department;
	@Column(name="Country")
	private String country;
	
	public Students() {
		
	}
	
	public Students(int id, String name, String department, String country) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.country = country;
	}
	
	
	public Students(String name, String department, String country) {
		super();
		this.name = name;
		this.department = department;
		this.country = country;
	}
	
	
	
	public int getId() {
		return id;
		
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}
	
	

}
