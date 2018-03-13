
package com.javapoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	private int id;

	@Column(name="name")
	private String name;
	
	private Address studentAddress;
	

	public Student() {
		
	}

	public Student(String name, Address studentAddress) {
		this.name = name;
		this.studentAddress = studentAddress;
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

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " address:" + studentAddress;
	}
}

