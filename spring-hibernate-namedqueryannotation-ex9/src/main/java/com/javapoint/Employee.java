
package com.javapoint;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="employee")

@NamedQueries({  
  @NamedQuery(
	name = "findEmployeeById",query = "select * from Employee  where id = :id")
})

public class Employee {

	@Id
	private int id;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="salary")
	private int salary;

	private Set certificates;

	public Employee() {
		
	}

	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary =  salary;
	}
	
	
	public Set getCertificates() {
		return certificates;
	}

	public void setCertificates(Set certificates) {
		this.certificates = certificates;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " firstname:" + firstName + " lastname:" + lastName + " salary:" + salary
				+ "\n Certifcates:" + certificates;
	}
}

